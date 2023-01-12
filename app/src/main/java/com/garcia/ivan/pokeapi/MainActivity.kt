package com.garcia.ivan.pokeapi
import ListAdapter
import ListViewModel
import ResultData
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.garcia.ivan.pokeapi.view.detail.Detail
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel
    private var mutableList: MutableList<ResultData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        listRecyclerView.layoutManager = LinearLayoutManager(this)

        listRecyclerView.adapter = ListAdapter{
            val intent = Intent(this, Detail::class.java)
            intent.putExtra("name", it)
            startActivity(intent)
        }

        viewModel.getPokemonList()

        viewModel.pokemonsList.observe(this) { list ->
            (listRecyclerView.adapter as ListAdapter).setData(list)
            mutableList =
                (listRecyclerView.adapter as ListAdapter).pokemonList as MutableList<ResultData>
        }

        edtSearch.addTextChangedListener { userFilter ->
            val listFiltered = mutableList.filter {
                    list -> list.name.lowercase().contains(userFilter.toString().lowercase())
            }
            viewModel.pokemonsList.observe(this) {
                (listRecyclerView.adapter as ListAdapter).updateData(listFiltered)
            }
        }
    }
}