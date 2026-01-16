package io.github.inflationx.calligraphy3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/* loaded from: classes3.dex */
public final class CalligraphyUtils {
    public static final int[] ANDROID_ATTR_TEXT_APPEARANCE = {android.R.attr.textAppearance};
    private static Boolean sAppCompatViewCheck;
    private static Boolean sToolbarCheck;

    public static CharSequence applyTypefaceSpan(CharSequence charSequence, Typeface typeface) {
        if (charSequence != null && charSequence.length() > 0) {
            if (!(charSequence instanceof Spannable)) {
                charSequence = new SpannableString(charSequence);
            }
            ((Spannable) charSequence).setSpan(TypefaceUtils.getSpan(typeface), 0, charSequence.length(), 33);
        }
        return charSequence;
    }

    public static boolean applyFontToTextView(TextView textView, Typeface typeface) {
        return applyFontToTextView(textView, typeface, false);
    }

    public static boolean applyFontToTextView(TextView textView, final Typeface typeface, boolean z) {
        if (textView == null || typeface == null) {
            return false;
        }
        textView.setPaintFlags(textView.getPaintFlags() | 128 | 1);
        textView.setTypeface(typeface);
        if (z) {
            textView.setText(applyTypefaceSpan(textView.getText(), typeface), TextView.BufferType.SPANNABLE);
            textView.addTextChangedListener(new TextWatcher() { // from class: io.github.inflationx.calligraphy3.CalligraphyUtils.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    CalligraphyUtils.applyTypefaceSpan(editable, typeface);
                }
            });
        }
        return true;
    }

    public static boolean applyFontToTextView(Context context, TextView textView, String str) {
        return applyFontToTextView(context, textView, str, false);
    }

    static boolean applyFontToTextView(Context context, TextView textView, String str, boolean z) {
        if (textView == null || context == null) {
            return false;
        }
        return applyFontToTextView(textView, TypefaceUtils.load(context.getAssets(), str), z);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig) {
        applyFontToTextView(context, textView, calligraphyConfig, false);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, boolean z) {
        if (context == null || textView == null || calligraphyConfig == null || !calligraphyConfig.isFontSet()) {
            return;
        }
        applyFontToTextView(context, textView, calligraphyConfig.getFontPath(), z);
    }

    public static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, String str) {
        applyFontToTextView(context, textView, calligraphyConfig, str, false);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, String str, boolean z) {
        if (context == null || textView == null || calligraphyConfig == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || !applyFontToTextView(context, textView, str, z)) {
            applyFontToTextView(context, textView, calligraphyConfig, z);
        }
    }

    static String pullFontPathFromView(Context context, AttributeSet attributeSet, int[] iArr) throws Resources.NotFoundException, NumberFormatException {
        String attributeValue;
        CharSequence charSequence;
        if (iArr != null && attributeSet != null) {
            try {
                String resourceEntryName = context.getResources().getResourceEntryName(iArr[0]);
                int attributeResourceValue = attributeSet.getAttributeResourceValue(null, resourceEntryName, -1);
                if (attributeResourceValue > 0) {
                    attributeValue = context.getString(attributeResourceValue);
                } else {
                    attributeValue = attributeSet.getAttributeValue(null, resourceEntryName);
                }
                if (attributeValue == null || !attributeValue.startsWith("?") || attributeValue.length() <= 1) {
                    return attributeValue;
                }
                String strSubstring = attributeValue.substring(1);
                if (!TextUtils.isDigitsOnly(strSubstring)) {
                    return attributeValue;
                }
                int i = Integer.parseInt(strSubstring);
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(i, typedValue, true);
                return (typedValue.type != 3 || (charSequence = typedValue.string) == null) ? attributeValue : charSequence.toString();
            } catch (Resources.NotFoundException unused) {
            }
        }
        return null;
    }

    static String pullFontPathFromStyle(Context context, AttributeSet attributeSet, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes;
        if (iArr != null && attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr)) != null) {
            try {
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    typedArrayObtainStyledAttributes.recycle();
                    return string;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        return null;
    }

    static String pullFontPathFromTextAppearance(Context context, AttributeSet attributeSet, int[] iArr) throws Resources.NotFoundException {
        if (iArr != null && attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ANDROID_ATTR_TEXT_APPEARANCE);
            int resourceId = -1;
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
                } catch (Exception unused) {
                    return null;
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, iArr);
            if (typedArrayObtainStyledAttributes2 != null) {
                try {
                    return typedArrayObtainStyledAttributes2.getString(0);
                } catch (Exception unused2) {
                } finally {
                    typedArrayObtainStyledAttributes2.recycle();
                }
            }
        }
        return null;
    }

    static String pullFontPathFromTheme(Context context, int i, int[] iArr) throws Resources.NotFoundException {
        if (i != -1 && iArr != null) {
            Resources.Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(i, typedValue, true);
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(typedValue.resourceId, iArr);
            try {
                return typedArrayObtainStyledAttributes.getString(0);
            } catch (Exception unused) {
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        return null;
    }

    static String pullFontPathFromTheme(Context context, int i, int i2, int[] iArr) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes;
        if (i != -1 && iArr != null) {
            Resources.Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(i, typedValue, true);
            TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(typedValue.resourceId, new int[]{i2});
            try {
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
                if (resourceId != -1 && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId, iArr)) != null) {
                    try {
                        return typedArrayObtainStyledAttributes.getString(0);
                    } catch (Exception unused) {
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
                return null;
            } catch (Exception unused2) {
            } finally {
                typedArrayObtainStyledAttributes2.recycle();
            }
        }
        return null;
    }

    static boolean canCheckForV7Toolbar() throws ClassNotFoundException {
        if (sToolbarCheck == null) {
            try {
                Class.forName("androidx.appcompat.widget.Toolbar");
                sToolbarCheck = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                sToolbarCheck = Boolean.FALSE;
            }
        }
        return sToolbarCheck.booleanValue();
    }

    static boolean canAddV7AppCompatViews() throws ClassNotFoundException {
        if (sAppCompatViewCheck == null) {
            try {
                Class.forName("androidx.appcompat.widget.AppCompatTextView");
                sAppCompatViewCheck = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                sAppCompatViewCheck = Boolean.FALSE;
            }
        }
        return sAppCompatViewCheck.booleanValue();
    }

    private CalligraphyUtils() {
    }
}
