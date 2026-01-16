package ir.nasim;

/* loaded from: classes8.dex */
abstract class EW0 extends AbstractC9493a34 implements InterfaceC16991mC6 {
    Class[] k;
    String[] l;
    Class[] m;

    EW0(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.k = clsArr;
        this.l = strArr;
        this.m = clsArr2;
    }

    public Class[] l() {
        if (this.m == null) {
            this.m = e(5);
        }
        return this.m;
    }

    public Class[] m() {
        if (this.k == null) {
            this.k = e(3);
        }
        return this.k;
    }
}
