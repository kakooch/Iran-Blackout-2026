package ir.nasim;

import android.util.Pair;
import com.google.android.play.core.splitinstall.internal.zzf;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xbill.DNS.TTL;
import org.xbill.DNS.Type;

/* loaded from: classes3.dex */
public abstract class Qp8 {
    public static X509Certificate[][] a(String str) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair pairC = Aq8.c(randomAccessFile);
            if (pairC == null) {
                throw new zzf("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
            }
            ByteBuffer byteBuffer = (ByteBuffer) pairC.first;
            long jLongValue = ((Long) pairC.second).longValue();
            long j = (-20) + jLongValue;
            if (j >= 0) {
                randomAccessFile.seek(j);
                if (randomAccessFile.readInt() == 1347094023) {
                    throw new zzf("ZIP64 APK not supported");
                }
            }
            long jA = Aq8.a(byteBuffer);
            if (jA >= jLongValue) {
                throw new zzf("ZIP Central Directory offset out of range: " + jA + ". ZIP End of Central Directory offset: " + jLongValue);
            }
            if (Aq8.b(byteBuffer) + jA != jLongValue) {
                throw new zzf("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            if (jA < 32) {
                throw new zzf("APK too small for APK Signing Block. ZIP Central Directory offset: " + jA);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(jA - byteBufferAllocate.capacity());
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                throw new zzf("No APK Signing Block before ZIP Central Directory");
            }
            int i = 0;
            long j2 = byteBufferAllocate.getLong(0);
            if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
                throw new zzf("APK Signing Block size out of range: " + j2);
            }
            int i2 = (int) (8 + j2);
            long j3 = jA - i2;
            if (j3 < 0) {
                throw new zzf("APK Signing Block offset out of range: " + j3);
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i2);
            byteBufferAllocate2.order(byteOrder);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
            long j4 = byteBufferAllocate2.getLong(0);
            if (j4 != j2) {
                throw new zzf("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
            }
            Pair pairCreate = Pair.create(byteBufferAllocate2, Long.valueOf(j3));
            ByteBuffer byteBuffer2 = (ByteBuffer) pairCreate.first;
            long jLongValue2 = ((Long) pairCreate.second).longValue();
            if (byteBuffer2.order() != byteOrder) {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
            int iCapacity = byteBuffer2.capacity() - 24;
            if (iCapacity < 8) {
                throw new IllegalArgumentException("end < start: " + iCapacity + " < 8");
            }
            int iCapacity2 = byteBuffer2.capacity();
            if (iCapacity > byteBuffer2.capacity()) {
                throw new IllegalArgumentException("end > capacity: " + iCapacity + " > " + iCapacity2);
            }
            int iLimit = byteBuffer2.limit();
            int iPosition = byteBuffer2.position();
            try {
                byteBuffer2.position(0);
                byteBuffer2.limit(iCapacity);
                byteBuffer2.position(8);
                ByteBuffer byteBufferSlice = byteBuffer2.slice();
                byteBufferSlice.order(byteBuffer2.order());
                while (byteBufferSlice.hasRemaining()) {
                    i++;
                    if (byteBufferSlice.remaining() < 8) {
                        throw new zzf("Insufficient data to read size of APK Signing Block entry #" + i);
                    }
                    long j5 = byteBufferSlice.getLong();
                    if (j5 < 4 || j5 > TTL.MAX_VALUE) {
                        throw new zzf("APK Signing Block entry #" + i + " size out of range: " + j5);
                    }
                    int i3 = (int) j5;
                    int iPosition2 = byteBufferSlice.position() + i3;
                    if (i3 > byteBufferSlice.remaining()) {
                        throw new zzf("APK Signing Block entry #" + i + " size out of range: " + i3 + ", available: " + byteBufferSlice.remaining());
                    }
                    if (byteBufferSlice.getInt() == 1896449818) {
                        X509Certificate[][] x509CertificateArrL = l(randomAccessFile.getChannel(), new Sm8(e(byteBufferSlice, i3 - 4), jLongValue2, jA, jLongValue, byteBuffer, null));
                        randomAccessFile.close();
                        return x509CertificateArrL;
                    }
                    byteBufferSlice.position(iPosition2);
                }
                throw new zzf("No APK Signature Scheme v2 block in APK Signing Block");
            } finally {
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
            }
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    private static int b(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    private static int c(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case Type.CAA /* 257 */:
            case Type.DOA /* 259 */:
                return 1;
            case Type.AVC /* 258 */:
            case Type.AMTRELAY /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i))));
        }
    }

    private static String d(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    private static ByteBuffer e(ByteBuffer byteBuffer, int i) {
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    private static ByteBuffer f(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            return e(byteBuffer, i);
        }
        throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
    }

    private static void g(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    private static void h(Map map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        Sk8 sk8 = new Sk8(fileChannel, 0L, j);
        Sk8 sk82 = new Sk8(fileChannel, j2, j3 - j2);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        Aq8.d(byteBufferDuplicate, j);
        Xg8 xg8 = new Xg8(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        try {
            byte[][] bArrK = k(iArr, new InterfaceC19663qj8[]{sk8, sk82, xg8});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i3)), bArrK[i2])) {
                    throw new SecurityException(d(i3).concat(" digest of contents did not verify"));
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[] i(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
    }

    private static X509Certificate[] j(ByteBuffer byteBuffer, Map map, CertificateFactory certificateFactory) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        Pair pairCreate;
        ByteBuffer byteBufferF = f(byteBuffer);
        ByteBuffer byteBufferF2 = f(byteBuffer);
        byte[] bArrI = i(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrI2 = null;
        int i = -1;
        byte[] bArrI3 = null;
        int i2 = 0;
        while (byteBufferF2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer byteBufferF3 = f(byteBufferF2);
                if (byteBufferF3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = byteBufferF3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (i3 != 513 && i3 != 514 && i3 != 769) {
                    switch (i3) {
                        case Type.CAA /* 257 */:
                        case Type.AVC /* 258 */:
                        case Type.DOA /* 259 */:
                        case Type.AMTRELAY /* 260 */:
                            break;
                        default:
                            continue;
                    }
                }
                if (i != -1) {
                    int iC = c(i3);
                    int iC2 = c(i);
                    if (iC != 1 && iC2 == 1) {
                    }
                }
                bArrI3 = i(byteBufferF3);
                i = i3;
            } catch (IOException e) {
                e = e;
                throw new SecurityException("Failed to parse signature record #" + i2, e);
            } catch (BufferUnderflowException e2) {
                e = e2;
                throw new SecurityException("Failed to parse signature record #" + i2, e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        if (i == 513 || i == 514) {
            str = "EC";
        } else if (i != 769) {
            switch (i) {
                case Type.CAA /* 257 */:
                case Type.AVC /* 258 */:
                case Type.DOA /* 259 */:
                case Type.AMTRELAY /* 260 */:
                    str = "RSA";
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i))));
            }
        } else {
            str = "DSA";
        }
        if (i == 513) {
            pairCreate = Pair.create("SHA256withECDSA", null);
        } else if (i == 514) {
            pairCreate = Pair.create("SHA512withECDSA", null);
        } else if (i != 769) {
            switch (i) {
                case Type.CAA /* 257 */:
                    pairCreate = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                    break;
                case Type.AVC /* 258 */:
                    pairCreate = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                    break;
                case Type.DOA /* 259 */:
                    pairCreate = Pair.create("SHA256withRSA", null);
                    break;
                case Type.AMTRELAY /* 260 */:
                    pairCreate = Pair.create("SHA512withRSA", null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i))));
            }
        } else {
            pairCreate = Pair.create("SHA256withDSA", null);
        }
        String str2 = (String) pairCreate.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairCreate.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrI));
            Signature signature = Signature.getInstance(str2);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferF);
            if (!signature.verify(bArrI3)) {
                throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
            }
            byteBufferF.clear();
            ByteBuffer byteBufferF4 = f(byteBufferF);
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (byteBufferF4.hasRemaining()) {
                i4++;
                try {
                    ByteBuffer byteBufferF5 = f(byteBufferF4);
                    if (byteBufferF5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i5 = byteBufferF5.getInt();
                    arrayList2.add(Integer.valueOf(i5));
                    if (i5 == i) {
                        bArrI2 = i(byteBufferF5);
                    }
                } catch (IOException e3) {
                    e = e3;
                    throw new IOException("Failed to parse digest record #" + i4, e);
                } catch (BufferUnderflowException e4) {
                    e = e4;
                    throw new IOException("Failed to parse digest record #" + i4, e);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iC3 = c(i);
            byte[] bArr = (byte[]) map.put(Integer.valueOf(iC3), bArrI2);
            if (bArr != null && !MessageDigest.isEqual(bArr, bArrI2)) {
                throw new SecurityException(d(iC3).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            ByteBuffer byteBufferF6 = f(byteBufferF);
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            while (byteBufferF6.hasRemaining()) {
                i6++;
                byte[] bArrI4 = i(byteBufferF6);
                try {
                    arrayList3.add(new C15576jo8((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrI4)), bArrI4));
                } catch (CertificateException e5) {
                    throw new SecurityException("Failed to decode certificate #" + i6, e5);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (Arrays.equals(bArrI, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
            }
            throw new SecurityException("Public key mismatch between certificate and signature record");
        } catch (InvalidAlgorithmParameterException e6) {
            e = e6;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        } catch (InvalidKeyException e7) {
            e = e7;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        } catch (NoSuchAlgorithmException e8) {
            e = e8;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        } catch (SignatureException e9) {
            e = e9;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        } catch (InvalidKeySpecException e10) {
            e = e10;
            throw new SecurityException("Failed to verify " + str2 + " signature", e);
        }
    }

    private static byte[][] k(int[] iArr, InterfaceC19663qj8[] interfaceC19663qj8Arr) throws DigestException {
        long j;
        int i;
        int length;
        long j2 = 0;
        int i2 = 0;
        long jZza = 0;
        int i3 = 0;
        while (true) {
            j = 1048576;
            if (i3 >= 3) {
                break;
            }
            jZza += (interfaceC19663qj8Arr[i3].zza() + 1048575) / 1048576;
            i3++;
        }
        if (jZza >= 2097151) {
            throw new DigestException("Too many chunks: " + jZza);
        }
        int i4 = (int) jZza;
        byte[][] bArr = new byte[iArr.length][];
        int i5 = 0;
        while (true) {
            length = iArr.length;
            if (i5 >= length) {
                break;
            }
            byte[] bArr2 = new byte[(b(iArr[i5]) * i4) + 5];
            bArr2[0] = 90;
            g(i4, bArr2, 1);
            bArr[i5] = bArr2;
            i5++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            String strD = d(iArr[i6]);
            try {
                messageDigestArr[i6] = MessageDigest.getInstance(strD);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strD.concat(" digest not supported"), e);
            }
        }
        int i7 = 0;
        int i8 = 0;
        for (i = 3; i7 < i; i = 3) {
            InterfaceC19663qj8 interfaceC19663qj8 = interfaceC19663qj8Arr[i7];
            long j3 = j2;
            long jZza2 = interfaceC19663qj8.zza();
            while (jZza2 > j2) {
                int iMin = (int) Math.min(jZza2, j);
                g(iMin, bArr3, 1);
                for (int i9 = 0; i9 < length; i9++) {
                    messageDigestArr[i9].update(bArr3);
                }
                long j4 = j3;
                try {
                    interfaceC19663qj8.a(messageDigestArr, j4, iMin);
                    byte[] bArr4 = bArr3;
                    int i10 = 0;
                    while (i10 < iArr.length) {
                        int i11 = iArr[i10];
                        InterfaceC19663qj8 interfaceC19663qj82 = interfaceC19663qj8;
                        byte[] bArr5 = bArr[i10];
                        int iB = b(i11);
                        int i12 = length;
                        MessageDigest messageDigest = messageDigestArr[i10];
                        MessageDigest[] messageDigestArr2 = messageDigestArr;
                        int iDigest = messageDigest.digest(bArr5, (i8 * iB) + 5, iB);
                        if (iDigest != iB) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i10++;
                        interfaceC19663qj8 = interfaceC19663qj82;
                        length = i12;
                        messageDigestArr = messageDigestArr2;
                    }
                    MessageDigest[] messageDigestArr3 = messageDigestArr;
                    long j5 = iMin;
                    long j6 = j4 + j5;
                    jZza2 -= j5;
                    i8++;
                    bArr3 = bArr4;
                    j2 = 0;
                    j3 = j6;
                    messageDigestArr = messageDigestArr3;
                    j = 1048576;
                } catch (IOException e2) {
                    throw new DigestException("Failed to digest chunk #" + i8 + " of section #" + i2, e2);
                }
            }
            i2++;
            i7++;
            j2 = 0;
            j = 1048576;
        }
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String strD2 = d(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(strD2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(strD2.concat(" digest not supported"), e3);
            }
        }
        return bArr6;
    }

    private static X509Certificate[][] l(FileChannel fileChannel, Sm8 sm8) throws CertificateException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferF = f(sm8.a);
                int i = 0;
                while (byteBufferF.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(j(f(byteBufferF), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                h(map, fileChannel, sm8.b, sm8.c, sm8.d, sm8.e);
                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }
}
