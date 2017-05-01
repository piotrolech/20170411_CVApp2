package pl.piotrolech.a20170411_cvapp2.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import pl.piotrolech.a20170411_cvapp2.R;

/**
 * Created by olech on 13.04.2017.
 */

public class GithubItem extends DataItem {

    private Uri uri;

    public GithubItem() {
        super(Data.GITHUBTITLE, R.drawable.github);
        uri = Uri.parse(Data.GITHUB);
    }

    @Override
    public void performAction(Context context) {
        Intent githubIntent = new Intent(Intent.ACTION_VIEW);
        githubIntent.setData(uri);
        context.startActivity(githubIntent);
    }
}
