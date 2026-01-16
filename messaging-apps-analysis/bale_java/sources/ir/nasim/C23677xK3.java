package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Rect;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.xK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23677xK3 {
    private Map c;
    private Map d;
    private float e;
    private Map f;
    private List g;
    private C19409qI6 h;
    private C21892uJ3 i;
    private List j;
    private Rect k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private int q;
    private int r;
    private final C35 a = new C35();
    private final HashSet b = new HashSet();
    private int p = 0;

    public void a(String str) {
        JI3.c(str);
        this.b.add(str);
    }

    public Rect b() {
        return this.k;
    }

    public C19409qI6 c() {
        return this.h;
    }

    public float d() {
        return (long) ((e() / this.n) * 1000.0f);
    }

    public float e() {
        return this.m - this.l;
    }

    public float f() {
        return this.m;
    }

    public Map g() {
        return this.f;
    }

    public float h(float f) {
        return AbstractC7323Rf4.i(this.l, this.m, f);
    }

    public float i() {
        return this.n;
    }

    public Map j() {
        float fE = AbstractC16500lN7.e();
        if (fE != this.e) {
            for (Map.Entry entry : this.d.entrySet()) {
                this.d.put((String) entry.getKey(), ((VK3) entry.getValue()).a(this.e / fE));
            }
        }
        this.e = fE;
        return this.d;
    }

    public List k() {
        return this.j;
    }

    public NO3 l(String str) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            NO3 no3 = (NO3) this.g.get(i);
            if (no3.a(str)) {
                return no3;
            }
        }
        return null;
    }

    public int m() {
        return this.p;
    }

    public C35 n() {
        return this.a;
    }

    public List o(String str) {
        return (List) this.c.get(str);
    }

    public float p() {
        return this.l;
    }

    public boolean q() {
        return this.o;
    }

    public boolean r() {
        return !this.d.isEmpty();
    }

    public void s(int i) {
        this.p += i;
    }

    public void t(Rect rect, float f, float f2, float f3, List list, C21892uJ3 c21892uJ3, Map map, Map map2, float f4, C19409qI6 c19409qI6, Map map3, List list2, int i, int i2) {
        this.k = rect;
        this.l = f;
        this.m = f2;
        this.n = f3;
        this.j = list;
        this.i = c21892uJ3;
        this.c = map;
        this.d = map2;
        this.e = f4;
        this.h = c19409qI6;
        this.f = map3;
        this.g = list2;
        this.q = i;
        this.r = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            sb.append(((C6970Pt3) it.next()).z(Separators.HT));
        }
        return sb.toString();
    }

    public C6970Pt3 u(long j) {
        return (C6970Pt3) this.i.f(j);
    }

    public void v(boolean z) {
        this.o = z;
    }

    public void w(boolean z) {
        this.a.b(z);
    }
}
