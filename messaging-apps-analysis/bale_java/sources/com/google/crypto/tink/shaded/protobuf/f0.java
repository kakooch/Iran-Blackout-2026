package com.google.crypto.tink.shaded.protobuf;

import android.gov.nist.javax.sip.parser.TokenNames;

/* loaded from: classes3.dex */
public abstract class f0 {
    static final int a = c(1, 3);
    static final int b = c(1, 4);
    static final int c = c(2, 0);
    static final int d = c(3, 2);

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
                super(str, i, cVar, i2);
            }
        }

        /* renamed from: com.google.crypto.tink.shaded.protobuf.f0$b$b, reason: collision with other inner class name */
        enum C0196b extends b {
            C0196b(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2);
            }
        }

        enum c extends b {
            c(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2);
            }
        }

        enum d extends b {
            d(String str, int i, c cVar, int i2) {
                super(str, i, cVar, i2);
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
            C0196b c0196b = new C0196b("GROUP", 9, cVar3, 3);
            l = c0196b;
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
            u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0196b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) u.clone();
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
        BYTE_STRING(AbstractC2345g.b),
        ENUM(null),
        MESSAGE(null);

        private final Object a;

        c(Object obj) {
            this.a = obj;
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
}
