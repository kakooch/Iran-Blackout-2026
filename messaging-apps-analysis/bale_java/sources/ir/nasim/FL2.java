package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C17448mz0;
import ir.nasim.C21753u45;
import ir.nasim.C24254yJ;
import ir.nasim.FL2;
import ir.nasim.InterfaceC10254bL2;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;
import java.util.SortedSet;
import kotlin.NoWhenBranchMatchedException;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public abstract class FL2 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ InterfaceC9664aL6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = interfaceC9664aL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (FL2.v(this.d).e() == C17448mz0.a.d) {
                this.c.invoke(FL2.v(this.d).i());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ Activity a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ C12767fA0 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;

        /* synthetic */ class a extends EB2 implements SA2 {
            a(Object obj) {
                super(0, obj, Activity.class, "onBackPressed", "onBackPressed()V", 0);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                y();
                return C19938rB7.a;
            }

            public final void y() {
                ((Activity) this.receiver).onBackPressed();
            }
        }

        b(Activity activity, SA2 sa2, C12767fA0 c12767fA0, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9664aL6 interfaceC9664aL64) {
            this.a = activity;
            this.b = sa2;
            this.c = c12767fA0;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
            this.f = interfaceC9664aL63;
            this.g = interfaceC9664aL64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.x2();
            return C19938rB7.a;
        }

        public final void c(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            Activity activity = this.a;
            interfaceC22053ub1.W(1218907688);
            boolean zD = interfaceC22053ub1.D(activity);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(activity);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
            String strW = FL2.w(this.d);
            interfaceC22053ub1.W(1218911384);
            boolean zV = interfaceC22053ub1.V(this.b);
            final SA2 sa22 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.GL2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return FL2.b.d(sa22);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa23 = (SA2) objB2;
            interfaceC22053ub1.Q();
            C18519on6 c18519on6K = FL2.k(this.e);
            C9215Yz0 c9215Yz0H = FL2.h(this.f);
            boolean zS = FL2.h(this.f).s();
            boolean zQ = FL2.v(this.g).q();
            interfaceC22053ub1.W(1218923005);
            boolean zD2 = interfaceC22053ub1.D(this.c);
            final C12767fA0 c12767fA0 = this.c;
            Object objB3 = interfaceC22053ub1.B();
            if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.HL2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return FL2.b.f(c12767fA0);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC6787Oz0.s(null, sa2, strW, sa23, c18519on6K, c9215Yz0H, zS, zQ, (SA2) objB3, interfaceC22053ub1, (C9215Yz0.y << 15) | (C18519on6.c << 12) | 6, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC16978mB2 {
        final /* synthetic */ WH1 a;
        final /* synthetic */ InterfaceC9664aL6 b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ float d;
        final /* synthetic */ C12767fA0 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ InterfaceC9664aL6 h;
        final /* synthetic */ InterfaceC9102Ym4 i;

        static final class a implements UA2 {
            final /* synthetic */ C12767fA0 a;

            a(C12767fA0 c12767fA0) {
                this.a = c12767fA0;
            }

            public final void a(String str) {
                AbstractC13042fc3.i(str, "userId");
                this.a.G1(str);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((String) obj);
                return C19938rB7.a;
            }
        }

        public static final class b extends AbstractC8614Ws3 implements UA2 {
            public static final b e = new b();

            public b() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Object obj) {
                return null;
            }
        }

        /* renamed from: ir.nasim.FL2$c$c, reason: collision with other inner class name */
        public static final class C0361c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0361c(UA2 ua2, List list) {
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

        public static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC14603iB2 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(InterfaceC14603iB2 interfaceC14603iB2, List list) {
                super(2);
                this.e = interfaceC14603iB2;
                this.f = list;
            }

            public final long a(InterfaceC20387rv3 interfaceC20387rv3, int i) {
                return ((C10870cL2) this.e.invoke(interfaceC20387rv3, this.f.get(i))).g();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return C10870cL2.a(a((InterfaceC20387rv3) obj, ((Number) obj2).intValue()));
            }
        }

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

        public static final class f extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;
            final /* synthetic */ float f;
            final /* synthetic */ C12767fA0 g;
            final /* synthetic */ UA2 h;
            final /* synthetic */ InterfaceC14603iB2 i;
            final /* synthetic */ InterfaceC9102Ym4 j;
            final /* synthetic */ InterfaceC9664aL6 k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(List list, float f, C12767fA0 c12767fA0, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6) {
                super(4);
                this.e = list;
                this.f = f;
                this.g = c12767fA0;
                this.h = ua2;
                this.i = interfaceC14603iB2;
                this.j = interfaceC9102Ym4;
                this.k = interfaceC9664aL6;
            }

            public final void a(InterfaceC19187pv3 interfaceC19187pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                if ((i2 & 6) == 0) {
                    i3 = i2 | (interfaceC22053ub1.V(interfaceC19187pv3) ? 4 : 2);
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
                    AbstractC5138Ib1.Q(699646206, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:542)");
                }
                InterfaceC10258bL6 interfaceC10258bL6 = (InterfaceC10258bL6) this.e.get(i);
                interfaceC22053ub1.W(-1206007560);
                androidx.compose.ui.e eVarB = InterfaceC19187pv3.b(interfaceC19187pv3, androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), C17784nZ1.q(FL2.o(this.j) / 2)), null, null, null, 7, null);
                float f = this.f;
                interfaceC22053ub1.W(792395200);
                boolean zD = interfaceC22053ub1.D(this.g);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new a(this.g);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC14816iX4.h(eVarB, interfaceC10258bL6, f, (UA2) objB, this.h, this.i, this.g, UY6.c(BD5.features_call_guest_user, interfaceC22053ub1, 0), FL2.h(this.k).l(), interfaceC22053ub1, C12767fA0.x << 18);
                interfaceC22053ub1.Q();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                a((InterfaceC19187pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        c(WH1 wh1, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, float f2, C12767fA0 c12767fA0, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = wh1;
            this.b = interfaceC9664aL6;
            this.c = interfaceC9664aL62;
            this.d = f2;
            this.e = c12767fA0;
            this.f = ua2;
            this.g = interfaceC14603iB2;
            this.h = interfaceC9664aL63;
            this.i = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(WH1 wh1, InterfaceC9102Ym4 interfaceC9102Ym4, C4414Fa3 c4414Fa3) {
            AbstractC13042fc3.i(wh1, "$localDensity");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$columnHeightDp$delegate");
            FL2.p(interfaceC9102Ym4, C17784nZ1.q(wh1.D((int) (c4414Fa3.j() & 4294967295L)) - C17784nZ1.q(10)));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(int i, final InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, float f2, C12767fA0 c12767fA0, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC4369Ev3 interfaceC4369Ev3) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$participantCount$delegate");
            AbstractC13042fc3.i(interfaceC9664aL62, "$chunkedItems$delegate");
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            AbstractC13042fc3.i(ua2, "$openUserChat");
            AbstractC13042fc3.i(interfaceC14603iB2, "$showKickUserDialog");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$columnHeightDp$delegate");
            AbstractC13042fc3.i(interfaceC9664aL63, "$callScreenUiState$delegate");
            AbstractC13042fc3.i(interfaceC4369Ev3, "$this$LazyVerticalGrid");
            if (FL2.l(interfaceC9664aL6) != 0 && i < FL2.i(interfaceC9664aL62).size()) {
                List list = (List) FL2.i(interfaceC9664aL62).get(i);
                interfaceC4369Ev3.e(list.size(), new C0361c(new UA2() { // from class: ir.nasim.KL2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return FL2.c.k((InterfaceC10258bL6) obj);
                    }
                }, list), new d(new InterfaceC14603iB2() { // from class: ir.nasim.LL2
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return FL2.c.n(interfaceC9664aL6, (InterfaceC20387rv3) obj, (InterfaceC10258bL6) obj2);
                    }
                }, list), new e(b.e, list), AbstractC19242q11.c(699646206, true, new f(list, f2, c12767fA0, ua2, interfaceC14603iB2, interfaceC9102Ym4, interfaceC9664aL63)));
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object k(InterfaceC10258bL6 interfaceC10258bL6) {
            AbstractC13042fc3.i(interfaceC10258bL6, "it");
            return ((M26) interfaceC10258bL6.getValue()).j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C10870cL2 n(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20387rv3 interfaceC20387rv3, InterfaceC10258bL6 interfaceC10258bL6) {
            int iL;
            AbstractC13042fc3.i(interfaceC9664aL6, "$participantCount$delegate");
            AbstractC13042fc3.i(interfaceC20387rv3, "$this$items");
            AbstractC13042fc3.i(interfaceC10258bL6, "item");
            boolean zO = ((M26) interfaceC10258bL6.getValue()).o();
            int i = 2;
            if (!zO && (iL = FL2.l(interfaceC9664aL6)) != 1 && iL != 2) {
                i = 1;
            }
            return C10870cL2.a(AbstractC5554Jv3.a(i));
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            f((InterfaceC22573vT4) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }

        public final void f(InterfaceC22573vT4 interfaceC22573vT4, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC22573vT4, "$this$HorizontalPager");
            InterfaceC10254bL2.b bVar = new InterfaceC10254bL2.b(2);
            C24254yJ c24254yJ = C24254yJ.a;
            G10 g10 = G10.a;
            int i3 = G10.b;
            C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1, i3).b().u());
            C24254yJ.f fVarO2 = c24254yJ.o(g10.c(interfaceC22053ub1, i3).b().u());
            boolean z = true;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            interfaceC22053ub1.W(-1688518891);
            boolean zV = interfaceC22053ub1.V(this.a);
            final WH1 wh1 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.i;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.IL2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return FL2.c.h(wh1, interfaceC9102Ym4, (C4414Fa3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA = androidx.compose.ui.layout.e.a(eVarF, (UA2) objB);
            interfaceC22053ub1.W(-1688509469);
            boolean zV2 = interfaceC22053ub1.V(this.b);
            if (((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) <= 32 || !interfaceC22053ub1.e(i)) {
                if ((i2 & 48) != 32) {
                    z = false;
                }
            }
            boolean zV3 = zV2 | z | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.c(this.d) | interfaceC22053ub1.D(this.e) | interfaceC22053ub1.V(this.f) | interfaceC22053ub1.V(this.g) | interfaceC22053ub1.V(this.h);
            final InterfaceC9664aL6 interfaceC9664aL6 = this.b;
            final InterfaceC9664aL6 interfaceC9664aL62 = this.c;
            final float f2 = this.d;
            final C12767fA0 c12767fA0 = this.e;
            final UA2 ua2 = this.f;
            final InterfaceC14603iB2 interfaceC14603iB2 = this.g;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.i;
            final InterfaceC9664aL6 interfaceC9664aL63 = this.h;
            Object objB2 = interfaceC22053ub1.B();
            if (zV3 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.JL2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return FL2.c.i(i, interfaceC9664aL6, interfaceC9664aL62, f2, c12767fA0, ua2, interfaceC14603iB2, interfaceC9102Ym42, interfaceC9664aL63, (InterfaceC4369Ev3) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC15050iv3.a(bVar, eVarA, null, null, false, fVarO, fVarO2, null, false, null, (UA2) objB2, interfaceC22053ub1, 100663296, 0, 668);
        }
    }

    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ C12767fA0 b;
        final /* synthetic */ Context c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[C17448mz0.a.values().length];
                try {
                    iArr[C17448mz0.a.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[C17448mz0.a.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[C17448mz0.a.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[C17448mz0.a.g.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[C17448mz0.a.f.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[C17448mz0.a.i.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[C17448mz0.a.h.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[C17448mz0.a.d.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[C17448mz0.a.e.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[C17448mz0.a.l.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[C17448mz0.a.j.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[C17448mz0.a.k.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[C17448mz0.a.m.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[C17448mz0.a.n.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[C17448mz0.a.o.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                a = iArr;
            }
        }

        d(SA2 sa2, C12767fA0 c12767fA0, Context context, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
            this.a = sa2;
            this.b = c12767fA0;
            this.c = context;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 A(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.P2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 B(C12767fA0 c12767fA0, C21753u45.d dVar) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            AbstractC13042fc3.i(dVar, "permission");
            c12767fA0.s2(AbstractC4363Eu6.c(dVar));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 C(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.Q2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.w2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$openMoreOptionBottomSheet");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.o2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 w(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.P2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 x(C12767fA0 c12767fA0) {
            AbstractC13042fc3.i(c12767fA0, "$viewModel");
            c12767fA0.w2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y() {
            C20384rv0.a.S();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z() {
            C20384rv0.a.A();
            return C19938rB7.a;
        }

        public final void p(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            float f = 20;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.q.l(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), C17784nZ1.q(f), C17784nZ1.q(16), C17784nZ1.q(f), C17784nZ1.q(28)), C17784nZ1.q(Type.EUI48));
            C24254yJ.f fVarF = C24254yJ.a.f();
            final SA2 sa2 = this.a;
            final C12767fA0 c12767fA0 = this.b;
            Context context = this.c;
            InterfaceC9664aL6 interfaceC9664aL6 = this.d;
            InterfaceC9664aL6 interfaceC9664aL62 = this.e;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarF, InterfaceC12529em.a.l(), interfaceC22053ub1, 6);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            switch (a.a[FL2.v(interfaceC9664aL6).e().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    interfaceC22053ub1.W(-1566027430);
                    AbstractC7031Pz0 abstractC7031Pz0F = FL2.v(interfaceC9664aL6).f();
                    C17448mz0.a aVarE = FL2.v(interfaceC9664aL6).e();
                    InterfaceC8534Wj4 interfaceC8534Wj4H = FL2.h(interfaceC9664aL62).h();
                    boolean zY = FL2.h(interfaceC9664aL62).y();
                    boolean zX = FL2.h(interfaceC9664aL62).x();
                    boolean zP = FL2.h(interfaceC9664aL62).p();
                    boolean zM = FL2.h(interfaceC9664aL62).m();
                    interfaceC22053ub1.W(2027702159);
                    boolean zV = interfaceC22053ub1.V(sa2);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.ML2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.t(sa2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa22 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(2027709876);
                    boolean zD = interfaceC22053ub1.D(c12767fA0);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.NL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.A(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa23 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(2027721302);
                    boolean zD2 = interfaceC22053ub1.D(c12767fA0);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new UA2() { // from class: ir.nasim.OL2
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return FL2.d.B(c12767fA0, (C21753u45.d) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    UA2 ua2 = (UA2) objB3;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(2027714674);
                    boolean zD3 = interfaceC22053ub1.D(c12767fA0);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD3 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.PL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.C(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    SA2 sa24 = (SA2) objB4;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(2027727255);
                    boolean zD4 = interfaceC22053ub1.D(c12767fA0);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD4 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new SA2() { // from class: ir.nasim.QL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.D(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB5);
                    }
                    SA2 sa25 = (SA2) objB5;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(2027735385);
                    boolean zD5 = interfaceC22053ub1.D(c12767fA0);
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD5 || objB6 == InterfaceC22053ub1.a.a()) {
                        objB6 = new SA2() { // from class: ir.nasim.RL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.v(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC18693p53.h(abstractC7031Pz0F, aVarE, interfaceC8534Wj4H, sa22, zY, sa23, zX, context, ua2, sa24, sa25, zP, (SA2) objB6, zM, interfaceC22053ub1, AbstractC7031Pz0.a, 0);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    interfaceC22053ub1.W(-1564165446);
                    boolean zX2 = FL2.h(interfaceC9664aL62).x();
                    interfaceC22053ub1.W(2027759056);
                    boolean zD6 = interfaceC22053ub1.D(c12767fA0);
                    Object objB7 = interfaceC22053ub1.B();
                    if (zD6 || objB7 == InterfaceC22053ub1.a.a()) {
                        objB7 = new SA2() { // from class: ir.nasim.SL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.w(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB7);
                    }
                    SA2 sa26 = (SA2) objB7;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(2027761779);
                    boolean zD7 = interfaceC22053ub1.D(c12767fA0);
                    Object objB8 = interfaceC22053ub1.B();
                    if (zD7 || objB8 == InterfaceC22053ub1.a.a()) {
                        objB8 = new SA2() { // from class: ir.nasim.TL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.x(c12767fA0);
                            }
                        };
                        interfaceC22053ub1.s(objB8);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC8103Un5.e(zX2, sa26, (SA2) objB8, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB72 = C19938rB7.a;
                    break;
                case 9:
                    interfaceC22053ub1.W(-1563737181);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB73 = C19938rB7.a;
                    break;
                case 10:
                case 11:
                case 12:
                case 13:
                    interfaceC22053ub1.W(-1563372280);
                    interfaceC22053ub1.W(2027781686);
                    Object objB9 = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
                    if (objB9 == aVar2.a()) {
                        objB9 = new SA2() { // from class: ir.nasim.UL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.y();
                            }
                        };
                        interfaceC22053ub1.s(objB9);
                    }
                    SA2 sa27 = (SA2) objB9;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(2027786652);
                    Object objB10 = interfaceC22053ub1.B();
                    if (objB10 == aVar2.a()) {
                        objB10 = new SA2() { // from class: ir.nasim.VL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FL2.d.z();
                            }
                        };
                        interfaceC22053ub1.s(objB10);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC5245In0.d(sa27, (SA2) objB10, interfaceC22053ub1, 54);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB74 = C19938rB7.a;
                    break;
                case 14:
                case 15:
                    interfaceC22053ub1.W(-1562814466);
                    AbstractC15166j72.b(interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                    C19938rB7 c19938rB75 = C19938rB7.a;
                    break;
                default:
                    interfaceC22053ub1.W(2027684693);
                    interfaceC22053ub1.Q();
                    throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            p((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ double c;
            /* synthetic */ Object d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC4616Fw7.a(AbstractC6392Nk0.b(this.c), ((C17448mz0) this.d).e());
            }

            public final Object n(double d, C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = d;
                aVar.d = c17448mz0;
                return aVar.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return n(((Number) obj).doubleValue(), (C17448mz0) obj2, (InterfaceC20295rm1) obj3);
            }
        }

        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC14415hs5 a;

            b(InterfaceC14415hs5 interfaceC14415hs5) {
                this.a = interfaceC14415hs5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setValue(str);
                return C19938rB7.a;
            }
        }

        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.FL2$f$c$a$a, reason: collision with other inner class name */
                public static final class C0364a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0364a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.FL2.f.c.a.C0364a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.FL2$f$c$a$a r0 = (ir.nasim.FL2.f.c.a.C0364a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.FL2$f$c$a$a r0 = new ir.nasim.FL2$f$c$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L55
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        ir.nasim.XV4 r7 = (ir.nasim.XV4) r7
                        java.lang.Object r2 = r7.e()
                        java.lang.Number r2 = (java.lang.Number) r2
                        double r4 = r2.doubleValue()
                        java.lang.Object r7 = r7.f()
                        ir.nasim.mz0$a r7 = (ir.nasim.C17448mz0.a) r7
                        java.lang.String r7 = ir.nasim.AbstractC19576qb1.e(r4, r7)
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L55
                        return r1
                    L55:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FL2.f.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C17448mz0.a y(C17448mz0 c17448mz0) {
            return c17448mz0.e();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                c cVar = new c(AbstractC6459Nq2.S(C18039nz0.a.a(), AbstractC6459Nq2.x(this.d, new UA2() { // from class: ir.nasim.WL2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return FL2.f.y((C17448mz0) obj2);
                    }
                }), new a(null)));
                b bVar = new b(interfaceC14415hs5);
                this.b = 1;
                if (cVar.b(bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC14415hs5 a;

            a(InterfaceC14415hs5 interfaceC14415hs5) {
                this.a = interfaceC14415hs5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setValue(c17448mz0);
                return C19938rB7.a;
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.FL2$g$b$a$a, reason: collision with other inner class name */
                public static final class C0365a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0365a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.FL2.g.b.a.C0365a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.FL2$g$b$a$a r0 = (ir.nasim.FL2.g.b.a.C0365a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.FL2$g$b$a$a r0 = new ir.nasim.FL2$g$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                        ir.nasim.mz0$a r2 = r2.e()
                        ir.nasim.mz0$a r4 = ir.nasim.C17448mz0.a.n
                        if (r2 == r4) goto L4a
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L4a
                        return r1
                    L4a:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FL2.g.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(this.d, interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                b bVar = new b(this.d);
                a aVar = new a(interfaceC14415hs5);
                this.b = 1;
                if (bVar.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x08d8  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [ir.nasim.ED1, ir.nasim.SA2, ir.nasim.zm6] */
    /* JADX WARN: Type inference failed for: r8v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(final ir.nasim.InterfaceC10258bL6 r55, final ir.nasim.UA2 r56, final ir.nasim.UA2 r57, final ir.nasim.C12767fA0 r58, final ir.nasim.UA2 r59, final ir.nasim.SA2 r60, final ir.nasim.InterfaceC14603iB2 r61, final ir.nasim.SA2 r62, final ir.nasim.SA2 r63, final ir.nasim.SA2 r64, ir.nasim.InterfaceC22053ub1 r65, final int r66) {
        /*
            Method dump skipped, instructions count: 2368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FL2.g(ir.nasim.bL6, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.fA0, ir.nasim.UA2, ir.nasim.SA2, ir.nasim.iB2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9215Yz0 h(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C9215Yz0) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List i(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C18519on6 k(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C18519on6) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).intValue();
    }

    private static final CK5 m(InterfaceC9664aL6 interfaceC9664aL6) {
        return (CK5) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(C12767fA0 c12767fA0, InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        AbstractC13042fc3.i(interfaceC9664aL6, "$uiState$delegate");
        if (v(interfaceC9664aL6).e() == C17448mz0.a.g) {
            c12767fA0.N2();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float o(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((C17784nZ1) interfaceC9102Ym4.getValue()).v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(InterfaceC9102Ym4 interfaceC9102Ym4, float f2) {
        interfaceC9102Ym4.setValue(C17784nZ1.j(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$chunkedItems$delegate");
        return i(interfaceC9664aL6).size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(C12767fA0 c12767fA0) {
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        c12767fA0.d2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(C12767fA0 c12767fA0) {
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        c12767fA0.v2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(C12767fA0 c12767fA0) {
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        c12767fA0.t2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, UA2 ua22, C12767fA0 c12767fA0, UA2 ua23, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22, SA2 sa23, SA2 sa24, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$callState");
        AbstractC13042fc3.i(ua2, "$openSpeakerBottomSheet");
        AbstractC13042fc3.i(ua22, "$showCallErrorsSnackbar");
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        AbstractC13042fc3.i(ua23, "$openUserChat");
        AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
        AbstractC13042fc3.i(interfaceC14603iB2, "$showKickUserDialog");
        AbstractC13042fc3.i(sa22, "$onCopyCallLink");
        AbstractC13042fc3.i(sa23, "$onShareCallLink");
        AbstractC13042fc3.i(sa24, "$openMoreOptionBottomSheet");
        g(interfaceC10258bL6, ua2, ua22, c12767fA0, ua23, sa2, interfaceC14603iB2, sa22, sa23, sa24, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17448mz0 v(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C17448mz0) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String w(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ UA2 f;

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.setValue((C18519on6) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C18519on6 c18519on6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c18519on6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ UA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC9102Ym4;
                this.f = ua2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    EN4 en4 = (EN4) this.d;
                    InterfaceC4557Fq2 interfaceC4557Fq2P = AbstractC6459Nq2.p(en4.e(), en4.a(), new a(this.e, this.f, en4, null));
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2P, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(interfaceC20295rm1, this.e, this.f);
                cVar.c = interfaceC4806Gq2;
                cVar.d = obj;
                return cVar.invokeSuspend(C19938rB7.a);
            }
        }

        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.FL2$e$d$a$a, reason: collision with other inner class name */
                public static final class C0363a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0363a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.FL2.e.d.a.C0363a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.FL2$e$d$a$a r0 = (ir.nasim.FL2.e.d.a.C0363a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.FL2$e$d$a$a r0 = new ir.nasim.FL2$e$d$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                        ir.nasim.EN4 r5 = r5.j()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FL2.e.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
            this.e = interfaceC9102Ym4;
            this.f = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.d, this.e, this.f, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2S0 = AbstractC6459Nq2.s0(AbstractC6459Nq2.F(AbstractC6459Nq2.v(new d(this.d))), new c(null, this.e, this.f));
                b bVar = new b(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2S0, bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ UA2 f;
            final /* synthetic */ EN4 g;

            /* renamed from: ir.nasim.FL2$e$a$a, reason: collision with other inner class name */
            static final class C0362a implements SA2 {
                final /* synthetic */ UA2 a;
                final /* synthetic */ EnumC25128zm6 b;

                C0362a(UA2 ua2, EnumC25128zm6 enumC25128zm6) {
                    this.a = ua2;
                    this.b = enumC25128zm6;
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

            static final class b implements SA2 {
                final /* synthetic */ EnumC25128zm6 a;
                final /* synthetic */ EN4 b;
                final /* synthetic */ SortedSet c;

                b(EnumC25128zm6 enumC25128zm6, EN4 en4, SortedSet sortedSet) {
                    this.a = enumC25128zm6;
                    this.b = en4;
                    this.c = sortedSet;
                }

                public final void a() {
                    EnumC25128zm6 enumC25128zm6 = this.a;
                    EnumC25128zm6 enumC25128zm62 = EnumC25128zm6.b;
                    if (enumC25128zm6 != enumC25128zm62) {
                        this.b.b(enumC25128zm62);
                        return;
                    }
                    EN4 en4 = this.b;
                    Object objLast = this.c.last();
                    AbstractC13042fc3.h(objLast, "last(...)");
                    en4.b((EnumC25128zm6) objLast);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2, EN4 en4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC9102Ym4;
                this.f = ua2;
                this.g = en4;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                EnumC25128zm6 enumC25128zm6 = (EnumC25128zm6) this.c;
                SortedSet sortedSet = (SortedSet) this.d;
                C12889fL5 c12889fL5 = new C12889fL5();
                c12889fL5.a = c.a;
                FL2.j(this.e, sortedSet.contains(EnumC25128zm6.d));
                if (enumC25128zm6 != null) {
                    InterfaceC9102Ym4 interfaceC9102Ym4 = this.e;
                    UA2 ua2 = this.f;
                    EN4 en4 = this.g;
                    if (FL2.x(interfaceC9102Ym4)) {
                        c12889fL5.a = new C0362a(ua2, enumC25128zm6);
                    } else {
                        c12889fL5.a = new b(enumC25128zm6, en4, sortedSet);
                    }
                }
                return new C18519on6(enumC25128zm6, (SA2) c12889fL5.a);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(EnumC25128zm6 enumC25128zm6, SortedSet sortedSet, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.e, this.f, this.g, interfaceC20295rm1);
                aVar.c = enumC25128zm6;
                aVar.d = sortedSet;
                return aVar.invokeSuspend(C19938rB7.a);
            }

            static final class c implements SA2 {
                public static final c a = new c();

                c() {
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }

                public final void a() {
                }
            }
        }
    }
}
