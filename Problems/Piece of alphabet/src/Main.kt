import kotlin.system.exitProcess

fun main() {
    val word = readLine()!!
    var isPieceAlphabet = true
    if (word.isEmpty() || word.length == 1) {
        print(true)
        exitProcess(0)
    }
    var first = word.first()
    for (ch in word) {
        if (first + 1 == ch + 1) {
            isPieceAlphabet = true
            first++
        } else {
            isPieceAlphabet = false
            break
        }
    }
    print(isPieceAlphabet)
}