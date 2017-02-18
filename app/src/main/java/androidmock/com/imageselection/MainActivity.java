package androidmock.com.imageselection;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Flag to indicate which task is to be performed.
    private static final int REQUEST_SELECT_IMAGE = 0;

    //Creating view variables
    private Button bSelectImage;
    private ImageView ivLogoWiseL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connecting the view variables with xml views
        bSelectImage = (Button) findViewById(R.id.bSelectImage);
        ivLogoWiseL = (ImageView) findViewById(R.id.ivLogoWiseL);

        //Setting click listener on button
        bSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectImageActivity.class);
                startActivityForResult(intent, REQUEST_SELECT_IMAGE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Checking the requestCode and resultCode to perform a specific task
        if (requestCode == REQUEST_SELECT_IMAGE && resultCode == RESULT_OK){
            // If image is selected successfully, set the image URI.
            Uri imageUri = data.getData();
            if (imageUri != null) {
                // Show the image on screen.
                ivLogoWiseL.setImageURI(imageUri);
            }
        }
    }
}
