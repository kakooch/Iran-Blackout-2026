package ir.nasim;

import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.Lx7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C6043Lx7 implements InterfaceC24081y07 {
    public static final C6043Lx7 b = new C6043Lx7();
    private final List a;

    public C6043Lx7(C14451hw1 c14451hw1) {
        this.a = Collections.singletonList(c14451hw1);
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

    private C6043Lx7() {
        this.a = Collections.emptyList();
    }
}
