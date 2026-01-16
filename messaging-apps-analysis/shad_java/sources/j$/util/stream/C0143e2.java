package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.t;

/* renamed from: j$.util.stream.e2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0143e2 extends W3 implements InterfaceC0245w1, InterfaceC0214q1 {
    C0143e2() {
    }

    @Override // j$.util.stream.W3
    /* renamed from: C */
    public t.b spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.function.Consumer
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Integer num) {
        AbstractC0202o1.b(this, num);
    }

    @Override // j$.util.stream.A1
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Integer[] numArr, int i) {
        AbstractC0202o1.i(this, numArr, i);
    }

    @Override // j$.util.stream.A1
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ InterfaceC0245w1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.o(this, j, j2, mVar);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(double d) {
        AbstractC0202o1.f(this);
        throw null;
    }

    @Override // j$.util.stream.W3, j$.util.function.l
    public void accept(int i) {
        super.accept(i);
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

    @Override // j$.util.stream.InterfaceC0214q1, j$.util.stream.InterfaceC0225s1
    public InterfaceC0245w1 b() {
        return this;
    }

    @Override // j$.util.stream.InterfaceC0260z1, j$.util.stream.A1
    public InterfaceC0260z1 c(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.Z3, j$.util.stream.InterfaceC0260z1
    public void e(Object obj, int i) {
        super.e((int[]) obj, i);
    }

    @Override // j$.util.stream.Z3, j$.util.stream.InterfaceC0260z1
    public Object g() {
        return (int[]) super.g();
    }

    @Override // j$.util.stream.Z3, j$.util.stream.InterfaceC0260z1
    public void h(Object obj) {
        super.h((j$.util.function.l) obj);
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

    @Override // j$.util.stream.W3, j$.util.stream.Z3, java.lang.Iterable, j$.lang.e
    public j$.util.u spliterator() {
        return super.spliterator();
    }

    @Override // j$.util.stream.A1
    public /* bridge */ /* synthetic */ A1 c(int i) {
        c(i);
        throw null;
    }

    @Override // j$.util.stream.W3, j$.util.stream.Z3, java.lang.Iterable, j$.lang.e
    public j$.util.t spliterator() {
        return super.spliterator();
    }
}
