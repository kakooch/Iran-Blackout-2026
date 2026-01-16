package ir.nasim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class OM6 extends AbstractC25020zb8 implements Comparable {
    private int a;
    private long b;
    private List c;
    private String d;

    private static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C23698xM6 c23698xM6, C23698xM6 c23698xM62) {
            return Integer.compare(c23698xM6.y(), c23698xM62.y());
        }
    }

    public OM6(GC gc) {
        super(10, gc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OM6 om6 = (OM6) obj;
        ArrayList arrayList = new ArrayList(this.c);
        Collections.sort(arrayList, new a());
        ArrayList arrayList2 = new ArrayList(om6.c);
        Collections.sort(arrayList2, new a());
        return this.a == om6.a && this.d.equals(om6.d) && arrayList.equals(arrayList2);
    }

    public String getName() {
        return this.d;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void applyWrapped(GC gc) {
        this.a = gc.q();
        this.b = gc.getAccessHash();
        this.c = new ArrayList();
        Iterator it = gc.r().iterator();
        while (it.hasNext()) {
            this.c.add(new C23698xM6((HC) it.next(), Integer.valueOf(this.a), Long.valueOf(this.b)));
        }
        if (gc.getName() != null) {
            this.d = gc.getName();
        } else {
            this.d = "";
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(OM6 om6) {
        return this.a - om6.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public GC createInstance() {
        return new GC();
    }

    public int u() {
        return this.a;
    }

    public List w() {
        return this.c;
    }

    public OM6(byte[] bArr) {
        super(10, bArr);
    }
}
