package com.wzx.suduku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import com.wzx.suduku.ui.theme.SuduKuTheme

/**
 * Created by wuzixuan on 2021/5/26
 */
open class BaseActivity : ComponentActivity() {
    fun setContentView(
        title: CharSequence,
        parent: CompositionContext? = null,
        content: @Composable () -> Unit
    ) {
        setContent(parent) {
            SuduKuTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Container(title = title) {
                        content()
                    }
                }
            }
        }
    }
}

@Composable
fun Container(title: CharSequence, content: @Composable () -> Unit) {
    Column {
        TopAppBar(
            title = {
                Text(text = title.toString(), maxLines = 2)
            }
        )
        content()
    }
}