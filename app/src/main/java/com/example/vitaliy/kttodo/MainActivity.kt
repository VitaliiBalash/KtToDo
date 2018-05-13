package com.example.vitaliy.kttodo

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    enum class Fragments {
        INBOX, COMPLETED
    }

    private var currentFragment = Fragments.INBOX

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        loadFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val newFragment = when (item.itemId) {
            R.id.nav_inbox -> Fragments.INBOX
            R.id.nav_completed -> Fragments.COMPLETED
            else -> currentFragment
        }

        if (newFragment != currentFragment) {
            currentFragment = newFragment
            loadFragment()
        }

        Handler().postDelayed({ drawer_layout.closeDrawer(GravityCompat.START) }, 100)

        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun loadFragment() {
        val fragment: Fragment = when (currentFragment) {
            Fragments.INBOX -> InboxFragment()
            Fragments.COMPLETED -> CompletedFragment()
        }

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()

        updateTitle()
    }

    private fun updateTitle() {
        title = when (currentFragment) {
            Fragments.INBOX -> getString(R.string.title_inbox)
            Fragments.COMPLETED -> getString(R.string.title_completed)
        }
    }
}
