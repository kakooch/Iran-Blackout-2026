package org.rbmain.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.FrameLayout;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class GroupCreateUserCell extends FrameLayout {
    private ValueAnimator animator;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private CheckBox2 checkBox;
    private int checkBoxType;
    private float checkProgress;
    private int currentAccount;
    private CharSequence currentName;
    private Object currentObject;
    private CharSequence currentStatus;
    private boolean drawDivider;
    private boolean forceDarkTheme;
    private boolean isChecked;
    private TLRPC$FileLocation lastAvatar;
    private String lastName;
    private int lastStatus;
    private SimpleTextView nameTextView;
    private int padding;
    private Paint paint;
    private boolean showSelfAsSaved;
    private SimpleTextView statusTextView;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public GroupCreateUserCell(Context context, int i, int i2, boolean z) {
        this(context, i, i2, z, false);
    }

    public GroupCreateUserCell(Context context, int i, int i2, boolean z, boolean z2) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.checkBoxType = i;
        this.forceDarkTheme = z2;
        this.drawDivider = false;
        this.padding = i2;
        this.showSelfAsSaved = z;
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(24.0f));
        BackupImageView backupImageView2 = this.avatarImageView;
        boolean z3 = LocaleController.isRTL;
        addView(backupImageView2, LayoutHelper.createFrame(46, 46.0f, (z3 ? 5 : 3) | 48, z3 ? 0.0f : this.padding + 13, 6.0f, z3 ? this.padding + 13 : 0.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_nameText : Theme.key_windowBackgroundWhiteBlackText));
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.nameTextView.setTextSize(16);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView2 = this.nameTextView;
        boolean z4 = LocaleController.isRTL;
        int i3 = (z4 ? 5 : 3) | 48;
        int i4 = z4 ? 28 : 72;
        int i5 = this.padding;
        addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, i3, i4 + i5, 10.0f, (z4 ? 72 : 28) + i5, 0.0f));
        SimpleTextView simpleTextView3 = new SimpleTextView(context);
        this.statusTextView = simpleTextView3;
        simpleTextView3.setTextSize(14);
        this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView4 = this.statusTextView;
        boolean z5 = LocaleController.isRTL;
        int i6 = (z5 ? 5 : 3) | 48;
        int i7 = z5 ? 28 : 72;
        int i8 = this.padding;
        addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, i6, i7 + i8, 32.0f, (z5 ? 72 : 28) + i8, 0.0f));
        if (i == 1) {
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(-1, Theme.key_windowBackgroundWhite, Theme.key_checkboxCheck);
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            CheckBox2 checkBox22 = this.checkBox;
            boolean z6 = LocaleController.isRTL;
            addView(checkBox22, LayoutHelper.createFrame(24, 24.0f, (z6 ? 5 : 3) | 48, z6 ? 0.0f : 40.0f, 33.0f, z6 ? 39.0f : 0.0f, 0.0f));
        } else if (i == 2) {
            Paint paint = new Paint(1);
            this.paint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        }
        setWillNotDraw(false);
    }

    public void setObject(TLObject tLObject, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        setObject(tLObject, charSequence, charSequence2);
        this.drawDivider = z;
    }

    public void setObject(Object obj, CharSequence charSequence, CharSequence charSequence2) {
        this.currentObject = obj;
        this.currentStatus = charSequence2;
        this.currentName = charSequence;
        this.drawDivider = false;
        update(0);
    }

    public void setChecked(boolean z, boolean z2) {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 != null) {
            checkBox2.setChecked(z, z2);
            return;
        }
        if (this.checkBoxType != 2 || this.isChecked == z) {
            return;
        }
        this.isChecked = z;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (z2) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.animator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.GroupCreateUserCell$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$setChecked$0(valueAnimator2);
                }
            });
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Cells.GroupCreateUserCell.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GroupCreateUserCell.this.animator = null;
                }
            });
            this.animator.setDuration(180L);
            this.animator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            this.animator.start();
        } else {
            this.avatarImageView.setScaleX(this.isChecked ? 0.82f : 1.0f);
            this.avatarImageView.setScaleY(this.isChecked ? 0.82f : 1.0f);
            this.checkProgress = this.isChecked ? 1.0f : 0.0f;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setChecked$0(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = this.isChecked ? 1.0f - (0.18f * fFloatValue) : 0.82f + (0.18f * fFloatValue);
        this.avatarImageView.setScaleX(f);
        this.avatarImageView.setScaleY(f);
        if (!this.isChecked) {
            fFloatValue = 1.0f - fFloatValue;
        }
        this.checkProgress = fFloatValue;
        invalidate();
    }

    public void setCheckBoxEnabled(boolean z) {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 != null) {
            checkBox2.setEnabled(z);
        }
    }

    public boolean isChecked() {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 != null) {
            return checkBox2.isChecked();
        }
        return this.isChecked;
    }

    public Object getObject() {
        return this.currentObject;
    }

    public void setDrawDivider(boolean z) {
        this.drawDivider = z;
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.currentObject instanceof String ? 50.0f : 58.0f), 1073741824));
    }

    public void recycle() {
        this.avatarImageView.getImageReceiver().cancelLoadImage();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(int r12) {
        /*
            Method dump skipped, instructions count: 1186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.GroupCreateUserCell.update(int):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.checkBoxType == 2 && (this.isChecked || this.checkProgress > 0.0f)) {
            this.paint.setColor(Theme.getColor(Theme.key_checkboxSquareBackground));
            canvas.drawCircle(this.avatarImageView.getLeft() + (this.avatarImageView.getMeasuredWidth() / 2), this.avatarImageView.getTop() + (this.avatarImageView.getMeasuredHeight() / 2), AndroidUtilities.dp(18.0f) + (AndroidUtilities.dp(4.0f) * this.checkProgress), this.paint);
        }
        if (this.drawDivider) {
            int iDp = AndroidUtilities.dp(LocaleController.isRTL ? 0.0f : this.padding + 72);
            int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(LocaleController.isRTL ? this.padding + 72 : 0.0f);
            if (this.forceDarkTheme) {
                Theme.dividerExtraPaint.setColor(Theme.getColor(Theme.key_voipgroup_actionBar));
                canvas.drawRect(iDp, getMeasuredHeight() - 1, measuredWidth, getMeasuredHeight(), Theme.dividerExtraPaint);
            } else {
                canvas.drawRect(iDp, getMeasuredHeight() - 1, measuredWidth, getMeasuredHeight(), Theme.dividerPaint);
            }
        }
    }
}
