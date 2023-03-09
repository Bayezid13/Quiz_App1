package com.example.quizapp_class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.quizapp_class.databinding.ActivityPlayBinding
import java.util.concurrent.TimeUnit

class PlayActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayBinding

    var quizList= listOf<Quiz>(
        Quiz("নিজের দেশের নাম? ","বাংলাদেশ","ইন্ডিয়া","চীন","বপাকিস্তান","বাংলাদেশ"),
        Quiz("আপনি পেশায় কি করেন?","ছাত্র","শিক্ষক","শ্রমিক","চাকরি","ছাত্র"),
        Quiz("নিজের ইউনিভার্সিটি  নাম?","ঢাকা বিশ্ববিদ্যালয়","রাজশাহী বিশ্ববিদ্যালয়","জগন্নাথ বিশ্ববিদ্যালয় ","রংপুর বিশ্ববিদ্যালয় ","াকা বিশ্ববিদ্যালয়"),
        Quiz("আপনার ডিপার্টমেন্ট  নাম?","কম্পিউটার ","আর্কিটেক্ট ","টেক্সটাইল ","ফুড","কম্পিউটার"),
        Quiz("ক্লাসে কতজন ছাত্র/ছাত্রী? ","৪০","৫০","৬০","৭০","৫০"),
        Quiz("নিজ পছন্দের বিষয়? ","বই পড়া","টিভি দেখা","খেলা করা","ট্রাভেলিং  করা","বই পড়া")


    )

    var updateQuestionNo=1
    var countDownTimer: CountDownTimer? =null
    var millisLeftSecound = 30000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.CountTv.text = "$updateQuestionNo/${quizList.size}"
        startCountdownTimer()

    }

   private fun startCountdownTimer(){
        countDownTimer = object : CountDownTimer(millisLeftSecound.toLong(),1000){
            override fun onTick(p0: Long) {
                millisLeftSecound = p0.toInt()
                val second= TimeUnit.MILLISECONDS.toSeconds(millisLeftSecound.toLong()).toInt()
                binding.TimerTv.text="Time Left : $second"

            }

            override fun onFinish() {


            }



        }.start()

    }
}