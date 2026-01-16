package ir.eitaa.ui.Components;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PickerBottomLayoutViewer extends FrameLayout {
    public TextView cancelButton;
    public TextView doneButton;
    public TextView doneButtonBadgeTextView;
    private boolean isDarkTheme;

    public PickerBottomLayoutViewer(Context context) {
        this(context, true);
    }

    public PickerBottomLayoutViewer(Context context, boolean darkTheme) {
        super(context);
        this.isDarkTheme = darkTheme;
        setBackgroundColor(darkTheme ? -15066598 : -1);
        TextView textView = new TextView(context);
        this.cancelButton = textView;
        textView.setTextSize(1, 14.0f);
        this.cancelButton.setTextColor(this.isDarkTheme ? -1 : -15095832);
        this.cancelButton.setGravity(17);
        this.cancelButton.setBackgroundDrawable(Theme.createSelectorDrawable(this.isDarkTheme ? -12763843 : 788529152, 0));
        this.cancelButton.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.cancelButton.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        this.cancelButton.setTypeface(AndroidUtilities.getFontFamily(true));
        addView(this.cancelButton, LayoutHelper.createFrame(-2, -1, 51));
        TextView textView2 = new TextView(context);
        this.doneButton = textView2;
        textView2.setTextSize(1, 14.0f);
        this.doneButton.setTextColor(this.isDarkTheme ? -1 : -15095832);
        this.doneButton.setGravity(17);
        this.doneButton.setBackgroundDrawable(Theme.createSelectorDrawable(this.isDarkTheme ? -12763843 : 788529152, 0));
        this.doneButton.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.doneButton.setText(LocaleController.getString("Send", R.string.Send).toUpperCase());
        this.doneButton.setTypeface(AndroidUtilities.getFontFamily(true));
        addView(this.doneButton, LayoutHelper.createFrame(-2, -1, 53));
        TextView textView3 = new TextView(context);
        this.doneButtonBadgeTextView = textView3;
        textView3.setTypeface(AndroidUtilities.getFontFamily(true));
        this.doneButtonBadgeTextView.setTextSize(1, 13.0f);
        this.doneButtonBadgeTextView.setTextColor(-1);
        this.doneButtonBadgeTextView.setGravity(17);
        this.doneButtonBadgeTextView.setBackgroundResource(this.isDarkTheme ? R.drawable.photobadge : R.drawable.bluecounter);
        this.doneButtonBadgeTextView.setMinWidth(AndroidUtilities.dp(23.0f));
        this.doneButtonBadgeTextView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), AndroidUtilities.dp(1.0f));
        addView(this.doneButtonBadgeTextView, LayoutHelper.createFrame(-2, 23.0f, 53, 0.0f, 0.0f, 7.0f, 0.0f));
    }

    public void updateSelectedCount(int count, boolean disable) {
        if (count == 0) {
            this.doneButtonBadgeTextView.setVisibility(8);
            if (disable) {
                this.doneButton.setTextColor(-6710887);
                this.doneButton.setEnabled(false);
                return;
            } else {
                this.doneButton.setTextColor(this.isDarkTheme ? -1 : -15095832);
                return;
            }
        }
        this.doneButtonBadgeTextView.setVisibility(0);
        this.doneButtonBadgeTextView.setText(String.format("%d", Integer.valueOf(count)));
        this.doneButton.setTextColor(this.isDarkTheme ? -1 : -15095832);
        if (disable) {
            this.doneButton.setEnabled(true);
        }
    }
}
