package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
public class M34 extends AbstractC9119Yo3 {
    private HashMap g;

    public M34(String str) {
        super(null, str, "", null, null);
        this.g = new HashMap();
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public void a(List list) {
        for (Object obj : list) {
            this.g.put(Long.valueOf(((InterfaceC8844Xo3) obj).a()), obj);
        }
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public void c() {
        this.g.clear();
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public List e() {
        ArrayList arrayList = new ArrayList();
        for (Long l : this.g.keySet()) {
            l.longValue();
            arrayList.add((AbstractC17902nl0) this.g.get(l));
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public AbstractC17902nl0 f(long j) {
        return (AbstractC17902nl0) this.g.get(Long.valueOf(j));
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public List g(long[] jArr) {
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            AbstractC17902nl0 abstractC17902nl0F = f(j);
            if (abstractC17902nl0F != null) {
                arrayList.add(abstractC17902nl0F);
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public void h(long j) {
        this.g.remove(Long.valueOf(j));
    }

    @Override // ir.nasim.AbstractC9119Yo3
    public void d() {
    }
}
