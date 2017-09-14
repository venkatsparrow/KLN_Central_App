package edu.klnce.sairam_kamalay.klncecentral.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import edu.klnce.sairam_kamalay.klncecentral.Models.TitleChild;
import edu.klnce.sairam_kamalay.klncecentral.Models.TitleParent;
import edu.klnce.sairam_kamalay.klncecentral.R;
import edu.klnce.sairam_kamalay.klncecentral.ViewHolders.TitleChildViewHolder;
import edu.klnce.sairam_kamalay.klncecentral.ViewHolders.TitleParentViewHolder;

/**
 * Created by sairam_kamalay on 13/9/17.
 */

public class staffdetailadapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {

    LayoutInflater inflater;

    public staffdetailadapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.stafflistparent,viewGroup,false);
        return new TitleParentViewHolder(view);
    }



    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.stafflistchild,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent title  = (TitleParent)o;
        titleParentViewHolder._textView.setText(title.getTitle());


    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild title = (TitleChild)o;
        titleChildViewHolder.option1.setText(title.getOption1());
    }
}
