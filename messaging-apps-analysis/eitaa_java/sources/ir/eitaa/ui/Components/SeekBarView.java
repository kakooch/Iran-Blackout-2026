package ir.eitaa.ui.Components;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class SeekBarView extends FrameLayout {
    private float bufferedProgress;
    boolean captured;
    private float currentRadius;
    public SeekBarViewDelegate delegate;
    private Drawable hoverDrawable;
    private Paint innerPaint1;
    private long lastUpdateTime;
    private Paint outerPaint1;
    private boolean pressed;
    private int[] pressedState;
    private float progressToSet;
    private boolean reportChanges;
    private final Theme.ResourcesProvider resourcesProvider;
    private final SeekBarAccessibilityDelegate seekBarAccessibilityDelegate;
    private int selectorWidth;
    float sx;
    float sy;
    private int thumbDX;
    private int thumbSize;
    private int thumbX;
    private float transitionProgress;
    private int transitionThumbX;
    private boolean twoSided;

    public interface SeekBarViewDelegate {

        /* renamed from: ir.eitaa.ui.Components.SeekBarView$SeekBarViewDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static CharSequence $default$getContentDescription(SeekBarViewDelegate seekBarViewDelegate) {
                return null;
            }

            public static int $default$getStepsCount(SeekBarViewDelegate seekBarViewDelegate) {
                return 0;
            }
        }

        CharSequence getContentDescription();

        int getStepsCount();

        void onSeekBarDrag(boolean stop, float progress);

        void onSeekBarPressed(boolean pressed);
    }

    public SeekBarView(Context context) {
        this(context, null);
    }

    public SeekBarView(Context context, Theme.ResourcesProvider resourcesProvider) {
        this(context, false, resourcesProvider);
    }

    public SeekBarView(Context context, boolean inPercents, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.progressToSet = -100.0f;
        this.pressedState = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        this.transitionProgress = 1.0f;
        this.resourcesProvider = resourcesProvider;
        setWillNotDraw(false);
        this.innerPaint1 = new Paint(1);
        Paint paint = new Paint(1);
        this.outerPaint1 = paint;
        paint.setColor(getThemedColor("player_progress"));
        this.selectorWidth = AndroidUtilities.dp(32.0f);
        this.thumbSize = AndroidUtilities.dp(24.0f);
        this.currentRadius = AndroidUtilities.dp(6.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            Drawable drawableCreateSelectorDrawable = Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(getThemedColor("player_progress"), 40), 1, AndroidUtilities.dp(16.0f));
            this.hoverDrawable = drawableCreateSelectorDrawable;
            drawableCreateSelectorDrawable.setCallback(this);
            this.hoverDrawable.setVisible(true, false);
        }
        setImportantForAccessibility(1);
        FloatSeekBarAccessibilityDelegate floatSeekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate(inPercents) { // from class: ir.eitaa.ui.Components.SeekBarView.1
            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public float getProgress() {
                return SeekBarView.this.getProgress();
            }

            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public void setProgress(float progress) {
                SeekBarView.this.pressed = true;
                SeekBarView.this.setProgress(progress);
                SeekBarViewDelegate seekBarViewDelegate = SeekBarView.this.delegate;
                if (seekBarViewDelegate != null) {
                    seekBarViewDelegate.onSeekBarDrag(true, progress);
                }
                SeekBarView.this.pressed = false;
            }

            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            protected float getDelta() {
                int stepsCount = SeekBarView.this.delegate.getStepsCount();
                return stepsCount > 0 ? 1.0f / stepsCount : super.getDelta();
            }

            @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
            public CharSequence getContentDescription(View host) {
                SeekBarViewDelegate seekBarViewDelegate = SeekBarView.this.delegate;
                if (seekBarViewDelegate != null) {
                    return seekBarViewDelegate.getContentDescription();
                }
                return null;
            }
        };
        this.seekBarAccessibilityDelegate = floatSeekBarAccessibilityDelegate;
        setAccessibilityDelegate(floatSeekBarAccessibilityDelegate);
    }

    public void setTwoSided(boolean value) {
        this.twoSided = value;
    }

    public boolean isTwoSided() {
        return this.twoSided;
    }

    public void setInnerColor(int color) {
        this.innerPaint1.setColor(color);
    }

    public void setOuterColor(int color) {
        this.outerPaint1.setColor(color);
        Drawable drawable = this.hoverDrawable;
        if (drawable != null) {
            Theme.setSelectorDrawableColor(drawable, ColorUtils.setAlphaComponent(color, 40), true);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return onTouch(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return onTouch(event);
    }

    public void setReportChanges(boolean value) {
        this.reportChanges = value;
    }

    public void setDelegate(SeekBarViewDelegate seekBarViewDelegate) {
        this.delegate = seekBarViewDelegate;
    }

    boolean onTouch(MotionEvent ev) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        if (ev.getAction() == 0) {
            this.sx = ev.getX();
            this.sy = ev.getY();
            return true;
        }
        if (ev.getAction() == 1 || ev.getAction() == 3) {
            this.captured = false;
            if (ev.getAction() == 1) {
                if (Math.abs(ev.getY() - this.sy) < ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    int measuredHeight = (getMeasuredHeight() - this.thumbSize) / 2;
                    if (this.thumbX - measuredHeight > ev.getX() || ev.getX() > this.thumbX + this.thumbSize + measuredHeight) {
                        int x = ((int) ev.getX()) - (this.thumbSize / 2);
                        this.thumbX = x;
                        if (x < 0) {
                            this.thumbX = 0;
                        } else if (x > getMeasuredWidth() - this.selectorWidth) {
                            this.thumbX = getMeasuredWidth() - this.selectorWidth;
                        }
                    }
                    this.thumbDX = (int) (ev.getX() - this.thumbX);
                    this.pressed = true;
                }
            }
            if (this.pressed) {
                if (ev.getAction() == 1) {
                    if (this.twoSided) {
                        float measuredWidth = (getMeasuredWidth() - this.selectorWidth) / 2;
                        int i = this.thumbX;
                        if (i >= measuredWidth) {
                            this.delegate.onSeekBarDrag(false, (i - measuredWidth) / measuredWidth);
                        } else {
                            this.delegate.onSeekBarDrag(false, -Math.max(0.01f, 1.0f - ((measuredWidth - i) / measuredWidth)));
                        }
                    } else {
                        this.delegate.onSeekBarDrag(true, this.thumbX / (getMeasuredWidth() - this.selectorWidth));
                    }
                }
                if (Build.VERSION.SDK_INT >= 21 && (drawable = this.hoverDrawable) != null) {
                    drawable.setState(StateSet.NOTHING);
                }
                this.delegate.onSeekBarPressed(false);
                this.pressed = false;
                invalidate();
                return true;
            }
        } else if (ev.getAction() == 2) {
            if (!this.captured) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                if (Math.abs(ev.getY() - this.sy) <= viewConfiguration.getScaledTouchSlop() && Math.abs(ev.getX() - this.sx) > viewConfiguration.getScaledTouchSlop()) {
                    this.captured = true;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    int measuredHeight2 = (getMeasuredHeight() - this.thumbSize) / 2;
                    if (ev.getY() >= 0.0f && ev.getY() <= getMeasuredHeight()) {
                        if (this.thumbX - measuredHeight2 > ev.getX() || ev.getX() > this.thumbX + this.thumbSize + measuredHeight2) {
                            int x2 = ((int) ev.getX()) - (this.thumbSize / 2);
                            this.thumbX = x2;
                            if (x2 < 0) {
                                this.thumbX = 0;
                            } else if (x2 > getMeasuredWidth() - this.selectorWidth) {
                                this.thumbX = getMeasuredWidth() - this.selectorWidth;
                            }
                        }
                        this.thumbDX = (int) (ev.getX() - this.thumbX);
                        this.pressed = true;
                        this.delegate.onSeekBarPressed(true);
                        if (Build.VERSION.SDK_INT >= 21 && (drawable3 = this.hoverDrawable) != null) {
                            drawable3.setState(this.pressedState);
                            this.hoverDrawable.setHotspot(ev.getX(), ev.getY());
                        }
                        invalidate();
                        return true;
                    }
                }
            } else if (this.pressed) {
                int x3 = (int) (ev.getX() - this.thumbDX);
                this.thumbX = x3;
                if (x3 < 0) {
                    this.thumbX = 0;
                } else if (x3 > getMeasuredWidth() - this.selectorWidth) {
                    this.thumbX = getMeasuredWidth() - this.selectorWidth;
                }
                if (this.reportChanges) {
                    if (this.twoSided) {
                        float measuredWidth2 = (getMeasuredWidth() - this.selectorWidth) / 2;
                        int i2 = this.thumbX;
                        if (i2 >= measuredWidth2) {
                            this.delegate.onSeekBarDrag(false, (i2 - measuredWidth2) / measuredWidth2);
                        } else {
                            this.delegate.onSeekBarDrag(false, -Math.max(0.01f, 1.0f - ((measuredWidth2 - i2) / measuredWidth2)));
                        }
                    } else {
                        this.delegate.onSeekBarDrag(false, this.thumbX / (getMeasuredWidth() - this.selectorWidth));
                    }
                }
                if (Build.VERSION.SDK_INT >= 21 && (drawable2 = this.hoverDrawable) != null) {
                    drawable2.setHotspot(ev.getX(), ev.getY());
                }
                invalidate();
                return true;
            }
        }
        return false;
    }

    public float getProgress() {
        if (getMeasuredWidth() == 0) {
            return this.progressToSet;
        }
        return this.thumbX / (getMeasuredWidth() - this.selectorWidth);
    }

    public void setProgress(float progress) {
        setProgress(progress, false);
    }

    public void setProgress(float progress, boolean animated) {
        double dCeil;
        if (getMeasuredWidth() == 0) {
            this.progressToSet = progress;
            return;
        }
        this.progressToSet = -100.0f;
        if (this.twoSided) {
            float measuredWidth = (getMeasuredWidth() - this.selectorWidth) / 2;
            if (progress < 0.0f) {
                dCeil = Math.ceil(measuredWidth + ((-(progress + 1.0f)) * measuredWidth));
            } else {
                dCeil = Math.ceil(measuredWidth + (progress * measuredWidth));
            }
        } else {
            dCeil = Math.ceil((getMeasuredWidth() - this.selectorWidth) * progress);
        }
        int i = (int) dCeil;
        int i2 = this.thumbX;
        if (i2 != i) {
            if (animated) {
                this.transitionThumbX = i2;
                this.transitionProgress = 0.0f;
            }
            this.thumbX = i;
            if (i < 0) {
                this.thumbX = 0;
            } else if (i > getMeasuredWidth() - this.selectorWidth) {
                this.thumbX = getMeasuredWidth() - this.selectorWidth;
            }
            invalidate();
        }
    }

    public void setBufferedProgress(float progress) {
        this.bufferedProgress = progress;
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.progressToSet == -100.0f || getMeasuredWidth() <= 0) {
            return;
        }
        setProgress(this.progressToSet);
        this.progressToSet = -100.0f;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.hoverDrawable;
    }

    public boolean isDragging() {
        return this.pressed;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int measuredHeight = (getMeasuredHeight() - this.thumbSize) / 2;
        this.innerPaint1.setColor(getThemedColor("player_progressBackground"));
        canvas.drawRect(this.selectorWidth / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(1.0f), getMeasuredWidth() - (this.selectorWidth / 2), (getMeasuredHeight() / 2) + AndroidUtilities.dp(1.0f), this.innerPaint1);
        if (this.bufferedProgress > 0.0f) {
            this.innerPaint1.setColor(getThemedColor("key_player_progressCachedBackground"));
            canvas.drawRect(this.selectorWidth / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(1.0f), (this.bufferedProgress * (getMeasuredWidth() - this.selectorWidth)) + (this.selectorWidth / 2), (getMeasuredHeight() / 2) + AndroidUtilities.dp(1.0f), this.innerPaint1);
        }
        if (this.twoSided) {
            canvas.drawRect((getMeasuredWidth() / 2) - AndroidUtilities.dp(1.0f), (getMeasuredHeight() / 2) - AndroidUtilities.dp(6.0f), (getMeasuredWidth() / 2) + AndroidUtilities.dp(1.0f), (getMeasuredHeight() / 2) + AndroidUtilities.dp(6.0f), this.outerPaint1);
            if (this.thumbX > (getMeasuredWidth() - this.selectorWidth) / 2) {
                canvas.drawRect(getMeasuredWidth() / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(1.0f), (this.selectorWidth / 2) + this.thumbX, (getMeasuredHeight() / 2) + AndroidUtilities.dp(1.0f), this.outerPaint1);
            } else {
                canvas.drawRect(this.thumbX + (r2 / 2), (getMeasuredHeight() / 2) - AndroidUtilities.dp(1.0f), getMeasuredWidth() / 2, (getMeasuredHeight() / 2) + AndroidUtilities.dp(1.0f), this.outerPaint1);
            }
        } else {
            canvas.drawRect(this.selectorWidth / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(1.0f), (this.selectorWidth / 2) + this.thumbX, (getMeasuredHeight() / 2) + AndroidUtilities.dp(1.0f), this.outerPaint1);
        }
        if (this.hoverDrawable != null) {
            int iDp = (this.thumbX + (this.selectorWidth / 2)) - AndroidUtilities.dp(16.0f);
            int iDp2 = ((this.thumbSize / 2) + measuredHeight) - AndroidUtilities.dp(16.0f);
            this.hoverDrawable.setBounds(iDp, iDp2, AndroidUtilities.dp(32.0f) + iDp, AndroidUtilities.dp(32.0f) + iDp2);
            this.hoverDrawable.draw(canvas);
        }
        boolean z = false;
        int iDp3 = AndroidUtilities.dp(this.pressed ? 8.0f : 6.0f);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.lastUpdateTime;
        if (jElapsedRealtime > 18) {
            jElapsedRealtime = 16;
        }
        float f = this.currentRadius;
        float f2 = iDp3;
        boolean z2 = true;
        if (f != f2) {
            if (f < f2) {
                float fDp = f + (AndroidUtilities.dp(1.0f) * (jElapsedRealtime / 60.0f));
                this.currentRadius = fDp;
                if (fDp > f2) {
                    this.currentRadius = f2;
                }
            } else {
                float fDp2 = f - (AndroidUtilities.dp(1.0f) * (jElapsedRealtime / 60.0f));
                this.currentRadius = fDp2;
                if (fDp2 < f2) {
                    this.currentRadius = f2;
                }
            }
            z = true;
        }
        float f3 = this.transitionProgress;
        if (f3 < 1.0f) {
            float f4 = f3 + (jElapsedRealtime / 225.0f);
            this.transitionProgress = f4;
            if (f4 >= 1.0f) {
                this.transitionProgress = 1.0f;
                z2 = z;
            }
        } else {
            z2 = z;
        }
        float f5 = this.transitionProgress;
        if (f5 < 1.0f) {
            float interpolation = 1.0f - Easings.easeInQuad.getInterpolation(Math.min(1.0f, f5 * 3.0f));
            float interpolation2 = Easings.easeOutQuad.getInterpolation(this.transitionProgress);
            if (interpolation > 0.0f) {
                canvas.drawCircle(this.transitionThumbX + (this.selectorWidth / 2), (this.thumbSize / 2) + measuredHeight, this.currentRadius * interpolation, this.outerPaint1);
            }
            canvas.drawCircle(this.thumbX + (this.selectorWidth / 2), measuredHeight + (this.thumbSize / 2), this.currentRadius * interpolation2, this.outerPaint1);
        } else {
            canvas.drawCircle(this.thumbX + (this.selectorWidth / 2), measuredHeight + (this.thumbSize / 2), this.currentRadius, this.outerPaint1);
        }
        if (z2) {
            postInvalidateOnAnimation();
        }
    }

    public SeekBarAccessibilityDelegate getSeekBarAccessibilityDelegate() {
        return this.seekBarAccessibilityDelegate;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
