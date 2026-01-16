package ir.nasim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.ro8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20322ro8 {
    public final C20322ro8 a;
    final Oi8 b;
    final Map c = new HashMap();
    final Map d = new HashMap();

    public C20322ro8(C20322ro8 c20322ro8, Oi8 oi8) {
        this.a = c20322ro8;
        this.b = oi8;
    }

    public final C20322ro8 a() {
        return new C20322ro8(this, this.b);
    }

    public final InterfaceC22720vi8 b(InterfaceC22720vi8 interfaceC22720vi8) {
        return this.b.a(this, interfaceC22720vi8);
    }

    public final InterfaceC22720vi8 c(Ch8 ch8) {
        InterfaceC22720vi8 interfaceC22720vi8A = InterfaceC22720vi8.r0;
        Iterator itB = ch8.B();
        while (itB.hasNext()) {
            interfaceC22720vi8A = this.b.a(this, ch8.x(((Integer) itB.next()).intValue()));
            if (interfaceC22720vi8A instanceof Lh8) {
                break;
            }
        }
        return interfaceC22720vi8A;
    }

    public final InterfaceC22720vi8 d(String str) {
        if (this.c.containsKey(str)) {
            return (InterfaceC22720vi8) this.c.get(str);
        }
        C20322ro8 c20322ro8 = this.a;
        if (c20322ro8 != null) {
            return c20322ro8.d(str);
        }
        throw new IllegalArgumentException(String.format("%s is not defined", str));
    }

    public final void e(String str, InterfaceC22720vi8 interfaceC22720vi8) {
        if (this.d.containsKey(str)) {
            return;
        }
        if (interfaceC22720vi8 == null) {
            this.c.remove(str);
        } else {
            this.c.put(str, interfaceC22720vi8);
        }
    }

    public final void f(String str, InterfaceC22720vi8 interfaceC22720vi8) {
        e(str, interfaceC22720vi8);
        this.d.put(str, Boolean.TRUE);
    }

    public final void g(String str, InterfaceC22720vi8 interfaceC22720vi8) {
        C20322ro8 c20322ro8;
        if (!this.c.containsKey(str) && (c20322ro8 = this.a) != null && c20322ro8.h(str)) {
            this.a.g(str, interfaceC22720vi8);
        } else {
            if (this.d.containsKey(str)) {
                return;
            }
            if (interfaceC22720vi8 == null) {
                this.c.remove(str);
            } else {
                this.c.put(str, interfaceC22720vi8);
            }
        }
    }

    public final boolean h(String str) {
        if (this.c.containsKey(str)) {
            return true;
        }
        C20322ro8 c20322ro8 = this.a;
        if (c20322ro8 != null) {
            return c20322ro8.h(str);
        }
        return false;
    }
}
