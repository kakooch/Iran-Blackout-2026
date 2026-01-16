package ir.nasim;

import com.vdurmont.semver4j.SemverException;

/* renamed from: ir.nasim.ko6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C16165ko6 implements Comparable {
    private final String a;
    private final String b;
    private final Integer c;
    private final Integer d;
    private final Integer e;
    private final String[] f;
    private final String g;
    private final a h;

    /* renamed from: ir.nasim.ko6$a */
    public enum a {
        STRICT,
        LOOSE,
        NPM,
        COCOAPODS,
        IVY
    }

    public C16165ko6(String str) {
        this(str, a.STRICT);
    }

    private boolean r(String str) {
        int iIndexOf = this.b.indexOf("+");
        int iIndexOf2 = this.b.indexOf("-");
        if (iIndexOf2 == -1) {
            return false;
        }
        return iIndexOf == -1 || iIndexOf2 < iIndexOf;
    }

    private void w(a aVar) {
        if (this.d == null && aVar == a.STRICT) {
            throw new SemverException("Invalid version (no minor version): " + this.b);
        }
        if (this.e == null && aVar == a.STRICT) {
            throw new SemverException("Invalid version (no patch version): " + this.b);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C16165ko6 c16165ko6) {
        if (u(c16165ko6)) {
            return 1;
        }
        return v(c16165ko6) ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C16165ko6) {
            return this.b.equals(((C16165ko6) obj).b);
        }
        return false;
    }

    public String h() {
        return this.g;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public Integer i() {
        return this.c;
    }

    public Integer j() {
        return this.d;
    }

    public Integer o() {
        return this.e;
    }

    public String[] p() {
        return this.f;
    }

    public String q() {
        return this.b;
    }

    public boolean s(C16165ko6 c16165ko6) {
        if (this.h == a.NPM) {
            if (i() != c16165ko6.i()) {
                return false;
            }
            if (c16165ko6.j() == null || c16165ko6.o() == null) {
                return true;
            }
        }
        return equals(c16165ko6);
    }

    public boolean t(C16165ko6 c16165ko6) {
        C16165ko6 c16165ko62;
        if (h() == null) {
            c16165ko62 = this;
        } else {
            c16165ko62 = new C16165ko6(q().replace("+" + h(), ""));
        }
        if (c16165ko6.h() != null) {
            c16165ko6 = new C16165ko6(c16165ko6.q().replace("+" + c16165ko6.h(), ""));
        }
        return c16165ko62.s(c16165ko6);
    }

    public String toString() {
        return q();
    }

    public boolean u(C16165ko6 c16165ko6) {
        int iCompareToIgnoreCase;
        if (i().intValue() > c16165ko6.i().intValue()) {
            return true;
        }
        if (i().intValue() < c16165ko6.i().intValue()) {
            return false;
        }
        a aVar = this.h;
        a aVar2 = a.NPM;
        if (aVar == aVar2 && c16165ko6.j() == null) {
            return false;
        }
        int iIntValue = c16165ko6.j() != null ? c16165ko6.j().intValue() : 0;
        if (j() != null && j().intValue() > iIntValue) {
            return true;
        }
        if (j() != null && j().intValue() < iIntValue) {
            return false;
        }
        if (this.h == aVar2 && c16165ko6.o() == null) {
            return false;
        }
        int iIntValue2 = c16165ko6.o() != null ? c16165ko6.o().intValue() : 0;
        if (o() != null && o().intValue() > iIntValue2) {
            return true;
        }
        if (o() != null && o().intValue() < iIntValue2) {
            return false;
        }
        String[] strArrP = p();
        String[] strArrP2 = c16165ko6.p();
        if (strArrP.length == 0 && strArrP2.length > 0) {
            return true;
        }
        if (strArrP2.length == 0 && strArrP.length > 0) {
            return false;
        }
        for (int i = 0; i < strArrP.length && i < strArrP2.length; i++) {
            try {
                iCompareToIgnoreCase = Integer.valueOf(strArrP[i]).intValue() - Integer.valueOf(strArrP2[i]).intValue();
            } catch (NumberFormatException unused) {
                iCompareToIgnoreCase = strArrP[i].compareToIgnoreCase(strArrP2[i]);
            }
            if (iCompareToIgnoreCase < 0) {
                return false;
            }
            if (iCompareToIgnoreCase > 0) {
                return true;
            }
        }
        return strArrP.length > strArrP2.length;
    }

    public boolean v(C16165ko6 c16165ko6) {
        return (u(c16165ko6) || t(c16165ko6)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x011f A[Catch: IndexOutOfBoundsException -> 0x0140, TryCatch #5 {IndexOutOfBoundsException -> 0x0140, blocks: (B:59:0x0117, B:61:0x011f, B:63:0x0129, B:64:0x0133, B:65:0x013a, B:66:0x013f), top: B:85:0x0117 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013a A[Catch: IndexOutOfBoundsException -> 0x0140, TryCatch #5 {IndexOutOfBoundsException -> 0x0140, blocks: (B:59:0x0117, B:61:0x011f, B:63:0x0129, B:64:0x0133, B:65:0x013a, B:66:0x013f), top: B:85:0x0117 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C16165ko6(java.lang.String r20, ir.nasim.C16165ko6.a r21) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16165ko6.<init>(java.lang.String, ir.nasim.ko6$a):void");
    }
}
