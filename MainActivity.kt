package drawer.apps.news_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import drawer.apps.news_app.model.NavItem
import kotlinx.android.synthetic.main.activity_main.*
import mdk.mdapp.other.CustomNavAdapter

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNavigationView()
    }

    private fun setUpNavigationView() {
        toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout_main,
        toolBar_main, R.string.open, R.string.close)

        drawerLayout_main.addDrawerListener(toggle)

        toggle.syncState()
        toggle.drawerArrowDrawable.color = Color.parseColor("#000000")

        var navItems = ArrayList<NavItem>()
        navItems.add(NavItem(R.drawable.ic_new_category, "News Categories"))
        navItems.add(NavItem(R.drawable.ic_bookmark, "Bookmarks"))
        navItems.add(NavItem(R.drawable.ic_contact_us, "Contact Us"))
        navItems.add(NavItem(R.drawable.ic_privacy_policy, "Privacy Policy"))

        var customNavAdapter = CustomNavAdapter(this@MainActivity, R.layout.row_nav_item, navItems)
        listView_nav.adapter = customNavAdapter
        customNavAdapter.notifyDataSetChanged()

        listView_nav.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Item: ${navItems[position].text}",
                        Toast.LENGTH_SHORT).show()
            }
        })
    }
}