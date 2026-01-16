package ir.nasim;

import ir.nasim.AbstractC21430te5;

/* renamed from: ir.nasim.tm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC21579tm7 {

    /* renamed from: ir.nasim.tm7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ C9348Zn7 e;

        /* renamed from: ir.nasim.tm7$a$a, reason: collision with other inner class name */
        static final class C1601a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
            final /* synthetic */ C20892sm7 e;

            /* renamed from: ir.nasim.tm7$a$a$a, reason: collision with other inner class name */
            static final class C1602a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ AbstractC21430te5 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1602a(AbstractC21430te5 abstractC21430te5) {
                    super(1);
                    this.e = abstractC21430te5;
                }

                public final void a(AbstractC21430te5.a aVar) {
                    AbstractC21430te5.a.l(aVar, this.e, 0, 0, 0.0f, 4, null);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((AbstractC21430te5.a) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1601a(C20892sm7 c20892sm7) {
                super(3);
                this.e = c20892sm7;
            }

            public final InterfaceC11734dW3 a(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
                long jB = this.e.b();
                AbstractC21430te5 abstractC21430te5L0 = zv3.l0(C17833ne1.d(j, AbstractC23053wG5.m((int) (jB >> 32), C17833ne1.n(j), C17833ne1.l(j)), 0, AbstractC23053wG5.m((int) (jB & 4294967295L), C17833ne1.m(j), C17833ne1.k(j)), 0, 10, null));
                return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new C1602a(abstractC21430te5L0), 4, null);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return a((InterfaceC12377eW3) obj, (ZV3) obj2, ((C17833ne1) obj3).r());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C9348Zn7 c9348Zn7) {
            super(3);
            this.e = c9348Zn7;
        }

        private static final Object b(InterfaceC9664aL6 interfaceC9664aL6) {
            return interfaceC9664aL6.getValue();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v2 ??, still in use, count: 1, list:
              (r10v2 ?? I:java.lang.Object) from 0x00c4: INVOKE (r13v0 ?? I:ir.nasim.ub1), (r10v2 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:197)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        public final androidx.compose.ui.e a(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v2 ??, still in use, count: 1, list:
              (r10v2 ?? I:java.lang.Object) from 0x00c4: INVOKE (r13v0 ?? I:ir.nasim.ub1), (r10v2 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:197)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r12v0 ??
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
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, C9348Zn7 c9348Zn7) {
        return androidx.compose.ui.c.c(eVar, null, new a(c9348Zn7), 1, null);
    }
}
