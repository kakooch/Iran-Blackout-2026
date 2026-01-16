package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.Gf1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4706Gf1 {

    /* renamed from: ir.nasim.Gf1$a */
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
            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(this.a.b(), null, false, 0, interfaceC22053ub1, 0, 14), null, AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(50)), N46.g()), this.a.a(), this.a.d(), 0.0f, false, null, 28, null), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1, 24624, 104);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Gf1$b */
    static final class b implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ InterfaceC10258bL6 c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ List e;

        b(C20996sx3 c20996sx3, boolean z, InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, List list) {
            this.a = c20996sx3;
            this.b = z;
            this.c = interfaceC10258bL6;
            this.d = ua2;
            this.e = list;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C23209wY c23209wY = (C23209wY) this.a.f(i);
            if (c23209wY == null) {
                return;
            }
            AbstractC4706Gf1.e(c23209wY, this.b, this.c, this.d, this.e, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Gf1$c */
    static final class c implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ boolean b;
        final /* synthetic */ InterfaceC10258bL6 c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ List e;

        c(List list, boolean z, InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, List list2) {
            this.a = list;
            this.b = z;
            this.c = interfaceC10258bL6;
            this.d = ua2;
            this.e = list2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C23209wY c23209wY = (C23209wY) AbstractC15401jX0.t0(this.a, i);
            if (c23209wY == null) {
                return;
            }
            AbstractC4706Gf1.e(c23209wY, this.b, this.c, this.d, this.e, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final ir.nasim.C23209wY r25, final boolean r26, final ir.nasim.InterfaceC10258bL6 r27, final ir.nasim.UA2 r28, final java.util.List r29, ir.nasim.InterfaceC22053ub1 r30, final int r31) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4706Gf1.e(ir.nasim.wY, boolean, ir.nasim.bL6, ir.nasim.UA2, java.util.List, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(boolean z, InterfaceC10258bL6 interfaceC10258bL6, C23209wY c23209wY, UA2 ua2, boolean z2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$canAddToGroup");
        AbstractC13042fc3.i(c23209wY, "$it");
        AbstractC13042fc3.i(ua2, "$selectOrRemoveContact");
        if (!z || AbstractC13042fc3.d(((HashMap) interfaceC10258bL6.getValue()).get(Integer.valueOf(c23209wY.a())), Boolean.TRUE)) {
            ua2.invoke(c23209wY);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(C23209wY c23209wY, boolean z, InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c23209wY, "$it");
        AbstractC13042fc3.i(interfaceC10258bL6, "$canAddToGroup");
        AbstractC13042fc3.i(ua2, "$selectOrRemoveContact");
        AbstractC13042fc3.i(list, "$selectedContact");
        e(c23209wY, z, interfaceC10258bL6, ua2, list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void i(InterfaceC15069ix3 interfaceC15069ix3, C20996sx3 c20996sx3, List list, boolean z, InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC15069ix3, "<this>");
        AbstractC13042fc3.i(c20996sx3, "lazyPagingItems");
        AbstractC13042fc3.i(list, "selectedContact");
        AbstractC13042fc3.i(interfaceC10258bL6, "canAddToGroup");
        AbstractC13042fc3.i(ua2, "selectOrRemoveContact");
        InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.Df1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC4706Gf1.j((C23209wY) obj);
            }
        }), null, AbstractC19242q11.c(-1304157777, true, new b(c20996sx3, z, interfaceC10258bL6, ua2, list)), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object j(C23209wY c23209wY) {
        AbstractC13042fc3.i(c23209wY, "it");
        return Integer.valueOf(c23209wY.a());
    }

    public static final void k(InterfaceC15069ix3 interfaceC15069ix3, final List list, List list2, boolean z, InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC15069ix3, "<this>");
        AbstractC13042fc3.i(list, "items");
        AbstractC13042fc3.i(list2, "selectedContact");
        AbstractC13042fc3.i(interfaceC10258bL6, "canAddToGroup");
        AbstractC13042fc3.i(ua2, "selectOrRemoveContact");
        InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), new UA2() { // from class: ir.nasim.Cf1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC4706Gf1.l(list, ((Integer) obj).intValue());
            }
        }, null, AbstractC19242q11.c(-294822083, true, new c(list, z, interfaceC10258bL6, ua2, list2)), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object l(List list, int i) {
        AbstractC13042fc3.i(list, "$items");
        C23209wY c23209wY = (C23209wY) AbstractC15401jX0.t0(list, i);
        return Integer.valueOf(c23209wY != null ? c23209wY.a() : AbstractC17026mG5.a.f());
    }
}
