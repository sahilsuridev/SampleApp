package com.example.sampleapp.di.module

import android.app.Application
import androidx.room.Room
import com.example.sampleapp.data.database.AppDatabase
import com.example.sampleapp.data.network.ApiInterface
import com.example.sampleapp.utils.Utils
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    internal fun buildDataBase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "sample.db"
        ).build()
    }

//    @Provides
//    @Singleton
//    fun providesRepository(api: ApiInterface, db: AppDatabase): RowsRepository {
//        return RowsRepository(api, db)
//    }

//    @Provides
//    @Singleton
//    fun providesContext(application: Application): Context {
//        return application.applicationContext
//    }

    @Provides
    @Singleton
    fun provideUtils(application: Application): Utils = Utils(application)

    private val API_BASE_URL = "https://dl.dropboxusercontent.com"
    @Provides
    @Singleton
    internal fun providePostApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

