package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.InputStream;

/* renamed from: ir.nasim.ap0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C9943ap0 extends AbstractC22692vg0 {
    public C9943ap0(InputStream inputStream) {
        super(inputStream);
    }

    private int i() {
        int i = 0;
        while (b() == 0) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((1 << i) - 1) + e(i));
    }

    private void k(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String strValueOf = String.valueOf(AbstractC22692vg0.f - this.e.c());
        int length = 8 - strValueOf.length();
        sb.append(Separators.AT + strValueOf);
        for (int i = 0; i < length; i++) {
            sb.append(' ');
        }
        sb.append(str);
        int length2 = (100 - sb.length()) - this.e.c();
        for (int i2 = 0; i2 < length2; i2++) {
            sb.append(' ');
        }
        sb.append(this.e);
        sb.append(" (" + str2 + Separators.RPAREN);
        this.e.b();
        NA1.a(sb.toString());
    }

    public boolean f(String str) {
        boolean z = b() != 0;
        k(str, z ? "1" : "0");
        return z;
    }

    public long g(int i, String str) {
        long jE = e(i);
        k(str, String.valueOf(jE));
        return jE;
    }

    public int h(int i, String str) {
        return (int) g(i, str);
    }

    public int j(String str) {
        int i = i();
        k(str, String.valueOf(i));
        return i;
    }
}
