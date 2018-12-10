package medina.elias.mlapp.models

data class Seller(
        var id: Int? = null,
        var power_seller_status: String? = null,
        var car_dealer: Boolean? = null,
        var real_estate_agency: Boolean? = null,
        var tags: List<Any>? = null
)