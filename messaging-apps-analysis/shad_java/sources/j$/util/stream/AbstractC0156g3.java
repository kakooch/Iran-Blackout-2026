package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.g3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0156g3 implements InterfaceC0180k3 {
    protected final InterfaceC0192m3 a;

    public AbstractC0156g3(InterfaceC0192m3 interfaceC0192m3) {
        interfaceC0192m3.getClass();
        this.a = interfaceC0192m3;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Integer num) {
        AbstractC0202o1.b(this, num);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(double d) {
        AbstractC0202o1.f(this);
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

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        lVar.getClass();
        return new j$.util.function.k(this, lVar);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void n() {
        this.a.n();
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public boolean p() {
        return this.a.p();
    }
}
