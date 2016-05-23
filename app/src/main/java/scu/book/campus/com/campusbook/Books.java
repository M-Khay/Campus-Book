package scu.book.campus.com.campusbook;

/**
 * Created by qizhao on 5/22/16.
 */
public class Books {
        private String price;
        private String Name;
        private String isbn;
        private String Seller;
        private String Pics;

        public Books() {}
        public Books(String Name, String price) {
            this.Name = Name;
            this.price = price;
        }
        public String getName() {
            return Name;
        }
        public String getPrice() {
            return price;
        }
}
