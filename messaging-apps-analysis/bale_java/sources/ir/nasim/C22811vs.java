package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.vs, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22811vs implements InterfaceC4104Ds {
    private final C17380ms a;
    private final C17380ms b;

    public C22811vs(C17380ms c17380ms, C17380ms c17380ms2) {
        this.a = c17380ms;
        this.b = c17380ms2;
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public boolean i() {
        return this.a.i() && this.b.i();
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public AbstractC24408ya0 j() {
        return new OI6(this.a.j(), this.b.j());
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public List k() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
}
