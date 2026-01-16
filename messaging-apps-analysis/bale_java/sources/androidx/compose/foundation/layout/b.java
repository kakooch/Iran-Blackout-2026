package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC13165fm;
import ir.nasim.ED1;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class b extends e.c implements InterfaceC21655tu3 {
    private AbstractC13165fm o;
    private float p;
    private float q;

    public /* synthetic */ b(AbstractC13165fm abstractC13165fm, float f, float f2, ED1 ed1) {
        this(abstractC13165fm, f, f2);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        return a.c(interfaceC12377eW3, this.o, this.p, this.q, zv3, j);
    }

    public final void v2(float f) {
        this.q = f;
    }

    public final void w2(AbstractC13165fm abstractC13165fm) {
        this.o = abstractC13165fm;
    }

    public final void x2(float f) {
        this.p = f;
    }

    private b(AbstractC13165fm abstractC13165fm, float f, float f2) {
        this.o = abstractC13165fm;
        this.p = f;
        this.q = f2;
    }
}
