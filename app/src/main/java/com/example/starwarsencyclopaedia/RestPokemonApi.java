package com.example.starwarsencyclopaedia;

import com.example.starwarsencyclopaedia.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestPokemonApi {

    @GET("pokemon")
    Call<RestPokemonResponse> getListPokemon();
}
