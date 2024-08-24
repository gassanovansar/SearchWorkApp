package com.example.detail.ui.details

import com.example.core.base.BaseScreenModel
import com.example.detail.domain.VacancyUseCase
import com.example.favourite.domain.AddFavouritesUseCase
import com.example.favourite.domain.DeleteFavouritesUseCase
import org.koin.core.component.inject

class DetailScreenModel : BaseScreenModel<DetailState, Any>(DetailState.Default) {
    val vacancyUseCase: VacancyUseCase by inject()
    private val addFavouritesUseCase: AddFavouritesUseCase by inject()
    private val deleteFavouritesUseCase: DeleteFavouritesUseCase by inject()
    fun loadVacancy(id: String) {
        launchOperation(operation = {
            vacancyUseCase(VacancyUseCase.Params(id))
        }, success = {
            setState { state.value.copy(vacancy = it) }
        })
    }

    fun isFavourites() {
        launchOperation(operation = {
            if (state.value.vacancy.isFavorite) deleteFavouritesUseCase(
                DeleteFavouritesUseCase.Params(
                    state.value.vacancy.id
                )
            )
            else addFavouritesUseCase(AddFavouritesUseCase.Params(state.value.vacancy.id))
        }, success = {
            setState {
                state.value.copy(
                    vacancy = state.value.vacancy.copy(isFavorite = !state.value.vacancy.isFavorite)
                )
            }
        })
    }

}