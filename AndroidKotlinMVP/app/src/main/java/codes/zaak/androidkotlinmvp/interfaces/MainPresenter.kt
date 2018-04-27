package codes.zaak.androidkotlinmvp.interfaces

interface MainPresenter {

    fun onResume()

    fun onItemClicked(position: Int)

    fun onDestroy()
}