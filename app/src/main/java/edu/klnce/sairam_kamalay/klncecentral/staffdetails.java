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
        String[] staffdetails = {

                "\nQualification:B.E.(CSE), M.E.(CSE), PH.D.,\n" +
                "\nExperience:21.8 (Y.M)\n" +
                "\nEmail ID:alageswaranramaiah@outlook.com\n",

                "\nQualification:B.E. (EEE), M.E. (CSE), PH.D.\n" +
                "\nExperience:15.10 (Y.M)\n" +
                "\nEmail ID:ramesh6_2000@yahoo.com\n",

                "\nQualification:B.E.(I&C), M.E.(APPL.ELECS.), PH.D.\n" +
                "\nExperience:16.7 (Y.M)\n" +
                "\nEmail ID:ganesh_me@yahoo.com\n",

                "\nQualification:B.E.(CSE) M.E.(CSE)., (PH.D.,)\n" +
                "\nExperience:19.8 (Y.M)\n" +
                "\nEmail ID:rckanch@yahoo.co.in\n",

                "\nQualification:B.E.(CSE) M.E.(CSE)., (PH.D.,)\n" +
                "\nExperience:12.9 (Y.M)\n" +
                "\nEmail ID:bala172001@yahoo.com\n",

                "\nQualification:B.E.(I.T), M.E.(CSE)\n" +
                "\nExperience:11.2 (Y.M)\n" +
                "\nEmail ID:pandian_daniel@yahoo.com\n",


                "\nQualification:B.E.(I.T), M.E.(CSE)\n" +
                "\nExperience:12.9 (Y.M)\n" +
                "\nEmail ID:selva25x@gmail.com\n"
        };
        int i = 0;
        TitleCreator titleCreator  = TitleCreator.get(this);
        List<TitleParent> titles  = titleCreator.getAll();
        List<ParentObject> parentObject =  new ArrayList<>();
           for (TitleParent title :
                titles) {

            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild(staffdetails[i]));
                title.setChildObjectList(childList);
            parentObject.add(title);
           i++;
        }


        return parentObject;
    }
}
