package com.tails.highthon.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.tails.highthon.view.viewholder.BaseViewHolder
import java.util.*

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>(){
    val sections = ArrayList<MutableList<Any>>()

    fun sections(): MutableList<MutableList<Any>> {
        return sections
    }

    fun clearSections() {
        sections.clear()
    }

    fun <T> addSection(section: List<T>) {
        sections.add(ArrayList<Any>(section))
    }

    fun <T> addSections(sections: List<List<T>>) {
        for (section in sections) {
            addSection(section)
        }
    }

    fun <T> setSection(location: Int, section: List<T>) {
        sections[location] = ArrayList<Any>(section)
    }

    fun <T> insertSection(location: Int, section: List<T>) {
        sections.add(location, ArrayList<Any>(section))
    }

    fun <T> removeSection(location: Int) {
        sections.removeAt(location)
    }

    fun <T> sectionOrderChange(location: Int) {
        sections[location].reverse()
    }

    protected abstract fun layout(sectionRow: SectionRow): Int

    protected abstract fun viewHolder(@LayoutRes layout: Int, view: View): BaseViewHolder

    override fun onCreateViewHolder(viewGroup: ViewGroup, @LayoutRes layout: Int): BaseViewHolder {
        val view = inflateView(viewGroup, layout)
        return viewHolder(layout, view)
    }

    override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
        val data = objectFromPosition(position)

        try {
            viewHolder.bindData(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }

    protected inner class SectionRow {
        private var section: Int = 0
        private var row: Int = 0

        constructor() {
            section = 0
            row = 0
        }

        constructor(section: Int, row: Int) {
            this.section = section
            this.row = row
        }

        fun section(): Int {
            return section
        }

        fun row(): Int {
            return row
        }

        fun nextRow() {
            row++
        }

        fun nextSection() {
            section++
            row = 0
        }
    }

    private fun objectFromSectionRow(sectionRow: SectionRow): Any {
        return sections[sectionRow.section()][sectionRow.row()]
    }

    protected fun sectionCount(section: Int): Int {
        return if (section > sections().size - 1) {
            0
        } else sections()[section].size
    }

    private fun objectFromPosition(position: Int): Any {
        return objectFromSectionRow(sectionRowFromPosition(position))
    }

    private fun sectionRowFromPosition(position: Int): SectionRow {
        val sectionRow = SectionRow()
        var cursor = 0
        for (section in sections) {
            for (item in section) {
                if (cursor == position) {
                    return sectionRow
                }
                cursor++
                sectionRow.nextRow()
            }
            sectionRow.nextSection()
        }

        throw RuntimeException("Position $position not found in sections")
    }

    override fun getItemCount(): Int {
        var itemCount = 0
        for (section in sections) {
            itemCount += section.size
        }

        return itemCount
    }

/*    private val section_itemDetail = 0

    init {
        addSection(ArrayList<ItemDetail>())
    }

    fun addItemDetail(itemDetail: ItemDetail) {
        sections[section_itemDetail].add(itemDetail)
        notifyItemChanged(sections[section_itemDetail].size)
    }

    override fun layout(sectionRow: BaseAdapter.SectionRow): Int {
        return R.layout.item_detail_info
    }

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        return DetailViewHolder(view)
    }*/
}