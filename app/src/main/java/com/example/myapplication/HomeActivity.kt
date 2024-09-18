package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d(TAG, "onCreate")

        val chatList = listOf(
            ChatItem("Рик", R.drawable.profile1, "Привет! Как дела?", "10:30"),
            ChatItem("Морти", R.drawable.profile2, "До встречи завтра!", "09:15"),
            ChatItem("Саммер Смит", R.drawable.profile3, "Мда, ты странный", "08:45"),
            ChatItem("Джерри Смит", R.drawable.profile4, "Йоу", "07:50")
        )

        val rootLayout: LinearLayout = findViewById(R.id.chat_list_layout)

        chatList.forEach { chatItem ->
            val chatLayout = layoutInflater.inflate(R.layout.item_chat, rootLayout, false)

            val profileImage = chatLayout.findViewById<ImageView>(R.id.profile_image)
            val senderName = chatLayout.findViewById<TextView>(R.id.sender_name)
            val lastMessage = chatLayout.findViewById<TextView>(R.id.last_message)
            val messageTime = chatLayout.findViewById<TextView>(R.id.message_time)

            profileImage.setImageResource(chatItem.profileImage)
            senderName.text = chatItem.senderName
            lastMessage.text = chatItem.lastMessage
            messageTime.text = chatItem.time

            rootLayout.addView(chatLayout)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
