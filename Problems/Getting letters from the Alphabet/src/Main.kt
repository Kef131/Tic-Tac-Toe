fun main() {
    val char = readLine()!!.first()

    for (letter in 'a'..'z') {
        if (char == letter) break else print(letter)
    }
}