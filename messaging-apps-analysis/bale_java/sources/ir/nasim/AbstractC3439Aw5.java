package ir.nasim;

import ir.nasim.InterfaceC4771Gm3;

/* renamed from: ir.nasim.Aw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3439Aw5 extends AbstractC3912Cw5 implements InterfaceC4771Gm3 {
    public AbstractC3439Aw5(Class cls, String str, String str2, int i) {
        super(AbstractC15785kA0.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // ir.nasim.AbstractC15785kA0
    protected InterfaceC9916am3 computeReflected() {
        return AbstractC10882cM5.j(this);
    }

    @Override // ir.nasim.InterfaceC4771Gm3
    public InterfaceC4771Gm3.a g() {
        return ((InterfaceC4771Gm3) getReflected()).g();
    }

    @Override // ir.nasim.InterfaceC14603iB2
    public Object invoke(Object obj, Object obj2) {
        return u(obj, obj2);
    }
}
