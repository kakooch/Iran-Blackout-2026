package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.yV3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24366yV3 {
    public static final C24366yV3 a = new C24366yV3();

    /* renamed from: ir.nasim.yV3$a */
    public interface a {
        void a(ArrayList arrayList);
    }

    private C24366yV3() {
    }

    private final long a(long j) {
        long j2 = 1;
        do {
            j2++;
        } while (j % j2 != 0);
        return j / j2;
    }

    public final void b(long j, a aVar) {
        AbstractC13042fc3.i(aVar, "callback");
        ArrayList arrayList = new ArrayList();
        long jA = a(j);
        for (long j2 = 10000; j2 <= jA; j2++) {
            if (j % j2 == 0) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        aVar.a(arrayList);
    }
}
