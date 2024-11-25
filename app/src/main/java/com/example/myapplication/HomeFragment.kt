package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val chatList = listOf(
            ChatItem("Рик", R.drawable.profile1, "Привет! Как дела?", "10:30"),
            ChatItem("Морти", R.drawable.profile2, "До встречи завтра!", "09:15"),
            ChatItem("Саммер Смит", R.drawable.profile3, "Мда, ты странный", "08:45"),
            ChatItem("Джерри Смит", R.drawable.profile4, "Йоу", "07:50")
        )

        chatList.forEach { chatItem ->
            val chatLayout = layoutInflater.inflate(R.layout.item_chat, binding.chatListLayout, false)

            val profileImage = chatLayout.findViewById<ImageView>(R.id.profile_image)
            val senderName = chatLayout.findViewById<TextView>(R.id.sender_name)
            val lastMessage = chatLayout.findViewById<TextView>(R.id.last_message)
            val messageTime = chatLayout.findViewById<TextView>(R.id.message_time)

            profileImage.setImageResource(chatItem.profileImage)
            senderName.text = chatItem.senderName
            lastMessage.text = chatItem.lastMessage
            messageTime.text = chatItem.time

            binding.chatListLayout.addView(chatLayout)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
