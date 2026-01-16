package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import j$.util.t;

/* renamed from: j$.util.stream.f2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0149f2 extends AbstractC0167i2 implements t.a {
    C0149f2(InterfaceC0235u1 interfaceC0235u1) {
        super(interfaceC0235u1);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.j(this, consumer);
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.b(this, consumer);
    }
}
