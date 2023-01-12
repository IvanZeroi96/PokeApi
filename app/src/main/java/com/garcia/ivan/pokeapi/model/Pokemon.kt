import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon (
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("base_experience") val baseExperience : String,
    @Expose @SerializedName("height") val height: Int,
    @Expose @SerializedName("weight") val weight: Int,
    @Expose @SerializedName("sprites") val sprites: Sprites
)

data class Sprites (
    @Expose @SerializedName("front_default") val frontDefault: String?,
    @Expose @SerializedName("front_shiny") val frontShiny: String?,
    @Expose @SerializedName("other") val Other: Other
)

data class Other (
    @Expose @SerializedName("dream_world") val dreamWorld: DreamWorld,
    @Expose @SerializedName("home") val home: Home,
    @Expose @SerializedName("official-artwork") val oficialArtwork: OficialAtwork,
)

data class OficialAtwork (
    @Expose @SerializedName("front_default") val frontDefault: String,
    @Expose @SerializedName("front_shiny") val frontShiny: String,
)

data class Home (
    @Expose @SerializedName("front_default") val frontDefault: String,
)

data class DreamWorld (
    @Expose @SerializedName("front_default") val frontDefault: String,
)