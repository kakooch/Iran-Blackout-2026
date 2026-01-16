package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class HeaderCell extends FrameLayout {
    private int height;
    private final Theme.ResourcesProvider resourcesProvider;
    private TextView textView;
    private SimpleTextView textView2;

    public HeaderCell(Context context) {
        this(context, "windowBackgroundWhiteBlueHeader", 21, 15, false, null);
    }

    public HeaderCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        this(context, "windowBackgroundWhiteBlueHeader", 21, 15, false, resourcesProvider);
    }

    public HeaderCell(Context context, int padding) {
        this(context, "windowBackgroundWhiteBlueHeader", padding, 15, false, null);
    }

    public HeaderCell(Context context, String textColorKey, int padding, int topMargin, boolean text2) {
        this(context, textColorKey, padding, topMargin, text2, null);
    }

    public HeaderCell(Context context, String textColorKey, int padding, int topMargin, boolean text2, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.height = 40;
        this.resourcesProvider = resourcesProvider;
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setTextSize(1, 15.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.textView.setMinHeight(AndroidUtilities.dp(this.height - topMargin));
        this.textView.setTextColor(getThemedColor(textColorKey));
        this.textView.setTag(textColorKey);
        float f = padding;
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, (LocaleController.isRTL ? 5 : 3) | 48, f, topMargin, f, 0.0f));
        if (text2) {
            SimpleTextView simpleTextView = new SimpleTextView(getContext());
            this.textView2 = simpleTextView;
            simpleTextView.setTextSize(13);
            this.textView2.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView2.setGravity((LocaleController.isRTL ? 3 : 5) | 48);
            addView(this.textView2, LayoutHelper.createFrame(-1, -1.0f, (LocaleController.isRTL ? 3 : 5) | 48, f, 21.0f, f, 0.0f));
        }
        ViewCompat.setAccessibilityHeading(this, true);
    }

    public void setHeight(int value) {
        TextView textView = this.textView;
        this.height = value;
        textView.setMinHeight(AndroidUtilities.dp(value) - ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).topMargin);
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

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public void setText(CharSequence text) {
        this.textView.setText(text);
    }

    public void setText2(CharSequence text) {
        SimpleTextView simpleTextView = this.textView2;
        if (simpleTextView == null) {
            return;
        }
        simpleTextView.setText(text);
    }

    public TextView getTextView() {
        return this.textView;
    }

    public SimpleTextView getTextView2() {
        return this.textView2;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        super.onInitializeAccessibilityNodeInfo(info);
        info.setContentDescription("عنوان، " + ((Object) this.textView.getText()));
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = info.getCollectionItemInfo()) == null) {
            return;
        }
        info.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(collectionItemInfo.getRowIndex(), collectionItemInfo.getRowSpan(), collectionItemInfo.getColumnIndex(), collectionItemInfo.getColumnSpan(), true));
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
