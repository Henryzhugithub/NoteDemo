package com.example.zhl.notedemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;

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
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_note);

        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        date = (TextView) findViewById(R.id.date);

        Intent intent = getIntent();
        starttempdate = intent.getStringExtra("editdate");
        if (starttempdate == null){
            return;
        }
        starttemptitle = intent.getStringExtra("edittitle");
        starttempcontent = intent.getStringExtra("editcontent");
        title.setText(starttemptitle);
        content.setText(starttempcontent);
        date.setText(starttempdate);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String tempTitle = title.getText().toString();
        String tempContent = content.getText().toString();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String tempDate = dateFormat.format(date);
        noteDb = NoteDb.getInstance(this);

        if (starttempdate == null){

            noteDb.saveNote(tempTitle,tempContent,tempDate);
        }else if (tempTitle == starttemptitle&&tempContent == starttempcontent){
            return;
        }else {
            noteDb.updateNote(tempTitle, tempContent, tempDate,starttempdate);
        }


/*        if (tempContent.equals("")&&tempTitle.equals("")){
            return;
            // Toast.makeText(this,"标题和内容都为空",Toast.LENGTH_SHORT).show();
        }else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String tempDate = dateFormat.format(date);
            noteDb = NoteDb.getInstance(this);
            noteDb.saveNote(tempTitle,tempContent,tempDate);

        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate menu resource file
        getMenuInflater().inflate(R.menu.edit,menu);

        //Locate MenuItem with ShareActionProvider
        MenuItem itemShare = menu.findItem(R.id.action_share);

        mShareActionProvider = (android.support.v7.widget.ShareActionProvider) MenuItemCompat.getActionProvider(itemShare);


        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_importpicuture){

        }else if (id == R.id.action_share){
            Intent myShareIntent = new Intent(Intent.ACTION_SEND);
            myShareIntent.setType("text/plain");
            String shareContent = content.getText().toString();
            myShareIntent.putExtra(Intent.EXTRA_TEXT,shareContent);
            startActivity(Intent.createChooser(myShareIntent, getResources().getText(R.string.action_share_to)));

        }else if (id == R.id.action_picture){

        }
        return super.onOptionsItemSelected(item);
    }
}
