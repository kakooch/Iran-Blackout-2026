package ir.resaneh1.iptv.UIView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.ColorUtils;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class InsStoryAvatarView extends AppCompatImageView {
    private static SparseArray<Status> sStatusArray;
    private final float ARC_WIDTH;
    private float CIRCLE_DIA;
    private final float CIRCLE_GRAY_WIDTH;
    private boolean DEBUG;
    private String TAG;
    private Paint addStoryPaint;
    private float bitmapDia;
    private Paint circleGrayPaint;
    private Drawable clockDrawable;
    private float distanceAreaWidth;
    private Drawable errorDrawable;
    private int height;
    private long liveAnimationStartTime;
    private RectF liveBottomTextBackgroundBounds;
    private Paint liveBottomTextBackgroundPaint;
    private RectF liveBottomTextBounds;
    private float liveImageSize;
    private RectF liveInnerCircleBounds;
    private Paint liveInnerCirclePaint;
    private RectF liveStrokeCircleBounds;
    private Paint liveStrokeCirclePaint;
    private Paint liveTextBackgroundPaint;
    private float liveTextStartX;
    private float liveTextStartY;
    private StaticLayout liveTextStaticLayout;
    private RectF liveWaveCircleBounds;
    private Paint liveWaveCirclePaint;
    private Paint liveWaveCompleteCirclePaint;
    private float liveWaveDistance;
    private DecelerateInterpolator liveWaveInterpolator;
    private RadialGradient liveWaveRadialShader;
    private Paint mBitmapPaint;
    private RectF mBitmapRectF;
    private ValueAnimator mCircleAnim;
    private int mCircleDuration;
    private float mCircleWidth;
    private Paint mClockCirclePaint;
    private int mEndColor;
    private Paint mErrorCirclePaint;
    private boolean mIsFirstCircle;
    private ValueAnimator mRotateAnim;
    private float mRotateDegree;
    private int mRotateDuration;
    private float mScale;
    private int mStartColor;
    private Status mStatus;
    private ValueAnimator mTouchAnim;
    private Paint mTrackPaint;
    private Paint mTrackPaint2;
    private RectF mTrackRectF;
    private float miniIconCenterX;
    private float miniIconCenterY;
    private int miniIconWidth;
    private Paint paintClicked;
    private Paint paintError;
    private Drawable plusDrawable;
    private float strokeWidth;
    private int width;

    public enum Status {
        LOADING,
        LOADING_GRAY,
        CLICKED,
        UNCLICKED,
        NONE,
        SENDINGSTORY,
        ERRORSENDING,
        ADDSTORY,
        LIVE
    }

    static {
        SparseArray<Status> sparseArray = new SparseArray<>(4);
        sStatusArray = sparseArray;
        sparseArray.put(0, Status.LOADING);
        sStatusArray.put(1, Status.CLICKED);
        sStatusArray.put(2, Status.UNCLICKED);
        sStatusArray.put(3, Status.NONE);
        sStatusArray.put(4, Status.SENDINGSTORY);
    }

    public InsStoryAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CIRCLE_GRAY_WIDTH = AndroidUtilities.dp(0.6f);
        this.TAG = "InsLoadingView";
        this.DEBUG = false;
        this.ARC_WIDTH = AndroidUtilities.dp(5.0f);
        this.CIRCLE_DIA = 0.97f;
        this.strokeWidth = 0.03f;
        this.distanceAreaWidth = 0.02f;
        this.width = 0;
        this.height = 0;
        this.mStatus = Status.NONE;
        this.mRotateDuration = 4000;
        this.mCircleDuration = 6000;
        this.bitmapDia = (0.97f - 0.03f) - 0.02f;
        this.mIsFirstCircle = true;
        this.mStartColor = Color.rgb(237, 184, 110);
        this.mEndColor = Color.rgb(160, 26, 145);
        this.mScale = 1.0f;
        updateVariablesFromXml(context, attributeSet);
        init(context, attributeSet);
    }

    public InsStoryAvatarView setCircleDuration(int i) {
        this.mCircleDuration = i;
        this.mCircleAnim.setDuration(i);
        return this;
    }

    public InsStoryAvatarView setRotateDuration(int i) {
        this.mRotateDuration = i;
        this.mRotateAnim.setDuration(i);
        return this;
    }

    public void setStatus(Status status) {
        Status status2 = Status.LIVE;
        boolean z = status == status2 || this.mStatus == status2;
        Status status3 = Status.LOADING;
        if (status == status3 && this.mStatus == Status.CLICKED) {
            this.mStatus = Status.LOADING_GRAY;
        } else {
            this.mStatus = status;
        }
        if (z) {
            this.mScale = 1.0f;
            float f = this.strokeWidth;
            float f2 = 1.0f - f;
            this.CIRCLE_DIA = f2;
            this.bitmapDia = (f2 - f) - this.distanceAreaWidth;
            this.width = 0;
            this.mTrackPaint = null;
            this.mTrackPaint2 = null;
            this.mBitmapRectF = null;
            this.mTrackRectF = null;
            this.mBitmapPaint = null;
            this.liveBottomTextBounds = null;
            if (this.mStatus == status2) {
                this.liveStrokeCirclePaint = null;
            }
        }
        Status status4 = this.mStatus;
        if (status4 == status3 || status4 == Status.LOADING_GRAY) {
            startAnim();
        }
        invalidate();
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public void setStartColor(int i) {
        this.mStartColor = i;
        this.mTrackPaint = null;
    }

    public void setEndColor(int i) {
        this.mEndColor = i;
        this.mTrackPaint = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMin;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.DEBUG) {
            Log.d(this.TAG, String.format("onMeasure widthMeasureSpec: %s -- %s", Integer.valueOf(mode), Integer.valueOf(size)));
            Log.d(this.TAG, String.format("onMeasure heightMeasureSpec: %s -- %s", Integer.valueOf(mode2), Integer.valueOf(size2)));
        }
        if (mode == 1073741824 && mode2 == 1073741824) {
            iMin = Math.min(size, size2);
        } else {
            iMin = Math.min(Math.min(size, size2), 300);
        }
        setMeasuredDimension(iMin, iMin);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        measureValueIfNeeded(canvas);
        initPaints();
        initRectFs();
        Status status = this.mStatus;
        Status status2 = Status.LIVE;
        if (status == status2) {
            drawLiveInnerCircle(canvas);
            canvas.save();
        }
        float f = this.mScale;
        canvas.scale(f, f, centerX(), centerY());
        if (this.mStatus == status2) {
            canvas.restore();
        } else {
            drawBitmap(canvas);
        }
        switch (AnonymousClass5.$SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[this.mStatus.ordinal()]) {
            case 1:
                drawTrack(canvas, this.mTrackPaint);
                break;
            case 2:
                drawTrack(canvas, this.mTrackPaint2);
                break;
            case 3:
                drawCircle(canvas, this.mTrackPaint);
                break;
            case 4:
                drawClickedCircle(canvas);
                break;
            case 6:
                drawClickedCircle(canvas);
                drawClock(canvas, this.mClockCirclePaint);
                break;
            case 7:
                drawErrorCircle(canvas);
                drawErrorDrawable(canvas, this.mErrorCirclePaint);
                break;
            case 8:
                drawPlus(canvas, this.addStoryPaint);
                break;
            case 9:
                drawLive(canvas);
                break;
        }
        if (this.mStatus == status2) {
            canvas.save();
            float f2 = this.mScale;
            canvas.scale(f2, f2, centerX(), centerY());
            drawBitmap(canvas);
            canvas.restore();
            updateLiveAnimation();
        }
    }

    /* renamed from: ir.resaneh1.iptv.UIView.InsStoryAvatarView$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status = iArr;
            try {
                iArr[Status.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[Status.LOADING_GRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[Status.UNCLICKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[Status.CLICKED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[Status.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[Status.SENDINGSTORY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[Status.ERRORSENDING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[Status.ADDSTORY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$UIView$InsStoryAvatarView$Status[Status.LIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private void drawErrorDrawable(Canvas canvas, Paint paint) {
        canvas.drawCircle(this.miniIconCenterX, this.miniIconCenterY, this.miniIconWidth + AndroidUtilities.dp(1.5f), paint);
        Drawable drawable = this.errorDrawable;
        float f = this.miniIconCenterX;
        float f2 = (int) (this.miniIconWidth * 0.6f);
        float f3 = (3.0f * f2) / 17.0f;
        float f4 = this.miniIconCenterY;
        drawable.setBounds((int) (f - f3), (int) (f4 - f2), (int) (f + f3), (int) (f4 + f2));
        this.errorDrawable.draw(canvas);
    }

    private void measureValueIfNeeded(Canvas canvas) {
        if (this.width != canvas.getWidth()) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            float f = ((this.width / 2.0f) + ((r1 / 2) * 0.757106f)) * this.CIRCLE_DIA;
            this.miniIconCenterX = f;
            this.miniIconCenterY = f;
        }
        if (this.mStatus == Status.LIVE && this.liveBottomTextBounds == null) {
            this.bitmapDia = (this.CIRCLE_DIA - this.strokeWidth) - 0.19f;
            this.liveAnimationStartTime = System.currentTimeMillis();
            String string = LocaleController.getString("LIVE", R.string.rubinoStoryLiveText);
            float fDp = AndroidUtilities.dp(14.0f);
            float f2 = this.width * 0.3f;
            float f3 = this.height - fDp;
            this.liveBottomTextBounds = new RectF(f2, f3, (this.width * 0.4f) + f2, fDp + f3);
            float fDpf2 = AndroidUtilities.dpf2(1.5f);
            RectF rectF = new RectF();
            this.liveBottomTextBackgroundBounds = rectF;
            RectF rectF2 = this.liveBottomTextBounds;
            rectF.left = rectF2.left + fDpf2;
            rectF.top = rectF2.top + fDpf2;
            rectF.right = rectF2.right - fDpf2;
            rectF.bottom = rectF2.bottom;
            TextPaint textPaint = new TextPaint();
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(AndroidUtilities.density * 7.5f);
            textPaint.setTypeface(Theme.getRubinoTypeFaceMedium());
            textPaint.setColor(-1);
            float fMeasureText = textPaint.measureText(string);
            if (Build.VERSION.SDK_INT >= 23) {
                this.liveTextStaticLayout = StaticLayout.Builder.obtain(string, 0, string.length(), textPaint, (int) fMeasureText).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
            } else {
                this.liveTextStaticLayout = new StaticLayout(string, textPaint, (int) fMeasureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            int[] iArr = {-3669628, -2096836};
            if (this.liveTextBackgroundPaint == null) {
                this.liveTextBackgroundPaint = getLiveBottomTextBackgroundPaint();
            }
            Paint paint = this.liveTextBackgroundPaint;
            RectF rectF3 = this.liveBottomTextBackgroundBounds;
            paint.setShader(new LinearGradient(rectF3.left, rectF3.top, rectF3.right, rectF3.bottom, iArr, (float[]) null, Shader.TileMode.MIRROR));
            this.liveStrokeCircleBounds = new RectF(getWidth() * (1.0f - this.CIRCLE_DIA), getWidth() * (1.0f - this.CIRCLE_DIA), getWidth() * this.CIRCLE_DIA, getHeight() * this.CIRCLE_DIA);
            float fDpf22 = AndroidUtilities.dpf2(3.0f);
            RectF rectF4 = new RectF();
            this.liveInnerCircleBounds = rectF4;
            RectF rectF5 = this.liveStrokeCircleBounds;
            float f4 = rectF5.left + fDpf22;
            rectF4.left = f4;
            rectF4.top = rectF5.top + fDpf22;
            rectF4.right = rectF5.right - fDpf22;
            rectF4.bottom = rectF5.bottom - fDpf22;
            float f5 = (this.width * (1.0f - this.bitmapDia)) - f4;
            this.liveWaveDistance = f5;
            this.liveWaveDistance = f5 * 0.98f;
            RectF rectF6 = new RectF();
            this.liveWaveCircleBounds = rectF6;
            RectF rectF7 = this.liveInnerCircleBounds;
            float f6 = rectF7.left;
            float f7 = this.liveWaveDistance;
            float f8 = f6 + f7;
            rectF6.left = f8;
            rectF6.top = rectF7.top + f7;
            rectF6.bottom = rectF7.bottom - f7;
            float f9 = rectF7.right - f7;
            rectF6.right = f9;
            this.liveImageSize = f9 - f8;
            RectF rectF8 = this.liveWaveCircleBounds;
            this.liveWaveRadialShader = new RadialGradient(this.width / 2.0f, this.height / 2.0f, (rectF8.right - rectF8.left) / 2.0f, new int[]{0, 0, 0, 0, -1}, (float[]) null, Shader.TileMode.CLAMP);
            int[] iArr2 = {0, 0, 0, 0, ColorUtils.setAlphaComponent(16777215, 84)};
            RectF rectF9 = this.liveInnerCircleBounds;
            RadialGradient radialGradient = new RadialGradient(this.width / 2.0f, this.height / 2.0f, (rectF9.right - rectF9.left) / 2.0f, iArr2, (float[]) null, Shader.TileMode.CLAMP);
            if (this.liveWaveCirclePaint == null) {
                this.liveWaveCirclePaint = getLiveWaveCirclePaint();
            }
            this.liveWaveCirclePaint.setShader(this.liveWaveRadialShader);
            if (this.liveWaveCompleteCirclePaint == null) {
                this.liveWaveCompleteCirclePaint = getLiveWaveCirclePaint();
            }
            this.liveWaveCompleteCirclePaint.setShader(radialGradient);
            float width = this.liveTextStaticLayout.getWidth();
            RectF rectF10 = this.liveBottomTextBounds;
            float f10 = rectF10.right - rectF10.left;
            float height = this.liveTextStaticLayout.getHeight();
            RectF rectF11 = this.liveBottomTextBounds;
            float f11 = rectF11.bottom + fDpf2;
            float f12 = rectF11.top;
            this.liveTextStartY = f12 + (((f11 - f12) - height) / 2.0f);
            this.liveTextStartX = rectF11.left + ((f10 - width) / 2.0f);
        }
    }

    private void drawClock(Canvas canvas, Paint paint) {
        canvas.drawCircle(this.miniIconCenterX, this.miniIconCenterY, this.miniIconWidth + AndroidUtilities.dp(1.5f), paint);
        Drawable drawable = this.clockDrawable;
        float f = this.miniIconCenterX;
        int i = this.miniIconWidth;
        float f2 = this.miniIconCenterY;
        drawable.setBounds((int) (f - i), (int) (f2 - i), (int) (f + i), (int) (f2 + i));
        this.clockDrawable.draw(canvas);
    }

    private void drawPlus(Canvas canvas, Paint paint) {
        canvas.drawCircle(this.miniIconCenterX, this.miniIconCenterY, this.miniIconWidth + AndroidUtilities.dp(1.5f), paint);
        Drawable drawable = this.plusDrawable;
        float f = this.miniIconCenterX;
        int i = this.miniIconWidth;
        float f2 = this.miniIconCenterY;
        drawable.setBounds((int) (f - i), (int) (f2 - i), (int) (f + i), (int) (f2 + i));
        this.plusDrawable.draw(canvas);
    }

    private void drawLiveInnerCircle(Canvas canvas) {
        try {
            canvas.drawOval(this.liveInnerCircleBounds, this.liveInnerCirclePaint);
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    private void drawLive(Canvas canvas) {
        canvas.drawOval(this.liveWaveCircleBounds, this.liveWaveCirclePaint);
        canvas.drawOval(this.liveInnerCircleBounds, this.liveWaveCompleteCirclePaint);
        canvas.drawOval(this.liveStrokeCircleBounds, this.liveStrokeCirclePaint);
        canvas.drawRoundRect(this.liveBottomTextBounds, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.liveBottomTextBackgroundPaint);
        canvas.drawRoundRect(this.liveBottomTextBackgroundBounds, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), this.liveTextBackgroundPaint);
        canvas.save();
        canvas.translate(this.liveTextStartX, this.liveTextStartY);
        this.liveTextStaticLayout.draw(canvas);
        canvas.restore();
    }

    private void updateLiveAnimation() {
        float fCurrentTimeMillis = (System.currentTimeMillis() - this.liveAnimationStartTime) / 1000.0f;
        double d = fCurrentTimeMillis;
        if (d <= 0.6d) {
            this.mScale = (0.1f * fCurrentTimeMillis) + 1.0f;
        } else {
            this.mScale = 1.06f - (((((fCurrentTimeMillis - 0.6f) * 100.0f) / 0.4f) / 100.0f) * 0.06f);
        }
        if (fCurrentTimeMillis >= 1.0f) {
            this.liveAnimationStartTime = System.currentTimeMillis();
            this.mScale = 1.0f;
            RectF rectF = this.liveWaveCircleBounds;
            RectF rectF2 = this.liveInnerCircleBounds;
            float f = rectF2.left;
            float f2 = this.liveWaveDistance;
            rectF.left = f + f2;
            rectF.top = rectF2.top + f2;
            rectF.bottom = rectF2.bottom - f2;
            rectF.right = rectF2.right - f2;
        }
        float f3 = d > 0.92d ? fCurrentTimeMillis - 0.92f : fCurrentTimeMillis + 0.08f;
        float interpolation = this.liveWaveDistance * this.liveWaveInterpolator.getInterpolation(f3);
        RectF rectF3 = this.liveWaveCircleBounds;
        RectF rectF4 = this.liveInnerCircleBounds;
        float f4 = rectF4.left;
        float f5 = this.liveWaveDistance;
        rectF3.left = (f4 + f5) - interpolation;
        rectF3.top = (rectF4.top + f5) - interpolation;
        rectF3.right = (rectF4.right - f5) + interpolation;
        rectF3.bottom = (rectF4.bottom - f5) + interpolation;
        int i = (int) (100.0f - (f3 * 100.0f));
        if (i < 0) {
            i = 0;
        }
        int alphaComponent = ColorUtils.setAlphaComponent(16777215, i);
        RectF rectF5 = this.liveWaveCircleBounds;
        RadialGradient radialGradient = new RadialGradient(this.width / 2.0f, this.height / 2.0f, (rectF5.right - rectF5.left) / 2.0f, new int[]{0, 0, 0, 0, alphaComponent}, (float[]) null, Shader.TileMode.CLAMP);
        this.liveWaveRadialShader = radialGradient;
        this.liveWaveCirclePaint.setShader(radialGradient);
        invalidate();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (this.DEBUG) {
            Log.d(this.TAG, "onVisibilityChanged");
        }
        if (i == 0) {
            if (getStatus() == Status.LOADING || getStatus() == Status.LOADING_GRAY) {
                startAnim();
            }
        } else {
            endAnim();
        }
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.DEBUG) {
            Log.d(this.TAG, "onSizeChanged");
        }
        this.mBitmapRectF = null;
        this.mTrackRectF = null;
        this.mBitmapPaint = null;
        this.mTrackPaint = null;
        this.mClockCirclePaint = null;
        this.liveBottomTextBackgroundPaint = null;
        this.liveTextBackgroundPaint = null;
        this.liveStrokeCirclePaint = null;
        this.liveInnerCirclePaint = null;
        this.liveWaveCirclePaint = null;
        this.liveWaveCompleteCirclePaint = null;
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.DEBUG) {
            Log.d(this.TAG, "setImageDrawable");
        }
        this.mBitmapPaint = null;
        super.setImageDrawable(drawable);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            parseAttrs(context, attributeSet);
        }
        onCreateAnimators();
    }

    private void parseAttrs(Context context, AttributeSet attributeSet) {
        int i = this.mStartColor;
        int i2 = this.mEndColor;
        int i3 = this.mCircleDuration;
        int i4 = this.mRotateDuration;
        if (this.DEBUG) {
            Log.d(this.TAG, "parseAttrs start_color: " + i);
            Log.d(this.TAG, "parseAttrs end_color: " + i2);
            Log.d(this.TAG, "parseAttrs rotate_duration: " + i4);
            Log.d(this.TAG, "parseAttrs circle_duration: " + i3);
            Log.d(this.TAG, "parseAttrs status: 3");
        }
        if (i3 != this.mCircleDuration) {
            setCircleDuration(i3);
        }
        if (i4 != this.mRotateDuration) {
            setRotateDuration(i4);
        }
        setStartColor(i);
        setEndColor(i2);
        setStatus(sStatusArray.get(3));
    }

    private void initPaints() {
        if (this.mBitmapPaint == null) {
            this.mBitmapPaint = getBitmapPaint();
        }
        if (this.mTrackPaint == null) {
            this.mTrackPaint = getTrackPaint();
        }
        if (this.mTrackPaint2 == null) {
            this.mTrackPaint2 = getTrackPaint2();
        }
        if (this.mClockCirclePaint == null) {
            this.mClockCirclePaint = getClockPaint();
        }
        if (this.addStoryPaint == null) {
            this.addStoryPaint = getAddStoryPaint();
        }
        if (this.mErrorCirclePaint == null) {
            this.mErrorCirclePaint = getErrorPaint();
        }
        if (this.circleGrayPaint == null) {
            Paint paint = new Paint(1);
            this.circleGrayPaint = paint;
            paint.setColor(671088640);
            this.circleGrayPaint.setStyle(Paint.Style.STROKE);
            this.circleGrayPaint.setStrokeWidth(this.CIRCLE_GRAY_WIDTH);
        }
        if (this.liveBottomTextBackgroundPaint == null) {
            this.liveBottomTextBackgroundPaint = getLiveBottomTextBackgroundPaint();
        }
        if (this.liveTextBackgroundPaint == null) {
            this.liveTextBackgroundPaint = getLiveTextBackgroundPaint();
        }
        if (this.liveStrokeCirclePaint == null) {
            this.liveStrokeCirclePaint = getLiveStrokeCirclePaint();
        }
        if (this.liveInnerCirclePaint == null) {
            this.liveInnerCirclePaint = getLiveInnerCirclePaint();
        }
        if (this.liveWaveCirclePaint == null) {
            this.liveWaveCirclePaint = getLiveWaveCirclePaint();
        }
        if (this.liveWaveCompleteCirclePaint == null) {
            this.liveWaveCompleteCirclePaint = getLiveWaveCirclePaint();
        }
        Resources resources = getContext().getResources();
        this.clockDrawable = resources.getDrawable(R.drawable.msg_clock).mutate();
        this.errorDrawable = resources.getDrawable(R.drawable.msg_warning).mutate();
        this.plusDrawable = resources.getDrawable(R.drawable.rubino_add_story_plus).mutate();
    }

    private Paint getClockPaint() {
        Paint paint = new Paint(1);
        paint.setColor(-3684409);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private Paint getAddStoryPaint() {
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private Paint getLiveBottomTextBackgroundPaint() {
        Paint paint = new Paint(1);
        paint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private Paint getLiveTextBackgroundPaint() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private Paint getLiveStrokeCirclePaint() {
        Paint paint = new Paint(1);
        int[] iArr = {-3669628, -9174843, -2096836};
        SweepGradient sweepGradient = new SweepGradient(getWidth() / 2.0f, getHeight() / 2.0f, iArr, new float[]{0.15f, 0.3f, 1.0f});
        Matrix matrix = new Matrix();
        matrix.setRotate(90.0f, getWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        sweepGradient.setLocalMatrix(matrix);
        new LinearGradient(0.0f, 0.0f, ((getWidth() * this.CIRCLE_DIA) * (360.0f - (this.ARC_WIDTH * 4.0f))) / 360.0f, getHeight() * this.strokeWidth, iArr, (float[]) null, Shader.TileMode.CLAMP);
        paint.setShader(sweepGradient);
        setPaintStroke(paint);
        return paint;
    }

    private Paint getLiveInnerCirclePaint() {
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    public Paint getLiveWaveCirclePaint() {
        Paint paint = new Paint(1);
        setPaintStroke(paint);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private Paint getErrorPaint() {
        Paint paint = new Paint(1);
        paint.setColor(-5242848);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private void initRectFs() {
        if (this.mBitmapRectF == null) {
            this.mBitmapRectF = new RectF(getWidth() * (1.0f - this.bitmapDia), getWidth() * (1.0f - this.bitmapDia), getWidth() * this.bitmapDia, getHeight() * this.bitmapDia);
        }
        if (this.mTrackRectF == null) {
            this.mTrackRectF = new RectF(getWidth() * (1.0f - this.CIRCLE_DIA), getWidth() * (1.0f - this.CIRCLE_DIA), getWidth() * this.CIRCLE_DIA, getHeight() * this.CIRCLE_DIA);
        }
    }

    private float centerX() {
        return getWidth() / 2;
    }

    private float centerY() {
        return getHeight() / 2;
    }

    private void onCreateAnimators() {
        this.liveWaveInterpolator = new DecelerateInterpolator(0.8f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 180.0f, 360.0f);
        this.mRotateAnim = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.resaneh1.iptv.UIView.InsStoryAvatarView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InsStoryAvatarView.this.mRotateDegree = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                InsStoryAvatarView.this.postInvalidate();
            }
        });
        this.mRotateAnim.setInterpolator(new LinearInterpolator());
        this.mRotateAnim.setDuration(this.mRotateDuration);
        this.mRotateAnim.setRepeatCount(-1);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.mCircleAnim = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
        this.mCircleAnim.setDuration(this.mCircleDuration);
        this.mCircleAnim.setRepeatCount(-1);
        this.mCircleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.resaneh1.iptv.UIView.InsStoryAvatarView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (InsStoryAvatarView.this.mIsFirstCircle) {
                    InsStoryAvatarView.this.mCircleWidth = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } else {
                    InsStoryAvatarView.this.mCircleWidth = ((Float) valueAnimator.getAnimatedValue()).floatValue() - 360.0f;
                }
                InsStoryAvatarView.this.postInvalidate();
            }
        });
        this.mCircleAnim.addListener(new Animator.AnimatorListener() { // from class: ir.resaneh1.iptv.UIView.InsStoryAvatarView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                InsStoryAvatarView.this.mIsFirstCircle = !r2.mIsFirstCircle;
            }
        });
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mTouchAnim = valueAnimator;
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        this.mTouchAnim.setDuration(200L);
        this.mTouchAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.resaneh1.iptv.UIView.InsStoryAvatarView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                InsStoryAvatarView.this.mScale = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                InsStoryAvatarView.this.postInvalidate();
            }
        });
        if (getStatus() == Status.LOADING || getStatus() == Status.LOADING_GRAY) {
            startAnim();
        }
    }

    private void drawBitmap(Canvas canvas) {
        canvas.drawOval(this.mBitmapRectF, this.mBitmapPaint);
        canvas.drawCircle(this.mBitmapRectF.centerX(), this.mBitmapRectF.centerY(), (this.mBitmapRectF.width() / 2.0f) - this.CIRCLE_GRAY_WIDTH, this.circleGrayPaint);
    }

    private void drawTrack(Canvas canvas, Paint paint) {
        canvas.rotate(this.mRotateDegree, centerX(), centerY());
        canvas.rotate(this.ARC_WIDTH, centerX(), centerY());
        if (this.DEBUG) {
            Log.d(this.TAG, "circleWidth:" + this.mCircleWidth);
        }
        float f = this.mCircleWidth;
        float f2 = 8.0f;
        float f3 = 360.0f;
        if (f < 0.0f) {
            float f4 = f + 360.0f;
            canvas.drawArc(this.mTrackRectF, f4, 360.0f - f4, false, paint);
            float f5 = this.mCircleWidth + 360.0f;
            while (true) {
                float f6 = this.ARC_WIDTH;
                if (f5 <= f6) {
                    return;
                }
                f2 -= 0.2f;
                float f7 = f5 - f6;
                canvas.drawArc(this.mTrackRectF, f7, f2, false, paint);
                f5 = f7;
            }
        } else {
            for (int i = 0; i <= 4; i++) {
                float f8 = this.ARC_WIDTH;
                float f9 = i;
                float f10 = f8 * f9;
                float f11 = this.mCircleWidth;
                if (f10 > f11) {
                    break;
                }
                canvas.drawArc(this.mTrackRectF, f11 - (f8 * f9), i + 8, false, paint);
            }
            float f12 = this.mCircleWidth;
            float f13 = this.ARC_WIDTH;
            if (f12 > f13 * 4.0f) {
                canvas.drawArc(this.mTrackRectF, 0.0f, f12 - (f13 * 4.0f), false, paint);
            }
            float f14 = ((360.0f - this.mCircleWidth) * 8.0f) / 360.0f;
            if (this.DEBUG) {
                Log.d(this.TAG, "width:" + f14);
            }
            while (f14 > 0.0f) {
                float f15 = this.ARC_WIDTH;
                if (f3 <= f15) {
                    return;
                }
                float f16 = f14 - 0.2f;
                f3 -= f15;
                canvas.drawArc(this.mTrackRectF, f3, f16, false, paint);
                f14 = f16;
            }
        }
    }

    private void drawCircle(Canvas canvas, Paint paint) {
        canvas.drawOval(new RectF(getWidth() * (1.0f - this.CIRCLE_DIA), getWidth() * (1.0f - this.CIRCLE_DIA), getWidth() * this.CIRCLE_DIA, getHeight() * this.CIRCLE_DIA), paint);
    }

    private void drawClickedCircle(Canvas canvas) {
        if (this.paintClicked == null) {
            Paint paint = new Paint(1);
            this.paintClicked = paint;
            paint.setColor(-3684409);
            this.paintClicked.setStyle(Paint.Style.STROKE);
            this.paintClicked.setStrokeWidth((getHeight() * this.strokeWidth) / 2.0f);
        }
        drawCircle(canvas, this.paintClicked);
    }

    private void drawErrorCircle(Canvas canvas) {
        if (this.paintError == null) {
            Paint paint = new Paint(1);
            this.paintError = paint;
            paint.setColor(-5242848);
            setPaintStroke(this.paintError);
        }
        drawCircle(canvas, this.paintError);
    }

    private void startAnim() {
        this.mRotateAnim.start();
        this.mCircleAnim.start();
    }

    private void endAnim() {
        this.mRotateAnim.end();
        this.mCircleAnim.end();
    }

    private Paint getTrackPaint() {
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(0.0f, 0.0f, ((getWidth() * this.CIRCLE_DIA) * (360.0f - (this.ARC_WIDTH * 4.0f))) / 360.0f, getHeight() * this.strokeWidth, this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP));
        setPaintStroke(paint);
        return paint;
    }

    private Paint getTrackPaint2() {
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(0.0f, 0.0f, ((getWidth() * this.CIRCLE_DIA) * (360.0f - (this.ARC_WIDTH * 4.0f))) / 360.0f, getHeight() * this.strokeWidth, -3684409, -2039584, Shader.TileMode.CLAMP));
        setPaintStroke(paint);
        return paint;
    }

    private void setPaintStroke(Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getHeight() * this.strokeWidth);
    }

    private Paint getBitmapPaint() {
        float width;
        Paint paint = new Paint(1);
        Drawable drawable = getDrawable();
        Matrix matrix = new Matrix();
        if (drawable == null) {
            return paint;
        }
        Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapDrawableToBitmap, tileMode, tileMode);
        int iMin = Math.min(bitmapDrawableToBitmap.getWidth(), bitmapDrawableToBitmap.getHeight());
        Status status = this.mStatus;
        Status status2 = Status.LIVE;
        if (status == status2) {
            width = this.liveImageSize;
        } else {
            width = getWidth();
        }
        float f = (width * 1.0f) / iMin;
        matrix.setScale(f, f);
        if (this.mStatus == status2) {
            matrix.postTranslate((-((bitmapDrawableToBitmap.getWidth() * f) - getWidth())) / 2.0f, (-((bitmapDrawableToBitmap.getHeight() * f) - getHeight())) / 2.0f);
        } else if (bitmapDrawableToBitmap.getWidth() > bitmapDrawableToBitmap.getHeight()) {
            matrix.postTranslate((-((bitmapDrawableToBitmap.getWidth() * f) - getWidth())) / 2.0f, 0.0f);
        } else {
            matrix.postTranslate(0.0f, (-((bitmapDrawableToBitmap.getHeight() * f) - getHeight())) / 2.0f);
        }
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        return paint;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        } catch (IllegalArgumentException unused) {
            bitmapCreateBitmap = Bitmap.createBitmap(20, 20, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void updateVariablesFromXml(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, org.rbmain.messenger.R.styleable.InsStoryAvatarView, 0, 0);
        this.strokeWidth = typedArrayObtainStyledAttributes.getFloat(0, 0.03f);
        this.distanceAreaWidth = typedArrayObtainStyledAttributes.getFloat(1, 0.02f);
        this.miniIconWidth = AndroidUtilities.dp(typedArrayObtainStyledAttributes.getFloat(2, 7.5f));
        float f = this.strokeWidth;
        float f2 = 1.0f - f;
        this.CIRCLE_DIA = f2;
        this.bitmapDia = (f2 - f) - this.distanceAreaWidth;
        typedArrayObtainStyledAttributes.recycle();
    }
}
