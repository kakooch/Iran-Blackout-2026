package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.iF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class EnumC14646iF5 {
    public static final EnumC14646iF5 c = new EnumC14646iF5("FREEZE_COUNT", 0, IE3.CLIENT_VIDEO_SUBSCRIBER_FREEZE_COUNT, "freezeCount");
    public static final EnumC14646iF5 d = new EnumC14646iF5("TOTAL_FREEZES_DURATION", 1, IE3.CLIENT_VIDEO_SUBSCRIBER_TOTAL_FREEZE_DURATION, "totalFreezesDuration");
    public static final EnumC14646iF5 e = new EnumC14646iF5("PAUSE_COUNT", 2, IE3.CLIENT_VIDEO_SUBSCRIBER_PAUSE_COUNT, "pauseCount");
    public static final EnumC14646iF5 f = new EnumC14646iF5("TOTAL_PAUSES_DURATION", 3, IE3.CLIENT_VIDEO_SUBSCRIBER_TOTAL_PAUSES_DURATION, "totalPausesDuration");
    public static final EnumC14646iF5 g = new EnumC14646iF5("CONCEALED_SAMPLES", 4, IE3.CLIENT_AUDIO_SUBSCRIBER_CONCEALED_SAMPLES, "concealedSamples");
    public static final EnumC14646iF5 h = new EnumC14646iF5("SILENT_CONCEALED_SAMPLES", 5, IE3.CLIENT_AUDIO_SUBSCRIBER_SILENT_CONCEALED_SAMPLES, "silentConcealedSamples");
    public static final EnumC14646iF5 i = new EnumC14646iF5("CONCEALMENT_EVENTS", 6, IE3.CLIENT_AUDIO_SUBSCRIBER_CONCEALMENT_EVENTS, "concealmentEvents");
    public static final EnumC14646iF5 j = new EnumC14646iF5("JITTER_BUFFER_DELAY", 7, IE3.CLIENT_SUBSCRIBER_JITTER_BUFFER_DELAY, "jitterBufferDelay");
    public static final EnumC14646iF5 k = new EnumC14646iF5("JITTER_BUFFER_EMITTED_COUNT", 8, IE3.CLIENT_SUBSCRIBER_JITTER_BUFFER_EMITTED_COUNT, "jitterBufferEmittedCount");
    public static final EnumC14646iF5 l = new EnumC14646iF5("QUALITY_LIMITATION_DURATION_BANDWIDTH", 9, IE3.CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_BANDWIDTH, "qualityLimitationDurations");
    public static final EnumC14646iF5 m = new EnumC14646iF5("QUALITY_LIMITATION_DURATION_CPU", 10, IE3.CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_CPU, "qualityLimitationDurations");
    public static final EnumC14646iF5 n = new EnumC14646iF5("QUALITY_LIMITATION_DURATION_OTHER", 11, IE3.CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_OTHER, "qualityLimitationDurations");
    private static final /* synthetic */ EnumC14646iF5[] o;
    private static final /* synthetic */ F92 p;
    private final IE3 a;
    private final String b;

    static {
        EnumC14646iF5[] enumC14646iF5ArrA = a();
        o = enumC14646iF5ArrA;
        p = G92.a(enumC14646iF5ArrA);
    }

    private EnumC14646iF5(String str, int i2, IE3 ie3, String str2) {
        this.a = ie3;
        this.b = str2;
    }

    private static final /* synthetic */ EnumC14646iF5[] a() {
        return new EnumC14646iF5[]{c, d, e, f, g, h, i, j, k, l, m, n};
    }

    public static EnumC14646iF5 valueOf(String str) {
        return (EnumC14646iF5) Enum.valueOf(EnumC14646iF5.class, str);
    }

    public static EnumC14646iF5[] values() {
        return (EnumC14646iF5[]) o.clone();
    }

    public final IE3 j() {
        return this.a;
    }

    public final String p() {
        return this.b;
    }
}
