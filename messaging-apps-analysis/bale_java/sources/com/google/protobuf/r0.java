package com.google.protobuf;

import android.gov.nist.javax.sip.parser.TokenNames;

/* loaded from: classes3.dex */
public abstract class r0 {
    static final int a = c(1, 3);
    static final int b = c(1, 4);
    static final int c = c(2, 0);
    static final int d = c(3, 2);

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.n.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[b.o.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[b.q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[b.r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[b.s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[b.t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[b.k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[b.l.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[b.m.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[b.p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class b {
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final b h;
        public static final b i;
        public static final b j;
        public static final b k;
        public static final b l;
        public static final b m;
        public static final b n;
        public static final b o;
        public static final b p;
        public static final b q;
        public static final b r;
        public static final b s;
        public static final b t;
        private static final /* synthetic */ b[] u;
        private final c a;
        private final int b;

        enum a extends b {
            a(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // com.google.protobuf.r0.b
            public boolean p() {
                return false;
            }
        }

        /* renamed from: com.google.protobuf.r0$b$b, reason: collision with other inner class name */
        enum C0207b extends b {
            C0207b(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // com.google.protobuf.r0.b
            public boolean p() {
                return false;
            }
        }

        enum c extends b {
            c(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // com.google.protobuf.r0.b
            public boolean p() {
                return false;
            }
        }

        enum d extends b {
            d(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2, null);
            }

            @Override // com.google.protobuf.r0.b
            public boolean p() {
                return false;
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            g = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            h = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            i = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            j = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            k = aVar;
            c cVar3 = c.MESSAGE;
            C0207b c0207b = new C0207b("GROUP", 9, cVar3, 3);
            l = c0207b;
            c cVar4 = new c(TokenNames.MESSAGE, 10, cVar3, 2);
            m = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            n = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            o = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            r = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            s = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            t = bVar14;
            u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0207b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        /* synthetic */ b(String str, int i2, c cVar, int i3, a aVar) {
            this(str, i2, cVar, i3);
        }

        public static b valueOf(String str) {
            return (b) java.lang.Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) u.clone();
        }

        public c a() {
            return this.a;
        }

        public int j() {
            return this.b;
        }

        public boolean p() {
            return true;
        }

        private b(String str, int i2, c cVar, int i3) {
            this.a = cVar;
            this.b = i3;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(AbstractC2383g.b),
        ENUM(null),
        MESSAGE(null);

        private final Object a;

        c(Object obj) {
            this.a = obj;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class d {
        public static final d a;
        public static final d b;
        public static final d c;
        private static final /* synthetic */ d[] d;

        enum a extends d {
            a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.protobuf.r0.d
            Object a(AbstractC2384h abstractC2384h) {
                return abstractC2384h.H();
            }
        }

        enum b extends d {
            b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.protobuf.r0.d
            Object a(AbstractC2384h abstractC2384h) {
                return abstractC2384h.I();
            }
        }

        enum c extends d {
            c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.protobuf.r0.d
            Object a(AbstractC2384h abstractC2384h) {
                return abstractC2384h.r();
            }
        }

        static {
            a aVar = new a("LOOSE", 0);
            a = aVar;
            b bVar = new b("STRICT", 1);
            b = bVar;
            c cVar = new c("LAZY", 2);
            c = cVar;
            d = new d[]{aVar, bVar, cVar};
        }

        private d(String str, int i) {
        }

        public static d valueOf(String str) {
            return (d) java.lang.Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) d.clone();
        }

        abstract Object a(AbstractC2384h abstractC2384h);

        /* synthetic */ d(String str, int i, a aVar) {
            this(str, i);
        }
    }

    public static int a(int i) {
        return i >>> 3;
    }

    public static int b(int i) {
        return i & 7;
    }

    static int c(int i, int i2) {
        return (i << 3) | i2;
    }

    static Object d(AbstractC2384h abstractC2384h, b bVar, d dVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(abstractC2384h.s());
            case 2:
                return Float.valueOf(abstractC2384h.w());
            case 3:
                return Long.valueOf(abstractC2384h.z());
            case 4:
                return Long.valueOf(abstractC2384h.L());
            case 5:
                return Integer.valueOf(abstractC2384h.y());
            case 6:
                return Long.valueOf(abstractC2384h.v());
            case 7:
                return Integer.valueOf(abstractC2384h.u());
            case 8:
                return Boolean.valueOf(abstractC2384h.q());
            case 9:
                return abstractC2384h.r();
            case 10:
                return Integer.valueOf(abstractC2384h.K());
            case 11:
                return Integer.valueOf(abstractC2384h.D());
            case 12:
                return Long.valueOf(abstractC2384h.E());
            case 13:
                return Integer.valueOf(abstractC2384h.F());
            case 14:
                return Long.valueOf(abstractC2384h.G());
            case 15:
                return dVar.a(abstractC2384h);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
