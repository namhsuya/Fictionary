package android.example.com.fictionary;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.provider.UserDictionary.Words;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private final String[] COLUMNS_TO_BE_FOUND = new String[]{
            Words.WORD, Words.FREQUENCY
    };

    private static final int[] LAYOUT_ITEMS_TO_FILL = new int[] {
            R.id.word,
            R.id.frequency
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView dictListView = (ListView) findViewById(R.id.dictionary_list_view);
        dictListView.setDivider(null);
        ContentResolver resolver = getContentResolver();

        Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);


        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.listview_layout, cursor,COLUMNS_TO_BE_FOUND, LAYOUT_ITEMS_TO_FILL,0);


        dictListView.setAdapter(adapter);
    }
}
