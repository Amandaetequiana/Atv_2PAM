package com.example.registerapp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registerapp.ui.theme.ErrorButtonColors
import com.example.registerapp.ui.theme.IntroductionJetPackTheme
import com.example.registerapp.ui.theme.RegisterAppTheme
import com.example.registerapp.ui.theme.WarningButtonColors
import com.example.registerapp.ui.theme.InfoButtonColors
import com.example.registerapp.ui.theme.DebugButtonColors
import java.lang.RuntimeException


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegisterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Register()
                }
            }
            IntroductionJetPackTheme {
                App()
            }
        }
    }
}

@Composable
fun Register() {
   var Nome by remember { mutableStateOf ("")}

    Column (
        Modifier
            .fillMaxWidth(),
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            Text(text = "ATIVIDADE DE PAM 2",
                fontSize = 20.sp
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )
        
        Row(
            Modifier
                .fillMaxWidth(),
                    Arrangement.Center
                ){
                    TextField(value = Nome, 
                        onValueChange = {novoValor -> Nome = novoValor},
                        label = { Text("Digite seu nome: ")},
                        )
                }
            Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun App() {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )  {
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ActionButton(
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(05f)
            ){
                Log.d(ContentValues.TAG, "nota B")
            }
            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.i(ContentValues.TAG, "nota MB")
            }
            ActionButton(
                text = "Warning",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.w(ContentValues.TAG, "nota R")
            }
            ActionButton(
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.w(ContentValues.TAG, " nota I")

            }
        }



    }
}


@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ){
        Text(text = text)
    }
}



@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview() {
    IntroductionJetPackTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview() {
    ActionButton(text = "Cadastrar") {

    }
}


