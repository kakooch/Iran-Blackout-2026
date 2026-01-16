package ir.nasim;

import java.util.Comparator;

/* renamed from: ir.nasim.d76, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C11509d76 implements Comparator {
    public static final C11509d76 a = new C11509d76();

    private C11509d76() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C7631Sn6 c7631Sn6, C7631Sn6 c7631Sn62) {
        CK5 ck5J = c7631Sn6.j();
        CK5 ck5J2 = c7631Sn62.j();
        int iCompare = Float.compare(ck5J2.j(), ck5J.j());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Float.compare(ck5J.l(), ck5J2.l());
        if (iCompare2 != 0) {
            return iCompare2;
        }
        int iCompare3 = Float.compare(ck5J.e(), ck5J2.e());
        return iCompare3 != 0 ? iCompare3 : Float.compare(ck5J2.i(), ck5J.i());
    }
}
