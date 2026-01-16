package org.rbmain.ui.Components;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class PickerBottomLayout extends FrameLayout {
    public TextView cancelButton;
    public LinearLayout doneButton;
    public TextView doneButtonBadgeTextView;
    public TextView doneButtonTextView;

    public PickerBottomLayout(Context context, boolean z) {
        super(context);
        setBackgroundColor(Theme.getColor(z ? Theme.key_dialogBackground : Theme.key_windowBackgroundWhite));
        TextView textView = new TextView(context);
        this.cancelButton = textView;
        textView.setTextSize(1, 14.0f);
        TextView textView2 = this.cancelButton;
        int i = Theme.key_picker_enabledButton;
        textView2.setTextColor(Theme.getColor(i));
        this.cancelButton.setGravity(17);
        this.cancelButton.setBackgroundDrawable(Theme.createSelectorDrawable(251658240, 0));
        this.cancelButton.setPadding(AndroidUtilities.dp(33.0f), 0, AndroidUtilities.dp(33.0f), 0);
        this.cancelButton.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        this.cancelButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        addView(this.cancelButton, LayoutHelper.createFrame(-2, -1, 51));
        LinearLayout linearLayout = new LinearLayout(context);
        this.doneButton = linearLayout;
        linearLayout.setOrientation(0);
        this.doneButton.setBackgroundDrawable(Theme.createSelectorDrawable(251658240, 0));
        this.doneButton.setPadding(AndroidUtilities.dp(33.0f), 0, AndroidUtilities.dp(33.0f), 0);
        addView(this.doneButton, LayoutHelper.createFrame(-2, -1, 53));
        TextView textView3 = new TextView(context);
        this.doneButtonBadgeTextView = textView3;
        textView3.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.doneButtonBadgeTextView.setTextSize(1, 13.0f);
        this.doneButtonBadgeTextView.setTextColor(Theme.getColor(Theme.key_picker_badgeText));
        this.doneButtonBadgeTextView.setGravity(17);
        this.doneButtonBadgeTextView.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(11.0f), Theme.getColor(Theme.key_picker_badge)));
        this.doneButtonBadgeTextView.setMinWidth(AndroidUtilities.dp(23.0f));
        this.doneButtonBadgeTextView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), AndroidUtilities.dp(1.0f));
        this.doneButton.addView(this.doneButtonBadgeTextView, LayoutHelper.createLinear(-2, 23, 16, 0, 0, 10, 0));
        TextView textView4 = new TextView(context);
        this.doneButtonTextView = textView4;
        textView4.setTextSize(1, 14.0f);
        this.doneButtonTextView.setTextColor(Theme.getColor(i));
        this.doneButtonTextView.setGravity(17);
        this.doneButtonTextView.setCompoundDrawablePadding(AndroidUtilities.dp(8.0f));
        this.doneButtonTextView.setText(LocaleController.getString("Send", R.string.Send).toUpperCase());
        this.doneButtonTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.doneButton.addView(this.doneButtonTextView, LayoutHelper.createLinear(-2, -2, 16));
    }

    public void updateSelectedCount(int i, boolean z) {
        if (i == 0) {
            this.doneButtonBadgeTextView.setVisibility(8);
            if (z) {
                TextView textView = this.doneButtonTextView;
                int i2 = Theme.key_picker_disabledButton;
                textView.setTag(Integer.valueOf(i2));
                this.doneButtonTextView.setTextColor(Theme.getColor(i2));
                this.doneButton.setEnabled(false);
                return;
            }
            TextView textView2 = this.doneButtonTextView;
            int i3 = Theme.key_picker_enabledButton;
            textView2.setTag(Integer.valueOf(i3));
            this.doneButtonTextView.setTextColor(Theme.getColor(i3));
            return;
        }
        this.doneButtonBadgeTextView.setVisibility(0);
        this.doneButtonBadgeTextView.setText(String.format("%d", Integer.valueOf(i)));
        TextView textView3 = this.doneButtonTextView;
        int i4 = Theme.key_picker_enabledButton;
        textView3.setTag(Integer.valueOf(i4));
        this.doneButtonTextView.setTextColor(Theme.getColor(i4));
        if (z) {
            this.doneButton.setEnabled(true);
        }
    }
}
