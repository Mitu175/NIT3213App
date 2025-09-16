package com.example.nit3213app.di

import com.example.nit3213app.network.ApiService
import com.example.nit3213app.repository.LoginRepository
import com.example.nit3213app.repository.DashboardRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://nit3213api.onrender.com/"

    // ✅ Moshi instance
    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    // ✅ Retrofit instance
    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    // ✅ ApiService
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    // ✅ DashboardRepository
    @Provides
    @Singleton
    fun provideDashboardRepository(apiService: ApiService): DashboardRepository =
        DashboardRepository(apiService)


}
