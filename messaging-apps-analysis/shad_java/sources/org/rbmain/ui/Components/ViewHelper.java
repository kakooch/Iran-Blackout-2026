package org.rbmain.ui.Components;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public final class ViewHelper {
    public static void setPadding(View view, float f, float f2, float f3, float f4) {
        view.setPadding(AndroidUtilities.dp(f), AndroidUtilities.dp(f2), AndroidUtilities.dp(f3), AndroidUtilities.dp(f4));
    }

    public static void setPaddingRelative(View view, float f, float f2, float f3, float f4) {
        boolean z = LocaleController.isRTL;
        float f5 = z ? f3 : f;
        if (!z) {
            f = f3;
        }
        setPadding(view, f5, f2, f, f4);
    }

    public static TextView createTextViewBlack(Context context, int i, boolean z) {
        return createTextView(context, i, Theme.getColor(Theme.key_dialogTextBlack), z);
    }

    public static TextView createTextViewGray(Context context, int i, boolean z) {
        return createTextView(context, i, Theme.getColor(Theme.key_dialogTextGray3), z);
    }

    public static TextView createTextView(Context context, int i, int i2, boolean z) {
        TextView textView = new TextView(context);
        textView.setTextColor(i2);
        textView.setTextSize(i);
        if (z) {
            textView.setTypeface(Theme.getHomePageTypeFaceBold());
        } else {
            textView.setTypeface(Theme.getHomePageTypeFaceRegular());
        }
        return textView;
    }

    public static EditText createEditTextBlack(Context context, int i, boolean z) {
        return createEditText(context, i, Theme.getColor(Theme.key_dialogTextBlack), z);
    }

    public static EditText createEditText(Context context, int i, int i2, boolean z) {
        EditText editText = new EditText(context);
        editText.setTextColor(i2);
        editText.setTextSize(i);
        if (z) {
            editText.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebbold.ttf"));
        } else {
            editText.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebregular.ttf"));
        }
        return editText;
    }

    public static TextView createShopTextView(Context context, int i, int i2, boolean z) {
        TextView textView = new TextView(context);
        textView.setTextColor(i2);
        textView.setTextSize(i);
        if (z) {
            textView.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebbold.ttf"));
        } else {
            textView.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebregular.ttf"));
        }
        return textView;
    }

    public static void addEditTextCostFormat(EditText editText) {
        addEditTextCostFormat(editText, ",");
    }

    public static void addEditTextCostFormat(final EditText editText, final CharSequence charSequence) {
        editText.setInputType(3);
        editText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.Components.ViewHelper.1
            CharSequence current;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence2, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence2, int i, int i2, int i3) {
                if (charSequence2.toString().equals(this.current)) {
                    return;
                }
                if (i2 == 0) {
                    i++;
                }
                editText.removeTextChangedListener(this);
                String costFormat = LocaleController.setCostFormat(charSequence2.toString().replace(charSequence, BuildConfig.FLAVOR), charSequence);
                this.current = costFormat;
                editText.setText(costFormat);
                int length = i + (costFormat.length() - charSequence2.length());
                if (length < 0) {
                    length = 0;
                }
                if (length > costFormat.length()) {
                    length = costFormat.length();
                }
                editText.setSelection(length);
                editText.addTextChangedListener(this);
            }
        });
    }
}
