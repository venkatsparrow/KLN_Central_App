package edu.klnce.sairam_kamalay.klncecentral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import java.util.ArrayList;
import java.util.List;

import edu.klnce.sairam_kamalay.klncecentral.Adapter.staffdetailadapter;
import edu.klnce.sairam_kamalay.klncecentral.Models.TitleChild;
import edu.klnce.sairam_kamalay.klncecentral.Models.TitleCreator;
import edu.klnce.sairam_kamalay.klncecentral.Models.TitleParent;

public class staffdetails extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((staffdetailadapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffdetails);

        recyclerView = (RecyclerView)findViewById(R.id.staffdetailrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        staffdetailadapter adapter = new staffdetailadapter(this,initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);
    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator  = TitleCreator.get(this);
        List<TitleParent> titles  = titleCreator.getAll();
        List<ParentObject> parentObject =  new ArrayList<>();
        for (TitleParent title :
                titles) {
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild(" Qualification:B.E.(CSE), M.E.(CSE), PH.D.,\n" +
                    "\nExperience:21.8 (Y.M)\n" +
                    "\nEmail ID:alageswaranramaiah@outlook.com","none"));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }

        return parentObject;
    }
}
