package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes8.dex */
public abstract class Z0 {
    public int a;
    private String c;
    public final C9317Zk3 b = new C9317Zk3();
    private StringBuilder d = new StringBuilder();

    private final int B(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        x(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final String L() {
        String str = this.c;
        AbstractC13042fc3.f(str);
        this.c = null;
        return str;
    }

    public static /* synthetic */ boolean O(Z0 z0, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return z0.N(z);
    }

    private final boolean Q() {
        return C().charAt(this.a - 1) != '\"';
    }

    private final int a(int i) {
        int iH = H(i);
        if (iH == -1) {
            x(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i2 = iH + 1;
        char cCharAt = C().charAt(iH);
        if (cCharAt == 'u') {
            return c(C(), i2);
        }
        char cB = AbstractC9468a1.b(cCharAt);
        if (cB != 0) {
            this.d.append(cB);
            return i2;
        }
        x(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int b(int i, int i2) {
        d(i, i2);
        return a(i2 + 1);
    }

    private final int c(CharSequence charSequence, int i) {
        int i2 = i + 4;
        if (i2 < charSequence.length()) {
            this.d.append((char) ((B(charSequence, i) << 12) + (B(charSequence, i + 1) << 8) + (B(charSequence, i + 2) << 4) + B(charSequence, i + 3)));
            return i2;
        }
        this.a = i;
        u();
        if (this.a + 4 < charSequence.length()) {
            return c(charSequence, this.a);
        }
        x(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean f(int i) {
        int iH = H(i);
        if (iH >= C().length() || iH == -1) {
            x(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i2 = iH + 1;
        int iCharAt = C().charAt(iH) | ' ';
        if (iCharAt == 102) {
            h("alse", i2);
            return false;
        }
        if (iCharAt == 116) {
            h("rue", i2);
            return true;
        }
        x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final void h(String str, int i) {
        if (C().length() - i < str.length()) {
            x(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != (C().charAt(i + i2) | ' ')) {
                x(this, "Expected valid boolean literal prefix, but had '" + q() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.a = i + str.length();
    }

    private static final double n(long j, boolean z) {
        if (!z) {
            return Math.pow(10.0d, -j);
        }
        if (z) {
            return Math.pow(10.0d, j);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String s(int i, int i2) {
        d(i, i2);
        String string = this.d.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        this.d.setLength(0);
        return string;
    }

    public static /* synthetic */ Void x(Z0 z0, String str, int i, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i2 & 2) != 0) {
            i = z0.a;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        return z0.w(str, i, str2);
    }

    public static /* synthetic */ Void z(Z0 z0, byte b, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return z0.y(b, z);
    }

    public final void A(String str) {
        AbstractC13042fc3.i(str, "key");
        w("Encountered an unknown key '" + str + '\'', AbstractC20762sZ6.r0(K(0, this.a), str, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    protected abstract CharSequence C();

    protected final boolean D(char c) {
        return !(c == '}' || c == ']' || c == ':' || c == ',');
    }

    public abstract String E(String str, boolean z);

    public final byte F() {
        CharSequence charSequenceC = C();
        int i = this.a;
        while (true) {
            int iH = H(i);
            if (iH == -1) {
                this.a = iH;
                return (byte) 10;
            }
            char cCharAt = charSequenceC.charAt(iH);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.a = iH;
                return AbstractC9468a1.a(cCharAt);
            }
            i = iH + 1;
        }
    }

    public final String G(boolean z) {
        String strO;
        byte bF = F();
        if (z) {
            if (bF != 1 && bF != 0) {
                return null;
            }
            strO = q();
        } else {
            if (bF != 1) {
                return null;
            }
            strO = o();
        }
        this.c = strO;
        return strO;
    }

    public abstract int H(int i);

    public final void I(boolean z) {
        ArrayList arrayList = new ArrayList();
        byte bF = F();
        if (bF != 8 && bF != 6) {
            q();
            return;
        }
        while (true) {
            byte bF2 = F();
            if (bF2 != 1) {
                if (bF2 == 8 || bF2 == 6) {
                    arrayList.add(Byte.valueOf(bF2));
                } else if (bF2 == 9) {
                    if (((Number) AbstractC15401jX0.C0(arrayList)).byteValue() != 8) {
                        throw AbstractC3802Ck3.e(this.a, "found ] instead of } at path: " + this.b, C());
                    }
                    AbstractC13610gX0.N(arrayList);
                } else if (bF2 == 7) {
                    if (((Number) AbstractC15401jX0.C0(arrayList)).byteValue() != 6) {
                        throw AbstractC3802Ck3.e(this.a, "found } instead of ] at path: " + this.b, C());
                    }
                    AbstractC13610gX0.N(arrayList);
                } else if (bF2 == 10) {
                    x(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                j();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z) {
                q();
            } else {
                i();
            }
        }
    }

    public abstract int J();

    public String K(int i, int i2) {
        return C().subSequence(i, i2).toString();
    }

    public abstract boolean M();

    public final boolean N(boolean z) {
        int iH = H(J());
        int length = C().length() - iH;
        if (length < 4 || iH == -1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if ("null".charAt(i) != C().charAt(iH + i)) {
                return false;
            }
        }
        if (length > 4 && AbstractC9468a1.a(C().charAt(iH + 4)) == 0) {
            return false;
        }
        if (!z) {
            return true;
        }
        this.a = iH + 4;
        return true;
    }

    protected final void P(char c) {
        int i = this.a;
        if (i > 0 && c == '\"') {
            try {
                this.a = i - 1;
                String strQ = q();
                this.a = i;
                if (AbstractC13042fc3.d(strQ, "null")) {
                    w("Expected string literal but 'null' literal was found", this.a - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.a = i;
                throw th;
            }
        }
        z(this, AbstractC9468a1.a(c), false, 2, null);
        throw new KotlinNothingValueException();
    }

    protected void d(int i, int i2) {
        this.d.append(C(), i, i2);
    }

    public abstract boolean e();

    public final boolean g() {
        boolean z;
        int iJ = J();
        if (iJ == C().length()) {
            x(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(iJ) == '\"') {
            iJ++;
            z = true;
        } else {
            z = false;
        }
        boolean zF = f(iJ);
        if (z) {
            if (this.a == C().length()) {
                x(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (C().charAt(this.a) != '\"') {
                x(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            this.a++;
        }
        return zF;
    }

    public abstract String i();

    public abstract byte j();

    public final byte k(byte b) {
        byte bJ = j();
        if (bJ == b) {
            return bJ;
        }
        z(this, b, false, 2, null);
        throw new KotlinNothingValueException();
    }

    public abstract void l(char c);

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f6, code lost:
    
        x(r17, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0206, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:?, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011d, code lost:
    
        x(r17, "Unexpected symbol '" + r3 + "' in numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0141, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0142, code lost:
    
        if (r5 == r0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0144, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0147, code lost:
    
        if (r0 == r5) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0149, code lost:
    
        if (r10 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014d, code lost:
    
        if (r0 == (r5 - 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014f, code lost:
    
        if (r1 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0151, code lost:
    
        if (r3 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015d, code lost:
    
        if (C().charAt(r5) != '\"') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x015f, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0162, code lost:
    
        x(r17, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0172, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0173, code lost:
    
        x(r17, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0183, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0184, code lost:
    
        r17.a = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0186, code lost:
    
        if (r9 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0188, code lost:
    
        r0 = r11 * n(r13, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0192, code lost:
    
        if (r0 > 9.223372036854776E18d) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0198, code lost:
    
        if (r0 < (-9.223372036854776E18d)) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a0, code lost:
    
        if (java.lang.Math.floor(r0) != r0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a2, code lost:
    
        r11 = (long) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a4, code lost:
    
        x(r17, "Can't convert " + r0 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c8, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c9, code lost:
    
        x(r17, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d9, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01da, code lost:
    
        if (r10 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e1, code lost:
    
        if (r11 == Long.MIN_VALUE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e4, code lost:
    
        return -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e5, code lost:
    
        x(r17, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f5, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long m() {
        /*
            Method dump skipped, instructions count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Z0.m():long");
    }

    public final String o() {
        return this.c != null ? L() : i();
    }

    protected final String p(CharSequence charSequence, int i, int i2) {
        int iH;
        AbstractC13042fc3.i(charSequence, "source");
        char cCharAt = charSequence.charAt(i2);
        boolean z = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                iH = H(b(i, i2));
                if (iH == -1) {
                    x(this, "Unexpected EOF", iH, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                i2++;
                if (i2 >= charSequence.length()) {
                    d(i, i2);
                    iH = H(i2);
                    if (iH == -1) {
                        x(this, "Unexpected EOF", iH, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    cCharAt = charSequence.charAt(i2);
                }
            }
            z = true;
            i = iH;
            i2 = i;
            cCharAt = charSequence.charAt(i2);
        }
        String strK = !z ? K(i, i2) : s(i, i2);
        this.a = i2 + 1;
        return strK;
    }

    public final String q() {
        if (this.c != null) {
            return L();
        }
        int iJ = J();
        if (iJ >= C().length() || iJ == -1) {
            x(this, "EOF", iJ, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte bA = AbstractC9468a1.a(C().charAt(iJ));
        if (bA == 1) {
            return o();
        }
        if (bA != 0) {
            x(this, "Expected beginning of the string, but got " + C().charAt(iJ), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z = false;
        while (AbstractC9468a1.a(C().charAt(iJ)) == 0) {
            iJ++;
            if (iJ >= C().length()) {
                d(this.a, iJ);
                int iH = H(iJ);
                if (iH == -1) {
                    this.a = iJ;
                    return s(0, 0);
                }
                iJ = iH;
                z = true;
            }
        }
        String strK = !z ? K(this.a, iJ) : s(this.a, iJ);
        this.a = iJ;
        return strK;
    }

    public final String r() {
        String strQ = q();
        if (!AbstractC13042fc3.d(strQ, "null") || !Q()) {
            return strQ;
        }
        x(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final void t() {
        this.c = null;
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.a + ')';
    }

    public final void v() {
        if (j() == 10) {
            return;
        }
        x(this, "Expected EOF after parsing, but had " + C().charAt(this.a - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final Void w(String str, int i, String str2) {
        String str3;
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str2, "hint");
        if (str2.length() == 0) {
            str3 = "";
        } else {
            str3 = '\n' + str2;
        }
        throw AbstractC3802Ck3.e(i, str + " at path: " + this.b.a() + str3, C());
    }

    public final Void y(byte b, boolean z) {
        String strC = AbstractC9468a1.c(b);
        int i = z ? this.a - 1 : this.a;
        x(this, "Expected " + strC + ", but had '" + ((this.a == C().length() || i < 0) ? "EOF" : String.valueOf(C().charAt(i))) + "' instead", i, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public void u() {
    }
}
