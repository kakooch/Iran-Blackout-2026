package androidx.compose.foundation.layout;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC5452Jk0;
import ir.nasim.Q93;
import ir.nasim.T93;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public final class h implements InterfaceC5452Jk0 {
    public static final h a = new h();

    public static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC12529em e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC12529em interfaceC12529em) {
            super(1);
            this.e = interfaceC12529em;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    public static final class b extends AbstractC8614Ws3 implements UA2 {
        public b() {
            super(1);
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    private h() {
    }

    @Override // ir.nasim.InterfaceC5452Jk0
    public androidx.compose.ui.e e(androidx.compose.ui.e eVar) {
        return eVar.i(new BoxChildDataElement(InterfaceC12529em.a.e(), true, Q93.b() ? new b() : Q93.a()));
    }

    @Override // ir.nasim.InterfaceC5452Jk0
    public androidx.compose.ui.e h(androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em) {
        return eVar.i(new BoxChildDataElement(interfaceC12529em, false, Q93.b() ? new a(interfaceC12529em) : Q93.a()));
    }
}
