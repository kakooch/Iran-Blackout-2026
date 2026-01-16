package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.List;

/* loaded from: classes3.dex */
public class GraySectionCell extends FrameLayout {
    private final Theme.ResourcesProvider resourcesProvider;
    private TextView rightTextView;
    private TextView textView;

    public GraySectionCell(Context context) {
        this(context, null);
    }

    public GraySectionCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.resourcesProvider = resourcesProvider;
        setBackgroundColor(getThemedColor("graySection"));
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setTextSize(1, 14.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setTextColor(getThemedColor("key_graySectionText"));
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, (LocaleController.isRTL ? 5 : 3) | 48, 16.0f, 0.0f, 16.0f, 0.0f));
        TextView textView2 = new TextView(getContext()) { // from class: ir.eitaa.ui.Cells.GraySectionCell.1
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        this.rightTextView = textView2;
        textView2.setTextSize(1, 14.0f);
        this.rightTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.rightTextView.setTextColor(getThemedColor("key_graySectionText"));
        this.rightTextView.setGravity((LocaleController.isRTL ? 3 : 5) | 16);
        addView(this.rightTextView, LayoutHelper.createFrame(-2, -1.0f, (LocaleController.isRTL ? 3 : 5) | 48, 16.0f, 0.0f, 16.0f, 0.0f));
        ViewCompat.setAccessibilityHeading(this, true);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
    }

    public void setTextColor(String key) {
        int themedColor = getThemedColor(key);
        this.textView.setTextColor(themedColor);
        this.rightTextView.setTextColor(themedColor);
    }

    public void setText(String text) {
        this.textView.setText(text);
        this.rightTextView.setVisibility(8);
    }

    public void setText(String left, String right, View.OnClickListener onClickListener) {
        this.textView.setText(left);
        this.rightTextView.setText(right);
        this.rightTextView.setOnClickListener(onClickListener);
        this.rightTextView.setVisibility(0);
    }

    public void settextSize(int textSize) {
        this.textView.setTextSize(1, textSize);
    }

    public static void createThemeDescriptions(List<ThemeDescription> descriptions, RecyclerListView listView) {
        descriptions.add(new ThemeDescription(listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        descriptions.add(new ThemeDescription(listView, 0, new Class[]{GraySectionCell.class}, new String[]{"rightTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        descriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
    }

    public TextView getTextView() {
        return this.textView;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
