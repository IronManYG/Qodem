package com.example.qodem.di.module

import com.example.qodem.data.bloodbanks.local.BloodBankCacheMapper
import com.example.qodem.data.bloodbanks.local.BloodBankDao
import com.example.qodem.data.bloodbanks.remote.BloodBankNetworkMapper
import com.example.qodem.data.bloodbanks.remote.BloodBanksDataSource
import com.example.qodem.data.bloodbanks.repository.BloodBankRepository
import com.example.qodem.data.userinfo.local.DonationsCacheMapper
import com.example.qodem.data.userinfo.local.UserCacheMapper
import com.example.qodem.data.userinfo.local.UserDao
import com.example.qodem.data.userinfo.remote.DonationsNetworkMapper
import com.example.qodem.data.userinfo.remote.UserFirestore
import com.example.qodem.data.userinfo.remote.UserNetworkMapper
import com.example.qodem.data.userinfo.repository.UserInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBloodBankRepository(
        bloodBanksDao: BloodBankDao,
        retrofit: BloodBanksDataSource,
        bloodBankCacheMapper: BloodBankCacheMapper,
        bloodBankNetworkMapper: BloodBankNetworkMapper
    ): BloodBankRepository {
        return BloodBankRepository(
            bloodBanksDao,
            retrofit,
            bloodBankCacheMapper,
            bloodBankNetworkMapper
        )
    }

    @Singleton
    @Provides
    fun provideUserRepository(
        userDao: UserDao,
        userFirestore: UserFirestore,
        userCacheMapper: UserCacheMapper,
        userNetworkMapper: UserNetworkMapper,
        donationsCacheMapper: DonationsCacheMapper,
        donationsNetworkMapper: DonationsNetworkMapper
    ): UserInfoRepository {
        return UserInfoRepository(
            userDao,
            userFirestore,
            userCacheMapper,
            userNetworkMapper,
            donationsCacheMapper,
            donationsNetworkMapper
        )
    }
}