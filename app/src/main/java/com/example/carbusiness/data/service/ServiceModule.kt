package com.example.carbusiness.data.service

import com.example.carbusiness.data.repository.CarsRepository
import com.example.carbusiness.data.repository.CarsRepositoryImpl
import com.example.carbusiness.di.ApplicationScope
import com.example.carbusiness.utils.ApiConstants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ServiceModule {

    @Provides
    @ApplicationScope
    fun provideInterceptor() = Interceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder()
            .header("Content-Type", "application/json")
            .method(original.method, original.body)
            .build()
        chain.proceed(request)
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @ApplicationScope
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
            .build()

    @Provides
    @ApplicationScope
    internal fun provideCarsService(retrofit: Retrofit) = retrofit.create(CarsService::class.java)

    @Provides
    @ApplicationScope
    internal fun provideAuthenticationService(retrofit: Retrofit) = retrofit.create(AuthenticationService::class.java)

    @Provides
    @ApplicationScope
    internal fun provideCarsRepository(service: CarsService): CarsRepository = CarsRepositoryImpl(service)
}