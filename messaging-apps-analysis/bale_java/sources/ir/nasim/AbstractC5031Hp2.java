package ir.nasim;

import ir.nasim.C6526Nw5;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* renamed from: ir.nasim.Hp2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5031Hp2 {
    public static final b A;
    public static final b B;
    public static final b C;
    public static final b D;
    public static final b E;
    public static final b F;
    public static final b G;
    public static final b H;
    public static final b I;
    public static final b J;
    public static final b K;
    public static final b L;
    public static final b M;
    public static final b N;
    public static final b a = d.c();
    public static final b b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final d n;
    public static final b o;
    public static final b p;
    public static final b q;
    public static final b r;
    public static final b s;
    public static final b t;
    public static final b u;
    public static final b v;
    public static final b w;
    public static final b x;
    public static final b y;
    public static final b z;

    /* renamed from: ir.nasim.Hp2$b */
    public static class b extends d {
        public b(int i) {
            super(i, 1);
        }

        @Override // ir.nasim.AbstractC5031Hp2.d
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i) {
            return Boolean.valueOf((i & (1 << this.a)) != 0);
        }

        @Override // ir.nasim.AbstractC5031Hp2.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* renamed from: ir.nasim.Hp2$c */
    private static class c extends d {
        private final i.a[] c;

        public c(int i, i.a[] aVarArr) {
            super(i, g(aVarArr));
            this.c = aVarArr;
        }

        private static /* synthetic */ void f(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static int g(Object[] objArr) {
            if (objArr == null) {
                f(0);
            }
            int length = objArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    return i + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + objArr.getClass());
        }

        @Override // ir.nasim.AbstractC5031Hp2.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public i.a d(int i) {
            int i2 = (1 << this.b) - 1;
            int i3 = this.a;
            int i4 = (i & (i2 << i3)) >> i3;
            for (i.a aVar : this.c) {
                if (aVar.getNumber() == i4) {
                    return aVar;
                }
            }
            return null;
        }

        @Override // ir.nasim.AbstractC5031Hp2.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(i.a aVar) {
            return aVar.getNumber() << this.a;
        }
    }

    /* renamed from: ir.nasim.Hp2$d */
    public static abstract class d {
        public final int a;
        public final int b;

        public static d a(d dVar, i.a[] aVarArr) {
            return new c(dVar.a + dVar.b, aVarArr);
        }

        public static b b(d dVar) {
            return new b(dVar.a + dVar.b);
        }

        public static b c() {
            return new b(0);
        }

        public abstract Object d(int i);

        public abstract int e(Object obj);

        private d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    static {
        b bVarC = d.c();
        b = bVarC;
        d dVarA = d.a(bVarC, EnumC15071ix5.values());
        c = dVarA;
        d dVarA2 = d.a(dVarA, EnumC8418Vw5.values());
        d = dVarA2;
        d dVarA3 = d.a(dVarA2, C6526Nw5.c.values());
        e = dVarA3;
        b bVarB = d.b(dVarA3);
        f = bVarB;
        b bVarB2 = d.b(bVarB);
        g = bVarB2;
        b bVarB3 = d.b(bVarB2);
        h = bVarB3;
        b bVarB4 = d.b(bVarB3);
        i = bVarB4;
        b bVarB5 = d.b(bVarB4);
        j = bVarB5;
        k = d.b(bVarB5);
        b bVarB6 = d.b(dVarA);
        l = bVarB6;
        m = d.b(bVarB6);
        d dVarA4 = d.a(dVarA2, EnumC8184Uw5.values());
        n = dVarA4;
        b bVarB7 = d.b(dVarA4);
        o = bVarB7;
        b bVarB8 = d.b(bVarB7);
        p = bVarB8;
        b bVarB9 = d.b(bVarB8);
        q = bVarB9;
        b bVarB10 = d.b(bVarB9);
        r = bVarB10;
        b bVarB11 = d.b(bVarB10);
        s = bVarB11;
        b bVarB12 = d.b(bVarB11);
        t = bVarB12;
        b bVarB13 = d.b(bVarB12);
        u = bVarB13;
        v = d.b(bVarB13);
        b bVarB14 = d.b(dVarA4);
        w = bVarB14;
        b bVarB15 = d.b(bVarB14);
        x = bVarB15;
        b bVarB16 = d.b(bVarB15);
        y = bVarB16;
        b bVarB17 = d.b(bVarB16);
        z = bVarB17;
        b bVarB18 = d.b(bVarB17);
        A = bVarB18;
        b bVarB19 = d.b(bVarB18);
        B = bVarB19;
        b bVarB20 = d.b(bVarB19);
        C = bVarB20;
        b bVarB21 = d.b(bVarB20);
        D = bVarB21;
        E = d.b(bVarB21);
        b bVarB22 = d.b(bVarC);
        F = bVarB22;
        b bVarB23 = d.b(bVarB22);
        G = bVarB23;
        H = d.b(bVarB23);
        b bVarB24 = d.b(dVarA2);
        I = bVarB24;
        b bVarB25 = d.b(bVarB24);
        J = bVarB25;
        K = d.b(bVarB25);
        b bVarC2 = d.c();
        L = bVarC2;
        M = d.b(bVarC2);
        N = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 1
            r2 = 0
            r3 = 2
            if (r5 == r1) goto L2b
            if (r5 == r3) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r2] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r2] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r2] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r2] = r4
        L2f:
            java.lang.String r2 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r1] = r2
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r3] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r3] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r3] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r3] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r3] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5031Hp2.a(int):void");
    }

    public static int b(boolean z2, EnumC15071ix5 enumC15071ix5, EnumC8418Vw5 enumC8418Vw5, boolean z3, boolean z4, boolean z5) {
        if (enumC15071ix5 == null) {
            a(10);
        }
        if (enumC8418Vw5 == null) {
            a(11);
        }
        return b.e(Boolean.valueOf(z2)) | d.e(enumC8418Vw5) | c.e(enumC15071ix5) | I.e(Boolean.valueOf(z3)) | J.e(Boolean.valueOf(z4)) | K.e(Boolean.valueOf(z5));
    }
}
