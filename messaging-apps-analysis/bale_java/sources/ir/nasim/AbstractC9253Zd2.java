package ir.nasim;

import java.util.HashSet;

/* renamed from: ir.nasim.Zd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9253Zd2 {
    private static final HashSet a = new HashSet();
    private static String b = "goog.exo.core";

    public static synchronized void a(String str) {
        if (a.add(str)) {
            b += ", " + str;
        }
    }

    public static synchronized String b() {
        return b;
    }
}
