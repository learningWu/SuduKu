package com.wzx.suduku.ui.game

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wzx.suduku.BaseActivity
import com.wzx.suduku.util.SuduHelperUtil

/**
 * Created by wuzixuan on 2021/5/26
 */
class GameActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView("游戏界面") {
            ChessBoard()
        }
    }
}

@Preview
@Composable
fun ChessBoard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val dataSource = remember {
            mutableStateOf(SuduHelperUtil.solveSudoku())
        }

        for (i in 0 until 9) {
            Row {
                for (j in 0 until 9) {
                    EditText(dataSource.value[i][j].toString())
                }
            }
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {
                // TODO(wzx) : 没更新，奇怪
                dataSource.value = SuduHelperUtil.solveSudoku(dataSource.value)
            }, modifier = Modifier
                .clip(shape = MaterialTheme.shapes.medium)
                .fillMaxWidth(0.75f)
                .wrapContentHeight()
                .background(MaterialTheme.colors.primary)
        ) {
            Text(
                text = "自动填充",
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        }
    }
}

@Composable
fun EditText(initialValue:String) {
    val state = remember {
        mutableStateOf(if (initialValue !in "1".."9") "" else initialValue)
    }
    BasicTextField(
        textStyle = TextStyle(Color.Black),
        value = state.value,
        onValueChange = { state.value = it },
        maxLines = 1,
        modifier = Modifier
            .size(35.dp)
            .border(1.dp, MaterialTheme.colors.primary)
    )
}