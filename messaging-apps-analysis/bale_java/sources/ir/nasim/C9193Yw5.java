package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.parser.TokenTypes;
import ir.nasim.C10647bx5;
import ir.nasim.C13280fx5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.Yw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9193Yw5 extends h.d implements V64 {
    private static final C9193Yw5 s;
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
    private C13280fx5 m;
    private int n;
    private int o;
    private List p;
    private byte q;
    private int r;

    /* renamed from: ir.nasim.Yw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C9193Yw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C9193Yw5(eVar, fVar);
        }
    }

    static {
        C9193Yw5 c9193Yw5 = new C9193Yw5(true);
        s = c9193Yw5;
        c9193Yw5.v0();
    }

    public static C9193Yw5 U() {
        return s;
    }

    private void v0() {
        this.e = 518;
        this.f = TokenTypes.ACK;
        this.g = 0;
        this.h = C10647bx5.b0();
        this.i = 0;
        this.j = Collections.emptyList();
        this.k = C10647bx5.b0();
        this.l = 0;
        this.m = C13280fx5.M();
        this.n = 0;
        this.o = 0;
        this.p = Collections.emptyList();
    }

    public static b w0() {
        return b.q();
    }

    public static b x0(C9193Yw5 c9193Yw5) {
        return w0().e(c9193Yw5);
    }

    @Override // ir.nasim.V64
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public C9193Yw5 getDefaultInstanceForType() {
        return s;
    }

    public int W() {
        return this.e;
    }

    public int X() {
        return this.n;
    }

    public int Y() {
        return this.g;
    }

    public int Z() {
        return this.f;
    }

    public C10647bx5 a0() {
        return this.k;
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
        if ((this.d & 128) == 128) {
            codedOutputStream.c0(6, this.m);
        }
        if ((this.d & 256) == 256) {
            codedOutputStream.Z(7, this.n);
        }
        if ((this.d & 512) == 512) {
            codedOutputStream.Z(8, this.o);
        }
        if ((this.d & 16) == 16) {
            codedOutputStream.Z(9, this.i);
        }
        if ((this.d & 64) == 64) {
            codedOutputStream.Z(10, this.l);
        }
        if ((this.d & 1) == 1) {
            codedOutputStream.Z(11, this.e);
        }
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            codedOutputStream.Z(31, ((Integer) this.p.get(i2)).intValue());
        }
        aVarZ.a(19000, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    public int b0() {
        return this.l;
    }

    public C10647bx5 c0() {
        return this.h;
    }

    public int e0() {
        return this.i;
    }

    public int f0() {
        return this.o;
    }

    public C13280fx5 g0() {
        return this.m;
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
        if ((this.d & 128) == 128) {
            iO += CodedOutputStream.r(6, this.m);
        }
        if ((this.d & 256) == 256) {
            iO += CodedOutputStream.o(7, this.n);
        }
        if ((this.d & 512) == 512) {
            iO += CodedOutputStream.o(8, this.o);
        }
        if ((this.d & 16) == 16) {
            iO += CodedOutputStream.o(9, this.i);
        }
        if ((this.d & 64) == 64) {
            iO += CodedOutputStream.o(10, this.l);
        }
        if ((this.d & 1) == 1) {
            iO += CodedOutputStream.o(11, this.e);
        }
        int iP = 0;
        for (int i3 = 0; i3 < this.p.size(); i3++) {
            iP += CodedOutputStream.p(((Integer) this.p.get(i3)).intValue());
        }
        int size = iO + iP + (k0().size() * 2) + r() + this.c.size();
        this.r = size;
        return size;
    }

    public C12053dx5 h0(int i) {
        return (C12053dx5) this.j.get(i);
    }

    public int i0() {
        return this.j.size();
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
        if (!n0()) {
            this.q = (byte) 0;
            return false;
        }
        if (r0() && !c0().isInitialized()) {
            this.q = (byte) 0;
            return false;
        }
        for (int i = 0; i < i0(); i++) {
            if (!h0(i).isInitialized()) {
                this.q = (byte) 0;
                return false;
            }
        }
        if (p0() && !a0().isInitialized()) {
            this.q = (byte) 0;
            return false;
        }
        if (u0() && !g0().isInitialized()) {
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

    public List j0() {
        return this.j;
    }

    public List k0() {
        return this.p;
    }

    public boolean l0() {
        return (this.d & 1) == 1;
    }

    public boolean m0() {
        return (this.d & 256) == 256;
    }

    public boolean n0() {
        return (this.d & 4) == 4;
    }

    public boolean o0() {
        return (this.d & 2) == 2;
    }

    public boolean p0() {
        return (this.d & 32) == 32;
    }

    public boolean q0() {
        return (this.d & 64) == 64;
    }

    public boolean r0() {
        return (this.d & 8) == 8;
    }

    public boolean s0() {
        return (this.d & 16) == 16;
    }

    public boolean t0() {
        return (this.d & 512) == 512;
    }

    public boolean u0() {
        return (this.d & 128) == 128;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return w0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return x0(this);
    }

    private C9193Yw5(h.c cVar) {
        super(cVar);
        this.q = (byte) -1;
        this.r = -1;
        this.c = cVar.d();
    }

    private C9193Yw5(boolean z) {
        this.q = (byte) -1;
        this.r = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private C9193Yw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.q = (byte) -1;
        this.r = -1;
        v0();
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
                                C13280fx5.b bVarF0 = (this.d & 128) == 128 ? this.m.toBuilder() : null;
                                C13280fx5 c13280fx5 = (C13280fx5) eVar.t(C13280fx5.n, fVar);
                                this.m = c13280fx5;
                                if (bVarF0 != null) {
                                    bVarF0.e(c13280fx5);
                                    this.m = bVarF0.o();
                                }
                                this.d |= 128;
                            case Type.NINFO /* 56 */:
                                this.d |= 256;
                                this.n = eVar.r();
                            case 64:
                                this.d |= 512;
                                this.o = eVar.r();
                            case 72:
                                this.d |= 16;
                                this.i = eVar.r();
                            case 80:
                                this.d |= 64;
                                this.l = eVar.r();
                            case SetRpcStruct$ComposedRpc.RESPONSE_GET_CONTACTS_FIELD_NUMBER /* 88 */:
                                this.d |= 1;
                                this.e = eVar.r();
                            case 248:
                                int i2 = (c == true ? 1 : 0) & 2048;
                                c = c;
                                if (i2 != 2048) {
                                    this.p = new ArrayList();
                                    c = (c == true ? 1 : 0) | 2048;
                                }
                                this.p.add(Integer.valueOf(eVar.r()));
                            case Type.TSIG /* 250 */:
                                int i3 = eVar.i(eVar.z());
                                int i4 = (c == true ? 1 : 0) & 2048;
                                c = c;
                                if (i4 != 2048) {
                                    c = c;
                                    if (eVar.e() > 0) {
                                        this.p = new ArrayList();
                                        c = (c == true ? 1 : 0) | 2048;
                                    }
                                }
                                while (eVar.e() > 0) {
                                    this.p.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i3);
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
                        if (((c == true ? 1 : 0) & 2048) == 2048) {
                            this.p = Collections.unmodifiableList(this.p);
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
                if (((c == true ? 1 : 0) & 2048) == 2048) {
                    this.p = Collections.unmodifiableList(this.p);
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

    /* renamed from: ir.nasim.Yw5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private int g;
        private int i;
        private int l;
        private int n;
        private int o;
        private int e = 518;
        private int f = TokenTypes.ACK;
        private C10647bx5 h = C10647bx5.b0();
        private List j = Collections.emptyList();
        private C10647bx5 k = C10647bx5.b0();
        private C13280fx5 m = C13280fx5.M();
        private List p = Collections.emptyList();

        private b() {
            t();
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
            if ((this.d & 2048) != 2048) {
                this.p = new ArrayList(this.p);
                this.d |= 2048;
            }
        }

        public b A(int i) {
            this.d |= 512;
            this.n = i;
            return this;
        }

        public b B(int i) {
            this.d |= 4;
            this.g = i;
            return this;
        }

        public b C(int i) {
            this.d |= 2;
            this.f = i;
            return this;
        }

        public b D(int i) {
            this.d |= 128;
            this.l = i;
            return this;
        }

        public b E(int i) {
            this.d |= 16;
            this.i = i;
            return this;
        }

        public b F(int i) {
            this.d |= 1024;
            this.o = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C9193Yw5 a() {
            C9193Yw5 c9193Yw5O = o();
            if (c9193Yw5O.isInitialized()) {
                return c9193Yw5O;
            }
            throw a.AbstractC1828a.c(c9193Yw5O);
        }

        public C9193Yw5 o() {
            C9193Yw5 c9193Yw5 = new C9193Yw5(this);
            int i = this.d;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c9193Yw5.e = this.e;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c9193Yw5.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c9193Yw5.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c9193Yw5.h = this.h;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            c9193Yw5.i = this.i;
            if ((this.d & 32) == 32) {
                this.j = Collections.unmodifiableList(this.j);
                this.d &= -33;
            }
            c9193Yw5.j = this.j;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            c9193Yw5.k = this.k;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            c9193Yw5.l = this.l;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            c9193Yw5.m = this.m;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            c9193Yw5.n = this.n;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            c9193Yw5.o = this.o;
            if ((this.d & 2048) == 2048) {
                this.p = Collections.unmodifiableList(this.p);
                this.d &= -2049;
            }
            c9193Yw5.p = this.p;
            c9193Yw5.d = i2;
            return c9193Yw5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b e(C9193Yw5 c9193Yw5) {
            if (c9193Yw5 == C9193Yw5.U()) {
                return this;
            }
            if (c9193Yw5.l0()) {
                z(c9193Yw5.W());
            }
            if (c9193Yw5.o0()) {
                C(c9193Yw5.Z());
            }
            if (c9193Yw5.n0()) {
                B(c9193Yw5.Y());
            }
            if (c9193Yw5.r0()) {
                x(c9193Yw5.c0());
            }
            if (c9193Yw5.s0()) {
                E(c9193Yw5.e0());
            }
            if (!c9193Yw5.j.isEmpty()) {
                if (this.j.isEmpty()) {
                    this.j = c9193Yw5.j;
                    this.d &= -33;
                } else {
                    r();
                    this.j.addAll(c9193Yw5.j);
                }
            }
            if (c9193Yw5.p0()) {
                w(c9193Yw5.a0());
            }
            if (c9193Yw5.q0()) {
                D(c9193Yw5.b0());
            }
            if (c9193Yw5.u0()) {
                y(c9193Yw5.g0());
            }
            if (c9193Yw5.m0()) {
                A(c9193Yw5.X());
            }
            if (c9193Yw5.t0()) {
                F(c9193Yw5.f0());
            }
            if (!c9193Yw5.p.isEmpty()) {
                if (this.p.isEmpty()) {
                    this.p = c9193Yw5.p;
                    this.d &= -2049;
                } else {
                    s();
                    this.p.addAll(c9193Yw5.p);
                }
            }
            l(c9193Yw5);
            f(d().h(c9193Yw5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C9193Yw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C9193Yw5.t     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Yw5 r3 = (ir.nasim.C9193Yw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Yw5 r4 = (ir.nasim.C9193Yw5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9193Yw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Yw5$b");
        }

        public b w(C10647bx5 c10647bx5) {
            if ((this.d & 64) != 64 || this.k == C10647bx5.b0()) {
                this.k = c10647bx5;
            } else {
                this.k = C10647bx5.D0(this.k).e(c10647bx5).o();
            }
            this.d |= 64;
            return this;
        }

        public b x(C10647bx5 c10647bx5) {
            if ((this.d & 8) != 8 || this.h == C10647bx5.b0()) {
                this.h = c10647bx5;
            } else {
                this.h = C10647bx5.D0(this.h).e(c10647bx5).o();
            }
            this.d |= 8;
            return this;
        }

        public b y(C13280fx5 c13280fx5) {
            if ((this.d & 256) != 256 || this.m == C13280fx5.M()) {
                this.m = c13280fx5;
            } else {
                this.m = C13280fx5.c0(this.m).e(c13280fx5).o();
            }
            this.d |= 256;
            return this;
        }

        public b z(int i) {
            this.d |= 1;
            this.e = i;
            return this;
        }

        private void t() {
        }
    }
}
