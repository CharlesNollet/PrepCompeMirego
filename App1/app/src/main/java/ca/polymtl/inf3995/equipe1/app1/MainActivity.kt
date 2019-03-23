package ca.polymtl.inf3995.equipe1.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fuel.get("https://api.datamuse.com/words?sp=t??k").responseString { request, response, result ->
            runOnUiThread {
                centerText.text = response.httpStatusCode.toString()
            }
        }

        Fuel.get("https://api.datamuse.com/words?sp=t??k")
            .responseObject(Data.Deserializer()) { request, response, result ->
                val (dataList, err) = result
                var text = ""
                dataList?.forEach { data ->
                    text += data.word
                }
                runOnUiThread {
                    centerText.text = text
                }
            }
    }
}
