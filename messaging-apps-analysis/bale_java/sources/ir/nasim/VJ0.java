package ir.nasim;

/* loaded from: classes8.dex */
public abstract class VJ0 {
    private final BJ a = new BJ();
    private int b;

    protected final void a(char[] cArr) {
        AbstractC13042fc3.i(cArr, "array");
        synchronized (this) {
            try {
                if (this.b + cArr.length < MJ.a) {
                    this.b += cArr.length;
                    this.a.addLast(cArr);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final char[] b(int i) {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) this.a.Y();
            if (cArr != null) {
                this.b -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[i] : cArr;
    }
}
