package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TextInfoPrivacyCell extends FrameLayout {
    private int bottomPadding;
    private int fixedSize;
    private String linkTextColorKey;
    private final Theme.ResourcesProvider resourcesProvider;
    private CharSequence text;
    private TextView textView;
    private int topPadding;

    protected void afterTextDraw() {
    }

    protected void onTextDraw() {
    }

    public TextInfoPrivacyCell(Context context) {
        this(context, 21, null);
    }

    public TextInfoPrivacyCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        this(context, 21, resourcesProvider);
    }

    public TextInfoPrivacyCell(Context context, int padding) {
        this(context, padding, null);
    }

    public TextInfoPrivacyCell(Context context, int padding, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.linkTextColorKey = "windowBackgroundWhiteLinkText";
        this.topPadding = 10;
        this.bottomPadding = 17;
        this.resourcesProvider = resourcesProvider;
        TextView textView = new TextView(context) { // from class: ir.eitaa.ui.Cells.TextInfoPrivacyCell.1
            @Override // android.widget.TextView, android.view.View
            protected void onDraw(Canvas canvas) {
                TextInfoPrivacyCell.this.onTextDraw();
                super.onDraw(canvas);
                TextInfoPrivacyCell.this.afterTextDraw();
            }
        };
        this.textView = textView;
        textView.setTextSize(1, 14.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.textView.setPadding(0, AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(17.0f));
        this.textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.textView.setTextColor(getThemedColor("windowBackgroundWhiteGrayText4"));
        this.textView.setLinkTextColor(getThemedColor(this.linkTextColorKey));
        this.textView.setImportantForAccessibility(2);
        float f = padding;
        addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, f, 0.0f, f, 0.0f));
    }

    public void setLinkTextColorKey(String key) {
        this.linkTextColorKey = key;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.fixedSize != 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.fixedSize), 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    public void setTopPadding(int topPadding) {
        this.topPadding = topPadding;
    }

    public void setBottomPadding(int value) {
        this.bottomPadding = value;
    }

    public void setFixedSize(int size) {
        this.fixedSize = size;
    }

    public void setText(CharSequence text) {
        if (TextUtils.equals(text, this.text)) {
            return;
        }
        this.text = text;
        if (text == null) {
            this.textView.setPadding(0, AndroidUtilities.dp(2.0f), 0, 0);
        } else {
            this.textView.setPadding(0, AndroidUtilities.dp(this.topPadding), 0, AndroidUtilities.dp(this.bottomPadding));
        }
        SpannableString spannableString = null;
        if (text != null) {
            int length = text.length();
            for (int i = 0; i < length - 1; i++) {
                if (text.charAt(i) == '\n') {
                    int i2 = i + 1;
                    if (text.charAt(i2) == '\n') {
                        if (spannableString == null) {
                            spannableString = new SpannableString(text);
                        }
                        spannableString.setSpan(new AbsoluteSizeSpan(10, true), i2, i + 2, 33);
                    }
                }
            }
        }
        TextView textView = this.textView;
        if (spannableString != null) {
            text = spannableString;
        }
        textView.setText(text);
    }

    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public void setTextColor(String key) {
        this.textView.setTextColor(getThemedColor(key));
        this.textView.setTag(key);
    }

    public TextView getTextView() {
        return this.textView;
    }

    public int length() {
        return this.textView.length();
    }

    public void setEnabled(boolean value, ArrayList<Animator> animators) {
        if (animators != null) {
            TextView textView = this.textView;
            float[] fArr = new float[1];
            fArr[0] = value ? 1.0f : 0.5f;
            animators.add(ObjectAnimator.ofFloat(textView, "alpha", fArr));
            return;
        }
        this.textView.setAlpha(value ? 1.0f : 0.5f);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(TextView.class.getName());
        info.setText(this.text);
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
