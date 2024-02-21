package com.example.jetpackcomposecustomdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcomposecustomdialog.components.CustomDialog
import com.example.jetpackcomposecustomdialog.ui.theme.JetpackComposeCustomDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCustomDialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   DialogContent()
                }
            }
        }
    }
}

@Composable
fun DialogContent() {
    val openDialog = remember{ mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                openDialog.value = true
            },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "Custom Compose Dialog")
        }
    }

    if (openDialog.value) {
        CustomDialog(openDialog = openDialog)
    }
}