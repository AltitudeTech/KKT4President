package com.example.nandom.kkt4president.apollographql;

import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.CustomTypeAdapter;

import javax.annotation.Nonnull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import type.CustomType;

/**
 * Created by Nandom on 3/23/2018.
 */

public class MyApolloClient {

    private static final String BASE_URL = "https://ktt-backend.herokuapp.com/graphql";
    private static ApolloClient myApolloClient;


    public static  ApolloClient getMyApolloClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        CustomTypeAdapter<String> customTypeAdapter = new CustomTypeAdapter<String>() {
            @Override
            public String decode(@Nonnull String value) {
                return value;
            }

            @Nonnull
            @Override
            public String encode(@Nonnull String value) {
                return value;
            }
        };

        myApolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .addCustomTypeAdapter(CustomType.MONGOID, customTypeAdapter)
                .build();

        return myApolloClient;

    }
}
