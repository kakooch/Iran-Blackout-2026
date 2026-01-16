package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import lombok.Generated;

/* loaded from: classes8.dex */
public final class Address {
    public static final int IPv4 = 1;
    public static final int IPv6 = 2;

    @Generated
    private Address() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    private static InetAddress addrFromRecord(String str, Record record) {
        return InetAddress.getByAddress(str, (record instanceof ARecord ? ((ARecord) record).getAddress() : ((AAAARecord) record).getAddress()).getAddress());
    }

    public static int addressLength(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int familyOf(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress[] getAllByName(String str) throws UnknownHostException {
        try {
            return new InetAddress[]{getByAddress(str)};
        } catch (UnknownHostException unused) {
            Record[] recordArrLookupHostName = lookupHostName(str, true);
            InetAddress[] inetAddressArr = new InetAddress[recordArrLookupHostName.length];
            for (int i = 0; i < recordArrLookupHostName.length; i++) {
                inetAddressArr[i] = addrFromRecord(str, recordArrLookupHostName[i]);
            }
            return inetAddressArr;
        }
    }

    public static InetAddress getByAddress(String str) throws UnknownHostException {
        byte[] byteArray = toByteArray(str, 1);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        byte[] byteArray2 = toByteArray(str, 2);
        if (byteArray2 != null) {
            return InetAddress.getByAddress(str, byteArray2);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }

    public static InetAddress getByName(String str) {
        try {
            return getByAddress(str);
        } catch (UnknownHostException unused) {
            return addrFromRecord(str, lookupHostName(str, false)[0]);
        }
    }

    public static String getHostName(InetAddress inetAddress) throws UnknownHostException {
        Name nameFromAddress = ReverseMap.fromAddress(inetAddress);
        Record[] recordArrRun = new Lookup(nameFromAddress, 12).run();
        if (recordArrRun != null) {
            return ((PTRRecord) recordArrRun[0]).getTarget().toString();
        }
        throw new UnknownHostException("unknown address: " + nameFromAddress);
    }

    public static boolean isDottedQuad(String str) {
        return toByteArray(str, 1) != null;
    }

    private static Record[] lookupHostName(String str, boolean z) throws UnknownHostException {
        Record[] recordArrRun;
        Record[] recordArrRun2;
        try {
            Lookup lookup = new Lookup(str, 1);
            Record[] recordArrRun3 = lookup.run();
            if (recordArrRun3 != null) {
                if (!z || (recordArrRun = new Lookup(str, 28).run()) == null) {
                    return recordArrRun3;
                }
                Record[] recordArr = new Record[recordArrRun3.length + recordArrRun.length];
                System.arraycopy(recordArrRun3, 0, recordArr, 0, recordArrRun3.length);
                System.arraycopy(recordArrRun, 0, recordArr, recordArrRun3.length, recordArrRun.length);
                return recordArr;
            }
            if (lookup.getResult() == 4 && (recordArrRun2 = new Lookup(str, 28).run()) != null) {
                return recordArrRun2;
            }
            throw new UnknownHostException(Separators.LESS_THAN + str + "> could not be resolved: " + lookup.getErrorString());
        } catch (TextParseException e) {
            throw new UnknownHostException(Separators.LESS_THAN + str + "> is invalid: " + e.getMessage());
        }
    }

    public static int[] toArray(String str, int i) {
        byte[] byteArray = toByteArray(str, i);
        if (byteArray == null) {
            return null;
        }
        int[] iArr = new int[byteArray.length];
        for (int i2 = 0; i2 < byteArray.length; i2++) {
            iArr[i2] = byteArray[i2] & 255;
        }
        return iArr;
    }

    public static byte[] toByteArray(String str, int i) {
        if (i == 1) {
            return IPAddressUtils.parseV4(str);
        }
        if (i == 2) {
            return IPAddressUtils.parseV6(str);
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static String toDottedQuad(byte[] bArr) {
        return (bArr[0] & 255) + Separators.DOT + (bArr[1] & 255) + Separators.DOT + (bArr[2] & 255) + Separators.DOT + (bArr[3] & 255);
    }

    public static InetAddress truncate(InetAddress inetAddress, int i) {
        int i2;
        int iAddressLength = addressLength(familyOf(inetAddress)) * 8;
        if (i < 0 || i > iAddressLength) {
            throw new IllegalArgumentException("invalid mask length");
        }
        if (i == iAddressLength) {
            return inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i3 = i / 8;
        int i4 = i3 + 1;
        while (true) {
            if (i4 >= address.length) {
                break;
            }
            address[i4] = 0;
            i4++;
        }
        int i5 = 0;
        for (i2 = 0; i2 < i % 8; i2++) {
            i5 |= 1 << (7 - i2);
        }
        address[i3] = (byte) (address[i3] & ((byte) i5));
        try {
            return InetAddress.getByAddress(address);
        } catch (UnknownHostException unused) {
            throw new IllegalArgumentException("invalid address");
        }
    }

    public static String toDottedQuad(int[] iArr) {
        return iArr[0] + Separators.DOT + iArr[1] + Separators.DOT + iArr[2] + Separators.DOT + iArr[3];
    }

    public static int[] toArray(String str) {
        return toArray(str, 1);
    }

    public static InetAddress getByAddress(String str, int i) throws UnknownHostException {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("unknown address family");
        }
        byte[] byteArray = toByteArray(str, i);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }
}
