package com.example.jetpack_compose_hw2

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_hw2.R
import com.example.jetpack_compose_hw2.ui.theme.NavigationDemoTheme

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to the City Explorer App", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("cityList") },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Explore Cities")
        }
    }
}

@Composable
fun CityListScreen(navController: NavController) {
    val cities = listOf("Yerevan", "Washington", "Madrid", "London", "Paris")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "City List") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        LazyColumn {
            items(cities) { city ->
                CityItem(city = city, onClick = {
                    navController.navigate("cityDetail/$city")
                })
            }
        }
    }
}

@Composable
fun CityItem(city: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = 4.dp
    ) {
        Text(
            text = city,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun CityDetailScreen(city: String, navController: NavController) {
    val cityDescription = "A brief description of $city."
    val imageRes = when (city) {
        "Yerevan" -> R.drawable.yerevan
        "Washington" -> R.drawable.washington
        "Madrid" -> R.drawable.madrid
        "London" -> R.drawable.london
        "Paris" -> R.drawable.paris
        else -> R.drawable.ic_launcher_background
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = city,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = city, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = cityDescription, style = MaterialTheme.typography.body1)
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("cityList") {
            CityListScreen(navController)
        }
        composable("cityDetail/{city}") { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city") ?: ""
            CityDetailScreen(city, navController)
        }
    }
}

@Composable
fun NavigationDemoApp() {
    NavigationDemoTheme {
        AppNavigation()
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    NavigationDemoTheme {
        WelcomeScreen(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun CityListScreenPreview() {
    NavigationDemoTheme {
        CityListScreen(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun CityDetailScreenPreview() {
    NavigationDemoTheme {
        CityDetailScreen("Yerevan", rememberNavController())
    }
}