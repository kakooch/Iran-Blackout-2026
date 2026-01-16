package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes8.dex */
public abstract class V1 implements InterfaceC9428Zw6 {
    public static final a g = new a(null);
    private final String a;
    private Path b;
    private float c;
    private float d;
    private float e;
    private float f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public V1(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        this.a = str;
        this.b = new Path();
    }

    private final RectF f() {
        RectF rectF = new RectF();
        this.b.computeBounds(rectF, true);
        return rectF;
    }

    public void d(Canvas canvas, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        canvas.drawPath(this.b, paint);
    }

    protected final float e() {
        return this.f;
    }

    protected final float g() {
        return this.c;
    }

    protected final Path h() {
        return this.b;
    }

    protected final float i() {
        return this.e;
    }

    protected final String j() {
        return this.a;
    }

    protected final float k() {
        return this.d;
    }

    public final boolean l() {
        RectF rectFF = f();
        return rectFF.top < 4.0f && rectFF.bottom < 4.0f && rectFF.left < 4.0f && rectFF.right < 4.0f;
    }

    protected final void m(float f) {
        this.f = f;
    }

    protected final void n(float f) {
        this.c = f;
    }

    protected final void o(Path path) {
        AbstractC13042fc3.i(path, "<set-?>");
        this.b = path;
    }

    protected final void p(float f) {
        this.e = f;
    }

    protected final void q(float f) {
        this.d = f;
    }

    public String toString() {
        return this.a + ": left: " + this.c + " - top: " + this.d + " - right: " + this.e + " - bottom: " + this.f;
    }
}
