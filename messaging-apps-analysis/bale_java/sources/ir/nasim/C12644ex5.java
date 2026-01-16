package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.ex5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12644ex5 extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
    private static final C12644ex5 h;
    public static LW4 i = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
    private int c;
    private List d;
    private int e;
    private byte f;
    private int g;

    /* renamed from: ir.nasim.ex5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C12644ex5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C12644ex5(eVar, fVar);
        }
    }

    static {
        C12644ex5 c12644ex5 = new C12644ex5(true);
        h = c12644ex5;
        c12644ex5.F();
    }

    private void F() {
        this.d = Collections.emptyList();
        this.e = -1;
    }

    public static b G() {
        return b.m();
    }

    public static b H(C12644ex5 c12644ex5) {
        return G().e(c12644ex5);
    }

    public static C12644ex5 w() {
        return h;
    }

    public int C() {
        return this.d.size();
    }

    public List D() {
        return this.d;
    }

    public boolean E() {
        return (this.c & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return G();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return H(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            codedOutputStream.c0(1, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.d.get(i2));
        }
        if ((this.c & 1) == 1) {
            codedOutputStream.Z(2, this.e);
        }
        codedOutputStream.h0(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i2 = this.g;
        if (i2 != -1) {
            return i2;
        }
        int iO = 0;
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            iO += CodedOutputStream.r(1, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.d.get(i3));
        }
        if ((this.c & 1) == 1) {
            iO += CodedOutputStream.o(2, this.e);
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
        for (int i2 = 0; i2 < C(); i2++) {
            if (!z(i2).isInitialized()) {
                this.f = (byte) 0;
                return false;
            }
        }
        this.f = (byte) 1;
        return true;
    }

    public int y() {
        return this.e;
    }

    public C10647bx5 z(int i2) {
        return (C10647bx5) this.d.get(i2);
    }

    private C12644ex5(h.b bVar) {
        super(bVar);
        this.f = (byte) -1;
        this.g = -1;
        this.b = bVar.d();
    }

    private C12644ex5(boolean z) {
        this.f = (byte) -1;
        this.g = -1;
        this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C12644ex5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.f = (byte) -1;
        this.g = -1;
        F();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 10) {
                            if (!(z2 & true)) {
                                this.d = new ArrayList();
                                z2 = true;
                            }
                            this.d.add(eVar.t(C10647bx5.v, fVar));
                        } else if (iJ != 16) {
                            if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                            }
                        } else {
                            this.c |= 1;
                            this.e = eVar.r();
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.d = Collections.unmodifiableList(this.d);
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
        if (z2 & true) {
            this.d = Collections.unmodifiableList(this.d);
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

    /* renamed from: ir.nasim.ex5$b */
    public static final class b extends h.b implements V64 {
        private int b;
        private List c = Collections.emptyList();
        private int d = -1;

        private b() {
            o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b m() {
            return new b();
        }

        private void n() {
            if ((this.b & 1) != 1) {
                this.c = new ArrayList(this.c);
                this.b |= 1;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public C12644ex5 a() {
            C12644ex5 c12644ex5K = k();
            if (c12644ex5K.isInitialized()) {
                return c12644ex5K;
            }
            throw a.AbstractC1828a.c(c12644ex5K);
        }

        public C12644ex5 k() {
            C12644ex5 c12644ex5 = new C12644ex5(this);
            int i = this.b;
            if ((i & 1) == 1) {
                this.c = Collections.unmodifiableList(this.c);
                this.b &= -2;
            }
            c12644ex5.d = this.c;
            int i2 = (i & 2) != 2 ? 0 : 1;
            c12644ex5.e = this.d;
            c12644ex5.c = i2;
            return c12644ex5;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return m().e(k());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b e(C12644ex5 c12644ex5) {
            if (c12644ex5 == C12644ex5.w()) {
                return this;
            }
            if (!c12644ex5.d.isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = c12644ex5.d;
                    this.b &= -2;
                } else {
                    n();
                    this.c.addAll(c12644ex5.d);
                }
            }
            if (c12644ex5.E()) {
                r(c12644ex5.y());
            }
            f(d().h(c12644ex5.b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C12644ex5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C12644ex5.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.ex5 r3 = (ir.nasim.C12644ex5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.ex5 r4 = (ir.nasim.C12644ex5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12644ex5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.ex5$b");
        }

        public b r(int i) {
            this.b |= 2;
            this.d = i;
            return this;
        }

        private void o() {
        }
    }
}
