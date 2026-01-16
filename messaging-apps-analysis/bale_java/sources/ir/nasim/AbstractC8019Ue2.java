package ir.nasim;

import java.util.NoSuchElementException;

/* renamed from: ir.nasim.Ue2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8019Ue2 {
    public static final Object a(C3587Bm4 c3587Bm4) {
        if (c3587Bm4.g()) {
            throw new NoSuchElementException("List is empty.");
        }
        int iE = c3587Bm4.e() - 1;
        Object objD = c3587Bm4.d(iE);
        c3587Bm4.A(iE);
        return objD;
    }
}
