package ir.nasim;

/* renamed from: ir.nasim.Aa3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3239Aa3 {
    public static final C25005za3 a(long j, long j2) {
        return new C25005za3(C22045ua3.k(j), C22045ua3.l(j), C22045ua3.k(j) + ((int) (j2 >> 32)), C22045ua3.l(j) + ((int) (j2 & 4294967295L)));
    }

    public static final C25005za3 b(CK5 ck5) {
        return new C25005za3(Math.round(ck5.i()), Math.round(ck5.l()), Math.round(ck5.j()), Math.round(ck5.e()));
    }
}
