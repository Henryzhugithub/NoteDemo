package com.example.zhl.notedemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhl.notedemo.R;
import com.example.zhl.notedemo.db.NoteDb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhl on 2015/12/31.
 */
public class EditNoteActivity extends AppCompatActivity {

    private TextView title,content,date;
    private NoteDb noteDb;
    private String starttempdate,starttempcontent,starttemptitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_note);

        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        date = (TextView) findViewById(R.id.date);

        Intent intent = getIntent();
        starttempdate = intent.getStringExtra("editdate");
        if (!starttempdate.equals("")){
            starttemptitle = intent.getStringExtra("edittitle");
            starttempcontent = intent.getStringExtra("editcontent");
            title.setText(starttemptitle);
            content.setText(starttempcontent);
            date.setText(starttempdate);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String tempTitle = title.getText().toString();
        String tempContent = content.getText().toString();
        if (tempContent.equals("")&&tempTitle.equals("")){
            Toast.makeText(this,"标题和内容都为空",Toast.LENGTH_SHORT).show();
        }else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String tempDate = dateFormat.format(date);
            noteDb = NoteDb.getInstance(this);
            noteDb.saveNote(tempTitle,tempContent,tempDate);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_importpicuture){

        }else if (id == R.id.action_share){

        }else if (id == R.id.action_picture){

        }
        return super.onOptionsItemSelected(item);
    }
}
