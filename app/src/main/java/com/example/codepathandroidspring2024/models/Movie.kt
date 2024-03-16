package com.example.codepathandroidspring2024.models

data class Movie(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)