package mdk.mdapp.other

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import drawer.apps.news_app.R
import drawer.apps.news_app.model.NavItem

class CustomNavAdapter : ArrayAdapter<NavItem> {

    var _context: Context
    var list: ArrayList<NavItem>
    var customLayout: Int

    lateinit var inflater: LayoutInflater

    constructor(
        context: Context,
        customLayout: Int,
        list: ArrayList<NavItem>
    ) : super(context, customLayout, list) {

        this._context = context
        this.customLayout = customLayout
        this.list = list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var NavItemHolder: NavItemHolder
        var view: View? = convertView

        if (view == null) {
            inflater = (context as Activity).layoutInflater
            NavItemHolder = NavItemHolder()

            view = inflater.inflate(customLayout, parent, false)
            NavItemHolder.textView_nav_item = view.findViewById(R.id.textView_nav_item)
            NavItemHolder.imageView_nav_item = view.findViewById(R.id.imageView_nav_item)

            view.tag = NavItemHolder
        } else {
            NavItemHolder = view.tag as NavItemHolder
        }

        var itemObj: NavItem = this.list[position]
        NavItemHolder.textView_nav_item.text = itemObj.text
        NavItemHolder.imageView_nav_item.setImageResource(itemObj.image)

        return view!!
    }

    private class NavItemHolder {
        lateinit var textView_nav_item: TextView
        lateinit var imageView_nav_item: ImageView
    }
}