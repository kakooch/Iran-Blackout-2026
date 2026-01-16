package ir.nasim;

import ir.nasim.DX1;
import ir.nasim.EX1;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class IX1 implements InterfaceC14123hO3 {
    public static final IX1 a = new IX1();

    private IX1() {
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DX1 a(EX1 ex1) {
        AbstractC13042fc3.i(ex1, "input");
        if (ex1 instanceof EX1.d) {
            return DX1.b.a;
        }
        if (ex1 instanceof EX1.e) {
            return new DX1.d(((EX1.e) ex1).b());
        }
        if (AbstractC13042fc3.d(ex1, EX1.a.b) || (ex1 instanceof EX1.b.a) || (ex1 instanceof EX1.b.C0341b) || AbstractC13042fc3.d(ex1, EX1.b.c.b) || (ex1 instanceof EX1.b.d) || AbstractC13042fc3.d(ex1, EX1.c.a.b) || AbstractC13042fc3.d(ex1, EX1.c.b.b) || AbstractC13042fc3.d(ex1, EX1.c.C0342c.b) || AbstractC13042fc3.d(ex1, EX1.c.d.b) || AbstractC13042fc3.d(ex1, EX1.c.e.b) || AbstractC13042fc3.d(ex1, EX1.c.f.b) || AbstractC13042fc3.d(ex1, EX1.c.g.b) || AbstractC13042fc3.d(ex1, EX1.c.h.b) || (ex1 instanceof EX1.c.i) || (ex1 instanceof EX1.c.j)) {
            return new DX1.d(null, 1, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
