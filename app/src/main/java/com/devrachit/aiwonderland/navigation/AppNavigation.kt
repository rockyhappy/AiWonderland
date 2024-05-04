package com.devrachit.aiwonderland.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devrachit.aiwonderland.presentation.screens.BarcodeScanningScreen
import com.devrachit.aiwonderland.presentation.screens.FaceMeshDetectionScreen
import com.devrachit.aiwonderland.presentation.screens.HomeScreen
import com.devrachit.aiwonderland.presentation.screens.ImageLabelingScreen
import com.devrachit.aiwonderland.presentation.screens.ObjectDetectionScreen
import com.devrachit.aiwonderland.presentation.screens.TextRecognitionScreen
//import com.google.accompanist.navigation.animation.AnimatedNavHost
//import com.google.accompanist.navigation.animation.composable
//import com.google.accompanist.navigation.animation.rememberAnimatedNavController

internal sealed class Screen(val route: String) {
    object Home : Screen("home")
    object FaceMeshDetection : Screen("face_mesh_detection")
    object TextRecognition : Screen("text_recognition")
    object ObjectDetection : Screen("object_detection")
    object BarcodeScanning : Screen("barcode_scanning")
    object ImageLabeling : Screen("image_labeling")

}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.TextRecognition.route) {
            TextRecognitionScreen(navController)
        }
        composable(route = Screen.ObjectDetection.route) {
            ObjectDetectionScreen(navController)
        }
        composable(route = Screen.FaceMeshDetection.route) {
            FaceMeshDetectionScreen(navController)
        }
        composable(route = Screen.BarcodeScanning.route) {
            BarcodeScanningScreen(navController)
        }
        composable(route = Screen.ImageLabeling.route) {
            ImageLabelingScreen(navController)
        }
    }
}