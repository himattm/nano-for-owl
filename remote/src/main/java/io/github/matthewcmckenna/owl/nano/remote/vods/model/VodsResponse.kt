package io.github.matthewcmckenna.owl.nano.remote.vods.model

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class VodsResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("_metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("status")
	val status: String? = null
)
