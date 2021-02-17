import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    var largestNumber = scanner.nextInt()
    var indexLargestNumber = 1
    var index = 1
    while (scanner.hasNext()) {
        index++
        val newNumber = scanner.nextInt()
        if (newNumber >= largestNumber) {
            if (newNumber != largestNumber) {
                largestNumber = newNumber
                indexLargestNumber = index
            }
        }

    }
    println("$largestNumber $indexLargestNumber")
}
