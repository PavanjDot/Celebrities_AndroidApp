package pavanjdot.com.celebrities

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.celebrity_row.view.*

class celebrityListAdapter: BaseAdapter {

     private var Celebritydatabase: celebrityDatabase? = null

     private var context: Context? = null

     constructor(context: Context) {
         Celebritydatabase = celebrityDatabase()
         this.context = context
     }


     override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


         val CeleBrity: celebrity = Celebritydatabase?.celebrityList?.get(position) ?:
                 celebrity("No Actor", "No Des", R.drawable.placeholder, false)


         var celebrityView: View

         var layoutInflater: LayoutInflater = context?.getSystemService(
             Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

         if(CeleBrity.isAlive == true) {
             celebrityView = layoutInflater.inflate(R.layout.alive_celebrity_row, null)
         } else{
             celebrityView  = layoutInflater.inflate(R.layout.celebrity_row, null)
         }


         celebrityView.actorImage.setImageResource(CeleBrity?.image ?: R.drawable.placeholder)
         celebrityView.lblActorName.setText(CeleBrity.name)
         celebrityView.lblActorDes.setText(CeleBrity.des)

         celebrityView.setOnClickListener {

             val actorBioIntent = Intent(context, BioActivity::class.java)
             actorBioIntent.putExtra(BioActivity.ACTOR_NAME, CeleBrity.name)
             actorBioIntent.putExtra(BioActivity.ACTOR_DES, CeleBrity.des)
             actorBioIntent.putExtra(BioActivity.ACTOR_IMAGE, CeleBrity.image)
             startActivity(context!!, actorBioIntent, null)

         }

        celebrityView.setOnLongClickListener {

            showDialog(position)

            return@setOnLongClickListener true
        }




         return celebrityView

     }

     override fun getItem(position: Int): Any {

         return Celebritydatabase?.celebrityList?.get(position) ?: celebrity("No Actor", "No Des", R.drawable.placeholder, false)
     }

     override fun getItemId(position: Int): Long {

         return position.toLong()
     }

     override fun getCount(): Int {

         return Celebritydatabase?.celebrityList?.size ?: 0


     }
// Alert Dialog calling
    private fun showDialog(index: Int) {

        val aleartDialog: AlertDialog = AlertDialog.Builder(context).create()
        aleartDialog.setTitle("Message")
        aleartDialog.setMessage("What would you like to do?")

        aleartDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Delete", {
            dialog: DialogInterface?, which: Int ->

            Celebritydatabase?.celebrityList?.removeAt(index)

            this@celebrityListAdapter.notifyDataSetChanged()
        })

        aleartDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Duplicate", {
            dialog: DialogInterface?, which: Int ->

            Celebritydatabase?.celebrityList?.add(index, Celebritydatabase?.celebrityList?.get(index)
            ?: celebrity("No Actor", "No Des", R.drawable.placeholder, false)
            )

            this.notifyDataSetChanged()


        })

        aleartDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
            { dialog: DialogInterface?, which: Int ->

                aleartDialog.dismiss()

        })

        aleartDialog.setCancelable(true)

        aleartDialog.show()


    }


 }