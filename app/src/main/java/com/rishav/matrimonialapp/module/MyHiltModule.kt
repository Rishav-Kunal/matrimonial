package com.rishav.matrimonialapp.module

import android.content.Context
import androidx.room.Room
import com.rishav.matrimonialapp.database.UserDatabase
import com.rishav.matrimonialapp.repository.RandomUserRepository
import com.rishav.matrimonialapp.repository.RandomUserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyHiltModule {
    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext applicationContext: Context): UserDatabase {
        return Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "users_table"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(userDatabase: UserDatabase) = userDatabase.userDao

    @Provides
    fun provideMovieRepository(randomUserRepositoryImpl: RandomUserRepositoryImpl) : RandomUserRepository = randomUserRepositoryImpl
}