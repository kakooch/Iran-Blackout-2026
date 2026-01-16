package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ir.nasim.Rn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7390Rn implements UE0 {
    private Canvas a = AbstractC7624Sn.a;
    private Rect b;
    private Rect c;

    public final Canvas a() {
        return this.a;
    }

    @Override // ir.nasim.UE0
    public void b(float f, float f2, float f3, float f4, int i) {
        this.a.clipRect(f, f2, f3, f4, z(i));
    }

    @Override // ir.nasim.UE0
    public void c(float f, float f2) {
        this.a.translate(f, f2);
    }

    @Override // ir.nasim.UE0
    public void d(V05 v05, int i) {
        Canvas canvas = this.a;
        if (!(v05 instanceof C19724qq)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((C19724qq) v05).u(), z(i));
    }

    @Override // ir.nasim.UE0
    public void e(float f, float f2) {
        this.a.scale(f, f2);
    }

    @Override // ir.nasim.UE0
    public void f(V05 v05, InterfaceC12969fU4 interfaceC12969fU4) {
        Canvas canvas = this.a;
        if (!(v05 instanceof C19724qq)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((C19724qq) v05).u(), interfaceC12969fU4.p());
    }

    @Override // ir.nasim.UE0
    public void h(Y03 y03, long j, long j2, long j3, long j4, InterfaceC12969fU4 interfaceC12969fU4) {
        if (this.b == null) {
            this.b = new Rect();
            this.c = new Rect();
        }
        Canvas canvas = this.a;
        Bitmap bitmapB = AbstractC19123pp.b(y03);
        Rect rect = this.b;
        AbstractC13042fc3.f(rect);
        rect.left = C22045ua3.k(j);
        rect.top = C22045ua3.l(j);
        rect.right = C22045ua3.k(j) + ((int) (j2 >> 32));
        rect.bottom = C22045ua3.l(j) + ((int) (j2 & 4294967295L));
        C19938rB7 c19938rB7 = C19938rB7.a;
        Rect rect2 = this.c;
        AbstractC13042fc3.f(rect2);
        rect2.left = C22045ua3.k(j3);
        rect2.top = C22045ua3.l(j3);
        rect2.right = C22045ua3.k(j3) + ((int) (j4 >> 32));
        rect2.bottom = C22045ua3.l(j3) + ((int) (j4 & 4294967295L));
        canvas.drawBitmap(bitmapB, rect, rect2, interfaceC12969fU4.p());
    }

    @Override // ir.nasim.UE0
    public void i() {
        this.a.restore();
    }

    @Override // ir.nasim.UE0
    public void j(CK5 ck5, InterfaceC12969fU4 interfaceC12969fU4) {
        this.a.saveLayer(ck5.i(), ck5.l(), ck5.j(), ck5.e(), interfaceC12969fU4.p(), 31);
    }

    @Override // ir.nasim.UE0
    public void k() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C23629xF0.a.a(this.a, true);
    }

    @Override // ir.nasim.UE0
    public void l(float f) {
        this.a.rotate(f);
    }

    @Override // ir.nasim.UE0
    public void n() {
        this.a.save();
    }

    @Override // ir.nasim.UE0
    public void o(float f, float f2, float f3, float f4, float f5, float f6, boolean z, InterfaceC12969fU4 interfaceC12969fU4) {
        this.a.drawArc(f, f2, f3, f4, f5, f6, z, interfaceC12969fU4.p());
    }

    @Override // ir.nasim.UE0
    public void p() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C23629xF0.a.a(this.a, false);
    }

    @Override // ir.nasim.UE0
    public void r(float[] fArr) {
        if (EV3.a(fArr)) {
            return;
        }
        Matrix matrix = new Matrix();
        AbstractC5964Lp.a(matrix, fArr);
        this.a.concat(matrix);
    }

    @Override // ir.nasim.UE0
    public void t(float f, float f2, float f3, float f4, InterfaceC12969fU4 interfaceC12969fU4) {
        this.a.drawRect(f, f2, f3, f4, interfaceC12969fU4.p());
    }

    @Override // ir.nasim.UE0
    public void u(long j, long j2, InterfaceC12969fU4 interfaceC12969fU4) {
        this.a.drawLine(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), interfaceC12969fU4.p());
    }

    @Override // ir.nasim.UE0
    public void v(float f, float f2, float f3, float f4, float f5, float f6, InterfaceC12969fU4 interfaceC12969fU4) {
        this.a.drawRoundRect(f, f2, f3, f4, f5, f6, interfaceC12969fU4.p());
    }

    @Override // ir.nasim.UE0
    public void w(long j, float f, InterfaceC12969fU4 interfaceC12969fU4) {
        this.a.drawCircle(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), f, interfaceC12969fU4.p());
    }

    @Override // ir.nasim.UE0
    public void x(Y03 y03, long j, InterfaceC12969fU4 interfaceC12969fU4) {
        this.a.drawBitmap(AbstractC19123pp.b(y03), Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), interfaceC12969fU4.p());
    }

    public final void y(Canvas canvas) {
        this.a = canvas;
    }

    public final Region.Op z(int i) {
        return GV0.d(i, GV0.a.a()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }
}
