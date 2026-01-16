package ir.nasim;

import ir.nasim.AbstractC20754sY7;

/* renamed from: ir.nasim.hY2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14212hY2 {
    public static final boolean a(AbstractC20754sY7 abstractC20754sY7, AbstractC20754sY7 abstractC20754sY72, EnumC16433lG3 enumC16433lG3) {
        AbstractC13042fc3.i(abstractC20754sY7, "<this>");
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        if (abstractC20754sY72 == null) {
            return true;
        }
        if ((abstractC20754sY72 instanceof AbstractC20754sY7.b) && (abstractC20754sY7 instanceof AbstractC20754sY7.a)) {
            return true;
        }
        return (((abstractC20754sY7 instanceof AbstractC20754sY7.b) && (abstractC20754sY72 instanceof AbstractC20754sY7.a)) || (abstractC20754sY7.a() == abstractC20754sY72.a() && abstractC20754sY7.b() == abstractC20754sY72.b() && abstractC20754sY72.e(enumC16433lG3) <= abstractC20754sY7.e(enumC16433lG3))) ? false : true;
    }
}
