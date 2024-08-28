package com.example.corekt


inline fun <reified T : Any?, reified R : Any> apiCall(
    call: () -> T,
    mapResponse: (T) -> R,
): Either<Failure, R> {
    return try {
        Either.Right(mapResponse(call.invoke()))
    } catch (ex: Failure) {
        Either.Left(ex)
    }
}

inline fun <reified T : Any> apiCall(
    call: () -> T,
): Either<Failure, T> =
    try {
        Either.Right(call.invoke())
    } catch (ex: Failure) {
        Either.Left(ex)
    }


sealed class Either<out L, out R> {

    data class Left<out L>(val a: L) : Either<L, Nothing>()
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    inline fun fold(failure: (L) -> Unit = {}, success: (R) -> Any = {}): Any =
        when (this) {
            is Left -> failure(a)
            is Right -> success(b)
        }
}

sealed class Failure(override val message: String) : Throwable() {
    class UseCase(val e: Exception) : Failure(e.message.orEmpty())
}


inline fun <L, R> Either<L, R>.doOnSuccess(action: (R) -> Unit): Either<L, R> =
    when (this) {
        is Either.Left -> {
            Either.Left(a)
        }

        is Either.Right -> {
            action(b)
            Either.Right(b)
        }
    }

inline fun <L, R> Either<L, R>.doOnFailure(failure: (L) -> Unit): Either<L, R> =
    when (this) {
        is Either.Left -> {
            failure.invoke(a)
            Either.Left(a)
        }

        is Either.Right -> Either.Right(b)
    }







