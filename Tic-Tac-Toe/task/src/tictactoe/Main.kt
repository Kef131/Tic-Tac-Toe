package tictactoe

import kotlin.math.abs
import kotlin.system.exitProcess
import java.util.Scanner

private val playerX = 'X'
private val playerO = 'O'
private var x = 0
private var y = 0
private var currentPlayer = playerX

fun setGame(inputGame: String): Array<CharArray> {
    val board = Array(3) { CharArray(3) { '_' } }
    var index = 0
    for (i in 0..2) {
        for (j in 0..2) {
            board[i][j] = inputGame[index]
            index++
        }
    }
    showGame(board)
    return board
}

fun showGame(board : Array<CharArray>) {
    val lineDashes = "---------"
    println(lineDashes)
    for (row in board) {
        println("| ${row.joinToString(" ")} |")
    }
    println(lineDashes)
}

fun endGame() {
    exitProcess(0)
}

fun allowedMovement(arrayField: Array<CharArray>) : Boolean {
    print("Enter the coordinates: ")
    val coordinates = readLine()!!
    val scanner = Scanner(coordinates)
    if (!scanner.hasNextInt()) {
        println("You should enter numbers!")
        scanner.next()
        return true
    } else {
        x = scanner.nextInt()
        y = scanner.nextInt()
        if (x !in 1..3 || y !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            return true
        } else {
            if (arrayField[x - 1][y - 1] != '_') {
                println("This cell is occupied! Choose another one!")
                return true
            }
        }
    }
    return false
}

fun checkWinner(arrayField: Array<CharArray>) {
    var blankSpaces = false
    var winnerPlayer = ' '
    var winnablePlayer = ' '
    for (i in 0..2) {
        for (j in 0..2) {
            //Check for spaces
            if (!(arrayField[i][j] == 'X' || arrayField[i][j] == 'O')) {
                blankSpaces = true
                continue
            }

            winnablePlayer = arrayField[i][j]
            //Check 3 possibles winnable vertical positions
            if (j < 1 && arrayField[i][j + 1] == winnablePlayer && arrayField[i][j + 2] == winnablePlayer) {
                winnerPlayer = currentPlayer
                break
                //Check 2 possibles winnable horizontal positions
            } else if (i < 1 && arrayField[i + 1][j] == winnablePlayer && arrayField[i + 2][j] == winnablePlayer) {
                winnerPlayer = currentPlayer
                break
                //Check 1 possible winnable diagonal positions. From top left
            } else if (j < 1 && i < 1 && arrayField[i + 1][j + 1] == winnablePlayer && arrayField[i + 2][j + 2] == winnablePlayer) {
                winnerPlayer = currentPlayer
                break
                //Check 1 possible winnable diagonal positions. From bottom left
            } else if (j == 2 && i == 0 && arrayField[i + 1][j - 1] == winnablePlayer && arrayField[i + 2][j - 2] == winnablePlayer) {
                winnerPlayer = currentPlayer
                break
            }
        }
    }
    if (!blankSpaces && winnerPlayer == ' '){
        println("Draw")
        endGame()
    }
    else if (winnerPlayer != ' '){
        print("$winnerPlayer wins")
        endGame()
    }
}

fun switchPlayer() {
    if (currentPlayer == playerX) currentPlayer = playerO else currentPlayer = playerX
}

fun main() {
    print("Enter cells: ")
    val arrayField = setGame("_________")

    repeat(9) {
        var repeat = true
        while (repeat) {
            repeat = allowedMovement(arrayField)
        }
        arrayField[x - 1][y - 1] = currentPlayer
        showGame(arrayField)
        if (it >= 4) {
            checkWinner(arrayField)
        }
        switchPlayer()
    }
}