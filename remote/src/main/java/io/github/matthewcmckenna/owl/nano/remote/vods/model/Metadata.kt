package io.github.matthewcmckenna.owl.nano.remote.vods.model

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Metadata(

	@field:SerializedName("per_page")
	val perPage: String? = null,

	@field:SerializedName("total_count")
	val totalCount: Int? = null,

	@field:SerializedName("page")
	val page: String? = null,

	@field:SerializedName("page_count")
	val pageCount: Int? = null
)
