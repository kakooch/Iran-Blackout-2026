package ir.nasim;

import com.bumptech.glide.Registry;
import ir.nasim.InterfaceC13701gg4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.xl4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23932xl4 {
    private static final c e = new c();
    private static final InterfaceC13701gg4 f = new a();
    private final List a;
    private final c b;
    private final Set c;
    private final InterfaceC20850si5 d;

    /* renamed from: ir.nasim.xl4$a */
    private static class a implements InterfaceC13701gg4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC13701gg4
        public boolean a(Object obj) {
            return false;
        }

        @Override // ir.nasim.InterfaceC13701gg4
        public InterfaceC13701gg4.a b(Object obj, int i, int i2, HL4 hl4) {
            return null;
        }
    }

    /* renamed from: ir.nasim.xl4$b */
    private static class b {
        private final Class a;
        final Class b;
        final InterfaceC14292hg4 c;

        public b(Class cls, Class cls2, InterfaceC14292hg4 interfaceC14292hg4) {
            this.a = cls;
            this.b = cls2;
            this.c = interfaceC14292hg4;
        }

        public boolean a(Class cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean b(Class cls, Class cls2) {
            return a(cls) && this.b.isAssignableFrom(cls2);
        }
    }

    /* renamed from: ir.nasim.xl4$c */
    static class c {
        c() {
        }

        public C23342wl4 a(List list, InterfaceC20850si5 interfaceC20850si5) {
            return new C23342wl4(list, interfaceC20850si5);
        }
    }

    public C23932xl4(InterfaceC20850si5 interfaceC20850si5) {
        this(interfaceC20850si5, e);
    }

    private void a(Class cls, Class cls2, InterfaceC14292hg4 interfaceC14292hg4, boolean z) {
        b bVar = new b(cls, cls2, interfaceC14292hg4);
        List list = this.a;
        list.add(z ? list.size() : 0, bVar);
    }

    private InterfaceC13701gg4 c(b bVar) {
        return (InterfaceC13701gg4) AbstractC3322Aj5.d(bVar.c.d(this));
    }

    private static InterfaceC13701gg4 f() {
        return f;
    }

    synchronized void b(Class cls, Class cls2, InterfaceC14292hg4 interfaceC14292hg4) {
        a(cls, cls2, interfaceC14292hg4, true);
    }

    public synchronized InterfaceC13701gg4 d(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b bVar : this.a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.c.add(bVar);
                    arrayList.add(c(bVar));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.d);
            }
            if (arrayList.size() == 1) {
                return (InterfaceC13701gg4) arrayList.get(0);
            }
            if (!z) {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
            return f();
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    synchronized List e(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.a) {
                if (!this.c.contains(bVar) && bVar.a(cls)) {
                    this.c.add(bVar);
                    arrayList.add(c(bVar));
                    this.c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    synchronized List g(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    C23932xl4(InterfaceC20850si5 interfaceC20850si5, c cVar) {
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = interfaceC20850si5;
        this.b = cVar;
    }
}
