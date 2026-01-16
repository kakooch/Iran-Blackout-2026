package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.xl3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23931xl3 {
    public static final String a(Object obj, String str) {
        if (str == null) {
            str = obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('@');
        DY6 dy6 = DY6.a;
        String str2 = String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
        AbstractC13042fc3.h(str2, "format(...)");
        sb.append(str2);
        return sb.toString();
    }
}
