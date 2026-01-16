package ir.nasim;

import ir.nasim.C10647bx5;
import ir.nasim.C12644ex5;
import ir.nasim.C6999Pw5;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.Tw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7950Tw5 extends h.d implements V64 {
    private static final C7950Tw5 s;
    public static LW4 t = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private int e;
    private int f;
    private int g;
    private C10647bx5 h;
    private int i;
    private List j;
    private C10647bx5 k;
    private int l;
    private List m;
    private C12644ex5 n;
    private List o;
    private C6999Pw5 p;
    private byte q;
    private int r;

    /* renamed from: ir.nasim.Tw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C7950Tw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C7950Tw5(eVar, fVar);
        }
    }

    static {
        C7950Tw5 c7950Tw5 = new C7950Tw5(true);
        s = c7950Tw5;
        c7950Tw5.x0();
    }

    public static C7950Tw5 B0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        return (C7950Tw5) t.a(inputStream, fVar);
    }

    public static C7950Tw5 W() {
        return s;
    }

    private void x0() {
        this.e = 6;
        this.f = 6;
        this.g = 0;
        this.h = C10647bx5.b0();
        this.i = 0;
        this.j = Collections.emptyList();
        this.k = C10647bx5.b0();
        this.l = 0;
        this.m = Collections.emptyList();
        this.n = C12644ex5.w();
        this.o = Collections.emptyList();
        this.p = C6999Pw5.s();
    }

    public static b y0() {
        return b.q();
    }

    public static b z0(C7950Tw5 c7950Tw5) {
        return y0().e(c7950Tw5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return y0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return z0(this);
    }

    public C6999Pw5 V() {
        return this.p;
    }

    @Override // ir.nasim.V64
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public C7950Tw5 getDefaultInstanceForType() {
        return s;
    }

    public int Y() {
        return this.e;
    }

    public int Z() {
        return this.g;
    }

    public int a0() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 2) == 2) {
            codedOutputStream.Z(1, this.f);
        }
        if ((this.d & 4) == 4) {
            codedOutputStream.Z(2, this.g);
        }
        if ((this.d & 8) == 8) {
            codedOutputStream.c0(3, this.h);
        }
        for (int i = 0; i < this.j.size(); i++) {
            codedOutputStream.c0(4, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.j.get(i));
        }
        if ((this.d & 32) == 32) {
            codedOutputStream.c0(5, this.k);
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            codedOutputStream.c0(6, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.m.get(i2));
        }
        if ((this.d & 16) == 16) {
            codedOutputStream.Z(7, this.i);
        }
        if ((this.d & 64) == 64) {
            codedOutputStream.Z(8, this.l);
        }
        if ((this.d & 1) == 1) {
            codedOutputStream.Z(9, this.e);
        }
        if ((this.d & 128) == 128) {
            codedOutputStream.c0(30, this.n);
        }
        for (int i3 = 0; i3 < this.o.size(); i3++) {
            codedOutputStream.Z(31, ((Integer) this.o.get(i3)).intValue());
        }
        if ((this.d & 256) == 256) {
            codedOutputStream.c0(32, this.p);
        }
        aVarZ.a(19000, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    public C10647bx5 b0() {
        return this.k;
    }

    public int c0() {
        return this.l;
    }

    public C10647bx5 e0() {
        return this.h;
    }

    public int f0() {
        return this.i;
    }

    public C12053dx5 g0(int i) {
        return (C12053dx5) this.j.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.r;
        if (i != -1) {
            return i;
        }
        int iO = (this.d & 2) == 2 ? CodedOutputStream.o(1, this.f) : 0;
        if ((this.d & 4) == 4) {
            iO += CodedOutputStream.o(2, this.g);
        }
        if ((this.d & 8) == 8) {
            iO += CodedOutputStream.r(3, this.h);
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            iO += CodedOutputStream.r(4, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.j.get(i2));
        }
        if ((this.d & 32) == 32) {
            iO += CodedOutputStream.r(5, this.k);
        }
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            iO += CodedOutputStream.r(6, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.m.get(i3));
        }
        if ((this.d & 16) == 16) {
            iO += CodedOutputStream.o(7, this.i);
        }
        if ((this.d & 64) == 64) {
            iO += CodedOutputStream.o(8, this.l);
        }
        if ((this.d & 1) == 1) {
            iO += CodedOutputStream.o(9, this.e);
        }
        if ((this.d & 128) == 128) {
            iO += CodedOutputStream.r(30, this.n);
        }
        int iP = 0;
        for (int i4 = 0; i4 < this.o.size(); i4++) {
            iP += CodedOutputStream.p(((Integer) this.o.get(i4)).intValue());
        }
        int size = iO + iP + (n0().size() * 2);
        if ((this.d & 256) == 256) {
            size += CodedOutputStream.r(32, this.p);
        }
        int iR = size + r() + this.c.size();
        this.r = iR;
        return iR;
    }

    public int h0() {
        return this.j.size();
    }

    public List i0() {
        return this.j;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.q;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!q0()) {
            this.q = (byte) 0;
            return false;
        }
        if (u0() && !e0().isInitialized()) {
            this.q = (byte) 0;
            return false;
        }
        for (int i = 0; i < h0(); i++) {
            if (!g0(i).isInitialized()) {
                this.q = (byte) 0;
                return false;
            }
        }
        if (s0() && !b0().isInitialized()) {
            this.q = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < l0(); i2++) {
            if (!k0(i2).isInitialized()) {
                this.q = (byte) 0;
                return false;
            }
        }
        if (w0() && !j0().isInitialized()) {
            this.q = (byte) 0;
            return false;
        }
        if (o0() && !V().isInitialized()) {
            this.q = (byte) 0;
            return false;
        }
        if (q()) {
            this.q = (byte) 1;
            return true;
        }
        this.q = (byte) 0;
        return false;
    }

    public C12644ex5 j0() {
        return this.n;
    }

    public C13280fx5 k0(int i) {
        return (C13280fx5) this.m.get(i);
    }

    public int l0() {
        return this.m.size();
    }

    public List m0() {
        return this.m;
    }

    public List n0() {
        return this.o;
    }

    public boolean o0() {
        return (this.d & 256) == 256;
    }

    public boolean p0() {
        return (this.d & 1) == 1;
    }

    public boolean q0() {
        return (this.d & 4) == 4;
    }

    public boolean r0() {
        return (this.d & 2) == 2;
    }

    public boolean s0() {
        return (this.d & 32) == 32;
    }

    public boolean t0() {
        return (this.d & 64) == 64;
    }

    public boolean u0() {
        return (this.d & 8) == 8;
    }

    public boolean v0() {
        return (this.d & 16) == 16;
    }

    public boolean w0() {
        return (this.d & 128) == 128;
    }

    private C7950Tw5(h.c cVar) {
        super(cVar);
        this.q = (byte) -1;
        this.r = -1;
        this.c = cVar.d();
    }

    private C7950Tw5(boolean z) {
        this.q = (byte) -1;
        this.r = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private C7950Tw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.q = (byte) -1;
        this.r = -1;
        x0();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        char c = 0;
        while (true) {
            ?? M = 32;
            if (!z) {
                try {
                    try {
                        int iJ = eVar.J();
                        switch (iJ) {
                            case 0:
                                z = true;
                            case 8:
                                this.d |= 2;
                                this.f = eVar.r();
                            case 16:
                                this.d |= 4;
                                this.g = eVar.r();
                            case 26:
                                C10647bx5.c cVarF0 = (this.d & 8) == 8 ? this.h.toBuilder() : null;
                                C10647bx5 c10647bx5 = (C10647bx5) eVar.t(C10647bx5.v, fVar);
                                this.h = c10647bx5;
                                if (cVarF0 != null) {
                                    cVarF0.e(c10647bx5);
                                    this.h = cVarF0.o();
                                }
                                this.d |= 8;
                            case 34:
                                int i = (c == true ? 1 : 0) & 32;
                                c = c;
                                if (i != 32) {
                                    this.j = new ArrayList();
                                    c = (c == true ? 1 : 0) | ' ';
                                }
                                this.j.add(eVar.t(C12053dx5.o, fVar));
                            case 42:
                                C10647bx5.c cVarF02 = (this.d & 32) == 32 ? this.k.toBuilder() : null;
                                C10647bx5 c10647bx52 = (C10647bx5) eVar.t(C10647bx5.v, fVar);
                                this.k = c10647bx52;
                                if (cVarF02 != null) {
                                    cVarF02.e(c10647bx52);
                                    this.k = cVarF02.o();
                                }
                                this.d |= 32;
                            case 50:
                                int i2 = (c == true ? 1 : 0) & 256;
                                c = c;
                                if (i2 != 256) {
                                    this.m = new ArrayList();
                                    c = (c == true ? 1 : 0) | 256;
                                }
                                this.m.add(eVar.t(C13280fx5.n, fVar));
                            case Type.NINFO /* 56 */:
                                this.d |= 16;
                                this.i = eVar.r();
                            case 64:
                                this.d |= 64;
                                this.l = eVar.r();
                            case 72:
                                this.d |= 1;
                                this.e = eVar.r();
                            case 242:
                                C12644ex5.b bVarK = (this.d & 128) == 128 ? this.n.toBuilder() : null;
                                C12644ex5 c12644ex5 = (C12644ex5) eVar.t(C12644ex5.i, fVar);
                                this.n = c12644ex5;
                                if (bVarK != null) {
                                    bVarK.e(c12644ex5);
                                    this.n = bVarK.k();
                                }
                                this.d |= 128;
                            case 248:
                                int i3 = (c == true ? 1 : 0) & 1024;
                                c = c;
                                if (i3 != 1024) {
                                    this.o = new ArrayList();
                                    c = (c == true ? 1 : 0) | 1024;
                                }
                                this.o.add(Integer.valueOf(eVar.r()));
                            case Type.TSIG /* 250 */:
                                int i4 = eVar.i(eVar.z());
                                int i5 = (c == true ? 1 : 0) & 1024;
                                c = c;
                                if (i5 != 1024) {
                                    c = c;
                                    if (eVar.e() > 0) {
                                        this.o = new ArrayList();
                                        c = (c == true ? 1 : 0) | 1024;
                                    }
                                }
                                while (eVar.e() > 0) {
                                    this.o.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i4);
                            case Type.AVC /* 258 */:
                                C6999Pw5.b bVarE = (this.d & 256) == 256 ? this.p.toBuilder() : null;
                                C6999Pw5 c6999Pw5 = (C6999Pw5) eVar.t(C6999Pw5.g, fVar);
                                this.p = c6999Pw5;
                                if (bVarE != null) {
                                    bVarE.e(c6999Pw5);
                                    this.p = bVarE.k();
                                }
                                this.d |= 256;
                            default:
                                M = m(eVar, codedOutputStreamI, fVar, iJ);
                                if (M == 0) {
                                    z = true;
                                }
                        }
                    } catch (Throwable th) {
                        if (((c == true ? 1 : 0) & 32) == M) {
                            this.j = Collections.unmodifiableList(this.j);
                        }
                        if (((c == true ? 1 : 0) & 256) == 256) {
                            this.m = Collections.unmodifiableList(this.m);
                        }
                        if (((c == true ? 1 : 0) & 1024) == 1024) {
                            this.o = Collections.unmodifiableList(this.o);
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
                } catch (InvalidProtocolBufferException e) {
                    throw e.k(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
                }
            } else {
                if (((c == true ? 1 : 0) & 32) == 32) {
                    this.j = Collections.unmodifiableList(this.j);
                }
                if (((c == true ? 1 : 0) & 256) == 256) {
                    this.m = Collections.unmodifiableList(this.m);
                }
                if (((c == true ? 1 : 0) & 1024) == 1024) {
                    this.o = Collections.unmodifiableList(this.o);
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
                return;
            }
        }
    }

    /* renamed from: ir.nasim.Tw5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private int g;
        private int i;
        private int l;
        private int e = 6;
        private int f = 6;
        private C10647bx5 h = C10647bx5.b0();
        private List j = Collections.emptyList();
        private C10647bx5 k = C10647bx5.b0();
        private List m = Collections.emptyList();
        private C12644ex5 n = C12644ex5.w();
        private List o = Collections.emptyList();
        private C6999Pw5 p = C6999Pw5.s();

        private b() {
            u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b q() {
            return new b();
        }

        private void r() {
            if ((this.d & 32) != 32) {
                this.j = new ArrayList(this.j);
                this.d |= 32;
            }
        }

        private void s() {
            if ((this.d & 256) != 256) {
                this.m = new ArrayList(this.m);
                this.d |= 256;
            }
        }

        private void t() {
            if ((this.d & 1024) != 1024) {
                this.o = new ArrayList(this.o);
                this.d |= 1024;
            }
        }

        public b A(C12644ex5 c12644ex5) {
            if ((this.d & 512) != 512 || this.n == C12644ex5.w()) {
                this.n = c12644ex5;
            } else {
                this.n = C12644ex5.H(this.n).e(c12644ex5).k();
            }
            this.d |= 512;
            return this;
        }

        public b B(int i) {
            this.d |= 1;
            this.e = i;
            return this;
        }

        public b C(int i) {
            this.d |= 4;
            this.g = i;
            return this;
        }

        public b D(int i) {
            this.d |= 2;
            this.f = i;
            return this;
        }

        public b E(int i) {
            this.d |= 128;
            this.l = i;
            return this;
        }

        public b F(int i) {
            this.d |= 16;
            this.i = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C7950Tw5 a() {
            C7950Tw5 c7950Tw5O = o();
            if (c7950Tw5O.isInitialized()) {
                return c7950Tw5O;
            }
            throw a.AbstractC1828a.c(c7950Tw5O);
        }

        public C7950Tw5 o() {
            C7950Tw5 c7950Tw5 = new C7950Tw5(this);
            int i = this.d;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c7950Tw5.e = this.e;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c7950Tw5.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c7950Tw5.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c7950Tw5.h = this.h;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            c7950Tw5.i = this.i;
            if ((this.d & 32) == 32) {
                this.j = Collections.unmodifiableList(this.j);
                this.d &= -33;
            }
            c7950Tw5.j = this.j;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            c7950Tw5.k = this.k;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            c7950Tw5.l = this.l;
            if ((this.d & 256) == 256) {
                this.m = Collections.unmodifiableList(this.m);
                this.d &= -257;
            }
            c7950Tw5.m = this.m;
            if ((i & 512) == 512) {
                i2 |= 128;
            }
            c7950Tw5.n = this.n;
            if ((this.d & 1024) == 1024) {
                this.o = Collections.unmodifiableList(this.o);
                this.d &= -1025;
            }
            c7950Tw5.o = this.o;
            if ((i & 2048) == 2048) {
                i2 |= 256;
            }
            c7950Tw5.p = this.p;
            c7950Tw5.d = i2;
            return c7950Tw5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        public b v(C6999Pw5 c6999Pw5) {
            if ((this.d & 2048) != 2048 || this.p == C6999Pw5.s()) {
                this.p = c6999Pw5;
            } else {
                this.p = C6999Pw5.C(this.p).e(c6999Pw5).k();
            }
            this.d |= 2048;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b e(C7950Tw5 c7950Tw5) {
            if (c7950Tw5 == C7950Tw5.W()) {
                return this;
            }
            if (c7950Tw5.p0()) {
                B(c7950Tw5.Y());
            }
            if (c7950Tw5.r0()) {
                D(c7950Tw5.a0());
            }
            if (c7950Tw5.q0()) {
                C(c7950Tw5.Z());
            }
            if (c7950Tw5.u0()) {
                z(c7950Tw5.e0());
            }
            if (c7950Tw5.v0()) {
                F(c7950Tw5.f0());
            }
            if (!c7950Tw5.j.isEmpty()) {
                if (this.j.isEmpty()) {
                    this.j = c7950Tw5.j;
                    this.d &= -33;
                } else {
                    r();
                    this.j.addAll(c7950Tw5.j);
                }
            }
            if (c7950Tw5.s0()) {
                y(c7950Tw5.b0());
            }
            if (c7950Tw5.t0()) {
                E(c7950Tw5.c0());
            }
            if (!c7950Tw5.m.isEmpty()) {
                if (this.m.isEmpty()) {
                    this.m = c7950Tw5.m;
                    this.d &= -257;
                } else {
                    s();
                    this.m.addAll(c7950Tw5.m);
                }
            }
            if (c7950Tw5.w0()) {
                A(c7950Tw5.j0());
            }
            if (!c7950Tw5.o.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = c7950Tw5.o;
                    this.d &= -1025;
                } else {
                    t();
                    this.o.addAll(c7950Tw5.o);
                }
            }
            if (c7950Tw5.o0()) {
                v(c7950Tw5.V());
            }
            l(c7950Tw5);
            f(d().h(c7950Tw5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C7950Tw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C7950Tw5.t     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Tw5 r3 = (ir.nasim.C7950Tw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Tw5 r4 = (ir.nasim.C7950Tw5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7950Tw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Tw5$b");
        }

        public b y(C10647bx5 c10647bx5) {
            if ((this.d & 64) != 64 || this.k == C10647bx5.b0()) {
                this.k = c10647bx5;
            } else {
                this.k = C10647bx5.D0(this.k).e(c10647bx5).o();
            }
            this.d |= 64;
            return this;
        }

        public b z(C10647bx5 c10647bx5) {
            if ((this.d & 8) != 8 || this.h == C10647bx5.b0()) {
                this.h = c10647bx5;
            } else {
                this.h = C10647bx5.D0(this.h).e(c10647bx5).o();
            }
            this.d |= 8;
            return this;
        }

        private void u() {
        }
    }
}
