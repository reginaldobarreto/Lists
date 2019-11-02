package br.com.barrsoft.lists;

import android.content.Context;
import android.util.Log;
import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;
import java.util.List;

class Artigos implements Callback{

    private static final String TAG = Artigos.class.getName() ;
    private List<Article> articleList;
    private RecyclerAdapter adapter;
    private final Context context;
    private String url;

    Artigos(String url, List<Article> articleList, RecyclerAdapter adapter, Context context) {
        this.url = url;
        this.articleList = articleList;
        this.adapter = adapter;
        this.context = context;
        PkRSS.with(context).load(url).skipCache().callback((Callback) this).async();
    }


    @Override
    public void onPreload() {

    }

    @Override
    public void onLoaded(List<Article> newArticles) {
        Log.i(TAG , "onLoaded: ");
        articleList.clear();
        articleList.addAll(newArticles);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onLoadFailed() {

    }
}
