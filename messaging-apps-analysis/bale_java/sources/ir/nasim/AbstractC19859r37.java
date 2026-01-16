package ir.nasim;

/* renamed from: ir.nasim.r37, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19859r37 extends AbstractC22163um1 implements InterfaceC23005wB2 {
    private final int a;

    public AbstractC19859r37(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        super(interfaceC20295rm1);
        this.a = i;
    }

    @Override // ir.nasim.InterfaceC23005wB2
    public int getArity() {
        return this.a;
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
