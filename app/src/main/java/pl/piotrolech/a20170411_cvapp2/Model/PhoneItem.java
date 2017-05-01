package pl.piotrolech.a20170411_cvapp2.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import pl.piotrolech.a20170411_cvapp2.R;

/**
 * Created by olech on 13.04.2017.
 */

public class PhoneItem extends DataItem {

    private final Uri uri;

    public PhoneItem() {
        super(Data.PHONENUMBER, R.drawable.ic_call_24dp);
        uri = Uri.parse("tel:" + Data.PHONENUMBER);
    }

    @Override
    public void performAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        context.startActivity(intent);
    }
}
