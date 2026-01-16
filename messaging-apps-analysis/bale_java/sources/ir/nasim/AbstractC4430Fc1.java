package ir.nasim;

/* renamed from: ir.nasim.Fc1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC4430Fc1 {
    static final /* synthetic */ InterfaceC5239Im3[] a = {AbstractC10882cM5.i(new C25226zw5(AbstractC4430Fc1.class, "oldDownloadManagerQueueLimitConfig", "getOldDownloadManagerQueueLimitConfig(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.i(new C25226zw5(AbstractC4430Fc1.class, "newDownloadManagerQueueLimit", "getNewDownloadManagerQueueLimit(Lir/nasim/config/ConfigurationRepository;)I", 1))};
    private static final C16022ka3 b = new C16022ka3("app.android.upload_concurrent_files", 8);
    private static final C16022ka3 c = new C16022ka3("app.android.concurrent_download_count", 8);

    public static final int a(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return c.a(interfaceC9824ad1, a[1]).intValue();
    }

    private static final int b(InterfaceC9824ad1 interfaceC9824ad1) {
        return b.a(interfaceC9824ad1, a[0]).intValue();
    }

    public static final int c(InterfaceC9824ad1 interfaceC9824ad1, boolean z) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return z ? a(interfaceC9824ad1) / 2 : b(interfaceC9824ad1);
    }
}
