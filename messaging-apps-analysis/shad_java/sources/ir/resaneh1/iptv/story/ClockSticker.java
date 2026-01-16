package ir.resaneh1.iptv.story;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class ClockSticker extends FrameLayout {
    private int WHITE;
    private int analogClockFontSize;
    private float backgroundRadius;
    private int centerCircleRadius;
    private Paint clockBackgroundPaint;
    private ClockMode clockMode;
    private int clockWidthHeight;
    private int cornerSize;
    private int endColor;
    private Paint endPaint;
    private Paint erasePaint;
    private final Typeface font;
    private TextPaint grayModeTextPaint;
    private int grayTextViewFontSize;
    private int handHeight;
    private Paint handPaint;
    private Path holderPath;
    private float hourRadius;
    private int largeMargin;
    private float minuteRadius;
    private Rect numberBound;
    private Paint numberPaint;
    private int[] numbers;
    private float numbersRadius;
    private int removeHeight;
    private TextPaint simpleModeTextPaint;
    private int simpleTextViewFontSize;
    private int smallMargin;
    private int startColor;
    private Paint startPaint;
    private StaticLayout staticLayoutFour;
    private StaticLayout staticLayoutOne;
    private StaticLayout staticLayoutThree;
    private StaticLayout staticLayoutTwo;
    private int staticsWidth;
    private String textFour;
    private String textOne;
    private String textThree;
    private String textTwo;
    private int textViewsPadding;
    private StaticLayout totalStaticLayout;

    public enum ClockMode {
        TEXTUAL_GRAY,
        CIRCULAR,
        TEXTUAL_SIMPLE
    }

    public int getViewWidth() {
        return this.clockWidthHeight;
    }

    public int getViewHeight() {
        return this.clockWidthHeight;
    }

    public ClockSticker(Context context, ClockMode clockMode) {
        super(context);
        this.clockWidthHeight = AndroidUtilities.dp(207.0f);
        this.smallMargin = AndroidUtilities.dp(2.0f);
        this.largeMargin = AndroidUtilities.dp(11.0f);
        this.textViewsPadding = AndroidUtilities.dp(8.0f);
        this.cornerSize = AndroidUtilities.dp(10.0f);
        this.grayTextViewFontSize = AndroidUtilities.dp(80.0f);
        this.simpleTextViewFontSize = AndroidUtilities.dp(100.0f);
        this.analogClockFontSize = AndroidUtilities.dp(30.0f);
        this.removeHeight = AndroidUtilities.dp(2.0f);
        this.handHeight = AndroidUtilities.dp(4.0f);
        this.centerCircleRadius = AndroidUtilities.dp(5.0f);
        this.numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        this.WHITE = -1;
        this.startColor = -2137022561;
        this.endColor = -1868587105;
        this.textOne = "1";
        this.textTwo = "4";
        this.textThree = "4";
        this.textFour = "2";
        setWillNotDraw(false);
        this.font = Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenyTRegular.otf");
        initPaints();
        initPath();
        initRect();
        setMode(clockMode);
        setLayerType(1, null);
    }

    private void initRect() {
        this.numberBound = new Rect();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.clockWidthHeight;
        this.staticsWidth = ((i3 - (this.smallMargin * 2)) - this.largeMargin) / 4;
        float f = i3 / 2.0f;
        this.backgroundRadius = f;
        this.numbersRadius = 0.75f * f;
        this.minuteRadius = 0.5f * f;
        this.hourRadius = f * 0.25f;
        setupTotalStaticLayout(i3);
        setupStaticLayouts();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.clockWidthHeight, 1073741824), View.MeasureSpec.makeMeasureSpec(this.clockWidthHeight, 1073741824));
    }

    private void setupTotalStaticLayout(int i) {
        this.totalStaticLayout = new StaticLayout(this.textOne + this.textTwo + ":" + this.textThree + this.textFour, this.simpleModeTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawGrayTextualMode(canvas);
        drawSimpleTextualMode(canvas);
        drawCircularMode(canvas);
    }

    private void drawCircularMode(Canvas canvas) {
        if (this.clockMode == ClockMode.CIRCULAR) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.backgroundRadius, this.clockBackgroundPaint);
            drawHands(canvas);
            drawNumbers(canvas);
        }
    }

    private void drawSimpleTextualMode(Canvas canvas) {
        if (this.clockMode == ClockMode.TEXTUAL_SIMPLE) {
            canvas.save();
            canvas.translate((getWidth() / 2.0f) - (this.totalStaticLayout.getWidth() / 2.0f), (getHeight() / 2.0f) - (this.totalStaticLayout.getHeight() / 2.0f));
            this.totalStaticLayout.draw(canvas);
            canvas.restore();
        }
    }

    private void drawGrayTextualMode(Canvas canvas) {
        if (this.clockMode == ClockMode.TEXTUAL_GRAY) {
            int height = (this.staticLayoutOne.getHeight() - (this.staticLayoutOne.getLineDescent(0) * 2)) + (this.textViewsPadding * 2);
            canvas.save();
            float f = height / 2.0f;
            canvas.translate(0.0f, (getHeight() / 2.0f) - f);
            drawHolders(canvas, height);
            drawStaticLayouts(canvas, height);
            canvas.drawRect(0.0f, f - (this.removeHeight / 2.0f), getWidth(), f + (this.removeHeight / 2.0f), this.erasePaint);
            canvas.restore();
        }
    }

    private void drawHands(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.centerCircleRadius, this.numberPaint);
        int i = Integer.parseInt(this.textOne + this.textTwo) % 12;
        float f = Integer.parseInt(this.textThree + this.textFour);
        drawHand(canvas, (i + (f / 60.0f)) * 5.0f, this.hourRadius);
        drawHand(canvas, f, this.minuteRadius);
    }

    private void drawHand(Canvas canvas, float f, double d) {
        double d2 = f;
        Double.isNaN(d2);
        double d3 = (d2 * 0.10471975511965977d) - 1.5707963267948966d;
        double width = getWidth() / 2;
        double dCos = Math.cos(d3) * d;
        Double.isNaN(width);
        float f2 = (float) (width + dCos);
        double height = getHeight() / 2;
        double dSin = Math.sin(d3) * d;
        Double.isNaN(height);
        float f3 = (float) (height + dSin);
        canvas.drawLine(getWidth() / 2.0f, getHeight() / 2.0f, f2, f3, this.handPaint);
        canvas.drawCircle(f2, f3, this.handHeight / 2.0f, this.handPaint);
    }

    private void drawNumbers(Canvas canvas) {
        int[] iArr = this.numbers;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int i3 = iArr[i2];
            String strValueOf = String.valueOf(i3);
            this.numberPaint.getTextBounds(strValueOf, i, strValueOf.length(), this.numberBound);
            double d = i3 - 3;
            Double.isNaN(d);
            double d2 = d * 0.5235987755982988d;
            double width = getWidth() / 2.0f;
            double dCos = Math.cos(d2);
            int i4 = i2;
            double d3 = this.numbersRadius;
            Double.isNaN(d3);
            Double.isNaN(width);
            float fWidth = ((float) (width + (dCos * d3))) - (this.numberBound.width() / 2.0f);
            double height = getHeight() / 2.0f;
            double dSin = Math.sin(d2);
            double d4 = this.numbersRadius;
            Double.isNaN(d4);
            Double.isNaN(height);
            canvas.drawText(strValueOf, fWidth, ((float) (height + (dSin * d4))) + (this.numberBound.height() / 2.0f), this.numberPaint);
            i2 = i4 + 1;
            i = 0;
        }
    }

    private void drawStaticLayouts(Canvas canvas, int i) {
        canvas.save();
        canvas.translate(0.0f, (i / 2.0f) - (this.staticLayoutOne.getHeight() / 2.0f));
        this.staticLayoutOne.draw(canvas);
        canvas.translate(this.staticLayoutOne.getWidth() + this.smallMargin, 0.0f);
        this.staticLayoutTwo.draw(canvas);
        canvas.translate(this.staticLayoutOne.getWidth() + this.largeMargin, 0.0f);
        this.staticLayoutThree.draw(canvas);
        canvas.translate(this.staticLayoutOne.getWidth() + this.smallMargin, 0.0f);
        this.staticLayoutFour.draw(canvas);
        canvas.restore();
    }

    private void drawHolders(Canvas canvas, int i) {
        drawTopHolders(canvas, i);
        drawBottomHolders(canvas, i);
    }

    private void drawTopHolders(Canvas canvas, int i) {
        createTopPath(i);
        canvas.drawPath(this.holderPath, this.startPaint);
        canvas.save();
        canvas.translate(this.staticLayoutOne.getWidth() + this.smallMargin, 0.0f);
        canvas.drawPath(this.holderPath, this.startPaint);
        canvas.restore();
        canvas.save();
        canvas.translate((this.staticLayoutOne.getWidth() * 2) + this.smallMargin + this.largeMargin, 0.0f);
        canvas.drawPath(this.holderPath, this.startPaint);
        canvas.restore();
        canvas.save();
        canvas.translate((this.staticLayoutOne.getWidth() * 3) + (this.smallMargin * 2) + this.largeMargin, 0.0f);
        canvas.drawPath(this.holderPath, this.startPaint);
        canvas.restore();
    }

    private void drawBottomHolders(Canvas canvas, int i) {
        createBottomPath(i);
        canvas.save();
        float f = i / 2.0f;
        canvas.translate(0.0f, f);
        canvas.drawPath(this.holderPath, this.endPaint);
        canvas.restore();
        canvas.save();
        canvas.translate(this.staticLayoutOne.getWidth() + this.smallMargin, f);
        canvas.drawPath(this.holderPath, this.endPaint);
        canvas.restore();
        canvas.save();
        canvas.translate((this.staticLayoutOne.getWidth() * 2) + this.smallMargin + this.largeMargin, f);
        canvas.drawPath(this.holderPath, this.endPaint);
        canvas.restore();
        canvas.save();
        canvas.translate((this.staticLayoutOne.getWidth() * 3) + (this.smallMargin * 2) + this.largeMargin, f);
        canvas.drawPath(this.holderPath, this.endPaint);
        canvas.restore();
    }

    private void createTopPath(int i) {
        this.holderPath.reset();
        this.holderPath.moveTo(this.cornerSize, 0.0f);
        this.holderPath.rLineTo(this.staticLayoutOne.getWidth() - (this.cornerSize * 2), 0.0f);
        Path path = this.holderPath;
        int i2 = this.cornerSize;
        path.rLineTo(i2, i2);
        this.holderPath.rLineTo(0.0f, (i / 2.0f) - this.cornerSize);
        this.holderPath.rLineTo(-this.staticLayoutOne.getWidth(), 0.0f);
        this.holderPath.rLineTo(0.0f, ((-i) / 2.0f) + this.cornerSize);
        this.holderPath.rLineTo(this.cornerSize, -r0);
        Path path2 = this.holderPath;
        int i3 = this.cornerSize;
        path2.addCircle(i3, i3, i3, Path.Direction.CW);
        Path path3 = this.holderPath;
        int width = this.staticLayoutOne.getWidth();
        int i4 = this.cornerSize;
        path3.addCircle(width - i4, i4, i4, Path.Direction.CW);
    }

    private void createBottomPath(int i) {
        this.holderPath.reset();
        this.holderPath.rLineTo(this.staticLayoutOne.getWidth(), 0.0f);
        float f = i / 2.0f;
        this.holderPath.rLineTo(0.0f, f - this.cornerSize);
        this.holderPath.rLineTo(-r4, this.cornerSize);
        this.holderPath.rLineTo((-this.staticLayoutOne.getWidth()) + (this.cornerSize * 2), 0.0f);
        Path path = this.holderPath;
        int i2 = this.cornerSize;
        path.rLineTo(-i2, -i2);
        this.holderPath.rLineTo(0.0f, ((-i) / 2.0f) + this.cornerSize);
        Path path2 = this.holderPath;
        int i3 = this.cornerSize;
        path2.addCircle(i3, f - i3, i3, Path.Direction.CW);
        Path path3 = this.holderPath;
        int width = this.staticLayoutOne.getWidth();
        int i4 = this.cornerSize;
        path3.addCircle(width - i4, f - i4, i4, Path.Direction.CW);
    }

    /* renamed from: ir.resaneh1.iptv.story.ClockSticker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode;

        static {
            int[] iArr = new int[ClockMode.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode = iArr;
            try {
                iArr[ClockMode.TEXTUAL_GRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode[ClockMode.TEXTUAL_SIMPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode[ClockMode.CIRCULAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void setMode(ClockMode clockMode) {
        this.clockMode = clockMode;
        int i = AnonymousClass1.$SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode[clockMode.ordinal()];
        if (i == 1) {
            setupStaticLayouts();
            invalidate();
        } else if (i == 2) {
            setupTotalStaticLayout(getWidth());
            invalidate();
        } else {
            if (i != 3) {
                return;
            }
            invalidate();
        }
    }

    private void initClockPaint() {
        Paint paint = new Paint();
        this.numberPaint = paint;
        paint.setAntiAlias(true);
        this.numberPaint.setColor(this.WHITE);
        this.numberPaint.setTypeface(this.font);
        this.numberPaint.setTextSize(this.analogClockFontSize);
        Paint paint2 = new Paint();
        this.clockBackgroundPaint = paint2;
        paint2.setAntiAlias(true);
        this.clockBackgroundPaint.setColor(this.endColor);
        Paint paint3 = new Paint();
        this.handPaint = paint3;
        paint3.setAntiAlias(true);
        this.handPaint.setColor(this.WHITE);
        this.handPaint.setStrokeWidth(this.handHeight);
        this.handPaint.setStyle(Paint.Style.FILL);
    }

    private void initPath() {
        this.holderPath = new Path();
    }

    private void initPaints() {
        initTextPaint();
        initHolderPaints();
        initErasePaint();
        initClockPaint();
    }

    private void initErasePaint() {
        Paint paint = new Paint();
        this.erasePaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private void initHolderPaints() {
        Paint paint = new Paint();
        this.startPaint = paint;
        paint.setColor(this.startColor);
        this.startPaint.setAntiAlias(true);
        this.startPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.endPaint = paint2;
        paint2.setColor(this.endColor);
        this.endPaint.setAntiAlias(true);
        this.endPaint.setStyle(Paint.Style.FILL);
    }

    private void initTextPaint() {
        TextPaint textPaint = new TextPaint();
        this.grayModeTextPaint = textPaint;
        textPaint.setColor(this.WHITE);
        this.grayModeTextPaint.setAntiAlias(true);
        this.grayModeTextPaint.setTypeface(this.font);
        this.grayModeTextPaint.setTextSize(this.grayTextViewFontSize);
        TextPaint textPaint2 = new TextPaint();
        this.simpleModeTextPaint = textPaint2;
        textPaint2.setColor(this.WHITE);
        this.simpleModeTextPaint.setAntiAlias(true);
        this.simpleModeTextPaint.setTypeface(this.font);
        this.simpleModeTextPaint.setTextSize(this.simpleTextViewFontSize);
    }

    public void setTexts(String str, String str2, String str3, String str4) {
        if (str == null) {
            str = String.valueOf(0);
        }
        this.textOne = str;
        if (str2 == null) {
            str2 = String.valueOf(0);
        }
        this.textTwo = str2;
        if (str3 == null) {
            str3 = String.valueOf(0);
        }
        this.textThree = str3;
        if (str4 == null) {
            str4 = String.valueOf(0);
        }
        this.textFour = str4;
        setupStaticLayouts();
        setupTotalStaticLayout(getWidth());
        invalidate();
    }

    private void setupStaticLayouts() {
        this.staticLayoutOne = new StaticLayout(this.textOne, this.grayModeTextPaint, this.staticsWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        this.staticLayoutTwo = new StaticLayout(this.textTwo, this.grayModeTextPaint, this.staticsWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        this.staticLayoutThree = new StaticLayout(this.textThree, this.grayModeTextPaint, this.staticsWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        this.staticLayoutFour = new StaticLayout(this.textFour, this.grayModeTextPaint, this.staticsWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    }

    public ClockMode getMode() {
        return this.clockMode;
    }
}
