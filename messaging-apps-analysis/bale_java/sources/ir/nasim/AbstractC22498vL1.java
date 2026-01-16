package ir.nasim;

import android.graphics.drawable.Drawable;
import ir.nasim.AbstractC24274yL1;

/* renamed from: ir.nasim.vL1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22498vL1 {
    private static final float a = C17784nZ1.q(24);
    private static final float b = C17784nZ1.q(20);
    private static final float c = C17784nZ1.q(12);
    private static final float d = C17784nZ1.q(16);

    /* renamed from: ir.nasim.vL1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AbstractC24274yL1 d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        /* renamed from: ir.nasim.vL1$a$a, reason: collision with other inner class name */
        static final class C1663a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ AbstractC24274yL1 c;
            final /* synthetic */ InterfaceC9102Ym4 d;
            final /* synthetic */ InterfaceC9102Ym4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1663a(AbstractC24274yL1 abstractC24274yL1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = abstractC24274yL1;
                this.d = interfaceC9102Ym4;
                this.e = interfaceC9102Ym42;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1663a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    if (AbstractC22498vL1.q(this.d)) {
                        AbstractC22498vL1.r(this.d, false);
                    } else {
                        this.b = 1;
                        if (HG1.b(1500L, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                AbstractC22498vL1.p(this.e, (AbstractC24274yL1.b.C1786b) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1663a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC24274yL1 abstractC24274yL1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = abstractC24274yL1;
            this.e = interfaceC9102Ym4;
            this.f = interfaceC9102Ym42;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new C1663a(this.d, this.e, this.f, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vL1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        /* renamed from: ir.nasim.vL1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ AbstractC24274yL1.b.C1786b d;
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ InterfaceC9102Ym4 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC24274yL1.b.C1786b c1786b, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c1786b;
                this.e = interfaceC9102Ym4;
                this.f = interfaceC9102Ym42;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, this.e, this.f, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r5.c
                    r2 = 0
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L27
                    if (r1 == r4) goto L1f
                    if (r1 != r3) goto L17
                    java.lang.Object r0 = r5.b
                    ir.nasim.Ym4 r0 = (ir.nasim.InterfaceC9102Ym4) r0
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L65
                L17:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1f:
                    java.lang.Object r1 = r5.b
                    ir.nasim.Ym4 r1 = (ir.nasim.InterfaceC9102Ym4) r1
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L43
                L27:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Ym4 r1 = r5.e
                    ir.nasim.yL1$b$b r6 = r5.d
                    ir.nasim.mP1 r6 = r6.c()
                    ir.nasim.zG1 r6 = r6.c()
                    if (r6 == 0) goto L46
                    r5.b = r1
                    r5.c = r4
                    java.lang.Object r6 = r6.y(r5)
                    if (r6 != r0) goto L43
                    return r0
                L43:
                    android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6
                    goto L47
                L46:
                    r6 = r2
                L47:
                    ir.nasim.AbstractC22498vL1.E(r1, r6)
                    ir.nasim.Ym4 r6 = r5.f
                    ir.nasim.yL1$b$b r1 = r5.d
                    ir.nasim.mP1 r1 = r1.c()
                    ir.nasim.zG1 r1 = r1.f()
                    if (r1 == 0) goto L69
                    r5.b = r6
                    r5.c = r3
                    java.lang.Object r1 = r1.y(r5)
                    if (r1 != r0) goto L63
                    return r0
                L63:
                    r0 = r6
                    r6 = r1
                L65:
                    r2 = r6
                    ir.nasim.bA3 r2 = (ir.nasim.InterfaceC10156bA3) r2
                    r6 = r0
                L69:
                    ir.nasim.AbstractC22498vL1.z(r6, r2)
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22498vL1.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC9102Ym4;
            this.e = interfaceC9102Ym42;
            this.f = interfaceC9102Ym43;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
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
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC24274yL1.b.C1786b c1786bN = AbstractC22498vL1.n(this.d);
            if (c1786bN != null) {
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c1786bN, this.e, this.f, null), 3, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(final ir.nasim.AbstractC24274yL1 r22, final ir.nasim.EnumC15912kO1 r23, final ir.nasim.SA2 r24, ir.nasim.InterfaceC22053ub1 r25, final int r26) {
        /*
            Method dump skipped, instructions count: 816
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22498vL1.g(ir.nasim.yL1, ir.nasim.kO1, ir.nasim.SA2, ir.nasim.ub1, int):void");
    }

    private static final InterfaceC10156bA3 h(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (InterfaceC10156bA3) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC10156bA3 interfaceC10156bA3) {
        interfaceC9102Ym4.setValue(interfaceC10156bA3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j() {
        return C8386Vt0.Q5();
    }

    private static final boolean k(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l() {
        return C8386Vt0.N5();
    }

    private static final boolean m(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC24274yL1.b.C1786b n(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (AbstractC24274yL1.b.C1786b) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(AbstractC24274yL1 abstractC24274yL1, EnumC15912kO1 enumC15912kO1, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(abstractC24274yL1, "$adState");
        AbstractC13042fc3.i(enumC15912kO1, "$dialogListMode");
        AbstractC13042fc3.i(sa2, "$onClickAd");
        g(abstractC24274yL1, enumC15912kO1, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(InterfaceC9102Ym4 interfaceC9102Ym4, AbstractC24274yL1.b.C1786b c1786b) {
        interfaceC9102Ym4.setValue(c1786b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    private static final Drawable s(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (Drawable) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(InterfaceC9102Ym4 interfaceC9102Ym4, Drawable drawable) {
        interfaceC9102Ym4.setValue(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0770  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0825  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0946  */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void u(final ir.nasim.EV4 r85, final java.lang.String r86, final ir.nasim.C12700f33 r87, final java.lang.String r88, final java.lang.String r89, final ir.nasim.SA2 r90, boolean r91, boolean r92, boolean r93, ir.nasim.InterfaceC22053ub1 r94, final int r95, final int r96) {
        /*
            Method dump skipped, instructions count: 2400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22498vL1.u(ir.nasim.EV4, java.lang.String, ir.nasim.f33, java.lang.String, java.lang.String, ir.nasim.SA2, boolean, boolean, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23546x62 v(String str) {
        AbstractC13042fc3.i(str, "it");
        return AbstractC8970Ya1.b(str, 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(EV4 ev4, String str, C12700f33 c12700f33, String str2, String str3, SA2 sa2, boolean z, boolean z2, boolean z3, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ev4, "$adImage");
        AbstractC13042fc3.i(str, "$adTitle");
        AbstractC13042fc3.i(str2, "$adDescription");
        AbstractC13042fc3.i(str3, "$adCallToActionText");
        AbstractC13042fc3.i(sa2, "$onClick");
        u(ev4, str, c12700f33, str2, str3, sa2, z, z2, z3, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void x(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(119177224);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, P41.a.a(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.pL1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22498vL1.y(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        x(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
