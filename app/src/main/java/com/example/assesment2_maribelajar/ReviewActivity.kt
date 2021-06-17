package com.example.assesment2_maribelajar

import android.app.AlertDialog
import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_review.*


class ReviewActivity : AppCompatActivity() {

    //In Kotlin `var` is used to declare a mutable variable. On the other hand
    //`internal` means a variable is visible within a given module.
    internal var dbHelper = DatabaseHelper(this)

    /**
     * Let's create a function to show Toast message
     */
    fun showToast(text: String){
        Toast.makeText(this@ReviewActivity, text, Toast.LENGTH_LONG).show()
    }

    /**
     * Let's create a function to show an alert dialog with data dialog.
     */
    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }


    fun clearEditTexts(){
        nameTxt.setText("")
        galaxyTxt.setText("")
        typeTxt.setText("")
        idTxt.setText("")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()
    }

    fun handleInserts() {
        insertBtn.setOnClickListener {
            try {
                dbHelper.insertData(nameTxt.text.toString(),galaxyTxt.text.toString(),
                    typeTxt.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }


    fun handleUpdates() {
        updateBtn.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(idTxt.text.toString(),
                    nameTxt.text.toString(),
                    galaxyTxt.text.toString(), typeTxt.text.toString())
                if (isUpdate == true)
                    showToast("Data Updated Successfully")
                else
                    showToast("Data Not Updated")
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }


    fun handleDeletes(){
        deleteBtn.setOnClickListener {
            try {
                dbHelper.deleteData(idTxt.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }


    fun handleViewing() {
        viewBtn.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("Nama :" + res.getString(1) + "\n")
                    buffer.append("Review :" + res.getString(2) + "\n")
                    buffer.append("Rating :" + res.getString(3) + "\n\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }
}