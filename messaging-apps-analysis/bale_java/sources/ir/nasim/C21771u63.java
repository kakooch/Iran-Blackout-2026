package ir.nasim;

import ir.nasim.C21097t63;
import java.util.Iterator;

/* renamed from: ir.nasim.u63, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21771u63 implements InterfaceC7041Qa1 {
    private final C22361v63 a;
    private final SA2 b;
    private C3324Aj7 c = new C3324Aj7(0, 0);

    public C21771u63(C22361v63 c22361v63, SA2 sa2) {
        this.a = c22361v63;
        this.b = sa2;
    }

    private final long c(C21097t63.a aVar) {
        InterfaceC5766Kt interfaceC5766KtF = aVar.f();
        AbstractC13042fc3.g(interfaceC5766KtF, "null cannot be cast to non-null type androidx.compose.animation.core.InfiniteRepeatableSpec<T of androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock.getIterationDuration>");
        C20494s63 c20494s63 = (C20494s63) interfaceC5766KtF;
        int i = c20494s63.g() == EO5.b ? 2 : 1;
        InterfaceC10929cR7 interfaceC10929cR7A = c20494s63.f().a(aVar.z());
        return AbstractC24892zN7.a(interfaceC10929cR7A.d() + (interfaceC10929cR7A.e() * i));
    }

    @Override // ir.nasim.InterfaceC7041Qa1
    public long a() {
        return Math.max(d(), ((Number) this.b.invoke()).longValue());
    }

    public C22361v63 b() {
        return this.a;
    }

    public long d() {
        Long l;
        Iterator it = b().b().g().iterator();
        if (it.hasNext()) {
            Long lValueOf = Long.valueOf(c((C21097t63.a) it.next()));
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(c((C21097t63.a) it.next()));
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
            }
            l = lValueOf;
        } else {
            l = null;
        }
        return AbstractC24892zN7.b(l != null ? l.longValue() : 0L);
    }
}
