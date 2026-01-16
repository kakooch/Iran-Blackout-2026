package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.t2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0231t2 extends C0121a4 implements A1, InterfaceC0225s1 {
    C0231t2() {
    }

    @Override // j$.util.stream.C0121a4, j$.lang.e
    public void a(Consumer consumer) {
        super.a(consumer);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(double d) {
        AbstractC0202o1.f(this);
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(int i) {
        AbstractC0202o1.d(this);
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public /* synthetic */ void accept(long j) {
        AbstractC0202o1.e(this);
        throw null;
    }

    @Override // j$.util.stream.C0121a4, j$.util.function.Consumer
    public void accept(Object obj) {
        super.accept(obj);
    }

    @Override // j$.util.stream.InterfaceC0225s1
    public A1 b() {
        return this;
    }

    @Override // j$.util.stream.A1
    public A1 c(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.C0121a4, j$.util.stream.A1
    public void j(Object[] objArr, int i) {
        super.j(objArr, i);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void n() {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        clear();
        v(j);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ int q() {
        return 0;
    }

    @Override // j$.util.stream.A1
    public Object[] r(j$.util.function.m mVar) {
        long jCount = count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) mVar.apply((int) jCount);
        j(objArr, 0);
        return objArr;
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ A1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.q(this, j, j2, mVar);
    }

    @Override // j$.util.stream.C0121a4, java.lang.Iterable, j$.lang.e
    public j$.util.t spliterator() {
        return super.spliterator();
    }
}
