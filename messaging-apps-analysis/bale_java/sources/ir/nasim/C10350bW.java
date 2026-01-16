package ir.nasim;

import java.util.regex.Pattern;

/* renamed from: ir.nasim.bW, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C10350bW extends AbstractC12750f83 {
    private static final Pattern e = C20105rU3.o;

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        this.d++;
        if (j() == '\n') {
            C17149mU2 c17149mU2 = new C17149mU2();
            this.d++;
            return c17149mU2;
        }
        if (this.d < this.c.length()) {
            Pattern pattern = e;
            String str = this.c;
            int i = this.d;
            if (pattern.matcher(str.substring(i, i + 1)).matches()) {
                String str2 = this.c;
                int i2 = this.d;
                C5693Kk7 c5693Kk7P = p(str2, i2, i2 + 1);
                this.d++;
                return c5693Kk7P;
            }
        }
        return o("\\");
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '\\';
    }
}
