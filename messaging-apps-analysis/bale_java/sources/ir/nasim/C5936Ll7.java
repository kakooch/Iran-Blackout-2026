package ir.nasim;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.Ll7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C5936Ll7 {
    private static final Pattern d = Pattern.compile("\\s+");
    private static final AbstractC14535i43 e = AbstractC14535i43.Z("auto", "none");
    private static final AbstractC14535i43 f = AbstractC14535i43.a0("dot", "sesame", "circle");
    private static final AbstractC14535i43 g = AbstractC14535i43.Z("filled", "open");
    private static final AbstractC14535i43 h = AbstractC14535i43.a0("after", "before", "outside");
    public final int a;
    public final int b;
    public final int c;

    private C5936Ll7(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static C5936Ll7 a(String str) {
        if (str == null) {
            return null;
        }
        String strE = AbstractC14083hK.e(str.trim());
        if (strE.isEmpty()) {
            return null;
        }
        return b(AbstractC14535i43.Q(TextUtils.split(strE, d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.C5936Ll7 b(ir.nasim.AbstractC14535i43 r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5936Ll7.b(ir.nasim.i43):ir.nasim.Ll7");
    }
}
