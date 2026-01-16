package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Ne4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
class C6342Ne4 extends EW0 implements InterfaceC5870Le4 {
    Class n;

    C6342Ne4(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.n = cls2;
    }

    @Override // ir.nasim.AbstractC19946rC6
    protected String a(OY6 oy6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(oy6.e(i()));
        if (oy6.b) {
            stringBuffer.append(oy6.g(n()));
        }
        if (oy6.b) {
            stringBuffer.append(Separators.SP);
        }
        stringBuffer.append(oy6.f(f(), g()));
        stringBuffer.append(Separators.DOT);
        stringBuffer.append(j());
        oy6.a(stringBuffer, m());
        oy6.b(stringBuffer, l());
        return stringBuffer.toString();
    }

    public Class n() {
        if (this.n == null) {
            this.n = d(6);
        }
        return this.n;
    }
}
