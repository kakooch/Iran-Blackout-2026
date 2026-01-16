package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import java.util.Set;

/* loaded from: classes3.dex */
public class DrawerActionCell extends FrameLayout {
    private int currentId;
    private RectF rect;
    private TextView textView;

    public DrawerActionCell(Context context) {
        super(context);
        this.rect = new RectF();
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor("chats_menuItemText"));
        this.textView.setTextSize(1, 15.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setGravity(19);
        this.textView.setCompoundDrawablePadding(AndroidUtilities.dp(29.0f));
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, 51, 19.0f, 0.0f, 16.0f, 0.0f));
        setWillNotDraw(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.currentId == 8) {
            Set<String> set = MessagesController.getInstance(UserConfig.selectedAccount).pendingSuggestions;
            if (set.contains("VALIDATE_PHONE_NUMBER") || set.contains("VALIDATE_PASSWORD")) {
                int iDp = AndroidUtilities.dp(12.5f);
                this.rect.set(((getMeasuredWidth() - AndroidUtilities.dp(9.0f)) - AndroidUtilities.dp(25.0f)) - AndroidUtilities.dp(5.5f), iDp, r2 + r1 + AndroidUtilities.dp(14.0f), iDp + AndroidUtilities.dp(23.0f));
                Theme.chat_docBackPaint.setColor(Theme.getColor("chats_archiveBackground"));
                RectF rectF = this.rect;
                float f = AndroidUtilities.density;
                canvas.drawRoundRect(rectF, f * 11.5f, f * 11.5f, Theme.chat_docBackPaint);
                float intrinsicWidth = Theme.dialogs_errorDrawable.getIntrinsicWidth() / 2;
                float intrinsicHeight = Theme.dialogs_errorDrawable.getIntrinsicHeight() / 2;
                Theme.dialogs_errorDrawable.setBounds((int) (this.rect.centerX() - intrinsicWidth), (int) (this.rect.centerY() - intrinsicHeight), (int) (this.rect.centerX() + intrinsicWidth), (int) (this.rect.centerY() + intrinsicHeight));
                Theme.dialogs_errorDrawable.draw(canvas);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.textView.setTextColor(Theme.getColor("chats_menuItemText"));
    }

    public void setTextAndIcon(int id, String text, int resId) {
        this.currentId = id;
        try {
            this.textView.setText(text);
            Drawable drawableMutate = getResources().getDrawable(resId).mutate();
            if (drawableMutate != null) {
                drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_menuItemIcon"), PorterDuff.Mode.MULTIPLY));
            }
            this.textView.setCompoundDrawablesWithIntrinsicBounds(drawableMutate, (Drawable) null, (Drawable) null, (Drawable) null);
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }
}
