package ir.nasim;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ST0 implements InterfaceC5277Iq5 {
    private static final ST0 a = new ST0();

    private static class b implements RT0 {
        private final C4092Dq5 a;

        private b(C4092Dq5 c4092Dq5) {
            this.a = c4092Dq5;
        }
    }

    private ST0() {
    }

    static void d() {
        AbstractC24881zM5.i(a);
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    public Class a() {
        return RT0.class;
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    public Class b() {
        return RT0.class;
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public RT0 c(C4092Dq5 c4092Dq5) throws GeneralSecurityException {
        if (c4092Dq5 == null) {
            throw new GeneralSecurityException("primitive set must be non-null");
        }
        if (c4092Dq5.f() == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator it = c4092Dq5.d().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new b(c4092Dq5);
    }
}
