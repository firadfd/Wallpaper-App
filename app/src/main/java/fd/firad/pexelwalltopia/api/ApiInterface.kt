package fd.firad.pexelwalltopia.api

import fd.firad.pexelwalltopia.model.MainResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    @Headers("Authorization: 563492ad6f91700001000001ebdaa10d9dee496a8081726a0ec69a08")
    suspend fun getSearchImages(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Response<MainResponse>


    @GET("curated")
    @Headers("Authorization: 563492ad6f91700001000001ebdaa10d9dee496a8081726a0ec69a08")
    suspend fun getTrendingImages(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Response<MainResponse>
}