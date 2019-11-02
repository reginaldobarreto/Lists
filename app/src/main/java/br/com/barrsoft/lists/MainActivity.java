package br.com.barrsoft.lists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.pkmmte.pkrss.Article;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    List<Article> articleList = new ArrayList<>();
    Artigos artigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(articleList);
        recyclerView.setAdapter(adapter);

        artigos = new Artigos("https://feeds2.feedburner.com/canaltechbr", articleList, adapter, this);
    }

}
