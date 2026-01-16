package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.wA3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C22997wA3 {
    private StringBuilder d;
    private String e;
    private String f;
    private char g;
    private StringBuilder h;
    private b a = b.START_DEFINITION;
    private final StringBuilder b = new StringBuilder();
    private final List c = new ArrayList();
    private boolean i = false;

    /* renamed from: ir.nasim.wA3$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.START_DEFINITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.START_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: ir.nasim.wA3$b */
    enum b {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    private int a(CharSequence charSequence, int i) {
        int iJ = OW4.j(charSequence, i, charSequence.length());
        int iA = AbstractC24767zA3.a(charSequence, iJ);
        if (iA == -1) {
            return -1;
        }
        this.f = charSequence.charAt(iJ) == '<' ? charSequence.subSequence(iJ + 1, iA - 1).toString() : charSequence.subSequence(iJ, iA).toString();
        int iJ2 = OW4.j(charSequence, iA, charSequence.length());
        if (iJ2 >= charSequence.length()) {
            this.i = true;
            this.b.setLength(0);
        } else if (iJ2 == iA) {
            return -1;
        }
        this.a = b.START_TITLE;
        return iJ2;
    }

    private void b() {
        if (this.i) {
            String strE = AbstractC16612la2.e(this.f);
            StringBuilder sb = this.h;
            this.c.add(new C22401vA3(this.e, strE, sb != null ? AbstractC16612la2.e(sb.toString()) : null));
            this.d = null;
            this.i = false;
            this.e = null;
            this.f = null;
            this.h = null;
        }
    }

    private int e(CharSequence charSequence, int i) {
        int i2;
        int iC = AbstractC24767zA3.c(charSequence, i);
        if (iC == -1) {
            return -1;
        }
        this.d.append(charSequence, i, iC);
        if (iC >= charSequence.length()) {
            this.d.append('\n');
            return iC;
        }
        if (charSequence.charAt(iC) != ']' || (i2 = iC + 1) >= charSequence.length() || charSequence.charAt(i2) != ':' || this.d.length() > 999) {
            return -1;
        }
        String strB = AbstractC16612la2.b(this.d.toString());
        if (strB.isEmpty()) {
            return -1;
        }
        this.e = strB;
        this.a = b.DESTINATION;
        return OW4.j(charSequence, iC + 2, charSequence.length());
    }

    private int g(CharSequence charSequence, int i) {
        int iJ = OW4.j(charSequence, i, charSequence.length());
        if (iJ >= charSequence.length() || charSequence.charAt(iJ) != '[') {
            return -1;
        }
        this.a = b.LABEL;
        this.d = new StringBuilder();
        int i2 = iJ + 1;
        if (i2 >= charSequence.length()) {
            this.d.append('\n');
        }
        return i2;
    }

    private int h(CharSequence charSequence, int i) {
        int iJ = OW4.j(charSequence, i, charSequence.length());
        if (iJ >= charSequence.length()) {
            this.a = b.START_DEFINITION;
            return iJ;
        }
        this.g = (char) 0;
        char cCharAt = charSequence.charAt(iJ);
        if (cCharAt == '\"' || cCharAt == '\'') {
            this.g = cCharAt;
        } else if (cCharAt == '(') {
            this.g = ')';
        }
        if (this.g != 0) {
            this.a = b.TITLE;
            this.h = new StringBuilder();
            iJ++;
            if (iJ == charSequence.length()) {
                this.h.append('\n');
            }
        } else {
            b();
            this.a = b.START_DEFINITION;
        }
        return iJ;
    }

    private int i(CharSequence charSequence, int i) {
        int iE = AbstractC24767zA3.e(charSequence, i, this.g);
        if (iE == -1) {
            return -1;
        }
        this.h.append(charSequence.subSequence(i, iE));
        if (iE >= charSequence.length()) {
            this.h.append('\n');
            return iE;
        }
        int iJ = OW4.j(charSequence, iE + 1, charSequence.length());
        if (iJ != charSequence.length()) {
            return -1;
        }
        this.i = true;
        b();
        this.b.setLength(0);
        this.a = b.START_DEFINITION;
        return iJ;
    }

    List c() {
        b();
        return this.c;
    }

    CharSequence d() {
        return this.b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[LOOP:0: B:6:0x0015->B:23:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.lang.CharSequence r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = r3.b
            int r0 = r0.length()
            if (r0 == 0) goto Lf
            java.lang.StringBuilder r0 = r3.b
            r1 = 10
            r0.append(r1)
        Lf:
            java.lang.StringBuilder r0 = r3.b
            r0.append(r4)
            r0 = 0
        L15:
            int r1 = r4.length()
            if (r0 >= r1) goto L48
            int[] r1 = ir.nasim.C22997wA3.a.a
            ir.nasim.wA3$b r2 = r3.a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L48;
                case 2: goto L3d;
                case 3: goto L38;
                case 4: goto L33;
                case 5: goto L2e;
                case 6: goto L29;
                default: goto L28;
            }
        L28:
            goto L41
        L29:
            int r0 = r3.i(r4, r0)
            goto L41
        L2e:
            int r0 = r3.h(r4, r0)
            goto L41
        L33:
            int r0 = r3.a(r4, r0)
            goto L41
        L38:
            int r0 = r3.e(r4, r0)
            goto L41
        L3d:
            int r0 = r3.g(r4, r0)
        L41:
            r1 = -1
            if (r0 != r1) goto L15
            ir.nasim.wA3$b r4 = ir.nasim.C22997wA3.b.PARAGRAPH
            r3.a = r4
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22997wA3.f(java.lang.CharSequence):void");
    }
}
