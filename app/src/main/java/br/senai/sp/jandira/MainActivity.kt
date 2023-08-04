package br.senai.sp.jandira

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.compose.composable
import br.senai.sp.jandira.login.LoginScreen
import br.senai.sp.jandira.menu.MenuScreen
import br.senai.sp.jandira.pedidos.PedidoScreen
import br.senai.sp.jandira.perfil.PerfilScreen
import br.senai.sp.jandira.theme.AtividadeTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AtividadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

        val navController = rememberAnimatedNavController()
        AnimatedNavHost(
            navController = navController,
            startDestination = "login",
            enterTransition = {
                slideIntoContainer(towards = AnimatedContentScope.SlideDirection.End, animationSpec = tween(2000))
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Start,
                    tween(2000)
                )
            }


        ){
            composable(route =  "login"){ LoginScreen(navController)}
            composable(route =  "menu"){ MenuScreen(navController) }
            composable(route =  "pedidos"){ PedidoScreen(navController) }
            composable(route =  "perfil"){ PerfilScreen(navController) }
        }
                }
            }
        }
    }
}
