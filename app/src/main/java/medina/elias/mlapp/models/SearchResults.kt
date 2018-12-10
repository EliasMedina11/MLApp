package medina.elias.mlapp.models

data class SearchResults(
        var site_id: String,
        var query: String,
        var paging: Paging,
        var results: List<Result>,
        var secondary_results: List<Any>,
        var related_results: List<Any>,
        var sort: Sort,
        var available_sorts: List<AvailableSort>,
        var filters: List<Filter>,
        var available_filters: List<AvailableFilter>
)