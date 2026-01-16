package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: ir.nasim.Cz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C3939Cz5 {
    private final RL a = AbstractC20507s76.f(0);
    private final HashMap b = new HashMap();
    private final LinkedList c = new LinkedList();
    private final ArrayList d = new ArrayList();

    public synchronized void a(InterfaceC4173Dz5 interfaceC4173Dz5) {
        if (!this.d.contains(interfaceC4173Dz5)) {
            this.d.add(interfaceC4173Dz5);
        }
    }

    public synchronized void b(int i) {
        C3705Bz5 c3705Bz5 = (C3705Bz5) this.b.remove(Integer.valueOf(i));
        if (c3705Bz5 != null) {
            this.c.remove(c3705Bz5);
        }
    }

    public synchronized C4656Fz5 c() {
        if (this.c.isEmpty()) {
            return null;
        }
        C3705Bz5 c3705Bz5 = (C3705Bz5) this.c.remove(0);
        c3705Bz5.d(true);
        return new C4656Fz5(c3705Bz5.a(), c3705Bz5.b().remove(0));
    }

    public synchronized List d(int i) {
        C3705Bz5 c3705Bz5 = (C3705Bz5) this.b.get(Integer.valueOf(i));
        if (c3705Bz5 == null) {
            return new ArrayList();
        }
        return new ArrayList(c3705Bz5.b());
    }

    public synchronized void e(int i, Object obj) {
        f(i, obj, false);
    }

    public synchronized void f(int i, Object obj, boolean z) {
        try {
            C3705Bz5 c3705Bz5 = (C3705Bz5) this.b.get(Integer.valueOf(i));
            if (c3705Bz5 == null) {
                return;
            }
            boolean zIsEmpty = this.c.isEmpty();
            boolean zIsEmpty2 = c3705Bz5.b().isEmpty();
            if (z) {
                c3705Bz5.b().add(0, obj);
            } else {
                c3705Bz5.b().add(obj);
            }
            if (zIsEmpty2 && !c3705Bz5.c()) {
                this.c.add(c3705Bz5);
            }
            if (zIsEmpty) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((InterfaceC4173Dz5) it.next()).a();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void g(C4656Fz5 c4656Fz5) {
        C3705Bz5 c3705Bz5 = (C3705Bz5) this.b.get(Integer.valueOf(c4656Fz5.a()));
        if (c3705Bz5 == null) {
            return;
        }
        c3705Bz5.d(false);
        if (!c3705Bz5.b().isEmpty()) {
            boolean zIsEmpty = this.c.isEmpty();
            this.c.add(c3705Bz5);
            if (zIsEmpty) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((InterfaceC4173Dz5) it.next()).a();
                }
            }
        }
    }

    public synchronized int h() {
        int iB;
        iB = this.a.b();
        this.b.put(Integer.valueOf(iB), new C3705Bz5(iB));
        return iB;
    }
}
