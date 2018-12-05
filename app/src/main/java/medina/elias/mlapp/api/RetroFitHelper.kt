package medina.elias.mlapp.api

import medina.elias.mlapp.models.Product
import medina.elias.mlapp.models.ProductDescription
import medina.elias.mlapp.models.SearchResult
import medina.elias.mlapp.utils.AppConstants
import retrofit2.Call
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroFitHelper {

    // Get search results based on a query
    @GET("sites/MLA/search")
    abstract fun getSearchResult(@Query("q") query: String): Call<SearchResult>

    // Get extra info item
    @GET("items/{id}")
    abstract fun getProductDetails(@Path("id") id: String): Call<Product>

    // Product description
    @GET("items/{id}/description")
    abstract fun getProductDescription(@Path("id") id: String): Call<ProductDescription>


    companion object Factory {
        fun create(): RetroFitHelper {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(AppConstants.BASE_URL)
                    .build()

            return retrofit.create(RetroFitHelper::class.java)
        }


    }
}