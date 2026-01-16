package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.nq7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17959nq7 {
    public static final C17959nq7 a = new C17959nq7();

    private C17959nq7() {
    }

    private final String b(int i, int i2, int i3) {
        DY6 dy6 = DY6.a;
        String str = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        AbstractC13042fc3.h(str, "format(...)");
        String str2 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        AbstractC13042fc3.h(str2, "format(...)");
        String str3 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        AbstractC13042fc3.h(str3, "format(...)");
        return str + ":" + str2 + ":" + str3;
    }

    private final String c(int i) {
        if (i < 0) {
            return "00";
        }
        if (i < 10) {
            return "0" + i;
        }
        if (i < 100) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        String strSubstring = sb2.toString().substring(r3.length() - 2);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String a(int i) {
        if (i < 60) {
            return c(0) + ":" + c(i);
        }
        if (i < 3600) {
            return c(i / 60) + ":" + c(i % 60);
        }
        return c(i / 3600) + ":" + c((i % 3600) / 60) + ":" + c(i % 60);
    }

    public final String d(double d) {
        int iC = AbstractC20723sV3.c(d) % 86400;
        int i = iC % 3600;
        return b(i % 60, i / 60, iC / 3600);
    }
}
