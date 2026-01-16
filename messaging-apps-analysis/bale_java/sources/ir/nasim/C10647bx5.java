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

/* renamed from: ir.nasim.bx5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10647bx5 extends h.d implements V64 {
    private static final C10647bx5 u;
    public static LW4 v = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private List e;
    private boolean f;
    private int g;
    private C10647bx5 h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private C10647bx5 n;
    private int o;
    private C10647bx5 p;
    private int q;
    private int r;
    private byte s;
    private int t;

    /* renamed from: ir.nasim.bx5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C10647bx5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C10647bx5(eVar, fVar);
        }
    }

    static {
        C10647bx5 c10647bx5 = new C10647bx5(true);
        u = c10647bx5;
        c10647bx5.B0();
    }

    private void B0() {
        this.e = Collections.emptyList();
        this.f = false;
        this.g = 0;
        this.h = b0();
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = b0();
        this.o = 0;
        this.p = b0();
        this.q = 0;
        this.r = 0;
    }

    public static c C0() {
        return c.q();
    }

    public static c D0(C10647bx5 c10647bx5) {
        return C0().e(c10647bx5);
    }

    public static C10647bx5 b0() {
        return u;
    }

    public boolean A0() {
        return (this.d & 64) == 64;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public c newBuilderForType() {
        return C0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public c toBuilder() {
        return D0(this);
    }

    public C10647bx5 V() {
        return this.p;
    }

    public int W() {
        return this.q;
    }

    public b X(int i) {
        return (b) this.e.get(i);
    }

    public int Y() {
        return this.e.size();
    }

    public List Z() {
        return this.e;
    }

    public int a0() {
        return this.j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 4096) == 4096) {
            codedOutputStream.Z(1, this.r);
        }
        for (int i = 0; i < this.e.size(); i++) {
            codedOutputStream.c0(2, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.get(i));
        }
        if ((this.d & 1) == 1) {
            codedOutputStream.K(3, this.f);
        }
        if ((this.d & 2) == 2) {
            codedOutputStream.Z(4, this.g);
        }
        if ((this.d & 4) == 4) {
            codedOutputStream.c0(5, this.h);
        }
        if ((this.d & 16) == 16) {
            codedOutputStream.Z(6, this.j);
        }
        if ((this.d & 32) == 32) {
            codedOutputStream.Z(7, this.k);
        }
        if ((this.d & 8) == 8) {
            codedOutputStream.Z(8, this.i);
        }
        if ((this.d & 64) == 64) {
            codedOutputStream.Z(9, this.l);
        }
        if ((this.d & 256) == 256) {
            codedOutputStream.c0(10, this.n);
        }
        if ((this.d & 512) == 512) {
            codedOutputStream.Z(11, this.o);
        }
        if ((this.d & 128) == 128) {
            codedOutputStream.Z(12, this.m);
        }
        if ((this.d & 1024) == 1024) {
            codedOutputStream.c0(13, this.p);
        }
        if ((this.d & 2048) == 2048) {
            codedOutputStream.Z(14, this.q);
        }
        aVarZ.a(200, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    @Override // ir.nasim.V64
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public C10647bx5 getDefaultInstanceForType() {
        return u;
    }

    public int e0() {
        return this.r;
    }

    public int f0() {
        return this.g;
    }

    public C10647bx5 g0() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.t;
        if (i != -1) {
            return i;
        }
        int iO = (this.d & 4096) == 4096 ? CodedOutputStream.o(1, this.r) : 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            iO += CodedOutputStream.r(2, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.get(i2));
        }
        if ((this.d & 1) == 1) {
            iO += CodedOutputStream.a(3, this.f);
        }
        if ((this.d & 2) == 2) {
            iO += CodedOutputStream.o(4, this.g);
        }
        if ((this.d & 4) == 4) {
            iO += CodedOutputStream.r(5, this.h);
        }
        if ((this.d & 16) == 16) {
            iO += CodedOutputStream.o(6, this.j);
        }
        if ((this.d & 32) == 32) {
            iO += CodedOutputStream.o(7, this.k);
        }
        if ((this.d & 8) == 8) {
            iO += CodedOutputStream.o(8, this.i);
        }
        if ((this.d & 64) == 64) {
            iO += CodedOutputStream.o(9, this.l);
        }
        if ((this.d & 256) == 256) {
            iO += CodedOutputStream.r(10, this.n);
        }
        if ((this.d & 512) == 512) {
            iO += CodedOutputStream.o(11, this.o);
        }
        if ((this.d & 128) == 128) {
            iO += CodedOutputStream.o(12, this.m);
        }
        if ((this.d & 1024) == 1024) {
            iO += CodedOutputStream.r(13, this.p);
        }
        if ((this.d & 2048) == 2048) {
            iO += CodedOutputStream.o(14, this.q);
        }
        int iR = iO + r() + this.c.size();
        this.t = iR;
        return iR;
    }

    public int h0() {
        return this.i;
    }

    public boolean i0() {
        return this.f;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.s;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < Y(); i++) {
            if (!X(i).isInitialized()) {
                this.s = (byte) 0;
                return false;
            }
        }
        if (t0() && !g0().isInitialized()) {
            this.s = (byte) 0;
            return false;
        }
        if (w0() && !j0().isInitialized()) {
            this.s = (byte) 0;
            return false;
        }
        if (o0() && !V().isInitialized()) {
            this.s = (byte) 0;
            return false;
        }
        if (q()) {
            this.s = (byte) 1;
            return true;
        }
        this.s = (byte) 0;
        return false;
    }

    public C10647bx5 j0() {
        return this.n;
    }

    public int k0() {
        return this.o;
    }

    public int l0() {
        return this.m;
    }

    public int m0() {
        return this.k;
    }

    public int n0() {
        return this.l;
    }

    public boolean o0() {
        return (this.d & 1024) == 1024;
    }

    public boolean p0() {
        return (this.d & 2048) == 2048;
    }

    public boolean q0() {
        return (this.d & 16) == 16;
    }

    public boolean r0() {
        return (this.d & 4096) == 4096;
    }

    public boolean s0() {
        return (this.d & 2) == 2;
    }

    public boolean t0() {
        return (this.d & 4) == 4;
    }

    public boolean u0() {
        return (this.d & 8) == 8;
    }

    public boolean v0() {
        return (this.d & 1) == 1;
    }

    public boolean w0() {
        return (this.d & 256) == 256;
    }

    public boolean x0() {
        return (this.d & 512) == 512;
    }

    public boolean y0() {
        return (this.d & 128) == 128;
    }

    public boolean z0() {
        return (this.d & 32) == 32;
    }

    /* renamed from: ir.nasim.bx5$b */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
        private static final b i;
        public static LW4 j = new a();
        private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
        private int c;
        private c d;
        private C10647bx5 e;
        private int f;
        private byte g;
        private int h;

        /* renamed from: ir.nasim.bx5$b$a */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
            a() {
            }

            @Override // ir.nasim.LW4
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public b b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new b(eVar, fVar);
            }
        }

        /* renamed from: ir.nasim.bx5$b$c */
        public enum c implements i.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);

            private static i.b f = new a();
            private final int a;

            /* renamed from: ir.nasim.bx5$b$c$a */
            static class a implements i.b {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public c a(int i) {
                    return c.a(i);
                }
            }

            c(int i, int i2) {
                this.a = i2;
            }

            public static c a(int i) {
                if (i == 0) {
                    return IN;
                }
                if (i == 1) {
                    return OUT;
                }
                if (i == 2) {
                    return INV;
                }
                if (i != 3) {
                    return null;
                }
                return STAR;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
            public final int getNumber() {
                return this.a;
            }
        }

        static {
            b bVar = new b(true);
            i = bVar;
            bVar.G();
        }

        private void G() {
            this.d = c.INV;
            this.e = C10647bx5.b0();
            this.f = 0;
        }

        public static C0925b H() {
            return C0925b.m();
        }

        public static C0925b J(b bVar) {
            return H().e(bVar);
        }

        public static b w() {
            return i;
        }

        public int C() {
            return this.f;
        }

        public boolean D() {
            return (this.c & 1) == 1;
        }

        public boolean E() {
            return (this.c & 2) == 2;
        }

        public boolean F() {
            return (this.c & 4) == 4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public C0925b newBuilderForType() {
            return H();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public C0925b toBuilder() {
            return J(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public void b(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.c & 1) == 1) {
                codedOutputStream.R(1, this.d.getNumber());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.c0(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.Z(3, this.f);
            }
            codedOutputStream.h0(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
        public int getSerializedSize() {
            int i2 = this.h;
            if (i2 != -1) {
                return i2;
            }
            int iH = (this.c & 1) == 1 ? CodedOutputStream.h(1, this.d.getNumber()) : 0;
            if ((this.c & 2) == 2) {
                iH += CodedOutputStream.r(2, this.e);
            }
            if ((this.c & 4) == 4) {
                iH += CodedOutputStream.o(3, this.f);
            }
            int size = iH + this.b.size();
            this.h = size;
            return size;
        }

        @Override // ir.nasim.V64
        public final boolean isInitialized() {
            byte b = this.g;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if (!E() || z().isInitialized()) {
                this.g = (byte) 1;
                return true;
            }
            this.g = (byte) 0;
            return false;
        }

        public c y() {
            return this.d;
        }

        public C10647bx5 z() {
            return this.e;
        }

        private b(h.b bVar) {
            super(bVar);
            this.g = (byte) -1;
            this.h = -1;
            this.b = bVar.d();
        }

        private b(boolean z) {
            this.g = (byte) -1;
            this.h = -1;
            this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
        }

        private b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            this.g = (byte) -1;
            this.h = -1;
            G();
            d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
            CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int iJ = eVar.J();
                            if (iJ != 0) {
                                if (iJ == 8) {
                                    int iM = eVar.m();
                                    c cVarA = c.a(iM);
                                    if (cVarA == null) {
                                        codedOutputStreamI.n0(iJ);
                                        codedOutputStreamI.n0(iM);
                                    } else {
                                        this.c |= 1;
                                        this.d = cVarA;
                                    }
                                } else if (iJ == 18) {
                                    c builder = (this.c & 2) == 2 ? this.e.toBuilder() : null;
                                    C10647bx5 c10647bx5 = (C10647bx5) eVar.t(C10647bx5.v, fVar);
                                    this.e = c10647bx5;
                                    if (builder != null) {
                                        builder.e(c10647bx5);
                                        this.e = builder.o();
                                    }
                                    this.c |= 2;
                                } else if (iJ != 24) {
                                    if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                    }
                                } else {
                                    this.c |= 4;
                                    this.f = eVar.r();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.k(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
                    }
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

        /* renamed from: ir.nasim.bx5$b$b, reason: collision with other inner class name */
        public static final class C0925b extends h.b implements V64 {
            private int b;
            private c c = c.INV;
            private C10647bx5 d = C10647bx5.b0();
            private int e;

            private C0925b() {
                n();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0925b m() {
                return new C0925b();
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
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                bVar.f = this.e;
                bVar.c = i2;
                return bVar;
            }

            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public C0925b clone() {
                return m().e(k());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public C0925b e(b bVar) {
                if (bVar == b.w()) {
                    return this;
                }
                if (bVar.D()) {
                    r(bVar.y());
                }
                if (bVar.E()) {
                    q(bVar.z());
                }
                if (bVar.F()) {
                    s(bVar.C());
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
            public ir.nasim.C10647bx5.b.C0925b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    ir.nasim.LW4 r1 = ir.nasim.C10647bx5.b.j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    ir.nasim.bx5$b r3 = (ir.nasim.C10647bx5.b) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    ir.nasim.bx5$b r4 = (ir.nasim.C10647bx5.b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10647bx5.b.C0925b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.bx5$b$b");
            }

            public C0925b q(C10647bx5 c10647bx5) {
                if ((this.b & 2) != 2 || this.d == C10647bx5.b0()) {
                    this.d = c10647bx5;
                } else {
                    this.d = C10647bx5.D0(this.d).e(c10647bx5).o();
                }
                this.b |= 2;
                return this;
            }

            public C0925b r(c cVar) {
                cVar.getClass();
                this.b |= 1;
                this.c = cVar;
                return this;
            }

            public C0925b s(int i) {
                this.b |= 4;
                this.e = i;
                return this;
            }

            private void n() {
            }
        }
    }

    private C10647bx5(h.c cVar) {
        super(cVar);
        this.s = (byte) -1;
        this.t = -1;
        this.c = cVar.d();
    }

    private C10647bx5(boolean z) {
        this.s = (byte) -1;
        this.t = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C10647bx5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        c builder;
        this.s = (byte) -1;
        this.t = -1;
        B0();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    try {
                        int iJ = eVar.J();
                        switch (iJ) {
                            case 0:
                                z = true;
                            case 8:
                                this.d |= 4096;
                                this.r = eVar.r();
                            case 18:
                                if (!(z2 & true)) {
                                    this.e = new ArrayList();
                                    z2 = true;
                                }
                                this.e.add(eVar.t(b.j, fVar));
                            case 24:
                                this.d |= 1;
                                this.f = eVar.j();
                            case 32:
                                this.d |= 2;
                                this.g = eVar.r();
                            case 42:
                                builder = (this.d & 4) == 4 ? this.h.toBuilder() : null;
                                C10647bx5 c10647bx5 = (C10647bx5) eVar.t(v, fVar);
                                this.h = c10647bx5;
                                if (builder != null) {
                                    builder.e(c10647bx5);
                                    this.h = builder.o();
                                }
                                this.d |= 4;
                            case 48:
                                this.d |= 16;
                                this.j = eVar.r();
                            case Type.NINFO /* 56 */:
                                this.d |= 32;
                                this.k = eVar.r();
                            case 64:
                                this.d |= 8;
                                this.i = eVar.r();
                            case 72:
                                this.d |= 64;
                                this.l = eVar.r();
                            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                                builder = (this.d & 256) == 256 ? this.n.toBuilder() : null;
                                C10647bx5 c10647bx52 = (C10647bx5) eVar.t(v, fVar);
                                this.n = c10647bx52;
                                if (builder != null) {
                                    builder.e(c10647bx52);
                                    this.n = builder.o();
                                }
                                this.d |= 256;
                            case SetRpcStruct$ComposedRpc.RESPONSE_GET_CONTACTS_FIELD_NUMBER /* 88 */:
                                this.d |= 512;
                                this.o = eVar.r();
                            case 96:
                                this.d |= 128;
                                this.m = eVar.r();
                            case Type.L64 /* 106 */:
                                builder = (this.d & 1024) == 1024 ? this.p.toBuilder() : null;
                                C10647bx5 c10647bx53 = (C10647bx5) eVar.t(v, fVar);
                                this.p = c10647bx53;
                                if (builder != null) {
                                    builder.e(c10647bx53);
                                    this.p = builder.o();
                                }
                                this.d |= 1024;
                            case SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER /* 112 */:
                                this.d |= 2048;
                                this.q = eVar.r();
                            default:
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                    z = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.k(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
                }
            } catch (Throwable th) {
                if (z2 & true) {
                    this.e = Collections.unmodifiableList(this.e);
                }
                try {
                    codedOutputStreamI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.c = bVarB.e();
                    throw th2;
                }
                this.c = bVarB.e();
                j();
                throw th;
            }
        }
        if (z2 & true) {
            this.e = Collections.unmodifiableList(this.e);
        }
        try {
            codedOutputStreamI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.c = bVarB.e();
            throw th3;
        }
        this.c = bVarB.e();
        j();
    }

    /* renamed from: ir.nasim.bx5$c */
    public static final class c extends h.c implements V64 {
        private int d;
        private boolean f;
        private int g;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int o;
        private int q;
        private int r;
        private List e = Collections.emptyList();
        private C10647bx5 h = C10647bx5.b0();
        private C10647bx5 n = C10647bx5.b0();
        private C10647bx5 p = C10647bx5.b0();

        private c() {
            s();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c q() {
            return new c();
        }

        private void r() {
            if ((this.d & 1) != 1) {
                this.e = new ArrayList(this.e);
                this.d |= 1;
            }
        }

        public c A(int i) {
            this.d |= 8192;
            this.r = i;
            return this;
        }

        public c B(int i) {
            this.d |= 4;
            this.g = i;
            return this;
        }

        public c C(int i) {
            this.d |= 16;
            this.i = i;
            return this;
        }

        public c D(boolean z) {
            this.d |= 2;
            this.f = z;
            return this;
        }

        public c E(int i) {
            this.d |= 1024;
            this.o = i;
            return this;
        }

        public c F(int i) {
            this.d |= 256;
            this.m = i;
            return this;
        }

        public c G(int i) {
            this.d |= 64;
            this.k = i;
            return this;
        }

        public c H(int i) {
            this.d |= 128;
            this.l = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C10647bx5 a() {
            C10647bx5 c10647bx5O = o();
            if (c10647bx5O.isInitialized()) {
                return c10647bx5O;
            }
            throw a.AbstractC1828a.c(c10647bx5O);
        }

        public C10647bx5 o() {
            C10647bx5 c10647bx5 = new C10647bx5(this);
            int i = this.d;
            if ((i & 1) == 1) {
                this.e = Collections.unmodifiableList(this.e);
                this.d &= -2;
            }
            c10647bx5.e = this.e;
            int i2 = (i & 2) != 2 ? 0 : 1;
            c10647bx5.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            c10647bx5.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            c10647bx5.h = this.h;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            c10647bx5.i = this.i;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            c10647bx5.j = this.j;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            c10647bx5.k = this.k;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            c10647bx5.l = this.l;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            c10647bx5.m = this.m;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            c10647bx5.n = this.n;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            c10647bx5.o = this.o;
            if ((i & 2048) == 2048) {
                i2 |= 1024;
            }
            c10647bx5.p = this.p;
            if ((i & 4096) == 4096) {
                i2 |= 2048;
            }
            c10647bx5.q = this.q;
            if ((i & 8192) == 8192) {
                i2 |= 4096;
            }
            c10647bx5.r = this.r;
            c10647bx5.d = i2;
            return c10647bx5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public c clone() {
            return q().e(o());
        }

        public c t(C10647bx5 c10647bx5) {
            if ((this.d & 2048) != 2048 || this.p == C10647bx5.b0()) {
                this.p = c10647bx5;
            } else {
                this.p = C10647bx5.D0(this.p).e(c10647bx5).o();
            }
            this.d |= 2048;
            return this;
        }

        public c u(C10647bx5 c10647bx5) {
            if ((this.d & 8) != 8 || this.h == C10647bx5.b0()) {
                this.h = c10647bx5;
            } else {
                this.h = C10647bx5.D0(this.h).e(c10647bx5).o();
            }
            this.d |= 8;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public c e(C10647bx5 c10647bx5) {
            if (c10647bx5 == C10647bx5.b0()) {
                return this;
            }
            if (!c10647bx5.e.isEmpty()) {
                if (this.e.isEmpty()) {
                    this.e = c10647bx5.e;
                    this.d &= -2;
                } else {
                    r();
                    this.e.addAll(c10647bx5.e);
                }
            }
            if (c10647bx5.v0()) {
                D(c10647bx5.i0());
            }
            if (c10647bx5.s0()) {
                B(c10647bx5.f0());
            }
            if (c10647bx5.t0()) {
                u(c10647bx5.g0());
            }
            if (c10647bx5.u0()) {
                C(c10647bx5.h0());
            }
            if (c10647bx5.q0()) {
                z(c10647bx5.a0());
            }
            if (c10647bx5.z0()) {
                G(c10647bx5.m0());
            }
            if (c10647bx5.A0()) {
                H(c10647bx5.n0());
            }
            if (c10647bx5.y0()) {
                F(c10647bx5.l0());
            }
            if (c10647bx5.w0()) {
                x(c10647bx5.j0());
            }
            if (c10647bx5.x0()) {
                E(c10647bx5.k0());
            }
            if (c10647bx5.o0()) {
                t(c10647bx5.V());
            }
            if (c10647bx5.p0()) {
                y(c10647bx5.W());
            }
            if (c10647bx5.r0()) {
                A(c10647bx5.e0());
            }
            l(c10647bx5);
            f(d().h(c10647bx5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C10647bx5.c d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C10647bx5.v     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.bx5 r3 = (ir.nasim.C10647bx5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.bx5 r4 = (ir.nasim.C10647bx5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10647bx5.c.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.bx5$c");
        }

        public c x(C10647bx5 c10647bx5) {
            if ((this.d & 512) != 512 || this.n == C10647bx5.b0()) {
                this.n = c10647bx5;
            } else {
                this.n = C10647bx5.D0(this.n).e(c10647bx5).o();
            }
            this.d |= 512;
            return this;
        }

        public c y(int i) {
            this.d |= 4096;
            this.q = i;
            return this;
        }

        public c z(int i) {
            this.d |= 32;
            this.j = i;
            return this;
        }

        private void s() {
        }
    }
}
