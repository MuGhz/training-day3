package com.pusilkom.training.day2.service;

import com.pusilkom.training.day2.model.ListMenuItem;
import com.pusilkom.training.day2.model.Post;
import com.pusilkom.training.day2.model.Repo;
import com.pusilkom.training.day2.model.UserEmail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by purwa on 6/14/17.
 */

public interface PostService {

    @GET("/posts")
    Call<List<Post>> listAll();

    @GET("/v2/{param}")
    Call<List<ListMenuItem>> listAllMenu(@Path("param") String param);

    @GET("/users/{username}/repos")
    Call<List<Repo>> listAllRepository(@Path("username") String username);

    @GET("/user/emails")
    Call<List<UserEmail>> listAllEmail(@Header("Authorization") String token);
}
