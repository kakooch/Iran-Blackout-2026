package ir.resaneh1.iptv.story.emojiSlider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import ir.resaneh1.iptv.story.ExtraView;
import ir.resaneh1.iptv.story.emojiSlider.EmojiSticker;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class EmojiSeekbar extends FrameLayout {
    public static int heightPreview = AndroidUtilities.dp(60.0f);
    private float average;
    private LinearGradient averageGradientShader;
    private int averagePadding;
    private Paint averagePaint;
    private int averageR;
    private String average_answer_hint;
    private Paint backgroundPaint;
    private RectF backgroundRectF;
    private Delegate delegate;
    private boolean draggingEmoji;
    private boolean drawAverage;
    private boolean drawProgress;
    private String emoji;
    private float emojiCurrentX;
    private float emojiCurrentY;
    private EmojiSticker.EmojiMode emojiMode;
    private int emojiSizePreviewPx;
    private int emojiSizePx;
    private StaticLayout emojiStaticLayout;
    private float emojiX;
    private boolean enableAverageHint;
    private Paint erasePaint;
    private ExtraView extraView;
    private LinearGradient foregroundGradientShader;
    private Paint foregroundPaint;
    private RectF foregroundRectF;
    private int gradientEndColor;
    private int gradientStartColor;
    private float height;
    private boolean isGradient;
    private boolean lockDragging;
    private boolean lockTouchMode;
    private int paddingHeight;
    private int paddingTouch;
    private int paddingWidth;
    private int parentOffsetY;
    private float percentage;
    private int previewAnimDuration;
    private long previewAnimationStartTime;
    private Interpolator previewInterpolator;
    private boolean previewMode;
    private int profileAnimDuration;
    private long profileAnimationStartTime;
    private RectF profileBounds;
    private int profileImagePadding;
    private int profileImageSize;
    private AccelerateDecelerateInterpolator profileInterpolator;
    private float rectBottom;
    private float rectLeft;
    private float rectRight;
    private float rectTop;
    private boolean showProfileImage;
    private float sliderHeight;
    private float sliderPreviewHeight;
    private boolean startProfileAnim;
    private TextPaint textPaint;
    private Bitmap userProfileImage;
    private float width;
    private float zoomAnim;

    public interface Delegate {
        void onChangedProgress(float f);

        Point realValueOfEventPosition(float f, float f2);
    }

    private float convertXtoZeroOneRang(long j, int i) {
        return j / i;
    }

    private float convertYToRealRang(float f, float f2) {
        return f2 * f;
    }

    public EmojiSeekbar(Context context, Delegate delegate) {
        super(context);
        this.profileInterpolator = new AccelerateDecelerateInterpolator();
        this.previewInterpolator = new Interpolator(this) { // from class: ir.resaneh1.iptv.story.emojiSlider.EmojiSeekbar.1
            AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
            float animStep = 0.15f;
            float stopStep = 0.15f + 0.35f;

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = this.animStep;
                if (f <= f2) {
                    return this.accelerateDecelerateInterpolator.getInterpolation(f / f2);
                }
                if (f2 < f && f < this.stopStep) {
                    return 1.0f;
                }
                float f3 = this.stopStep;
                if (f >= f3 && f <= f2 + f3) {
                    return 1.0f - this.accelerateDecelerateInterpolator.getInterpolation((f - f3) / f2);
                }
                if (f > f2 + f3) {
                    return 0.0f;
                }
                return f;
            }
        };
        this.gradientStartColor = -5822301;
        this.gradientEndColor = -2216153;
        this.backgroundRectF = new RectF();
        this.foregroundRectF = new RectF();
        this.backgroundPaint = new Paint(1);
        this.foregroundPaint = new Paint(1);
        this.averagePaint = new Paint(1);
        this.textPaint = new TextPaint(1);
        this.profileBounds = new RectF();
        this.average_answer_hint = "Average answer.";
        this.paddingHeight = AndroidUtilities.dp(4.0f);
        this.paddingWidth = AndroidUtilities.dp(30.0f);
        this.paddingTouch = AndroidUtilities.dp(4.0f);
        this.emojiSizePx = AndroidUtilities.dp(32.0f);
        this.emojiSizePreviewPx = AndroidUtilities.dp(55.0f);
        this.averageR = AndroidUtilities.dp(10.0f);
        this.profileImagePadding = AndroidUtilities.dp(1.0f);
        this.profileImageSize = AndroidUtilities.dp(32.0f);
        this.averagePadding = AndroidUtilities.dp(2.0f);
        this.sliderHeight = AndroidUtilities.dp(10.0f);
        this.sliderPreviewHeight = AndroidUtilities.dp(17.0f);
        this.drawProgress = true;
        this.previewAnimDuration = 3000;
        this.profileAnimDuration = 200;
        this.previewAnimationStartTime = 0L;
        this.profileAnimationStartTime = 0L;
        this.percentage = 10.0f;
        this.enableAverageHint = true;
        this.emoji = "😍";
        this.delegate = delegate;
        setClipChildren(false);
        setClipToPadding(false);
        init();
    }

    private void init() {
        setLayerType(1, null);
        initPaints();
        initEmoji();
        setBackgroundColor(0);
        int i = this.paddingHeight;
        setPadding(0, i, 0, i);
    }

    private void initPaints() {
        this.averagePaint.setColor(this.gradientStartColor);
        this.foregroundPaint.setStyle(Paint.Style.FILL);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        Paint paint = new Paint(1);
        this.erasePaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private void initEmoji() {
        if (this.previewMode) {
            this.emojiSizePx = this.emojiSizePreviewPx;
        }
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(this.emojiSizePx);
        setEmoji(this.emoji);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.emojiMode == EmojiSticker.EmojiMode.PREVIEW) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(heightPreview, 1073741824));
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.emojiStaticLayout.getHeight() + (this.paddingHeight * 2), 1073741824));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        this.width = f;
        float f2 = i2;
        this.height = f2;
        float f3 = this.previewMode ? this.sliderPreviewHeight : this.sliderHeight;
        this.sliderHeight = f3;
        int i5 = this.paddingWidth;
        float f4 = f - (i5 * 2);
        this.width = f4;
        this.rectBottom = (f2 / 2.0f) + (f3 / 2.0f);
        this.rectTop = (f2 / 2.0f) - (f3 / 2.0f);
        this.rectLeft = i5;
        this.rectRight = f4 + i5;
        setupBackgroundRect();
        setupForegroundRect();
    }

    public boolean onTouch(float f, float f2, int i) {
        Delegate delegate;
        Delegate delegate2;
        Delegate delegate3;
        if (!this.previewMode && !this.lockTouchMode) {
            int i2 = this.parentOffsetY;
            float f3 = f2 - i2;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                    }
                } else if (this.draggingEmoji) {
                    this.draggingEmoji = false;
                    ExtraView extraView = this.extraView;
                    if (extraView != null && (delegate3 = this.delegate) != null) {
                        extraView.onEmojiActionUpEvent(delegate3.realValueOfEventPosition(this.emojiX, this.emojiCurrentY + i2 + (this.emojiStaticLayout.getHeight() / 2.0f)), this.emojiStaticLayout.getHeight());
                    }
                    if (!this.lockDragging && this.emojiMode == EmojiSticker.EmojiMode.STORY) {
                        this.showProfileImage = true;
                        setFinalPercentage(getPercentage(f));
                        Delegate delegate4 = this.delegate;
                        if (delegate4 != null) {
                            delegate4.onChangedProgress(getPercentage(checkBounds(f)));
                        }
                    }
                }
                return true;
            }
            if (emojiTouched(f, f3)) {
                this.draggingEmoji = true;
                ExtraView extraView2 = this.extraView;
                if (extraView2 != null && (delegate = this.delegate) != null) {
                    extraView2.onDraggingEmoji(delegate.realValueOfEventPosition(this.emojiX, this.emojiCurrentY + this.parentOffsetY + (this.emojiStaticLayout.getHeight() / 2.0f)), this.emojiStaticLayout.getHeight() / 2);
                }
            }
            if (this.draggingEmoji && !this.lockDragging) {
                this.showProfileImage = false;
                this.percentage = getPercentage(f);
                invalidate();
                ExtraView extraView3 = this.extraView;
                if (extraView3 != null && (delegate2 = this.delegate) != null) {
                    extraView3.onDraggingEmoji(delegate2.realValueOfEventPosition(checkBounds(f), this.emojiCurrentY + this.parentOffsetY + (this.emojiStaticLayout.getHeight() / 2.0f)), this.emojiStaticLayout.getHeight() / 2);
                }
            }
            return true;
        }
        return false;
    }

    private boolean emojiTouched(float f, float f2) {
        if (!this.drawProgress) {
            return false;
        }
        float f3 = this.emojiCurrentX;
        if (f3 - this.paddingTouch > f) {
            return false;
        }
        float width = f3 + this.emojiStaticLayout.getWidth();
        int i = this.paddingTouch;
        if (f > width + i) {
            return false;
        }
        float f4 = this.emojiCurrentY;
        return f4 - ((float) i) <= f2 && f2 <= (f4 + ((float) this.emojiStaticLayout.getHeight())) + ((float) this.paddingTouch);
    }

    private float getPercentage(float f) {
        return ((f - this.backgroundRectF.left) * 100.0f) / this.width;
    }

    public void setFinalPercentage(float f) {
        if (f == -1.0f) {
            this.drawProgress = false;
        } else {
            this.percentage = f;
            this.showProfileImage = true;
            this.startProfileAnim = true;
            this.drawProgress = true;
            this.profileAnimationStartTime = 0L;
        }
        invalidate();
    }

    public void setAverage(float f) {
        if (f == -1.0f) {
            this.drawAverage = false;
        } else {
            this.drawAverage = true;
            this.average = f;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.foregroundGradientShader == null && this.isGradient) {
            float f = this.rectLeft;
            LinearGradient linearGradient = new LinearGradient(f, this.rectTop, f, this.rectBottom, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.REPEAT);
            this.foregroundGradientShader = linearGradient;
            this.foregroundPaint.setShader(linearGradient);
        }
        this.emojiX = checkBounds(((this.percentage / 100.0f) * this.width) + this.backgroundRectF.left);
        RectF rectF = this.backgroundRectF;
        float f2 = this.sliderHeight;
        canvas.drawRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, this.backgroundPaint);
        if (this.drawProgress) {
            RectF rectF2 = this.foregroundRectF;
            rectF2.right = this.emojiX;
            float f3 = this.sliderHeight;
            canvas.drawRoundRect(rectF2, f3 / 2.0f, f3 / 2.0f, this.foregroundPaint);
        }
        drawAverageIfNeeded(canvas);
        drawProgressPoint(canvas);
        updatePreviewIfNeeded();
        super.onDraw(canvas);
    }

    private void drawHintIfNeeded(float f, float f2) {
        Delegate delegate;
        if (!this.enableAverageHint || (delegate = this.delegate) == null || this.extraView == null) {
            return;
        }
        this.enableAverageHint = false;
        Point pointRealValueOfEventPosition = delegate.realValueOfEventPosition(f, f2 + this.parentOffsetY);
        ExtraView extraView = this.extraView;
        extraView.showHint(this.average_answer_hint, pointRealValueOfEventPosition.x, pointRealValueOfEventPosition.y, (int) ((this.averageR * extraView.getEmojiParentScale()) + AndroidUtilities.dp(10.0f)), true);
    }

    private void drawProgressPoint(Canvas canvas) {
        if (this.drawProgress) {
            this.emojiCurrentX = this.emojiX - (this.emojiStaticLayout.getWidth() / 2.0f);
            this.emojiCurrentY = this.backgroundRectF.bottom - ((this.sliderHeight + this.emojiStaticLayout.getHeight()) / 2.0f);
            drawProfileImageIfNeeded(canvas);
            drawEmojiIfNeeded(canvas);
        }
    }

    private void drawProfileImageIfNeeded(Canvas canvas) {
        Bitmap bitmap;
        if (!this.showProfileImage || (bitmap = this.userProfileImage) == null || bitmap.isRecycled()) {
            return;
        }
        updateProfileAnimIfNeeded();
        canvas.save();
        float f = this.emojiX;
        int i = this.profileImageSize;
        canvas.translate(f - (i / 2.0f), (this.backgroundRectF.bottom - (this.sliderHeight / 2.0f)) - (i / 2.0f));
        RectF rectF = this.profileBounds;
        rectF.top = 0.0f;
        int i2 = this.profileImageSize;
        rectF.bottom = i2;
        rectF.left = 0.0f;
        rectF.right = i2;
        if (this.startProfileAnim) {
            float f2 = this.zoomAnim;
            canvas.scale(f2, f2, i2 / 2.0f, i2 / 2.0f);
        }
        int i3 = this.profileImageSize;
        canvas.drawCircle(i3 / 2.0f, i3 / 2.0f, (i3 / 2.0f) + this.profileImagePadding, this.backgroundPaint);
        if (!this.userProfileImage.isRecycled()) {
            canvas.drawBitmap(this.userProfileImage, (Rect) null, this.profileBounds, this.foregroundPaint);
        }
        canvas.restore();
    }

    private void drawEmojiIfNeeded(Canvas canvas) {
        Bitmap bitmap;
        boolean z = this.showProfileImage;
        if (!z || ((z && ((bitmap = this.userProfileImage) == null || bitmap.isRecycled())) || this.startProfileAnim)) {
            canvas.save();
            canvas.translate(this.emojiCurrentX, this.emojiCurrentY);
            if (this.startProfileAnim) {
                float f = this.zoomAnim;
                canvas.scale(1.0f - f, 1.0f - f, this.emojiStaticLayout.getLineWidth(0) / 2.0f, this.emojiStaticLayout.getHeight() / 2.0f);
            }
            this.emojiStaticLayout.draw(canvas);
            canvas.restore();
        }
    }

    private void updateProfileAnimIfNeeded() {
        if (this.startProfileAnim) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.profileAnimationStartTime;
            long j2 = jCurrentTimeMillis - j;
            if (j == 0) {
                this.profileAnimationStartTime = jCurrentTimeMillis;
                j2 = 0;
            }
            int i = this.profileAnimDuration;
            if (j2 >= i) {
                this.startProfileAnim = false;
            }
            this.zoomAnim = this.profileInterpolator.getInterpolation(convertXtoZeroOneRang(j2, i));
            invalidate();
        }
    }

    private void drawAverageIfNeeded(Canvas canvas) {
        if (this.drawAverage && this.drawProgress) {
            float fCheckBounds = checkBounds(((this.average / 100.0f) * this.width) + this.backgroundRectF.left);
            float f = this.backgroundRectF.bottom - (this.sliderHeight / 2.0f);
            LinearGradient linearGradient = new LinearGradient(0.0f, -r2, 0.0f, this.averageR, this.gradientStartColor, this.gradientEndColor, Shader.TileMode.CLAMP);
            this.averageGradientShader = linearGradient;
            if (this.isGradient) {
                this.averagePaint.setShader(linearGradient);
            }
            canvas.save();
            canvas.translate(fCheckBounds, f);
            if (this.showProfileImage && this.userProfileImage != null && this.startProfileAnim) {
                float f2 = this.zoomAnim;
                canvas.scale(f2, f2);
            }
            canvas.drawCircle(0.0f, 0.0f, this.averageR, this.averagePaint);
            canvas.drawCircle(0.0f, 0.0f, this.averageR - this.averagePadding, this.erasePaint);
            canvas.restore();
            drawHintIfNeeded(fCheckBounds, f);
        }
    }

    public void setProgressColor(boolean z, int i) {
        this.isGradient = z;
        if (z) {
            this.foregroundPaint.setShader(this.foregroundGradientShader);
        } else {
            this.foregroundPaint.setShader(null);
            this.foregroundPaint.setColor(i);
            this.averagePaint.setShader(null);
            this.averagePaint.setColor(i);
        }
        invalidate();
    }

    private void updatePreviewIfNeeded() {
        if (this.previewMode) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.previewAnimationStartTime;
            long j2 = jCurrentTimeMillis - j;
            int i = this.previewAnimDuration;
            if (j2 >= i || j == 0) {
                this.previewAnimationStartTime = jCurrentTimeMillis;
                j2 = 0;
            }
            this.percentage = convertYToRealRang(40.0f, this.previewInterpolator.getInterpolation(convertXtoZeroOneRang(j2, i))) + 10.0f;
            invalidate();
        }
    }

    public void setEmoji(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.emoji = str;
        ExtraView extraView = this.extraView;
        if (extraView != null) {
            extraView.setEmoji(str);
        }
        this.emojiStaticLayout = new StaticLayout(str, this.textPaint, this.emojiSizePx * 10, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        this.emojiStaticLayout = new StaticLayout(str, this.textPaint, (int) this.emojiStaticLayout.getLineWidth(0), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        invalidate();
    }

    private float checkBounds(float f) {
        RectF rectF = this.backgroundRectF;
        float f2 = rectF.right;
        if (f > f2) {
            f = f2;
        }
        float f3 = rectF.left;
        return f < f3 ? f3 : f;
    }

    private void setupForegroundRect() {
        RectF rectF = this.foregroundRectF;
        rectF.bottom = this.rectBottom;
        rectF.top = this.rectTop;
        rectF.left = this.rectLeft;
    }

    private void setupBackgroundRect() {
        RectF rectF = this.backgroundRectF;
        rectF.bottom = this.rectBottom;
        rectF.left = this.rectLeft;
        rectF.right = this.rectRight;
        rectF.top = this.rectTop;
    }

    public void lockTouchMode(boolean z) {
        this.lockTouchMode = z;
    }

    public void lockDragging(boolean z) {
        this.lockDragging = z;
    }

    public void setPreviewMode(boolean z) {
        this.previewMode = z;
        initEmoji();
        invalidate();
    }

    public String getEmoji() {
        return this.emoji;
    }

    public void setBackGroundColor(int i) {
        this.backgroundPaint.setColor(i);
        invalidate();
    }

    public void setUserProfileImage(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.userProfileImage = bitmap;
        invalidate();
    }

    public boolean isGradient() {
        return this.isGradient;
    }

    public void setExtraView(ExtraView extraView) {
        this.extraView = extraView;
        extraView.setEmoji(this.emoji);
    }

    public void setMode(EmojiSticker.EmojiMode emojiMode) {
        this.emojiMode = emojiMode;
    }

    public void setParentOffsetY(int i) {
        this.parentOffsetY = i;
    }
}
