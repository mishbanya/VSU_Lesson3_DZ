import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.vsu_lesson3_dz.Launch
import com.example.vsu_lesson3_dz.R

class Page2Adapter(context: Context, resource: Int, objects: List<Launch>) :
    ArrayAdapter<Launch>(context, resource, objects) {

    private var mContext: Context = context
    private var mResource: Int = resource

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            listItemView = inflater.inflate(mResource, parent, false)
        }

        val currentItem = getItem(position)

        val imageView = listItemView!!.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(currentItem!!.imageResource)

        val nameTextView = listItemView.findViewById<TextView>(R.id.nameTextView)
        nameTextView.text = currentItem.name

        val locationTextView = listItemView.findViewById<TextView>(R.id.locationTextView)
        locationTextView.text = currentItem.location

        val dateTextView = listItemView.findViewById<TextView>(R.id.dateTextView)
        dateTextView.text = currentItem.date

        return listItemView
    }
}