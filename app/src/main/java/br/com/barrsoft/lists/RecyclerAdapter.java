package br.com.barrsoft.lists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pkmmte.pkrss.Article;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {


    private List<Article> articleList;

    public RecyclerAdapter(List<Article> articleList) {

        this.articleList = articleList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Article article = articleList.get(position);

        holder.title.setText(article.getTitle());
        holder.subTitle.setText(article.getDescription());

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
