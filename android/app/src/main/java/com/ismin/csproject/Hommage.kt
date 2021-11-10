package com.ismin.csproject

import java.io.Serializable

data class Hommage(    val commemore: String,
                       val precision_adresse: String,
                       val adresse_complete: String,
                       val xy: FloatArray) :Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hommage

        if (commemore != other.commemore) return false
        if (precision_adresse != other.precision_adresse) return false
        if (adresse_complete != other.adresse_complete) return false
        if (!xy.contentEquals(other.xy)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = commemore.hashCode()
        result = 31 * result + precision_adresse.hashCode()
        result = 31 * result + adresse_complete.hashCode()
        result = 31 * result + xy.contentHashCode()
        return result
    }

}