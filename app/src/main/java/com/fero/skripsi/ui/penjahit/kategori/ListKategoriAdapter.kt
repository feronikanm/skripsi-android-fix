package com.fero.skripsi.ui.penjahit.kategori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fero.skripsi.databinding.ItemListKategoriBinding
import com.fero.skripsi.model.ListDetailKategori
import com.fero.skripsi.utils.Constant

class ListKategoriAdapter : RecyclerView.Adapter<ListKategoriAdapter.ListKategoriViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    var listDetailKategori = mutableListOf<ListDetailKategori>()

    fun setOnDeleteBtnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setOnEditBtnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setDetailKategori(kategoriList: List<ListDetailKategori>){
        this.listDetailKategori.clear()
        this.listDetailKategori.addAll(kategoriList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKategoriViewHolder {
        val itemListKategoriBinding = ItemListKategoriBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListKategoriViewHolder(itemListKategoriBinding)
    }

    override fun onBindViewHolder(holder: ListKategoriViewHolder, position: Int) {
        val data = listDetailKategori[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listDetailKategori.size
    }

    inner class ListKategoriViewHolder(private var binding: ItemListKategoriBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ListDetailKategori){
            binding.apply {

                tvKategori.text = data.nama_kategori

                btnDelete.setOnClickListener {
                    onItemClickCallback.onItemClicked(listDetailKategori[adapterPosition])
//                    popupDelete(root.context)
//                    deleteData(root.context, data)
                }

                btnEdit.setOnClickListener {
                    onItemClickCallback.onItemClicked(listDetailKategori[adapterPosition])
                }

                Glide.with(root.context)
                    .load("${Constant.IMAGE_KATEGORI}${data.gambar_kategori}")
                    .into(imgKategori)

                root.setOnClickListener {

                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ListDetailKategori)
    }


}