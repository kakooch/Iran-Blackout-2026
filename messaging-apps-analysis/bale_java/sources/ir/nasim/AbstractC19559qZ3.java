package ir.nasim;

import android.net.Uri;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.qZ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19559qZ3 {
    public static boolean a(Uri uri) {
        return c(uri) && uri.getPathSegments().contains("picker");
    }

    public static boolean b(Uri uri) {
        return c(uri) && !f(uri);
    }

    public static boolean c(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean d(Uri uri) {
        return c(uri) && f(uri);
    }

    public static boolean e(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    private static boolean f(Uri uri) {
        return uri.getPathSegments().contains(MediaStreamTrack.VIDEO_TRACK_KIND);
    }
}
