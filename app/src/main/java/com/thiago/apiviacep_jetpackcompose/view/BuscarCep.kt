package com.thiago.apiviacep_jetpackcompose.view


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thiago.apiviacep_jetpackcompose.components.Botao
import com.thiago.apiviacep_jetpackcompose.components.CaixaTexto
import com.thiago.apiviacep_jetpackcompose.listener.RespostaApi
import com.thiago.apiviacep_jetpackcompose.ui.theme.Teal700
import com.thiago.apiviacep_jetpackcompose.viewmodel.BuscarCepViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarCep(navController: NavController,viewModel : BuscarCepViewModel = hiltViewModel()) {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Buscador de Cep", fontSize = 18.sp, color = Color.White)


                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Teal700
                )

            )
        }
    ) {

        val context  = LocalContext.current

        var inputCep by remember{
               mutableStateOf("")
        }

        var inputLogradouro by remember{
            mutableStateOf("")
        }

        var inputBairro by remember{
            mutableStateOf("")
        }

        var inputCidade by remember{
            mutableStateOf("")
        }

        var inputEstado by remember{
            mutableStateOf("")
        }


        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            
            Row ( modifier = Modifier.fillMaxWidth()){
                
                CaixaTexto(
                    value = inputCep ,
                    onValueChange = {
                         inputCep = it
                    },
                    label = "Cep",
                    modifier = Modifier
                        .width(200.dp)
                        .padding(20.dp, 75.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
                Botao(
                    onClick = {
                              viewModel.respostaApi(inputCep,object  : RespostaApi{
                                  override fun onSucess(
                                      logradouro: String,
                                      bairro: String,
                                      cidade: String,
                                      estado: String
                                  ) {
                                   inputLogradouro = logradouro
                                      inputBairro = bairro
                                      inputCidade = cidade
                                      inputEstado = estado
                                  }

                                  override fun onFailure(erro: String) {
                                      Toast.makeText(context, erro, Toast.LENGTH_SHORT).show()
                                  }

                              })
                    },
                    text = "Buscar Cep",
                    modifier = Modifier
                        .padding(0.dp, 80.dp, 20.dp, 10.dp)
                        .height(56.dp)
                )

            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                CaixaTexto(
                    value = inputLogradouro,
                    onValueChange = {
                        inputLogradouro = it
                    },
                    label = "Logradouro",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )

                CaixaTexto(
                    value = inputBairro,
                    onValueChange = {
                        inputBairro = it
                    },
                    label = "Bairro",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )
                CaixaTexto(
                    value = inputCidade,
                    onValueChange = {
                        inputCidade = it
                    },
                    label = "Cidade",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )

                CaixaTexto(
                    value = inputEstado,
                    onValueChange = {
                        inputEstado = it
                    },
                    label = "Estado",
                    modifier = Modifier
                        .width(150.dp)
                        .padding(20.dp, 0.dp, 20.dp, 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )

                Botao(
                    onClick = {
                              if(inputCep.isEmpty() || inputLogradouro.isEmpty() || inputBairro.isEmpty() || inputCidade.isEmpty() || inputEstado.isEmpty() ){
                                  Toast.makeText(context, "Preencha todos os campo", Toast.LENGTH_SHORT).show()
                              }else {
                                  navController.navigate("detalhesEndereco/${inputLogradouro}/${inputBairro}/${inputCidade}/${inputEstado}")
                              }
                    },
                    text = "Avançar",
                    modifier = Modifier
                        .padding(20.dp)
                        .height(56.dp)
                )

            }

        }
        

    }
}

@Preview(showBackground = true)
@Composable
fun BuscarCepPreview(

) {

    BuscarCep(rememberNavController())
}