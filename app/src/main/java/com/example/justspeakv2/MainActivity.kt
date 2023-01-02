package com.example.justspeakv2

import android.graphics.Paint
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.justspeakv2.ui.theme.JustSpeakV2Theme
import com.example.justspeakv2.ui.theme.LightBlue
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustSpeakV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Splash_screen") {

        composable("Splash_screen") {
            SplashScreen(navController = navController)
        }

        composable("home_screen") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painterResource(R.drawable.hinter),
                        contentScale = ContentScale.FillBounds,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(R.string.app_name),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 104.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(140.dp))
                Text(
                    stringResource(R.string.learn_a_language_nat_your_nown_pace),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightBlue,
                    textAlign = TextAlign.Center
                )
                Text(
                    stringResource(R.string.speak_on_the_go),
                    color = LightBlue,
                    modifier = Modifier.padding(top = 5.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(200.dp))
                Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 6.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(red = 0, green = 173, blue = 242)
                )
                ) {
                    Text(
                        stringResource(R.string.get_started),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(5000)
    }
    navController.navigate("home_screen")
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(R.drawable.logoblue),
                contentDescription = "",
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
        }
}