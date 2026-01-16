package ir.nasim;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC11557dC6;
import ir.nasim.LP;

/* renamed from: ir.nasim.dC6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC11557dC6 {

    /* renamed from: ir.nasim.dC6$a */
    static final class a implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC3630Br2 a;

        a(InterfaceC3630Br2 interfaceC3630Br2) {
            this.a = interfaceC3630Br2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(InterfaceC3630Br2 interfaceC3630Br2, ZG4 zg4) {
            AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
            InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final InterfaceC3630Br2 interfaceC3630Br2 = this.a;
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.cC6
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC11557dC6.a.b(interfaceC3630Br2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dC6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19391qG6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C19391qG6 c19391qG6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19391qG6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19391qG6 c19391qG6 = this.c;
                this.b = 1;
                if (C19391qG6.f(c19391qG6, "", null, false, null, this, 14, null) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dC6$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ LP a;

        c(LP lp) {
            this.a = lp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC15254jG6 interfaceC15254jG6, boolean z) {
            AbstractC13042fc3.i(interfaceC15254jG6, "$snackBar");
            interfaceC15254jG6.dismiss();
            return C19938rB7.a;
        }

        public final void b(final InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            LP lp = this.a;
            if (lp instanceof LP.a) {
                Integer numD = ((LP.a) lp).d();
                interfaceC22053ub1.W(-789375302);
                String strC = numD == null ? null : UY6.c(numD.intValue(), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                if (strC == null) {
                    strC = ((LP.a) this.a).e();
                }
                String str = strC;
                interfaceC22053ub1.W(-789371819);
                boolean z = (i & 14) == 4;
                Object objB = interfaceC22053ub1.B();
                if (z || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.eC6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC11557dC6.c.c(interfaceC15254jG6, ((Boolean) obj).booleanValue());
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC10984cY.c(str, null, null, 0, (UA2) objB, interfaceC22053ub1, 0, 14);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(ir.nasim.AbstractC6747Ou5 r49, ir.nasim.SA2 r50, java.lang.String r51, ir.nasim.UA2 r52, boolean r53, ir.nasim.LP r54, ir.nasim.UA2 r55, ir.nasim.InterfaceC22053ub1 r56, final int r57, final int r58) {
        /*
            Method dump skipped, instructions count: 1817
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11557dC6.i(ir.nasim.Ou5, ir.nasim.SA2, java.lang.String, ir.nasim.UA2, boolean, ir.nasim.LP, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(SA2 sa2) {
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(InterfaceC20600sH6 interfaceC20600sH6, InterfaceC10566bp3 interfaceC10566bp3) {
        AbstractC13042fc3.i(interfaceC10566bp3, "$this$KeyboardActions");
        if (interfaceC20600sH6 != null) {
            interfaceC20600sH6.b();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(String str, UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, C19391qG6 c19391qG6) {
        AbstractC13042fc3.i(interfaceC20315ro1, "$cScope");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$emptyCode$delegate");
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        if (str.length() == 0) {
            r(interfaceC9102Ym4, true);
        } else {
            ua2.invoke(AbstractC20762sZ6.n1(str).toString());
        }
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(c19391qG6, null), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(AbstractC6747Ou5 abstractC6747Ou5, SA2 sa2, String str, UA2 ua2, boolean z, LP lp, UA2 ua22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        i(abstractC6747Ou5, sa2, str, ua2, z, lp, ua22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    private static final boolean q(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void r(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    public static final void s(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1492049255);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            i(null, null, null, null, false, null, null, interfaceC22053ub1J, 0, 127);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.UB6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC11557dC6.t(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        s(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
