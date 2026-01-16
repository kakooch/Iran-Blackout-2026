package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.vV1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22588vV1 {
    private static int j;
    private final int b;
    private C9528a7 c;
    protected ArrayList[] d;
    protected volatile int e;
    private volatile Object f;
    private final String a = "DisplayList";
    private CopyOnWriteArrayList g = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    private VB3 i = null;

    /* renamed from: ir.nasim.vV1$a */
    public interface a {
        void a(C4311Ep c4311Ep);
    }

    /* renamed from: ir.nasim.vV1$b */
    private static class b {
        private InterfaceC16674lg4 a;
        private Runnable b;
        private boolean c;

        private b(InterfaceC16674lg4 interfaceC16674lg4, Runnable runnable, boolean z) {
            this.a = interfaceC16674lg4;
            this.b = runnable;
            this.c = z;
        }
    }

    /* renamed from: ir.nasim.vV1$c */
    private static class c {
        private f[] a;

        private c(f[] fVarArr) {
            this.a = fVarArr;
        }
    }

    /* renamed from: ir.nasim.vV1$d */
    private static class d extends K6 {
        private ArrayList f;
        private boolean g;
        private AbstractC22588vV1 h;

        /* renamed from: ir.nasim.vV1$d$a */
        class a implements Runnable {
            final /* synthetic */ Object a;
            final /* synthetic */ ArrayList b;
            final /* synthetic */ ArrayList c;
            final /* synthetic */ f[] d;

            a(Object obj, ArrayList arrayList, ArrayList arrayList2, f[] fVarArr) {
                this.a = obj;
                this.b = arrayList;
                this.c = arrayList2;
                this.d = fVarArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.h.e = (d.this.h.e + 1) % 2;
                d.this.h.f = this.a;
                if (this.b != null) {
                    Iterator it = d.this.h.h.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).a(new C4311Ep(this.c, this.b));
                    }
                }
                Iterator it2 = d.this.h.g.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).X0();
                }
                for (f fVar : this.d) {
                    if (fVar.b != null) {
                        fVar.b.run();
                    }
                }
                d.this.r().d(new c(this.d));
            }
        }

        private void D(f[] fVarArr, ArrayList arrayList, ArrayList arrayList2, Object obj) {
            this.g = true;
            AbstractC20507s76.z(new a(obj, arrayList2, arrayList, fVarArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void B(InterfaceC16674lg4 interfaceC16674lg4, Runnable runnable, boolean z) {
            Object[] objArr = 0;
            if (interfaceC16674lg4 != null) {
                this.f.add(new f(interfaceC16674lg4, runnable, z));
            }
            if (this.g || this.f.size() == 0) {
                return;
            }
            AbstractC22588vV1 abstractC22588vV1 = this.h;
            ArrayList arrayList = abstractC22588vV1.d[(abstractC22588vV1.e + 1) % 2];
            ArrayList arrayList2 = new ArrayList(arrayList);
            Iterator it = this.f.iterator();
            while (it.hasNext() && !((f) it.next()).c) {
            }
            f[] fVarArr = {(f) this.f.remove(0)};
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(fVarArr[0].a.a(arrayList));
            D(fVarArr, arrayList2, AbstractC17630nI0.b(arrayList3), this.h.i != null ? this.h.i.a(arrayList, this.h.f) : null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void C(f[] fVarArr) {
            boolean z = false;
            this.g = false;
            AbstractC22588vV1 abstractC22588vV1 = this.h;
            ArrayList arrayList = abstractC22588vV1.d[(abstractC22588vV1.e + 1) % 2];
            for (f fVar : fVarArr) {
                fVar.a.a(arrayList);
            }
            if (this.f.size() > 0) {
                r().d(new b(null, 0 == true ? 1 : 0, z));
            }
        }

        @Override // ir.nasim.K6
        public void m(Object obj) {
            if (obj instanceof c) {
                C(((c) obj).a);
            } else if (!(obj instanceof b)) {
                super.m(obj);
            } else {
                b bVar = (b) obj;
                B(bVar.a, bVar.b, bVar.c);
            }
        }

        private d(AbstractC22588vV1 abstractC22588vV1) {
            this.f = new ArrayList();
            this.h = abstractC22588vV1;
        }
    }

    /* renamed from: ir.nasim.vV1$e */
    public interface e {
        void X0();
    }

    /* renamed from: ir.nasim.vV1$f */
    private static class f {
        private InterfaceC16674lg4 a;
        private Runnable b;
        private boolean c;

        private f(InterfaceC16674lg4 interfaceC16674lg4, Runnable runnable, boolean z) {
            this.a = interfaceC16674lg4;
            this.b = runnable;
            this.c = z;
        }
    }

    static {
        C12736f7.n().h("D_display_list");
        j = 0;
    }

    public AbstractC22588vV1() {
        AbstractC20507s76.e();
        int i = j;
        j = i + 1;
        this.b = i;
        this.c = C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.uV1
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.s();
            }
        }).a("D_display_list"), "display_lists/" + i);
        this.d = new ArrayList[2];
        this.e = 0;
        this.d[0] = new ArrayList();
        this.d[1] = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 s() {
        return new d();
    }

    public void h(a aVar) {
        if (this.h.contains(aVar)) {
            return;
        }
        this.h.add(aVar);
    }

    public void i(e eVar) {
        if (this.g.contains(eVar)) {
            return;
        }
        this.g.add(eVar);
    }

    protected void j() {
        this.c.d(C12485eh5.a);
    }

    public void k(InterfaceC16674lg4 interfaceC16674lg4) {
        l(interfaceC16674lg4, null);
    }

    public void l(InterfaceC16674lg4 interfaceC16674lg4, Runnable runnable) {
        this.c.d(new b(interfaceC16674lg4, runnable, false));
    }

    public void m(InterfaceC16674lg4 interfaceC16674lg4, Runnable runnable, boolean z) {
        this.c.d(new b(interfaceC16674lg4, runnable, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(InterfaceC16674lg4 interfaceC16674lg4, boolean z) {
        this.c.d(new b(interfaceC16674lg4, null, z));
    }

    public Object o(int i) {
        if (i >= 0 && i < this.d[this.e].size()) {
            return this.d[this.e].get(i);
        }
        C19406qI3.b("DisplayList", "Index out of range!");
        return null;
    }

    public VB3 p() {
        return this.i;
    }

    public Object q() {
        return this.f;
    }

    public int r() {
        return this.d[this.e].size();
    }

    public void t(a aVar) {
        this.h.remove(aVar);
    }

    public void u(e eVar) {
        this.g.remove(eVar);
    }

    public void v(VB3 vb3) {
        this.i = vb3;
    }
}
