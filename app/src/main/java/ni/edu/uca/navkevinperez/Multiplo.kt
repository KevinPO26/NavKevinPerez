package ni.edu.uca.navkevinperez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ni.edu.uca.navkevinperez.databinding.FragmentMultiploBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Multiplo.newInstance] factory method to
 * create an instance of this fragment.
 */
class Multiplo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fbinding: FragmentMultiploBinding

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
        fbinding = FragmentMultiploBinding.inflate(layoutInflater)
        iniciar()
        return fbinding.root
    }

    private fun iniciar() {
        fbinding.btnMult.setOnClickListener {
            calcularMultiplo()
        }
        fbinding.btnLimpiarTabla.setOnClickListener{
            limpiar()
        }
    }

    private fun limpiar() {
        with(fbinding){
            tvMult.setText("")
            etNumber.setText("")
        }
    }

    private fun calcularMultiplo() {
        val num = fbinding.etNumber.text.toString().toInt()
        var result = ""
        if(num%5 == 0){
            result = "Si es multiplo de 5"
        }else{
            result = "No es multiplo de 5"

        }
        fbinding.tvMult.setText(result)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Multiplo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Multiplo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}