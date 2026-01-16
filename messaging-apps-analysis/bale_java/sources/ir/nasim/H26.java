package ir.nasim;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class H26 {
    public static final XV4 a(String str) {
        AbstractC13042fc3.i(str, "packed");
        List listM0 = AbstractC20762sZ6.M0(str, new char[]{'|'}, false, 0, 6, null);
        return listM0.size() != 2 ? new XV4(str, null) : new XV4(listM0.get(0), listM0.get(1));
    }
}
