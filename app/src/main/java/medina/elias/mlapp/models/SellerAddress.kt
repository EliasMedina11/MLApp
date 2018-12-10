package medina.elias.mlapp.models

data class SellerAddress(
        var id: String,
        var comment: String,
        var address_line: String,
        var zip_code: String,
        var country: Country,
        var state: State,
        var city: City,
        var latitude: String,
        var longitude: String
)