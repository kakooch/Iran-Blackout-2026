package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.tgnet.TLRPC$TL_messageMediaVenue;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class LocationCell extends FrameLayout {
    private TextView addressTextView;
    private ShapeDrawable circleDrawable;
    private BackupImageView imageView;
    private TextView nameTextView;
    private boolean needDivider;
    private boolean wrapContent;

    public LocationCell(Context context, boolean z) {
        super(context);
        this.wrapContent = z;
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        ShapeDrawable shapeDrawableCreateCircleDrawable = Theme.createCircleDrawable(AndroidUtilities.dp(42.0f), -1);
        this.circleDrawable = shapeDrawableCreateCircleDrawable;
        backupImageView.setBackground(shapeDrawableCreateCircleDrawable);
        this.imageView.setSize(AndroidUtilities.dp(30.0f), AndroidUtilities.dp(30.0f));
        BackupImageView backupImageView2 = this.imageView;
        boolean z2 = LocaleController.isRTL;
        addView(backupImageView2, LayoutHelper.createFrame(42, 42.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 15.0f, 11.0f, z2 ? 15.0f : 0.0f, 0.0f));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTextSize(1, 16.0f);
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.nameTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        TextView textView2 = this.nameTextView;
        boolean z3 = LocaleController.isRTL;
        addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 16 : 73, 10.0f, z3 ? 73 : 16, 0.0f));
        TextView textView3 = new TextView(context);
        this.addressTextView = textView3;
        textView3.setTextSize(1, 14.0f);
        this.addressTextView.setMaxLines(1);
        this.addressTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.addressTextView.setSingleLine(true);
        this.addressTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
        this.addressTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        TextView textView4 = this.addressTextView;
        boolean z4 = LocaleController.isRTL;
        addView(textView4, LayoutHelper.createFrame(-2, -2.0f, (z4 ? 5 : 3) | 48, z4 ? 16 : 73, 35.0f, z4 ? 73 : 16, 0.0f));
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

    public void setLocation(TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue, String str, int i, boolean z) {
        setLocation(tLRPC$TL_messageMediaVenue, str, null, i, z);
    }

    public static int getColorForIndex(int i) {
        int i2 = i % 7;
        if (i2 == 0) {
            return -1351584;
        }
        if (i2 == 1) {
            return -868277;
        }
        if (i2 == 2) {
            return -12214795;
        }
        if (i2 == 3) {
            return -13187226;
        }
        if (i2 != 4) {
            return i2 != 5 ? -1285237 : -12338729;
        }
        return -7900675;
    }

    public void setLocation(TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue, String str, String str2, int i, boolean z) {
        this.needDivider = z;
        this.circleDrawable.getPaint().setColor(getColorForIndex(i));
        this.nameTextView.setText(tLRPC$TL_messageMediaVenue.title);
        if (str2 != null) {
            this.addressTextView.setText(str2);
        } else {
            this.addressTextView.setText(tLRPC$TL_messageMediaVenue.address);
        }
        this.imageView.setImage(str, null, null);
        setWillNotDraw(!z);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(AndroidUtilities.dp(72.0f), getHeight() - 1, getWidth(), getHeight() - 1, Theme.dividerPaint);
        }
    }
}
