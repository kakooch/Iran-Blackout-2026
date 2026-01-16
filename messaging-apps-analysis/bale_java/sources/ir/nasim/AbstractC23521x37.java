package ir.nasim;

import android.gov.nist.core.Separators;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: ir.nasim.x37, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23521x37 {
    private static final ByteString a;
    private static final ByteString b;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        a = companion.encodeUtf8("<svg");
        b = companion.encodeUtf8(Separators.LESS_THAN);
    }

    public static final boolean a(C21144tB1 c21144tB1, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0L, b) && AbstractC18047o.a(bufferedSource, a, 0L, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) != -1;
    }
}
