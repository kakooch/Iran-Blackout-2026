package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.t;

/* loaded from: classes2.dex */
final class V1 extends U3 implements InterfaceC0235u1, InterfaceC0208p1 {
    V1() {
    }

    @Override // j$.util.stream.U3
    /* renamed from: C */
    public t.a spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.function.Consumer
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        AbstractC0202o1.a(this, d);
    }

    @Override // j$.util.stream.A1
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Double[] dArr, int i) {
        AbstractC0202o1.h(this, dArr, i);
    }

    @Override // j$.util.stream.A1
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ InterfaceC0235u1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.n(this, j, j2, mVar);
    }

    @Override // j$.util.stream.U3, j$.util.function.f
    public void accept(double d) {
        super.accept(d);
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

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0225s1
    public A1 b() {
        return this;
    }

    @Override // j$.util.stream.InterfaceC0208p1, j$.util.stream.InterfaceC0225s1
    public InterfaceC0235u1 b() {
        return this;
    }

    @Override // j$.util.stream.InterfaceC0260z1, j$.util.stream.A1
    public InterfaceC0260z1 c(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.Z3, j$.util.stream.InterfaceC0260z1
    public void e(Object obj, int i) {
        super.e((double[]) obj, i);
    }

    @Override // j$.util.stream.Z3, j$.util.stream.InterfaceC0260z1
    public Object g() {
        return (double[]) super.g();
    }

    @Override // j$.util.stream.Z3, j$.util.stream.InterfaceC0260z1
    public void h(Object obj) {
        super.h((j$.util.function.f) obj);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void n() {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        clear();
        y(j);
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
    public /* synthetic */ Object[] r(j$.util.function.m mVar) {
        return AbstractC0202o1.g(this, mVar);
    }

    @Override // j$.util.stream.U3, j$.util.stream.Z3, java.lang.Iterable, j$.lang.e
    public j$.util.u spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.A1
    public /* bridge */ /* synthetic */ A1 c(int i) {
        c(i);
        throw null;
    }

    @Override // j$.util.stream.U3, j$.util.stream.Z3, java.lang.Iterable, j$.lang.e
    public j$.util.t spliterator() {
        return super.spliterator();
    }
}
