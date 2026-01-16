package ir.nasim;

import android.gov.nist.core.Separators;
import java.nio.ByteBuffer;
import java.util.UUID;
import okhttp3.internal.http2.Http2Connection;

/* renamed from: ir.nasim.jy5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15671jy5 {

    /* renamed from: ir.nasim.jy5$a */
    private static class a {
        private final UUID a;
        private final int b;
        private final byte[] c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.a = uuid;
            this.b = i;
            this.c = bArr;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    private static a d(byte[] bArr) {
        EW4 ew4 = new EW4(bArr);
        if (ew4.g() < 32) {
            return null;
        }
        ew4.S(0);
        if (ew4.o() != ew4.a() + 4 || ew4.o() != 1886614376) {
            return null;
        }
        int iC = ML.c(ew4.o());
        if (iC > 1) {
            AbstractC18815pI3.k("PsshAtomUtil", "Unsupported pssh version: " + iC);
            return null;
        }
        UUID uuid = new UUID(ew4.y(), ew4.y());
        if (iC == 1) {
            ew4.T(ew4.J() * 16);
        }
        int iJ = ew4.J();
        if (iJ != ew4.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iJ];
        ew4.j(bArr2, 0, iJ);
        return new a(uuid, iC, bArr2);
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        if (uuid.equals(aVarD.a)) {
            return aVarD.c;
        }
        AbstractC18815pI3.k("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + aVarD.a + Separators.DOT);
        return null;
    }

    public static UUID f(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        return aVarD.a;
    }

    public static int g(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return -1;
        }
        return aVarD.b;
    }
}
