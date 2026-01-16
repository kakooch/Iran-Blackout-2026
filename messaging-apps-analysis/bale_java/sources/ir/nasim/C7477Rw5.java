package ir.nasim;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.Rw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7477Rw5 extends h.d implements V64 {
    private static final C7477Rw5 h;
    public static LW4 i = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private int e;
    private byte f;
    private int g;

    /* renamed from: ir.nasim.Rw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C7477Rw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C7477Rw5(eVar, fVar);
        }
    }

    static {
        C7477Rw5 c7477Rw5 = new C7477Rw5(true);
        h = c7477Rw5;
        c7477Rw5.L();
    }

    public static C7477Rw5 G() {
        return h;
    }

    private void L() {
        this.e = 0;
    }

    public static b M() {
        return b.q();
    }

    public static b N(C7477Rw5 c7477Rw5) {
        return M().e(c7477Rw5);
    }

    @Override // ir.nasim.V64
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public C7477Rw5 getDefaultInstanceForType() {
        return h;
    }

    public int J() {
        return this.e;
    }

    public boolean K() {
        return (this.d & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return N(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 1) == 1) {
            codedOutputStream.Z(1, this.e);
        }
        aVarZ.a(200, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i2 = this.g;
        if (i2 != -1) {
            return i2;
        }
        int iO = ((this.d & 1) == 1 ? CodedOutputStream.o(1, this.e) : 0) + r() + this.c.size();
        this.g = iO;
        return iO;
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
        if (q()) {
            this.f = (byte) 1;
            return true;
        }
        this.f = (byte) 0;
        return false;
    }

    private C7477Rw5(h.c cVar) {
        super(cVar);
        this.f = (byte) -1;
        this.g = -1;
        this.c = cVar.d();
    }

    private C7477Rw5(boolean z) {
        this.f = (byte) -1;
        this.g = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C7477Rw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.f = (byte) -1;
        this.g = -1;
        L();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ != 8) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                this.d |= 1;
                                this.e = eVar.r();
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
                    this.c = bVarB.e();
                    throw th2;
                }
                this.c = bVarB.e();
                j();
                throw th;
            }
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

    /* renamed from: ir.nasim.Rw5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private int e;

        private b() {
            r();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b q() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C7477Rw5 a() {
            C7477Rw5 c7477Rw5O = o();
            if (c7477Rw5O.isInitialized()) {
                return c7477Rw5O;
            }
            throw a.AbstractC1828a.c(c7477Rw5O);
        }

        public C7477Rw5 o() {
            C7477Rw5 c7477Rw5 = new C7477Rw5(this);
            int i = (this.d & 1) != 1 ? 0 : 1;
            c7477Rw5.e = this.e;
            c7477Rw5.d = i;
            return c7477Rw5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public b e(C7477Rw5 c7477Rw5) {
            if (c7477Rw5 == C7477Rw5.G()) {
                return this;
            }
            if (c7477Rw5.K()) {
                u(c7477Rw5.J());
            }
            l(c7477Rw5);
            f(d().h(c7477Rw5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C7477Rw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C7477Rw5.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Rw5 r3 = (ir.nasim.C7477Rw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Rw5 r4 = (ir.nasim.C7477Rw5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7477Rw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Rw5$b");
        }

        public b u(int i) {
            this.d |= 1;
            this.e = i;
            return this;
        }

        private void r() {
        }
    }
}
