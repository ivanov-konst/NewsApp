package com.example.newsapp.Base

inline fun <reified T> attempt (func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable){
    Either.Left(e)
}