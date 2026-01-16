package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBoxSquare;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class CheckBoxUserCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private CheckBoxSquare checkBox;
    private TLRPC$User currentUser;
    private BackupImageView imageView;
    private boolean needDivider;
    private TextView textView;

    public CheckBoxUserCell(Context context, boolean alert) {
        super(context);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor(alert ? "dialogTextBlack" : "windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        View view = this.textView;
        boolean z = LocaleController.isRTL;
        addView(view, LayoutHelper.createFrame(-1, -1.0f, (z ? 5 : 3) | 48, z ? 21 : 94, 0.0f, z ? 94 : 21, 0.0f));
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(36.0f));
        addView(this.imageView, LayoutHelper.createFrame(36, 36.0f, (LocaleController.isRTL ? 5 : 3) | 48, 48.0f, 7.0f, 48.0f, 0.0f));
        CheckBoxSquare checkBoxSquare = new CheckBoxSquare(context, alert, null);
        this.checkBox = checkBoxSquare;
        boolean z2 = LocaleController.isRTL;
        addView(checkBoxSquare, LayoutHelper.createFrame(18, 18.0f, (z2 ? 5 : 3) | 48, z2 ? 0 : 21, 16.0f, z2 ? 21 : 0, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public TLRPC$User getCurrentUser() {
        return this.currentUser;
    }

    public void setUser(TLRPC$User user, boolean checked, boolean divider) {
        this.currentUser = user;
        this.textView.setText(ContactsController.formatName(user.first_name, user.last_name));
        this.checkBox.setChecked(checked, false);
        this.avatarDrawable.setInfo(user);
        this.imageView.setForUserOrChat(user, this.avatarDrawable);
        this.needDivider = divider;
        setWillNotDraw(!divider);
    }

    public void setChecked(boolean checked, boolean animated) {
        this.checkBox.setChecked(checked, animated);
    }

    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    public TextView getTextView() {
        return this.textView;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }
}
