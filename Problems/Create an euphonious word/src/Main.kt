fun main() {
    val word = readLine()!!
    val consonants = "bcdfghjklmnpqrstvwxz"
    val vowels = "aeiouy"
    val arrayAlpahabet = arrayOf(consonants, vowels)
    var consonantOrVowel = 0
    var counter = 0
    var index = 0
    while (index < word.lastIndex - 1) {
        if (word[index] in consonants) consonantOrVowel = 0 else consonantOrVowel = 1
        if (word[index + 1] in arrayAlpahabet[consonantOrVowel]) {
            if (word[index + 2] in arrayAlpahabet[consonantOrVowel]) {
                counter++
                index = index + 2
            } else index++
        } else index++
    }
    print(counter)
}
