package ir.nasim;

/* renamed from: ir.nasim.vi5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C22717vi5 implements InterfaceC21537ti5 {
    private final Object[] a;
    private int b;

    C22717vi5(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[i];
    }

    @Override // ir.nasim.InterfaceC21537ti5
    public boolean a(Object obj) {
        int i = this.b;
        Object[] objArr = this.a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = obj;
        this.b = i + 1;
        return true;
    }

    @Override // ir.nasim.InterfaceC21537ti5
    public Object b() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.b = i - 1;
        return obj;
    }

    @Override // ir.nasim.InterfaceC21537ti5
    public void c(Object[] objArr, int i) {
        if (i > objArr.length) {
            i = objArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            int i3 = this.b;
            Object[] objArr2 = this.a;
            if (i3 < objArr2.length) {
                objArr2[i3] = obj;
                this.b = i3 + 1;
            }
        }
    }
}
