package io.github.matthewcmckenna.owl.nano.remote.model.vods

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class VideoAssetsItem(

	@field:SerializedName("unique_id")
	val uniqueId: String? = null,

	@field:SerializedName("source_host")
	val sourceHost: String? = null,

	@field:SerializedName("source_data")
	val sourceData: String? = null,

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("available")
	val available: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("source_url")
	val sourceUrl: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("asset_type")
	val assetType: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("source_id")
	val sourceId: String? = null,

	@field:SerializedName("source_path")
	val sourcePath: String? = null,

	@field:SerializedName("video_id")
	val videoId: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)