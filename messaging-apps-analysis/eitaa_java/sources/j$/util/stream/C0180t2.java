package j$.util.stream;

import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* renamed from: j$.util.stream.t2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0180t2 implements InterfaceC0192w2<Long, Long, C0180t2>, C2.g {
    private long a;
    final /* synthetic */ long b;
    final /* synthetic */ j$.util.function.D c;

    C0180t2(long j, j$.util.function.D d) {
        this.b = j;
        this.c = d;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(double d) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.C2, j$.util.function.y
    public /* synthetic */ void accept(int i) {
        j$.time.a.a(this);
        throw null;
    }

    @Override // j$.util.stream.C2
    public void accept(long j) {
        this.a = this.c.applyAsLong(this.a, j);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        S1.c(this, l);
    }

    @Override // j$.util.function.E
    public j$.util.function.E f(j$.util.function.E e) {
        e.getClass();
        return new C0099j(this, e);
    }

    @Override // j$.util.function.L
    public Object get() {
        return Long.valueOf(this.a);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        accept(((C0180t2) interfaceC0192w2).a);
    }

    @Override // j$.util.stream.C2
    public void l() {
    }

    @Override // j$.util.stream.C2
    public void m(long j) {
        this.a = this.b;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
