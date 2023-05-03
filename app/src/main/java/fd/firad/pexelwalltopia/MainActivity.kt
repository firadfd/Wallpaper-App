package fd.firad.pexelwalltopia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fd.firad.pexelwalltopia.adapter.MyAdapter
import fd.firad.pexelwalltopia.databinding.ActivityMainBinding
import fd.firad.pexelwalltopia.model.Photo
import fd.firad.pexelwalltopia.viewmodel.MyViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayList: ArrayList<Photo>
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        supportActionBar?.hide()
        arrayList = ArrayList()

        binding.rclId.layoutManager = GridLayoutManager(this, 2)
        binding.rclId.setHasFixedSize(true)


        viewModel.showTrendingImages()

        binding.search.setOnClickListener {
            val query = binding.searchImage.text.toString()

            if (query.equals("")) {
                Toast.makeText(this@MainActivity, "Enter Image That you want", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.searchImage(query)
            }

        }


        viewModel.arrayList.observe(this@MainActivity, Observer {
            binding.rclId.adapter = MyAdapter(it, this@MainActivity)
        })

    }

}