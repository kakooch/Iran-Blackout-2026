package ir.nasim;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC14816iX4;
import ir.nasim.AbstractC15996kX4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.iX4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC14816iX4 {

    /* renamed from: ir.nasim.iX4$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ C12767fA0 e;
        final /* synthetic */ InterfaceC9664aL6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4, C12767fA0 c12767fA0, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9664aL6;
            this.d = interfaceC9102Ym4;
            this.e = c12767fA0;
            this.f = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (AbstractC14816iX4.A(this.c) != null) {
                InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
                C12767fA0 c12767fA0 = this.e;
                InterfaceC9664aL6 interfaceC9664aL6 = this.c;
                InterfaceC9664aL6 interfaceC9664aL62 = this.f;
                C17637nI7 c17637nI7A = AbstractC14816iX4.A(interfaceC9664aL6);
                AbstractC13042fc3.f(c17637nI7A);
                interfaceC9102Ym4.setValue(c12767fA0.N1(c17637nI7A, (C9770aX4) interfaceC9102Ym4.getValue(), AbstractC14816iX4.i(interfaceC9664aL62)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iX4$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ InterfaceC9102Ym4 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        b(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44) {
            this.a = interfaceC9102Ym4;
            this.b = interfaceC9102Ym42;
            this.c = interfaceC9102Ym43;
            this.d = interfaceC9102Ym44;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44, ZG4 zg4, ZG4 zg42, float f, float f2) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$scale$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym42, "$boxSize$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym43, "$parentSize$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym44, "$offset$delegate");
            AbstractC14816iX4.q(interfaceC9102Ym4, AbstractC23053wG5.l(AbstractC14816iX4.p(interfaceC9102Ym4) * f, 1.0f, 5.0f));
            float fMax = Math.max(0.0f, ((((int) (AbstractC14816iX4.j(interfaceC9102Ym42) >> 32)) * AbstractC14816iX4.p(interfaceC9102Ym4)) - ((int) (AbstractC14816iX4.t(interfaceC9102Ym43) >> 32))) / 2.0f);
            float fMax2 = Math.max(0.0f, ((((int) (AbstractC14816iX4.j(interfaceC9102Ym42) & 4294967295L)) * AbstractC14816iX4.p(interfaceC9102Ym4)) - ((int) (AbstractC14816iX4.t(interfaceC9102Ym43) & 4294967295L))) / 2.0f);
            float fL = AbstractC23053wG5.l(Float.intBitsToFloat((int) (AbstractC14816iX4.r(interfaceC9102Ym44) >> 32)) + Float.intBitsToFloat((int) (zg42.t() >> 32)), -fMax, fMax);
            float fL2 = AbstractC23053wG5.l(Float.intBitsToFloat((int) (AbstractC14816iX4.r(interfaceC9102Ym44) & 4294967295L)) + Float.intBitsToFloat((int) (zg42.t() & 4294967295L)), -fMax2, fMax2);
            AbstractC14816iX4.s(interfaceC9102Ym44, ZG4.e((Float.floatToRawIntBits(fL) << 32) | (Float.floatToRawIntBits(fL2) & 4294967295L)));
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.b;
            final InterfaceC9102Ym4 interfaceC9102Ym43 = this.c;
            final InterfaceC9102Ym4 interfaceC9102Ym44 = this.d;
            Object objH = AbstractC12627ev7.h(interfaceC9049Yg5, false, new InterfaceC16978mB2() { // from class: ir.nasim.jX4
                @Override // ir.nasim.InterfaceC16978mB2
                public final Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    return AbstractC14816iX4.b.b(interfaceC9102Ym4, interfaceC9102Ym42, interfaceC9102Ym43, interfaceC9102Ym44, (ZG4) obj, (ZG4) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue());
                }
            }, interfaceC20295rm1, 1, null);
            return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.iX4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12767fA0 d;
        final /* synthetic */ String e;
        final /* synthetic */ InterfaceC9664aL6 f;

        /* renamed from: ir.nasim.iX4$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
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
                this.d.setValue((C17637nI7) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17637nI7 c17637nI7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c17637nI7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C12767fA0 c12767fA0, String str, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12767fA0;
            this.e = str;
            this.f = interfaceC9664aL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, this.f, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws NumberFormatException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                long j = Long.parseLong((String) AbstractC15401jX0.q0(AbstractC20762sZ6.N0(AbstractC14816iX4.i(this.f).j(), new String[]{"_"}, false, 0, 6, null)));
                if (j < 0) {
                    interfaceC14415hs5.setValue(this.d.D1(j, AbstractC14816iX4.i(this.f).g(), this.e));
                } else {
                    InterfaceC4557Fq2 interfaceC4557Fq2C2 = this.d.c2(j);
                    a aVar = new a(interfaceC14415hs5, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2C2, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17637nI7 A(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C17637nI7) interfaceC9664aL6.getValue();
    }

    private static final boolean B(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void C(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x087f  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0a0e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0a13  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0a16  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0a1b  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0aaa  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0b4d  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0c14  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0c28  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0c8e  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0cb3  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0cb6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final androidx.compose.ui.e r84, final ir.nasim.InterfaceC10258bL6 r85, final float r86, final ir.nasim.UA2 r87, final ir.nasim.UA2 r88, final ir.nasim.InterfaceC14603iB2 r89, final ir.nasim.C12767fA0 r90, final java.lang.String r91, final boolean r92, ir.nasim.InterfaceC22053ub1 r93, final int r94) {
        /*
            Method dump skipped, instructions count: 3458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14816iX4.h(androidx.compose.ui.e, ir.nasim.bL6, float, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.iB2, ir.nasim.fA0, java.lang.String, boolean, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M26 i(InterfaceC9664aL6 interfaceC9664aL6) {
        return (M26) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((C4414Fa3) interfaceC9102Ym4.getValue()).j();
    }

    private static final void k(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
        interfaceC9102Ym4.setValue(C4414Fa3.b(j));
    }

    private static final C23677xK3 l(LK3 lk3) {
        return (C23677xK3) lk3.getValue();
    }

    private static final C23677xK3 m(LK3 lk3) {
        return (C23677xK3) lk3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$expanded$delegate");
        C(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6, C12767fA0 c12767fA0, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC9102Ym4 interfaceC9102Ym42, AbstractC15996kX4 abstractC15996kX4) {
        String strB;
        AbstractC13042fc3.i(ua2, "$openUserChat");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$participantItemDataState");
        AbstractC13042fc3.i(interfaceC9664aL6, "$participantState$delegate");
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        AbstractC13042fc3.i(interfaceC14603iB2, "$showKickUserDialog");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$expanded$delegate");
        AbstractC13042fc3.i(abstractC15996kX4, "it");
        String strE = i(interfaceC9664aL6).e();
        if (strE == null) {
            return C19938rB7.a;
        }
        if (AbstractC13042fc3.d(abstractC15996kX4, AbstractC15996kX4.a.c)) {
            String strL = i(interfaceC9664aL6).l();
            if (strL != null) {
                c12767fA0.e2(strL, strE, true);
            }
        } else if (AbstractC13042fc3.d(abstractC15996kX4, AbstractC15996kX4.c.c)) {
            String strC = i(interfaceC9664aL6).c();
            if (strC != null) {
                c12767fA0.e2(strC, strE, false);
            }
        } else if (AbstractC13042fc3.d(abstractC15996kX4, AbstractC15996kX4.d.c)) {
            ua2.invoke(Integer.valueOf(Integer.parseInt((String) AbstractC15401jX0.q0(AbstractC20762sZ6.N0(i(interfaceC9664aL6).j(), new String[]{"_"}, false, 0, 6, null)))));
        } else {
            if (!AbstractC13042fc3.d(abstractC15996kX4, AbstractC15996kX4.b.c)) {
                throw new NoWhenBranchMatchedException();
            }
            C9770aX4 c9770aX4 = (C9770aX4) interfaceC9102Ym4.getValue();
            if (c9770aX4 != null && (strB = c9770aX4.b()) != null) {
                interfaceC14603iB2.invoke(strE, strB);
            }
        }
        C(interfaceC9102Ym42, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float p(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(InterfaceC9102Ym4 interfaceC9102Ym4, float f) {
        interfaceC9102Ym4.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long r(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((ZG4) interfaceC9102Ym4.getValue()).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
        interfaceC9102Ym4.setValue(ZG4.d(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long t(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((C4414Fa3) interfaceC9102Ym4.getValue()).j();
    }

    private static final void u(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
        interfaceC9102Ym4.setValue(C4414Fa3.b(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$parentSize$delegate");
        AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
        u(interfaceC9102Ym4, interfaceC11379cu3.a());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$boxSize$delegate");
        AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
        k(interfaceC9102Ym4, interfaceC11379cu3.a());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(ua2, "$expandScreenClicked");
        AbstractC13042fc3.i(interfaceC9664aL6, "$participantState$delegate");
        ua2.invoke(i(interfaceC9664aL6).j());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$expanded$delegate");
        C(interfaceC9102Ym4, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(androidx.compose.ui.e eVar, InterfaceC10258bL6 interfaceC10258bL6, float f, UA2 ua2, UA2 ua22, InterfaceC14603iB2 interfaceC14603iB2, C12767fA0 c12767fA0, String str, boolean z, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(interfaceC10258bL6, "$participantFlow");
        AbstractC13042fc3.i(ua2, "$expandScreenClicked");
        AbstractC13042fc3.i(ua22, "$openUserChat");
        AbstractC13042fc3.i(interfaceC14603iB2, "$showKickUserDialog");
        AbstractC13042fc3.i(c12767fA0, "$viewModel");
        AbstractC13042fc3.i(str, "$guestNamePlaceHolder");
        h(eVar, interfaceC10258bL6, f, ua2, ua22, interfaceC14603iB2, c12767fA0, str, z, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
