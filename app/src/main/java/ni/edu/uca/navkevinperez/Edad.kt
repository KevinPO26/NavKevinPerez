package ni.edu.uca.navkevinperez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.navkevinperez.databinding.FragmentEdadBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Edad.newInstance] factory method to
 * create an instance of this fragment.
 */
class Edad : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fbinding: FragmentEdadBinding
    val numbers: MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentEdadBinding.inflate(layoutInflater)
        iniciar()
        return fbinding.root
    }

    private fun iniciar() {
        fbinding.btnAgregar.setOnClickListener {
            agregar()
        }
        fbinding.btnMediaA.setOnClickListener {
            calcularMediaAritmetica()
        }
        fbinding.btnEliminar.setOnClickListener {
            limpiarLista()
        }
    }

    private fun limpiarLista() {
        try {
            numbers.removeAll(numbers)
            fbinding.tvMediaA.setText("")
            limpiar()
        } catch (ex: Exception) {
            Toast.makeText(
                activity, "Error: ${ex.toString()} ",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun limpiar() {
        with(fbinding) {
            etNumero.setText("")
        }
    }

    private fun calcularMediaAritmetica() {
        var result = ""
        var media = 0
        try {
            val (mode, _) = numbers.groupingBy { it }.eachCount().maxByOrNull { it.value }!!

            if (numbers.size % 2 == 0)
                media = (numbers[numbers.size / 2] + numbers[(numbers.size - 1) / 2]) / 2
            else
                media = numbers[numbers.size / 2]
            val sum: Double = numbers.sum().toDouble() / numbers.size
            result = "Numeros Ingresados: ${numbers}\n Media Aritmetica: ${sum}\n Media: ${media}\n Moda: ${mode}"
            fbinding.tvMediaA.setText(result)
        } catch (ex: Exception) {
            Toast.makeText(
                activity, "Error: ${ex.toString()} ",
                Toast.LENGTH_LONG
            ).show()

        }
    }

    private fun agregar() {
        val number = fbinding.etNumero.text.toString().toInt()
        numbers.add(number)
        limpiar()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Edad.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Edad().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}