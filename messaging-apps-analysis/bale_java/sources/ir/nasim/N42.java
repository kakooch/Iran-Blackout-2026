package ir.nasim;

/* loaded from: classes2.dex */
public abstract class N42 {
    public static final long a(long j, long j2) {
        int iJ;
        int iL = C4301En7.l(j);
        int iK = C4301En7.k(j);
        if (C4301En7.p(j2, j)) {
            if (C4301En7.d(j2, j)) {
                iL = C4301En7.l(j2);
                iK = iL;
            } else {
                if (C4301En7.d(j, j2)) {
                    iJ = C4301En7.j(j2);
                } else if (C4301En7.e(j2, iL)) {
                    iL = C4301En7.l(j2);
                    iJ = C4301En7.j(j2);
                } else {
                    iK = C4301En7.l(j2);
                }
                iK -= iJ;
            }
        } else if (iK > C4301En7.l(j2)) {
            iL -= C4301En7.j(j2);
            iJ = C4301En7.j(j2);
            iK -= iJ;
        }
        return AbstractC4535Fn7.b(iL, iK);
    }
}
