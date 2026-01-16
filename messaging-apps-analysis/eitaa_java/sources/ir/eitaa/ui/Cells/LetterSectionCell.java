package ir.eitaa.ui.Cells;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class LetterSectionCell extends FrameLayout {
    private TextView textView;

    public LetterSectionCell(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(AndroidUtilities.dp(54.0f), AndroidUtilities.dp(64.0f)));
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setTextSize(1, 22.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
        this.textView.setGravity(17);
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f));
    }

    public void setLetter(String letter) {
        this.textView.setText(letter.toUpperCase());
    }

    public void setCellHeight(int height) {
        setLayoutParams(new ViewGroup.LayoutParams(AndroidUtilities.dp(54.0f), height));
    }
}
