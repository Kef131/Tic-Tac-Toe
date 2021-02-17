import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    var counter = 0
    while (scanner.hasNext()) {
        val number = scanner.nextInt()
        if (number != 0) counter++ else break
    }
    print(counter)
}