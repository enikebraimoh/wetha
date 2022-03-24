package com.enike.wetha.framework.database.di

import android.content.Context
import androidx.room.Room
import com.enike.core.data.LocalDataSource
import com.enike.wetha.framework.database.CityDao
import com.enike.wetha.framework.database.Database
import com.enike.wetha.framework.database.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            Database.DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesCityDao(database: Database) = database.cityDao()

    @Provides
    @Singleton
    fun providesLocalDataSource(data: CityDao): LocalDataSource = LocalDataSourceImpl(data)

}