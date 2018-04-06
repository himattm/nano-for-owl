package io.github.matthewcmckenna.owl.nano.remote.model.vods

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class TagsItem(

	@field:SerializedName("tag_value")
	val tagValue: String? = null,

	@field:SerializedName("tag_type")
	val tagType: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("tag_type_id")
	val tagTypeId: Int? = null
)