package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import ir.nasim.AbstractC19837r15;
import ir.nasim.V05;

/* renamed from: ir.nasim.qq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19724qq implements V05 {
    private final Path b;
    private RectF c;
    private float[] d;
    private Matrix e;

    public C19724qq(Path path) {
        this.b = path;
    }

    private final void v(CK5 ck5) {
        if (Float.isNaN(ck5.i()) || Float.isNaN(ck5.l()) || Float.isNaN(ck5.j()) || Float.isNaN(ck5.e())) {
            AbstractC21611tq.d("Invalid rectangle, make sure no value is NaN");
        }
    }

    @Override // ir.nasim.V05
    public void a(float f, float f2) {
        this.b.moveTo(f, f2);
    }

    @Override // ir.nasim.V05
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b.cubicTo(f, f2, f3, f4, f5, f6);
    }

    @Override // ir.nasim.V05
    public void c(float f, float f2) {
        this.b.lineTo(f, f2);
    }

    @Override // ir.nasim.V05
    public void close() {
        this.b.close();
    }

    @Override // ir.nasim.V05
    public boolean d() {
        return this.b.isConvex();
    }

    @Override // ir.nasim.V05
    public void e(float f, float f2) {
        this.b.rMoveTo(f, f2);
    }

    @Override // ir.nasim.V05
    public void f(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b.rCubicTo(f, f2, f3, f4, f5, f6);
    }

    @Override // ir.nasim.V05
    public CK5 getBounds() {
        if (this.c == null) {
            this.c = new RectF();
        }
        RectF rectF = this.c;
        AbstractC13042fc3.f(rectF);
        this.b.computeBounds(rectF, true);
        return new CK5(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // ir.nasim.V05
    public void h(int i) {
        this.b.setFillType(AbstractC14502i15.d(i, AbstractC14502i15.a.a()) ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
    }

    @Override // ir.nasim.V05
    public void i(float f, float f2, float f3, float f4) {
        this.b.quadTo(f, f2, f3, f4);
    }

    @Override // ir.nasim.V05
    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // ir.nasim.V05
    public void j(long j) {
        Matrix matrix = this.e;
        if (matrix == null) {
            this.e = new Matrix();
        } else {
            AbstractC13042fc3.f(matrix);
            matrix.reset();
        }
        Matrix matrix2 = this.e;
        AbstractC13042fc3.f(matrix2);
        matrix2.setTranslate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        Path path = this.b;
        Matrix matrix3 = this.e;
        AbstractC13042fc3.f(matrix3);
        path.transform(matrix3);
    }

    @Override // ir.nasim.V05
    public void k(CK5 ck5, V05.b bVar) {
        v(ck5);
        if (this.c == null) {
            this.c = new RectF();
        }
        RectF rectF = this.c;
        AbstractC13042fc3.f(rectF);
        rectF.set(ck5.i(), ck5.l(), ck5.j(), ck5.e());
        Path path = this.b;
        RectF rectF2 = this.c;
        AbstractC13042fc3.f(rectF2);
        path.addRect(rectF2, AbstractC21611tq.e(bVar));
    }

    @Override // ir.nasim.V05
    public void l(I46 i46, V05.b bVar) {
        if (this.c == null) {
            this.c = new RectF();
        }
        RectF rectF = this.c;
        AbstractC13042fc3.f(rectF);
        rectF.set(i46.e(), i46.g(), i46.f(), i46.a());
        if (this.d == null) {
            this.d = new float[8];
        }
        float[] fArr = this.d;
        AbstractC13042fc3.f(fArr);
        fArr[0] = Float.intBitsToFloat((int) (i46.h() >> 32));
        fArr[1] = Float.intBitsToFloat((int) (i46.h() & 4294967295L));
        fArr[2] = Float.intBitsToFloat((int) (i46.i() >> 32));
        fArr[3] = Float.intBitsToFloat((int) (i46.i() & 4294967295L));
        fArr[4] = Float.intBitsToFloat((int) (i46.c() >> 32));
        fArr[5] = Float.intBitsToFloat((int) (i46.c() & 4294967295L));
        fArr[6] = Float.intBitsToFloat((int) (i46.b() >> 32));
        fArr[7] = Float.intBitsToFloat((int) (i46.b() & 4294967295L));
        Path path = this.b;
        RectF rectF2 = this.c;
        AbstractC13042fc3.f(rectF2);
        float[] fArr2 = this.d;
        AbstractC13042fc3.f(fArr2);
        path.addRoundRect(rectF2, fArr2, AbstractC21611tq.e(bVar));
    }

    @Override // ir.nasim.V05
    public boolean m(V05 v05, V05 v052, int i) {
        AbstractC19837r15.a aVar = AbstractC19837r15.a;
        Path.Op op = AbstractC19837r15.f(i, aVar.a()) ? Path.Op.DIFFERENCE : AbstractC19837r15.f(i, aVar.b()) ? Path.Op.INTERSECT : AbstractC19837r15.f(i, aVar.c()) ? Path.Op.REVERSE_DIFFERENCE : AbstractC19837r15.f(i, aVar.d()) ? Path.Op.UNION : Path.Op.XOR;
        Path path = this.b;
        if (!(v05 instanceof C19724qq)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        Path pathU = ((C19724qq) v05).u();
        if (v052 instanceof C19724qq) {
            return path.op(pathU, ((C19724qq) v052).u(), op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // ir.nasim.V05
    public void n(float f, float f2, float f3, float f4) {
        this.b.rQuadTo(f, f2, f3, f4);
    }

    @Override // ir.nasim.V05
    public int q() {
        return this.b.getFillType() == Path.FillType.EVEN_ODD ? AbstractC14502i15.a.a() : AbstractC14502i15.a.b();
    }

    @Override // ir.nasim.V05
    public void r(V05 v05, long j) {
        Path path = this.b;
        if (!(v05 instanceof C19724qq)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        path.addPath(((C19724qq) v05).u(), Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    @Override // ir.nasim.V05
    public void reset() {
        this.b.reset();
    }

    @Override // ir.nasim.V05
    public void s(float f, float f2) {
        this.b.rLineTo(f, f2);
    }

    @Override // ir.nasim.V05
    public void t() {
        this.b.rewind();
    }

    public final Path u() {
        return this.b;
    }

    public /* synthetic */ C19724qq(Path path, int i, ED1 ed1) {
        this((i & 1) != 0 ? new Path() : path);
    }
}
