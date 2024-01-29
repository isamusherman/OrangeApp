package com.example.orangeapp

import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orangeapp.ui.theme.OrangeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeAppTheme {
                MakeAndDrinkOJ()
            }
        }
    }
}

@Composable
fun MakeAndDrinkOJ() {
    var count = 0
    var juicer = (5..10).random()
    var clicks = 0
    var stage by remember { mutableStateOf(1) }
    var displayStage = when(stage)
    {
        1-> R.drawable.orange_tree
        2-> R.drawable.orange_fruit
        3-> R.drawable.orange_drink_full
        else-> R.drawable.orange_drink_empty
    }
    Button(onClick =
    {
        if(stage == 2)
        {
            clicks += 1
            if(clicks >= juicer)
            {
                stage += 1
            }
        }

        else
            stage+= 1
    })



    {
        Image(painter = painterResource(displayStage),
            contentDescription = "OJ Stage")
    }



    if(stage > 4)
    {
        stage = 1
        count += 1
    }
}

@Preview
@Composable
fun MakeAndDrinkOJPreview() {
    MakeAndDrinkOJ()
}