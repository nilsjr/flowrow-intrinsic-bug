package de.nilsdruyen.flowrow.intrinsic

private val lorem = """
    Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor 
    invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et 
    accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren
""".trimIndent()

data class Data(val text: String, val items: List<String>)

val testData = Data(
    text = "Hello World",
    items = listOf(
        lorem.take(45),
        "Hello",
        "Lorem ipsum dolo",
        "Hello",
        "Hello",
        "Lorem ipsum dolo",
    ),
)

val testData02 = Data(
    text = "Hello World",
    items = listOf(
        lorem.take(45),
        "Hello",
        "Lorem ipsum dolo",
        "Hello",
    ),
)

val columTestData = Data(
    text = "Hello World",
    items = listOf(
        "Hello",
        "Lorem ipsum dolo",
        "Bla bla",
        "Hello",
        "Hello",
        "Lorem ipsum dolo",
    ),
)