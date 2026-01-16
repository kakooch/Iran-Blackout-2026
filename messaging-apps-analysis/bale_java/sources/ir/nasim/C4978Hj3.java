package ir.nasim;

import ir.nasim.AbstractC17643nJ4;
import ir.nasim.C17448mz0;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Hj3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4978Hj3 {
    public static final int b = C4627Fy0.D;
    private final C4627Fy0 a;

    public C4978Hj3(C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.a = c4627Fy0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(long j, int i) {
        AbstractC17643nJ4 abstractC17643nJ4;
        Iterator it = ((Iterable) C10263bM2.a.b().getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            AbstractC17643nJ4 abstractC17643nJ42 = (AbstractC17643nJ4) next;
            abstractC17643nJ4 = abstractC17643nJ42 instanceof AbstractC17643nJ4 ? abstractC17643nJ42 : null;
            if (abstractC17643nJ4 != null && abstractC17643nJ4.a() == j) {
                abstractC17643nJ4 = next;
                break;
            }
        }
        AbstractC17643nJ4 abstractC17643nJ43 = abstractC17643nJ4;
        if (abstractC17643nJ43 != null) {
            if (abstractC17643nJ43 instanceof AbstractC17643nJ4.a) {
                C18039nz0 c18039nz0 = C18039nz0.a;
                AbstractC17643nJ4.a aVar = (AbstractC17643nJ4.a) abstractC17643nJ43;
                if (((C17448mz0) c18039nz0.d().getValue()).c() == aVar.a() && ((C17448mz0) c18039nz0.d().getValue()).e() == C17448mz0.a.e) {
                    InterfaceC5110Hy0.c(this.a, true, 0L, 2, null);
                    return;
                } else {
                    C20384rv0.a.O(i, aVar.a(), aVar.b());
                    return;
                }
            }
            if (!(abstractC17643nJ43 instanceof AbstractC17643nJ4.c)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(abstractC17643nJ43 instanceof AbstractC17643nJ4.b)) {
                C20384rv0.a.O(i, ((AbstractC17643nJ4.c) abstractC17643nJ43).a(), 0);
            } else {
                AbstractC17643nJ4.b bVar = (AbstractC17643nJ4.b) abstractC17643nJ43;
                this.a.O0(bVar.a(), bVar.f() == AbstractC5969Lp4.f(), (448 & 4) != 0 ? null : Long.valueOf(bVar.f()), (448 & 8) != 0 ? null : bVar.c(), (448 & 16) != 0 ? null : bVar.e(), (448 & 32) != 0 ? null : bVar.d(), (448 & 64) != 0 ? false : false, (448 & 128) != 0, (448 & 256) != 0);
            }
        }
    }
}
