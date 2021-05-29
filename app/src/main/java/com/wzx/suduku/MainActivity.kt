package com.wzx.suduku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wzx.suduku.ext.startActivity
import com.wzx.suduku.ui.game.GameActivity
import com.wzx.suduku.ui.theme.SuduKuTheme

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView("数独") {
            MyApp()
        }
    }

    @Composable
    private fun MyApp() {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.mipmap.icon_sudu),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .padding(top = 100.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = {
                    startActivity<GameActivity>()
                }, modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.medium)
                    .fillMaxWidth(0.75f)
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.primary)
            ) {
                Text(
                    text = "新开一局",
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        SuduKuTheme {
            Container("数独") {
                MyApp()
            }
        }
    }
}

