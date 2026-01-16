package ir.nasim;

/* renamed from: ir.nasim.rI6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC20000rI6 {
    private static final Object a = new Object();

    public static final Object c(C19409qI6 c19409qI6, int i) {
        Object obj;
        AbstractC13042fc3.i(c19409qI6, "<this>");
        int iA = AbstractC13738gk1.a(c19409qI6.b, c19409qI6.d, i);
        if (iA < 0 || (obj = c19409qI6.c[iA]) == a) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C19409qI6 c19409qI6) {
        int i = c19409qI6.d;
        int[] iArr = c19409qI6.b;
        Object[] objArr = c19409qI6.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        c19409qI6.a = false;
        c19409qI6.d = i2;
    }
}
