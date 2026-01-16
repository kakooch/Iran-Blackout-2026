package org.xbill.DNS;

import lombok.Generated;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes8.dex */
final class Utils {
    @Generated
    private Utils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static boolean isUInt16(int i) {
        return i >= 0 && i <= 65535;
    }

    static boolean isUInt32(long j) {
        return j >= 0 && j <= 4294967295L;
    }

    static boolean isUInt8(int i) {
        return i >= 0 && i <= 255;
    }

    static boolean isUInt16(long j) {
        return j >= 0 && j <= WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    static boolean isUInt8(long j) {
        return j >= 0 && j <= 255;
    }
}
