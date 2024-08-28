package com.example.favourite.ui

import com.example.core.base.BaseScreenModel
import com.example.favourite.domain.AddFavouritesUseCase
import com.example.favourite.domain.DeleteFavouritesUseCase
import com.example.favourite.domain.FavouritesUseCase
import com.example.models.domain.VacancyUI
import org.koin.core.component.inject

class FavouriteScreenModel : BaseScreenModel<FavouriteState, Any>(FavouriteState.Default) {

    private val favouritesUseCase: FavouritesUseCase by inject()
    private val addFavouritesUseCase: AddFavouritesUseCase by inject()
    private val deleteFavouritesUseCase: DeleteFavouritesUseCase by inject()

    fun loadFavourites() {
        launchOperation(operation = { scope ->
            favouritesUseCase(scope, FavouritesUseCase.Params())
        }, success = {
            setState { state.value.copy(favourites = it) }
        })
    }

    fun isFavourites(item: VacancyUI) {
        launchOperation(operation = { scope ->
            if (item.isFavorite) deleteFavouritesUseCase(
                scope,
                DeleteFavouritesUseCase.Params(item.id)
            )
            else addFavouritesUseCase(scope, AddFavouritesUseCase.Params(item.id))
        }, success = {
            setState {
                state.value.copy(favourites = state.value.favourites.map {
                    if (it.id == item.id) it.copy(isFavorite = !it.isFavorite) else it
                })
            }
        })
    }

}