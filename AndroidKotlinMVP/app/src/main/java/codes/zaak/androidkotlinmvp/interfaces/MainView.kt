package codes.zaak.androidkotlinmvp.interfaces

interface MainView {

    fun setItems(items: List<String>)

    fun showMessage(message: String)

    fun showProgress()

    fun hideProgress()
}