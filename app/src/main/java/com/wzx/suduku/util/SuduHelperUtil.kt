package com.wzx.suduku.util

import kotlin.random.Random

/**
 * Created by wuzixuan on 2021/7/14
 */
object SuduHelperUtil {

    fun solveSudoku(board: Array<CharArray>? = null): Array<CharArray> {
        var result = board
        if (board == null) {
            // 生成新sudu
            result = Array(9) { CharArray(9) { '.' } }
        }
        dfsSolve(result!!)
        if (board == null) {
            // 抽出元素，生成初始盘
            takeRandomValueFromBoard(result)
        }
        return result
    }

    private fun takeRandomValueFromBoard(board: Array<CharArray>){
        repeat(50) {
            val row = Random(System.currentTimeMillis()).nextInt(9)
            val column = Random(System.currentTimeMillis() + 1000).nextInt(9)
            board[row][column] = '.'
        }
    }

    val alreadyTryCharSet = HashSet<Char>()
    fun dfsSolve(board: Array<CharArray>): Boolean {
        // 将棋盘上不为 '.' 的部分进行替换数字。替换后校验棋盘合法性,合法继续替换下一个
        for (i in board.indices)
            for (j in board[i].indices) {
                if (board[i][j] == '.') {
                    // 使用 [1..9] 进行替换
                    for (c in '1'..'9') {
                        if (isValid(board, i, j, c)) {
                            // 判断棋盘合法，即可放入 c
                            board[i][j] = c
                            if (dfsSolve(board))
                                return true
                            // 放入 c 无法解决，回溯
                            board[i][j] = '.'
                        }
                    }
                    // 1..9 都不可以，返回 false
                    return false
                }
            }
        // 最后一个数字放入时，走这个 true 。完成整个递归
        return true
    }

    private fun isValid(board: Array<CharArray>, row: Int, column: Int, c: Char): Boolean {
        for (i in 0 until 9) {
            // 行里有相同数字
            if (board[row][i] == c) return false
            // 列里有相同数字
            if (board[i][column] == c) return false

            // 遍历同一个格子元素
            // 将 row,column 映射到 九宫格中
//        val blockIndex = 3 * (row / 3) + (column / 3)
            // block 号块的 行 从 3 * (row / 3) -> + i / 3 ( i = 0..2 时就是这个block第一行)
            // block 号块的 列 从 3 * (column / 3) -> + i % 3 ( 起始列是 3 * (column / 3))
            // =》 3 * (column / 3)：表示 0..2 的起始列为0；3..5 的起始列为 3
            // 类比 二维数组中 row * column + i 作为线性 poi
            val sameBlockElement = board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3]
            if (sameBlockElement == c) return false
        }
        return true
    }
}