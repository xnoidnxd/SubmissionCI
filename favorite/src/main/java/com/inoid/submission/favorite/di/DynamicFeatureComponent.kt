package com.inoid.submission.favorite.di

import com.inoid.submission.core.di.CoreComponent
import com.inoid.submission.favorite.movie.FavoriteMovieFragment
import com.inoid.submission.favorite.tvshow.FavoriteTvShowFragment
import dagger.Component

@FeatureScope
@Component(dependencies = [CoreComponent::class]
    , modules = [
        FeatureModule::class,
        ViewModelModule::class
    ]
)
interface DynamicFeatureComponent {

    @Component.Factory
    interface Factory{
        fun create(coreComponent: CoreComponent): DynamicFeatureComponent
    }



    fun inject(fragment: FavoriteMovieFragment)
    fun inject(fragment: FavoriteTvShowFragment)
}