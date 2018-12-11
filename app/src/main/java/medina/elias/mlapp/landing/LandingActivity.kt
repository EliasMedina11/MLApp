package medina.elias.mlapp.landing

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.eliasmedina.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.sugestion_edit_text.*
import medina.elias.mlapp.R
import medina.elias.mlapp.search.SearchLandingActivity
import medina.elias.mlapp.utils.AppConstants
import medina.elias.mlapp.utils.goToActivity
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
            navView.menu.getItem(0).isChecked = true
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.toolbar_actions,menu)
        val searchItem = menu.findItem(R.id.action_search_button)
        val adapter = ArrayAdapter<String>(this, R.layout.sugestion_edit_text, AppConstants.mainSlides)
        suggestion_list.adapter = adapter

        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            searchView.setOnCloseListener {
                suggestion_list.visibility = View.GONE
                container.visibility = View.VISIBLE
                true
            }
            searchView.setOnSearchClickListener {
                suggestion_list.visibility = View.VISIBLE
                container.visibility = View.GONE
            }
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    val intent = Intent(applicationContext,SearchLandingActivity::class.java)
                    intent.putExtra("query", query)
                    startActivity(intent)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()){
                        adapter.filter.filter(newText)
                    }
                    return true
                }
            })
            suggestion_list.setOnItemClickListener { _, _, _, _ ->
                val selectedString = suggestion_text.text.toString()
                val intent = Intent(applicationContext,SearchLandingActivity::class.java)
                intent.putExtra("query", selectedString)
                startActivity(intent)
            }

        }
       return true
    }


    private fun setNavDrawer() {
        val toogle = ActionBarDrawerToggle(this, drawerLayout, _toolbar,  R.string.open_drawer, R.string.close_drawer)
        toogle.isDrawerIndicatorEnabled = true
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
            R.id.nav_profile -> toast("Profile")
            R.id.nav_settings -> toast("Settings")
        }
    }

    private fun setUserHeaderInformation() {
        val name = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewName)
        val email = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewEmail)

         name?.let { name.text = getString(R.string.user) }
         email?.let { email.text = getString(R.string.email) }
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