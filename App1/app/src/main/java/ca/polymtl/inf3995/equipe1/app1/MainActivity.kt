package ca.polymtl.inf3995.equipe1.app1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Data> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Fuel.get("https://api.datamuse.com/words?sp=t??k").responseString { request, response, result ->
            result.fold(success = {
                Log.e("FUEL RESPONSE", it)
            }, failure = {
                Log.e("FUEL RESPONSE", "ERROR")
            })
            Log.e("FUEL RESPONSE", response.httpStatusCode.toString())
        }

        Fuel.get("https://api.datamuse.com/words?sp=t??k")
            .responseObject(Data.Deserializer()) { request, response, result ->
                val (dataList, err) = result
                dataList?.forEach { data ->
                    list.add(data)
                }
                runOnUiThread {
                    //https://developer.android.com/guide/topics/ui/layout/recyclerview
                    // Attach the adapter to the recyclerview to populate items
                    recyclerView.adapter = WordsAdapter(list)
                    // Set layout manager to position the items
                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                }
            }

    }
}
