package com.actorbeet.txtbtn

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.actorbeet.Greeting
import com.actorbeet.ui.theme.ActorBeetTheme
import org.w3c.dom.Text

@Composable
fun TextButton(param: String, textVM: TextButtonVM){
    Button(onClick = { textVM.buttonClick()}) {
        Text(text = "someText $param ${textVM.secondText.value}" )

    }
}

@Preview(showBackground = true)
@Composable
fun TextButtonPreview() {
    ActorBeetTheme {
        TextButton("Preview Text", viewModel())
    }
}

@Preview(showBackground = true)
@Composable
fun TextButtonLongPreview() {
    ActorBeetTheme {
        TextButton("Preview Text Long Long", viewModel())
    }
}