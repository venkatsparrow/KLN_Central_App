package edu.klnce.sairam_kamalay.klncecentral.Models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sairam_kamalay on 13/9/17.
 */

public class TitleCreator {
    static TitleCreator _titleCreator;
    List<TitleParent> _titleParents;

    public TitleCreator(Context context) {
        _titleParents = new ArrayList<>();
            TitleParent title =  new TitleParent(String.format("DR.R.ALAGESWARAN HOD"));
            _titleParents.add(title);
        TitleParent title2 =  new TitleParent(String.format("DR.G.RAMESH Professor"));
        _titleParents.add(title2);
        TitleParent title3 =  new TitleParent(String.format("DR.P.GANESHKUMAR Professor"));
        _titleParents.add(title3);
        TitleParent title4 =  new TitleParent(String.format("KANCHANA J S Professor"));
        _titleParents.add(title4);
        TitleParent title5 =  new TitleParent(String.format("ILANKUMARAN S ASP1"));
        _titleParents.add(title5);
        TitleParent title6 =  new TitleParent(String.format("PANDIAN C AP(Sr.Gr.)"));
        _titleParents.add(title6);
        TitleParent title7 =  new TitleParent(String.format("SELVARAJ AP(Sr.Gr.)"));
        _titleParents.add(title7);



    }

    public static TitleCreator get(Context context)
    {
        if(_titleCreator == null)
            _titleCreator = new TitleCreator(context);
        return _titleCreator;
    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}
