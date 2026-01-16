package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class K6 {
    private final FC6 a = new FC6() { // from class: ir.nasim.J6
        @Override // ir.nasim.FC6
        public final void a(Runnable runnable) {
            this.a.k(runnable);
        }
    };
    private C4201Ec6 b;
    private String c;
    private U6 d;
    private HashMap e;

    private void j(Object obj, C9528a7 c9528a7) {
        AbstractC7407Ro7.c(this.a);
        this.d.e(c9528a7);
        this.d.d(obj);
        try {
            if (obj instanceof Runnable) {
                ((Runnable) obj).run();
            } else {
                m(obj);
            }
        } finally {
            AbstractC7407Ro7.b();
            this.d.e(null);
            this.d.d(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Runnable runnable) {
        r().c(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Object obj) {
        r().d(obj);
    }

    public void c() {
        HashMap map = this.e;
        if (map == null) {
            return;
        }
        map.clear();
    }

    public void d(Object obj) {
        if (v().j() != null) {
            v().j().b(s(), obj, this);
        }
        p(new MA1(obj));
    }

    public FC6 e() {
        return this.a;
    }

    protected final String f() {
        return this.c;
    }

    public final void h(Object obj, C9528a7 c9528a7) {
        j(obj, c9528a7);
    }

    public final void i(String str, U6 u6) {
        this.c = str;
        this.d = u6;
    }

    public void m(Object obj) {
        d(obj);
    }

    public void p(Object obj) {
        if (this.d.c() != null) {
            this.d.c().e(obj, r());
        }
    }

    public FE0 q(final Object obj, long j) {
        if (this.b == null) {
            this.b = new C4201Ec6(r());
        }
        return obj instanceof Runnable ? this.b.e((Runnable) obj, j) : this.b.e(new Runnable() { // from class: ir.nasim.I6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l(obj);
            }
        }, j);
    }

    public final C9528a7 r() {
        return this.d.a();
    }

    public final C9528a7 s() {
        return this.d.c();
    }

    public void t() {
        u(0);
    }

    public void u(int i) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        ArrayList arrayList = (ArrayList) this.e.get(Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.e.put(Integer.valueOf(i), arrayList);
        }
        arrayList.add(new SK6(this.d.b(), this.d.c()));
    }

    public final C12736f7 v() {
        return C12736f7.n();
    }

    public void w() {
        x(0);
    }

    public void x(int i) {
        ArrayList arrayList;
        HashMap map = this.e;
        if (map == null || (arrayList = (ArrayList) map.get(Integer.valueOf(i))) == null || arrayList.size() == 0) {
            return;
        }
        C19406qI3.a("stashHandler", "unstashAll size: " + arrayList.size(), new Object[0]);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SK6 sk6 = (SK6) it.next();
            r().g(sk6.a(), sk6.b());
        }
        arrayList.clear();
    }

    public void y() {
        z(0);
    }

    public void z(int i) {
        ArrayList arrayList;
        HashMap map = this.e;
        if (map == null || (arrayList = (ArrayList) map.get(Integer.valueOf(i))) == null || arrayList.size() == 0) {
            return;
        }
        C19406qI3.a("stashHandler", "unstashAllReverse size: " + arrayList.size(), new Object[0]);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SK6 sk6 = (SK6) it.next();
            r().e(sk6.a(), sk6.b());
        }
        arrayList.clear();
    }

    public void n() {
    }

    public void o() {
    }
}
