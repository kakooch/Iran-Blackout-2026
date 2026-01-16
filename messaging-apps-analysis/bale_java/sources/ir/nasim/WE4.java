package ir.nasim;

import android.content.SharedPreferences;

/* loaded from: classes7.dex */
public class WE4 {
    private final int a;

    public WE4(int i) {
        this.a = i;
    }

    private SharedPreferences a() {
        return ir.nasim.tgwidgets.editor.messenger.C.p(this.a);
    }

    public int b(String str, long j, int i, int i2) {
        String strQ = ir.nasim.tgwidgets.editor.messenger.F.q(j, i);
        if (a().contains(str + strQ)) {
            return a().getInt(str + strQ, i2);
        }
        String strQ2 = ir.nasim.tgwidgets.editor.messenger.F.q(j, 0);
        return a().getInt(str + strQ2, i2);
    }
}
