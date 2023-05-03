package fd.firad.pexelwalltopia.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fd.firad.pexelwalltopia.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Singleton
    @Provides
    fun provideRetrofit(): ApiInterface = Retrofit.Builder()
        .baseUrl("https://api.pexels.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ApiInterface::class.java)

}