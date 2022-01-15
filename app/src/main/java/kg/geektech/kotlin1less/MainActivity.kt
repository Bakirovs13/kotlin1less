package kg.geektech.kotlin1less

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlin1less.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sendText()
        getText()
    }

    private fun getText() {
      resultLauncher  = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data !=null){
                val intent =result.data?.getStringExtra("text2").toString()
                binding.textTv.setText(intent)
            }
        }
    }

    private fun sendText() {
        binding.clickBtn.setOnClickListener{
            if (binding.textTv.length()>0){
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("text",binding.textTv.text.toString())
                resultLauncher.launch(intent)
            }else{
                Toast.makeText(this,"EditText не может быть пустым!",Toast.LENGTH_LONG).show()
            }
        }
    }

}

