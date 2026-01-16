package ir.nasim;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.hx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14465hx6 {
    private final List a;
    private PointF b;
    private boolean c;

    public C14465hx6(PointF pointF, boolean z, List list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
    }

    public List a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(C14465hx6 c14465hx6, C14465hx6 c14465hx62, float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = c14465hx6.d() || c14465hx62.d();
        if (c14465hx6.a().size() != c14465hx62.a().size()) {
            JI3.c("Curves must have the same number of control points. Shape 1: " + c14465hx6.a().size() + "\tShape 2: " + c14465hx62.a().size());
        }
        int iMin = Math.min(c14465hx6.a().size(), c14465hx62.a().size());
        if (this.a.size() < iMin) {
            for (int size = this.a.size(); size < iMin; size++) {
                this.a.add(new C13267fw1());
            }
        } else if (this.a.size() > iMin) {
            for (int size2 = this.a.size() - 1; size2 >= iMin; size2--) {
                List list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = c14465hx6.b();
        PointF pointFB2 = c14465hx62.b();
        f(AbstractC7323Rf4.i(pointFB.x, pointFB2.x, f), AbstractC7323Rf4.i(pointFB.y, pointFB2.y, f));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            C13267fw1 c13267fw1 = (C13267fw1) c14465hx6.a().get(size3);
            C13267fw1 c13267fw12 = (C13267fw1) c14465hx62.a().get(size3);
            PointF pointFA = c13267fw1.a();
            PointF pointFB3 = c13267fw1.b();
            PointF pointFC = c13267fw1.c();
            PointF pointFA2 = c13267fw12.a();
            PointF pointFB4 = c13267fw12.b();
            PointF pointFC2 = c13267fw12.c();
            ((C13267fw1) this.a.get(size3)).d(AbstractC7323Rf4.i(pointFA.x, pointFA2.x, f), AbstractC7323Rf4.i(pointFA.y, pointFA2.y, f));
            ((C13267fw1) this.a.get(size3)).e(AbstractC7323Rf4.i(pointFB3.x, pointFB4.x, f), AbstractC7323Rf4.i(pointFB3.y, pointFB4.y, f));
            ((C13267fw1) this.a.get(size3)).f(AbstractC7323Rf4.i(pointFC.x, pointFC2.x, f), AbstractC7323Rf4.i(pointFC.y, pointFC2.y, f));
        }
    }

    public boolean d() {
        return this.c;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }

    public C14465hx6() {
        this.a = new ArrayList();
    }
}
