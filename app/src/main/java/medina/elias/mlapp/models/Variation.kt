package medina.elias.mlapp.models

data class Variation(
        private var id: Long = 0,
        var price: Float = 0.toFloat(),
        var attribute_combinations: List<AttributeCombination>? = null,
        var available_quantity: Int? = null,
        var sold_quantity: Int? = null,
        var sale_terms: List<Any>? = null,
        var picture_ids: List<String>? = null,
        var seller_custom_field: Any? = null,
        var catalog_product_id: String? = null
)