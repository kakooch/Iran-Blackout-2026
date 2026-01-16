package ir.nasim;

/* loaded from: classes8.dex */
public abstract class DB2 extends AbstractC15785kA0 implements InterfaceC23005wB2, InterfaceC16733lm3 {
    private final int arity;
    private final int flags;

    public DB2(int i) {
        this(i, AbstractC15785kA0.NO_RECEIVER, null, null, null, 0);
    }

    @Override // ir.nasim.AbstractC15785kA0
    protected InterfaceC9916am3 computeReflected() {
        return AbstractC10882cM5.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DB2) {
            DB2 db2 = (DB2) obj;
            return getName().equals(db2.getName()) && getSignature().equals(db2.getSignature()) && this.flags == db2.flags && this.arity == db2.arity && AbstractC13042fc3.d(getBoundReceiver(), db2.getBoundReceiver()) && AbstractC13042fc3.d(getOwner(), db2.getOwner());
        }
        if (obj instanceof InterfaceC16733lm3) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC23005wB2
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        InterfaceC9916am3 interfaceC9916am3Compute = compute();
        if (interfaceC9916am3Compute != this) {
            return interfaceC9916am3Compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public DB2(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15785kA0
    public InterfaceC16733lm3 getReflected() {
        return (InterfaceC16733lm3) super.getReflected();
    }

    public DB2(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
