package ir.resaneh1.iptv.story.poll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class PollPreview extends FrameLayout {
    private static int PREVIEW_VIEW_HEIGHT = AndroidUtilities.dp(50.0f);
    private static int PREVIEW_VIEW_WIDTH = AndroidUtilities.dp(105.0f);
    private int previewEndColor;
    private int previewFontSize;
    private int previewLineColor;
    private int previewPadding;
    private Paint previewPaint;
    private int previewStartColor;
    private StaticLayout previewStaticLayout;
    private String previewText;
    private TextPaint previewTextPaint;
    private int tripleRoundRectHeight;
    private int tripleRoundRectMargin;
    private RectF tripleRoundRectOne;
    private RectF tripleRoundRectThree;
    private RectF tripleRoundRectTwo;
    private int tripleRoundRectWidthLarge;
    private int tripleRoundRectWidthMedium;
    private int tripleRoundRectWidthSmall;

    public boolean onClick(float f, float f2) {
        return false;
    }

    public PollPreview(Context context) {
        super(context);
        this.previewStartColor = -15025494;
        this.previewEndColor = -13968866;
        this.previewLineColor = -15093288;
        this.previewPadding = AndroidUtilities.dp(12.0f);
        this.tripleRoundRectMargin = AndroidUtilities.dp(4.0f);
        this.tripleRoundRectHeight = AndroidUtilities.dp(4.0f);
        this.tripleRoundRectWidthSmall = AndroidUtilities.dp(15.0f);
        this.tripleRoundRectWidthMedium = AndroidUtilities.dp(20.0f);
        this.tripleRoundRectWidthLarge = AndroidUtilities.dp(25.0f);
        this.previewFontSize = 35;
        this.previewText = "POLL";
        setBackgroundResource(R.drawable.poll_preview_round_rect);
        init();
    }

    private void init() {
        setClipChildren(false);
        setClipToPadding(false);
        this.previewPaint = new Paint();
        this.tripleRoundRectOne = new RectF();
        this.tripleRoundRectTwo = new RectF();
        this.tripleRoundRectThree = new RectF();
        this.previewPaint.setAntiAlias(true);
        this.previewPaint.setStyle(Paint.Style.FILL);
        this.previewPaint.setColor(this.previewLineColor);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(PREVIEW_VIEW_WIDTH, 1073741824), View.MeasureSpec.makeMeasureSpec(PREVIEW_VIEW_HEIGHT, 1073741824));
        setupRect(PREVIEW_VIEW_HEIGHT);
        setupPreviewStaticLayoutIfNeeded(PREVIEW_VIEW_WIDTH);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawTripleRoundRect(canvas);
        drawPreviewStaticLayout(canvas);
    }

    private void drawPreviewStaticLayout(Canvas canvas) {
        canvas.save();
        canvas.translate(((this.previewPadding * 1.5f) + this.tripleRoundRectWidthLarge) - minLeft(this.previewStaticLayout), (getHeight() / 2.0f) - (this.previewStaticLayout.getHeight() / 2.0f));
        this.previewStaticLayout.draw(canvas);
        canvas.restore();
    }

    private void drawTripleRoundRect(Canvas canvas) {
        canvas.drawRoundRect(this.tripleRoundRectOne, 10.0f, 10.0f, this.previewPaint);
        canvas.drawRoundRect(this.tripleRoundRectTwo, 10.0f, 10.0f, this.previewPaint);
        canvas.drawRoundRect(this.tripleRoundRectThree, 10.0f, 10.0f, this.previewPaint);
    }

    private void setupRect(int i) {
        RectF rectF = this.tripleRoundRectTwo;
        int i2 = this.tripleRoundRectHeight;
        float f = (i / 2.0f) - (i2 / 2.0f);
        rectF.top = f;
        int i3 = this.previewPadding;
        float f2 = i3;
        rectF.left = f2;
        rectF.bottom = i2 + f;
        rectF.right = f2 + this.tripleRoundRectWidthLarge;
        RectF rectF2 = this.tripleRoundRectOne;
        int i4 = this.tripleRoundRectMargin;
        float f3 = f - i4;
        rectF2.bottom = f3;
        rectF2.top = f3 - i2;
        float f4 = i3;
        rectF2.left = f4;
        rectF2.right = f4 + this.tripleRoundRectWidthSmall;
        RectF rectF3 = this.tripleRoundRectThree;
        float f5 = rectF.bottom + i4;
        rectF3.top = f5;
        float f6 = i3;
        rectF3.left = f6;
        rectF3.bottom = f5 + i2;
        rectF3.right = f6 + this.tripleRoundRectWidthMedium;
    }

    private void setupPreviewStaticLayoutIfNeeded(int i) {
        float f = (i - (this.previewPadding * 1.5f)) - this.tripleRoundRectWidthLarge;
        TextPaint textPaint = new TextPaint();
        this.previewTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.previewTextPaint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenyTRegular.otf"));
        this.previewTextPaint.setTextSize(AndroidUtilities.dp(this.previewFontSize));
        this.previewTextPaint.setShader(new LinearGradient(0.0f, 0.0f, f, 0.0f, this.previewStartColor, this.previewEndColor, Shader.TileMode.REPEAT));
        this.previewStaticLayout = new StaticLayout(this.previewText, this.previewTextPaint, (int) f, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    private float minLeft(StaticLayout staticLayout) {
        float lineLeft = staticLayout.getLineLeft(0);
        for (int i = 1; i < staticLayout.getLineCount(); i++) {
            lineLeft = Math.min(staticLayout.getLineLeft(i), lineLeft);
        }
        return lineLeft;
    }

    public static int getWidthValue() {
        return PREVIEW_VIEW_WIDTH;
    }

    public static int getHeightValue() {
        return PREVIEW_VIEW_HEIGHT;
    }
}
