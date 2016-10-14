package io.github.sliskicode.robusttestinglivecodingdemos

interface MainActivityMVP {
    interface View {
        fun showMessage(message: String)
        fun showError()
    }

    interface Presenter {
        fun present(isRecreated: Boolean, tag: String?)
    }
}
