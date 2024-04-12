import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.vsu_lesson3_dz.Launch
import com.example.vsu_lesson3_dz.R
import com.example.vsu_lesson3_dz.Rocket

class Page3Adapter(context: Context, resource: Int, objects: List<Rocket>) :
    ArrayAdapter<Rocket>(context, resource, objects) {

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

        val activeTextView = listItemView.findViewById<TextView>(R.id.activeTextView)
        if (currentItem.isActive) {
            activeTextView.text = "ACTIVE"
            activeTextView.setBackgroundResource(R.drawable.active_text)
        } else {
            activeTextView.text = "INACTIVE"
            activeTextView.setBackgroundResource(R.drawable.inactive_text)
        }

        return listItemView
    }
}