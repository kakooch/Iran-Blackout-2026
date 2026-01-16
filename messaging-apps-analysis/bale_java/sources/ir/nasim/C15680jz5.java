package ir.nasim;

import ir.nasim.C19451qN3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: ir.nasim.jz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C15680jz5 extends K6 {
    private HL3 f;
    private C9528a7 g;
    private FE0 k;
    private LinkedHashMap h = new LinkedHashMap();
    private HashSet j = new HashSet();
    private HashSet i = new HashSet();

    /* renamed from: ir.nasim.jz5$a */
    public static class a {
        private final long a;

        public a(long j) {
            this.a = j;
        }
    }

    /* renamed from: ir.nasim.jz5$b */
    public static class b {
    }

    /* renamed from: ir.nasim.jz5$c */
    public static class c {
    }

    /* renamed from: ir.nasim.jz5$d */
    public static class d {
        private final long a;
        private final boolean b;

        public d(long j, boolean z) {
            this.a = j;
            this.b = z;
        }
    }

    /* renamed from: ir.nasim.jz5$e */
    public static class e {
        private final long a;

        public e(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.jz5$f */
    public static class f {
    }

    /* renamed from: ir.nasim.jz5$g */
    public static class g {
        private final long a;
        private final byte[] b;

        public g(long j, byte[] bArr) {
            this.a = j;
            this.b = bArr;
        }
    }

    /* renamed from: ir.nasim.jz5$h */
    public static class h {
    }

    public C15680jz5(HL3 hl3) {
        this.f = hl3;
    }

    private L44 B() {
        int size = this.i.size();
        long[] jArr = new long[size];
        HashSet hashSet = this.i;
        Long[] lArr = (Long[]) hashSet.toArray(new Long[hashSet.size()]);
        for (int i = 0; i < size; i++) {
            jArr[i] = lArr[i].longValue();
        }
        this.j.addAll(this.i);
        this.i.clear();
        return new L44(jArr);
    }

    private void C(C20408rx5 c20408rx5) {
        if (this.i.size() <= 0) {
            F(c20408rx5);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c20408rx5);
        D(arrayList);
    }

    private void D(List list) {
        if (list.size() > 0 && this.i.size() > 0) {
            list.add(0, new C20408rx5(NL3.a(), B().b()));
        }
        if (list.size() == 1) {
            C((C20408rx5) list.get(0));
            return;
        }
        if (list.size() > 1) {
            ArrayList arrayList = new ArrayList();
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                C20408rx5 c20408rx5 = (C20408rx5) list.get(i);
                length += c20408rx5.e().length;
                arrayList.add(c20408rx5);
                if (length > 1024) {
                    F(new C20408rx5(NL3.a(), new C11899dk1((C20408rx5[]) arrayList.toArray(new C20408rx5[arrayList.size()])).b()));
                    arrayList.clear();
                    length = 0;
                }
            }
            if (arrayList.size() > 0) {
                F(new C20408rx5(NL3.a(), new C11899dk1((C20408rx5[]) arrayList.toArray(new C20408rx5[arrayList.size()])).b()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 E(HL3 hl3) {
        return new C15680jz5(hl3);
    }

    private void F(C20408rx5 c20408rx5) {
        byte[] bArrB = c20408rx5.b();
        this.g.d(new C19451qN3.j(bArrB, 0, bArrB.length));
    }

    public static C9528a7 G(final HL3 hl3) {
        return C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.iz5
            @Override // ir.nasim.V6
            public final K6 create() {
                return C15680jz5.E(hl3);
            }
        }), hl3.c() + "/sender");
    }

    @Override // ir.nasim.K6
    public void m(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            C20408rx5 c20408rx5 = new C20408rx5(gVar.a, gVar.b);
            this.h.put(Long.valueOf(c20408rx5.d()), c20408rx5);
            C(c20408rx5);
            return;
        }
        if (obj instanceof b) {
            this.i.addAll(this.j);
            this.j.clear();
            ArrayList arrayList = new ArrayList();
            Iterator it = this.h.values().iterator();
            while (it.hasNext()) {
                arrayList.add((C20408rx5) it.next());
            }
            if (arrayList.size() == 0) {
                arrayList.add(new C20408rx5(NL3.a(), new C9401Zt6().b()));
            }
            D(arrayList);
            return;
        }
        if (obj instanceof h) {
            C(new C20408rx5(NL3.a(), new C9401Zt6().b()));
            return;
        }
        if (obj instanceof d) {
            this.h.remove(Long.valueOf(((d) obj).a));
            return;
        }
        if (obj instanceof a) {
            this.i.add(Long.valueOf(((a) obj).a));
            if (this.i.size() >= 10) {
                FE0 fe0 = this.k;
                if (fe0 != null) {
                    fe0.cancel();
                    this.k = null;
                }
                this.k = q(new c(), 0L);
                return;
            }
            if (this.i.size() == 1) {
                FE0 fe02 = this.k;
                if (fe02 != null) {
                    fe02.cancel();
                    this.k = null;
                }
                this.k = q(new c(), 10000L);
                return;
            }
            return;
        }
        if (obj instanceof c) {
            if (this.i.size() == 0) {
                return;
            }
            C(new C20408rx5(NL3.a(), B().b()));
            return;
        }
        if (!(obj instanceof e)) {
            if (!(obj instanceof f) || this.j.size() <= 0) {
                return;
            }
            this.j.clear();
            return;
        }
        e eVar = (e) obj;
        this.j.clear();
        this.i.clear();
        ArrayList arrayList2 = new ArrayList();
        for (C20408rx5 c20408rx52 : this.h.values()) {
            if (c20408rx52.d() < eVar.a()) {
                arrayList2.add(c20408rx52);
            }
        }
        D(arrayList2);
    }

    @Override // ir.nasim.K6
    public void n() {
        this.h = null;
        this.i = null;
        this.j = null;
        this.f = null;
        this.g = null;
    }

    @Override // ir.nasim.K6
    public void o() {
        this.g = C19451qN3.J(this.f);
    }
}
