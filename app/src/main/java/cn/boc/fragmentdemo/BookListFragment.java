package cn.boc.fragmentdemo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglj on 16/7/19.
 */

public class BookListFragment extends Fragment {

    public OnItemOnclick onItemOnclick;


    public List<Book> dataList;

    public  interface OnItemOnclick{
        void onitemClick(int position);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onItemOnclick = (OnItemOnclick) context;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.book_listview,container,false);

        ListView listView = (ListView) view.findViewById(R.id.bookListView);

        dataList = initBookList();


        List<String> stringList = new ArrayList<>();
        for(Book book:dataList){
            stringList.add(book.bookName);
        }

        listView.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,stringList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onItemOnclick.onitemClick(i);
            }
        });
        return view;
    }



    public List<Book> initBookList(){
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.bookName = "bookname"+i;
            book.bookContent = "bookContent"+i;
            bookList.add(book);
        }

        return bookList;
    }
}
