package com.wzx.suduku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    // Scaffold 留出内容区域
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = title.toString(), maxLines = 2)
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            }
        )
    }) { innerPadding ->
        BodyContent(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }

}

@Composable
fun BodyContent(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier.padding(8.dp)) {
        content()
    }
}