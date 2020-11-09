package com.inoid.submission

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inoid.submission.ui.body.airing.BaseAiringFragmentDirections
import com.inoid.submission.ui.body.popular.BasePopularFragmentDirections
import com.inoid.submission.ui.body.search.BaseSearchFragmentDirections
import com.inoid.submission.ui.utils.isInvisible
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(tool_bar)
        setupViews()
    }

    private fun setupViews() {
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        // Finding the Navigation Controller
        val navController = findNavController(R.id.fragNavHost)
        // Setting Navigation Controller with the BottomNavigationView
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_favorite -> {
                supportActionBar?.hide()
                bottom_navigation.isInvisible()

                when (bottom_navigation.selectedItemId) {
                    R.id.bottom_airing -> {
                        val toFavoriteActivity = BaseAiringFragmentDirections.actionBottomAiringToFavoriteNavigation()
                        this.findNavController(R.id.fragNavHost).navigate(toFavoriteActivity)
                    }
                    R.id.bottom_popular -> {
                        val toFavoriteActivity2 = BasePopularFragmentDirections.actionBottomPopularToFavoriteNavigation()
                        this.findNavController(R.id.fragNavHost).navigate(toFavoriteActivity2)
                    }
                    R.id.bottom_search -> {
                        val toFavoriteActivity3 = BaseSearchFragmentDirections.actionBottomSearchToFavoriteNavigation()
                        this.findNavController(R.id.fragNavHost).navigate(toFavoriteActivity3)
                    }
                }
                return true
            }
            else -> return true
        }
    }

    override fun onBackPressed() {
        if (bottom_navigation.isVisible){
            showExitAlert()
        }  else {
            super.onBackPressed()
        }
    }

    private fun showExitAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(resources.getString(R.string.alert_message_close_app))
            .setCancelable(true)
            .setPositiveButton(
                resources.getString(R.string.alert_option_yes)) {
                    _, _ -> this@HomeActivity.finish() }
            .setNegativeButton(
                resources.getString(R.string.alert_option_no)) {
                    dialogInterface, _ -> dialogInterface?.cancel() }
        val alertDialog = builder.create()
        alertDialog.show()
    }


}