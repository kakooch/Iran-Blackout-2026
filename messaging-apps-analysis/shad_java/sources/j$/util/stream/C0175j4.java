package j$.util.stream;

/* renamed from: j$.util.stream.j4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0175j4 extends AbstractC0181k4 implements j$.util.function.q {
    final long[] c;

    C0175j4(int i) {
        this.c = new long[i];
    }

    @Override // j$.util.stream.AbstractC0181k4
    public void a(Object obj, long j) {
        j$.util.function.q qVar = (j$.util.function.q) obj;
        for (int i = 0; i < j; i++) {
            qVar.accept(this.c[i]);
        }
    }

    @Override // j$.util.function.q
    public void accept(long j) {
        long[] jArr = this.c;
        int i = this.b;
        this.b = i + 1;
        jArr[i] = j;
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }
}
