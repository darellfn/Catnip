package no.uio.ifi.in2000.darellfn.catnip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.darellfn.catnip.data.facts.FactsDataSource
import no.uio.ifi.in2000.darellfn.catnip.ui.facts.FactsScreen
import no.uio.ifi.in2000.darellfn.catnip.ui.home.HomeScreen
import no.uio.ifi.in2000.darellfn.catnip.ui.theme.CatnipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CatnipTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
   val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen") {
        composable("home_screen") {
            HomeScreen(viewModel = viewModel(), navController = navController)
        }
        composable("facts_screen") {
            FactsScreen(viewModel = viewModel(), navController = navController)
        }
    }
}