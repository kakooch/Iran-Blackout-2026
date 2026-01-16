package ir.nasim;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* renamed from: ir.nasim.s07, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C20438s07 implements OI3 {
    private final String a;
    private volatile OI3 b;
    private Boolean c;
    private Method d;
    private C12422eb2 e;
    private Queue f;
    private final boolean g;

    public C20438s07(String str, Queue queue, boolean z) {
        this.a = str;
        this.f = queue;
        this.g = z;
    }

    private OI3 i() {
        if (this.e == null) {
            this.e = new C12422eb2(this, this.f);
        }
        return this.e;
    }

    public void A(OI3 oi3) {
        this.b = oi3;
    }

    @Override // ir.nasim.OI3
    public void C(String str, Object... objArr) {
        h().C(str, objArr);
    }

    @Override // ir.nasim.OI3
    public void a(String str, Throwable th) {
        h().a(str, th);
    }

    @Override // ir.nasim.OI3
    public void b(String str) {
        h().b(str);
    }

    @Override // ir.nasim.OI3
    public void c(String str, Object obj, Object obj2) {
        h().c(str, obj, obj2);
    }

    @Override // ir.nasim.OI3
    public boolean d() {
        return h().d();
    }

    @Override // ir.nasim.OI3
    public void e(String str, Object obj, Object obj2) {
        h().e(str, obj, obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a.equals(((C20438s07) obj).a);
    }

    @Override // ir.nasim.OI3
    public void f(String str, Object... objArr) {
        h().f(str, objArr);
    }

    @Override // ir.nasim.OI3
    public void g(String str, Object obj, Object obj2) {
        h().g(str, obj, obj2);
    }

    @Override // ir.nasim.OI3
    public String getName() {
        return this.a;
    }

    OI3 h() {
        return this.b != null ? this.b : this.g ? C5492Jo4.a : i();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.OI3
    public boolean j() {
        return h().j();
    }

    @Override // ir.nasim.OI3
    public void k(String str, Object... objArr) {
        h().k(str, objArr);
    }

    @Override // ir.nasim.OI3
    public void l(String str, Object... objArr) {
        h().l(str, objArr);
    }

    @Override // ir.nasim.OI3
    public void m(String str, Throwable th) {
        h().m(str, th);
    }

    @Override // ir.nasim.OI3
    public void n(String str, Object... objArr) {
        h().n(str, objArr);
    }

    public boolean o() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.d = this.b.getClass().getMethod("log", TI3.class);
            this.c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.c = Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    @Override // ir.nasim.OI3
    public void p(String str, Object obj) {
        h().p(str, obj);
    }

    @Override // ir.nasim.OI3
    public void q(String str, Object obj) {
        h().q(str, obj);
    }

    @Override // ir.nasim.OI3
    public void r(String str, Object obj) {
        h().r(str, obj);
    }

    @Override // ir.nasim.OI3
    public void s(String str, Object obj) {
        h().s(str, obj);
    }

    public boolean t() {
        return this.b instanceof C5492Jo4;
    }

    @Override // ir.nasim.OI3
    public void u(String str, Object obj) {
        h().u(str, obj);
    }

    public boolean v() {
        return this.b == null;
    }

    @Override // ir.nasim.OI3
    public void w(String str, Throwable th) {
        h().w(str, th);
    }

    public void x(TI3 ti3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (o()) {
            try {
                this.d.invoke(this.b, ti3);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // ir.nasim.OI3
    public void y(String str) {
        h().y(str);
    }

    @Override // ir.nasim.OI3
    public void z(String str) {
        h().z(str);
    }
}
