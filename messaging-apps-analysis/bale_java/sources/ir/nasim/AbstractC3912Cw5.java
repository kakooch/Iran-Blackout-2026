package ir.nasim;

/* renamed from: ir.nasim.Cw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3912Cw5 extends AbstractC15785kA0 implements InterfaceC5239Im3 {
    private final boolean a;

    public AbstractC3912Cw5() {
        this.a = false;
    }

    @Override // ir.nasim.AbstractC15785kA0
    public InterfaceC9916am3 compute() {
        return this.a ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3912Cw5) {
            AbstractC3912Cw5 abstractC3912Cw5 = (AbstractC3912Cw5) obj;
            return getOwner().equals(abstractC3912Cw5.getOwner()) && getName().equals(abstractC3912Cw5.getName()) && getSignature().equals(abstractC3912Cw5.getSignature()) && AbstractC13042fc3.d(getBoundReceiver(), abstractC3912Cw5.getBoundReceiver());
        }
        if (obj instanceof InterfaceC5239Im3) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        InterfaceC9916am3 interfaceC9916am3Compute = compute();
        if (interfaceC9916am3Compute != this) {
            return interfaceC9916am3Compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC15785kA0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public InterfaceC5239Im3 getReflected() {
        if (this.a) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (InterfaceC5239Im3) super.getReflected();
    }

    public AbstractC3912Cw5(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.a = (i & 2) == 2;
    }
}
