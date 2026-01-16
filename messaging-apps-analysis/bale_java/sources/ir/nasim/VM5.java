package ir.nasim;

import java.util.List;

/* loaded from: classes.dex */
public abstract class VM5 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C16143km4 c16143km4, int i, int i2) {
        int iE = c16143km4.e(i);
        c16143km4.n(i, c16143km4.e(i2));
        c16143km4.n(i2, iE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(List list, int i, int i2) {
        Object obj = list.get(i);
        list.set(i, list.get(i2));
        list.set(i2, obj);
    }
}
