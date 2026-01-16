package ir.nasim;

import ir.nasim.InterfaceC24357yU3;

/* renamed from: ir.nasim.zU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC24951zU3 {

    /* renamed from: ir.nasim.zU3$a */
    class a extends AbstractC24951zU3 {
        final /* synthetic */ InterfaceC24357yU3.b a;
        final /* synthetic */ C18332oU3 b;

        a(InterfaceC24357yU3.b bVar, C18332oU3 c18332oU3) {
            this.a = bVar;
            this.b = c18332oU3;
        }

        @Override // ir.nasim.AbstractC24951zU3
        InterfaceC24357yU3 a() {
            return this.a.b(this.b, new C18280oO5());
        }
    }

    AbstractC24951zU3() {
    }

    static AbstractC24951zU3 b(InterfaceC24357yU3.b bVar, C18332oU3 c18332oU3) {
        return new a(bVar, c18332oU3);
    }

    abstract InterfaceC24357yU3 a();
}
