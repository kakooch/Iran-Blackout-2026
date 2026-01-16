package ir.nasim;

import ir.nasim.InterfaceC4288Em3;

/* renamed from: ir.nasim.Km4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5708Km4 extends AbstractC6674Om4 implements InterfaceC22165um3 {
    public AbstractC5708Km4(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // ir.nasim.AbstractC15785kA0
    protected InterfaceC9916am3 computeReflected() {
        return AbstractC10882cM5.f(this);
    }

    @Override // ir.nasim.InterfaceC4288Em3
    public InterfaceC4288Em3.a g() {
        return ((InterfaceC22165um3) getReflected()).g();
    }

    @Override // ir.nasim.UA2
    public Object invoke(Object obj) {
        return get(obj);
    }
}
