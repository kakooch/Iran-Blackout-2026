package j$.util.stream;

import j$.wrappers.C0280i0;

/* renamed from: j$.util.stream.h1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0160h1 extends AbstractC0172j1 implements InterfaceC0186l3 {
    final /* synthetic */ EnumC0178k1 c;
    final /* synthetic */ C0280i0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0160h1(EnumC0178k1 enumC0178k1, C0280i0 c0280i0) {
        super(enumC0178k1);
        this.c = enumC0178k1;
        this.d = c0280i0;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        AbstractC0202o1.c(this, l);
    }

    @Override // j$.util.stream.AbstractC0172j1, j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        if (this.a || this.d.b(j) != this.c.a) {
            return;
        }
        this.a = true;
        this.b = this.c.b;
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }
}
