package com.pusilkom.training.day2.helper;

import android.content.Context;

import com.pusilkom.training.day2.model.ListMenuItem;
import com.pusilkom.training.day2.service.PostService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by purwa on 6/14/17.
 */

public class RequestHelper {
    private Context context;
    private Retrofit retrofit;

    public RequestHelper(Context context, String baseUrl) {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public List<ListMenuItem> getAllMenu() throws IOException {
        PostService service = retrofit.create(PostService.class);
        Call<List<ListMenuItem>> call = service.listAllMenu("5940dc3c0f0000a802c62f3a");
        Response<List<ListMenuItem>> response = call.execute();
        return response.body();
    }
}
