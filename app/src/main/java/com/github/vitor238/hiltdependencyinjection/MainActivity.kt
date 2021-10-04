package com.github.vitor238.hiltdependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

class SomeClass
@Inject
constructor(
    //private val someInterfaceImpl: SomeInterface,
    private val gson: Gson
) {
    fun doAThing(): String {
        //return "Look I got: ${someInterfaceImpl.getAThing()}"
        return "something"
    }
}

class SomeInterfaceImpl
@Inject
constructor() : SomeInterface {
    override fun getAThing(): String {
        return "A Thing"
    }

}

interface SomeInterface {
    fun getAThing(): String
}