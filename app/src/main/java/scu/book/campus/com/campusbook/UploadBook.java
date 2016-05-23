package scu.book.campus.com.campusbook;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kii.cloud.storage.Kii;
import com.kii.cloud.storage.KiiBucket;
import com.kii.cloud.storage.KiiObject;
import com.kii.cloud.storage.exception.app.AppException;
import com.kii.cloud.storage.resumabletransfer.AlreadyStartedException;
import com.kii.cloud.storage.resumabletransfer.KiiRTransfer;
import com.kii.cloud.storage.resumabletransfer.KiiRTransferProgressCallback;
import com.kii.cloud.storage.resumabletransfer.KiiUploader;
import com.kii.cloud.storage.resumabletransfer.StateStoreAccessException;
import com.kii.cloud.storage.resumabletransfer.SuspendedException;
import com.kii.cloud.storage.resumabletransfer.TerminatedException;

import java.io.File;
import java.io.IOException;

/**
 * Created by qizhao on 5/22/16.
 */
public class UploadBook extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadbook);
        Kii.initialize(getApplicationContext(), "\n" +
                "5e6cf58f", "3de2d3d6d860244b7f81698a20e38225", Kii.Site.US, true);
    }

    public void uploadImage(View v){
        // Create Application Scope Bucket
        KiiBucket appBucket = Kii.bucket("mydata");

        KiiObject object = appBucket.object();
        try {
            object.save();
        } catch (IOException e) {
            // handle error

        } catch (AppException e) {
            // handle error

        }
        /*KiiObject object = Kii.bucket("mydata").object();


// Set key-value pairs
        object.set("score", 987);
        object.set("mode", "easy");
        object.set("premiumUser", false);

// Save the object
        try {
            object.save();
        } catch (IOException e) {
            // Handle error
        } catch (AppException e) {
            // Handle error
        }*/
        // Create an object in an application-scope bucket.
        /*KiiObject object = Kii.bucket("mydata").object();

// Set key-value pairs.
        object.set("title", "MyVideo");
        object.set("fileSize", 10485760);

// Create an uploader.
        File localFile = new File(Environment.getExternalStorageDirectory(),
                "sample.mp4");
        KiiUploader uploader = object.uploader(getApplicationContext(),
                localFile);

// Start uploading
        try {
            uploader.transfer(new KiiRTransferProgressCallback() {
                @Override
                public void onProgress(KiiRTransfer operator, long completedInBytes, long totalSizeinBytes) {
                    float progress = (float)completedInBytes / (float)totalSizeinBytes * 100.0f;
                }
            });
        } catch (AlreadyStartedException e) {
            // Upload already in progress.
        } catch (SuspendedException e) {
            // Upload suspended (e.g. network error or user interruption).
        } catch (TerminatedException e) {
            // Upload terminated (e.g. file not found or user interruption).
        } catch (StateStoreAccessException e) {
            // Failed to access the local storage.
        }*/
    }
}
