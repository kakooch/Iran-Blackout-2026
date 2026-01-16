package ir.nasim;

import java.util.Comparator;

/* renamed from: ir.nasim.Ds7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C4112Ds7 implements Comparator {
    public static final C4112Ds7 a = new C4112Ds7();

    private C4112Ds7() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(XV4 xv4, XV4 xv42) {
        int iCompare = Float.compare(((CK5) xv4.e()).l(), ((CK5) xv42.e()).l());
        return iCompare != 0 ? iCompare : Float.compare(((CK5) xv4.e()).e(), ((CK5) xv42.e()).e());
    }
}
