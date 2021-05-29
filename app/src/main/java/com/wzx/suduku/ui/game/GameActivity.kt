package com.wzx.suduku.ui.game

import android.os.Bundle
import android.widget.EditText
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.isFocused
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wzx.suduku.BaseActivity
import com.wzx.suduku.ui.theme.SuduKuTheme

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
        repeat(9) {
            Row {
                repeat(9) {
                    EditText()
                }
            }
        }
    }
}

@Composable
fun EditText() {
    val state = remember {
        mutableStateOf("")
    }
    BasicTextField(
        textStyle = TextStyle(Color.Black),
        value = state.value,
        onValueChange = { state.value = it },
        maxLines = 1,
        modifier = Modifier
            .size(40.dp)
            .border(1.dp, MaterialTheme.colors.primary)
    )
}