package examples.repository.infrastructure

class Helpers {


    class Validation<T>(var validations: MutableList<Pair<String, T.() -> Boolean>> = mutableListOf()) {

        companion object {
            operator fun <T> invoke(init: Validation<T>.() -> Unit): Validation<T> {
                val builder = Validation<T>()
                return builder.apply(init)
            }
        }

        infix fun rule(body: () -> String) = body

        infix fun (() -> String).verify(validate: T.() -> Boolean) {
            validations.add(this() to validate)
        }

    }

}

inline fun <T> T.validate(rules: Helpers.Validation<T>): List<String> {
    val result: List<String> = rules.validations
        .filter { it.second(this) }
        .map { it.first }

    if (result.isNotEmpty()) throw RuntimeException(result.toString())

    return result
}