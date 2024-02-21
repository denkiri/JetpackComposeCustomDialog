package com.example.jetpackcomposecustomdialog.components
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcomposecustomdialog.R
import com.example.jetpackcomposecustomdialog.ui.theme.Purple40
import com.example.jetpackcomposecustomdialog.ui.theme.Purple80
import com.example.jetpackcomposecustomdialog.ui.theme.PurpleGrey40

@Composable
fun CustomDialog(openDialog: MutableState<Boolean>) {

    Dialog(onDismissRequest = {
        openDialog.value = false
    }) {

        CustomDialogUI(openDialog = openDialog)
    }
}

@Composable
fun CustomDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp,5.dp,10.dp,10.dp),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Column(
            modifier
                .background(Color.White)) {

            Image(
                painter = painterResource(id = R.drawable.baseline_notifications_none_24),
                contentDescription = null, // decorative
                contentScale = ContentScale.Fit,
                colorFilter  = ColorFilter.tint(
                    color = Purple40
                ),
                modifier = Modifier
                    .padding(top = 35.dp)
                    .height(70.dp)
                    .fillMaxWidth(),

                )

            Column(modifier = Modifier.padding(16.dp)) {
                androidx.compose.material3.Text(
                    text = stringResource(id = R.string.get_updates),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                androidx.compose.material3.Text(
                    text = stringResource(id = R.string.alert_string),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(Purple80),
                horizontalArrangement = Arrangement.SpaceAround) {

                androidx.compose.material3.TextButton(onClick = {
                    openDialog.value = false
                }) {

                    androidx.compose.material3.Text(
                        stringResource(id = R.string.not_now),
                        fontWeight = FontWeight.Bold,
                        color = PurpleGrey40,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
                androidx.compose.material3.TextButton(onClick = {
                    openDialog.value = false
                }) {
                    androidx.compose.material3.Text(
                        stringResource(id = R.string.allow),
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview (name="Custom Dialog")
@Composable
fun MyDialogUIPreview(){
    CustomDialogUI(openDialog = mutableStateOf(false))
}