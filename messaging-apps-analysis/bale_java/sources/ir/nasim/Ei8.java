package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Ei8 implements Iterable, InterfaceC22720vi8 {
    private final String a;

    public Ei8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.a = str;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        return new Ei8(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ei8) {
            return this.a.equals(((Ei8) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new Di8(this);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        if (this.a.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.a);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        return Boolean.valueOf(!this.a.isEmpty());
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return new Ai8(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0162  */
    @Override // ir.nasim.InterfaceC22720vi8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.InterfaceC22720vi8 t(java.lang.String r21, ir.nasim.C20322ro8 r22, java.util.List r23) {
        /*
            Method dump skipped, instructions count: 1762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Ei8.t(java.lang.String, ir.nasim.ro8, java.util.List):ir.nasim.vi8");
    }

    public final String toString() {
        return Separators.DOUBLE_QUOTE + this.a + Separators.DOUBLE_QUOTE;
    }
}
