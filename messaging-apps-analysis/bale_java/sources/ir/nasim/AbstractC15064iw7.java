package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.iw7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15064iw7 {
    public static final int f(int i, int i2) {
        return (i >> i2) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] g(Object[] objArr, int i, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        AbstractC9648aK.q(objArr, objArr2, 0, 0, i, 6, null);
        AbstractC9648aK.l(objArr, objArr2, i + 2, i, objArr.length);
        objArr2[i] = obj;
        objArr2[i + 1] = obj2;
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] h(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length - 2];
        AbstractC9648aK.q(objArr, objArr2, 0, 0, i, 6, null);
        AbstractC9648aK.l(objArr, objArr2, i, i + 2, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] i(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length - 1];
        AbstractC9648aK.q(objArr, objArr2, 0, 0, i, 6, null);
        AbstractC9648aK.l(objArr, objArr2, i, i + 1, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] j(Object[] objArr, int i, int i2, C12637ew7 c12637ew7) {
        Object[] objArr2 = new Object[objArr.length - 1];
        AbstractC9648aK.q(objArr, objArr2, 0, 0, i, 6, null);
        AbstractC9648aK.l(objArr, objArr2, i, i + 2, i2);
        objArr2[i2 - 2] = c12637ew7;
        AbstractC9648aK.l(objArr, objArr2, i2 - 1, i2, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] k(Object[] objArr, int i, int i2, Object obj, Object obj2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        AbstractC9648aK.l(objArrCopyOf, objArrCopyOf, i + 2, i + 1, objArr.length);
        AbstractC9648aK.l(objArrCopyOf, objArrCopyOf, i2 + 2, i2, i);
        objArrCopyOf[i2] = obj;
        objArrCopyOf[i2 + 1] = obj2;
        return objArrCopyOf;
    }
}
