fun main() {

    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    if (a > b) print(a)
    if (b > a) print(b)
    if (a == 0 && b == 0) print(0)
    if (a == b && a != 0) print(b)
}
