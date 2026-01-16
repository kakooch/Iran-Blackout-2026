package ir.nasim;

import kotlin.KotlinNothingValueException;

/* loaded from: classes8.dex */
public final class LY6 extends Z0 {
    private final String e;

    public LY6(String str) {
        AbstractC13042fc3.i(str, "source");
        this.e = str;
    }

    @Override // ir.nasim.Z0
    public String E(String str, boolean z) {
        AbstractC13042fc3.i(str, "keyToMatch");
        int i = this.a;
        try {
            if (j() == 6 && AbstractC13042fc3.d(G(z), str)) {
                t();
                if (j() == 5) {
                    return G(z);
                }
            }
            return null;
        } finally {
            this.a = i;
            t();
        }
    }

    @Override // ir.nasim.Z0
    public int H(int i) {
        if (i < C().length()) {
            return i;
        }
        return -1;
    }

    @Override // ir.nasim.Z0
    public int J() {
        char cCharAt;
        int i = this.a;
        if (i == -1) {
            return i;
        }
        while (i < C().length() && ((cCharAt = C().charAt(i)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i++;
        }
        this.a = i;
        return i;
    }

    @Override // ir.nasim.Z0
    public boolean M() {
        int iJ = J();
        if (iJ == C().length() || iJ == -1 || C().charAt(iJ) != ',') {
            return false;
        }
        this.a++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.Z0
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public String C() {
        return this.e;
    }

    @Override // ir.nasim.Z0
    public boolean e() {
        int i = this.a;
        if (i == -1) {
            return false;
        }
        while (i < C().length()) {
            char cCharAt = C().charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.a = i;
                return D(cCharAt);
            }
            i++;
        }
        this.a = i;
        return false;
    }

    @Override // ir.nasim.Z0
    public String i() {
        l('\"');
        int i = this.a;
        int iK0 = AbstractC20762sZ6.k0(C(), '\"', i, false, 4, null);
        if (iK0 == -1) {
            q();
            y((byte) 1, false);
            throw new KotlinNothingValueException();
        }
        for (int i2 = i; i2 < iK0; i2++) {
            if (C().charAt(i2) == '\\') {
                return p(C(), this.a, i2);
            }
        }
        this.a = iK0 + 1;
        String strSubstring = C().substring(i, iK0);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // ir.nasim.Z0
    public byte j() {
        byte bA;
        String strC = C();
        do {
            int i = this.a;
            if (i == -1 || i >= strC.length()) {
                return (byte) 10;
            }
            int i2 = this.a;
            this.a = i2 + 1;
            bA = AbstractC9468a1.a(strC.charAt(i2));
        } while (bA == 3);
        return bA;
    }

    @Override // ir.nasim.Z0
    public void l(char c) {
        if (this.a == -1) {
            P(c);
        }
        String strC = C();
        while (this.a < strC.length()) {
            int i = this.a;
            this.a = i + 1;
            char cCharAt = strC.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt == c) {
                    return;
                } else {
                    P(c);
                }
            }
        }
        this.a = -1;
        P(c);
    }
}
