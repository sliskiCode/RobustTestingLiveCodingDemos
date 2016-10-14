package io.github.sliskicode.robusttestinglivecodingdemos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity(), MainActivityMVP.View {

    companion object { val TAG = "TAG" }

    private val presenter: MainActivityMVP.Presenter by lazy { MainActivityPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tag: String? = intent.extras.getString(TAG)

        presenter.present(savedInstanceState.isNotNull(), tag)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}
