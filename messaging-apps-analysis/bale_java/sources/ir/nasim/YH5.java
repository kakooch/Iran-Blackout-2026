package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class YH5 extends AbstractC21707u0 implements D48 {
    private final C9057Yh4 b;
    private final InterfaceC9173Yu3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YH5(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.XH5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return YH5.B();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4275El B() {
        return ((InterfaceC6280My1) C92.a(C5721Ko.a.d(), InterfaceC6280My1.class)).s0();
    }

    private final Long C(long j, C11458d25 c11458d25, long j2) {
        return D().c(c11458d25.u(), AbstractC4616Fw7.a(Long.valueOf(j), Long.valueOf(j2)));
    }

    private final C4275El D() {
        return (C4275El) this.c.getValue();
    }

    private final J44 E(J44 j44, long j, List list, long j2) {
        AbstractC17457n0 abstractC17457n0F = j44.F();
        C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
        if (c11907dl == null) {
            return j44;
        }
        List<J44> listR = c11907dl.r();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listR, 10));
        for (J44 j44F : listR) {
            if (j44F.i() == j && j44F.h() == j2) {
                j44F = F(j44F, list);
            }
            arrayList.add(j44F);
        }
        C11907dl c11907dl2 = new C11907dl(arrayList);
        return J44.D(j44, 0L, 0L, 0L, 0, null, c11907dl2, AbstractC12519el.a(c11907dl2), 0, null, null, 0L, null, null, false, null, false, null, null, 262047, null);
    }

    private final J44 F(J44 j44, List list) {
        Object next;
        Iterator it = j44.R().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((GG5) next).u(), "👁️")) {
                break;
            }
        }
        GG5 gg5 = (GG5) next;
        return J44.D(j44, 0L, 0L, 0L, 0, null, null, gg5 != null ? AbstractC15401jX0.S0(list, gg5) : list, 0, null, null, 0L, null, null, false, null, false, null, null, 262079, null);
    }

    @Override // ir.nasim.D48
    public boolean d(AbstractC20556sC7 abstractC20556sC7, long j) {
        J44 j44F;
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (!(abstractC20556sC7 instanceof ME7)) {
            return false;
        }
        ME7 me7 = (ME7) abstractC20556sC7;
        List listC = me7.c();
        C11458d25 c11458d25B = me7.b();
        long jD = me7.d();
        long jA = me7.a();
        DB3 db3H0 = this.b.G().H0(c11458d25B);
        J44 j44 = (J44) db3H0.a(jD);
        if (j44 == null || (j44F = F(j44, listC)) == null) {
            Long lC = C(jD, c11458d25B, jA);
            if (lC != null) {
                J44 j442 = (J44) db3H0.a(lC.longValue());
                if (j442.F() instanceof C11907dl) {
                    AbstractC13042fc3.f(j442);
                    db3H0.d(E(j442, jD, listC, jA));
                }
            }
        } else {
            db3H0.d(j44F);
        }
        return true;
    }
}
