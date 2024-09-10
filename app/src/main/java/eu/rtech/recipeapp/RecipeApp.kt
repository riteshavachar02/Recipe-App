package eu.rtech.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun  RecipeApp(navController: NavHostController){
    val recipeviewModel: MainViewModel = viewModel()
    val viewstate by recipeviewModel.categoriesState

    NavHost(navController = navController, startDestination =Screen.RecipeScreen.route ) {
        composable(route = Screen.RecipeScreen.route){
            RecipeScreen(viewstate = viewstate, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("dog",it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route = Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("dog") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }
    }

}