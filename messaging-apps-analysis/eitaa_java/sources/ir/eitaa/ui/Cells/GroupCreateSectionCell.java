package ir.eitaa.ui.Cells;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class GroupCreateSectionCell extends FrameLayout {
    private Drawable drawable;
    private TextView textView;

    public GroupCreateSectionCell(Context context) throws Resources.NotFoundException {
        super(context);
        setBackgroundColor(Theme.getColor("graySection"));
        Drawable drawable = getResources().getDrawable(R.drawable.shadowdown);
        this.drawable = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("groupcreate_sectionShadow"), PorterDuff.Mode.MULTIPLY));
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setTextSize(1, 14.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setTextColor(Theme.getColor("groupcreate_sectionText"));
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, (LocaleController.isRTL ? 5 : 3) | 48, 16.0f, 0.0f, 16.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(40.0f), 1073741824));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.drawable.setBounds(0, getMeasuredHeight() - AndroidUtilities.dp(3.0f), getMeasuredWidth(), getMeasuredHeight());
        this.drawable.draw(canvas);
    }

    public void setText(String text) {
        this.textView.setText(text);
    }
}
