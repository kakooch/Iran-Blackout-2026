package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC10271bN1;
import java.util.List;

/* renamed from: ir.nasim.bN1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10271bN1 {

    /* renamed from: ir.nasim.bN1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ List a;

        /* renamed from: ir.nasim.bN1$a$a, reason: collision with other inner class name */
        static final class C0903a implements UA2 {
            public static final C0903a a = new C0903a();

            C0903a() {
            }

            public final void a(RM1 rm1) {
                AbstractC13042fc3.i(rm1, "it");
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((RM1) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.bN1$a$b */
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

        /* renamed from: ir.nasim.bN1$a$c */
        public static final class c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(UA2 ua2, List list) {
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

        /* renamed from: ir.nasim.bN1$a$d */
        public static final class d extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(List list) {
                super(4);
                this.e = list;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) throws Resources.NotFoundException {
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
                XV4 xv4 = (XV4) this.e.get(i);
                interfaceC22053ub1.W(1814982062);
                RM1 rm1 = (RM1) xv4.f();
                EV4 ev4C = FV4.c(AbstractC24188yB5.avatar_placeholder, interfaceC22053ub1, 0);
                interfaceC22053ub1.W(751289863);
                Object objB = interfaceC22053ub1.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = C0903a.a;
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC10271bN1.i(rm1, null, ev4C, 0.0f, 0.0f, 0.0f, null, (UA2) objB, interfaceC22053ub1, 12582912, 122);
                interfaceC22053ub1.Q();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) throws Resources.NotFoundException {
                a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        a(List list) {
            this.a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(list, "$items");
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            interfaceC15069ix3.a(list.size(), null, new c(b.e, list), AbstractC19242q11.c(-632812321, true, new d(list)));
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.ui.e.a, G10.a.a(interfaceC22053ub1, G10.b).r(), null, 2, null);
            interfaceC22053ub1.W(1417153821);
            boolean zD = interfaceC22053ub1.D(this.a);
            final List list = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.aN1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC10271bN1.a.c(list, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC12623ev3.b(eVarD, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 510);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0782  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:261:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129  */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v5, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final ir.nasim.RM1 r84, androidx.compose.ui.e r85, ir.nasim.EV4 r86, float r87, float r88, float r89, ir.nasim.InterfaceC14603iB2 r90, ir.nasim.UA2 r91, ir.nasim.InterfaceC22053ub1 r92, final int r93, final int r94) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1963
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10271bN1.i(ir.nasim.RM1, androidx.compose.ui.e, ir.nasim.EV4, float, float, float, ir.nasim.iB2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(RM1 rm1) {
        AbstractC13042fc3.i(rm1, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(UA2 ua2, RM1 rm1) {
        AbstractC13042fc3.i(rm1, "$dialogFolderDTO");
        ua2.invoke(rm1);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(InterfaceC14603iB2 interfaceC14603iB2, RM1 rm1, boolean z) {
        AbstractC13042fc3.i(rm1, "$dialogFolderDTO");
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(rm1, Boolean.valueOf(z));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(RM1 rm1, androidx.compose.ui.e eVar, EV4 ev4, float f, float f2, float f3, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) throws Resources.NotFoundException {
        AbstractC13042fc3.i(rm1, "$dialogFolderDTO");
        i(rm1, eVar, ev4, f, f2, f3, interfaceC14603iB2, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(InterfaceC14603iB2 interfaceC14603iB2, RM1 rm1) {
        AbstractC13042fc3.i(rm1, "$dialogFolderDTO");
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(rm1, Boolean.valueOf(!rm1.j()));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(InterfaceC14603iB2 interfaceC14603iB2, RM1 rm1) {
        AbstractC13042fc3.i(rm1, "$dialogFolderDTO");
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(rm1, Boolean.valueOf(!rm1.j()));
        }
        return C19938rB7.a;
    }

    public static final void p(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1258807172);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC23384wp6 interfaceC23384wp6A = new C11358cs2().a();
            interfaceC22053ub1J.W(2118223116);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.SM1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(AbstractC10271bN1.q((XV4) obj));
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(292561988, true, new a(AbstractC11342cq6.K(AbstractC11342cq6.r(interfaceC23384wp6A, (UA2) objB))), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.TM1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10271bN1.r(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "it");
        return xv4.e() == EnumC12613eu3.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        p(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final String s() {
        String strD = PH3.d();
        if (AbstractC13042fc3.d(strD, EnumC9389Zs3.b.toString()) || AbstractC13042fc3.d(strD, EnumC9389Zs3.d.toString())) {
            return ", ";
        }
        AbstractC13042fc3.d(strD, EnumC9389Zs3.c.toString());
        return "، ";
    }
}
