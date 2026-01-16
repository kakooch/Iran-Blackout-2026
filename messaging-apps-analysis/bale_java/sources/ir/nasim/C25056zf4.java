package ir.nasim;

import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.zf4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C25056zf4 {
    public static final C25056zf4 a = new C25056zf4();

    private C25056zf4() {
    }

    private final String a(String str) {
        int iK0 = AbstractC20762sZ6.k0(str, '/', 0, false, 6, null);
        if (iK0 != -1) {
            String strSubstring = str.substring(0, iK0);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Invalid mime type: " + str).toString());
    }

    public static final boolean b(String str) {
        AbstractC13042fc3.i(str, "mimeType");
        return AbstractC13042fc3.d(a.a(str), MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public static final boolean c(String str) {
        AbstractC13042fc3.i(str, "mimeType");
        return AbstractC13042fc3.d(a.a(str), MediaStreamTrack.VIDEO_TRACK_KIND);
    }
}
