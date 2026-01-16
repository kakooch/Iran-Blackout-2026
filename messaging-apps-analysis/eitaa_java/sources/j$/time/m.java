package j$.time;

import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class m extends l implements j$.time.temporal.k, Comparable<m>, Serializable {
    private static final ConcurrentMap b = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap c = new ConcurrentHashMap(16, 0.75f, 4);
    public static final m d = B(0);
    public static final m e = B(-64800);
    public static final m f = B(64800);
    private final int g;
    private final transient String h;

    private m(int i) {
        String string;
        this.g = i;
        if (i == 0) {
            string = "Z";
        } else {
            int iAbs = Math.abs(i);
            StringBuilder sb = new StringBuilder();
            int i2 = iAbs / 3600;
            int i3 = (iAbs / 60) % 60;
            sb.append(i < 0 ? "-" : "+");
            sb.append(i2 < 10 ? "0" : "");
            sb.append(i2);
            sb.append(i3 < 10 ? ":0" : ":");
            sb.append(i3);
            int i4 = iAbs % 60;
            if (i4 != 0) {
                sb.append(i4 >= 10 ? ":" : ":0");
                sb.append(i4);
            }
            string = sb.toString();
        }
        this.h = string;
    }

    public static m A(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            throw new c("Zone offset hours not in valid range: value " + i + " is not in the range -18 to 18");
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new c("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new c("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new c("Zone offset minutes and seconds must have the same sign");
        }
        if (i2 < -59 || i2 > 59) {
            throw new c("Zone offset minutes not in valid range: value " + i2 + " is not in the range -59 to 59");
        }
        if (i3 < -59 || i3 > 59) {
            throw new c("Zone offset seconds not in valid range: value " + i3 + " is not in the range -59 to 59");
        }
        if (Math.abs(i) == 18 && (i2 | i3) != 0) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        return B((i2 * 60) + (i * 3600) + i3);
    }

    public static m B(int i) {
        if (i < -64800 || i > 64800) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i % 900 != 0) {
            return new m(i);
        }
        Integer numValueOf = Integer.valueOf(i);
        ConcurrentMap concurrentMap = b;
        m mVar = (m) concurrentMap.get(numValueOf);
        if (mVar != null) {
            return mVar;
        }
        concurrentMap.putIfAbsent(numValueOf, new m(i));
        m mVar2 = (m) concurrentMap.get(numValueOf);
        c.putIfAbsent(mVar2.h, mVar2);
        return mVar2;
    }

    private static int C(CharSequence charSequence, int i, boolean z) {
        if (z && charSequence.charAt(i - 1) != ':') {
            throw new c("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char cCharAt = charSequence.charAt(i);
        char cCharAt2 = charSequence.charAt(i + 1);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            return (cCharAt2 - '0') + ((cCharAt - '0') * 10);
        }
        throw new c("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.m z(java.lang.String r7) {
        /*
            if (r7 == 0) goto Lbf
            java.util.concurrent.ConcurrentMap r0 = j$.time.m.c
            java.lang.Object r0 = r0.get(r7)
            j$.time.m r0 = (j$.time.m) r0
            if (r0 == 0) goto Ld
            return r0
        Ld:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L6a
            r1 = 3
            if (r0 == r1) goto L86
            r4 = 5
            if (r0 == r4) goto L61
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L58
            r5 = 7
            if (r0 == r5) goto L4b
            r1 = 9
            if (r0 != r1) goto L34
            int r0 = C(r7, r2, r3)
            int r1 = C(r7, r6, r2)
            int r2 = C(r7, r5, r2)
            goto L8c
        L34:
            j$.time.c r0 = new j$.time.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, invalid format: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L4b:
            int r0 = C(r7, r2, r3)
            int r1 = C(r7, r1, r3)
            int r2 = C(r7, r4, r3)
            goto L8c
        L58:
            int r0 = C(r7, r2, r3)
            int r1 = C(r7, r6, r2)
            goto L8b
        L61:
            int r0 = C(r7, r2, r3)
            int r1 = C(r7, r1, r3)
            goto L8b
        L6a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L86:
            int r0 = C(r7, r2, r3)
            r1 = 0
        L8b:
            r2 = 0
        L8c:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto Lb0
            if (r3 != r5) goto L99
            goto Lb0
        L99:
            j$.time.c r0 = new j$.time.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        Lb0:
            if (r3 != r5) goto Lba
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.m r7 = A(r7, r0, r1)
            return r7
        Lba:
            j$.time.m r7 = A(r0, r1, r2)
            return r7
        Lbf:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "offsetId"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.m.z(java.lang.String):j$.time.m");
    }

    @Override // java.lang.Comparable
    public int compareTo(m mVar) {
        return mVar.g - this.g;
    }

    @Override // j$.time.temporal.k
    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.OFFSET_SECONDS : lVar != null && lVar.n(this);
    }

    @Override // j$.time.l
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && this.g == ((m) obj).g;
    }

    @Override // j$.time.l
    public String g() {
        return this.h;
    }

    @Override // j$.time.temporal.k
    public int h(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.h.OFFSET_SECONDS) {
            return this.g;
        }
        if (!(lVar instanceof j$.time.temporal.h)) {
            return a.k(this, lVar).a(l(lVar), lVar);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.l
    public int hashCode() {
        return this.g;
    }

    @Override // j$.time.temporal.k
    public q j(j$.time.temporal.l lVar) {
        return a.k(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long l(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.h.OFFSET_SECONDS) {
            return this.g;
        }
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        return (nVar == j$.time.temporal.c.a || nVar == j$.time.temporal.g.a) ? this : a.j(this, nVar);
    }

    @Override // j$.time.l
    public j$.time.zone.c t() {
        return j$.time.zone.c.e(this);
    }

    @Override // j$.time.l
    public String toString() {
        return this.h;
    }

    public int y() {
        return this.g;
    }
}
