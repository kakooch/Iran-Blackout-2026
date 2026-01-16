package ir.nasim;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class JH0 implements InterfaceC24081y07 {
    private final List a;

    public JH0(List list) {
        this.a = list;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public List h(long j) {
        return j >= 0 ? this.a : Collections.emptyList();
    }

    @Override // ir.nasim.InterfaceC24081y07
    public long i(int i) {
        AbstractC20011rK.a(i == 0);
        return 0L;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int j() {
        return 1;
    }
}
