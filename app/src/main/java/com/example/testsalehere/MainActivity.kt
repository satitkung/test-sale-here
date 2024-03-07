package com.example.testsalehere

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testsalehere.databinding.ActivityMainBinding
import com.example.testsalehere.ui.achievement.AchievementFragment
import com.example.testsalehere.ui.blank.BlankFragment
import com.example.testsalehere.ui.home.HomeMainFragment
import com.google.android.material.badge.BadgeDrawable
import dagger.hilt.android.AndroidEntryPoint
import io.socket.client.IO
import io.socket.client.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeFragment by lazy { HomeMainFragment() }
    private val blankFragment by lazy { BlankFragment() }
    private val achievementFragment by lazy { AchievementFragment() }

    private lateinit var socket: Socket
    private lateinit var badgeDrawable: BadgeDrawable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCurrentFragment(homeFragment)

        initView()
    }

    private fun initView() {
        val menuItemId: Int = binding.bottomNavigationView.menu.getItem(3).itemId
        badgeDrawable = binding.bottomNavigationView.getOrCreateBadge(menuItemId)
        badgeDrawable.backgroundColor = ContextCompat.getColor(this, R.color.red)
        badgeDrawable.badgeTextColor = ContextCompat.getColor(this, R.color.white)
        badgeDrawable.isVisible = true
        badgeDrawable.number = 1
        badgeDrawable.badgeGravity = BadgeDrawable.TOP_END

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> setCurrentFragment(homeFragment)
                R.id.navigation_achievement -> setCurrentFragment(achievementFragment)
                else -> setCurrentFragment(blankFragment)
            }
            true
        }

        initSocket()
    }

    private fun initSocket() {
        socket = IO.socket("wss://px-socket-emitter.saleherethailand.com")
        socket.on(Socket.EVENT_CONNECT) {
            Log.d("tee", "socket : EVENT_CONNECT")
        }.on("new-notification") { args ->
            lifecycleScope.launch(Dispatchers.Main) {
                badgeDrawable.number = (args[0] as String).toInt()
            }
        }.on(Socket.EVENT_CONNECT_ERROR) {
            Log.d("tee", "socket : EVENT_CONNECT_ERROR")
        }

        socket.connect()
    }

    override fun onDestroy() {
        super.onDestroy()
        socket.disconnect()
    }

    private fun setCurrentFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager.beginTransaction()

        if (fragment.isAdded) {
            fragmentManager.show(fragment);
        } else {
            fragmentManager.add(R.id.layout_main, fragment, fragment.tag);
        }

        if (homeFragment.isAdded && fragment !is HomeMainFragment) {
            fragmentManager.hide(homeFragment)
        }

        if (blankFragment.isAdded && fragment !is BlankFragment) {
            fragmentManager.hide(blankFragment)
        }

        if (achievementFragment.isAdded && fragment !is AchievementFragment) {
            fragmentManager.hide(achievementFragment)
        }

        fragmentManager.commit()
    }

}