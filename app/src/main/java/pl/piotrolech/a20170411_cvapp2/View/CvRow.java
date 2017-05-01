package pl.piotrolech.a20170411_cvapp2.View;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pl.piotrolech.a20170411_cvapp2.Model.DataItem;
import pl.piotrolech.a20170411_cvapp2.R;

/**
 * Created by olech on 13.04.2017.
 */

public class CvRow extends LinearLayout {

    public static final int ICONWIDTHDP = 24;
    public static final int ICONHEIGHTDP = 24;
    public static final int LAYOUTPADDINGLEFT = 16;
    public static final int LAYOUTPADDINGRIGHT = 16;
    public static final int LAYOUTPADDINGTOP = 0;
    public static final int LAYOUTPADDINGBOTTOM = 0;
    public static final int LAYOUTHEIGHTDP = 48;
    public static final int TEXT_SIZE = 16;
    public static final int TEXTPADDINGLEFTDP = 32;
    public static final int TEXTPADDINGTOPDP = 0;
    public static final int TEXTPADDINGRIGHTDP = 0;
    public static final int TEXTPADDINGBOTTOMDP = 0;

    public CvRow(final Context context, final DataItem dataItem) {
        super(context);
        setupLayout(context);
        ImageView iconContainer = setupIcon(context, dataItem);
        TextView textContainer = setupText(context, dataItem);
        createView(iconContainer, textContainer);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dataItem.performAction(context);
            }
        });
    }

    private void createView(ImageView iconContainer, TextView textContainer) {
        this.addView(iconContainer);
        this.addView(textContainer);
    }

    private TextView setupText(Context context, DataItem dataItem) {
        TextView textContainer = new TextView(context);
        textContainer.setText(dataItem.getText());

        textContainer.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textContainer.setTextSize(TEXT_SIZE);
        textContainer.setGravity(Gravity.CENTER_VERTICAL);
        textContainer.setPadding(dpToPx(
                context, TEXTPADDINGLEFTDP), TEXTPADDINGTOPDP, TEXTPADDINGRIGHTDP, TEXTPADDINGBOTTOMDP);

        return textContainer;
    }

    private ImageView setupIcon(Context context, DataItem dataItem) {
        ImageView iconContainer = new ImageView(context);
        iconContainer.setImageResource(dataItem.getIcon());

        LayoutParams iconContainerParams = new LayoutParams(dpToPx(context, ICONWIDTHDP),
                dpToPx(context, ICONHEIGHTDP));
        iconContainerParams.gravity = Gravity.CENTER_VERTICAL;
        iconContainer.setLayoutParams(iconContainerParams);
        iconContainer.setColorFilter(ContextCompat.getColor(context, R.color.accent));

        return iconContainer;
    }

    private void setupLayout(Context context) {
        this.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(context, LAYOUTHEIGHTDP)));
        this.setPadding(dpToPx(context, LAYOUTPADDINGLEFT), LAYOUTPADDINGTOP,
                dpToPx(context, LAYOUTPADDINGRIGHT), LAYOUTPADDINGBOTTOM);
        this.setOrientation(LinearLayout.HORIZONTAL);
        setClickableBackground(context);
    }

    private void setClickableBackground(Context context) {
        this.setClickable(true);
        int[] attrs = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        this.setBackgroundResource(backgroundResource);
        typedArray.recycle();
    }

    private int dpToPx(Context context, int dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

}
