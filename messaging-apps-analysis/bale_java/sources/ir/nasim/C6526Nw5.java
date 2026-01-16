package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C12644ex5;
import ir.nasim.C14464hx5;
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
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Nw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6526Nw5 extends h.d implements V64 {
    public static LW4 A = new a();
    private static final C6526Nw5 z;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private int e;
    private int f;
    private int g;
    private List h;
    private List i;
    private List j;
    private int k;
    private List l;
    private int m;
    private List n;
    private List o;
    private List p;
    private List q;
    private List r;
    private List s;
    private int t;
    private C12644ex5 u;
    private List v;
    private C14464hx5 w;
    private byte x;
    private int y;

    /* renamed from: ir.nasim.Nw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C6526Nw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C6526Nw5(eVar, fVar);
        }
    }

    /* renamed from: ir.nasim.Nw5$c */
    public enum c implements i.a {
        CLASS(0, 0),
        INTERFACE(1, 1),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);

        private static i.b i = new a();
        private final int a;

        /* renamed from: ir.nasim.Nw5$c$a */
        static class a implements i.b {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i) {
                return c.a(i);
            }
        }

        c(int i2, int i3) {
            this.a = i3;
        }

        public static c a(int i2) {
            switch (i2) {
                case 0:
                    return CLASS;
                case 1:
                    return INTERFACE;
                case 2:
                    return ENUM_CLASS;
                case 3:
                    return ENUM_ENTRY;
                case 4:
                    return ANNOTATION_CLASS;
                case 5:
                    return OBJECT;
                case 6:
                    return COMPANION_OBJECT;
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
        C6526Nw5 c6526Nw5 = new C6526Nw5(true);
        z = c6526Nw5;
        c6526Nw5.T0();
    }

    private void T0() {
        this.e = 6;
        this.f = 0;
        this.g = 0;
        this.h = Collections.emptyList();
        this.i = Collections.emptyList();
        this.j = Collections.emptyList();
        this.l = Collections.emptyList();
        this.n = Collections.emptyList();
        this.o = Collections.emptyList();
        this.p = Collections.emptyList();
        this.q = Collections.emptyList();
        this.r = Collections.emptyList();
        this.s = Collections.emptyList();
        this.u = C12644ex5.w();
        this.v = Collections.emptyList();
        this.w = C14464hx5.s();
    }

    public static b U0() {
        return b.q();
    }

    public static b V0(C6526Nw5 c6526Nw5) {
        return U0().e(c6526Nw5);
    }

    public static C6526Nw5 X0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        return (C6526Nw5) A.a(inputStream, fVar);
    }

    public static C6526Nw5 m0() {
        return z;
    }

    public List A0() {
        return this.s;
    }

    public C10647bx5 B0(int i) {
        return (C10647bx5) this.i.get(i);
    }

    public int C0() {
        return this.i.size();
    }

    public List D0() {
        return this.j;
    }

    public List E0() {
        return this.i;
    }

    public C11410cx5 F0(int i) {
        return (C11410cx5) this.q.get(i);
    }

    public int G0() {
        return this.q.size();
    }

    public List H0() {
        return this.q;
    }

    public C12053dx5 I0(int i) {
        return (C12053dx5) this.h.get(i);
    }

    public int J0() {
        return this.h.size();
    }

    public List K0() {
        return this.h;
    }

    public C12644ex5 L0() {
        return this.u;
    }

    public List M0() {
        return this.v;
    }

    public C14464hx5 N0() {
        return this.w;
    }

    public boolean O0() {
        return (this.d & 4) == 4;
    }

    public boolean P0() {
        return (this.d & 1) == 1;
    }

    public boolean Q0() {
        return (this.d & 2) == 2;
    }

    public boolean R0() {
        return (this.d & 8) == 8;
    }

    public boolean S0() {
        return (this.d & 16) == 16;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return U0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return V0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 1) == 1) {
            codedOutputStream.Z(1, this.e);
        }
        if (D0().size() > 0) {
            codedOutputStream.n0(18);
            codedOutputStream.n0(this.k);
        }
        for (int i = 0; i < this.j.size(); i++) {
            codedOutputStream.a0(((Integer) this.j.get(i)).intValue());
        }
        if ((this.d & 2) == 2) {
            codedOutputStream.Z(3, this.f);
        }
        if ((this.d & 4) == 4) {
            codedOutputStream.Z(4, this.g);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            codedOutputStream.c0(5, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.h.get(i2));
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            codedOutputStream.c0(6, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.i.get(i3));
        }
        if (w0().size() > 0) {
            codedOutputStream.n0(58);
            codedOutputStream.n0(this.m);
        }
        for (int i4 = 0; i4 < this.l.size(); i4++) {
            codedOutputStream.a0(((Integer) this.l.get(i4)).intValue());
        }
        for (int i5 = 0; i5 < this.n.size(); i5++) {
            codedOutputStream.c0(8, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.n.get(i5));
        }
        for (int i6 = 0; i6 < this.o.size(); i6++) {
            codedOutputStream.c0(9, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.o.get(i6));
        }
        for (int i7 = 0; i7 < this.p.size(); i7++) {
            codedOutputStream.c0(10, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.p.get(i7));
        }
        for (int i8 = 0; i8 < this.q.size(); i8++) {
            codedOutputStream.c0(11, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.q.get(i8));
        }
        for (int i9 = 0; i9 < this.r.size(); i9++) {
            codedOutputStream.c0(13, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.r.get(i9));
        }
        if (A0().size() > 0) {
            codedOutputStream.n0(130);
            codedOutputStream.n0(this.t);
        }
        for (int i10 = 0; i10 < this.s.size(); i10++) {
            codedOutputStream.a0(((Integer) this.s.get(i10)).intValue());
        }
        if ((this.d & 8) == 8) {
            codedOutputStream.c0(30, this.u);
        }
        for (int i11 = 0; i11 < this.v.size(); i11++) {
            codedOutputStream.Z(31, ((Integer) this.v.get(i11)).intValue());
        }
        if ((this.d & 16) == 16) {
            codedOutputStream.c0(32, this.w);
        }
        aVarZ.a(19000, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.y;
        if (i != -1) {
            return i;
        }
        int iO = (this.d & 1) == 1 ? CodedOutputStream.o(1, this.e) : 0;
        int iP = 0;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            iP += CodedOutputStream.p(((Integer) this.j.get(i2)).intValue());
        }
        int iR = iO + iP;
        if (!D0().isEmpty()) {
            iR = iR + 1 + CodedOutputStream.p(iP);
        }
        this.k = iP;
        if ((this.d & 2) == 2) {
            iR += CodedOutputStream.o(3, this.f);
        }
        if ((this.d & 4) == 4) {
            iR += CodedOutputStream.o(4, this.g);
        }
        for (int i3 = 0; i3 < this.h.size(); i3++) {
            iR += CodedOutputStream.r(5, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.h.get(i3));
        }
        for (int i4 = 0; i4 < this.i.size(); i4++) {
            iR += CodedOutputStream.r(6, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.i.get(i4));
        }
        int iP2 = 0;
        for (int i5 = 0; i5 < this.l.size(); i5++) {
            iP2 += CodedOutputStream.p(((Integer) this.l.get(i5)).intValue());
        }
        int iR2 = iR + iP2;
        if (!w0().isEmpty()) {
            iR2 = iR2 + 1 + CodedOutputStream.p(iP2);
        }
        this.m = iP2;
        for (int i6 = 0; i6 < this.n.size(); i6++) {
            iR2 += CodedOutputStream.r(8, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.n.get(i6));
        }
        for (int i7 = 0; i7 < this.o.size(); i7++) {
            iR2 += CodedOutputStream.r(9, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.o.get(i7));
        }
        for (int i8 = 0; i8 < this.p.size(); i8++) {
            iR2 += CodedOutputStream.r(10, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.p.get(i8));
        }
        for (int i9 = 0; i9 < this.q.size(); i9++) {
            iR2 += CodedOutputStream.r(11, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.q.get(i9));
        }
        for (int i10 = 0; i10 < this.r.size(); i10++) {
            iR2 += CodedOutputStream.r(13, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.r.get(i10));
        }
        int iP3 = 0;
        for (int i11 = 0; i11 < this.s.size(); i11++) {
            iP3 += CodedOutputStream.p(((Integer) this.s.get(i11)).intValue());
        }
        int iR3 = iR2 + iP3;
        if (!A0().isEmpty()) {
            iR3 = iR3 + 2 + CodedOutputStream.p(iP3);
        }
        this.t = iP3;
        if ((this.d & 8) == 8) {
            iR3 += CodedOutputStream.r(30, this.u);
        }
        int iP4 = 0;
        for (int i12 = 0; i12 < this.v.size(); i12++) {
            iP4 += CodedOutputStream.p(((Integer) this.v.get(i12)).intValue());
        }
        int size = iR3 + iP4 + (M0().size() * 2);
        if ((this.d & 16) == 16) {
            size += CodedOutputStream.r(32, this.w);
        }
        int iR4 = size + r() + this.c.size();
        this.y = iR4;
        return iR4;
    }

    public int i0() {
        return this.g;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.x;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!Q0()) {
            this.x = (byte) 0;
            return false;
        }
        for (int i = 0; i < J0(); i++) {
            if (!I0(i).isInitialized()) {
                this.x = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < C0(); i2++) {
            if (!B0(i2).isInitialized()) {
                this.x = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < k0(); i3++) {
            if (!j0(i3).isInitialized()) {
                this.x = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < u0(); i4++) {
            if (!t0(i4).isInitialized()) {
                this.x = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < y0(); i5++) {
            if (!x0(i5).isInitialized()) {
                this.x = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < G0(); i6++) {
            if (!F0(i6).isInitialized()) {
                this.x = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < p0(); i7++) {
            if (!o0(i7).isInitialized()) {
                this.x = (byte) 0;
                return false;
            }
        }
        if (R0() && !L0().isInitialized()) {
            this.x = (byte) 0;
            return false;
        }
        if (q()) {
            this.x = (byte) 1;
            return true;
        }
        this.x = (byte) 0;
        return false;
    }

    public C6765Ow5 j0(int i) {
        return (C6765Ow5) this.n.get(i);
    }

    public int k0() {
        return this.n.size();
    }

    public List l0() {
        return this.n;
    }

    @Override // ir.nasim.V64
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public C6526Nw5 getDefaultInstanceForType() {
        return z;
    }

    public C7477Rw5 o0(int i) {
        return (C7477Rw5) this.r.get(i);
    }

    public int p0() {
        return this.r.size();
    }

    public List q0() {
        return this.r;
    }

    public int r0() {
        return this.e;
    }

    public int s0() {
        return this.f;
    }

    public C7950Tw5 t0(int i) {
        return (C7950Tw5) this.o.get(i);
    }

    public int u0() {
        return this.o.size();
    }

    public List v0() {
        return this.o;
    }

    public List w0() {
        return this.l;
    }

    public C9193Yw5 x0(int i) {
        return (C9193Yw5) this.p.get(i);
    }

    public int y0() {
        return this.p.size();
    }

    public List z0() {
        return this.p;
    }

    private C6526Nw5(h.c cVar) {
        super(cVar);
        this.k = -1;
        this.m = -1;
        this.t = -1;
        this.x = (byte) -1;
        this.y = -1;
        this.c = cVar.d();
    }

    private C6526Nw5(boolean z2) {
        this.k = -1;
        this.m = -1;
        this.t = -1;
        this.x = (byte) -1;
        this.y = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    /* renamed from: ir.nasim.Nw5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private int f;
        private int g;
        private int e = 6;
        private List h = Collections.emptyList();
        private List i = Collections.emptyList();
        private List j = Collections.emptyList();
        private List k = Collections.emptyList();
        private List l = Collections.emptyList();
        private List m = Collections.emptyList();
        private List n = Collections.emptyList();
        private List o = Collections.emptyList();
        private List p = Collections.emptyList();
        private List q = Collections.emptyList();
        private C12644ex5 r = C12644ex5.w();
        private List s = Collections.emptyList();
        private C14464hx5 t = C14464hx5.s();

        private b() {
            C();
        }

        private void A() {
            if ((this.d & 8) != 8) {
                this.h = new ArrayList(this.h);
                this.d |= 8;
            }
        }

        private void B() {
            if ((this.d & 16384) != 16384) {
                this.s = new ArrayList(this.s);
                this.d |= 16384;
            }
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
            if ((this.d & 2048) != 2048) {
                this.p = new ArrayList(this.p);
                this.d |= 2048;
            }
        }

        private void t() {
            if ((this.d & 256) != 256) {
                this.m = new ArrayList(this.m);
                this.d |= 256;
            }
        }

        private void u() {
            if ((this.d & 64) != 64) {
                this.k = new ArrayList(this.k);
                this.d |= 64;
            }
        }

        private void v() {
            if ((this.d & 512) != 512) {
                this.n = new ArrayList(this.n);
                this.d |= 512;
            }
        }

        private void w() {
            if ((this.d & 4096) != 4096) {
                this.q = new ArrayList(this.q);
                this.d |= 4096;
            }
        }

        private void x() {
            if ((this.d & 32) != 32) {
                this.j = new ArrayList(this.j);
                this.d |= 32;
            }
        }

        private void y() {
            if ((this.d & 16) != 16) {
                this.i = new ArrayList(this.i);
                this.d |= 16;
            }
        }

        private void z() {
            if ((this.d & 1024) != 1024) {
                this.o = new ArrayList(this.o);
                this.d |= 1024;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public b e(C6526Nw5 c6526Nw5) {
            if (c6526Nw5 == C6526Nw5.m0()) {
                return this;
            }
            if (c6526Nw5.P0()) {
                I(c6526Nw5.r0());
            }
            if (c6526Nw5.Q0()) {
                J(c6526Nw5.s0());
            }
            if (c6526Nw5.O0()) {
                H(c6526Nw5.i0());
            }
            if (!c6526Nw5.h.isEmpty()) {
                if (this.h.isEmpty()) {
                    this.h = c6526Nw5.h;
                    this.d &= -9;
                } else {
                    A();
                    this.h.addAll(c6526Nw5.h);
                }
            }
            if (!c6526Nw5.i.isEmpty()) {
                if (this.i.isEmpty()) {
                    this.i = c6526Nw5.i;
                    this.d &= -17;
                } else {
                    y();
                    this.i.addAll(c6526Nw5.i);
                }
            }
            if (!c6526Nw5.j.isEmpty()) {
                if (this.j.isEmpty()) {
                    this.j = c6526Nw5.j;
                    this.d &= -33;
                } else {
                    x();
                    this.j.addAll(c6526Nw5.j);
                }
            }
            if (!c6526Nw5.l.isEmpty()) {
                if (this.k.isEmpty()) {
                    this.k = c6526Nw5.l;
                    this.d &= -65;
                } else {
                    u();
                    this.k.addAll(c6526Nw5.l);
                }
            }
            if (!c6526Nw5.n.isEmpty()) {
                if (this.l.isEmpty()) {
                    this.l = c6526Nw5.n;
                    this.d &= -129;
                } else {
                    r();
                    this.l.addAll(c6526Nw5.n);
                }
            }
            if (!c6526Nw5.o.isEmpty()) {
                if (this.m.isEmpty()) {
                    this.m = c6526Nw5.o;
                    this.d &= -257;
                } else {
                    t();
                    this.m.addAll(c6526Nw5.o);
                }
            }
            if (!c6526Nw5.p.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = c6526Nw5.p;
                    this.d &= -513;
                } else {
                    v();
                    this.n.addAll(c6526Nw5.p);
                }
            }
            if (!c6526Nw5.q.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = c6526Nw5.q;
                    this.d &= -1025;
                } else {
                    z();
                    this.o.addAll(c6526Nw5.q);
                }
            }
            if (!c6526Nw5.r.isEmpty()) {
                if (this.p.isEmpty()) {
                    this.p = c6526Nw5.r;
                    this.d &= -2049;
                } else {
                    s();
                    this.p.addAll(c6526Nw5.r);
                }
            }
            if (!c6526Nw5.s.isEmpty()) {
                if (this.q.isEmpty()) {
                    this.q = c6526Nw5.s;
                    this.d &= -4097;
                } else {
                    w();
                    this.q.addAll(c6526Nw5.s);
                }
            }
            if (c6526Nw5.R0()) {
                F(c6526Nw5.L0());
            }
            if (!c6526Nw5.v.isEmpty()) {
                if (this.s.isEmpty()) {
                    this.s = c6526Nw5.v;
                    this.d &= -16385;
                } else {
                    B();
                    this.s.addAll(c6526Nw5.v);
                }
            }
            if (c6526Nw5.S0()) {
                G(c6526Nw5.N0());
            }
            l(c6526Nw5);
            f(d().h(c6526Nw5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C6526Nw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C6526Nw5.A     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Nw5 r3 = (ir.nasim.C6526Nw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Nw5 r4 = (ir.nasim.C6526Nw5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6526Nw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Nw5$b");
        }

        public b F(C12644ex5 c12644ex5) {
            if ((this.d & 8192) != 8192 || this.r == C12644ex5.w()) {
                this.r = c12644ex5;
            } else {
                this.r = C12644ex5.H(this.r).e(c12644ex5).k();
            }
            this.d |= 8192;
            return this;
        }

        public b G(C14464hx5 c14464hx5) {
            if ((this.d & 32768) != 32768 || this.t == C14464hx5.s()) {
                this.t = c14464hx5;
            } else {
                this.t = C14464hx5.C(this.t).e(c14464hx5).k();
            }
            this.d |= 32768;
            return this;
        }

        public b H(int i) {
            this.d |= 4;
            this.g = i;
            return this;
        }

        public b I(int i) {
            this.d |= 1;
            this.e = i;
            return this;
        }

        public b J(int i) {
            this.d |= 2;
            this.f = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C6526Nw5 a() {
            C6526Nw5 c6526Nw5O = o();
            if (c6526Nw5O.isInitialized()) {
                return c6526Nw5O;
            }
            throw a.AbstractC1828a.c(c6526Nw5O);
        }

        public C6526Nw5 o() {
            C6526Nw5 c6526Nw5 = new C6526Nw5(this);
            int i = this.d;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c6526Nw5.e = this.e;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c6526Nw5.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c6526Nw5.g = this.g;
            if ((this.d & 8) == 8) {
                this.h = Collections.unmodifiableList(this.h);
                this.d &= -9;
            }
            c6526Nw5.h = this.h;
            if ((this.d & 16) == 16) {
                this.i = Collections.unmodifiableList(this.i);
                this.d &= -17;
            }
            c6526Nw5.i = this.i;
            if ((this.d & 32) == 32) {
                this.j = Collections.unmodifiableList(this.j);
                this.d &= -33;
            }
            c6526Nw5.j = this.j;
            if ((this.d & 64) == 64) {
                this.k = Collections.unmodifiableList(this.k);
                this.d &= -65;
            }
            c6526Nw5.l = this.k;
            if ((this.d & 128) == 128) {
                this.l = Collections.unmodifiableList(this.l);
                this.d &= -129;
            }
            c6526Nw5.n = this.l;
            if ((this.d & 256) == 256) {
                this.m = Collections.unmodifiableList(this.m);
                this.d &= -257;
            }
            c6526Nw5.o = this.m;
            if ((this.d & 512) == 512) {
                this.n = Collections.unmodifiableList(this.n);
                this.d &= -513;
            }
            c6526Nw5.p = this.n;
            if ((this.d & 1024) == 1024) {
                this.o = Collections.unmodifiableList(this.o);
                this.d &= -1025;
            }
            c6526Nw5.q = this.o;
            if ((this.d & 2048) == 2048) {
                this.p = Collections.unmodifiableList(this.p);
                this.d &= -2049;
            }
            c6526Nw5.r = this.p;
            if ((this.d & 4096) == 4096) {
                this.q = Collections.unmodifiableList(this.q);
                this.d &= -4097;
            }
            c6526Nw5.s = this.q;
            if ((i & 8192) == 8192) {
                i2 |= 8;
            }
            c6526Nw5.u = this.r;
            if ((this.d & 16384) == 16384) {
                this.s = Collections.unmodifiableList(this.s);
                this.d &= -16385;
            }
            c6526Nw5.v = this.s;
            if ((i & 32768) == 32768) {
                i2 |= 16;
            }
            c6526Nw5.w = this.t;
            c6526Nw5.d = i2;
            return c6526Nw5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        private void C() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private C6526Nw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        boolean z2;
        this.k = -1;
        this.m = -1;
        this.t = -1;
        this.x = (byte) -1;
        this.y = -1;
        T0();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z3 = false;
        char c2 = 0;
        while (true) {
            ?? M = 8;
            if (!z3) {
                try {
                    try {
                        int iJ = eVar.J();
                        switch (iJ) {
                            case 0:
                                z2 = true;
                                z3 = true;
                                c2 = c2;
                            case 8:
                                z2 = true;
                                this.d |= 1;
                                this.e = eVar.r();
                                c2 = c2;
                            case 16:
                                int i = (c2 == true ? 1 : 0) & 32;
                                char c3 = c2;
                                if (i != 32) {
                                    this.j = new ArrayList();
                                    c3 = (c2 == true ? 1 : 0) | ' ';
                                }
                                this.j.add(Integer.valueOf(eVar.r()));
                                c2 = c3;
                                z2 = true;
                                c2 = c2;
                            case 18:
                                int i2 = eVar.i(eVar.z());
                                int i3 = (c2 == true ? 1 : 0) & 32;
                                char c4 = c2;
                                if (i3 != 32) {
                                    c4 = c2;
                                    if (eVar.e() > 0) {
                                        this.j = new ArrayList();
                                        c4 = (c2 == true ? 1 : 0) | ' ';
                                    }
                                }
                                while (eVar.e() > 0) {
                                    this.j.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i2);
                                c2 = c4;
                                z2 = true;
                                c2 = c2;
                            case 24:
                                this.d |= 2;
                                this.f = eVar.r();
                                c2 = c2;
                                z2 = true;
                                c2 = c2;
                            case 32:
                                this.d |= 4;
                                this.g = eVar.r();
                                c2 = c2;
                                z2 = true;
                                c2 = c2;
                            case 42:
                                int i4 = (c2 == true ? 1 : 0) & 8;
                                char c5 = c2;
                                if (i4 != 8) {
                                    this.h = new ArrayList();
                                    c5 = (c2 == true ? 1 : 0) | '\b';
                                }
                                this.h.add(eVar.t(C12053dx5.o, fVar));
                                c2 = c5;
                                z2 = true;
                                c2 = c2;
                            case 50:
                                int i5 = (c2 == true ? 1 : 0) & 16;
                                char c6 = c2;
                                if (i5 != 16) {
                                    this.i = new ArrayList();
                                    c6 = (c2 == true ? 1 : 0) | 16;
                                }
                                this.i.add(eVar.t(C10647bx5.v, fVar));
                                c2 = c6;
                                z2 = true;
                                c2 = c2;
                            case Type.NINFO /* 56 */:
                                int i6 = (c2 == true ? 1 : 0) & 64;
                                char c7 = c2;
                                if (i6 != 64) {
                                    this.l = new ArrayList();
                                    c7 = (c2 == true ? 1 : 0) | '@';
                                }
                                this.l.add(Integer.valueOf(eVar.r()));
                                c2 = c7;
                                z2 = true;
                                c2 = c2;
                            case 58:
                                int i7 = eVar.i(eVar.z());
                                int i8 = (c2 == true ? 1 : 0) & 64;
                                char c8 = c2;
                                if (i8 != 64) {
                                    c8 = c2;
                                    if (eVar.e() > 0) {
                                        this.l = new ArrayList();
                                        c8 = (c2 == true ? 1 : 0) | '@';
                                    }
                                }
                                while (eVar.e() > 0) {
                                    this.l.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i7);
                                c2 = c8;
                                z2 = true;
                                c2 = c2;
                            case WKSRecord.Protocol.RVD /* 66 */:
                                int i9 = (c2 == true ? 1 : 0) & 128;
                                char c9 = c2;
                                if (i9 != 128) {
                                    this.n = new ArrayList();
                                    c9 = (c2 == true ? 1 : 0) | 128;
                                }
                                this.n.add(eVar.t(C6765Ow5.k, fVar));
                                c2 = c9;
                                z2 = true;
                                c2 = c2;
                            case 74:
                                int i10 = (c2 == true ? 1 : 0) & 256;
                                char c10 = c2;
                                if (i10 != 256) {
                                    this.o = new ArrayList();
                                    c10 = (c2 == true ? 1 : 0) | 256;
                                }
                                this.o.add(eVar.t(C7950Tw5.t, fVar));
                                c2 = c10;
                                z2 = true;
                                c2 = c2;
                            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                                int i11 = (c2 == true ? 1 : 0) & 512;
                                char c11 = c2;
                                if (i11 != 512) {
                                    this.p = new ArrayList();
                                    c11 = (c2 == true ? 1 : 0) | 512;
                                }
                                this.p.add(eVar.t(C9193Yw5.t, fVar));
                                c2 = c11;
                                z2 = true;
                                c2 = c2;
                            case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
                                int i12 = (c2 == true ? 1 : 0) & 1024;
                                char c12 = c2;
                                if (i12 != 1024) {
                                    this.q = new ArrayList();
                                    c12 = (c2 == true ? 1 : 0) | 1024;
                                }
                                this.q.add(eVar.t(C11410cx5.q, fVar));
                                c2 = c12;
                                z2 = true;
                                c2 = c2;
                            case Type.L64 /* 106 */:
                                int i13 = (c2 == true ? 1 : 0) & 2048;
                                char c13 = c2;
                                if (i13 != 2048) {
                                    this.r = new ArrayList();
                                    c13 = (c2 == true ? 1 : 0) | 2048;
                                }
                                this.r.add(eVar.t(C7477Rw5.i, fVar));
                                c2 = c13;
                                z2 = true;
                                c2 = c2;
                            case 128:
                                int i14 = (c2 == true ? 1 : 0) & 4096;
                                char c14 = c2;
                                if (i14 != 4096) {
                                    this.s = new ArrayList();
                                    c14 = (c2 == true ? 1 : 0) | 4096;
                                }
                                this.s.add(Integer.valueOf(eVar.r()));
                                c2 = c14;
                                z2 = true;
                                c2 = c2;
                            case 130:
                                int i15 = eVar.i(eVar.z());
                                int i16 = (c2 == true ? 1 : 0) & 4096;
                                char c15 = c2;
                                if (i16 != 4096) {
                                    c15 = c2;
                                    if (eVar.e() > 0) {
                                        this.s = new ArrayList();
                                        c15 = (c2 == true ? 1 : 0) | 4096;
                                    }
                                }
                                while (eVar.e() > 0) {
                                    this.s.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i15);
                                c2 = c15;
                                z2 = true;
                                c2 = c2;
                            case 242:
                                C12644ex5.b bVarK = (this.d & 8) == 8 ? this.u.toBuilder() : null;
                                C12644ex5 c12644ex5 = (C12644ex5) eVar.t(C12644ex5.i, fVar);
                                this.u = c12644ex5;
                                if (bVarK != null) {
                                    bVarK.e(c12644ex5);
                                    this.u = bVarK.k();
                                }
                                this.d |= 8;
                                c2 = c2;
                                z2 = true;
                                c2 = c2;
                            case 248:
                                int i17 = (c2 == true ? 1 : 0) & 16384;
                                char c16 = c2;
                                if (i17 != 16384) {
                                    this.v = new ArrayList();
                                    c16 = (c2 == true ? 1 : 0) | 16384;
                                }
                                this.v.add(Integer.valueOf(eVar.r()));
                                c2 = c16;
                                z2 = true;
                                c2 = c2;
                            case Type.TSIG /* 250 */:
                                int i18 = eVar.i(eVar.z());
                                int i19 = (c2 == true ? 1 : 0) & 16384;
                                char c17 = c2;
                                if (i19 != 16384) {
                                    c17 = c2;
                                    if (eVar.e() > 0) {
                                        this.v = new ArrayList();
                                        c17 = (c2 == true ? 1 : 0) | 16384;
                                    }
                                }
                                while (eVar.e() > 0) {
                                    this.v.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i18);
                                c2 = c17;
                                z2 = true;
                                c2 = c2;
                            case Type.AVC /* 258 */:
                                C14464hx5.b bVarE = (this.d & 16) == 16 ? this.w.toBuilder() : null;
                                C14464hx5 c14464hx5 = (C14464hx5) eVar.t(C14464hx5.g, fVar);
                                this.w = c14464hx5;
                                if (bVarE != null) {
                                    bVarE.e(c14464hx5);
                                    this.w = bVarE.k();
                                }
                                this.d |= 16;
                                c2 = c2;
                                z2 = true;
                                c2 = c2;
                            default:
                                M = m(eVar, codedOutputStreamI, fVar, iJ);
                                c2 = c2;
                                if (M == 0) {
                                    z3 = true;
                                    c2 = c2;
                                }
                                z2 = true;
                                c2 = c2;
                        }
                    } catch (Throwable th) {
                        if (((c2 == true ? 1 : 0) & 32) == 32) {
                            this.j = Collections.unmodifiableList(this.j);
                        }
                        if (((c2 == true ? 1 : 0) & 8) == M) {
                            this.h = Collections.unmodifiableList(this.h);
                        }
                        if (((c2 == true ? 1 : 0) & 16) == 16) {
                            this.i = Collections.unmodifiableList(this.i);
                        }
                        if (((c2 == true ? 1 : 0) & 64) == 64) {
                            this.l = Collections.unmodifiableList(this.l);
                        }
                        if (((c2 == true ? 1 : 0) & 128) == 128) {
                            this.n = Collections.unmodifiableList(this.n);
                        }
                        if (((c2 == true ? 1 : 0) & 256) == 256) {
                            this.o = Collections.unmodifiableList(this.o);
                        }
                        if (((c2 == true ? 1 : 0) & 512) == 512) {
                            this.p = Collections.unmodifiableList(this.p);
                        }
                        if (((c2 == true ? 1 : 0) & 1024) == 1024) {
                            this.q = Collections.unmodifiableList(this.q);
                        }
                        if (((c2 == true ? 1 : 0) & 2048) == 2048) {
                            this.r = Collections.unmodifiableList(this.r);
                        }
                        if (((c2 == true ? 1 : 0) & 4096) == 4096) {
                            this.s = Collections.unmodifiableList(this.s);
                        }
                        if (((c2 == true ? 1 : 0) & 16384) == 16384) {
                            this.v = Collections.unmodifiableList(this.v);
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
                if (((c2 == true ? 1 : 0) & 32) == 32) {
                    this.j = Collections.unmodifiableList(this.j);
                }
                if (((c2 == true ? 1 : 0) & 8) == 8) {
                    this.h = Collections.unmodifiableList(this.h);
                }
                if (((c2 == true ? 1 : 0) & 16) == 16) {
                    this.i = Collections.unmodifiableList(this.i);
                }
                if (((c2 == true ? 1 : 0) & 64) == 64) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                if (((c2 == true ? 1 : 0) & 128) == 128) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                if (((c2 == true ? 1 : 0) & 256) == 256) {
                    this.o = Collections.unmodifiableList(this.o);
                }
                if (((c2 == true ? 1 : 0) & 512) == 512) {
                    this.p = Collections.unmodifiableList(this.p);
                }
                if (((c2 == true ? 1 : 0) & 1024) == 1024) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                if (((c2 == true ? 1 : 0) & 2048) == 2048) {
                    this.r = Collections.unmodifiableList(this.r);
                }
                if (((c2 == true ? 1 : 0) & 4096) == 4096) {
                    this.s = Collections.unmodifiableList(this.s);
                }
                if (((c2 == true ? 1 : 0) & 16384) == 16384) {
                    this.v = Collections.unmodifiableList(this.v);
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
}
