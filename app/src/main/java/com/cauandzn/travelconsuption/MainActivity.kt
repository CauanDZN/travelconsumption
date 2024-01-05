package com.cauandzn.travelconsuption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cauandzn.travelconsuption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonCalculate) {
            calculate(view)
        }
    }

    private fun isValid(): Boolean {
        return binding.editDistance.text.toString() != "" &&
                binding.editPrice.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "0" &&
                binding.editAutonomy.text.toString().toFloat() != 0f
    }

    private fun calculate(view: View) {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            if (autonomy == 0f) {
                Toast.makeText(this, R.string.validationAutonomy, Toast.LENGTH_SHORT).show()
                binding.labelResult.text = "R$ 0"
            } else {
                val totalValue = (distance * price) / autonomy
                binding.labelResult.text = "R$ ${"%.2f".format(totalValue)}"
            }
        } else {
            Toast.makeText(this, R.string.validationAllFields, Toast.LENGTH_SHORT).show()
        }
    }


}