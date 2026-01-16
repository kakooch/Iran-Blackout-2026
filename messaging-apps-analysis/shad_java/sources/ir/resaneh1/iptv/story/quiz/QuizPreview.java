package ir.resaneh1.iptv.story.quiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class QuizPreview extends FrameLayout {
    private int WHITE;
    private int animDuration;
    private int animOrder;
    private int backgroundCorner;
    private Paint backgroundPaint;
    private RectF backgroundRectF;
    private float borderWidth;
    private Drawable correctDrawable;
    private int grayBorderColor;
    private int greenColor;
    private int holderPadding;
    private Rect iconDrawableBoundRect;
    private Paint iconPaint;
    private Interpolator interpolator;
    private long lastUpdateAnimation;
    private int margin;
    private Paint optionBackgroundPaint;
    private int optionIconSize;
    private float optionIconWidthFactor;
    private RectF optionRectF;
    private Paint optionStorkPaint;
    private int optionViewHeight;
    private float optionViewPercent;
    private int shadowColor;
    private int shadowRadius;
    private StaticLayout staticLayout;
    private String text;
    private TextPaint textPaint;
    private int textSizePx;
    private int topMargin;
    private static int PREVIEW_VIEW_WIDTH = AndroidUtilities.dp(250.0f);
    private static int PREVIEW_VIEW_HEIGHT = AndroidUtilities.dp(250.0f);

    private float zeroOneRang(long j, long j2) {
        return j / j2;
    }

    public QuizPreview(Context context) {
        super(context);
        this.backgroundCorner = AndroidUtilities.dp(21.0f);
        this.borderWidth = AndroidUtilities.dp(4.0f);
        this.margin = AndroidUtilities.dp(15.0f);
        this.textSizePx = AndroidUtilities.dp(49.0f);
        this.holderPadding = AndroidUtilities.dp(12.0f);
        this.shadowRadius = AndroidUtilities.dp(3.0f);
        this.shadowColor = 1694498816;
        this.optionIconWidthFactor = 0.1f;
        this.optionViewPercent = 0.85f;
        this.animDuration = 3000;
        this.grayBorderColor = -3684409;
        this.greenColor = -10960094;
        this.WHITE = -1;
        this.text = "QUIZ";
        setWillNotDraw(false);
        init();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(PREVIEW_VIEW_WIDTH, 1073741824), View.MeasureSpec.makeMeasureSpec(PREVIEW_VIEW_HEIGHT, 1073741824));
    }

    private void init() {
        this.optionIconSize = (int) (this.optionIconWidthFactor * (PREVIEW_VIEW_WIDTH - (this.holderPadding * 2)));
        this.interpolator = new LinearInterpolator();
        this.iconDrawableBoundRect = new Rect();
        this.correctDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_correct_preview);
        setupIconBoundRect();
        initBackgroundRect();
        initBackgroundPaint();
        initIconBackgroundPaint();
        initOptionPaints();
        initStaticLayoutAndCalculateOptionHeight();
    }

    private void setupIconBoundRect() {
        Rect rect = this.iconDrawableBoundRect;
        rect.top = 0;
        rect.left = 0;
        int i = this.optionIconSize;
        rect.right = i;
        rect.bottom = i;
        this.correctDrawable.setBounds(rect);
    }

    private void initStaticLayoutAndCalculateOptionHeight() {
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.textPaint.setTextSize(this.textSizePx);
        this.textPaint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenyTMedium.otf"));
        StaticLayout staticLayout = new StaticLayout(this.text, this.textPaint, PREVIEW_VIEW_WIDTH, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        this.staticLayout = staticLayout;
        this.optionViewHeight = ((PREVIEW_VIEW_HEIGHT - staticLayout.getHeight()) - (this.margin * 5)) / 3;
        initOptionRect();
    }

    private void initOptionRect() {
        RectF rectF = new RectF();
        this.optionRectF = rectF;
        rectF.top = 0.0f;
        rectF.left = 0.0f;
        rectF.right = this.optionViewPercent * PREVIEW_VIEW_WIDTH;
        rectF.bottom = this.optionViewHeight;
    }

    private void initBackgroundPaint() {
        Paint paint = new Paint(1);
        this.backgroundPaint = paint;
        paint.setColor(this.WHITE);
        this.backgroundPaint.setShadowLayer(this.shadowRadius, 0.0f, 0.0f, this.shadowColor);
    }

    private void initIconBackgroundPaint() {
        Paint paint = new Paint(1);
        this.iconPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.iconPaint.setStrokeWidth(this.borderWidth);
        this.iconPaint.setColor(this.WHITE);
    }

    private void initBackgroundRect() {
        RectF rectF = new RectF();
        this.backgroundRectF = rectF;
        rectF.top = 0.0f;
        rectF.left = 0.0f;
        rectF.right = PREVIEW_VIEW_WIDTH;
        rectF.bottom = PREVIEW_VIEW_HEIGHT;
    }

    private void initOptionPaints() {
        Paint paint = new Paint(1);
        this.optionStorkPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.optionStorkPaint.setStrokeWidth(this.borderWidth);
        this.optionStorkPaint.setColor(this.grayBorderColor);
        Paint paint2 = new Paint(1);
        this.optionBackgroundPaint = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.optionBackgroundPaint.setColor(this.greenColor);
        this.optionBackgroundPaint.setStrokeWidth(this.borderWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.backgroundRectF;
        int i = this.backgroundCorner;
        canvas.drawRoundRect(rectF, i, i, this.backgroundPaint);
        drawStaticLayout(canvas);
        updateAnimationIfNeeded();
        this.topMargin = this.staticLayout.getHeight() + (this.margin * 2);
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.animOrder == i2) {
                drawOptionBackground(canvas, this.optionBackgroundPaint);
                drawIcon(canvas);
            } else {
                drawOptionBackground(canvas, this.optionStorkPaint);
            }
            this.topMargin += this.optionViewHeight + this.margin;
        }
    }

    private void drawOptionBackground(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(((1.0f - this.optionViewPercent) / 2.0f) * PREVIEW_VIEW_WIDTH, this.topMargin);
        RectF rectF = this.optionRectF;
        int i = this.optionViewHeight;
        canvas.drawRoundRect(rectF, i / 2.0f, i / 2.0f, paint);
        canvas.restore();
    }

    private void updateAnimationIfNeeded() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.lastUpdateAnimation == 0) {
            this.lastUpdateAnimation = jCurrentTimeMillis;
        }
        long j = jCurrentTimeMillis - this.lastUpdateAnimation;
        int i = this.animDuration;
        if (j > i) {
            this.lastUpdateAnimation = 0L;
        }
        this.animOrder = (int) (this.interpolator.getInterpolation(zeroOneRang(j, i)) * 3.0f);
        invalidate();
    }

    private void drawStaticLayout(Canvas canvas) {
        canvas.save();
        canvas.translate((PREVIEW_VIEW_WIDTH / 2.0f) - (this.staticLayout.getWidth() / 2.0f), this.margin);
        this.staticLayout.draw(canvas);
        canvas.restore();
    }

    private void drawIcon(Canvas canvas) {
        canvas.save();
        canvas.translate(((1.0f - this.optionViewPercent) / 2.0f) * PREVIEW_VIEW_WIDTH, this.topMargin);
        float f = this.holderPadding;
        int i = this.optionIconSize;
        canvas.drawCircle(f + (i / 2.0f), this.optionViewHeight / 2.0f, i / 2.0f, this.iconPaint);
        canvas.translate((this.holderPadding + (this.optionIconSize / 2.0f)) - this.iconDrawableBoundRect.centerX(), (this.optionViewHeight / 2.0f) - this.iconDrawableBoundRect.centerY());
        this.correctDrawable.draw(canvas);
        canvas.restore();
    }

    public static int getPreviewViewWidth() {
        return PREVIEW_VIEW_WIDTH;
    }

    public static int getPreviewViewHeight() {
        return PREVIEW_VIEW_HEIGHT;
    }
}
