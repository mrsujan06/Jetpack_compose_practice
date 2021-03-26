package com.example.superheroes.model

data class SuperHero(
    val name: String,
    val image: Int,
    val superpower : String,
    val description: String,
    val date: String,
    val powerSecret: String,
    val weapon: String,
    val fact: String,
    val createdBy: String
)