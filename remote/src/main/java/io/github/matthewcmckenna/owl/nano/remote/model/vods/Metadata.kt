package io.github.matthewcmckenna.owl.nano.remote.model.vods

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

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