package medina.elias.mlapp.models

object Model {
    data class Result (var id: String?,var siteId: String?, var title: String?, var seller: Seller?,var price: Float = 0.toFloat(),
                       var currencyId: String?, var availableQuantity: Int?, var soldQuantity: Int?, var buyingMode: String?,
                       var listingTypeId: String?, var stopTime: String?,var condition: String?,var permalink: String?,var thumbnail: String?,
                       var acceptsMercadopago: Boolean?, var installments: Installments?, var address: Addresss?, var shipping: Shipping?,
                       var sellerAddress: SellerAddress?,var attributes: List<Attribute>?,var originalPrice: Any? , var categoryId: String?,
                       var reviews: Reviews?)
    data class SearchInfo (val totalhits: Int)
}



