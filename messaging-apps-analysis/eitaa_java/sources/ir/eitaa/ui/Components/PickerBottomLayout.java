package ir.eitaa.ui.Components;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PickerBottomLayout extends FrameLayout {
    public TextView cancelButton;
    public LinearLayout doneButton;
    public TextView doneButtonBadgeTextView;
    public TextView doneButtonTextView;

    public PickerBottomLayout(Context context, boolean darkTheme) {
        super(context);
        setBackgroundColor(Theme.getColor(darkTheme ? "dialogBackground" : "windowBackgroundWhite"));
        TextView textView = new TextView(context);
        this.cancelButton = textView;
        textView.setTextSize(1, 14.0f);
        this.cancelButton.setTextColor(Theme.getColor("picker_enabledButton"));
        this.cancelButton.setGravity(17);
        this.cancelButton.setBackgroundDrawable(Theme.createSelectorDrawable(251658240, 0));
        this.cancelButton.setPadding(AndroidUtilities.dp(33.0f), 0, AndroidUtilities.dp(33.0f), 0);
        this.cancelButton.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        this.cancelButton.setTypeface(AndroidUtilities.getFontFamily(true));
        addView(this.cancelButton, LayoutHelper.createFrame(-2, -1, 51));
        LinearLayout linearLayout = new LinearLayout(context);
        this.doneButton = linearLayout;
        linearLayout.setOrientation(0);
        this.doneButton.setBackgroundDrawable(Theme.createSelectorDrawable(251658240, 0));
        this.doneButton.setPadding(AndroidUtilities.dp(33.0f), 0, AndroidUtilities.dp(33.0f), 0);
        addView(this.doneButton, LayoutHelper.createFrame(-2, -1, 53));
        TextView textView2 = new TextView(context);
        this.doneButtonBadgeTextView = textView2;
        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
        this.doneButtonBadgeTextView.setTextSize(1, 13.0f);
        this.doneButtonBadgeTextView.setTextColor(Theme.getColor("picker_badgeText"));
        this.doneButtonBadgeTextView.setGravity(17);
        this.doneButtonBadgeTextView.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(11.0f), Theme.getColor("picker_badge")));
        this.doneButtonBadgeTextView.setMinWidth(AndroidUtilities.dp(23.0f));
        this.doneButtonBadgeTextView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), AndroidUtilities.dp(1.0f));
        this.doneButton.addView(this.doneButtonBadgeTextView, LayoutHelper.createLinear(-2, 23, 16, 0, 0, 10, 0));
        TextView textView3 = new TextView(context);
        this.doneButtonTextView = textView3;
        textView3.setTextSize(1, 14.0f);
        this.doneButtonTextView.setTextColor(Theme.getColor("picker_enabledButton"));
        this.doneButtonTextView.setGravity(17);
        this.doneButtonTextView.setCompoundDrawablePadding(AndroidUtilities.dp(8.0f));
        this.doneButtonTextView.setText(LocaleController.getString("Send", R.string.Send).toUpperCase());
        this.doneButtonTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.doneButton.addView(this.doneButtonTextView, LayoutHelper.createLinear(-2, -2, 16));
    }
}
