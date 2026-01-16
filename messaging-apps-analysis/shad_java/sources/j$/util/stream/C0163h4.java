package j$.util.stream;

/* renamed from: j$.util.stream.h4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0163h4 extends AbstractC0181k4 implements j$.util.function.f {
    final double[] c;

    C0163h4(int i) {
        this.c = new double[i];
    }

    @Override // j$.util.stream.AbstractC0181k4
    void a(Object obj, long j) {
        j$.util.function.f fVar = (j$.util.function.f) obj;
        for (int i = 0; i < j; i++) {
            fVar.accept(this.c[i]);
        }
    }

    @Override // j$.util.function.f
    public void accept(double d) {
        double[] dArr = this.c;
        int i = this.b;
        this.b = i + 1;
        dArr[i] = d;
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }
}
