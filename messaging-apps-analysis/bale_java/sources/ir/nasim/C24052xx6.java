package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.xx6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C24052xx6 {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    private final List g = new ArrayList();
    private final List h = new ArrayList();
    private boolean i;

    /* renamed from: ir.nasim.xx6$a */
    class a extends g {
        final /* synthetic */ List b;
        final /* synthetic */ Matrix c;

        a(List list, Matrix matrix) {
            this.b = list;
            this.c = matrix;
        }

        @Override // ir.nasim.C24052xx6.g
        public void a(Matrix matrix, C6267Mw6 c6267Mw6, int i, Canvas canvas) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.c, c6267Mw6, i, canvas);
            }
        }
    }

    /* renamed from: ir.nasim.xx6$b */
    static class b extends g {
        private final d b;

        public b(d dVar) {
            this.b = dVar;
        }

        @Override // ir.nasim.C24052xx6.g
        public void a(Matrix matrix, C6267Mw6 c6267Mw6, int i, Canvas canvas) {
            c6267Mw6.a(canvas, matrix, new RectF(this.b.k(), this.b.o(), this.b.l(), this.b.j()), i, this.b.m(), this.b.n());
        }
    }

    /* renamed from: ir.nasim.xx6$c */
    static class c extends g {
        private final e b;
        private final float c;
        private final float d;

        public c(e eVar, float f, float f2) {
            this.b = eVar;
            this.c = f;
            this.d = f2;
        }

        @Override // ir.nasim.C24052xx6.g
        public void a(Matrix matrix, C6267Mw6 c6267Mw6, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.b.c - this.d, this.b.b - this.c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.d);
            matrix2.preRotate(c());
            c6267Mw6.b(canvas, matrix2, rectF, i);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.b.c - this.d) / (this.b.b - this.c)));
        }
    }

    /* renamed from: ir.nasim.xx6$d */
    public static class d extends f {
        private static final RectF h = new RectF();
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;

        public d(float f, float f2, float f3, float f4) {
            q(f);
            u(f2);
            r(f3);
            p(f4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.c;
        }

        private void p(float f) {
            this.e = f;
        }

        private void q(float f) {
            this.b = f;
        }

        private void r(float f) {
            this.d = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f) {
            this.f = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f) {
            this.g = f;
        }

        private void u(float f) {
            this.c = f;
        }

        @Override // ir.nasim.C24052xx6.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* renamed from: ir.nasim.xx6$e */
    public static class e extends f {
        private float b;
        private float c;

        @Override // ir.nasim.C24052xx6.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.c);
            path.transform(matrix);
        }
    }

    /* renamed from: ir.nasim.xx6$f */
    public static abstract class f {
        protected final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* renamed from: ir.nasim.xx6$g */
    static abstract class g {
        static final Matrix a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, C6267Mw6 c6267Mw6, int i, Canvas canvas);

        public final void b(C6267Mw6 c6267Mw6, int i, Canvas canvas) {
            a(a, c6267Mw6, i, canvas);
        }
    }

    public C24052xx6() {
        n(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (g() == f2) {
            return;
        }
        float fG = ((f2 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.h.add(new b(dVar));
        p(f2);
    }

    private void c(g gVar, float f2, float f3) {
        b(f2);
        this.h.add(gVar);
        p(f3);
    }

    private float g() {
        return this.e;
    }

    private float h() {
        return this.f;
    }

    private void p(float f2) {
        this.e = f2;
    }

    private void q(float f2) {
        this.f = f2;
    }

    private void r(float f2) {
        this.c = f2;
    }

    private void s(float f2) {
        this.d = f2;
    }

    private void t(float f2) {
        this.a = f2;
    }

    private void u(float f2) {
        this.b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        c(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        r(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        s(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((f) this.g.get(i)).a(matrix, path);
        }
    }

    boolean e() {
        return this.i;
    }

    g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.h), new Matrix(matrix));
    }

    float i() {
        return this.c;
    }

    float j() {
        return this.d;
    }

    float k() {
        return this.a;
    }

    float l() {
        return this.b;
    }

    public void m(float f2, float f3) {
        e eVar = new e();
        eVar.b = f2;
        eVar.c = f3;
        this.g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f2);
        s(f3);
    }

    public void n(float f2, float f3) {
        o(f2, f3, 270.0f, 0.0f);
    }

    public void o(float f2, float f3, float f4, float f5) {
        t(f2);
        u(f3);
        r(f2);
        s(f3);
        p(f4);
        q((f4 + f5) % 360.0f);
        this.g.clear();
        this.h.clear();
        this.i = false;
    }
}
