package com.github.vitor238.hiltdependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //filed injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

@AndroidEntryPoint
class MyFragment : Fragment() {
    @Inject
    lateinit var someOtherClass: SomeOtherClass

}

@ActivityScoped
class SomeClass
@Inject
constructor(
    private val someOtherClass: SomeOtherClass
) {
    fun doAThing(): String {
        return "Look, I did a thing!"
    }

    fun doSomeAnotherThing(): String {
        return someOtherClass.doSomeAnotherThing()
    }
}

class SomeOtherClass
@Inject
constructor() {
    fun doSomeAnotherThing(): String {
        return "Look, I did some other thing!"
    }
}