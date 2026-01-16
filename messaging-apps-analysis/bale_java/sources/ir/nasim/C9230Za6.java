package ir.nasim;

import ir.nasim.InterfaceC11814db6;
import java.util.Arrays;

/* renamed from: ir.nasim.Za6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C9230Za6 implements InterfaceC8730Xb6, YM5 {
    private InterfaceC8230Vb6 a;
    private InterfaceC11814db6 b;
    private String c;
    private Object d;
    private Object[] e;
    private InterfaceC11814db6.a f;
    private final SA2 g = new a();

    /* renamed from: ir.nasim.Za6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            InterfaceC8230Vb6 interfaceC8230Vb6 = C9230Za6.this.a;
            C9230Za6 c9230Za6 = C9230Za6.this;
            Object obj = c9230Za6.d;
            if (obj != null) {
                return interfaceC8230Vb6.a(c9230Za6, obj);
            }
            throw new IllegalArgumentException("Value should be initialized".toString());
        }
    }

    public C9230Za6(InterfaceC8230Vb6 interfaceC8230Vb6, InterfaceC11814db6 interfaceC11814db6, String str, Object obj, Object[] objArr) {
        this.a = interfaceC8230Vb6;
        this.b = interfaceC11814db6;
        this.c = str;
        this.d = obj;
        this.e = objArr;
    }

    private final void h() {
        InterfaceC11814db6 interfaceC11814db6 = this.b;
        if (this.f == null) {
            if (interfaceC11814db6 != null) {
                AbstractC9681aN5.f(interfaceC11814db6, this.g.invoke());
                this.f = interfaceC11814db6.f(this.c, this.g);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("entry(" + this.f + ") is not null").toString());
    }

    @Override // ir.nasim.InterfaceC8730Xb6
    public boolean a(Object obj) {
        InterfaceC11814db6 interfaceC11814db6 = this.b;
        return interfaceC11814db6 == null || interfaceC11814db6.a(obj);
    }

    @Override // ir.nasim.YM5
    public void b() {
        h();
    }

    @Override // ir.nasim.YM5
    public void d() {
        InterfaceC11814db6.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // ir.nasim.YM5
    public void e() {
        InterfaceC11814db6.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final Object g(Object[] objArr) {
        if (Arrays.equals(objArr, this.e)) {
            return this.d;
        }
        return null;
    }

    public final void i(InterfaceC8230Vb6 interfaceC8230Vb6, InterfaceC11814db6 interfaceC11814db6, String str, Object obj, Object[] objArr) {
        boolean z;
        boolean z2 = true;
        if (this.b != interfaceC11814db6) {
            this.b = interfaceC11814db6;
            z = true;
        } else {
            z = false;
        }
        if (AbstractC13042fc3.d(this.c, str)) {
            z2 = z;
        } else {
            this.c = str;
        }
        this.a = interfaceC8230Vb6;
        this.d = obj;
        this.e = objArr;
        InterfaceC11814db6.a aVar = this.f;
        if (aVar == null || !z2) {
            return;
        }
        if (aVar != null) {
            aVar.a();
        }
        this.f = null;
        h();
    }
}
