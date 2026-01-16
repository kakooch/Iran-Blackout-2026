package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.Ws3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8614Ws3 implements InterfaceC23005wB2, Serializable {
    private final int arity;

    public AbstractC8614Ws3(int i) {
        this.arity = i;
    }

    @Override // ir.nasim.InterfaceC23005wB2
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strL = AbstractC10882cM5.l(this);
        AbstractC13042fc3.h(strL, "renderLambdaToString(...)");
        return strL;
    }
}
