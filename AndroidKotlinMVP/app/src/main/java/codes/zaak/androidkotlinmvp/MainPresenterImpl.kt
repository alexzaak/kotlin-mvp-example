package codes.zaak.androidkotlinmvp

import codes.zaak.androidkotlinmvp.interfaces.MainPresenter
import codes.zaak.androidkotlinmvp.interfaces.MainView

class MainPresenterImpl(private var mMainView: MainView?) : MainPresenter {

    private var mMoviesList = listOf("Iron Man (2008)",
            "The Incredible Hulk (2008)",
            "Iron Man 2 (2010)",
            "Thor (2011)",
            "Captain America: The First Avenger (2011)",
            "Marvel's The Avengers (2012)",
            "Iron Man 3 (2013)",
            "Thor: The Dark World (2013)",
            "Captain America: The Winter Soldier (2014)",
            "Guardians of the Galaxy (2014)",
            "Avengers: Age of Ultron (2015)",
            "Ant-Man (2015)",
            "Captain America: Civil War (2016)",
            "Doctor Strange (2016)",
            "Guardians of the Galaxy Vol. 2 (2017)",
            "Spider-Man: Homecoming (2017)",
            "Thor: Ragnarok (2017)",
            "Black Panther (2018)",
            "Avengers: Infinity War (2018)")

    override fun onResume() {
        mMainView?.setItems(mMoviesList)
    }

    override fun onItemClicked(position: Int) {
        mMainView?.showMessage(String.format("%d %s", (position + 1), mMoviesList[position]))
    }

    override fun onDestroy() {
        mMainView = null
    }

}