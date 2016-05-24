package scu.book.campus.com.campusbook.model;

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
    public List<String> buyers;


    public Books(String bookName, String bookPrice, String bookImage, String sellerEmail, String sellerName, String sellerLocation,
                 String isbn, String sellerType) {


        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookPrice = bookPrice;
        this.sellerEmail = sellerEmail;
        this.sellerName = sellerName;
        this.sellerLocation = sellerLocation;
        this.isbn = isbn;
        this.sellerType = sellerType;
    }

    private Books() {

        return;
    }
}

