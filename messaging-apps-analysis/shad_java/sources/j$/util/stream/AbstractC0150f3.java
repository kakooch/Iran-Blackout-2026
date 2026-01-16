package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.f3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0150f3 implements InterfaceC0174j3 {
    protected final InterfaceC0192m3 a;

    public AbstractC0150f3(InterfaceC0192m3 interfaceC0192m3) {
        interfaceC0192m3.getClass();
        this.a = interfaceC0192m3;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        AbstractC0202o1.a(this, d);
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

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
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
