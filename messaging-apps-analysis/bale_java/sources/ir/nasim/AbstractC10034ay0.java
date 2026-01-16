package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.NK3;
import kotlin.NoWhenBranchMatchedException;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.ay0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10034ay0 {

    /* renamed from: ir.nasim.ay0$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(656630148);
            A98 a98G = AbstractC21393ta8.g(C8062Uj0.a.g(interfaceC22053ub1, 6), AbstractC23236wa8.a.e());
            interfaceC22053ub1.Q();
            return a98G;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.ay0$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ C19391qG6 a;
        final /* synthetic */ InterfaceC9664aL6 b;
        final /* synthetic */ XV4 c;
        final /* synthetic */ InterfaceC14603iB2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ Context g;
        final /* synthetic */ LK3 h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ SA2 j;
        final /* synthetic */ SA2 k;
        final /* synthetic */ SA2 l;
        final /* synthetic */ SA2 m;

        /* renamed from: ir.nasim.ay0$b$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC18030ny0.values().length];
                try {
                    iArr[EnumC18030ny0.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC18030ny0.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC18030ny0.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        b(C19391qG6 c19391qG6, InterfaceC9664aL6 interfaceC9664aL6, XV4 xv4, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, UA2 ua2, Context context, LK3 lk3, UA2 ua22, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25) {
            this.a = c19391qG6;
            this.b = interfaceC9664aL6;
            this.c = xv4;
            this.d = interfaceC14603iB2;
            this.e = sa2;
            this.f = ua2;
            this.g = context;
            this.h = lk3;
            this.i = ua22;
            this.j = sa22;
            this.k = sa23;
            this.l = sa24;
            this.m = sa25;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onUnMuteVoicePressed");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onMuteVoicePressed");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$state");
            AbstractC13042fc3.i(ua2, "$onSwitchCameraPressed");
            if (!((C18621oy0) interfaceC9664aL6.getValue()).s()) {
                ua2.invoke(Boolean.valueOf(!((C18621oy0) interfaceC9664aL6.getValue()).t()));
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onUnMuteVideoPressed");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onMuteVideoPressed");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, UA2 ua2) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$state");
            AbstractC13042fc3.i(interfaceC14603iB2, "$onStartOutGoingCallPressed");
            AbstractC13042fc3.i(sa2, "$onAskToJoinCallPressed");
            AbstractC13042fc3.i(ua2, "$onJoinCallPressed");
            int i = a.a[((C18621oy0) interfaceC9664aL6.getValue()).f().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    interfaceC14603iB2.invoke(((C18621oy0) interfaceC9664aL6.getValue()).m(), Boolean.valueOf(!((C18621oy0) interfaceC9664aL6.getValue()).s()));
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (((C18621oy0) interfaceC9664aL6.getValue()).q()) {
                sa2.invoke();
            } else {
                ua2.invoke(((C18621oy0) interfaceC9664aL6.getValue()).c());
            }
            return C19938rB7.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:107:0x06fc  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x078d  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x081c  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x0894  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x08fc  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0bac  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void i(ir.nasim.ZY0 r76, ir.nasim.InterfaceC22053ub1 r77, int r78) {
            /*
                Method dump skipped, instructions count: 3067
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10034ay0.b.i(ir.nasim.ZY0, ir.nasim.ub1, int):void");
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            i((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ay0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ C19391qG6 d;
        final /* synthetic */ Context e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9664aL6 interfaceC9664aL6, C19391qG6 c19391qG6, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9664aL6;
            this.d = c19391qG6;
            this.e = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Integer numL = ((C18621oy0) this.c.getValue()).l();
                if (numL != null) {
                    C19391qG6 c19391qG6 = this.d;
                    String string = this.e.getString(numL.intValue());
                    AbstractC13042fc3.h(string, "getString(...)");
                    this.b = 1;
                    if (C19391qG6.f(c19391qG6, string, null, false, null, this, 14, null) == objE) {
                        return objE;
                    }
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final void c(final InterfaceC10258bL6 interfaceC10258bL6, final Context context, final SA2 sa2, final SA2 sa22, final SA2 sa23, final SA2 sa24, final SA2 sa25, final UA2 ua2, final UA2 ua22, final SA2 sa26, final InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        int i4;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC10258bL6, "uiState");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(sa22, "onMuteVoicePressed");
        AbstractC13042fc3.i(sa23, "onUnMuteVoicePressed");
        AbstractC13042fc3.i(sa24, "onMuteVideoPressed");
        AbstractC13042fc3.i(sa25, "onUnMuteVideoPressed");
        AbstractC13042fc3.i(ua2, "onSwitchCameraPressed");
        AbstractC13042fc3.i(ua22, "onJoinCallPressed");
        AbstractC13042fc3.i(sa26, "onAskToJoinCallPressed");
        AbstractC13042fc3.i(interfaceC14603iB2, "onStartOutGoingCallPressed");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-77661235);
        if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(context) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(sa23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(sa24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(sa25) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(ua22) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(sa26) ? 536870912 : 268435456;
        }
        int i5 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i5 & 306783379) == 306783378 && (i4 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            XV4 xv4 = new XV4(160, Integer.valueOf(Type.AVC));
            LK3 lk3R = WM5.r(NK3.b.a(NK3.b.b(AbstractC19954rD5.call_participant_animated_speaking)), null, null, null, null, null, interfaceC22053ub1J, 0, 62);
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i5 & 14, 7);
            interfaceC22053ub12 = interfaceC22053ub1J;
            interfaceC22053ub12.W(1067062069);
            Object objB = interfaceC22053ub12.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C19391qG6();
                interfaceC22053ub12.s(objB);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB;
            interfaceC22053ub12.Q();
            if (((C18621oy0) interfaceC9664aL6C.getValue()).n()) {
                ua22.invoke(((C18621oy0) interfaceC9664aL6C.getValue()).c());
                sa2.invoke();
            }
            long jR = G10.a.a(interfaceC22053ub12, G10.b).r();
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(true, null, interfaceC22053ub12, 6, 2);
            interfaceC22053ub12.W(1067068543);
            boolean z = (i5 & 896) == 256;
            Object objB2 = interfaceC22053ub12.B();
            if (z || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Yx0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10034ay0.e(sa2);
                    }
                };
                interfaceC22053ub12.s(objB2);
            }
            interfaceC22053ub12.Q();
            AbstractC9273Zf4.a((SA2) objB2, null, c19818qz6L, 0.0f, null, jR, 0L, 0.0f, 0L, null, a.a, null, AbstractC19242q11.e(1136293584, true, new b(c19391qG6, interfaceC9664aL6C, xv4, interfaceC14603iB2, sa26, ua22, context, lk3R, ua2, sa25, sa24, sa23, sa22), interfaceC22053ub12, 54), interfaceC22053ub12, 0, 384, 3034);
            Integer numL = ((C18621oy0) interfaceC9664aL6C.getValue()).l();
            interfaceC22053ub12.W(1067473771);
            boolean zV = interfaceC22053ub12.V(interfaceC9664aL6C) | interfaceC22053ub12.D(context);
            Object objB3 = interfaceC22053ub12.B();
            if (zV || objB3 == aVar.a()) {
                objB3 = new c(interfaceC9664aL6C, c19391qG6, context, null);
                interfaceC22053ub12.s(objB3);
            }
            interfaceC22053ub12.Q();
            AbstractC10721c52.e(numL, (InterfaceC14603iB2) objB3, interfaceC22053ub12, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Zx0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10034ay0.f(interfaceC10258bL6, context, sa2, sa22, sa23, sa24, sa25, ua2, ua22, sa26, interfaceC14603iB2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23677xK3 d(LK3 lk3) {
        return (C23677xK3) lk3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(InterfaceC10258bL6 interfaceC10258bL6, Context context, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, UA2 ua2, UA2 ua22, SA2 sa26, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$uiState");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(sa22, "$onMuteVoicePressed");
        AbstractC13042fc3.i(sa23, "$onUnMuteVoicePressed");
        AbstractC13042fc3.i(sa24, "$onMuteVideoPressed");
        AbstractC13042fc3.i(sa25, "$onUnMuteVideoPressed");
        AbstractC13042fc3.i(ua2, "$onSwitchCameraPressed");
        AbstractC13042fc3.i(ua22, "$onJoinCallPressed");
        AbstractC13042fc3.i(sa26, "$onAskToJoinCallPressed");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onStartOutGoingCallPressed");
        c(interfaceC10258bL6, context, sa2, sa22, sa23, sa24, sa25, ua2, ua22, sa26, interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2));
        return C19938rB7.a;
    }
}
