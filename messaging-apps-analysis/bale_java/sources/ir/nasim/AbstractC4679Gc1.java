package ir.nasim;

/* renamed from: ir.nasim.Gc1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC4679Gc1 {
    static final /* synthetic */ InterfaceC5239Im3[] a = {AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "uploadChunkSize", "getUploadChunkSize(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "downloadChunkSize", "getDownloadChunkSize(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerWindowSize", "getBandwidthOptimizerWindowSize(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerStartupResetTimeoutInSecond", "getBandwidthOptimizerStartupResetTimeoutInSecond(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerStartupPacingFactor", "getBandwidthOptimizerStartupPacingFactor(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerDrainPacingFactor", "getBandwidthOptimizerDrainPacingFactor(Lir/nasim/config/ConfigurationRepository;)F", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerCruisingGainInByte", "getBandwidthOptimizerCruisingGainInByte(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerMaxAcceptableRttInMillis", "getBandwidthOptimizerMaxAcceptableRttInMillis(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerStartupBoostRttInMillis", "getBandwidthOptimizerStartupBoostRttInMillis(Lir/nasim/config/ConfigurationRepository;)J", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerStartupBoostTransferThresholdUploadInByte", "getBandwidthOptimizerStartupBoostTransferThresholdUploadInByte(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerStartupBoostTransferThresholdDownloadInByte", "getBandwidthOptimizerStartupBoostTransferThresholdDownloadInByte(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerInitialTransferCapacityUploadInByte", "getBandwidthOptimizerInitialTransferCapacityUploadInByte(Lir/nasim/config/ConfigurationRepository;)I", 1)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4679Gc1.class, "bandwidthOptimizerInitialTransferCapacityDownloadInByte", "getBandwidthOptimizerInitialTransferCapacityDownloadInByte(Lir/nasim/config/ConfigurationRepository;)I", 1))};
    private static final C16022ka3 b = new C16022ka3("app.android.upload_chunk_size", 16384);
    private static final C16022ka3 c = new C16022ka3("app.android.download_chunk_size", 32768);
    private static final C16022ka3 d = new C16022ka3("app.android.file.bandwidth_optimizer_window_size", 100);
    private static final C16022ka3 e = new C16022ka3("app.android.file.bandwidth_optimizer_startup_reset_timeout_second", 15);
    private static final C16022ka3 f = new C16022ka3("app.android.file.bandwidth_optimizer_startup_pacing_factor", 2);
    private static final C9958aq2 g = new C9958aq2("app.android.file.bandwidth_optimizer_drain_pacing_factor", 0.3f);
    private static final C16022ka3 h = new C16022ka3("app.android.file.bandwidth_optimizer_cruising_gain_byte", 32768);
    private static final C16022ka3 i = new C16022ka3("app.android.file.bandwidth_optimizer_max_acceptable_rtt_millis", 2000);
    private static final C10853cJ3 j = new C10853cJ3("app.android.file.bandwidth_optimizer_startup_boost_rtt_millis", 100);
    private static final C16022ka3 k = new C16022ka3("app.android.file.bandwidth_optimizer_startup_boost_transfer_upload_millis", 262144);
    private static final C16022ka3 l = new C16022ka3("app.android.file.bandwidth_optimizer_startup_boost_transfer_download_millis", 524288);
    private static final C16022ka3 m = new C16022ka3("app.android.file.bandwidth_optimizer_initial_transfer_capacity_upload_byte", 65536);
    private static final C16022ka3 n = new C16022ka3("app.android.file.bandwidth_optimizer_initial_transfer_capacity_download_byte", 262144);

    public static final int a(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return h.a(interfaceC9824ad1, a[6]).intValue();
    }

    public static final float b(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return g.a(interfaceC9824ad1, a[5]).floatValue();
    }

    public static final int c(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return n.a(interfaceC9824ad1, a[12]).intValue();
    }

    public static final int d(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return m.a(interfaceC9824ad1, a[11]).intValue();
    }

    public static final int e(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return i.a(interfaceC9824ad1, a[7]).intValue();
    }

    public static final long f(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return j.a(interfaceC9824ad1, a[8]).longValue();
    }

    public static final int g(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return l.a(interfaceC9824ad1, a[10]).intValue();
    }

    public static final int h(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return k.a(interfaceC9824ad1, a[9]).intValue();
    }

    public static final int i(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return f.a(interfaceC9824ad1, a[4]).intValue();
    }

    public static final int j(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return e.a(interfaceC9824ad1, a[3]).intValue();
    }

    public static final int k(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return d.a(interfaceC9824ad1, a[2]).intValue();
    }

    public static final PV l(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return new PV(m(interfaceC9824ad1), k(interfaceC9824ad1), a(interfaceC9824ad1), b(interfaceC9824ad1), i(interfaceC9824ad1), f(interfaceC9824ad1), e(interfaceC9824ad1), j(interfaceC9824ad1), c(interfaceC9824ad1), g(interfaceC9824ad1));
    }

    public static final int m(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return c.a(interfaceC9824ad1, a[1]).intValue();
    }

    public static final PV n(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return new PV(o(interfaceC9824ad1), k(interfaceC9824ad1), a(interfaceC9824ad1), b(interfaceC9824ad1), i(interfaceC9824ad1), f(interfaceC9824ad1), e(interfaceC9824ad1), j(interfaceC9824ad1), d(interfaceC9824ad1), h(interfaceC9824ad1));
    }

    public static final int o(InterfaceC9824ad1 interfaceC9824ad1) {
        AbstractC13042fc3.i(interfaceC9824ad1, "<this>");
        return b.a(interfaceC9824ad1, a[0]).intValue();
    }
}
