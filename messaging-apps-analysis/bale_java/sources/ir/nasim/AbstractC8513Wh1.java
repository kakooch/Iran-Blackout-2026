package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC8513Wh1;
import ir.nasim.PS0;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;

/* renamed from: ir.nasim.Wh1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8513Wh1 {

    /* renamed from: ir.nasim.Wh1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C23209wY a;

        a(C23209wY c23209wY) {
            this.a = c23209wY;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(this.a.b(), null, false, 0, interfaceC22053ub1, 0, 14), null, AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, G10.b).b().j()), N46.g()), this.a.a(), this.a.d(), 0.0f, false, null, 28, null), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1, 24624, 104);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wh1$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ C23209wY b;

        b(UA2 ua2, C23209wY c23209wY) {
            this.a = ua2;
            this.b = c23209wY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, C23209wY c23209wY) {
            AbstractC13042fc3.i(ua2, "$selectOrRemoveContact");
            AbstractC13042fc3.i(c23209wY, "$contact");
            ua2.invoke(c23209wY);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(174517121);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final UA2 ua2 = this.a;
            final C23209wY c23209wY = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Xh1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC8513Wh1.b.c(ua2, c23209wY);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(eVarF, g10.c(interfaceC22053ub1, i2).b().b());
            AbstractC24077y03.b(FV4.c(KB5.cross_search, interfaceC22053ub1, 0), UY6.c(AbstractC12217eE5.deleted_for_chip_content_desc, interfaceC22053ub1, 0) + this.b.d(), eVarT, g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final List list, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        AbstractC13042fc3.i(list, "selectedContact");
        AbstractC13042fc3.i(ua2, "selectOrRemoveContact");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1285122474);
        int i2 = (i & 6) == 0 ? (interfaceC22053ub1J.D(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                C23209wY c23209wY = (C23209wY) list.get(i3);
                e.a aVar = androidx.compose.ui.e.a;
                G10 g10 = G10.a;
                int i4 = G10.b;
                NS0.f(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g10.c(interfaceC22053ub1J, i4).b().r(), g10.c(interfaceC22053ub1J, i4).b().r(), g10.c(interfaceC22053ub1J, i4).b().r(), 1, null), false, null, false, c23209wY.d(), new PS0.b(null, AbstractC19242q11.e(-1558873377, true, new a(c23209wY), interfaceC22053ub1J, 54), AbstractC19242q11.e(-304091360, true, new b(ua2, c23209wY), interfaceC22053ub1J, 54), 1, null), 0L, interfaceC22053ub1J, PS0.b.d << 15, 78);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Vh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC8513Wh1.c(list, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(List list, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(list, "$selectedContact");
        AbstractC13042fc3.i(ua2, "$selectOrRemoveContact");
        b(list, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
