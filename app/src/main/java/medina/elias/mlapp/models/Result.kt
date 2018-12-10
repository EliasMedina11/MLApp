package medina.elias.mlapp.models

data class Result(

        var id: String,
        var site_id: String? = null,
        var title: String? = null,
        var seller: Seller? = null,
        var price: Float = 0.toFloat(),
        var currency_id: String? = null,
        var available_quantity: Int? = null,
        var sold_quantity: Int? = null,
        var buying_mode: String? = null,
        var listing_type_id: String? = null,
        var stop_time: String? = null,
        var condition: String? = null,
        var permalink: String? = null,
        var thumbnail: String? = null,
        var accepts_mercadopago: Boolean? = null,
        var installments: Installments? = null,
        var address: Address? = null,
        var shipping: Shipping? = null,
        var seller_address: SellerAddress? = null,
        var attributes: List<Attribute>? = null,
        var original_price: Any? = null,
        var category_id: String? = null,
        var official_store_id: Any? = null,
        var catalog_product_id: Any? = null,
        var reviews: Reviews? = null,
        var tags: List<String>? = null
)