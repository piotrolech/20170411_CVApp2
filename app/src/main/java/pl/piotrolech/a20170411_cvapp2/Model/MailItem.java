package pl.piotrolech.a20170411_cvapp2.Model;

import android.content.Context;
import android.content.Intent;

import pl.piotrolech.a20170411_cvapp2.R;

/**
 * Created by olech on 13.04.2017.
 */

public class MailItem extends DataItem {

    public MailItem() {
        super(Data.MAIL, R.drawable.ic_mail_24dp);
    }

    @Override
    public void performAction(Context context) {
        String[] email = {Data.MAIL};
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setType("text/html");
        mailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, Data.MAILTITLE);
        context.startActivity(mailIntent);
    }
}
