package edu.klnce.sairam_kamalay.klncecentral.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import edu.klnce.sairam_kamalay.klncecentral.R;

/**
 * Created by sairam_kamalay on 13/9/17.
 */

public class TitleChildViewHolder extends ChildViewHolder {

    public TextView option1;

    public TitleChildViewHolder(View itemView) {
        super(itemView);
        option1 = (TextView) itemView.findViewById(R.id.option1);
    }
}
