package ir.eitaa.ui.Cells;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class LanguageCell extends FrameLayout {
    private ImageView checkImage;
    private LocaleController.LocaleInfo currentLocale;
    private boolean isDialog;
    private boolean needDivider;
    private TextView textView;
    private TextView textView2;

    public LanguageCell(Context context, boolean dialog) throws Resources.NotFoundException {
        super(context);
        if (Theme.dividerPaint == null) {
            Theme.createCommonResources(context);
        }
        setWillNotDraw(false);
        this.isDialog = dialog;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor(dialog ? "dialogTextBlack" : "windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        TextView textView2 = this.textView;
        boolean z = LocaleController.isRTL;
        addView(textView2, LayoutHelper.createFrame(-1, -1.0f, (z ? 5 : 3) | 48, z ? 71.0f : 23.0f, this.isDialog ? 4 : 7, z ? 23.0f : 71.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.textView2 = textView3;
        textView3.setTextColor(Theme.getColor(dialog ? "dialogTextGray3" : "windowBackgroundWhiteGrayText3"));
        this.textView2.setTextSize(1, 13.0f);
        this.textView2.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView2.setLines(1);
        this.textView2.setMaxLines(1);
        this.textView2.setSingleLine(true);
        this.textView2.setEllipsize(TextUtils.TruncateAt.END);
        this.textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        TextView textView4 = this.textView2;
        boolean z2 = LocaleController.isRTL;
        addView(textView4, LayoutHelper.createFrame(-1, -1.0f, (z2 ? 5 : 3) | 48, z2 ? 71.0f : 23.0f, this.isDialog ? 25 : 29, z2 ? 23.0f : 71.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        this.checkImage = imageView;
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("featuredStickers_addedIcon"), PorterDuff.Mode.MULTIPLY));
        this.checkImage.setImageResource(R.drawable.sticker_added);
        addView(this.checkImage, LayoutHelper.createFrame(19, 14.0f, (LocaleController.isRTL ? 3 : 5) | 16, 23.0f, 0.0f, 23.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.isDialog ? 50.0f : 54.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    public void setLanguage(LocaleController.LocaleInfo language, String desc, boolean divider) {
        TextView textView = this.textView;
        if (desc == null) {
            desc = language.name;
        }
        textView.setText(desc);
        this.textView2.setText(language.nameEnglish);
        this.currentLocale = language;
        this.needDivider = divider;
    }

    public LocaleController.LocaleInfo getCurrentLocale() {
        return this.currentLocale;
    }

    public void setLanguageSelected(boolean value) {
        this.checkImage.setVisibility(value ? 0 : 4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }
}
