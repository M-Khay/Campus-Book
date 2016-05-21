package scu.book.campus.com.campusbook;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import scu.book.campus.com.campusbook.adapter.ImageListAdapter;

/**
 * Created by kushahuja on 5/18/16.
 */
public class Home extends Fragment implements View.OnClickListener, TextWatcher {
    public EditText edtSearch;

    RecyclerView imageListView;
ImageListAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.search_page,container,false);

        edtSearch = (EditText) rootView.findViewById(R.id.edt_tags_search);
        edtSearch.setOnClickListener(this);
        edtSearch.addTextChangedListener(this);

        imageListView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        adapter = new ImageListAdapter(getContext());
        imageListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        RecyclerView.LayoutManager gridLayoutManager =  new GridLayoutManager(getContext(),adapter.getItemCount());
        imageListView.setLayoutManager(gridLayoutManager);
        imageListView.setItemAnimator(new DefaultItemAnimator());



        return rootView;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String searchString = s.toString();

        if (searchString.trim().length() > 0) {
        } else {
        }

    }

    @Override
    public void onClick(View v) {

    }
}
