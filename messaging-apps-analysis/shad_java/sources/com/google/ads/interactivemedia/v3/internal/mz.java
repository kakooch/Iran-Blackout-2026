package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class mz {
    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length;
        int length2 = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length2 += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
        byteBufferAllocate.putInt(length2);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? ConnectionsManager.FileTypePhoto : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && (length = bArr.length) != 0) {
            byteBufferAllocate.putInt(length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.UUID c(byte[] r9) {
        /*
            com.google.ads.interactivemedia.v3.internal.aee r0 = new com.google.ads.interactivemedia.v3.internal.aee
            r0.<init>(r9)
            int r9 = r0.e()
            r1 = 0
            r2 = 32
            if (r9 >= r2) goto L10
        Le:
            r9 = r1
            goto L7c
        L10:
            r9 = 0
            r0.h(r9)
            int r2 = r0.v()
            int r3 = r0.d()
            int r3 = r3 + 4
            if (r2 == r3) goto L21
            goto Le
        L21:
            int r2 = r0.v()
            r3 = 1886614376(0x70737368, float:3.013775E29)
            if (r2 == r3) goto L2b
            goto Le
        L2b:
            int r2 = r0.v()
            int r2 = com.google.ads.interactivemedia.v3.internal.me.e(r2)
            r3 = 1
            if (r2 <= r3) goto L4f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r0 = 37
            r9.<init>(r0)
            java.lang.String r0 = "Unsupported pssh version: "
            r9.append(r0)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "PsshAtomUtil"
            android.util.Log.w(r0, r9)
            goto Le
        L4f:
            java.util.UUID r4 = new java.util.UUID
            long r5 = r0.x()
            long r7 = r0.x()
            r4.<init>(r5, r7)
            if (r2 != r3) goto L67
            int r2 = r0.B()
            int r2 = r2 * 16
            r0.k(r2)
        L67:
            int r2 = r0.B()
            int r3 = r0.d()
            if (r2 == r3) goto L72
            goto Le
        L72:
            byte[] r3 = new byte[r2]
            r0.m(r3, r9, r2)
            com.google.ads.interactivemedia.v3.internal.my r9 = new com.google.ads.interactivemedia.v3.internal.my
            r9.<init>(r4)
        L7c:
            if (r9 != 0) goto L7f
            return r1
        L7f:
            java.util.UUID r9 = com.google.ads.interactivemedia.v3.internal.my.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.mz.c(byte[]):java.util.UUID");
    }

    public static void d(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(list.get(i)));
        }
    }

    public static void e(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static int f(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long g(aee aeeVar, int i, int i2) {
        aeeVar.h(i);
        if (aeeVar.d() < 5) {
            return -9223372036854775807L;
        }
        int iV = aeeVar.v();
        if ((8388608 & iV) != 0 || ((iV >> 8) & 8191) != i2 || (iV & 32) == 0 || aeeVar.n() < 7 || aeeVar.d() < 7 || (aeeVar.n() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        aeeVar.m(bArr, 0, 6);
        byte b = bArr[0];
        long j = bArr[3] & 255;
        return ((bArr[1] & 255) << 17) | ((b & 255) << 25) | ((bArr[2] & 255) << 9) | (j + j) | ((bArr[4] & 255) >> 7);
    }

    public static List<byte[]> h(byte[] bArr) {
        byte b = bArr[11];
        byte b2 = bArr[10];
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(i(j(((b & 255) << 8) | (b2 & 255))));
        arrayList.add(i(j(3840L)));
        return arrayList;
    }

    private static byte[] i(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    private static long j(long j) {
        return (j * 1000000000) / 48000;
    }
}
