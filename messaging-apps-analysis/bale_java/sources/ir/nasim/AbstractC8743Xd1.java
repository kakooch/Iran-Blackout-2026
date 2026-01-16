package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Xd1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8743Xd1 implements InterfaceC12451ee1 {
    private final List a = new ArrayList();
    private Object b;
    private AbstractC15469je1 c;
    private a d;

    /* renamed from: ir.nasim.Xd1$a */
    public interface a {
        void a(List list);

        void b(List list);
    }

    AbstractC8743Xd1(AbstractC15469je1 abstractC15469je1) {
        this.c = abstractC15469je1;
    }

    private void h(a aVar, Object obj) {
        if (this.a.isEmpty() || aVar == null) {
            return;
        }
        if (obj == null || c(obj)) {
            aVar.b(this.a);
        } else {
            aVar.a(this.a);
        }
    }

    @Override // ir.nasim.InterfaceC12451ee1
    public void a(Object obj) {
        this.b = obj;
        h(this.d, obj);
    }

    abstract boolean b(C17810nb8 c17810nb8);

    abstract boolean c(Object obj);

    public boolean d(String str) {
        Object obj = this.b;
        return obj != null && c(obj) && this.a.contains(str);
    }

    public void e(Iterable iterable) {
        this.a.clear();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C17810nb8 c17810nb8 = (C17810nb8) it.next();
            if (b(c17810nb8)) {
                this.a.add(c17810nb8.a);
            }
        }
        if (this.a.isEmpty()) {
            this.c.c(this);
        } else {
            this.c.a(this);
        }
        h(this.d, this.b);
    }

    public void f() {
        if (this.a.isEmpty()) {
            return;
        }
        this.a.clear();
        this.c.c(this);
    }

    public void g(a aVar) {
        if (this.d != aVar) {
            this.d = aVar;
            h(aVar, this.b);
        }
    }
}
