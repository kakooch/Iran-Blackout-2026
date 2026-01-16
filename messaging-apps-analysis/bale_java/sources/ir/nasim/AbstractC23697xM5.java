package ir.nasim;

import java.net.URI;

/* renamed from: ir.nasim.xM5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC23697xM5 {
    private static boolean a;

    public static final URI a(URI uri, String str) {
        String scheme;
        AbstractC13042fc3.i(uri, "<this>");
        AbstractC13042fc3.i(str, "appendPath");
        String scheme2 = uri.getScheme();
        AbstractC13042fc3.h(scheme2, "getScheme(...)");
        if (AbstractC20153rZ6.S(scheme2, "ws", false, 2, null)) {
            String scheme3 = uri.getScheme();
            AbstractC13042fc3.h(scheme3, "getScheme(...)");
            scheme = AbstractC20153rZ6.O(scheme3, "ws", "http", false, 4, null);
        } else {
            scheme = uri.getScheme();
        }
        return new URI(scheme, null, uri.getHost(), uri.getPort(), "/settings" + str, null, null);
    }

    public static final boolean b(URI uri) {
        AbstractC13042fc3.i(uri, "<this>");
        if (!a) {
            if (uri.getHost() == null) {
                return false;
            }
            String host = uri.getHost();
            AbstractC13042fc3.h(host, "getHost(...)");
            if (!AbstractC20153rZ6.C(host, ".livekit.cloud", false, 2, null)) {
                String host2 = uri.getHost();
                AbstractC13042fc3.h(host2, "getHost(...)");
                if (!AbstractC20153rZ6.C(host2, ".livekit.run", false, 2, null)) {
                    return false;
                }
            }
        }
        return true;
    }
}
