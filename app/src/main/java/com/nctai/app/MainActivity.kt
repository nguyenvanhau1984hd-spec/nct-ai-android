package com.nctai.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NctAiScreen() }
    }
}

@Composable
fun NctAiScreen() {
    var model by remember { mutableStateOf("OpenAI") }
    var prompt by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(listOf("NCT AI에 오신 것을 환영합니다.\n서버 연결 후 AI 대화를 사용할 수 있습니다.")) }
    MaterialTheme(colorScheme = darkColorScheme()) {
        Scaffold(containerColor = MaterialTheme.colorScheme.background) { padding ->
            Column(Modifier.fillMaxSize().padding(padding).padding(18.dp)) {
                Text("NCT AI", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
                Text("모두를 위한 AI 어시스턴트", color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(16.dp))
                var expanded by remember { mutableStateOf(false) }
                Box {
                    OutlinedButton(onClick = { expanded = true }) { Text("모델: $model  ▾") }
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        listOf("OpenAI", "Gemini", "Claude").forEach {
                            DropdownMenuItem(text = { Text(it) }, onClick = { model = it; expanded = false })
                        }
                    }
                }
                Spacer(Modifier.height(12.dp))
                LazyColumn(Modifier.weight(1f).fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(messages) { msg ->
                        Surface(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.surfaceVariant) {
                            Text(msg, Modifier.padding(14.dp))
                        }
                    }
                }
                OutlinedTextField(value = prompt, onValueChange = { prompt = it }, modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("메시지를 입력하세요") }, maxLines = 4)
                Spacer(Modifier.height(8.dp))
                Button(onClick = {
                    if (prompt.isNotBlank()) {
                        messages = messages + "나: $prompt" + "NCT AI: 아직 서버가 연결되지 않았습니다. 배포 후 실제 답변을 받을 수 있습니다."
                        prompt = ""
                    }
                }, modifier = Modifier.fillMaxWidth()) { Text("보내기") }
            }
        }
    }
}
