package io.github.sliskicode.robusttestinglivecodingdemos

class MainActivityPresenter(private val view: MainActivityMVP.View) : MainActivityMVP.Presenter {

    override fun present(isRecreated: Boolean, tag: String?) = tag.ifNotNull {
        if (isRecreated)
            view.showMessage("Recreation")
        else
            view.showMessage("First creation")
    }
}
