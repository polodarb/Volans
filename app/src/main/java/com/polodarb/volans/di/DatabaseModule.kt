package com.polodarb.volans.di

import android.app.Application
import androidx.room.Room
import com.polodarb.volans.data.local.AviaDao
import com.polodarb.volans.data.local.AviaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application
    ): AviaDatabase {
        return AviaDatabase.getInstance(app)
    }

    @Provides
    @Singleton
    fun provideDao(
        aviaDatabase: AviaDatabase
    ): AviaDao {
        return aviaDatabase.aviaDao()
    }

}