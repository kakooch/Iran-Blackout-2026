package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Gt6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4837Gt6 {
    private final EnumC17988nt6 a;
    private final AbstractC13937h43 b;
    private final int c;
    private final boolean d;
    private final boolean e;
    private final String f;
    private final boolean g;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0055 A[EDGE_INSN: B:15:0x0055->B:16:0x0056 BREAK  A[LOOP:0: B:10:0x0040->B:20:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C4837Gt6(ir.nasim.EnumC17988nt6 r2, ir.nasim.AbstractC13937h43 r3, int r4, boolean r5, boolean r6, java.lang.String r7) {
        /*
            r1 = this;
            java.lang.String r0 = "servicesPageLoadingState"
            ir.nasim.AbstractC13042fc3.i(r2, r0)
            java.lang.String r0 = "servicesPageSections"
            ir.nasim.AbstractC13042fc3.i(r3, r0)
            r1.<init>()
            r1.a = r2
            r1.b = r3
            r1.c = r4
            r1.d = r5
            r1.e = r6
            r1.f = r7
            int r2 = r3.size()
            if (r2 != r4) goto L55
            boolean r2 = r3.isEmpty()
            r4 = 1
            r2 = r2 ^ r4
            if (r2 == 0) goto L55
            java.util.Collection r2 = r3.values()
            java.lang.String r3 = "<get-values>(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r3)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L3c
            goto L56
        L3c:
            java.util.Iterator r2 = r2.iterator()
        L40:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L56
            java.lang.Object r3 = r2.next()
            ir.nasim.rt6 r3 = (ir.nasim.InterfaceC20370rt6) r3
            ir.nasim.qt6 r3 = r3.a()
            ir.nasim.qt6 r5 = ir.nasim.EnumC19761qt6.b
            if (r3 != r5) goto L55
            goto L40
        L55:
            r4 = 0
        L56:
            r1.g = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4837Gt6.<init>(ir.nasim.nt6, ir.nasim.h43, int, boolean, boolean, java.lang.String):void");
    }

    public static /* synthetic */ C4837Gt6 b(C4837Gt6 c4837Gt6, EnumC17988nt6 enumC17988nt6, AbstractC13937h43 abstractC13937h43, int i, boolean z, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            enumC17988nt6 = c4837Gt6.a;
        }
        if ((i2 & 2) != 0) {
            abstractC13937h43 = c4837Gt6.b;
        }
        AbstractC13937h43 abstractC13937h432 = abstractC13937h43;
        if ((i2 & 4) != 0) {
            i = c4837Gt6.c;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = c4837Gt6.d;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            z2 = c4837Gt6.e;
        }
        boolean z4 = z2;
        if ((i2 & 32) != 0) {
            str = c4837Gt6.f;
        }
        return c4837Gt6.a(enumC17988nt6, abstractC13937h432, i3, z3, z4, str);
    }

    public final C4837Gt6 a(EnumC17988nt6 enumC17988nt6, AbstractC13937h43 abstractC13937h43, int i, boolean z, boolean z2, String str) {
        AbstractC13042fc3.i(enumC17988nt6, "servicesPageLoadingState");
        AbstractC13042fc3.i(abstractC13937h43, "servicesPageSections");
        return new C4837Gt6(enumC17988nt6, abstractC13937h43, i, z, z2, str);
    }

    public final EnumC17988nt6 c() {
        return this.a;
    }

    public final AbstractC13937h43 d() {
        return this.b;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4837Gt6)) {
            return false;
        }
        C4837Gt6 c4837Gt6 = (C4837Gt6) obj;
        return this.a == c4837Gt6.a && AbstractC13042fc3.d(this.b, c4837Gt6.b) && this.c == c4837Gt6.c && this.d == c4837Gt6.d && this.e == c4837Gt6.e && AbstractC13042fc3.d(this.f, c4837Gt6.f);
    }

    public final boolean f() {
        return this.e;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31;
        String str = this.f;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ServicesUiState(servicesPageLoadingState=" + this.a + ", servicesPageSections=" + this.b + ", sectionsCount=" + this.c + ", isViewBotVitrineEventSent=" + this.d + ", isBotsNewBadgeCountVisible=" + this.e + ", snackBarMessage=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ C4837Gt6(EnumC17988nt6 enumC17988nt6, AbstractC13937h43 abstractC13937h43, int i, boolean z, boolean z2, String str, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? EnumC17988nt6.a : enumC17988nt6, (i2 & 2) != 0 ? AbstractC13937h43.p() : abstractC13937h43, i, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? null : str);
    }
}
