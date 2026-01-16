package ir.nasim;

/* renamed from: ir.nasim.ui5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22127ui5 implements InterfaceC20850si5 {
    private final Object[] a;
    private int b;

    public C22127ui5(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }
        this.a = new Object[i];
    }

    private final boolean c(Object obj) {
        int i = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.a[i2] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC20850si5
    public boolean a(Object obj) {
        AbstractC13042fc3.i(obj, "instance");
        if (!(!c(obj))) {
            throw new IllegalStateException("Already in the pool!".toString());
        }
        int i = this.b;
        Object[] objArr = this.a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = obj;
        this.b = i + 1;
        return true;
    }

    @Override // ir.nasim.InterfaceC20850si5
    public Object b() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object obj = this.a[i2];
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.a[i2] = null;
        this.b--;
        return obj;
    }
}
