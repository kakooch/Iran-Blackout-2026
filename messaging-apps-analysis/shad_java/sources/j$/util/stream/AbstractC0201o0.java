package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.o0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0201o0 implements O4, P4 {
    private final boolean a;

    protected AbstractC0201o0(boolean z) {
        this.a = z;
    }

    @Override // j$.util.stream.O4
    public int a() {
        if (this.a) {
            return 0;
        }
        return EnumC0145e4.r;
    }

    public /* synthetic */ void accept(double d) {
        AbstractC0202o1.f(this);
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        AbstractC0202o1.d(this);
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        AbstractC0202o1.e(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.O4
    public Object c(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        (this.a ? new C0213q0(abstractC0256y2, tVar, this) : new C0218r0(abstractC0256y2, tVar, abstractC0256y2.w0(this))).invoke();
        return null;
    }

    @Override // j$.util.stream.O4
    public Object d(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        AbstractC0128c abstractC0128c = (AbstractC0128c) abstractC0256y2;
        abstractC0128c.o0(abstractC0128c.w0(this), tVar);
        return null;
    }

    @Override // j$.util.function.z
    public /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void n() {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void o(long j) {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }
}
