package ir.nasim;

import livekit.org.webrtc.MediaStreamTrack;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.j74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC15168j74 {
    public static final a b;
    public static final EnumC15168j74 c = new EnumC15168j74("PHOTO", 0, "photo");
    public static final EnumC15168j74 d = new EnumC15168j74("VIDEO", 1, MediaStreamTrack.VIDEO_TRACK_KIND);
    public static final EnumC15168j74 e = new EnumC15168j74("GIF", 2, "gif");
    public static final EnumC15168j74 f = new EnumC15168j74("VOICE", 3, "voice");
    public static final EnumC15168j74 g = new EnumC15168j74("AUDIO", 4, MediaStreamTrack.AUDIO_TRACK_KIND);
    public static final EnumC15168j74 h = new EnumC15168j74("DOCUMENT", 5, "document");
    private static final /* synthetic */ EnumC15168j74[] i;
    private static final /* synthetic */ F92 j;
    private final String a;

    /* renamed from: ir.nasim.j74$a */
    public static final class a {
        private a() {
        }

        public final String a(C24967zW1 c24967zW1) {
            AbstractC13042fc3.i(c24967zW1, "documentContent");
            return (c24967zW1 instanceof C13388g85 ? EnumC15168j74.c : c24967zW1 instanceof GS7 ? EnumC15168j74.d : c24967zW1 instanceof XG2 ? EnumC15168j74.e : c24967zW1 instanceof J08 ? EnumC15168j74.f : c24967zW1 instanceof TM ? EnumC15168j74.g : EnumC15168j74.h).getValue();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC15168j74[] enumC15168j74ArrA = a();
        i = enumC15168j74ArrA;
        j = G92.a(enumC15168j74ArrA);
        b = new a(null);
    }

    private EnumC15168j74(String str, int i2, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ EnumC15168j74[] a() {
        return new EnumC15168j74[]{c, d, e, f, g, h};
    }

    public static EnumC15168j74 valueOf(String str) {
        return (EnumC15168j74) Enum.valueOf(EnumC15168j74.class, str);
    }

    public static EnumC15168j74[] values() {
        return (EnumC15168j74[]) i.clone();
    }

    public final String getValue() {
        return this.a;
    }
}
