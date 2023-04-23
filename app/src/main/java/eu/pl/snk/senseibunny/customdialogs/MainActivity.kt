package eu.pl.snk.senseibunny.customdialogs

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var image_button: ImageButton?=null
    private var allert_button: Button?=null
    private var custom_button: Button?=null
    private var progress_button:Button ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image_button=findViewById(R.id.snack_btn);
        allert_button=findViewById(R.id.alert)
        custom_button=findViewById(R.id.custom)
        progress_button=findViewById(R.id.progress)

        image_button?.setOnClickListener{
            view->
            Snackbar.make(view,"You clicked button",Snackbar.LENGTH_LONG).show()
        }

        allert_button?.setOnClickListener{
            view->
            alertDialogFunction()
        }
        custom_button?.setOnClickListener{
            view->
            customDialogFunction()
        }
        progress_button?.setOnClickListener{
            view->
            custmDialogProgressDialogFunction()
        }
    }

    private fun alertDialogFunction(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is alert Dialog. It is used to show alerts")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes"){
            dialogInterface, which ->
            Toast.makeText(applicationContext,"Clicked yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("Cancel"){
                dialogInterface, which ->
            Toast.makeText(applicationContext,"Clicked cancel", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){
                dialogInterface, which ->
            Toast.makeText(applicationContext,"No", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)//you cant exit it clicking on the screen
        alertDialog.show()
    }

    private fun customDialogFunction() {
        val customDialog = Dialog(this)
        /*Set the screen content from a layout resource.
    The resource will be inflated, adding all top-level views to the screen.*/
        customDialog.setContentView(R.layout.dialog_layout)
        customDialog.findViewById<Button>(R.id.submit).setOnClickListener {
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_LONG).show()
            customDialog.dismiss() // Dialog will be dismissed
        }
        customDialog.findViewById<Button>(R.id.cancel).setOnClickListener {
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }
        //Start the dialog and display it on screen.
        customDialog.show()
    }

    private fun custmDialogProgressDialogFunction(){
        val customProgressDialog = Dialog(this)

        customProgressDialog.setContentView(R.layout.dialog_custom_progress)

        customProgressDialog.show()
    }
}