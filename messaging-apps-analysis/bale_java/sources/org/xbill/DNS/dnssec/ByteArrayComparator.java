package org.xbill.DNS.dnssec;

import lombok.Generated;

/* loaded from: classes8.dex */
final class ByteArrayComparator {
    private static final int MAX_BYTE = 255;

    @Generated
    private ByteArrayComparator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int compare(byte[] bArr, byte[] bArr2) {
        int length;
        int length2;
        if (bArr.length == bArr2.length) {
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                byte b2 = bArr2[i];
                if (b != b2) {
                    length = b & 255;
                    length2 = b2 & 255;
                }
            }
            return 0;
        }
        length = bArr.length;
        length2 = bArr2.length;
        return length - length2;
    }
}
