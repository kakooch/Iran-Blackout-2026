package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.PS0;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.List;

/* renamed from: ir.nasim.ln6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16746ln6 {

    /* renamed from: ir.nasim.ln6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C19206px3 d;
        final /* synthetic */ InterfaceC17916nm4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, C19206px3 c19206px3, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c19206px3;
            this.e = interfaceC17916nm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.size() > AbstractC16746ln6.g(this.e)) {
                    C19206px3 c19206px3 = this.d;
                    this.b = 1;
                    if (C19206px3.J(c19206px3, 0, 0, this, 2, null) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC16746ln6.h(this.e, this.c.size());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ln6$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ RM1 a;

        b(RM1 rm1) {
            this.a = rm1;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (((int) this.a.f()) == AbstractC5969Lp4.f()) {
                interfaceC22053ub1.W(2100247313);
                AbstractC11456d23.b(FV4.c(KB5.ic_saved_message, interfaceC22053ub1, 0), null, FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), N46.g()), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1, 24624, 104);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(2100726511);
            TU.m(AvatarAsyncImagePainterKt.h(this.a.c(), null, false, 0, interfaceC22053ub1, 48, 12), new UU(false, null, null, null, this.a.g(), (int) this.a.f(), false, 79, null), androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), 0.0f, 0.0f, 0.0f, null, interfaceC22053ub1, 384, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ln6$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ RM1 b;

        /* renamed from: ir.nasim.ln6$c$a */
        static final class a implements SA2 {
            final /* synthetic */ UA2 a;
            final /* synthetic */ RM1 b;

            a(UA2 ua2, RM1 rm1) {
                this.a = ua2;
                this.b = rm1;
            }

            public final void a() {
                this.a.invoke(this.b);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        c(UA2 ua2, RM1 rm1) {
            this.a = ua2;
            this.b = rm1;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            EV4 ev4C = FV4.c(AbstractC16390lB5.close, interfaceC22053ub1, 0);
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(-209300385);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            UA2 ua2 = this.a;
            RM1 rm1 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(ua2, rm1);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC11456d23.b(ev4C, "", androidx.compose.foundation.layout.t.t(androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null), C17784nZ1.q(18)), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ln6$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.ln6$e */
    public static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.ln6$f */
    public static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.ln6$g */
    public static final class g extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(List list, UA2 ua2) {
            super(4);
            this.e = list;
            this.f = ua2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            RM1 rm1 = (RM1) this.e.get(i);
            interfaceC22053ub1.W(-1741183779);
            PS0.b bVar = new PS0.b(null, AbstractC19242q11.e(-1877100685, true, new b(rm1), interfaceC22053ub1, 54), AbstractC19242q11.e(773917842, true, new c(this.f, rm1), interfaceC22053ub1, 54), 1, null);
            interfaceC22053ub1.W(775174233);
            String strC = ((int) rm1.f()) == AbstractC5969Lp4.f() ? UY6.c(AbstractC12217eE5.saved_message_dialog_title, interfaceC22053ub1, 0) : rm1.g();
            interfaceC22053ub1.Q();
            NS0.f(null, false, null, false, strC, bVar, 0L, interfaceC22053ub1, PS0.b.d << 15, 79);
            interfaceC22053ub1.Q();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(androidx.compose.ui.e r22, final java.util.List r23, float r24, final ir.nasim.UA2 r25, ir.nasim.C19206px3 r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16746ln6.e(androidx.compose.ui.e, java.util.List, float, ir.nasim.UA2, ir.nasim.px3, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(androidx.compose.ui.e eVar, List list, float f2, UA2 ua2, C19206px3 c19206px3, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$selectedDialogsList");
        AbstractC13042fc3.i(ua2, "$onRemoveClick");
        e(eVar, list, f2, ua2, c19206px3, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(InterfaceC17916nm4 interfaceC17916nm4) {
        return interfaceC17916nm4.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        interfaceC17916nm4.h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(List list, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$selectedDialogsList");
        AbstractC13042fc3.i(ua2, "$onRemoveClick");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
        interfaceC15069ix3.a(list.size(), new e(new UA2() { // from class: ir.nasim.kn6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC16746ln6.j((RM1) obj);
            }
        }, list), new f(d.e, list), AbstractC19242q11.c(-632812321, true, new g(list, ua2)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object j(RM1 rm1) {
        AbstractC13042fc3.i(rm1, "selectedDialog");
        return Long.valueOf(rm1.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(androidx.compose.ui.e eVar, List list, float f2, UA2 ua2, C19206px3 c19206px3, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$selectedDialogsList");
        AbstractC13042fc3.i(ua2, "$onRemoveClick");
        e(eVar, list, f2, ua2, c19206px3, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
