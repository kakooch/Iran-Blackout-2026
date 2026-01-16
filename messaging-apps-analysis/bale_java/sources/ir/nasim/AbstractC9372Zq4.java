package ir.nasim;

/* renamed from: ir.nasim.Zq4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC9372Zq4 {
    static final /* synthetic */ InterfaceC5239Im3[] a = {AbstractC10882cM5.i(new C25226zw5(AbstractC9372Zq4.class, "fileConnectionPoolCount", "getFileConnectionPoolCount(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.i(new C25226zw5(AbstractC9372Zq4.class, "fileWriteTimeoutInMillis", "getFileWriteTimeoutInMillis(Lir/nasim/config/ConfigurationRepository;)J", 1))};
    private static final C16022ka3 b = new C16022ka3("app.android.file_connection_pool_count", 5);
    private static final C10853cJ3 c = new C10853cJ3("app.android.file_write_timeout_in_millis", 5000);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(InterfaceC9824ad1 interfaceC9824ad1) {
        return b.a(interfaceC9824ad1, a[0]).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long d(InterfaceC9824ad1 interfaceC9824ad1) {
        return c.a(interfaceC9824ad1, a[1]).longValue();
    }
}
