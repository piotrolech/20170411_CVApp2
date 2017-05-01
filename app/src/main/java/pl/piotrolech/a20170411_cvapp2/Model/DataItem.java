package pl.piotrolech.a20170411_cvapp2.Model;

import android.content.Context;

/**
 * Created by olech on 13.04.2017.
 */

public abstract class DataItem {
    private String text;
    private int icon;

    public DataItem(String text, int icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public int getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public abstract void performAction(Context context);
}
