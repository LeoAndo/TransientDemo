package jp.ac.jec.cm0199.transientdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // de-serialize
        Person3 data = getIntent().getSerializableExtra("data", Person3.class);
        if (data != null) {
            Log.d("TAG", data.toString());
            ((TextView) findViewById(R.id.textView)).setText(data.toString());
        }
    }

    public static void start(Context context, Person3 person3) {
        Intent starter = new Intent(context, NextActivity.class);
        starter.putExtra("data", person3); // シリアライズしたデータを渡すのは非推奨.
        context.startActivity(starter);
    }
}