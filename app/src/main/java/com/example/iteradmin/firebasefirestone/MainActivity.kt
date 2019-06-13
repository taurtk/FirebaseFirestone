package com.example.iteradmin.firebasefirestone
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val x=findViewById<EditText>(R.id.city)
        val t=findViewById<TextView>(R.id.text)
        val b=findViewById<Button>(R.id.save)
        val queue= Volley.newRequestQueue(this)

        val url:String="http://api.openweathermap.org/data/2.5/weather?q="
        val api:String="&appid=cbcdcd0307baefbd88a237868960add9"

        b.setOnClickListener {

            val complink=url+x.text.toString()+api
            val jsnRequest:JsonObjectRequest = JsonObjectRequest(Request.Method.GET,complink,null,
                    Response.Listener<JSONObject>{
                        response ->
                        val ar: JSONObject =response.getJSONObject("coord")
                        val s:String="longitute :"+ar.get("lon")+"latitude : "+ar.get("lat")
                        t.text=s


                    },
                    Response.ErrorListener {
                        Toast.makeText(this,"error",Toast.LENGTH_LONG).show()

                    }

            )
            queue.add(jsnRequest)
        }

        }
    }

