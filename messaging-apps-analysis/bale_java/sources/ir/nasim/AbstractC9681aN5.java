package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.aN5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9681aN5 {
    private static final int a = 36;

    /* renamed from: ir.nasim.aN5$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC8230Vb6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC8230Vb6 interfaceC8230Vb6) {
            super(2);
            this.e = interfaceC8230Vb6;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9102Ym4 invoke(InterfaceC8730Xb6 interfaceC8730Xb6, InterfaceC9102Ym4 interfaceC9102Ym4) {
            if (!(interfaceC9102Ym4 instanceof YG6)) {
                throw new IllegalArgumentException("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()".toString());
            }
            Object objA = this.e.a(interfaceC8730Xb6, interfaceC9102Ym4.getValue());
            if (objA == null) {
                return null;
            }
            ZG6 zg6C = ((YG6) interfaceC9102Ym4).c();
            AbstractC13042fc3.g(zg6C, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<kotlin.Any?>");
            return AbstractC10222bH6.h(objA, zg6C);
        }
    }

    /* renamed from: ir.nasim.aN5$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC8230Vb6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC8230Vb6 interfaceC8230Vb6) {
            super(1);
            this.e = interfaceC8230Vb6;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9102Ym4 invoke(InterfaceC9102Ym4 interfaceC9102Ym4) {
            Object objB;
            if (!(interfaceC9102Ym4 instanceof YG6)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (interfaceC9102Ym4.getValue() != null) {
                InterfaceC8230Vb6 interfaceC8230Vb6 = this.e;
                Object value = interfaceC9102Ym4.getValue();
                AbstractC13042fc3.f(value);
                objB = interfaceC8230Vb6.b(value);
            } else {
                objB = null;
            }
            ZG6 zg6C = ((YG6) interfaceC9102Ym4).c();
            AbstractC13042fc3.g(zg6C, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver?>");
            InterfaceC9102Ym4 interfaceC9102Ym4H = AbstractC10222bH6.h(objB, zg6C);
            AbstractC13042fc3.g(interfaceC9102Ym4H, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver>");
            return interfaceC9102Ym4H;
        }
    }

    /* renamed from: ir.nasim.aN5$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C9230Za6 e;
        final /* synthetic */ InterfaceC8230Vb6 f;
        final /* synthetic */ InterfaceC11814db6 g;
        final /* synthetic */ String h;
        final /* synthetic */ Object i;
        final /* synthetic */ Object[] j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C9230Za6 c9230Za6, InterfaceC8230Vb6 interfaceC8230Vb6, InterfaceC11814db6 interfaceC11814db6, String str, Object obj, Object[] objArr) {
            super(0);
            this.e = c9230Za6;
            this.f = interfaceC8230Vb6;
            this.g = interfaceC11814db6;
            this.h = str;
            this.i = obj;
            this.j = objArr;
        }

        public final void a() {
            this.e.i(this.f, this.g, this.h, this.i, this.j);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public static final String b(Object obj) {
        return obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }

    private static final InterfaceC8230Vb6 c(InterfaceC8230Vb6 interfaceC8230Vb6) {
        AbstractC13042fc3.g(interfaceC8230Vb6, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        return AbstractC8464Wb6.a(new a(interfaceC8230Vb6), new b(interfaceC8230Vb6));
    }

    public static final InterfaceC9102Ym4 d(Object[] objArr, InterfaceC8230Vb6 interfaceC8230Vb6, String str, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        String str2 = str;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-202053668, i, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:124)");
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) e(Arrays.copyOf(objArr, objArr.length), c(interfaceC8230Vb6), str2, sa2, interfaceC22053ub1, (i & 896) | (i & 7168), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9102Ym4;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v9 ??, still in use, count: 1, list:
          (r14v9 ?? I:java.lang.Object) from 0x00c8: INVOKE (r13v0 ?? I:ir.nasim.ub1), (r14v9 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:201)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public static final java.lang.Object e(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v9 ??, still in use, count: 1, list:
          (r14v9 ?? I:java.lang.Object) from 0x00c8: INVOKE (r13v0 ?? I:ir.nasim.ub1), (r14v9 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:201)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(InterfaceC11814db6 interfaceC11814db6, Object obj) {
        String strB;
        if (obj == null || interfaceC11814db6.a(obj)) {
            return;
        }
        if (obj instanceof YG6) {
            YG6 yg6 = (YG6) obj;
            if (yg6.c() == AbstractC10222bH6.j() || yg6.c() == AbstractC10222bH6.s() || yg6.c() == AbstractC10222bH6.p()) {
                strB = "MutableState containing " + yg6.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
            } else {
                strB = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
            }
        } else {
            strB = b(obj);
        }
        throw new IllegalArgumentException(strB);
    }
}
