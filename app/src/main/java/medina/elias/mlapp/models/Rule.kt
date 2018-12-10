package medina.elias.mlapp.models

data class Rule(
        private var _default: Boolean? = null,
        var free_mode: String? = null,
        var free_shipping_flag: Boolean? = null,
        var value: Any? = null)