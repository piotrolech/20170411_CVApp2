package pl.piotrolech.a20170411_cvapp2.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import pl.piotrolech.a20170411_cvapp2.R;

/**
 * Created by olech on 13.04.2017.
 */

public class LinkedInItem extends DataItem {

    private Uri uri;

    public LinkedInItem() {
        super(Data.LINKEDINTILE, R.drawable.linkedin);
        uri = Uri.parse(Data.LINKEDIN);
    }

    @Override
    public void performAction(Context context) {
        Intent linkedInIntent = new Intent(Intent.ACTION_VIEW);
        linkedInIntent.setData(uri);
        context.startActivity(linkedInIntent);
    }
}
