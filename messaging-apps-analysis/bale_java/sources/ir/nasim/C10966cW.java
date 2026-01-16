package ir.nasim;

/* renamed from: ir.nasim.cW, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C10966cW extends AbstractC12750f83 {
    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        int i = this.d;
        int i2 = i + 3;
        if (i2 > this.c.length() || this.c.charAt(i) != '`' || this.c.charAt(i + 1) != '`' || this.c.charAt(i + 2) != '`') {
            return null;
        }
        if ((i > 0 && this.c.charAt(i - 1) == 8204) || (i2 < this.c.length() && this.c.charAt(i2) == 8204)) {
            this.d = i;
            return null;
        }
        int iIndexOf = this.c.indexOf("```", i2);
        if (iIndexOf == -1) {
            this.d = i;
            return null;
        }
        String strSubstring = this.c.substring(i2, iIndexOf);
        if (strSubstring.length() >= 3 && strSubstring.charAt(0) == ' ' && strSubstring.charAt(strSubstring.length() - 1) == ' ' && OW4.d(strSubstring)) {
            strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
        }
        BW0 bw0 = new BW0();
        bw0.n(strSubstring);
        this.d = iIndexOf + 3;
        return bw0;
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '`';
    }
}
