package pl.piotrolech.a20170411_cvapp2.Fragments;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.piotrolech.a20170411_cvapp2.Model.GithubItem;
import pl.piotrolech.a20170411_cvapp2.Model.LinkedInItem;
import pl.piotrolech.a20170411_cvapp2.Model.MailItem;
import pl.piotrolech.a20170411_cvapp2.Model.NameItem;
import pl.piotrolech.a20170411_cvapp2.Model.PhoneItem;
import pl.piotrolech.a20170411_cvapp2.R;
import pl.piotrolech.a20170411_cvapp2.View.CvRow;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @BindView(R.id.mainFragmentRowHolder)
    LinearLayout rowHolder;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        setupRows();

        return view;
    }

    @OnClick(R.id.showButton)
    public void showCV() {

        Intent showCvIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.rivingtonshoreditch.co.uk/media/1075/test.pdf"));
        startActivity(showCvIntent);
    }

    @OnClick(R.id.downloadButton)
    public void downloadCV(){
        Toast.makeText(getContext(),"Downloading CV", Toast.LENGTH_LONG).show();
    }

    private void setupRows() {
        CvRow nameRow = new CvRow(getContext(), new NameItem());
        CvRow phoneRow = new CvRow(getContext(), new PhoneItem());
        CvRow mailRow = new CvRow(getContext(), new MailItem());
        CvRow gitRow = new CvRow(getContext(), new GithubItem());
        CvRow linkedInRow = new CvRow(getContext(), new LinkedInItem());
        rowHolder.addView(nameRow);
        rowHolder.addView(phoneRow);
        rowHolder.addView(mailRow);
        rowHolder.addView(gitRow);
        rowHolder.addView(linkedInRow);
    }

    public static MainFragment newInstance() {

        MainFragment fragment = new MainFragment();
        return fragment;
    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        String filepath;

        @Override
        protected String doInBackground(String... params) {
            try {
                String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                File folder = new File(extStorageDirectory, "IFIN-PDF");
                folder.mkdir();
                filepath = "ISFL-" + new Date().getDate() + new Date().getMonth() +
                        new Date().getYear() + ".pdf";
                File file = new File(extStorageDirectory, filepath);
                try {
                    file.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                downloadFile("https://www.rivingtonshoreditch.co.uk/media/1075/test.pdf", file);
            } catch (Exception e) {
            }
            return filepath;
        }

        @Override
        protected void onPostExecute(String result) {

//        ProgressClass.progressClose();

            File file = new File(Environment.getExternalStorageDirectory()
                    + "/IFIN-PDF/" + result);

            PackageManager packageManager = getActivity().getPackageManager();
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setType("application/pdf");
            List list = packageManager.queryIntentActivities(pdfIntent,
                    PackageManager.MATCH_DEFAULT_ONLY);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(file);
            intent.setDataAndType(uri, "application/pdf");
            startActivity(intent);

        }

        @Override
        protected void onPreExecute() {

//            ProgressClass.progressShow(downloadPDF.this, "Connecting");
        }

        private void downloadFile(String fileURL, File directory) {
            try {
                FileOutputStream file = new FileOutputStream(directory);
                URL url = new URL(fileURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoOutput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = input.read(buffer)) > 0) {
                    file.write(buffer, 0, len);
                }
                file.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
