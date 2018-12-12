package medina.elias.mlapp.models

data class Shipping(
        private var free_shipping: Boolean? = null,
        var mode: String? = null,
        var tags: List<Any>? = null,
        var logistic_type: String? = null,
        var storePickUp: Boolean? = null
)