package com.example.dedalos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dedalos.R

class ItemCategoriaAdapter(
    private val dataList: List<ItemCategoria>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ItemCategoriaAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val imagePhoto: ImageView = itemView.findViewById(R.id.image_photo)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val categoria = dataList[position]
                    when (categoria.nome) {
                        "Entradas" -> listener.onEntradasClick()
                        "Bebidas" -> listener.onBebidasClick()
                        "Aperitivos" -> listener.onAperitivosClick()
                        "Recarregar Cartão" -> listener.onRecarregarCartaoClick()
                        // Adicione outros casos conforme necessário
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categoria, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemCategoria = dataList[position]
        holder.textName.text = itemCategoria.nome
        holder.imagePhoto.setImageResource(itemCategoria.imagem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnItemClickListener {
        fun onEntradasClick()
        fun onBebidasClick()
        fun onAperitivosClick()
        fun onRecarregarCartaoClick()
        // Adicione outros métodos conforme necessário para os outros itens
    }

    data class ItemCategoria(val nome: String, val imagem: Int)
}
