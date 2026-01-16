package ir.nasim;

/* renamed from: ir.nasim.Di6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4021Di6 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final UA2 ua2) {
        AbstractC17969nr7.e().z(new InterfaceC3273Ae1() { // from class: ir.nasim.Ci6
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                AbstractC4021Di6.d(ua2, (Boolean) obj, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(UA2 ua2, Boolean bool, Exception exc) {
        AbstractC13042fc3.i(ua2, "$onResult");
        ua2.invoke(Boolean.valueOf(AbstractC13042fc3.d(bool, Boolean.TRUE) && exc == null));
    }

    public static final void e(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onRefreshTlsPublicKeyHashResult");
        if (AbstractC17969nr7.i()) {
            c(ua2);
        }
    }
}
