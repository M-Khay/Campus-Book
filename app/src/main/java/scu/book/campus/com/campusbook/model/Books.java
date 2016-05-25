package scu.book.campus.com.campusbook.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by kushahuja on 5/23/16.
 */
public class Books {
    public String bookName;
    public String bookPrice;
    public String bookImage;
    public  String sellerEmail;
    public String sellerName;
    public String sellerLocation;
    public String isbn;
    public String sellerType;
//    public List<String> buyers;

//    public Books(String bookName, String bookPrice, String bookImage, String sellerEmail, String sellerName, String sellerLocation,
//                 String isbn, String sellerType) {
//
//
//        this.bookName = bookName;
//        this.bookImage = bookImage;
//        this.bookPrice = bookPrice;
//        this.sellerEmail = sellerEmail;
//        this.sellerName = sellerName;
//        this.sellerLocation = sellerLocation;
//        this.isbn = isbn;
//        this.sellerType = sellerType;
//    }



    public void setBookName(String bookName){
        this.bookName= bookName;

    }

    public String getBookName(){
        return bookName;
    }

    public void setBookPrice(String bookPrice){
        this.bookPrice= bookPrice;

    }

    public String getBookPrice(){
        return bookPrice;
    }

    public void setBookImage(String bookImage){
        this.bookImage = bookImage;

    }

    public String getBookImage(){
        return bookImage;
    }

    public void setIsbn(String isbn){
        this.isbn= isbn;

    }

    public String getIsbn(){
        return isbn;
    }
    public void setSellerEmail(String sellerEmail){
        this.sellerEmail= sellerEmail;

    }

    public String getSellerEmail(){
        return sellerEmail;
    }

    public void setSellerLocation(String sellerLocation){
        this.sellerLocation= sellerLocation;

    }

    public String getSellerLocation(){
        return sellerLocation;
    }

    public void setSellerName(String sellerName){
        this.sellerName= sellerName;

    }

    public String getSellerName(){
        return sellerName;
    }

    public void setSellerType(String sellerType){
        this.sellerType= sellerType;

    }

    public String getSellerType(){
        return sellerType;
    }

}

