package ir.nasim;

import java.util.Queue;

/* renamed from: ir.nasim.eb2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C12422eb2 implements OI3 {
    String a;
    C20438s07 b;
    Queue c;

    public C12422eb2(C20438s07 c20438s07, Queue queue) {
        this.b = c20438s07;
        this.a = c20438s07.getName();
        this.c = queue;
    }

    private void h(EnumC8200Uy3 enumC8200Uy3, MO3 mo3, String str, Object[] objArr, Throwable th) {
        C21715u07 c21715u07 = new C21715u07();
        c21715u07.j(System.currentTimeMillis());
        c21715u07.c(enumC8200Uy3);
        c21715u07.d(this.b);
        c21715u07.e(this.a);
        c21715u07.f(mo3);
        c21715u07.g(str);
        c21715u07.h(Thread.currentThread().getName());
        c21715u07.b(objArr);
        c21715u07.i(th);
        this.c.add(c21715u07);
    }

    private void i(EnumC8200Uy3 enumC8200Uy3, MO3 mo3, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            h(enumC8200Uy3, mo3, str, new Object[]{obj}, (Throwable) obj2);
        } else {
            h(enumC8200Uy3, mo3, str, new Object[]{obj, obj2}, null);
        }
    }

    private void o(EnumC8200Uy3 enumC8200Uy3, MO3 mo3, String str, Object[] objArr) {
        Throwable thA = D64.a(objArr);
        if (thA != null) {
            h(enumC8200Uy3, mo3, str, D64.b(objArr), thA);
        } else {
            h(enumC8200Uy3, mo3, str, objArr, null);
        }
    }

    private void t(EnumC8200Uy3 enumC8200Uy3, MO3 mo3, String str, Throwable th) {
        h(enumC8200Uy3, mo3, str, null, th);
    }

    private void v(EnumC8200Uy3 enumC8200Uy3, MO3 mo3, String str, Object obj) {
        h(enumC8200Uy3, mo3, str, new Object[]{obj}, null);
    }

    @Override // ir.nasim.OI3
    public void C(String str, Object... objArr) {
        o(EnumC8200Uy3.INFO, null, str, objArr);
    }

    @Override // ir.nasim.OI3
    public void a(String str, Throwable th) {
        t(EnumC8200Uy3.ERROR, null, str, th);
    }

    @Override // ir.nasim.OI3
    public void b(String str) {
        t(EnumC8200Uy3.DEBUG, null, str, null);
    }

    @Override // ir.nasim.OI3
    public void c(String str, Object obj, Object obj2) {
        i(EnumC8200Uy3.DEBUG, null, str, obj, obj2);
    }

    @Override // ir.nasim.OI3
    public boolean d() {
        return true;
    }

    @Override // ir.nasim.OI3
    public void e(String str, Object obj, Object obj2) {
        i(EnumC8200Uy3.TRACE, null, str, obj, obj2);
    }

    @Override // ir.nasim.OI3
    public void f(String str, Object... objArr) {
        o(EnumC8200Uy3.WARN, null, str, objArr);
    }

    @Override // ir.nasim.OI3
    public void g(String str, Object obj, Object obj2) {
        i(EnumC8200Uy3.WARN, null, str, obj, obj2);
    }

    @Override // ir.nasim.OI3
    public String getName() {
        return this.a;
    }

    @Override // ir.nasim.OI3
    public boolean j() {
        return true;
    }

    @Override // ir.nasim.OI3
    public void k(String str, Object... objArr) {
        o(EnumC8200Uy3.ERROR, null, str, objArr);
    }

    @Override // ir.nasim.OI3
    public void l(String str, Object... objArr) {
        o(EnumC8200Uy3.DEBUG, null, str, objArr);
    }

    @Override // ir.nasim.OI3
    public void m(String str, Throwable th) {
        t(EnumC8200Uy3.WARN, null, str, th);
    }

    @Override // ir.nasim.OI3
    public void n(String str, Object... objArr) {
        o(EnumC8200Uy3.TRACE, null, str, objArr);
    }

    @Override // ir.nasim.OI3
    public void p(String str, Object obj) {
        v(EnumC8200Uy3.INFO, null, str, obj);
    }

    @Override // ir.nasim.OI3
    public void q(String str, Object obj) {
        v(EnumC8200Uy3.WARN, null, str, obj);
    }

    @Override // ir.nasim.OI3
    public void r(String str, Object obj) {
        v(EnumC8200Uy3.TRACE, null, str, obj);
    }

    @Override // ir.nasim.OI3
    public void s(String str, Object obj) {
        v(EnumC8200Uy3.DEBUG, null, str, obj);
    }

    @Override // ir.nasim.OI3
    public void u(String str, Object obj) {
        v(EnumC8200Uy3.ERROR, null, str, obj);
    }

    @Override // ir.nasim.OI3
    public void w(String str, Throwable th) {
        t(EnumC8200Uy3.DEBUG, null, str, th);
    }

    @Override // ir.nasim.OI3
    public void y(String str) {
        t(EnumC8200Uy3.WARN, null, str, null);
    }

    @Override // ir.nasim.OI3
    public void z(String str) {
        t(EnumC8200Uy3.TRACE, null, str, null);
    }
}
