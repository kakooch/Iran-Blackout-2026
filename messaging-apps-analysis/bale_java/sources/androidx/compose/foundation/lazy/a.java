package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC17916nm4;
import ir.nasim.InterfaceC4788Go2;
import ir.nasim.InterfaceC6988Pv3;
import ir.nasim.UG6;

/* loaded from: classes.dex */
public final class a implements InterfaceC6988Pv3 {
    private InterfaceC17916nm4 a = UG6.a(Integer.MAX_VALUE);
    private InterfaceC17916nm4 b = UG6.a(Integer.MAX_VALUE);

    @Override // ir.nasim.InterfaceC6988Pv3
    public e a(e eVar, InterfaceC4788Go2 interfaceC4788Go2, InterfaceC4788Go2 interfaceC4788Go22, InterfaceC4788Go2 interfaceC4788Go23) {
        return (interfaceC4788Go2 == null && interfaceC4788Go22 == null && interfaceC4788Go23 == null) ? eVar : eVar.i(new LazyLayoutAnimateItemElement(interfaceC4788Go2, interfaceC4788Go22, interfaceC4788Go23));
    }

    @Override // ir.nasim.InterfaceC6988Pv3
    public e e(e eVar, float f) {
        return eVar.i(new ParentSizeElement(f, null, this.b, "fillParentMaxHeight", 2, null));
    }

    @Override // ir.nasim.InterfaceC6988Pv3
    public e f(e eVar, float f) {
        return eVar.i(new ParentSizeElement(f, this.a, null, "fillParentMaxWidth", 4, null));
    }

    @Override // ir.nasim.InterfaceC6988Pv3
    public e h(e eVar, float f) {
        return eVar.i(new ParentSizeElement(f, this.a, this.b, "fillParentMaxSize"));
    }

    public final void i(int i, int i2) {
        this.a.h(i);
        this.b.h(i2);
    }
}
