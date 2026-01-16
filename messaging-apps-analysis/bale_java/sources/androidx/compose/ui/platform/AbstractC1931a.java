package androidx.compose.ui.platform;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC24683z2;

/* renamed from: androidx.compose.ui.platform.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1931a implements InterfaceC24683z2 {
    protected String a;
    private final int[] b = new int[2];

    protected final int[] c(int i, int i2) {
        if (i < 0 || i2 < 0 || i == i2) {
            return null;
        }
        int[] iArr = this.b;
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    protected final String d() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y(ParameterNames.TEXT);
        return null;
    }

    public void e(String str) {
        f(str);
    }

    protected final void f(String str) {
        this.a = str;
    }
}
