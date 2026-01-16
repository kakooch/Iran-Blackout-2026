package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
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

    public GroupCreateUserCell(Context context, int checkBoxType, int pad, boolean selfAsSaved) {
        this(context, checkBoxType, pad, selfAsSaved, false);
    }

    public GroupCreateUserCell(Context context, int checkBoxType, int pad, boolean selfAsSaved, boolean forCall) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.checkBoxType = checkBoxType;
        this.forceDarkTheme = forCall;
        this.drawDivider = false;
        this.padding = pad;
        this.showSelfAsSaved = selfAsSaved;
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(24.0f));
        BackupImageView backupImageView2 = this.avatarImageView;
        boolean z = LocaleController.isRTL;
        addView(backupImageView2, LayoutHelper.createFrame(46, 46.0f, (z ? 5 : 3) | 48, z ? 0.0f : this.padding + 13, 6.0f, z ? this.padding + 13 : 0.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor(this.forceDarkTheme ? "voipgroup_nameText" : "windowBackgroundWhiteBlackText"));
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setTextSize(16);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView2 = this.nameTextView;
        boolean z2 = LocaleController.isRTL;
        int i = (z2 ? 5 : 3) | 48;
        int i2 = z2 ? 28 : 72;
        int i3 = this.padding;
        addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, i, i2 + i3, 10.0f, (z2 ? 72 : 28) + i3, 0.0f));
        SimpleTextView simpleTextView3 = new SimpleTextView(context);
        this.statusTextView = simpleTextView3;
        simpleTextView3.setTextSize(14);
        this.statusTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView4 = this.statusTextView;
        boolean z3 = LocaleController.isRTL;
        int i4 = (z3 ? 5 : 3) | 48;
        int i5 = z3 ? 28 : 72;
        int i6 = this.padding;
        addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, i4, i5 + i6, 32.0f, (z3 ? 72 : 28) + i6, 0.0f));
        if (checkBoxType == 1) {
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(null, "windowBackgroundWhite", "checkboxCheck");
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            CheckBox2 checkBox22 = this.checkBox;
            boolean z4 = LocaleController.isRTL;
            addView(checkBox22, LayoutHelper.createFrame(24, 24.0f, (z4 ? 5 : 3) | 48, z4 ? 0.0f : 40.0f, 33.0f, z4 ? 39.0f : 0.0f, 0.0f));
        } else if (checkBoxType == 2) {
            Paint paint = new Paint(1);
            this.paint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        }
        setWillNotDraw(false);
    }

    public void setObject(TLObject object, CharSequence name, CharSequence status, boolean drawDivider) {
        setObject(object, name, status);
        this.drawDivider = drawDivider;
    }

    public void setObject(Object object, CharSequence name, CharSequence status) {
        this.currentObject = object;
        this.currentStatus = status;
        this.currentName = name;
        this.drawDivider = false;
        update(0);
    }

    public void setChecked(boolean checked, boolean animated) {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 != null) {
            checkBox2.setChecked(checked, animated);
            return;
        }
        if (this.checkBoxType != 2 || this.isChecked == checked) {
            return;
        }
        this.isChecked = checked;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (animated) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.animator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$GroupCreateUserCell$7JwlgGBIT3enKDzvGhOjOFrcuEQ
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$setChecked$0$GroupCreateUserCell(valueAnimator2);
                }
            });
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.GroupCreateUserCell.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
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
    /* renamed from: lambda$setChecked$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setChecked$0$GroupCreateUserCell(ValueAnimator valueAnimator) {
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

    public void setCheckBoxEnabled(boolean enabled) {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 != null) {
            checkBox2.setEnabled(enabled);
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

    public void setDrawDivider(boolean value) {
        this.drawDivider = value;
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.currentObject instanceof String ? 50.0f : 58.0f), 1073741824));
    }

    public void recycle() {
        this.avatarImageView.getImageReceiver().cancelLoadImage();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(int r14) {
        /*
            Method dump skipped, instructions count: 1228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.GroupCreateUserCell.update(int):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.checkBoxType == 2 && (this.isChecked || this.checkProgress > 0.0f)) {
            this.paint.setColor(Theme.getColor("checkboxSquareBackground"));
            canvas.drawCircle(this.avatarImageView.getLeft() + (this.avatarImageView.getMeasuredWidth() / 2), this.avatarImageView.getTop() + (this.avatarImageView.getMeasuredHeight() / 2), AndroidUtilities.dp(18.0f) + (AndroidUtilities.dp(4.0f) * this.checkProgress), this.paint);
        }
        if (this.drawDivider) {
            int iDp = AndroidUtilities.dp(LocaleController.isRTL ? 0.0f : this.padding + 72);
            int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(LocaleController.isRTL ? this.padding + 72 : 0.0f);
            if (this.forceDarkTheme) {
                Theme.dividerExtraPaint.setColor(Theme.getColor("voipgroup_actionBar"));
                canvas.drawRect(iDp, getMeasuredHeight() - 1, measuredWidth, getMeasuredHeight(), Theme.dividerExtraPaint);
            } else {
                canvas.drawRect(iDp, getMeasuredHeight() - 1, measuredWidth, getMeasuredHeight(), Theme.dividerPaint);
            }
        }
    }
}
