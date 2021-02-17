fun main() {
    val word = readLine()!!
    var isPalindrome = false
    for (i in 0..word.length / 2) {
        if (word[i] != word[word.lastIndex - i]) {
            isPalindrome = false
            break
        } else {
            isPalindrome = true
        }
    }
    if (isPalindrome) print("yes") else print("no")
}