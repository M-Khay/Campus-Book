package scu.book.campus.com.campusbook.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scu.book.campus.com.campusbook.R;
import scu.book.campus.com.campusbook.model.Image;

/**
 * Created by kushahuja on 5/17/16.
 */
public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.MyViewHolder> {
    private List<Image> imageList;
    Context context;
//    private MyDB daOdb;


    public ImageListAdapter(Context context) {
        List<Image> imageList = new ArrayList<>();
        this.context = context;
//        daOdb = new MyDB(context);
//        for (Image image : daOdb.getNotes()) {
//            imageList.add(image);
//        }
        Drawable myDrawable = context.getResources().getDrawable(R.drawable.book_cover_1);
        Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();

        imageList.add(new Image("Book1",myLogo));
        imageList.add(new Image("Book1",myLogo));
        imageList.add(new Image("Book1",myLogo));

        this.imageList = imageList;

        Toast.makeText(context, "The size of imageList being loaded from database is " + imageList.size(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public ImageListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_page_grid, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ImageListAdapter.MyViewHolder holder, int position) {

        Image image = imageList.get(position);
        holder.bookName.setText(image.getDescription());
        holder.bookPrice.setText(image.getDescription());

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8; // Experiment with different sizes
//        Bitmap b = BitmapFactory.decodeFile(image.getImagePath(), options);

//        holder.img_icon.setImageBitmap(b);
    }

    @Override
    public int getItemCount() {
//        Toast.makeText(context, "The new image list size when retyurning to main Activity is " + imageList.size(), Toast.LENGTH_SHORT).show();
        return imageList.size();


    }

//
//    @Override
//    public void onItemDismiss(int position) {
//        imageList.remove(position);
//
//        Image image = getImageObjectAtPosition(position);
////        daOdb.deleteImage(image);
//        notifyItemRemoved(position);
//    }
//
//    @Override
//    public boolean onItemMove(int fromPosition, int toPosition) {
//        Toast.makeText(context, "The size of iamgeList is " + imageList.size(), Toast.LENGTH_SHORT).show();
//        Collections.swap(imageList, fromPosition, toPosition);
//        notifyItemMoved(fromPosition, toPosition);
//        return true;
//    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bookName;
        public TextView bookPrice;
        public ImageView img_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            bookName = (TextView) itemView.findViewById(R.id.book_name);
            bookPrice= (TextView) itemView.findViewById(R.id.book_price);

            img_icon = (ImageView) itemView.findViewById(R.id.book_img);
        }
    }

    public Image getImageObjectAtPosition(int position) {

        Image image = imageList.get(position);
        return image;
    }


}
