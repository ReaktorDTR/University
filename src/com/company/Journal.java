package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Journal implements Serializable{
    private List<Rating> ratings = new ArrayList<>();

    public void setRatingToStudent(Rating ratingToStudent) {
        this.ratings.add(ratingToStudent);
    }

}
