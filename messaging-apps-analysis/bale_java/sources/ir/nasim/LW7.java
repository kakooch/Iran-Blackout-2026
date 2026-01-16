package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class LW7 {
    private final String a;
    private final int b;
    private final C25005za3 c;
    private final TH6 d;
    private final List e;
    private final Object f;

    public LW7(String str, int i, C25005za3 c25005za3, TH6 th6, List list, Object obj) {
        this.a = str;
        this.b = i;
        this.c = c25005za3;
        this.d = th6;
        this.e = list;
        this.f = obj;
    }

    public final List a() {
        List list = this.e;
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((LW7) it.next()).a());
        }
        return AbstractC15401jX0.R0(list2, arrayList);
    }

    public final C25005za3 b() {
        return this.c;
    }

    public final List c() {
        return this.e;
    }

    public final String d() {
        return this.a;
    }

    public final Object e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LW7)) {
            return false;
        }
        LW7 lw7 = (LW7) obj;
        return AbstractC13042fc3.d(this.a, lw7.a) && this.b == lw7.b && AbstractC13042fc3.d(this.c, lw7.c) && AbstractC13042fc3.d(this.d, lw7.d) && AbstractC13042fc3.d(this.e, lw7.e) && AbstractC13042fc3.d(this.f, lw7.f);
    }

    public final int f() {
        return this.b;
    }

    public final TH6 g() {
        return this.d;
    }

    public final boolean h() {
        return (this.c.d() == 0 || this.c.h() == 0) ? false : true;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode()) * 31;
        TH6 th6 = this.d;
        int iHashCode2 = (((iHashCode + (th6 == null ? 0 : th6.hashCode())) * 31) + this.e.hashCode()) * 31;
        Object obj = this.f;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 40
            r0.append(r1)
            java.lang.String r2 = r4.a
            r0.append(r2)
            r2 = 58
            r0.append(r2)
            int r2 = r4.b
            r0.append(r2)
            java.lang.String r2 = ",\n            |bounds=(top="
            r0.append(r2)
            ir.nasim.za3 r2 = r4.c
            int r2 = r2.j()
            r0.append(r2)
            java.lang.String r2 = ", left="
            r0.append(r2)
            ir.nasim.za3 r2 = r4.c
            int r2 = r2.g()
            r0.append(r2)
            java.lang.String r2 = ",\n            |location="
            r0.append(r2)
            ir.nasim.TH6 r2 = r4.d
            if (r2 == 0) goto L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            int r1 = r2.c()
            r3.append(r1)
            r1 = 76
            r3.append(r1)
            int r1 = r2.a()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            if (r1 != 0) goto L61
        L5f:
            java.lang.String r1 = "<none>"
        L61:
            r0.append(r1)
            java.lang.String r1 = "\n            |bottom="
            r0.append(r1)
            ir.nasim.za3 r1 = r4.c
            int r1 = r1.d()
            r0.append(r1)
            java.lang.String r1 = ", right="
            r0.append(r1)
            ir.nasim.za3 r1 = r4.c
            int r1 = r1.h()
            r0.append(r1)
            java.lang.String r1 = "),\n            |childrenCount="
            r0.append(r1)
            java.util.List r1 = r4.e
            int r1 = r1.size()
            r0.append(r1)
            r1 = 41
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            r2 = 0
            java.lang.String r0 = ir.nasim.AbstractC14836iZ6.i(r0, r2, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LW7.toString():java.lang.String");
    }
}
