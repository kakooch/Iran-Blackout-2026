package ir.nasim;

/* renamed from: ir.nasim.Hk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4987Hk3 {
    public static final AbstractC11279ck3 a(AbstractC11279ck3 abstractC11279ck3, UA2 ua2) {
        AbstractC13042fc3.i(abstractC11279ck3, "from");
        AbstractC13042fc3.i(ua2, "builderAction");
        C14333hk3 c14333hk3 = new C14333hk3(abstractC11279ck3);
        ua2.invoke(c14333hk3);
        return new C4504Fk3(c14333hk3.a(), c14333hk3.b());
    }

    public static /* synthetic */ AbstractC11279ck3 b(AbstractC11279ck3 abstractC11279ck3, UA2 ua2, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC11279ck3 = AbstractC11279ck3.d;
        }
        return a(abstractC11279ck3, ua2);
    }
}
