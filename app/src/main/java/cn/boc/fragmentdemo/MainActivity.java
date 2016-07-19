package cn.boc.fragmentdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BookListFragment.OnItemOnclick{

    private boolean isTwoPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(findViewById(R.id.activity_main) != null){
            isTwoPanel = false;
            BookListFragment bookListFragment = new BookListFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.add(R.id.activity_main,bookListFragment);

            fragmentTransaction.commit();
        }else{
            isTwoPanel = true;
            BookListFragment bookListFragment = new BookListFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.add(R.id.booklist,bookListFragment,"book_list");

            fragmentTransaction.commit();

            BookDetailFragment bookDetailFragment = new BookDetailFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.bookcontent,bookDetailFragment,"book_detail").commit();


        }

    }



    @Override
    public void onitemClick(int position) {
        if(isTwoPanel){
            BookDetailFragment bookDetailFragment = (BookDetailFragment) getSupportFragmentManager().findFragmentByTag("book_detail");

            BookListFragment bookListFragment = (BookListFragment) getSupportFragmentManager().findFragmentByTag("book_list");

            bookDetailFragment.textView.setText(bookListFragment.dataList.get(position).bookContent);


        }else{
            BookDetailFragment bookDetailFragment = new BookDetailFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.activity_main,bookDetailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
