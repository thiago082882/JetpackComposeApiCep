package com.thiago.apiviacep_jetpackcompose.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thiago.apiviacep_jetpackcompose.ui.theme.Teal700

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaTexto(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier : Modifier,
    keyboardOptions : KeyboardOptions
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Teal700,
            cursorColor = Teal700,
            focusedLabelColor = Teal700
        ),
        modifier =  modifier,
        keyboardOptions = keyboardOptions,
        maxLines = 1
    )


}

//@Preview
//@Composable
//fun CaixaTextoPreview() {
//    CaixaTexto("", onValueChange = {},"cep")
//}