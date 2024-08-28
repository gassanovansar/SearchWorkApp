package com.example.search.ui

import cafe.adriel.voyager.core.model.screenModelScope
import com.example.core.base.BaseScreenModel
import com.example.core.ext.debounce
import com.example.favourite.domain.AddFavouritesUseCase
import com.example.favourite.domain.DeleteFavouritesUseCase
import com.example.main.domain.VacanciesUseCase
import com.example.models.domain.VacancyUI
import org.koin.core.component.inject

class SearchScreenModel : BaseScreenModel<SearchState, Any>(SearchState.Default) {

    private val vacanciesUseCase: VacanciesUseCase by inject()
    private val addFavouritesUseCase: AddFavouritesUseCase by inject()
    private val deleteFavouritesUseCase: DeleteFavouritesUseCase by inject()
    fun loadVacancies(search: String = "") {
        launchOperation(operation = { scope ->
            vacanciesUseCase(scope, VacanciesUseCase.Params(search))
        }, success = { setState { state.value.copy(vacancy = it) } }
        )
    }

    fun changeSearch(value: String) {
        setState { state.value.copy(search = value) }
        debounceSearch(value)

    }

    private val debounceSearch = debounce<String?>(screenModelScope) {
        loadVacancies(it.orEmpty())
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
                state.value.copy(vacancy = state.value.vacancy.map {
                    if (it.id == item.id) it.copy(isFavorite = !it.isFavorite) else it
                })
            }
        })
    }

}