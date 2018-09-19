package io.github.matthewcmckenna.owl.nano.remote.vods.model

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class DataItem(

		@field:SerializedName("favorites")
	val favorites: Any? = null,

		@field:SerializedName("publish_type")
	val publishType: String? = null,

		@field:SerializedName("video_assets")
	val videoAssets: List<VideoAssetsItem?>? = null,

		@field:SerializedName("available")
	val available: Int? = null,

		@field:SerializedName("description")
	val description: Any? = null,

		@field:SerializedName("privacy")
	val privacy: Any? = null,

		@field:SerializedName("created_at")
	val createdAt: String? = null,

		@field:SerializedName("stats_at")
	val statsAt: Any? = null,

		@field:SerializedName("title")
	val title: String? = null,

		@field:SerializedName("channel_slug")
	val channelSlug: Any? = null,

		@field:SerializedName("stream_name")
	val streamName: Any? = null,

		@field:SerializedName("updated_at")
	val updatedAt: String? = null,

		@field:SerializedName("embed")
	val embed: String? = null,

		@field:SerializedName("views")
	val views: Any? = null,

		@field:SerializedName("available_at")
	val availableAt: String? = null,

		@field:SerializedName("likes")
	val likes: Any? = null,

		@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

		@field:SerializedName("unique_id")
	val uniqueId: String? = null,

		@field:SerializedName("length")
	val length: Int? = null,

		@field:SerializedName("dislikes")
	val dislikes: Any? = null,

		@field:SerializedName("video_thumbnail_id")
	val videoThumbnailId: Int? = null,

		@field:SerializedName("video_type")
	val videoType: String? = null,

		@field:SerializedName("tags")
	val tags: List<TagsItem?>? = null,

		@field:SerializedName("recorded_at")
	val recordedAt: Any? = null,

		@field:SerializedName("user_id")
	val userId: Int? = null,

		@field:SerializedName("eve_slug")
	val eveSlug: Any? = null,

		@field:SerializedName("broadcasted_at")
	val broadcastedAt: Any? = null,

		@field:SerializedName("share_url")
	val shareUrl: String? = null,

		@field:SerializedName("organization_id")
	val organizationId: String? = null,

		@field:SerializedName("location")
	val location: Any? = null,

		@field:SerializedName("thumbnails")
	val thumbnails: List<ThumbnailsItem?>? = null,

		@field:SerializedName("channel_id")
	val channelId: Any? = null,

		@field:SerializedName("status")
	val status: String? = null
)
