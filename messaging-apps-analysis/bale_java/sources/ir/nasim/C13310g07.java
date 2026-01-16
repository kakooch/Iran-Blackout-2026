package ir.nasim;

import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.g07, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C13310g07 implements InterfaceC24081y07 {
    private final C14451hw1[] a;
    private final long[] b;

    public C13310g07(C14451hw1[] c14451hw1Arr, long[] jArr) {
        this.a = c14451hw1Arr;
        this.b = jArr;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int a(long j) {
        int iE = AbstractC9683aN7.e(this.b, j, false, false);
        if (iE < this.b.length) {
            return iE;
        }
        return -1;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public List h(long j) {
        C14451hw1 c14451hw1;
        int i = AbstractC9683aN7.i(this.b, j, true, false);
        return (i == -1 || (c14451hw1 = this.a[i]) == C14451hw1.r) ? Collections.emptyList() : Collections.singletonList(c14451hw1);
    }

    @Override // ir.nasim.InterfaceC24081y07
    public long i(int i) {
        AbstractC20011rK.a(i >= 0);
        AbstractC20011rK.a(i < this.b.length);
        return this.b[i];
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int j() {
        return this.b.length;
    }
}
