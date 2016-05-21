package scu.book.campus.com.campusbook.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import scu.book.campus.com.campusbook.R;

/**
 * Created by kushahuja on 5/17/16.
 */
public class Image {

    private String imageDescription;
            private Bitmap bookImage;

    public Image(String description, Bitmap bookImage)
    {

     imageDescription = description;
        this.bookImage= bookImage;
    }

    public Image()
    {

    }

    public String getDescription()
    {
        return imageDescription;
    }

    public Bitmap getImagePath()
    {
        return bookImage;
    }

    public void setDescription(String description)
    {
        imageDescription = description;
    }

    public void setImagePath(Bitmap bookImage)
    {
        this.bookImage=bookImage;
    }

    @Override public String toString() {
        return "path:" + getImagePath()  +
                "\ndescription:" + imageDescription;
    }
}
