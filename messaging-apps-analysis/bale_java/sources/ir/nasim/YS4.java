package ir.nasim;

/* loaded from: classes2.dex */
public abstract class YS4 {
    public static final boolean a(OE2 oe2, OE2 oe22, EnumC16433lG3 enumC16433lG3) {
        AbstractC13042fc3.i(oe2, "<this>");
        AbstractC13042fc3.i(oe22, "previous");
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        if (oe2.a() > oe22.a()) {
            return true;
        }
        if (oe2.a() < oe22.a()) {
            return false;
        }
        return AbstractC14212hY2.a(oe2.b(), oe22.b(), enumC16433lG3);
    }
}
