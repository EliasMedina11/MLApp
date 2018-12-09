package medina.elias.mlapp.Service;

import java.util.List;

import medina.elias.mlapp.models.Result;


public class ConnexionHandler {

    private static List<Result>  resultList;

  /*  public static List<Result> search (String query)  {
        RetroFitHelper service = ApiService.getRetrofitInstance().create(RetroFitHelper.class);
        Call<SearchResult> call = service.getSearchResult(query);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if (response.body().getResults().size() != 0) {
                    resultList = response.body().getResults();
                    Log.e("err",resultList.toString());
                } else {
                 //   resultContainer.setVisibility(View.GONE);
                 //   TextView noResultsMessage = findViewById(R.id.no_results_message);
                 //   noResultsMessage.setVisibility(View.VISIBLE);
                }
              //  progressBar.setVisibility(View.GONE);
            }
            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.d("Error", "Something went wrong...Error message: " + t.getMessage());
              //  progressBar.setVisibility(View.GONE);
            }
    });
        return resultList;
}

*/
}
