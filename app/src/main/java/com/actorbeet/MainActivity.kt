package com.actorbeet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.actorbeet.repository.actor.ImdbActorSource
import com.actorbeet.txtbtn.TextButton
import com.actorbeet.ui.theme.ActorBeetTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActorBeetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   // Greeting("Android")

                    ImdbActorSource().buildRetrofit()


                    TextButton(param = "Activity btn", textVM = viewModel())
                }
            }
        }
    }
}

@Composable
fun ButtonHello(param: Int){
    Row {
       Button(onClick = { /*TODO*/ }) {
           Text(text = ""+param)

       }
        Text(text = "Some text")
    }
}

@Composable
fun Greeting(name: String) {
   // val bigText = BigTextProvider().getBigText()
    var showlist by remember {
        mutableStateOf(value = true)
    }

    val strChe = remember {
        mutableStateOf(value = "Che to")
    }

    val bigText by remember {
       mutableStateOf(BigTextProvider().getBigText())
    }

    Column() {
        Button(onClick =  {

            showlist = !showlist
            strChe.value = "Refresh" + Random.nextInt(10)

        }) {
            Text(text = "Hello $name!")
        }

        Text(text = bigText)

        Text(text = strChe.value)

        val arr = arrayListOf(1,2,3,4,5,6,7,8,9,10,11)

        if(showlist) {
            LazyColumn {
                items(arr) { item ->
                    ButtonHello(item)
                }
            }
        }

    }



}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ActorBeetTheme {
        Greeting("Android")
    }
}