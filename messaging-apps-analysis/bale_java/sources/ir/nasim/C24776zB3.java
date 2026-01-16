package ir.nasim;

/* renamed from: ir.nasim.zB3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C24776zB3 extends B0 {
    private final AbstractC24186yB3 a;
    private boolean b;
    private int c;

    /* renamed from: ir.nasim.zB3$a */
    public static class a extends C0 {
        @Override // ir.nasim.InterfaceC16089kh0
        public AbstractC17271mh0 a(NW4 nw4, PU3 pu3) {
            InterfaceC15498jh0 interfaceC15498jh0B = pu3.b();
            if (nw4.a() >= OW4.a) {
                return AbstractC17271mh0.b();
            }
            b bVarN = C24776zB3.n(nw4.d(), nw4.e(), nw4.b() + nw4.a(), pu3.a() != null);
            if (bVarN == null) {
                return AbstractC17271mh0.b();
            }
            int i = bVarN.b;
            OB3 ob3 = new OB3(i - nw4.b());
            if ((interfaceC15498jh0B instanceof C24776zB3) && C24776zB3.m((AbstractC24186yB3) interfaceC15498jh0B.f(), bVarN.a)) {
                return AbstractC17271mh0.c(ob3).a(i);
            }
            C24776zB3 c24776zB3 = new C24776zB3(bVarN.a);
            bVarN.a.o(true);
            return AbstractC17271mh0.c(c24776zB3, ob3).a(i);
        }
    }

    /* renamed from: ir.nasim.zB3$b */
    private static class b {
        final AbstractC24186yB3 a;
        final int b;

        b(AbstractC24186yB3 abstractC24186yB3, int i) {
            this.a = abstractC24186yB3;
            this.b = i;
        }
    }

    /* renamed from: ir.nasim.zB3$c */
    private static class c {
        final AbstractC24186yB3 a;
        final int b;

        c(AbstractC24186yB3 abstractC24186yB3, int i) {
            this.a = abstractC24186yB3;
            this.b = i;
        }
    }

    public C24776zB3(AbstractC24186yB3 abstractC24186yB3) {
        this.a = abstractC24186yB3;
    }

    private static boolean k(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static boolean l(CharSequence charSequence, int i) {
        char cCharAt;
        return i >= charSequence.length() || (cCharAt = charSequence.charAt(i)) == '\t' || cCharAt == ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(AbstractC24186yB3 abstractC24186yB3, AbstractC24186yB3 abstractC24186yB32) {
        if ((abstractC24186yB3 instanceof PL4) && (abstractC24186yB32 instanceof PL4)) {
            return k(Character.valueOf(((PL4) abstractC24186yB3).p()), Character.valueOf(((PL4) abstractC24186yB32).p()));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b n(CharSequence charSequence, int i, int i2, boolean z) {
        boolean z2;
        c cVarO = o(charSequence, i);
        if (cVarO == null) {
            return null;
        }
        AbstractC24186yB3 abstractC24186yB3 = cVarO.a;
        int i3 = cVarO.b;
        int i4 = i2 + (i3 - i);
        int length = charSequence.length();
        int iA = i4;
        while (true) {
            if (i3 >= length) {
                z2 = false;
                break;
            }
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt != '\t') {
                if (cCharAt != ' ') {
                    z2 = true;
                    break;
                }
                iA++;
            } else {
                iA += OW4.a(iA);
            }
            i3++;
        }
        if (z && (((abstractC24186yB3 instanceof PL4) && ((PL4) abstractC24186yB3).q() != 1) || !z2)) {
            return null;
        }
        if (!z2 || iA - i4 > OW4.a) {
            iA = i4 + 1;
        }
        return new b(abstractC24186yB3, iA);
    }

    private static c o(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == '*' || cCharAt == '+' || cCharAt == '-') {
            return null;
        }
        return p(charSequence, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0009  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.C24776zB3.c p(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = 0
            r2 = r7
        L6:
            r3 = 0
            if (r2 >= r0) goto L4b
            char r4 = r6.charAt(r2)
            r5 = 41
            if (r4 == r5) goto L23
            r5 = 46
            if (r4 == r5) goto L23
            switch(r4) {
                case 48: goto L19;
                case 49: goto L19;
                case 50: goto L19;
                case 51: goto L19;
                case 52: goto L19;
                case 53: goto L19;
                case 54: goto L19;
                case 55: goto L19;
                case 56: goto L19;
                case 57: goto L19;
                default: goto L18;
            }
        L18:
            return r3
        L19:
            int r1 = r1 + 1
            r4 = 9
            if (r1 <= r4) goto L20
            return r3
        L20:
            int r2 = r2 + 1
            goto L6
        L23:
            r0 = 1
            if (r1 < r0) goto L4b
            int r0 = r2 + 1
            boolean r1 = l(r6, r0)
            if (r1 == 0) goto L4b
            java.lang.CharSequence r6 = r6.subSequence(r7, r2)
            java.lang.String r6 = r6.toString()
            ir.nasim.PL4 r7 = new ir.nasim.PL4
            r7.<init>()
            int r6 = java.lang.Integer.parseInt(r6)
            r7.s(r6)
            r7.r(r4)
            ir.nasim.zB3$c r6 = new ir.nasim.zB3$c
            r6.<init>(r7, r0)
            return r6
        L4b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24776zB3.p(java.lang.CharSequence, int):ir.nasim.zB3$c");
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public boolean a(AbstractC10483bh0 abstractC10483bh0) {
        if (!(abstractC10483bh0 instanceof NB3)) {
            return false;
        }
        if (this.b && this.c == 1) {
            this.a.o(false);
            this.b = false;
        }
        return true;
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public boolean b() {
        return true;
    }

    @Override // ir.nasim.InterfaceC15498jh0
    public AbstractC11868dh0 d(NW4 nw4) {
        if (nw4.c()) {
            this.b = true;
            this.c = 0;
        } else if (this.b) {
            this.c++;
        }
        return AbstractC11868dh0.b(nw4.getIndex());
    }

    @Override // ir.nasim.InterfaceC15498jh0
    public AbstractC10483bh0 f() {
        return this.a;
    }
}
