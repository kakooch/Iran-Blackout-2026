package ir.nasim.features.media.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.features.media.components.PhotoFilterView;
import java.util.Locale;

/* loaded from: classes6.dex */
public class PhotoFilterCurvesControl extends View {
    private int a;
    private boolean b;
    private boolean c;
    private float d;
    private Rect e;
    private Paint f;
    private Paint g;
    private Paint h;
    private TextPaint i;
    private Path j;
    private PhotoFilterCurvesControlDelegate k;
    private PhotoFilterView.CurvesToolValue l;

    public interface PhotoFilterCurvesControlDelegate {
        void valueChanged();
    }

    public PhotoFilterCurvesControl(Context context, PhotoFilterView.CurvesToolValue curvesToolValue) {
        super(context);
        this.a = 0;
        this.c = true;
        this.e = new Rect();
        this.f = new Paint(1);
        this.g = new Paint(1);
        this.h = new Paint(1);
        this.i = new TextPaint(1);
        this.j = new Path();
        setWillNotDraw(false);
        this.l = curvesToolValue;
        Paint paint = this.f;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        paint.setColor(c5495Jo7.y0(c5495Jo7.f0(), 60));
        this.f.setStrokeWidth(C22078ud6.a(1.0f));
        Paint paint2 = this.f;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.g.setColor(c5495Jo7.y0(c5495Jo7.f0(), 60));
        this.g.setStrokeWidth(C22078ud6.a(2.0f));
        this.g.setStyle(style);
        this.h.setColor(c5495Jo7.f0());
        this.h.setStrokeWidth(C22078ud6.a(2.0f));
        this.h.setStyle(style);
        this.i.setColor(c5495Jo7.o2());
        this.i.setTextSize(C22078ud6.a(13.0f));
    }

    private void a(int i, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (i == 1) {
            b(x);
            return;
        }
        if (i != 2) {
            if (i == 3 || i == 4 || i == 5) {
                c();
                return;
            }
            return;
        }
        float fMin = Math.min(2.0f, (this.d - y) / 8.0f);
        PhotoFilterView.CurvesToolValue curvesToolValue = this.l;
        int i2 = curvesToolValue.activeType;
        PhotoFilterView.CurvesValue curvesValue = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : curvesToolValue.blueCurve : curvesToolValue.greenCurve : curvesToolValue.redCurve : curvesToolValue.luminanceCurve;
        int i3 = this.a;
        if (i3 == 1) {
            curvesValue.blacksLevel = Math.max(0.0f, Math.min(100.0f, curvesValue.blacksLevel + fMin));
        } else if (i3 == 2) {
            curvesValue.shadowsLevel = Math.max(0.0f, Math.min(100.0f, curvesValue.shadowsLevel + fMin));
        } else if (i3 == 3) {
            curvesValue.midtonesLevel = Math.max(0.0f, Math.min(100.0f, curvesValue.midtonesLevel + fMin));
        } else if (i3 == 4) {
            curvesValue.highlightsLevel = Math.max(0.0f, Math.min(100.0f, curvesValue.highlightsLevel + fMin));
        } else if (i3 == 5) {
            curvesValue.whitesLevel = Math.max(0.0f, Math.min(100.0f, curvesValue.whitesLevel + fMin));
        }
        invalidate();
        PhotoFilterCurvesControlDelegate photoFilterCurvesControlDelegate = this.k;
        if (photoFilterCurvesControlDelegate != null) {
            photoFilterCurvesControlDelegate.valueChanged();
        }
        this.d = y;
    }

    private void b(float f) {
        if (this.a != 0) {
            return;
        }
        Rect rect = this.e;
        this.a = (int) Math.floor(((f - rect.x) / (rect.width / 5.0f)) + 1.0f);
    }

    private void c() {
        if (this.a == 0) {
            return;
        }
        this.a = 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        PhotoFilterView.CurvesValue curvesValue;
        float f = this.e.width / 5.0f;
        for (int i = 0; i < 4; i++) {
            Rect rect = this.e;
            float f2 = rect.x;
            float f3 = i * f;
            float f4 = rect.y;
            canvas.drawLine(f2 + f + f3, f4, f2 + f + f3, f4 + rect.height, this.f);
        }
        Rect rect2 = this.e;
        float f5 = rect2.x;
        float f6 = rect2.y;
        canvas.drawLine(f5, f6 + rect2.height, f5 + rect2.width, f6, this.g);
        int i2 = this.l.activeType;
        if (i2 == 0) {
            this.h.setColor(C5495Jo7.a.f0());
            curvesValue = this.l.luminanceCurve;
        } else if (i2 == 1) {
            this.h.setColor(C5495Jo7.a.B0());
            curvesValue = this.l.redCurve;
        } else if (i2 == 2) {
            this.h.setColor(C5495Jo7.a.e2());
            curvesValue = this.l.greenCurve;
        } else if (i2 != 3) {
            curvesValue = null;
        } else {
            this.h.setColor(C5495Jo7.a.t2());
            curvesValue = this.l.blueCurve;
        }
        int i3 = 0;
        while (i3 < 5) {
            String str = i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "" : String.format(Locale.US, "%.2f", Float.valueOf(curvesValue.whitesLevel / 100.0f)) : String.format(Locale.US, "%.2f", Float.valueOf(curvesValue.highlightsLevel / 100.0f)) : String.format(Locale.US, "%.2f", Float.valueOf(curvesValue.midtonesLevel / 100.0f)) : String.format(Locale.US, "%.2f", Float.valueOf(curvesValue.shadowsLevel / 100.0f)) : String.format(Locale.US, "%.2f", Float.valueOf(curvesValue.blacksLevel / 100.0f));
            float fMeasureText = this.i.measureText(str);
            Rect rect3 = this.e;
            canvas.drawText(str, rect3.x + ((f - fMeasureText) / 2.0f) + (i3 * f), (rect3.y + rect3.height) - C22078ud6.a(4.0f), this.i);
            i3++;
        }
        float[] fArrInterpolateCurve = curvesValue.interpolateCurve();
        invalidate();
        this.j.reset();
        for (int i4 = 0; i4 < fArrInterpolateCurve.length / 2; i4++) {
            if (i4 == 0) {
                Path path = this.j;
                Rect rect4 = this.e;
                int i5 = i4 * 2;
                path.moveTo(rect4.x + (fArrInterpolateCurve[i5] * rect4.width), rect4.y + ((1.0f - fArrInterpolateCurve[i5 + 1]) * rect4.height));
            } else {
                Path path2 = this.j;
                Rect rect5 = this.e;
                int i6 = i4 * 2;
                path2.lineTo(rect5.x + (fArrInterpolateCurve[i6] * rect5.width), rect5.y + ((1.0f - fArrInterpolateCurve[i6 + 1]) * rect5.height));
            }
        }
        canvas.drawPath(this.j, this.h);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 3
            r3 = 1
            if (r0 == 0) goto L2b
            if (r0 == r3) goto L1f
            r4 = 2
            if (r0 == r4) goto L17
            if (r0 == r2) goto L1f
            r4 = 5
            if (r0 == r4) goto L2b
            r4 = 6
            if (r0 == r4) goto L1f
            goto L76
        L17:
            boolean r0 = r7.b
            if (r0 == 0) goto L76
            r7.a(r4, r8)
            goto L76
        L1f:
            boolean r0 = r7.b
            if (r0 == 0) goto L28
            r7.a(r2, r8)
            r7.b = r1
        L28:
            r7.c = r3
            goto L76
        L2b:
            int r0 = r8.getPointerCount()
            if (r0 != r3) goto L6b
            boolean r0 = r7.c
            if (r0 == 0) goto L76
            boolean r0 = r7.b
            if (r0 != 0) goto L76
            float r0 = r8.getX()
            float r2 = r8.getY()
            r7.d = r2
            ir.nasim.features.media.components.Rect r4 = r7.e
            float r5 = r4.x
            int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r6 < 0) goto L61
            float r6 = r4.width
            float r5 = r5 + r6
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L61
            float r0 = r4.y
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 < 0) goto L61
            float r4 = r4.height
            float r0 = r0 + r4
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 > 0) goto L61
            r7.b = r3
        L61:
            r7.c = r1
            boolean r0 = r7.b
            if (r0 == 0) goto L76
            r7.a(r3, r8)
            goto L76
        L6b:
            boolean r0 = r7.b
            if (r0 == 0) goto L76
            r7.a(r2, r8)
            r7.c = r3
            r7.b = r1
        L76:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.components.PhotoFilterCurvesControl.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setActualArea(float f, float f2, float f3, float f4) {
        Rect rect = this.e;
        rect.x = f;
        rect.y = f2;
        rect.width = f3;
        rect.height = f4;
    }

    public void setDelegate(PhotoFilterCurvesControlDelegate photoFilterCurvesControlDelegate) {
        this.k = photoFilterCurvesControlDelegate;
    }
}
