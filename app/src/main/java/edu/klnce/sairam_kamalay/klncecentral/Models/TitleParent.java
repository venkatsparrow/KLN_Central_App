package edu.klnce.sairam_kamalay.klncecentral.Models;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.UUID;

/**
 * Created by sairam_kamalay on 13/9/17.
 */

public class TitleParent implements ParentObject {

    private List<Object> mChildrenList;
    private UUID _id;
    private String title;

    public TitleParent(String title) {
        this.title = title;
        _id = UUID.randomUUID();
    }

    public UUID get_id(){
        return _id;
    }

    public void set_id(UUID _id){
        this._id = _id;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mChildrenList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mChildrenList = list;
    }
}
