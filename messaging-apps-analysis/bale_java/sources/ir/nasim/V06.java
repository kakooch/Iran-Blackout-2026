package ir.nasim;

/* loaded from: classes8.dex */
public abstract class V06 extends U06 implements InterfaceC23005wB2 {
    private final int arity;

    public V06(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        super(interfaceC20295rm1);
        this.arity = i;
    }

    @Override // ir.nasim.InterfaceC23005wB2
    public int getArity() {
        return this.arity;
    }

    @Override // ir.nasim.E90
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strK = AbstractC10882cM5.k(this);
        AbstractC13042fc3.h(strK, "renderLambdaToString(...)");
        return strK;
    }
}
