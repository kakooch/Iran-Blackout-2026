package ir.nasim;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.oY6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18371oY6 extends kotlinx.serialization.encoding.b implements InterfaceC3329Ak3 {
    private final C22643vb1 a;
    private final AbstractC11279ck3 b;
    private final Gb8 c;
    private final InterfaceC3329Ak3[] d;
    private final AbstractC3859Cq6 e;
    private final C15531jk3 f;
    private boolean g;
    private String h;

    /* renamed from: ir.nasim.oY6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Gb8.values().length];
            try {
                iArr[Gb8.d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Gb8.e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Gb8.f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public C18371oY6(C22643vb1 c22643vb1, AbstractC11279ck3 abstractC11279ck3, Gb8 gb8, InterfaceC3329Ak3[] interfaceC3329Ak3Arr) {
        AbstractC13042fc3.i(c22643vb1, "composer");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(gb8, "mode");
        this.a = c22643vb1;
        this.b = abstractC11279ck3;
        this.c = gb8;
        this.d = interfaceC3329Ak3Arr;
        this.e = d().a();
        this.f = d().d();
        int iOrdinal = gb8.ordinal();
        if (interfaceC3329Ak3Arr != null) {
            InterfaceC3329Ak3 interfaceC3329Ak3 = interfaceC3329Ak3Arr[iOrdinal];
            if (interfaceC3329Ak3 == null && interfaceC3329Ak3 == this) {
                return;
            }
            interfaceC3329Ak3Arr[iOrdinal] = this;
        }
    }

    private final void I(SerialDescriptor serialDescriptor) {
        this.a.c();
        String str = this.h;
        AbstractC13042fc3.f(str);
        F(str);
        this.a.f(':');
        this.a.p();
        F(serialDescriptor.i());
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void A(int i) {
        if (this.g) {
            F(String.valueOf(i));
        } else {
            this.a.i(i);
        }
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void F(String str) {
        AbstractC13042fc3.i(str, "value");
        this.a.n(str);
    }

    @Override // kotlinx.serialization.encoding.b
    public boolean G(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        int i2 = a.a[this.c.ordinal()];
        if (i2 != 1) {
            boolean z = false;
            if (i2 != 2) {
                if (i2 != 3) {
                    if (!this.a.a()) {
                        this.a.f(',');
                    }
                    this.a.c();
                    F(AbstractC7601Sk3.g(serialDescriptor, d(), i));
                    this.a.f(':');
                    this.a.p();
                } else {
                    if (i == 0) {
                        this.g = true;
                    }
                    if (i == 1) {
                        this.a.f(',');
                        this.a.p();
                        this.g = false;
                    }
                }
            } else if (this.a.a()) {
                this.g = true;
                this.a.c();
            } else {
                if (i % 2 == 0) {
                    this.a.f(',');
                    this.a.c();
                    z = true;
                } else {
                    this.a.f(':');
                    this.a.p();
                }
                this.g = z;
            }
        } else {
            if (!this.a.a()) {
                this.a.f(',');
            }
            this.a.c();
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public AbstractC3859Cq6 a() {
        return this.e;
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public kotlinx.serialization.encoding.d b(SerialDescriptor serialDescriptor) {
        InterfaceC3329Ak3 interfaceC3329Ak3;
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        Gb8 gb8B = Hb8.b(d(), serialDescriptor);
        char c = gb8B.a;
        if (c != 0) {
            this.a.f(c);
            this.a.b();
        }
        if (this.h != null) {
            I(serialDescriptor);
            this.h = null;
        }
        if (this.c == gb8B) {
            return this;
        }
        InterfaceC3329Ak3[] interfaceC3329Ak3Arr = this.d;
        return (interfaceC3329Ak3Arr == null || (interfaceC3329Ak3 = interfaceC3329Ak3Arr[gb8B.ordinal()]) == null) ? new C18371oY6(this.a, d(), gb8B, this.d) : interfaceC3329Ak3;
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.d
    public void c(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (this.c.b != 0) {
            this.a.q();
            this.a.d();
            this.a.f(this.c.b);
        }
    }

    @Override // ir.nasim.InterfaceC3329Ak3
    public AbstractC11279ck3 d() {
        return this.b;
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void f(double d) {
        if (this.g) {
            F(String.valueOf(d));
        } else {
            this.a.g(d);
        }
        if (this.f.a()) {
            return;
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw AbstractC3802Ck3.b(Double.valueOf(d), this.a.a.toString());
        }
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void g(byte b) {
        if (this.g) {
            F(String.valueOf((int) b));
        } else {
            this.a.e(b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(ir.nasim.InterfaceC22798vq6 r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.String r0 = "serializer"
            ir.nasim.AbstractC13042fc3.i(r4, r0)
            ir.nasim.ck3 r0 = r3.d()
            ir.nasim.jk3 r0 = r0.d()
            boolean r0 = r0.o()
            if (r0 == 0) goto L18
            r4.serialize(r3, r5)
            goto Lc3
        L18:
            boolean r0 = r4 instanceof ir.nasim.AbstractC24673z1
            if (r0 == 0) goto L2d
            ir.nasim.ck3 r1 = r3.d()
            ir.nasim.jk3 r1 = r1.d()
            ir.nasim.yU0 r1 = r1.e()
            ir.nasim.yU0 r2 = ir.nasim.EnumC24354yU0.a
            if (r1 == r2) goto L75
            goto L62
        L2d:
            ir.nasim.ck3 r1 = r3.d()
            ir.nasim.jk3 r1 = r1.d()
            ir.nasim.yU0 r1 = r1.e()
            int[] r2 = ir.nasim.AbstractC13131fi5.a.a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L75
            r2 = 2
            if (r1 == r2) goto L75
            r2 = 3
            if (r1 != r2) goto L6f
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            ir.nasim.qq6 r1 = r1.f()
            ir.nasim.IZ6$a r2 = ir.nasim.IZ6.a.a
            boolean r2 = ir.nasim.AbstractC13042fc3.d(r1, r2)
            if (r2 != 0) goto L62
            ir.nasim.IZ6$d r2 = ir.nasim.IZ6.d.a
            boolean r1 = ir.nasim.AbstractC13042fc3.d(r1, r2)
            if (r1 == 0) goto L75
        L62:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            ir.nasim.ck3 r2 = r3.d()
            java.lang.String r1 = ir.nasim.AbstractC13131fi5.c(r1, r2)
            goto L76
        L6f:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L75:
            r1 = 0
        L76:
            if (r0 == 0) goto Lbc
            r0 = r4
            ir.nasim.z1 r0 = (ir.nasim.AbstractC24673z1) r0
            if (r5 == 0) goto L98
            ir.nasim.vq6 r0 = ir.nasim.AbstractC14313hi5.b(r0, r3, r5)
            if (r1 == 0) goto L86
            ir.nasim.AbstractC13131fi5.a(r4, r0, r1)
        L86:
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            ir.nasim.qq6 r4 = r4.f()
            ir.nasim.AbstractC13131fi5.b(r4)
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>"
            ir.nasim.AbstractC13042fc3.g(r0, r4)
            r4 = r0
            goto Lbc
        L98:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Value for serializer "
            r5.append(r0)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r4.getDescriptor()
            r5.append(r4)
            java.lang.String r4 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        Lbc:
            if (r1 == 0) goto Lc0
            r3.h = r1
        Lc0:
            r4.serialize(r3, r5)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18371oY6.h(ir.nasim.vq6, java.lang.Object):void");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void j(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "enumDescriptor");
        F(serialDescriptor.e(i));
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public Encoder k(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (AbstractC18962pY6.b(serialDescriptor)) {
            C22643vb1 c4421Fb1 = this.a;
            if (!(c4421Fb1 instanceof C4421Fb1)) {
                c4421Fb1 = new C4421Fb1(c4421Fb1.a, this.g);
            }
            return new C18371oY6(c4421Fb1, d(), this.c, (InterfaceC3329Ak3[]) null);
        }
        if (!AbstractC18962pY6.a(serialDescriptor)) {
            return super.k(serialDescriptor);
        }
        C22643vb1 c23829xb1 = this.a;
        if (!(c23829xb1 instanceof C23829xb1)) {
            c23829xb1 = new C23829xb1(c23829xb1.a, this.g);
        }
        return new C18371oY6(c23829xb1, d(), this.c, (InterfaceC3329Ak3[]) null);
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void l(long j) {
        if (this.g) {
            F(String.valueOf(j));
        } else {
            this.a.j(j);
        }
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.d
    public void m(SerialDescriptor serialDescriptor, int i, InterfaceC22798vq6 interfaceC22798vq6, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(interfaceC22798vq6, "serializer");
        if (obj != null || this.f.i()) {
            super.m(serialDescriptor, i, interfaceC22798vq6, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o() {
        this.a.k("null");
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void q(short s) {
        if (this.g) {
            F(String.valueOf((int) s));
        } else {
            this.a.l(s);
        }
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void r(boolean z) {
        if (this.g) {
            F(String.valueOf(z));
        } else {
            this.a.m(z);
        }
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void t(float f) {
        if (this.g) {
            F(String.valueOf(f));
        } else {
            this.a.h(f);
        }
        if (this.f.a()) {
            return;
        }
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw AbstractC3802Ck3.b(Float.valueOf(f), this.a.a.toString());
        }
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.Encoder
    public void u(char c) {
        F(String.valueOf(c));
    }

    @Override // kotlinx.serialization.encoding.b, kotlinx.serialization.encoding.d
    public boolean z(SerialDescriptor serialDescriptor, int i) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return this.f.h();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C18371oY6(InterfaceC6075Mb3 interfaceC6075Mb3, AbstractC11279ck3 abstractC11279ck3, Gb8 gb8, InterfaceC3329Ak3[] interfaceC3329Ak3Arr) {
        this(AbstractC5606Kb1.a(interfaceC6075Mb3, abstractC11279ck3), abstractC11279ck3, gb8, interfaceC3329Ak3Arr);
        AbstractC13042fc3.i(interfaceC6075Mb3, "output");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(gb8, "mode");
        AbstractC13042fc3.i(interfaceC3329Ak3Arr, "modeReuseCache");
    }
}
