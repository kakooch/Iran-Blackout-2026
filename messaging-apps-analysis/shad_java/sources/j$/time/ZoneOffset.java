package j$.time;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.db.DBHelper;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.t;
import j$.time.temporal.u;
import j$.time.temporal.w;
import j$.time.temporal.x;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX WARN: Unexpected interfaces in signature: [java.io.Serializable] */
/* loaded from: classes2.dex */
public final class ZoneOffset extends l implements j$.time.temporal.k, Comparable<ZoneOffset> {
    private final int b;
    private final transient String c;
    private static final ConcurrentMap d = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = n(0);
    public static final ZoneOffset f = n(-64800);
    public static final ZoneOffset g = n(64800);

    private ZoneOffset(int i) {
        String string;
        this.b = i;
        if (i == 0) {
            string = "Z";
        } else {
            int iAbs = Math.abs(i);
            StringBuilder sb = new StringBuilder();
            int i2 = iAbs / 3600;
            int i3 = (iAbs / 60) % 60;
            sb.append(i < 0 ? "-" : "+");
            sb.append(i2 < 10 ? "0" : BuildConfig.FLAVOR);
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
        this.c = string;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.ZoneOffset l(java.lang.String r7) {
        /*
            if (r7 == 0) goto Lbf
            java.util.concurrent.ConcurrentMap r0 = j$.time.ZoneOffset.e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
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
            int r0 = o(r7, r2, r3)
            int r1 = o(r7, r6, r2)
            int r2 = o(r7, r5, r2)
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
            int r0 = o(r7, r2, r3)
            int r1 = o(r7, r1, r3)
            int r2 = o(r7, r4, r3)
            goto L8c
        L58:
            int r0 = o(r7, r2, r3)
            int r1 = o(r7, r6, r2)
            goto L8b
        L61:
            int r0 = o(r7, r2, r3)
            int r1 = o(r7, r1, r3)
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
            int r0 = o(r7, r2, r3)
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
            j$.time.ZoneOffset r7 = m(r7, r0, r1)
            return r7
        Lba:
            j$.time.ZoneOffset r7 = m(r0, r1, r2)
            return r7
        Lbf:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "offsetId"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.l(java.lang.String):j$.time.ZoneOffset");
    }

    public static ZoneOffset m(int i, int i2, int i3) {
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
        return n((i2 * 60) + (i * 3600) + i3);
    }

    public static ZoneOffset n(int i) {
        if (i < -64800 || i > 64800) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i % DBHelper.GET_STICKER_LIMIT != 0) {
            return new ZoneOffset(i);
        }
        Integer numValueOf = Integer.valueOf(i);
        ConcurrentMap concurrentMap = d;
        ZoneOffset zoneOffset = (ZoneOffset) concurrentMap.get(numValueOf);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        concurrentMap.putIfAbsent(numValueOf, new ZoneOffset(i));
        ZoneOffset zoneOffset2 = (ZoneOffset) concurrentMap.get(numValueOf);
        e.putIfAbsent(zoneOffset2.c, zoneOffset2);
        return zoneOffset2;
    }

    private static int o(CharSequence charSequence, int i, boolean z) {
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

    @Override // j$.time.temporal.k
    public int a(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.b;
        }
        if (!(lVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.j.c(this, lVar).a(c(lVar), lVar);
        }
        throw new w("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public x b(j$.time.temporal.l lVar) {
        return j$.time.temporal.j.c(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long c(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.b;
        }
        if (!(lVar instanceof j$.time.temporal.a)) {
            return lVar.c(this);
        }
        throw new w("Unsupported field: " + lVar);
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.b - this.b;
    }

    @Override // j$.time.temporal.k
    public Object d(u uVar) {
        int i = t.a;
        return (uVar == p.a || uVar == q.a) ? this : j$.time.temporal.j.b(this, uVar);
    }

    @Override // j$.time.temporal.k
    public boolean e(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.a ? lVar == j$.time.temporal.a.OFFSET_SECONDS : lVar != null && lVar.d(this);
    }

    @Override // j$.time.l
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.b == ((ZoneOffset) obj).b;
    }

    @Override // j$.time.l
    public String f() {
        return this.c;
    }

    @Override // j$.time.l
    public j$.time.zone.c g() {
        return j$.time.zone.c.e(this);
    }

    @Override // j$.time.l
    public int hashCode() {
        return this.b;
    }

    public int k() {
        return this.b;
    }

    @Override // j$.time.l
    public String toString() {
        return this.c;
    }
}
