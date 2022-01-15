package kg.geektech.kotlin1less

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.kotlin1less.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getText()
        sendTextBack()

    }

    private fun sendTextBack() {
       binding.clickBtn.setOnClickListener{
           if (binding.textTv.length()>0){
               val intent = Intent()
               intent.putExtra(MainActivity.INTENT_KEY,binding.textTv.text.toString())
               setResult(Activity.RESULT_OK,intent)
               finish()
           }else{
               Toast.makeText(this,this.getString(R.string.toast),Toast.LENGTH_LONG).show()



           }
       }
    }

    private fun getText() {
        val getText : String = intent.getStringExtra(MainActivity.INTENT_KEY).toString()
        binding.textTv.setText(getText)
    }

}


