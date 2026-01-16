package ir.nasim;

import ir.nasim.Q34;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class Q34 implements YB3 {
    private SortedMap a = new TreeMap(new Comparator() { // from class: ir.nasim.P34
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Q34.w((Q34.a) obj, (Q34.a) obj2);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    class a {
        private long a;
        private long b;

        a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }
    }

    private class b {
        private long a;
        private long b;
        private byte[] c;
        private String d;

        b(long j, long j2, byte[] bArr, String str) {
            this.a = j;
            this.b = j2;
            this.c = bArr;
            this.d = str;
        }

        public byte[] b() {
            return this.c;
        }

        public long c() {
            return this.a;
        }

        public long d() {
            return this.b;
        }

        public String e() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int w(a aVar, a aVar2) {
        return Long.compare(aVar2.b(), aVar.b());
    }

    @Override // ir.nasim.YB3
    public List a(Long l, int i, boolean z) {
        return p(null, l, i);
    }

    @Override // ir.nasim.XB3
    public void b(long j) {
        for (a aVar : this.a.keySet()) {
            if (aVar.a() == j) {
                this.a.remove(aVar);
                return;
            }
        }
    }

    @Override // ir.nasim.XB3
    public IB3 c(long j) {
        b bVar;
        Iterator it = this.a.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            a aVar = (a) it.next();
            if (aVar.a() == j) {
                bVar = (b) this.a.get(aVar);
                break;
            }
        }
        if (bVar != null) {
            return new IB3(bVar.c(), bVar.d(), bVar.e(), bVar.b());
        }
        return null;
    }

    @Override // ir.nasim.XB3
    public void clear() {
        this.a.clear();
    }

    @Override // ir.nasim.YB3
    public List d(Long l, int i) {
        return n(null, l, i);
    }

    @Override // ir.nasim.XB3
    public void e(long[] jArr) {
        for (long j : jArr) {
            b(j);
        }
    }

    @Override // ir.nasim.XB3
    public void f(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j((IB3) it.next());
        }
    }

    @Override // ir.nasim.YB3
    public List g(String str, int i, int i2) {
        return null;
    }

    @Override // ir.nasim.XB3
    public int getCount() {
        return this.a.size();
    }

    @Override // ir.nasim.YB3
    public List h(Long l, int i) {
        b bVar;
        ArrayList arrayList = new ArrayList();
        if (this.a.size() == 0) {
            return arrayList;
        }
        int i2 = 0;
        if (l == null) {
            for (a aVar : this.a.keySet()) {
                if (i2 == i) {
                    break;
                }
                b bVar2 = (b) this.a.get(aVar);
                arrayList.add(new IB3(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.b()));
                i2++;
            }
        } else {
            Iterator it = this.a.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                a aVar2 = (a) it.next();
                if (aVar2.b() == l.longValue()) {
                    bVar = (b) this.a.get(aVar2);
                    break;
                }
            }
            arrayList.addAll(a(l, i, false));
            if (bVar != null) {
                arrayList.add(new IB3(bVar.c(), bVar.d(), bVar.e(), bVar.b()));
            }
            arrayList.addAll(d(l, i));
        }
        return arrayList;
    }

    @Override // ir.nasim.XB3
    public void i(long j, EnumC24659yz5 enumC24659yz5) {
        throw new RuntimeException("deleteByDateToDirection is not implemented for MemoryListStorage !");
    }

    @Override // ir.nasim.XB3
    public void j(IB3 ib3) {
        this.a.put(new a(ib3.b(), ib3.c()), new b(ib3.b(), ib3.c(), ib3.a(), ib3.d() != null ? ib3.d().toLowerCase() : null));
    }

    @Override // ir.nasim.XB3
    public IB3 k(Long l, Long l2) {
        return null;
    }

    @Override // ir.nasim.XB3
    public int l(String str) {
        int i = 0;
        for (b bVar : (b[]) this.a.values().toArray()) {
            if (bVar.d.contains(str)) {
                i++;
            }
        }
        return i;
    }

    @Override // ir.nasim.XB3
    public IB3 m(Long l, Boolean bool) {
        return null;
    }

    @Override // ir.nasim.YB3
    public List n(String str, Long l, int i) {
        ArrayList arrayList = new ArrayList();
        if (this.a.size() == 0) {
            return arrayList;
        }
        int i2 = 0;
        boolean z = (str == null || str.length() == 0) ? false : true;
        if (l == null) {
            for (a aVar : this.a.keySet()) {
                if (i2 == i) {
                    break;
                }
                b bVar = (b) this.a.get(aVar);
                if (!z) {
                    arrayList.add(new IB3(bVar.c(), bVar.d(), bVar.e(), bVar.b()));
                } else if (bVar.e() != null && bVar.e().contains(str)) {
                    arrayList.add(new IB3(bVar.c(), bVar.d(), bVar.e(), bVar.b()));
                }
                i2++;
            }
        } else {
            for (a aVar2 : this.a.keySet()) {
                if (i2 == i) {
                    break;
                }
                if (aVar2.b() < l.longValue()) {
                    b bVar2 = (b) this.a.get(aVar2);
                    if (!z) {
                        arrayList.add(new IB3(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.b()));
                    } else if (bVar2.e() != null && bVar2.e().contains(str)) {
                        arrayList.add(new IB3(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.b()));
                    }
                    i2++;
                }
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.XB3
    public List o() {
        ArrayList arrayList = new ArrayList();
        for (a aVar : this.a.keySet()) {
            b bVar = (b) this.a.get(aVar);
            arrayList.add(new IB3(aVar.a(), bVar.d(), bVar.e(), bVar.b()));
        }
        return arrayList;
    }

    @Override // ir.nasim.YB3
    public List p(String str, Long l, int i) {
        ArrayList arrayList = new ArrayList();
        if (this.a.size() == 0) {
            return arrayList;
        }
        int i2 = 0;
        boolean z = (str == null || str.length() == 0) ? false : true;
        if (l == null) {
            for (a aVar : this.a.keySet()) {
                if (i2 == i) {
                    break;
                }
                b bVar = (b) this.a.get(aVar);
                if (!z) {
                    arrayList.add(new IB3(bVar.c(), bVar.d(), bVar.e(), bVar.b()));
                } else if (bVar.e() != null && bVar.e().contains(str)) {
                    arrayList.add(new IB3(bVar.c(), bVar.d(), bVar.e(), bVar.b()));
                }
                i2++;
            }
        } else {
            for (a aVar2 : this.a.keySet()) {
                if (i2 == i) {
                    break;
                }
                if (aVar2.b() > l.longValue()) {
                    b bVar2 = (b) this.a.get(aVar2);
                    if (!z) {
                        arrayList.add(new IB3(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.b()));
                    } else if (bVar2.e() != null && bVar2.e().contains(str)) {
                        arrayList.add(new IB3(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.b()));
                    }
                    i2++;
                }
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.XB3
    public List q(long j, EnumC24659yz5 enumC24659yz5) {
        throw new RuntimeException("loadKeysByDate is not implemented for MemoryListStorage !");
    }

    @Override // ir.nasim.XB3
    public List r(String str, long j, EnumC24659yz5 enumC24659yz5, int i, boolean z) {
        return null;
    }

    public Long t() {
        if (this.a.size() == 0) {
            return null;
        }
        Iterator it = this.a.keySet().iterator();
        long jC = 0;
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            b bVar = (b) this.a.get((a) it.next());
            if (bVar.d() <= j) {
                long jD = bVar.d();
                jC = bVar.c();
                j = jD;
            }
        }
        return Long.valueOf(jC);
    }

    public Long u() {
        if (this.a.size() == 0) {
            return null;
        }
        Iterator it = this.a.keySet().iterator();
        long jC = 0;
        long j = Long.MIN_VALUE;
        while (it.hasNext()) {
            b bVar = (b) this.a.get((a) it.next());
            if (bVar.d() >= j) {
                long jD = bVar.d();
                jC = bVar.c();
                j = jD;
            }
        }
        return Long.valueOf(jC);
    }

    public boolean v() {
        return getCount() == 0;
    }
}
