package fd.firad.pexelwalltopia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fd.firad.pexelwalltopia.model.Photo
import fd.firad.pexelwalltopia.repository.MyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {


    val arrayList: LiveData<ArrayList<Photo>>
        get() = repository.arrayList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getImage(1, 20)
        }

    }

    fun showTrendingImages() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getImage(1, 20)
        }
    }

    fun searchImage(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getSearchImage(query, 1, 80)
        }
    }
}