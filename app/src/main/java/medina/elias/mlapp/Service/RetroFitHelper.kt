package medina.elias.mlapp.Service

import io.reactivex.Observable
import medina.elias.mlapp.models.Product
import medina.elias.mlapp.models.ProductDescription
import medina.elias.mlapp.models.SearchResults
import medina.elias.mlapp.utils.AppConstants
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/** Interfaz que utiliza Retrofit para hacer llamados hacia la API y obtiene Observables**/

interface RetroFitHelper {

    // Get search results based on a query
    @GET("sites/MLA/search")
     fun getSearchResult(@Query("q") query: String): Observable<SearchResults>

    // Get extra info item
    @GET("items/{id}")
     fun getProductDetails(@Path("id") id: String): Observable<Product>

    // Product description
    @GET("items/{id}/description")
     fun getProductDescription(@Path("id") id: String): Observable<ProductDescription>

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