fun main() {
    val firstAnswer = readLine().toBoolean()
    val secondAnswer = readLine().toBoolean()
    val confession = readLine().toBoolean()
    if (confession) {
        print(false)
    } else if (firstAnswer.xor(secondAnswer)) {
        print(false)
    } else {
        print(true)
    }
}