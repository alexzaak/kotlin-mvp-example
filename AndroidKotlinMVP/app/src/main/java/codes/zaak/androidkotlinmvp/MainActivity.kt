package codes.zaak.androidkotlinmvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import codes.zaak.androidkotlinmvp.interfaces.MainPresenter
import codes.zaak.androidkotlinmvp.interfaces.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView, AdapterView.OnItemClickListener {

    private lateinit var mMainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.onItemClickListener = this
        mMainPresenter = MainPresenterImpl(this)
    }

    override fun onResume() {
        super.onResume()
        mMainPresenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.onDestroy()
    }

    override fun setItems(items: List<String>) {
        list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
        list.visibility = View.GONE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
        list.visibility = View.VISIBLE
    }

    override fun onItemClick(p0: AdapterView<*>?, view: View?, pos: Int, p3: Long) {
        mMainPresenter.onItemClicked(pos)
    }
}
