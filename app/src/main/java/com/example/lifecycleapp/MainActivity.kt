package com.example.lifecycleapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.example.lifecycleapp.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding
    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        lifecycle.addObserver(MyObserver())

        binding.btNavigate.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }
//        Log.v(TAG,"Verbose")
//        Log.d(TAG,"Debug")
//        Log.i(TAG,"Info")
//        Log.w(TAG,"Warning")
//        Log.e(TAG,"Error")
//        Log.wtf(TAG,"Assert")   // What a terrible failure

        Log.d(TAG,"onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")

    }


    class MyObserver : DefaultLifecycleObserver {
        val TAG: String = "Observer"
        override fun onCreate(owner: LifecycleOwner) {
            Log.d(TAG,"onCreate")
        }
        override fun onStart(owner: LifecycleOwner) {
            Log.d(TAG,"onStart")
        }
        override fun onResume(owner: LifecycleOwner) {
            Log.d(TAG,"onResume")
        }
        override fun onPause(owner: LifecycleOwner) {
            Log.d(TAG,"onPause")
        }
        override fun onStop(owner: LifecycleOwner) {
            Log.d(TAG,"onStop")
        }
        override fun onDestroy(owner: LifecycleOwner) {
            Log.d(TAG,"onDestroy")
        }
    }

    //deprecated
//    class MyObserver2 : LifecycleObserver {
//        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//        fun connectListener() {
//
//        }
//    }


    }
