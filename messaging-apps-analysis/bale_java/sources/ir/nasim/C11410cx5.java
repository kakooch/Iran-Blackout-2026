package ir.nasim;

import ir.nasim.C10647bx5;
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
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.cx5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11410cx5 extends h.d implements V64 {
    private static final C11410cx5 p;
    public static LW4 q = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private int e;
    private int f;
    private List g;
    private C10647bx5 h;
    private int i;
    private C10647bx5 j;
    private int k;
    private List l;
    private List m;
    private byte n;
    private int o;

    /* renamed from: ir.nasim.cx5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C11410cx5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C11410cx5(eVar, fVar);
        }
    }

    static {
        C11410cx5 c11410cx5 = new C11410cx5(true);
        p = c11410cx5;
        c11410cx5.o0();
    }

    public static C11410cx5 V() {
        return p;
    }

    private void o0() {
        this.e = 6;
        this.f = 0;
        this.g = Collections.emptyList();
        this.h = C10647bx5.b0();
        this.i = 0;
        this.j = C10647bx5.b0();
        this.k = 0;
        this.l = Collections.emptyList();
        this.m = Collections.emptyList();
    }

    public static b p0() {
        return b.q();
    }

    public static b q0(C11410cx5 c11410cx5) {
        return p0().e(c11410cx5);
    }

    public static C11410cx5 s0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        return (C11410cx5) q.c(inputStream, fVar);
    }

    public C6266Mw5 S(int i) {
        return (C6266Mw5) this.l.get(i);
    }

    public int T() {
        return this.l.size();
    }

    public List U() {
        return this.l;
    }

    @Override // ir.nasim.V64
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public C11410cx5 getDefaultInstanceForType() {
        return p;
    }

    public C10647bx5 X() {
        return this.j;
    }

    public int Y() {
        return this.k;
    }

    public int Z() {
        return this.e;
    }

    public int a0() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 1) == 1) {
            codedOutputStream.Z(1, this.e);
        }
        if ((this.d & 2) == 2) {
            codedOutputStream.Z(2, this.f);
        }
        for (int i = 0; i < this.g.size(); i++) {
            codedOutputStream.c0(3, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.g.get(i));
        }
        if ((this.d & 4) == 4) {
            codedOutputStream.c0(4, this.h);
        }
        if ((this.d & 8) == 8) {
            codedOutputStream.Z(5, this.i);
        }
        if ((this.d & 16) == 16) {
            codedOutputStream.c0(6, this.j);
        }
        if ((this.d & 32) == 32) {
            codedOutputStream.Z(7, this.k);
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            codedOutputStream.c0(8, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.l.get(i2));
        }
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            codedOutputStream.Z(31, ((Integer) this.m.get(i3)).intValue());
        }
        aVarZ.a(200, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    public C12053dx5 b0(int i) {
        return (C12053dx5) this.g.get(i);
    }

    public int c0() {
        return this.g.size();
    }

    public List e0() {
        return this.g;
    }

    public C10647bx5 f0() {
        return this.h;
    }

    public int g0() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.o;
        if (i != -1) {
            return i;
        }
        int iO = (this.d & 1) == 1 ? CodedOutputStream.o(1, this.e) : 0;
        if ((this.d & 2) == 2) {
            iO += CodedOutputStream.o(2, this.f);
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            iO += CodedOutputStream.r(3, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.g.get(i2));
        }
        if ((this.d & 4) == 4) {
            iO += CodedOutputStream.r(4, this.h);
        }
        if ((this.d & 8) == 8) {
            iO += CodedOutputStream.o(5, this.i);
        }
        if ((this.d & 16) == 16) {
            iO += CodedOutputStream.r(6, this.j);
        }
        if ((this.d & 32) == 32) {
            iO += CodedOutputStream.o(7, this.k);
        }
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            iO += CodedOutputStream.r(8, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.l.get(i3));
        }
        int iP = 0;
        for (int i4 = 0; i4 < this.m.size(); i4++) {
            iP += CodedOutputStream.p(((Integer) this.m.get(i4)).intValue());
        }
        int size = iO + iP + (h0().size() * 2) + r() + this.c.size();
        this.o = size;
        return size;
    }

    public List h0() {
        return this.m;
    }

    public boolean i0() {
        return (this.d & 16) == 16;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.n;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!l0()) {
            this.n = (byte) 0;
            return false;
        }
        for (int i = 0; i < c0(); i++) {
            if (!b0(i).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        if (m0() && !f0().isInitialized()) {
            this.n = (byte) 0;
            return false;
        }
        if (i0() && !X().isInitialized()) {
            this.n = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < T(); i2++) {
            if (!S(i2).isInitialized()) {
                this.n = (byte) 0;
                return false;
            }
        }
        if (q()) {
            this.n = (byte) 1;
            return true;
        }
        this.n = (byte) 0;
        return false;
    }

    public boolean j0() {
        return (this.d & 32) == 32;
    }

    public boolean k0() {
        return (this.d & 1) == 1;
    }

    public boolean l0() {
        return (this.d & 2) == 2;
    }

    public boolean m0() {
        return (this.d & 4) == 4;
    }

    public boolean n0() {
        return (this.d & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return p0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return q0(this);
    }

    private C11410cx5(h.c cVar) {
        super(cVar);
        this.n = (byte) -1;
        this.o = -1;
        this.c = cVar.d();
    }

    private C11410cx5(boolean z) {
        this.n = (byte) -1;
        this.o = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private C11410cx5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        C10647bx5.c builder;
        this.n = (byte) -1;
        this.o = -1;
        o0();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        int i = 0;
        while (true) {
            ?? M = 128;
            if (!z) {
                try {
                    try {
                        int iJ = eVar.J();
                        switch (iJ) {
                            case 0:
                                z = true;
                            case 8:
                                this.d |= 1;
                                this.e = eVar.r();
                            case 16:
                                this.d |= 2;
                                this.f = eVar.r();
                            case 26:
                                if ((i & 4) != 4) {
                                    this.g = new ArrayList();
                                    i |= 4;
                                }
                                this.g.add(eVar.t(C12053dx5.o, fVar));
                            case 34:
                                builder = (this.d & 4) == 4 ? this.h.toBuilder() : null;
                                C10647bx5 c10647bx5 = (C10647bx5) eVar.t(C10647bx5.v, fVar);
                                this.h = c10647bx5;
                                if (builder != null) {
                                    builder.e(c10647bx5);
                                    this.h = builder.o();
                                }
                                this.d |= 4;
                            case 40:
                                this.d |= 8;
                                this.i = eVar.r();
                            case 50:
                                builder = (this.d & 16) == 16 ? this.j.toBuilder() : null;
                                C10647bx5 c10647bx52 = (C10647bx5) eVar.t(C10647bx5.v, fVar);
                                this.j = c10647bx52;
                                if (builder != null) {
                                    builder.e(c10647bx52);
                                    this.j = builder.o();
                                }
                                this.d |= 16;
                            case Type.NINFO /* 56 */:
                                this.d |= 32;
                                this.k = eVar.r();
                            case WKSRecord.Protocol.RVD /* 66 */:
                                if ((i & 128) != 128) {
                                    this.l = new ArrayList();
                                    i |= 128;
                                }
                                this.l.add(eVar.t(C6266Mw5.i, fVar));
                            case 248:
                                if ((i & 256) != 256) {
                                    this.m = new ArrayList();
                                    i |= 256;
                                }
                                this.m.add(Integer.valueOf(eVar.r()));
                            case Type.TSIG /* 250 */:
                                int i2 = eVar.i(eVar.z());
                                if ((i & 256) != 256 && eVar.e() > 0) {
                                    this.m = new ArrayList();
                                    i |= 256;
                                }
                                while (eVar.e() > 0) {
                                    this.m.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i2);
                                break;
                            default:
                                M = m(eVar, codedOutputStreamI, fVar, iJ);
                                if (M == 0) {
                                    z = true;
                                }
                        }
                    } catch (Throwable th) {
                        if ((i & 4) == 4) {
                            this.g = Collections.unmodifiableList(this.g);
                        }
                        if ((i & 128) == M) {
                            this.l = Collections.unmodifiableList(this.l);
                        }
                        if ((i & 256) == 256) {
                            this.m = Collections.unmodifiableList(this.m);
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
                if ((i & 4) == 4) {
                    this.g = Collections.unmodifiableList(this.g);
                }
                if ((i & 128) == 128) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                if ((i & 256) == 256) {
                    this.m = Collections.unmodifiableList(this.m);
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

    /* renamed from: ir.nasim.cx5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private int f;
        private int i;
        private int k;
        private int e = 6;
        private List g = Collections.emptyList();
        private C10647bx5 h = C10647bx5.b0();
        private C10647bx5 j = C10647bx5.b0();
        private List l = Collections.emptyList();
        private List m = Collections.emptyList();

        private b() {
            u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b q() {
            return new b();
        }

        private void r() {
            if ((this.d & 128) != 128) {
                this.l = new ArrayList(this.l);
                this.d |= 128;
            }
        }

        private void s() {
            if ((this.d & 4) != 4) {
                this.g = new ArrayList(this.g);
                this.d |= 4;
            }
        }

        private void t() {
            if ((this.d & 256) != 256) {
                this.m = new ArrayList(this.m);
                this.d |= 256;
            }
        }

        public b A(int i) {
            this.d |= 1;
            this.e = i;
            return this;
        }

        public b B(int i) {
            this.d |= 2;
            this.f = i;
            return this;
        }

        public b C(int i) {
            this.d |= 16;
            this.i = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C11410cx5 a() {
            C11410cx5 c11410cx5O = o();
            if (c11410cx5O.isInitialized()) {
                return c11410cx5O;
            }
            throw a.AbstractC1828a.c(c11410cx5O);
        }

        public C11410cx5 o() {
            C11410cx5 c11410cx5 = new C11410cx5(this);
            int i = this.d;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11410cx5.e = this.e;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c11410cx5.f = this.f;
            if ((this.d & 4) == 4) {
                this.g = Collections.unmodifiableList(this.g);
                this.d &= -5;
            }
            c11410cx5.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            c11410cx5.h = this.h;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            c11410cx5.i = this.i;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            c11410cx5.j = this.j;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            c11410cx5.k = this.k;
            if ((this.d & 128) == 128) {
                this.l = Collections.unmodifiableList(this.l);
                this.d &= -129;
            }
            c11410cx5.l = this.l;
            if ((this.d & 256) == 256) {
                this.m = Collections.unmodifiableList(this.m);
                this.d &= -257;
            }
            c11410cx5.m = this.m;
            c11410cx5.d = i2;
            return c11410cx5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        public b v(C10647bx5 c10647bx5) {
            if ((this.d & 32) != 32 || this.j == C10647bx5.b0()) {
                this.j = c10647bx5;
            } else {
                this.j = C10647bx5.D0(this.j).e(c10647bx5).o();
            }
            this.d |= 32;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b e(C11410cx5 c11410cx5) {
            if (c11410cx5 == C11410cx5.V()) {
                return this;
            }
            if (c11410cx5.k0()) {
                A(c11410cx5.Z());
            }
            if (c11410cx5.l0()) {
                B(c11410cx5.a0());
            }
            if (!c11410cx5.g.isEmpty()) {
                if (this.g.isEmpty()) {
                    this.g = c11410cx5.g;
                    this.d &= -5;
                } else {
                    s();
                    this.g.addAll(c11410cx5.g);
                }
            }
            if (c11410cx5.m0()) {
                y(c11410cx5.f0());
            }
            if (c11410cx5.n0()) {
                C(c11410cx5.g0());
            }
            if (c11410cx5.i0()) {
                v(c11410cx5.X());
            }
            if (c11410cx5.j0()) {
                z(c11410cx5.Y());
            }
            if (!c11410cx5.l.isEmpty()) {
                if (this.l.isEmpty()) {
                    this.l = c11410cx5.l;
                    this.d &= -129;
                } else {
                    r();
                    this.l.addAll(c11410cx5.l);
                }
            }
            if (!c11410cx5.m.isEmpty()) {
                if (this.m.isEmpty()) {
                    this.m = c11410cx5.m;
                    this.d &= -257;
                } else {
                    t();
                    this.m.addAll(c11410cx5.m);
                }
            }
            l(c11410cx5);
            f(d().h(c11410cx5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C11410cx5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C11410cx5.q     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.cx5 r3 = (ir.nasim.C11410cx5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.cx5 r4 = (ir.nasim.C11410cx5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11410cx5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.cx5$b");
        }

        public b y(C10647bx5 c10647bx5) {
            if ((this.d & 8) != 8 || this.h == C10647bx5.b0()) {
                this.h = c10647bx5;
            } else {
                this.h = C10647bx5.D0(this.h).e(c10647bx5).o();
            }
            this.d |= 8;
            return this;
        }

        public b z(int i) {
            this.d |= 64;
            this.k = i;
            return this;
        }

        private void u() {
        }
    }
}
