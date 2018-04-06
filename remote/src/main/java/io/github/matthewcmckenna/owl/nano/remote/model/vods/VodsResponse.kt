package io.github.matthewcmckenna.owl.nano.remote.model.vods

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

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