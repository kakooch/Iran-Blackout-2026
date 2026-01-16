package ir.eitaa.ui.Components;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.StateSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class Switch extends View {
    private boolean attachedToWindow;
    private boolean bitmapsCreated;
    private ObjectAnimator checkAnimator;
    private int colorSet;
    private int drawIconType;
    private boolean drawRipple;
    private ObjectAnimator iconAnimator;
    private Drawable iconDrawable;
    private float iconProgress;
    private boolean isChecked;
    private int lastIconColor;
    private OnCheckedChangeListener onCheckedChangeListener;
    private Bitmap[] overlayBitmap;
    private Canvas[] overlayCanvas;
    private float overlayCx;
    private float overlayCy;
    private Paint overlayEraserPaint;
    private Bitmap overlayMaskBitmap;
    private Canvas overlayMaskCanvas;
    private Paint overlayMaskPaint;
    private float overlayRad;
    private int overrideColorProgress;
    private Paint paint;
    private Paint paint2;
    private int[] pressedState;
    private float progress;
    private RectF rectF;
    private RippleDrawable rippleDrawable;
    private Paint ripplePaint;
    private String thumbCheckedColorKey;
    private String thumbColorKey;
    private String trackCheckedColorKey;
    private String trackColorKey;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(Switch view, boolean isChecked);
    }

    public Switch(Context context) {
        super(context);
        this.iconProgress = 1.0f;
        this.trackColorKey = "switch2Track";
        this.trackCheckedColorKey = "switch2TrackChecked";
        this.thumbColorKey = "windowBackgroundWhite";
        this.thumbCheckedColorKey = "windowBackgroundWhite";
        this.pressedState = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        this.rectF = new RectF();
        this.paint = new Paint(1);
        Paint paint = new Paint(1);
        this.paint2 = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.paint2.setStrokeCap(Paint.Cap.ROUND);
        this.paint2.setStrokeWidth(AndroidUtilities.dp(2.0f));
    }

    @Keep
    public void setProgress(float value) {
        if (this.progress == value) {
            return;
        }
        this.progress = value;
        invalidate();
    }

    @Keep
    public float getProgress() {
        return this.progress;
    }

    @Keep
    public void setIconProgress(float value) {
        if (this.iconProgress == value) {
            return;
        }
        this.iconProgress = value;
        invalidate();
    }

    @Keep
    public float getIconProgress() {
        return this.iconProgress;
    }

    private void cancelCheckAnimator() {
        ObjectAnimator objectAnimator = this.checkAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.checkAnimator = null;
        }
    }

    private void cancelIconAnimator() {
        ObjectAnimator objectAnimator = this.iconAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.iconAnimator = null;
        }
    }

    public void setDrawIconType(int type) {
        this.drawIconType = type;
    }

    public void setDrawRipple(boolean value) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21 || value == this.drawRipple) {
            return;
        }
        this.drawRipple = value;
        if (this.rippleDrawable == null) {
            Paint paint = new Paint(1);
            this.ripplePaint = paint;
            paint.setColor(-1);
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{0}), null, i >= 23 ? null : new Drawable() { // from class: ir.eitaa.ui.Components.Switch.1
                @Override // android.graphics.drawable.Drawable
                public int getOpacity() {
                    return 0;
                }

                @Override // android.graphics.drawable.Drawable
                public void setAlpha(int alpha) {
                }

                @Override // android.graphics.drawable.Drawable
                public void setColorFilter(ColorFilter colorFilter) {
                }

                @Override // android.graphics.drawable.Drawable
                public void draw(Canvas canvas) {
                    android.graphics.Rect bounds = getBounds();
                    canvas.drawCircle(bounds.centerX(), bounds.centerY(), AndroidUtilities.dp(18.0f), Switch.this.ripplePaint);
                }
            });
            this.rippleDrawable = rippleDrawable;
            if (i >= 23) {
                rippleDrawable.setRadius(AndroidUtilities.dp(18.0f));
            }
            this.rippleDrawable.setCallback(this);
        }
        boolean z = this.isChecked;
        if ((z && this.colorSet != 2) || (!z && this.colorSet != 1)) {
            this.rippleDrawable.setColor(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{Theme.getColor(z ? "switchTrackBlueSelectorChecked" : "switchTrackBlueSelector")}));
            this.colorSet = this.isChecked ? 2 : 1;
        }
        if (i >= 28 && value) {
            this.rippleDrawable.setHotspot(this.isChecked ? 0.0f : AndroidUtilities.dp(100.0f), AndroidUtilities.dp(18.0f));
        }
        this.rippleDrawable.setState(value ? this.pressedState : StateSet.NOTHING);
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        RippleDrawable rippleDrawable;
        return super.verifyDrawable(who) || ((rippleDrawable = this.rippleDrawable) != null && who == rippleDrawable);
    }

    public void setColors(String track, String trackChecked, String thumb, String thumbChecked) {
        this.trackColorKey = track;
        this.trackCheckedColorKey = trackChecked;
        this.thumbColorKey = thumb;
        this.thumbCheckedColorKey = thumbChecked;
    }

    private void animateToCheckedState(boolean newCheckedState) {
        float[] fArr = new float[1];
        fArr[0] = newCheckedState ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", fArr);
        this.checkAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.checkAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.Switch.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Switch.this.checkAnimator = null;
            }
        });
        this.checkAnimator.start();
    }

    private void animateIcon(boolean newCheckedState) {
        float[] fArr = new float[1];
        fArr[0] = newCheckedState ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "iconProgress", fArr);
        this.iconAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.iconAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.Switch.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Switch.this.iconAnimator = null;
            }
        });
        this.iconAnimator.start();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.onCheckedChangeListener = listener;
    }

    public void setChecked(boolean checked, boolean animated) {
        setChecked(checked, this.drawIconType, animated);
    }

    public void setChecked(boolean checked, int iconType, boolean animated) {
        if (checked != this.isChecked) {
            this.isChecked = checked;
            if (this.attachedToWindow && animated) {
                animateToCheckedState(checked);
            } else {
                cancelCheckAnimator();
                setProgress(checked ? 1.0f : 0.0f);
            }
            OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, checked);
            }
        }
        if (this.drawIconType != iconType) {
            this.drawIconType = iconType;
            if (this.attachedToWindow && animated) {
                animateIcon(iconType == 0);
            } else {
                cancelIconAnimator();
                setIconProgress(iconType != 0 ? 0.0f : 1.0f);
            }
        }
    }

    public void setIcon(int icon) {
        if (icon != 0) {
            Drawable drawableMutate = getResources().getDrawable(icon).mutate();
            this.iconDrawable = drawableMutate;
            if (drawableMutate != null) {
                int color = Theme.getColor(this.isChecked ? this.trackCheckedColorKey : this.trackColorKey);
                this.lastIconColor = color;
                drawableMutate.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                return;
            }
            return;
        }
        this.iconDrawable = null;
    }

    public boolean hasIcon() {
        return this.iconDrawable != null;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setOverrideColor(int override) {
        if (this.overrideColorProgress == override) {
            return;
        }
        if (this.overlayBitmap == null) {
            try {
                this.overlayBitmap = new Bitmap[2];
                this.overlayCanvas = new Canvas[2];
                for (int i = 0; i < 2; i++) {
                    this.overlayBitmap[i] = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                    this.overlayCanvas[i] = new Canvas(this.overlayBitmap[i]);
                }
                this.overlayMaskBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                this.overlayMaskCanvas = new Canvas(this.overlayMaskBitmap);
                Paint paint = new Paint(1);
                this.overlayEraserPaint = paint;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                Paint paint2 = new Paint(1);
                this.overlayMaskPaint = paint2;
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                this.bitmapsCreated = true;
            } catch (Throwable unused) {
                return;
            }
        }
        if (this.bitmapsCreated) {
            this.overrideColorProgress = override;
            this.overlayCx = 0.0f;
            this.overlayCy = 0.0f;
            this.overlayRad = 0.0f;
            invalidate();
        }
    }

    public void setOverrideColorProgress(float cx, float cy, float rad) {
        this.overlayCx = cx;
        this.overlayCy = cy;
        this.overlayRad = rad;
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03d5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r32) {
        /*
            Method dump skipped, instructions count: 1002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.Switch.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.Switch");
        info.setCheckable(true);
        info.setChecked(this.isChecked);
    }
}
