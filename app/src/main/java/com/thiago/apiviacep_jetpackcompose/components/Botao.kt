package com.thiago.apiviacep_jetpackcompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButtonDefaults.containerColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.thiago.apiviacep_jetpackcompose.ui.theme.Teal700
import com.thiago.apiviacep_jetpackcompose.ui.theme.White
import java.nio.file.WatchEvent

@Composable
fun Botao(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier
) {
    Button(
        onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Teal700

        ),
        modifier = modifier

    ) {
        Text(text = text, fontSize = 18.sp, color = White, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun BotaoPreview() {
    Botao(onClick = {}, "Buscar Cep", modifier = Modifier.fillMaxWidth())
}
