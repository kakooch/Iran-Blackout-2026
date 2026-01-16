package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import ir.nasim.DK5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterView;
import java.util.Locale;

/* loaded from: classes7.dex */
public class PhotoFilterCurvesControl extends View {
    private int a;
    private boolean b;
    private boolean c;
    private float d;
    private float e;
    private DK5 f;
    private Paint g;
    private Paint h;
    private Paint i;
    private TextPaint j;
    private Path k;
    private a l;
    private PhotoFilterView.b m;

    public interface a {
        void valueChanged();
    }

    public PhotoFilterCurvesControl(Context context, PhotoFilterView.b bVar) {
        super(context);
        this.a = 0;
        this.c = true;
        this.f = new DK5();
        this.g = new Paint(1);
        this.h = new Paint(1);
        this.i = new Paint(1);
        this.j = new TextPaint(1);
        this.k = new Path();
        setWillNotDraw(false);
        this.m = bVar;
        this.g.setColor(-1711276033);
        this.g.setStrokeWidth(AbstractC21455b.F(1.0f));
        Paint paint = this.g;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.h.setColor(-1711276033);
        this.h.setStrokeWidth(AbstractC21455b.F(2.0f));
        this.h.setStyle(style);
        this.i.setColor(-1);
        this.i.setStrokeWidth(AbstractC21455b.F(2.0f));
        this.i.setStyle(style);
        this.j.setColor(-4210753);
        this.j.setTextSize(AbstractC21455b.F(13.0f));
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
        float fMin = Math.min(2.0f, (this.e - y) / 8.0f);
        PhotoFilterView.b bVar = this.m;
        int i2 = bVar.f;
        PhotoFilterView.c cVar = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : bVar.d : bVar.c : bVar.b : bVar.a;
        int i3 = this.a;
        if (i3 == 1) {
            cVar.a = Math.max(0.0f, Math.min(100.0f, cVar.a + fMin));
        } else if (i3 == 2) {
            cVar.b = Math.max(0.0f, Math.min(100.0f, cVar.b + fMin));
        } else if (i3 == 3) {
            cVar.c = Math.max(0.0f, Math.min(100.0f, cVar.c + fMin));
        } else if (i3 == 4) {
            cVar.d = Math.max(0.0f, Math.min(100.0f, cVar.d + fMin));
        } else if (i3 == 5) {
            cVar.e = Math.max(0.0f, Math.min(100.0f, cVar.e + fMin));
        }
        invalidate();
        a aVar = this.l;
        if (aVar != null) {
            aVar.valueChanged();
        }
        this.d = x;
        this.e = y;
    }

    private void b(float f) {
        if (this.a != 0) {
            return;
        }
        DK5 dk5 = this.f;
        this.a = (int) Math.floor(((f - dk5.a) / (dk5.c / 5.0f)) + 1.0f);
    }

    private void c() {
        if (this.a == 0) {
            return;
        }
        this.a = 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        PhotoFilterView.c cVar;
        float f = this.f.c / 5.0f;
        for (int i = 0; i < 4; i++) {
            DK5 dk5 = this.f;
            float f2 = dk5.a;
            float f3 = i * f;
            float f4 = dk5.b;
            canvas.drawLine(f2 + f + f3, f4, f2 + f + f3, f4 + dk5.d, this.g);
        }
        DK5 dk52 = this.f;
        float f5 = dk52.a;
        float f6 = dk52.b;
        canvas.drawLine(f5, f6 + dk52.d, f5 + dk52.c, f6, this.h);
        int i2 = this.m.f;
        if (i2 == 0) {
            this.i.setColor(-1);
            cVar = this.m.a;
        } else if (i2 == 1) {
            this.i.setColor(-1229492);
            cVar = this.m.b;
        } else if (i2 == 2) {
            this.i.setColor(-15667555);
            cVar = this.m.c;
        } else if (i2 != 3) {
            cVar = null;
        } else {
            this.i.setColor(-13404165);
            cVar = this.m.d;
        }
        int i3 = 0;
        while (i3 < 5) {
            String str = i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "" : String.format(Locale.US, "%.2f", Float.valueOf(cVar.e / 100.0f)) : String.format(Locale.US, "%.2f", Float.valueOf(cVar.d / 100.0f)) : String.format(Locale.US, "%.2f", Float.valueOf(cVar.c / 100.0f)) : String.format(Locale.US, "%.2f", Float.valueOf(cVar.b / 100.0f)) : String.format(Locale.US, "%.2f", Float.valueOf(cVar.a / 100.0f));
            float fMeasureText = this.j.measureText(str);
            DK5 dk53 = this.f;
            canvas.drawText(str, dk53.a + ((f - fMeasureText) / 2.0f) + (i3 * f), (dk53.b + dk53.d) - AbstractC21455b.F(4.0f), this.j);
            i3++;
        }
        float[] fArrB = cVar.b();
        invalidate();
        this.k.reset();
        for (int i4 = 0; i4 < fArrB.length / 2; i4++) {
            if (i4 == 0) {
                Path path = this.k;
                DK5 dk54 = this.f;
                int i5 = i4 * 2;
                path.moveTo(dk54.a + (fArrB[i5] * dk54.c), dk54.b + ((1.0f - fArrB[i5 + 1]) * dk54.d));
            } else {
                Path path2 = this.k;
                DK5 dk55 = this.f;
                int i6 = i4 * 2;
                path2.lineTo(dk55.a + (fArrB[i6] * dk55.c), dk55.b + ((1.0f - fArrB[i6 + 1]) * dk55.d));
            }
        }
        canvas.drawPath(this.k, this.i);
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
            goto L78
        L17:
            boolean r0 = r7.b
            if (r0 == 0) goto L78
            r7.a(r4, r8)
            goto L78
        L1f:
            boolean r0 = r7.b
            if (r0 == 0) goto L28
            r7.a(r2, r8)
            r7.b = r1
        L28:
            r7.c = r3
            goto L78
        L2b:
            int r0 = r8.getPointerCount()
            if (r0 != r3) goto L6d
            boolean r0 = r7.c
            if (r0 == 0) goto L78
            boolean r0 = r7.b
            if (r0 != 0) goto L78
            float r0 = r8.getX()
            float r2 = r8.getY()
            r7.d = r0
            r7.e = r2
            ir.nasim.DK5 r4 = r7.f
            float r5 = r4.a
            int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r6 < 0) goto L63
            float r6 = r4.c
            float r5 = r5 + r6
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L63
            float r0 = r4.b
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 < 0) goto L63
            float r4 = r4.d
            float r0 = r0 + r4
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 > 0) goto L63
            r7.b = r3
        L63:
            r7.c = r1
            boolean r0 = r7.b
            if (r0 == 0) goto L78
            r7.a(r3, r8)
            goto L78
        L6d:
            boolean r0 = r7.b
            if (r0 == 0) goto L78
            r7.a(r2, r8)
            r7.c = r3
            r7.b = r1
        L78:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterCurvesControl.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setActualArea(float f, float f2, float f3, float f4) {
        DK5 dk5 = this.f;
        dk5.a = f;
        dk5.b = f2;
        dk5.c = f3;
        dk5.d = f4;
    }

    public void setDelegate(a aVar) {
        this.l = aVar;
    }
}
