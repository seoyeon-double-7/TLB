package com.example.tlb.data

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Users(
    var id : String ?= null,
    var name: String?= null,
    var number: String?= null,
    var ageType: String?= null
) : Serializable
