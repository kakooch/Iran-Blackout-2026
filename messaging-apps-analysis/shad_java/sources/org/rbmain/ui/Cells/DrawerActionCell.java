package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class DrawerActionCell extends FrameLayout {
    private TextView textView;

    public DrawerActionCell(Context context) {
        super(context);
        new RectF();
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_chats_menuItemText));
        this.textView.setTextSize(1, 15.0f);
        this.textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setGravity(19);
        this.textView.setCompoundDrawablePadding(AndroidUtilities.dp(29.0f));
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, 51, 19.0f, 0.0f, 16.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.textView.setTextColor(Theme.getColor(Theme.key_chats_menuItemText));
    }

    public void setTextAndIcon(String str, int i) {
        try {
            this.textView.setText(str);
            Drawable drawableMutate = getResources().getDrawable(i).mutate();
            if (drawableMutate != null) {
                drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chats_menuItemIcon), PorterDuff.Mode.MULTIPLY));
            }
            this.textView.setCompoundDrawablesWithIntrinsicBounds(drawableMutate, (Drawable) null, (Drawable) null, (Drawable) null);
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }
}
