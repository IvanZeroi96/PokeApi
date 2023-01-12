import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garcia.ivan.pokeapi.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_pokemon.view.*

class ListAdapter(val pokemonClick: (String) -> Unit): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    var pokemonList: List<ResultData> = emptyList()

    fun setData(list: List<ResultData>){
        var position : Int = 1
        for(c in list){
            c.position = position
            position ++
        }
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon, parent,false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.nameText.text = "No ${position + 1} - ${pokemon.name}"
        holder.itemView.setOnClickListener { pokemonClick(pokemon.name) }
        Picasso.get().load(Common().baseURlImagePng + pokemon.position + ".png").into(holder.itemView.imageView)
    }

    fun updateData(list: List<ResultData>){
        this.pokemonList = list
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}