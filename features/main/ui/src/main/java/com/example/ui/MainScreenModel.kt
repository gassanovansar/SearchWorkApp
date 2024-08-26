package com.example.ui

import com.example.core.base.BaseScreenModel
import com.example.favourite.domain.AddFavouritesUseCase
import com.example.favourite.domain.DeleteFavouritesUseCase
import com.example.main.domain.OffersUseCase
import com.example.main.domain.VacanciesUseCase
import com.example.models.domain.VacancyUI
import org.koin.core.component.inject

class MainScreenModel : BaseScreenModel<MainState, Any>(MainState.Default) {

    private val offersUseCase: OffersUseCase by inject()
    private val vacanciesUseCase: VacanciesUseCase by inject()
    private val addFavouritesUseCase: AddFavouritesUseCase by inject()
    private val deleteFavouritesUseCase: DeleteFavouritesUseCase by inject()
    fun loadOffers() {
        launchOperation(operation = {
            offersUseCase(OffersUseCase.Params())
        }, success = {
            setState { state.value.copy(offers = it) }
        })
    }

    fun loadVacancies() {
        launchOperation(operation = {
            vacanciesUseCase(VacanciesUseCase.Params())
        }, success = {
            setState { state.value.copy(vacancy = it) }
        })
    }

    fun isFavourites(item: VacancyUI) {
        launchOperation(operation = {
            if (item.isFavorite) deleteFavouritesUseCase(DeleteFavouritesUseCase.Params(item.id))
            else addFavouritesUseCase(AddFavouritesUseCase.Params(item.id))
        }, success = {
            setState {
                state.value.copy(vacancy = state.value.vacancy.map {
                    if (it.id == item.id) it.copy(isFavorite = !it.isFavorite) else it
                })
            }
        })
    }

}