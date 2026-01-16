package j$.time.format;

import java.util.Locale;

/* loaded from: classes2.dex */
final class q {
    private j$.time.temporal.k a;
    private DateTimeFormatter b;
    private int c;

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    q(j$.time.temporal.k r10, j$.time.format.DateTimeFormatter r11) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.q.<init>(j$.time.temporal.k, j$.time.format.DateTimeFormatter):void");
    }

    void a() {
        this.c--;
    }

    s b() {
        return this.b.c();
    }

    Locale c() {
        return this.b.d();
    }

    j$.time.temporal.k d() {
        return this.a;
    }

    Long e(j$.time.temporal.l lVar) {
        try {
            return Long.valueOf(this.a.c(lVar));
        } catch (j$.time.c e) {
            if (this.c > 0) {
                return null;
            }
            throw e;
        }
    }

    Object f(j$.time.temporal.u uVar) {
        Object objD = this.a.d(uVar);
        if (objD != null || this.c != 0) {
            return objD;
        }
        throw new j$.time.c("Unable to extract value: " + this.a.getClass());
    }

    void g() {
        this.c++;
    }

    public String toString() {
        return this.a.toString();
    }
}
