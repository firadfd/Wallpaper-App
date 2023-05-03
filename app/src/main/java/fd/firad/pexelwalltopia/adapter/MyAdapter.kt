package fd.firad.pexelwalltopia.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fd.firad.pexelwalltopia.SetWallpaperActivity
import fd.firad.pexelwalltopia.databinding.SimpleImageBinding
import fd.firad.pexelwalltopia.model.Photo

class MyAdapter(
    private val arrayList: ArrayList<Photo>,
    private val context: Context
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(SimpleImageBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(arrayList.get(position).src.portrait).into(holder.binding.image)
        holder.binding.image.setOnClickListener {
            val intent = Intent(context, SetWallpaperActivity::class.java)
            intent.putExtra("url", arrayList.get(position).src.portrait.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class MyViewHolder(val binding: SimpleImageBinding) :
        RecyclerView.ViewHolder(binding.root)
}