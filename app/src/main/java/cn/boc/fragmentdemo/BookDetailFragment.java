package cn.boc.fragmentdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wanglj on 16/7/19.
 */

public class BookDetailFragment extends Fragment {
    public TextView textView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        textView = new TextView(getContext());
        textView.setText("内容");
        return textView;
    }
}
