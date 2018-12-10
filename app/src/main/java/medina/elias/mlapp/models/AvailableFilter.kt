package medina.elias.mlapp.models

data class AvailableFilter(var id: String,
                           var name: String,
                           var type: String,
                           var values: List<Values>)
