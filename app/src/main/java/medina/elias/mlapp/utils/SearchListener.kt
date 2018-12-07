package medina.elias.mlapp.utils

import medina.elias.mlapp.models.Result
import java.text.ParsePosition

interface SearchListener {

    fun onClick ( siteId : String, position: Int)
}