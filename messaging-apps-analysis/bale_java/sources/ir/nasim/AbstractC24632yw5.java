package ir.nasim;

import ir.nasim.InterfaceC4288Em3;

/* renamed from: ir.nasim.yw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24632yw5 extends AbstractC3912Cw5 implements InterfaceC4288Em3 {
    public AbstractC24632yw5() {
    }

    @Override // ir.nasim.AbstractC15785kA0
    protected InterfaceC9916am3 computeReflected() {
        return AbstractC10882cM5.i(this);
    }

    @Override // ir.nasim.InterfaceC4288Em3
    public InterfaceC4288Em3.a g() {
        return ((InterfaceC4288Em3) getReflected()).g();
    }

    @Override // ir.nasim.UA2
    public Object invoke(Object obj) {
        return get(obj);
    }

    public AbstractC24632yw5(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
