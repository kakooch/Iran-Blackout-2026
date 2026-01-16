package com.github.mikephil.charting.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.List;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes2.dex */
public abstract class Utils {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final float FDEG2RAD = 0.017453292f;
    private static DisplayMetrics a = null;
    private static int b = 50;
    private static int c = 8000;
    public static final double DOUBLE_EPSILON = Double.longBitsToDouble(1);
    public static final float FLOAT_EPSILON = Float.intBitsToFloat(1);
    private static Rect d = new Rect();
    private static Paint.FontMetrics e = new Paint.FontMetrics();
    private static Rect f = new Rect();
    private static final int[] g = {1, 10, 100, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};
    private static ValueFormatter h = a();
    private static Rect i = new Rect();
    private static Rect j = new Rect();
    private static Paint.FontMetrics k = new Paint.FontMetrics();

    private static ValueFormatter a() {
        return new DefaultValueFormatter(1);
    }

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = d;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize calcTextSize(Paint paint, String str) {
        FSize fSize = FSize.getInstance(0.0f, 0.0f);
        calcTextSize(paint, str, fSize);
        return fSize;
    }

    public static int calcTextWidth(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float convertDpToPixel(float f2) {
        DisplayMetrics displayMetrics = a;
        if (displayMetrics != null) {
            return f2 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static int[] convertIntegers(List<Integer> list) {
        int[] iArr = new int[list.size()];
        copyIntegers(list, iArr);
        return iArr;
    }

    public static float convertPixelsToDp(float f2) {
        DisplayMetrics displayMetrics = a;
        if (displayMetrics != null) {
            return f2 / displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static String[] convertStrings(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2);
        }
        return strArr;
    }

    public static void copyIntegers(List<Integer> list, int[] iArr) {
        int length = iArr.length < list.size() ? iArr.length : list.size();
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
    }

    public static void copyStrings(List<String> list, String[] strArr) {
        int length = strArr.length < list.size() ? strArr.length : list.size();
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = list.get(i2);
        }
    }

    public static void drawImage(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        MPPointF mPPointF = MPPointF.getInstance();
        mPPointF.x = i2 - (i4 / 2);
        mPPointF.y = i3 - (i5 / 2);
        drawable.copyBounds(i);
        Rect rect = i;
        int i6 = rect.left;
        int i7 = rect.top;
        drawable.setBounds(i6, i7, i6 + i4, i4 + i7);
        int iSave = canvas.save();
        canvas.translate(mPPointF.x, mPPointF.y);
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public static void drawMultilineText(Canvas canvas, StaticLayout staticLayout, float f2, float f3, TextPaint textPaint, MPPointF mPPointF, float f4) {
        float fontMetrics = textPaint.getFontMetrics(k);
        float width = staticLayout.getWidth();
        float lineCount = staticLayout.getLineCount() * fontMetrics;
        float f5 = 0.0f - j.left;
        float f6 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f4 != 0.0f) {
            float f7 = f5 - (width * 0.5f);
            float f8 = f6 - (lineCount * 0.5f);
            if (mPPointF.x != 0.5f || mPPointF.y != 0.5f) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(width, lineCount, f4);
                f2 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.x - 0.5f);
                f3 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.translate(f7, f8);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            float f9 = mPPointF.x;
            if (f9 != 0.0f || mPPointF.y != 0.0f) {
                f5 -= width * f9;
                f6 -= lineCount * mPPointF.y;
            }
            canvas.save();
            canvas.translate(f5 + f2, f6 + f3);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    public static void drawXAxisValue(Canvas canvas, String str, float f2, float f3, Paint paint, MPPointF mPPointF, float f4) {
        float fontMetrics = paint.getFontMetrics(k);
        paint.getTextBounds(str, 0, str.length(), j);
        float fWidth = 0.0f - j.left;
        float f5 = (-k.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f4 != 0.0f) {
            float fWidth2 = fWidth - (j.width() * 0.5f);
            float f6 = f5 - (fontMetrics * 0.5f);
            if (mPPointF.x != 0.5f || mPPointF.y != 0.5f) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(j.width(), fontMetrics, f4);
                f2 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.x - 0.5f);
                f3 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.drawText(str, fWidth2, f6, paint);
            canvas.restore();
        } else {
            if (mPPointF.x != 0.0f || mPPointF.y != 0.0f) {
                fWidth -= j.width() * mPPointF.x;
                f5 -= fontMetrics * mPPointF.y;
            }
            canvas.drawText(str, fWidth + f2, f5 + f3, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String formatNumber(float f2, int i2, boolean z) {
        return formatNumber(f2, i2, z, '.');
    }

    public static int getDecimals(float f2) {
        float fRoundToNextSignificant = roundToNextSignificant(f2);
        if (Float.isInfinite(fRoundToNextSignificant)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(fRoundToNextSignificant))) + 2;
    }

    public static ValueFormatter getDefaultValueFormatter() {
        return h;
    }

    public static float getLineHeight(Paint paint) {
        return getLineHeight(paint, e);
    }

    public static float getLineSpacing(Paint paint) {
        return getLineSpacing(paint, e);
    }

    public static int getMaximumFlingVelocity() {
        return c;
    }

    public static int getMinimumFlingVelocity() {
        return b;
    }

    public static float getNormalizedAngle(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2 % 360.0f;
    }

    public static MPPointF getPosition(MPPointF mPPointF, float f2, float f3) {
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(mPPointF, f2, f3, mPPointF2);
        return mPPointF2;
    }

    public static int getSDKInt() {
        return Build.VERSION.SDK_INT;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(FSize fSize, float f2) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f2 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(FSize fSize, float f2) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f2);
    }

    public static void init(Context context) {
        if (context == null) {
            b = ViewConfiguration.getMinimumFlingVelocity();
            c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            b = viewConfiguration.getScaledMinimumFlingVelocity();
            c = viewConfiguration.getScaledMaximumFlingVelocity();
            a = context.getResources().getDisplayMetrics();
        }
    }

    public static double nextUp(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        double d3 = d2 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d3) + (d3 >= 0.0d ? 1L : -1L));
    }

    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    public static float roundToNextSignificant(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == 0.0d) {
            return 0.0f;
        }
        return Math.round(d2 * r0) / ((float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d2 < 0.0d ? -d2 : d2)))));
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (i2 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static String formatNumber(float f2, int i2, boolean z, char c2) {
        boolean z2;
        float f3 = f2;
        char[] cArr = new char[35];
        if (f3 == 0.0f) {
            return "0";
        }
        int i3 = 0;
        boolean z3 = f3 < 1.0f && f3 > -1.0f;
        if (f3 < 0.0f) {
            f3 = -f3;
            z2 = true;
        } else {
            z2 = false;
        }
        int[] iArr = g;
        int length = i2 > iArr.length ? iArr.length - 1 : i2;
        long jRound = Math.round(f3 * iArr[length]);
        int i4 = 34;
        boolean z4 = false;
        while (true) {
            if (jRound == 0 && i3 >= length + 1) {
                break;
            }
            int i5 = (int) (jRound % 10);
            jRound /= 10;
            int i6 = i4 - 1;
            cArr[i4] = (char) (i5 + 48);
            int i7 = i3 + 1;
            if (i7 == length) {
                i4 -= 2;
                cArr[i6] = ',';
                i3 += 2;
                z4 = true;
            } else {
                if (z && jRound != 0 && i7 > length) {
                    if (z4) {
                        if ((i7 - length) % 4 == 0) {
                            i4 -= 2;
                            cArr[i6] = c2;
                            i3 += 2;
                        }
                    } else if ((i7 - length) % 4 == 3) {
                        i4 -= 2;
                        cArr[i6] = c2;
                        i3 += 2;
                    }
                }
                i3 = i7;
                i4 = i6;
            }
        }
        if (z3) {
            cArr[i4] = '0';
            i3++;
            i4--;
        }
        if (z2) {
            cArr[i4] = '-';
            i3++;
        }
        int i8 = 35 - i3;
        return String.valueOf(cArr, i8, 35 - i8);
    }

    public static float getLineHeight(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getLineSpacing(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f2, float f3, float f4) {
        return getSizeOfRotatedRectangleByRadians(f2, f3, f4 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(float f2, float f3, float f4) {
        double d2 = f4;
        return FSize.getInstance(Math.abs(((float) Math.cos(d2)) * f2) + Math.abs(((float) Math.sin(d2)) * f3), Math.abs(f2 * ((float) Math.sin(d2))) + Math.abs(f3 * ((float) Math.cos(d2))));
    }

    public static void calcTextSize(Paint paint, String str, FSize fSize) {
        Rect rect = f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.width = rect.width();
        fSize.height = rect.height();
    }

    public static void getPosition(MPPointF mPPointF, float f2, float f3, MPPointF mPPointF2) {
        double d2 = f2;
        double d3 = f3;
        mPPointF2.x = (float) (mPPointF.x + (Math.cos(Math.toRadians(d3)) * d2));
        mPPointF2.y = (float) (mPPointF.y + (d2 * Math.sin(Math.toRadians(d3))));
    }

    @Deprecated
    public static void init(Resources resources) {
        a = resources.getDisplayMetrics();
        b = ViewConfiguration.getMinimumFlingVelocity();
        c = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static void drawMultilineText(Canvas canvas, String str, float f2, float f3, TextPaint textPaint, FSize fSize, MPPointF mPPointF, float f4) {
        drawMultilineText(canvas, new StaticLayout(str, 0, str.length(), textPaint, (int) Math.max(Math.ceil(fSize.width), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f2, f3, textPaint, mPPointF, f4);
    }
}
