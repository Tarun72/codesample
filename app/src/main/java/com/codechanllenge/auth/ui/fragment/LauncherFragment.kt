package com.codechanllenge.auth.ui.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codechanllenge.R

class LauncherFragment : BaseAuthFragment() {
    lateinit var timer: CountDownTimer
    var isFinish = false;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launcher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenOnTime()
    }

    override fun subscribeObserver() {
    }

    /**
     * Launcher fragment should see for 2 Seconds
     * */
    private fun screenOnTime() {
        timer = object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("screenOnTime", "onTick: $Long")
            }

            override fun onFinish() {
                isFinish = true;
                navigateToLogin()
            }
        }
        timer.start()
    }

    fun navigateToLogin() {
        findNavController().navigate(R.id.action_launcherFragment_to_loginFragment)
    }

    override fun onStop() {
        super.onStop()
        if (!isFinish) {
            with(timer) { cancel() }
        }
    }
}