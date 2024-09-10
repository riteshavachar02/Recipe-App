package eu.rtech.recipeapp

import okhttp3.Route

sealed class Screen(val route: String){
    object RecipeScreen: Screen("recipeScreen")
    object DetailScreen: Screen("detailScreen")
}