package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC24533ym5;
import ir.nasim.VT1;

/* renamed from: ir.nasim.ym5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC24533ym5 {

    /* renamed from: ir.nasim.ym5$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(835414675);
            A98 a98G = C8062Uj0.a.g(interfaceC22053ub1, 6);
            interfaceC22053ub1.Q();
            return a98G;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.ym5$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ VT1 a;
        final /* synthetic */ C6167Ml5 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ InterfaceC14603iB2 d;
        final /* synthetic */ C19818qz6 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ InterfaceC14603iB2 g;

        /* renamed from: ir.nasim.ym5$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19818qz6 c19818qz6 = this.c;
                    this.b = 1;
                    if (c19818qz6.j(this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(VT1 vt1, C6167Ml5 c6167Ml5, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, C19818qz6 c19818qz6, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB22) {
            this.a = vt1;
            this.b = c6167Ml5;
            this.c = sa2;
            this.d = interfaceC14603iB2;
            this.e = c19818qz6;
            this.f = sa22;
            this.g = interfaceC14603iB22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC9102Ym4 i() {
            return AbstractC13472gH6.d("", null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final SA2 sa2, final InterfaceC14603iB2 interfaceC14603iB2, final C6167Ml5 c6167Ml5, final VT1 vt1, final InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            AbstractC13042fc3.i(interfaceC14603iB2, "$purchasePackage");
            AbstractC13042fc3.i(c6167Ml5, "$pkg");
            AbstractC13042fc3.i(vt1, "$discountState");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$discount$delegate");
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.Dm5
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC24533ym5.b.n(c19818qz6, sa2, interfaceC14603iB2, c6167Ml5, vt1, interfaceC9102Ym4, (Throwable) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(C19818qz6 c19818qz6, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, C6167Ml5 c6167Ml5, VT1 vt1, InterfaceC9102Ym4 interfaceC9102Ym4, Throwable th) {
            AbstractC13042fc3.i(c19818qz6, "$sheetState");
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            AbstractC13042fc3.i(interfaceC14603iB2, "$purchasePackage");
            AbstractC13042fc3.i(c6167Ml5, "$pkg");
            AbstractC13042fc3.i(vt1, "$discountState");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$discount$delegate");
            if (!c19818qz6.k()) {
                sa2.invoke();
            }
            interfaceC14603iB2.invoke(Long.valueOf(c6167Ml5.f()), ((vt1 instanceof VT1.d) && (AbstractC20762sZ6.n0(o(interfaceC9102Ym4)) ^ true)) ? o(interfaceC9102Ym4) : null);
            return C19938rB7.a;
        }

        private static final String o(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (String) interfaceC9102Ym4.getValue();
        }

        private static final void p(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            interfaceC9102Ym4.setValue(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$discount$delegate");
            AbstractC13042fc3.i(str, "it");
            p(interfaceC9102Ym4, str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(InterfaceC14603iB2 interfaceC14603iB2, C6167Ml5 c6167Ml5, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$calculateDiscountedPrice");
            AbstractC13042fc3.i(c6167Ml5, "$pkg");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$discount$delegate");
            if (!AbstractC20762sZ6.n0(o(interfaceC9102Ym4))) {
                interfaceC14603iB2.invoke(o(interfaceC9102Ym4), Long.valueOf(c6167Ml5.f()));
            }
            return C19938rB7.a;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v20 ??, still in use, count: 1, list:
              (r0v20 ?? I:java.lang.Object) from 0x046b: INVOKE (r10v6 ?? I:ir.nasim.ub1), (r0v20 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:1132)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        public final void h(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v20 ??, still in use, count: 1, list:
              (r0v20 ?? I:java.lang.Object) from 0x046b: INVOKE (r10v6 ?? I:ir.nasim.ub1), (r0v20 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:1132)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r82v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            h((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final InterfaceC14603iB2 interfaceC14603iB2, final C6167Ml5 c6167Ml5, final VT1 vt1, final SA2 sa2, final SA2 sa22, final InterfaceC14603iB2 interfaceC14603iB22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC14603iB2, "purchasePackage");
        AbstractC13042fc3.i(c6167Ml5, "pkg");
        AbstractC13042fc3.i(vt1, "discountState");
        AbstractC13042fc3.i(sa2, "onQuestionClick");
        AbstractC13042fc3.i(sa22, "onDismissRequest");
        AbstractC13042fc3.i(interfaceC14603iB22, "calculateDiscountedPrice");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1366612906);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c6167Ml5) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(vt1) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 131072 : 65536;
        }
        int i3 = i2;
        if ((i3 & 74899) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(true, null, interfaceC22053ub1J, 6, 2);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9273Zf4.a(sa22, AbstractC22640va8.c(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null)), c19818qz6L, 0.0f, null, G10.a.a(interfaceC22053ub1J, G10.b).M(), 0L, 0.0f, 0L, S71.a.b(), a.a, null, AbstractC19242q11.e(437031367, true, new b(vt1, c6167Ml5, sa2, interfaceC14603iB22, c19818qz6L, sa22, interfaceC14603iB2), interfaceC22053ub1J, 54), interfaceC22053ub12, ((i3 >> 12) & 14) | 805306368, 384, 2520);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xm5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24533ym5.c(interfaceC14603iB2, c6167Ml5, vt1, sa2, sa22, interfaceC14603iB22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(InterfaceC14603iB2 interfaceC14603iB2, C6167Ml5 c6167Ml5, VT1 vt1, SA2 sa2, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$purchasePackage");
        AbstractC13042fc3.i(c6167Ml5, "$pkg");
        AbstractC13042fc3.i(vt1, "$discountState");
        AbstractC13042fc3.i(sa2, "$onQuestionClick");
        AbstractC13042fc3.i(sa22, "$onDismissRequest");
        AbstractC13042fc3.i(interfaceC14603iB22, "$calculateDiscountedPrice");
        b(interfaceC14603iB2, c6167Ml5, vt1, sa2, sa22, interfaceC14603iB22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
