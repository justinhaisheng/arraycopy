package com.aispeech.array_copy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        Person[] persons1 = new Person[10];
        for (int i = 0; i < persons1.length; i++) {
            persons1[i] = new Person("Darren", 24 + i);
        }

        // java 层赋值
        Person[] newPersons = new Person[10];

        try {
            arraycopy(persons1, 0, newPersons, 0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < newPersons.length; i++) {
            Log.e("TAG", newPersons[i].toString());
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public static native void arraycopy(Object src, int srcPos,
                                        Object dest, int destPos,
                                        int length);
}
