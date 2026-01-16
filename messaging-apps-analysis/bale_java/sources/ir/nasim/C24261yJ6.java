package ir.nasim;

import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.yJ6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C24261yJ6 implements InterfaceC24081y07 {
    private final List a;
    private final List b;

    public C24261yJ6(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int a(long j) {
        int iD = AbstractC9683aN7.d(this.b, Long.valueOf(j), false, false);
        if (iD < this.b.size()) {
            return iD;
        }
        return -1;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public List h(long j) {
        int iG = AbstractC9683aN7.g(this.b, Long.valueOf(j), true, false);
        return iG == -1 ? Collections.emptyList() : (List) this.a.get(iG);
    }

    @Override // ir.nasim.InterfaceC24081y07
    public long i(int i) {
        AbstractC20011rK.a(i >= 0);
        AbstractC20011rK.a(i < this.b.size());
        return ((Long) this.b.get(i)).longValue();
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int j() {
        return this.b.size();
    }
}
