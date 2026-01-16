package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaVenue;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class LocationCell extends FrameLayout {
    private TextView addressTextView;
    private ShapeDrawable circleDrawable;
    private BackupImageView imageView;
    private TextView nameTextView;
    private boolean needDivider;
    private final Theme.ResourcesProvider resourcesProvider;
    private boolean wrapContent;

    public LocationCell(Context context, boolean wrap, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.resourcesProvider = resourcesProvider;
        this.wrapContent = wrap;
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        ShapeDrawable shapeDrawableCreateCircleDrawable = Theme.createCircleDrawable(AndroidUtilities.dp(42.0f), -1);
        this.circleDrawable = shapeDrawableCreateCircleDrawable;
        backupImageView.setBackground(shapeDrawableCreateCircleDrawable);
        this.imageView.setSize(AndroidUtilities.dp(30.0f), AndroidUtilities.dp(30.0f));
        BackupImageView backupImageView2 = this.imageView;
        boolean z = LocaleController.isRTL;
        addView(backupImageView2, LayoutHelper.createFrame(42, 42.0f, (z ? 5 : 3) | 48, z ? 0.0f : 15.0f, 11.0f, z ? 15.0f : 0.0f, 0.0f));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTextSize(1, 16.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setTextColor(getThemedColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        TextView textView2 = this.nameTextView;
        boolean z2 = LocaleController.isRTL;
        addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 16 : 73, 10.0f, z2 ? 73 : 16, 0.0f));
        TextView textView3 = new TextView(context);
        this.addressTextView = textView3;
        textView3.setTextSize(1, 14.0f);
        this.addressTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.addressTextView.setMaxLines(1);
        this.addressTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.addressTextView.setSingleLine(true);
        this.addressTextView.setTextColor(getThemedColor("windowBackgroundWhiteGrayText3"));
        this.addressTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        TextView textView4 = this.addressTextView;
        boolean z3 = LocaleController.isRTL;
        addView(textView4, LayoutHelper.createFrame(-2, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 16 : 73, 35.0f, z3 ? 73 : 16, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.wrapContent) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.needDivider ? 1 : 0), 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.needDivider ? 1 : 0), 1073741824));
        }
    }

    public BackupImageView getImageView() {
        return this.imageView;
    }

    public void setLocation(TLRPC$TL_messageMediaVenue location, String icon, int pos, boolean divider) {
        setLocation(location, icon, null, pos, divider);
    }

    public static int getColorForIndex(int index) {
        int i = index % 7;
        if (i == 0) {
            return -1351584;
        }
        if (i == 1) {
            return -868277;
        }
        if (i == 2) {
            return -12214795;
        }
        if (i == 3) {
            return -13187226;
        }
        if (i != 4) {
            return i != 5 ? -1285237 : -12338729;
        }
        return -7900675;
    }

    public void setLocation(TLRPC$TL_messageMediaVenue location, String icon, String label, int pos, boolean divider) {
        this.needDivider = divider;
        this.circleDrawable.getPaint().setColor(getColorForIndex(pos));
        this.nameTextView.setText(location.title);
        if (label != null) {
            this.addressTextView.setText(label);
        } else {
            this.addressTextView.setText(location.address);
        }
        this.imageView.setImage(icon, null, null);
        setWillNotDraw(!divider);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(AndroidUtilities.dp(72.0f), getHeight() - 1, getWidth(), getHeight() - 1, Theme.dividerPaint);
        }
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
