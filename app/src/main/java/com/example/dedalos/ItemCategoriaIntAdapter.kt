package com.example.dedalos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemCategoriaIntAdapter(
    private val dataList: List<ItemCategoriaInt>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ItemCategoriaIntAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val imagePhoto: ImageView = itemView.findViewById(R.id.image_photo)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val categoria = dataList[position]
                    when (categoria.nome) {
                        "Ler Qr Code" -> listener.onLerQrCodeClick()
                        "Entradas" -> listener.onEntradasClick()
                        "Pedidos" -> listener.onPedidosClick()
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categoria_int, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemCategoriaInt = dataList[position]
        holder.textName.text = itemCategoriaInt.nome
        holder.imagePhoto.setImageResource(itemCategoriaInt.imagem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnItemClickListener {
        fun onLerQrCodeClick()
        fun onEntradasClick()
        fun onPedidosClick()
    }

    data class ItemCategoriaInt(val nome: String, val imagem: Int)
}
