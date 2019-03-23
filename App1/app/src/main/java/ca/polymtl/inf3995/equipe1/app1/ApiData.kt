package ca.polymtl.inf3995.equipe1.app1

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("word") val word: String,
    @SerializedName("score") val score: Int
) {
    class Deserializer : ResponseDeserializable<Array<Data>> {
        override fun deserialize(content: String): Array<Data>? = Gson().fromJson(content, Array<Data>::class.java)
    }

}