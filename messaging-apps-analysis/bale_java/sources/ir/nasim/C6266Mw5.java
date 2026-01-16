package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Mw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6266Mw5 extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
    private static final C6266Mw5 h;
    public static LW4 i = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
    private int c;
    private int d;
    private List e;
    private byte f;
    private int g;

    /* renamed from: ir.nasim.Mw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C6266Mw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C6266Mw5(eVar, fVar);
        }
    }

    /* renamed from: ir.nasim.Mw5$b */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
        private static final b h;
        public static LW4 i = new a();
        private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
        private int c;
        private int d;
        private c e;
        private byte f;
        private int g;

        /* renamed from: ir.nasim.Mw5$b$a */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
            a() {
            }

            @Override // ir.nasim.LW4
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public b b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new b(eVar, fVar);
            }
        }

        static {
            b bVar = new b(true);
            h = bVar;
            bVar.D();
        }

        private void D() {
            this.d = 0;
            this.e = c.P();
        }

        public static C0526b E() {
            return C0526b.m();
        }

        public static C0526b F(b bVar) {
            return E().e(bVar);
        }

        public static b u() {
            return h;
        }

        public boolean C() {
            return (this.c & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public C0526b newBuilderForType() {
            return E();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public C0526b toBuilder() {
            return F(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public void b(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.Z(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.c0(2, this.e);
            }
            codedOutputStream.h0(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public int getSerializedSize() {
            int i2 = this.g;
            if (i2 != -1) {
                return i2;
            }
            int iO = (this.c & 1) == 1 ? CodedOutputStream.o(1, this.d) : 0;
            if ((this.c & 2) == 2) {
                iO += CodedOutputStream.r(2, this.e);
            }
            int size = iO + this.b.size();
            this.g = size;
            return size;
        }

        @Override // ir.nasim.V64
        public final boolean isInitialized() {
            byte b = this.f;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!z()) {
                this.f = (byte) 0;
                return false;
            }
            if (!C()) {
                this.f = (byte) 0;
                return false;
            }
            if (y().isInitialized()) {
                this.f = (byte) 1;
                return true;
            }
            this.f = (byte) 0;
            return false;
        }

        public int w() {
            return this.d;
        }

        public c y() {
            return this.e;
        }

        public boolean z() {
            return (this.c & 1) == 1;
        }

        /* renamed from: ir.nasim.Mw5$b$c */
        public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
            private static final c q;
            public static LW4 r = new a();
            private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
            private int c;
            private EnumC0528c d;
            private long e;
            private float f;
            private double g;
            private int h;
            private int i;
            private int j;
            private C6266Mw5 k;
            private List l;
            private int m;
            private int n;
            private byte o;
            private int p;

            /* renamed from: ir.nasim.Mw5$b$c$a */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
                a() {
                }

                @Override // ir.nasim.LW4
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public c b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                    return new c(eVar, fVar);
                }
            }

            /* renamed from: ir.nasim.Mw5$b$c$c, reason: collision with other inner class name */
            public enum EnumC0528c implements i.a {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);

                private static i.b o = new a();
                private final int a;

                /* renamed from: ir.nasim.Mw5$b$c$c$a */
                static class a implements i.b {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0528c a(int i) {
                        return EnumC0528c.a(i);
                    }
                }

                EnumC0528c(int i, int i2) {
                    this.a = i2;
                }

                public static EnumC0528c a(int i) {
                    switch (i) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
                public final int getNumber() {
                    return this.a;
                }
            }

            static {
                c cVar = new c(true);
                q = cVar;
                cVar.i0();
            }

            public static c P() {
                return q;
            }

            private void i0() {
                this.d = EnumC0528c.BYTE;
                this.e = 0L;
                this.f = 0.0f;
                this.g = 0.0d;
                this.h = 0;
                this.i = 0;
                this.j = 0;
                this.k = C6266Mw5.C();
                this.l = Collections.emptyList();
                this.m = 0;
                this.n = 0;
            }

            public static C0527b j0() {
                return C0527b.m();
            }

            public static C0527b k0(c cVar) {
                return j0().e(cVar);
            }

            public C6266Mw5 J() {
                return this.k;
            }

            public int K() {
                return this.m;
            }

            public c L(int i) {
                return (c) this.l.get(i);
            }

            public int M() {
                return this.l.size();
            }

            public List N() {
                return this.l;
            }

            public int O() {
                return this.i;
            }

            public double Q() {
                return this.g;
            }

            public int R() {
                return this.j;
            }

            public int S() {
                return this.n;
            }

            public float T() {
                return this.f;
            }

            public long U() {
                return this.e;
            }

            public int V() {
                return this.h;
            }

            public EnumC0528c W() {
                return this.d;
            }

            public boolean X() {
                return (this.c & 128) == 128;
            }

            public boolean Y() {
                return (this.c & 256) == 256;
            }

            public boolean Z() {
                return (this.c & 32) == 32;
            }

            public boolean a0() {
                return (this.c & 8) == 8;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
            public void b(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.c & 1) == 1) {
                    codedOutputStream.R(1, this.d.getNumber());
                }
                if ((this.c & 2) == 2) {
                    codedOutputStream.s0(2, this.e);
                }
                if ((this.c & 4) == 4) {
                    codedOutputStream.V(3, this.f);
                }
                if ((this.c & 8) == 8) {
                    codedOutputStream.P(4, this.g);
                }
                if ((this.c & 16) == 16) {
                    codedOutputStream.Z(5, this.h);
                }
                if ((this.c & 32) == 32) {
                    codedOutputStream.Z(6, this.i);
                }
                if ((this.c & 64) == 64) {
                    codedOutputStream.Z(7, this.j);
                }
                if ((this.c & 128) == 128) {
                    codedOutputStream.c0(8, this.k);
                }
                for (int i = 0; i < this.l.size(); i++) {
                    codedOutputStream.c0(9, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.l.get(i));
                }
                if ((this.c & 512) == 512) {
                    codedOutputStream.Z(10, this.n);
                }
                if ((this.c & 256) == 256) {
                    codedOutputStream.Z(11, this.m);
                }
                codedOutputStream.h0(this.b);
            }

            public boolean b0() {
                return (this.c & 64) == 64;
            }

            public boolean c0() {
                return (this.c & 512) == 512;
            }

            public boolean e0() {
                return (this.c & 4) == 4;
            }

            public boolean f0() {
                return (this.c & 2) == 2;
            }

            public boolean g0() {
                return (this.c & 16) == 16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
            public int getSerializedSize() {
                int i = this.p;
                if (i != -1) {
                    return i;
                }
                int iH = (this.c & 1) == 1 ? CodedOutputStream.h(1, this.d.getNumber()) : 0;
                if ((this.c & 2) == 2) {
                    iH += CodedOutputStream.z(2, this.e);
                }
                if ((this.c & 4) == 4) {
                    iH += CodedOutputStream.l(3, this.f);
                }
                if ((this.c & 8) == 8) {
                    iH += CodedOutputStream.f(4, this.g);
                }
                if ((this.c & 16) == 16) {
                    iH += CodedOutputStream.o(5, this.h);
                }
                if ((this.c & 32) == 32) {
                    iH += CodedOutputStream.o(6, this.i);
                }
                if ((this.c & 64) == 64) {
                    iH += CodedOutputStream.o(7, this.j);
                }
                if ((this.c & 128) == 128) {
                    iH += CodedOutputStream.r(8, this.k);
                }
                for (int i2 = 0; i2 < this.l.size(); i2++) {
                    iH += CodedOutputStream.r(9, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.l.get(i2));
                }
                if ((this.c & 512) == 512) {
                    iH += CodedOutputStream.o(10, this.n);
                }
                if ((this.c & 256) == 256) {
                    iH += CodedOutputStream.o(11, this.m);
                }
                int size = iH + this.b.size();
                this.p = size;
                return size;
            }

            public boolean h0() {
                return (this.c & 1) == 1;
            }

            @Override // ir.nasim.V64
            public final boolean isInitialized() {
                byte b = this.o;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                if (X() && !J().isInitialized()) {
                    this.o = (byte) 0;
                    return false;
                }
                for (int i = 0; i < M(); i++) {
                    if (!L(i).isInitialized()) {
                        this.o = (byte) 0;
                        return false;
                    }
                }
                this.o = (byte) 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
            /* renamed from: l0, reason: merged with bridge method [inline-methods] */
            public C0527b newBuilderForType() {
                return j0();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
            /* renamed from: m0, reason: merged with bridge method [inline-methods] */
            public C0527b toBuilder() {
                return k0(this);
            }

            private c(h.b bVar) {
                super(bVar);
                this.o = (byte) -1;
                this.p = -1;
                this.b = bVar.d();
            }

            private c(boolean z) {
                this.o = (byte) -1;
                this.p = -1;
                this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
            private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                this.o = (byte) -1;
                this.p = -1;
                i0();
                d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
                CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
                boolean z = false;
                char c = 0;
                while (true) {
                    ?? M = 256;
                    if (!z) {
                        try {
                            try {
                                int iJ = eVar.J();
                                switch (iJ) {
                                    case 0:
                                        z = true;
                                    case 8:
                                        int iM = eVar.m();
                                        EnumC0528c enumC0528cA = EnumC0528c.a(iM);
                                        if (enumC0528cA == null) {
                                            codedOutputStreamI.n0(iJ);
                                            codedOutputStreamI.n0(iM);
                                        } else {
                                            this.c |= 1;
                                            this.d = enumC0528cA;
                                        }
                                    case 16:
                                        this.c |= 2;
                                        this.e = eVar.G();
                                    case 29:
                                        this.c |= 4;
                                        this.f = eVar.p();
                                    case 33:
                                        this.c |= 8;
                                        this.g = eVar.l();
                                    case 40:
                                        this.c |= 16;
                                        this.h = eVar.r();
                                    case 48:
                                        this.c |= 32;
                                        this.i = eVar.r();
                                    case Type.NINFO /* 56 */:
                                        this.c |= 64;
                                        this.j = eVar.r();
                                    case WKSRecord.Protocol.RVD /* 66 */:
                                        c builder = (this.c & 128) == 128 ? this.k.toBuilder() : null;
                                        C6266Mw5 c6266Mw5 = (C6266Mw5) eVar.t(C6266Mw5.i, fVar);
                                        this.k = c6266Mw5;
                                        if (builder != null) {
                                            builder.e(c6266Mw5);
                                            this.k = builder.k();
                                        }
                                        this.c |= 128;
                                    case 74:
                                        if ((c & 256) != 256) {
                                            this.l = new ArrayList();
                                            c = 256;
                                        }
                                        this.l.add(eVar.t(r, fVar));
                                    case 80:
                                        this.c |= 512;
                                        this.n = eVar.r();
                                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CONTACTS_FIELD_NUMBER /* 88 */:
                                        this.c |= 256;
                                        this.m = eVar.r();
                                    default:
                                        M = m(eVar, codedOutputStreamI, fVar, iJ);
                                        if (M == 0) {
                                            z = true;
                                        }
                                }
                            } catch (Throwable th) {
                                if ((c & 256) == M) {
                                    this.l = Collections.unmodifiableList(this.l);
                                }
                                try {
                                    codedOutputStreamI.H();
                                } catch (IOException unused) {
                                } catch (Throwable th2) {
                                    this.b = bVarB.e();
                                    throw th2;
                                }
                                this.b = bVarB.e();
                                j();
                                throw th;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.k(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
                        }
                    } else {
                        if ((c & 256) == 256) {
                            this.l = Collections.unmodifiableList(this.l);
                        }
                        try {
                            codedOutputStreamI.H();
                        } catch (IOException unused2) {
                        } catch (Throwable th3) {
                            this.b = bVarB.e();
                            throw th3;
                        }
                        this.b = bVarB.e();
                        j();
                        return;
                    }
                }
            }

            /* renamed from: ir.nasim.Mw5$b$c$b, reason: collision with other inner class name */
            public static final class C0527b extends h.b implements V64 {
                private int b;
                private long d;
                private float e;
                private double f;
                private int g;
                private int h;
                private int i;
                private int l;
                private int m;
                private EnumC0528c c = EnumC0528c.BYTE;
                private C6266Mw5 j = C6266Mw5.C();
                private List k = Collections.emptyList();

                private C0527b() {
                    o();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static C0527b m() {
                    return new C0527b();
                }

                private void n() {
                    if ((this.b & 256) != 256) {
                        this.k = new ArrayList(this.k);
                        this.b |= 256;
                    }
                }

                public C0527b A(EnumC0528c enumC0528c) {
                    enumC0528c.getClass();
                    this.b |= 1;
                    this.c = enumC0528c;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public c a() {
                    c cVarK = k();
                    if (cVarK.isInitialized()) {
                        return cVarK;
                    }
                    throw a.AbstractC1828a.c(cVarK);
                }

                public c k() {
                    c cVar = new c(this);
                    int i = this.b;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    cVar.d = this.c;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    cVar.e = this.d;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    cVar.f = this.e;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    cVar.g = this.f;
                    if ((i & 16) == 16) {
                        i2 |= 16;
                    }
                    cVar.h = this.g;
                    if ((i & 32) == 32) {
                        i2 |= 32;
                    }
                    cVar.i = this.h;
                    if ((i & 64) == 64) {
                        i2 |= 64;
                    }
                    cVar.j = this.i;
                    if ((i & 128) == 128) {
                        i2 |= 128;
                    }
                    cVar.k = this.j;
                    if ((this.b & 256) == 256) {
                        this.k = Collections.unmodifiableList(this.k);
                        this.b &= -257;
                    }
                    cVar.l = this.k;
                    if ((i & 512) == 512) {
                        i2 |= 256;
                    }
                    cVar.m = this.l;
                    if ((i & 1024) == 1024) {
                        i2 |= 512;
                    }
                    cVar.n = this.m;
                    cVar.c = i2;
                    return cVar;
                }

                /* renamed from: l, reason: merged with bridge method [inline-methods] */
                public C0527b clone() {
                    return m().e(k());
                }

                public C0527b p(C6266Mw5 c6266Mw5) {
                    if ((this.b & 128) != 128 || this.j == C6266Mw5.C()) {
                        this.j = c6266Mw5;
                    } else {
                        this.j = C6266Mw5.H(this.j).e(c6266Mw5).k();
                    }
                    this.b |= 128;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public C0527b e(c cVar) {
                    if (cVar == c.P()) {
                        return this;
                    }
                    if (cVar.h0()) {
                        A(cVar.W());
                    }
                    if (cVar.f0()) {
                        y(cVar.U());
                    }
                    if (cVar.e0()) {
                        x(cVar.T());
                    }
                    if (cVar.a0()) {
                        u(cVar.Q());
                    }
                    if (cVar.g0()) {
                        z(cVar.V());
                    }
                    if (cVar.Z()) {
                        t(cVar.O());
                    }
                    if (cVar.b0()) {
                        v(cVar.R());
                    }
                    if (cVar.X()) {
                        p(cVar.J());
                    }
                    if (!cVar.l.isEmpty()) {
                        if (this.k.isEmpty()) {
                            this.k = cVar.l;
                            this.b &= -257;
                        } else {
                            n();
                            this.k.addAll(cVar.l);
                        }
                    }
                    if (cVar.Y()) {
                        s(cVar.K());
                    }
                    if (cVar.c0()) {
                        w(cVar.S());
                    }
                    f(d().h(cVar.b));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public ir.nasim.C6266Mw5.b.c.C0527b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        ir.nasim.LW4 r1 = ir.nasim.C6266Mw5.b.c.r     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        ir.nasim.Mw5$b$c r3 = (ir.nasim.C6266Mw5.b.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.e(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1b
                    L11:
                        r3 = move-exception
                        kotlin.reflect.jvm.internal.impl.protobuf.l r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                        ir.nasim.Mw5$b$c r4 = (ir.nasim.C6266Mw5.b.c) r4     // Catch: java.lang.Throwable -> Lf
                        throw r3     // Catch: java.lang.Throwable -> L19
                    L19:
                        r3 = move-exception
                        r0 = r4
                    L1b:
                        if (r0 == 0) goto L20
                        r2.e(r0)
                    L20:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6266Mw5.b.c.C0527b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Mw5$b$c$b");
                }

                public C0527b s(int i) {
                    this.b |= 512;
                    this.l = i;
                    return this;
                }

                public C0527b t(int i) {
                    this.b |= 32;
                    this.h = i;
                    return this;
                }

                public C0527b u(double d) {
                    this.b |= 8;
                    this.f = d;
                    return this;
                }

                public C0527b v(int i) {
                    this.b |= 64;
                    this.i = i;
                    return this;
                }

                public C0527b w(int i) {
                    this.b |= 1024;
                    this.m = i;
                    return this;
                }

                public C0527b x(float f) {
                    this.b |= 4;
                    this.e = f;
                    return this;
                }

                public C0527b y(long j) {
                    this.b |= 2;
                    this.d = j;
                    return this;
                }

                public C0527b z(int i) {
                    this.b |= 16;
                    this.g = i;
                    return this;
                }

                private void o() {
                }
            }
        }

        private b(h.b bVar) {
            super(bVar);
            this.f = (byte) -1;
            this.g = -1;
            this.b = bVar.d();
        }

        private b(boolean z) {
            this.f = (byte) -1;
            this.g = -1;
            this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
        }

        private b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            this.f = (byte) -1;
            this.g = -1;
            D();
            d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
            CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.c |= 1;
                                this.d = eVar.r();
                            } else if (iJ != 18) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                c.C0527b builder = (this.c & 2) == 2 ? this.e.toBuilder() : null;
                                c cVar = (c) eVar.t(c.r, fVar);
                                this.e = cVar;
                                if (builder != null) {
                                    builder.e(cVar);
                                    this.e = builder.k();
                                }
                                this.c |= 2;
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
                        try {
                            codedOutputStreamI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.b = bVarB.e();
                            throw th2;
                        }
                        this.b = bVarB.e();
                        j();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.k(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
                }
            }
            try {
                codedOutputStreamI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = bVarB.e();
                throw th3;
            }
            this.b = bVarB.e();
            j();
        }

        /* renamed from: ir.nasim.Mw5$b$b, reason: collision with other inner class name */
        public static final class C0526b extends h.b implements V64 {
            private int b;
            private int c;
            private c d = c.P();

            private C0526b() {
                n();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0526b m() {
                return new C0526b();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public b a() {
                b bVarK = k();
                if (bVarK.isInitialized()) {
                    return bVarK;
                }
                throw a.AbstractC1828a.c(bVarK);
            }

            public b k() {
                b bVar = new b(this);
                int i = this.b;
                int i2 = (i & 1) != 1 ? 0 : 1;
                bVar.d = this.c;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bVar.e = this.d;
                bVar.c = i2;
                return bVar;
            }

            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public C0526b clone() {
                return m().e(k());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public C0526b e(b bVar) {
                if (bVar == b.u()) {
                    return this;
                }
                if (bVar.z()) {
                    r(bVar.w());
                }
                if (bVar.C()) {
                    q(bVar.y());
                }
                f(d().h(bVar.b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ir.nasim.C6266Mw5.b.C0526b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ir.nasim.LW4 r1 = ir.nasim.C6266Mw5.b.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    ir.nasim.Mw5$b r3 = (ir.nasim.C6266Mw5.b) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.e(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.l r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    ir.nasim.Mw5$b r4 = (ir.nasim.C6266Mw5.b) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.e(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6266Mw5.b.C0526b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Mw5$b$b");
            }

            public C0526b q(c cVar) {
                if ((this.b & 2) != 2 || this.d == c.P()) {
                    this.d = cVar;
                } else {
                    this.d = c.k0(this.d).e(cVar).k();
                }
                this.b |= 2;
                return this;
            }

            public C0526b r(int i) {
                this.b |= 1;
                this.c = i;
                return this;
            }

            private void n() {
            }
        }
    }

    static {
        C6266Mw5 c6266Mw5 = new C6266Mw5(true);
        h = c6266Mw5;
        c6266Mw5.F();
    }

    public static C6266Mw5 C() {
        return h;
    }

    private void F() {
        this.d = 0;
        this.e = Collections.emptyList();
    }

    public static c G() {
        return c.m();
    }

    public static c H(C6266Mw5 c6266Mw5) {
        return G().e(c6266Mw5);
    }

    public int D() {
        return this.d;
    }

    public boolean E() {
        return (this.c & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public c newBuilderForType() {
        return G();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public c toBuilder() {
        return H(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.c & 1) == 1) {
            codedOutputStream.Z(1, this.d);
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            codedOutputStream.c0(2, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.get(i2));
        }
        codedOutputStream.h0(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i2 = this.g;
        if (i2 != -1) {
            return i2;
        }
        int iO = (this.c & 1) == 1 ? CodedOutputStream.o(1, this.d) : 0;
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            iO += CodedOutputStream.r(2, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.get(i3));
        }
        int size = iO + this.b.size();
        this.g = size;
        return size;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.f;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!E()) {
            this.f = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < y(); i2++) {
            if (!w(i2).isInitialized()) {
                this.f = (byte) 0;
                return false;
            }
        }
        this.f = (byte) 1;
        return true;
    }

    public b w(int i2) {
        return (b) this.e.get(i2);
    }

    public int y() {
        return this.e.size();
    }

    public List z() {
        return this.e;
    }

    private C6266Mw5(h.b bVar) {
        super(bVar);
        this.f = (byte) -1;
        this.g = -1;
        this.b = bVar.d();
    }

    private C6266Mw5(boolean z) {
        this.f = (byte) -1;
        this.g = -1;
        this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C6266Mw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.f = (byte) -1;
        this.g = -1;
        F();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        char c2 = 0;
        while (!z) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.c |= 1;
                            this.d = eVar.r();
                        } else if (iJ != 18) {
                            if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                            }
                        } else {
                            if ((c2 & 2) != 2) {
                                this.e = new ArrayList();
                                c2 = 2;
                            }
                            this.e.add(eVar.t(b.i, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if ((c2 & 2) == 2) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    try {
                        codedOutputStreamI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = bVarB.e();
                        throw th2;
                    }
                    this.b = bVarB.e();
                    j();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.k(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
            }
        }
        if ((c2 & 2) == 2) {
            this.e = Collections.unmodifiableList(this.e);
        }
        try {
            codedOutputStreamI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.b = bVarB.e();
            throw th3;
        }
        this.b = bVarB.e();
        j();
    }

    /* renamed from: ir.nasim.Mw5$c */
    public static final class c extends h.b implements V64 {
        private int b;
        private int c;
        private List d = Collections.emptyList();

        private c() {
            o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c m() {
            return new c();
        }

        private void n() {
            if ((this.b & 2) != 2) {
                this.d = new ArrayList(this.d);
                this.b |= 2;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public C6266Mw5 a() {
            C6266Mw5 c6266Mw5K = k();
            if (c6266Mw5K.isInitialized()) {
                return c6266Mw5K;
            }
            throw a.AbstractC1828a.c(c6266Mw5K);
        }

        public C6266Mw5 k() {
            C6266Mw5 c6266Mw5 = new C6266Mw5(this);
            int i = (this.b & 1) != 1 ? 0 : 1;
            c6266Mw5.d = this.c;
            if ((this.b & 2) == 2) {
                this.d = Collections.unmodifiableList(this.d);
                this.b &= -3;
            }
            c6266Mw5.e = this.d;
            c6266Mw5.c = i;
            return c6266Mw5;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public c clone() {
            return m().e(k());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public c e(C6266Mw5 c6266Mw5) {
            if (c6266Mw5 == C6266Mw5.C()) {
                return this;
            }
            if (c6266Mw5.E()) {
                r(c6266Mw5.D());
            }
            if (!c6266Mw5.e.isEmpty()) {
                if (this.d.isEmpty()) {
                    this.d = c6266Mw5.e;
                    this.b &= -3;
                } else {
                    n();
                    this.d.addAll(c6266Mw5.e);
                }
            }
            f(d().h(c6266Mw5.b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C6266Mw5.c d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C6266Mw5.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Mw5 r3 = (ir.nasim.C6266Mw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                if (r3 == 0) goto Le
                r2.e(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.l r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                ir.nasim.Mw5 r4 = (ir.nasim.C6266Mw5) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.e(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6266Mw5.c.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Mw5$c");
        }

        public c r(int i) {
            this.b |= 1;
            this.c = i;
            return this;
        }

        private void o() {
        }
    }
}
