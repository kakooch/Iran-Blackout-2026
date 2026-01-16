package androidx.compose.ui;

import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19810qy7;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.Q93;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public abstract class c {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(e.b bVar) {
            return Boolean.valueOf(!(bVar instanceof androidx.compose.ui.b));
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC22053ub1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC22053ub1 interfaceC22053ub1) {
            super(2);
            this.e = interfaceC22053ub1;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e invoke(e eVar, e.b bVar) {
            boolean z = bVar instanceof androidx.compose.ui.b;
            e eVarD = bVar;
            if (z) {
                InterfaceC15796kB2 interfaceC15796kB2F = ((androidx.compose.ui.b) bVar).f();
                AbstractC13042fc3.g(interfaceC15796kB2F, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                eVarD = c.d(this.e, (e) ((InterfaceC15796kB2) AbstractC19810qy7.g(interfaceC15796kB2F, 3)).q(e.a, this.e, 0));
            }
            return eVar.i(eVarD);
        }
    }

    public static final e b(e eVar, UA2 ua2, InterfaceC15796kB2 interfaceC15796kB2) {
        return eVar.i(new androidx.compose.ui.b(ua2, interfaceC15796kB2));
    }

    public static /* synthetic */ e c(e eVar, UA2 ua2, InterfaceC15796kB2 interfaceC15796kB2, int i, Object obj) {
        if ((i & 1) != 0) {
            ua2 = Q93.a();
        }
        return b(eVar, ua2, interfaceC15796kB2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e d(InterfaceC22053ub1 interfaceC22053ub1, e eVar) {
        if (eVar.c(a.e)) {
            return eVar;
        }
        interfaceC22053ub1.A(1219399079);
        e eVar2 = (e) eVar.a(e.a, new b(interfaceC22053ub1));
        interfaceC22053ub1.U();
        return eVar2;
    }

    public static final e e(InterfaceC22053ub1 interfaceC22053ub1, e eVar) {
        interfaceC22053ub1.W(439770924);
        e eVarD = d(interfaceC22053ub1, eVar);
        interfaceC22053ub1.Q();
        return eVarD;
    }

    public static final e f(InterfaceC22053ub1 interfaceC22053ub1, e eVar) {
        return eVar == e.a ? eVar : e(interfaceC22053ub1, new CompositionLocalMapInjectionElement(interfaceC22053ub1.q()).i(eVar));
    }
}
