package ir.nasim;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Bw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C3680Bw7 implements InterfaceC24081y07 {
    private final C24044xw7 a;
    private final long[] b;
    private final Map c;
    private final Map d;
    private final Map e;

    public C3680Bw7(C24044xw7 c24044xw7, Map map, Map map2, Map map3) {
        this.a = c24044xw7;
        this.d = map2;
        this.e = map3;
        this.c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.b = c24044xw7.j();
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
        return this.a.h(j, this.c, this.d, this.e);
    }

    @Override // ir.nasim.InterfaceC24081y07
    public long i(int i) {
        return this.b[i];
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int j() {
        return this.b.length;
    }
}
