package com.fcenesiz.handleerrors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fcenesiz.handleerrors.presentation.MainViewModel
import com.fcenesiz.handleerrors.ui.theme.HandleErrorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            HandleErrorsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(
                            value = viewModel.email,
                            onValueChange = viewModel::onEmailChanged,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = viewModel::submitEmail,
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text(text = "Submit")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        if (viewModel.error != null) {
                            Text(text = viewModel.error?.asString() ?: "")
                        }
                    }
                }
            }
        }
    }
}

