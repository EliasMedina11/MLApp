package medina.elias.mlapp.models

data class Paging (var total: Int,
                   var offset: Int,
                   var limit: Int,
                   var primary_results: Int)
