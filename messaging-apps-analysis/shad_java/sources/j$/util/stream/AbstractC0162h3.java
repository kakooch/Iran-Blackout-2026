package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.h3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0162h3 implements InterfaceC0186l3 {
    protected final InterfaceC0192m3 a;

    public AbstractC0162h3(InterfaceC0192m3 interfaceC0192m3) {
        interfaceC0192m3.getClass();
        this.a = interfaceC0192m3;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        AbstractC0202o1.c(this, l);
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

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
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
