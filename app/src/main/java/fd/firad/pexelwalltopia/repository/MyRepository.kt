package fd.firad.pexelwalltopia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fd.firad.pexelwalltopia.api.ApiInterface
import fd.firad.pexelwalltopia.model.Photo
import javax.inject.Inject

class MyRepository @Inject constructor(private val apiInterface: ApiInterface) {

    private var _arrayList: MutableLiveData<ArrayList<Photo>> = MutableLiveData()

    val arrayList: LiveData<ArrayList<Photo>>
        get() = _arrayList

    suspend fun getSearchImage(query: String, page: Int, per_page: Int) {
        val result = apiInterface.getSearchImages(query, page, per_page)
        if (result?.body() != null) {
            _arrayList.postValue(result.body()!!.photos as ArrayList<Photo>?)
        }
    }

    suspend fun getImage(page: Int, per_page: Int) {
        val result = apiInterface.getTrendingImages(page, per_page)
        if (result?.body() != null) {
            _arrayList.postValue(result.body()!!.photos as ArrayList<Photo>?)
        }
    }
}