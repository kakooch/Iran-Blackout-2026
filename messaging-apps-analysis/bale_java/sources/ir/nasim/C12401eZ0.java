package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.eZ0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C12401eZ0 {
    private HashMap a = new HashMap();
    private HashMap b = new HashMap();
    private HashMap c = new HashMap();
    private HashMap d = new HashMap();
    private List e = new ArrayList();

    /* renamed from: ir.nasim.eZ0$a */
    public static class a {
        private long a;
        private int b;
        private long c;

        public a(long j, int i, long j2) {
            this.a = j;
            this.b = i;
            this.c = j2;
        }

        public int b() {
            return this.b;
        }

        public long c() {
            return this.a;
        }

        public long d() {
            return this.c;
        }
    }

    private void f(HashMap map, C11458d25 c11458d25, long j) {
        if (!map.containsKey(c11458d25)) {
            map.put(c11458d25, Long.valueOf(j));
        } else if (((Long) map.get(c11458d25)).longValue() <= j) {
            map.put(c11458d25, Long.valueOf(j));
        }
    }

    public HashMap a() {
        return this.d;
    }

    public List b() {
        return this.e;
    }

    public HashMap c() {
        return this.b;
    }

    public HashMap d() {
        return this.a;
    }

    public HashMap e() {
        return this.c;
    }

    public void g(CE7 ce7) {
        C11458d25 c11458d25E = ce7.e();
        if (this.d.containsKey(c11458d25E)) {
            ((List) this.d.get(c11458d25E)).add(ce7);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ce7);
        this.d.put(c11458d25E, arrayList);
    }

    public void h(C11458d25 c11458d25, long j) {
        if (this.c.containsKey(c11458d25) && ((Long) this.c.get(c11458d25)).longValue() <= j) {
            this.c.remove(c11458d25);
        }
        f(this.b, c11458d25, j);
    }

    public void i(C11458d25 c11458d25, long j, int i, long j2) {
        if (!this.a.containsKey(c11458d25)) {
            this.a.put(c11458d25, new a(j, i, j2));
        } else if (((a) this.a.get(c11458d25)).a <= j || ((a) this.a.get(c11458d25)).d() < j2) {
            this.a.put(c11458d25, new a(j, i, j2));
        }
    }

    public void j(C11458d25 c11458d25, long j) {
        if (!this.b.containsKey(c11458d25) || ((Long) this.b.get(c11458d25)).longValue() < j) {
            f(this.c, c11458d25, j);
        }
    }
}
