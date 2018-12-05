package medina.elias.mlapp.landing

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import com.eliasmedina.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_landing.*
import medina.elias.mlapp.R
import medina.elias.mlapp.utils.toast

class LandingActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        toolbarToLoad(toolbar as Toolbar)

        setNavDrawer()
        setUserHeaderInformation()

        if (savedInstanceState == null) {
            fragmentTransaction(LandingFragment())
            navView.menu.getItem(0).isChecked = true;
        }

    }

    private fun setNavDrawer() {
        val toogle = ActionBarDrawerToggle(this, drawerLayout, _toolbar, R.string.open_drawer, R.string.close_drawer)
        toogle.isDrawerIndicatorEnabled = true;
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    private fun fragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }

    private fun loadFragmentById(id: Int) {
        when (id) {

            R.id.nav_home -> fragmentTransaction(LandingFragment())


        }
    }

    private fun showMessageNavItemSelectedById(id: Int) {
        when (id) {
            R.id.nav_profile -> toast("Hello from Profile")
            R.id.nav_settings -> toast("Hello from Settings")
        }
    }

    private fun setUserHeaderInformation() {
        val name = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewName)
        val email = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewEmail)

       // name?.let { name.text = getString(R.string.user_name) }
        // email?.let { email.text = getString(R.string.user_email) }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        showMessageNavItemSelectedById(item.itemId)
        loadFragmentById(item.itemId)
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}