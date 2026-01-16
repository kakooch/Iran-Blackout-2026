package ir.resaneh1.iptv.helper;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class InputFilterHelper {
    public static InputFilter[] getFilter(int i, final int i2, final View view) {
        return new InputFilter[]{new InputFilter.LengthFilter(i) { // from class: ir.resaneh1.iptv.helper.InputFilterHelper.1
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i3, int i4, Spanned spanned, int i5, int i6) {
                View view2;
                if (charSequence != null && TextUtils.indexOf(charSequence, '\n') != -1) {
                    int length = spanned.length() - spanned.toString().replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR).length();
                    if ((charSequence.length() - charSequence.toString().replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR).length()) + length >= i2) {
                        View view3 = view;
                        if (view3 != null) {
                            AndroidUtilities.shakeView(view3, 2.0f, 0);
                        }
                        int i7 = i2 - length;
                        if (i7 > 0) {
                            int i8 = 0;
                            int iIndexOf = 0;
                            for (int i9 = 0; i9 < i7; i9++) {
                                try {
                                    if (iIndexOf < charSequence.length() && (iIndexOf = TextUtils.indexOf(charSequence, '\n', iIndexOf + 1)) > 0) {
                                        i8 = iIndexOf;
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            return charSequence.subSequence(0, i8);
                        }
                        return BuildConfig.FLAVOR;
                    }
                }
                CharSequence charSequenceFilter = super.filter(charSequence, i3, i4, spanned, i5, i6);
                if (charSequenceFilter != null && charSequence != null && charSequenceFilter.length() != charSequence.length() && (view2 = view) != null) {
                    AndroidUtilities.shakeView(view2, 2.0f, 0);
                }
                return charSequenceFilter;
            }
        }};
    }

    public static InputFilter[] getFilterMaxLine(final int i, final View view) {
        return new InputFilter[]{new InputFilter() { // from class: ir.resaneh1.iptv.helper.InputFilterHelper.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                if (charSequence == null || TextUtils.indexOf(charSequence, '\n') == -1 || spanned.length() - spanned.toString().replace("\n", BuildConfig.FLAVOR).replace("\r", BuildConfig.FLAVOR).length() < i - 1) {
                    return charSequence;
                }
                View view2 = view;
                if (view2 != null) {
                    AndroidUtilities.shakeView(view2, 2.0f, 0);
                }
                return BuildConfig.FLAVOR;
            }
        }};
    }

    public static InputFilter[] getFilterMaxChar(int i, final View view) {
        return new InputFilter[]{new InputFilter.LengthFilter(i) { // from class: ir.resaneh1.iptv.helper.InputFilterHelper.3
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                View view2;
                CharSequence charSequenceFilter = super.filter(charSequence, i2, i3, spanned, i4, i5);
                if (charSequenceFilter != null && charSequence != null && charSequenceFilter.length() != charSequence.length() && (view2 = view) != null) {
                    AndroidUtilities.shakeView(view2, 2.0f, 0);
                }
                return charSequenceFilter;
            }
        }};
    }
}
