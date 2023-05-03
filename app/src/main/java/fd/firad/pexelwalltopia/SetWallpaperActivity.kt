package fd.firad.pexelwalltopia

import android.app.WallpaperManager
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import fd.firad.pexelwalltopia.databinding.ActivitySetWallpaperBinding
import java.io.IOException


class SetWallpaperActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetWallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(
            this@SetWallpaperActivity,
            R.layout.activity_set_wallpaper
        )
        val url = intent.getStringExtra("url")

        Glide.with(this@SetWallpaperActivity).load(url).into(binding.finalImage)

        binding.setWall.setOnClickListener {
            val wallpaperManager = WallpaperManager.getInstance(this@SetWallpaperActivity)
            try {
                val bitmap = (binding.finalImage.drawable as BitmapDrawable).bitmap
                wallpaperManager.setBitmap(bitmap)
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


    }
}