package com.devrachit.aiwonderland.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devrachit.aiwonderland.R
import com.devrachit.aiwonderland.navigation.Screen
import com.devrachit.aiwonderland.presentation.common.components.ImageCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                    }
                },
                title = { Text(text = stringResource(id = R.string.app_name)) })
        },
        contentColor = MaterialTheme.colorScheme.primary,
        content = {
            LazyColumn(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp),
                verticalArrangement =Arrangement.spacedBy(6.dp),
                contentPadding = it
            ) {
                item {
                    ImageCard(
                        title = stringResource(id = R.string.barcode_detection_title),
                        description = stringResource(id = R.string.barcode_detection_description),
                        imageUrl = stringResource(id = R.string.barcode_detection_url),
                        onCardClick = { navController.navigate(Screen.BarcodeScanning.route) }
                    )
                }

                item {
                    ImageCard(
                        title = stringResource(id = R.string.face_mesh_detection_title),
                        description = stringResource(id = R.string.face_mesh_detection_description),
                        imageUrl = stringResource(id = R.string.face_mesh_detection_url),
                        onCardClick = { navController.navigate(Screen.FaceMeshDetection.route) }
                    )
                }

                item {
                    ImageCard(
                        title = stringResource(id = R.string.text_recognition_title),
                        description = stringResource(id = R.string.text_recognition_description),
                        imageUrl = stringResource(id = R.string.text_recognition_url),
                        onCardClick = { navController.navigate(Screen.TextRecognition.route) }
                    )
                }

                item {
                    ImageCard(
                        title = stringResource(id = R.string.image_labeling_detection_title),
                        description = stringResource(id = R.string.image_labeling_detection_description),
                        imageUrl = stringResource(id = R.string.image_labeling_detection_url),
                        onCardClick = { navController.navigate(Screen.ImageLabeling.route) }
                    )
                }

                item {
                    ImageCard(
                        title = stringResource(id = R.string.object_detection_title),
                        description = stringResource(id = R.string.object_detection_description),
                        imageUrl = stringResource(id = R.string.object_detection_url),
                        onCardClick = { navController.navigate(Screen.ObjectDetection.route) }
                    )
                }
            }
        }
    )
}