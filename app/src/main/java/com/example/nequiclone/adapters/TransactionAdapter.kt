package com.example.nequiclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nequiclone.databinding.ItemTransactionBinding
import com.example.nequiclone.models.Transaction

class TransactionAdapter(private val items: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val b = holder.binding
        val ctx = holder.itemView.context

        b.tvTitle.text = item.title
        b.tvSubtitle.text = item.subtitle
        b.tvDate.text = item.date
        b.tvAmount.text = if (item.amount >= 0) "+${item.amount}" else item.amount.toString()
        b.tvAmount.setTextColor(
            if (item.type == "receive")
                ctx.getColor(R.color.success_green)
            else
                ctx.getColor(R.color.danger_red)
        )

        val icon = if (item.type == "receive") R.drawable.ic_arrow_receive else R.drawable.ic_arrow_send
        b.ivIcon.setImageResource(icon)
        b.ivIcon.setTint(ctx.getColor(R.color.nequi_green))
    }

    override fun getItemCount() = items.size
}
