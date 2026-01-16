package ir.eitaa.messenger;

import ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordSRP;
import ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class SRPHelper {
    public static byte[] getBigIntegerBytes(BigInteger value) {
        byte[] byteArray = value.toByteArray();
        if (byteArray.length > 256) {
            byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            System.arraycopy(byteArray, 1, bArr, 0, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
            return bArr;
        }
        if (byteArray.length >= 256) {
            return byteArray;
        }
        byte[] bArr2 = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
        System.arraycopy(byteArray, 0, bArr2, 256 - byteArray.length, byteArray.length);
        for (int i = 0; i < 256 - byteArray.length; i++) {
            bArr2[i] = 0;
        }
        return bArr2;
    }

    public static byte[] getX(byte[] passwordBytes, TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow algo) throws NoSuchAlgorithmException {
        byte[] bArr = algo.salt1;
        byte[] bArrComputeSHA256 = Utilities.computeSHA256(bArr, passwordBytes, bArr);
        byte[] bArr2 = algo.salt2;
        byte[] bArrComputePBKDF2 = Utilities.computePBKDF2(Utilities.computeSHA256(bArr2, bArrComputeSHA256, bArr2), algo.salt1);
        byte[] bArr3 = algo.salt2;
        return Utilities.computeSHA256(bArr3, bArrComputePBKDF2, bArr3);
    }

    public static BigInteger getV(byte[] passwordBytes, TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow algo) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(algo.g);
        getBigIntegerBytes(bigIntegerValueOf);
        return bigIntegerValueOf.modPow(new BigInteger(1, getX(passwordBytes, algo)), new BigInteger(1, algo.p));
    }

    public static byte[] getVBytes(byte[] passwordBytes, TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow algo) {
        if (Utilities.isGoodPrime(algo.p, algo.g)) {
            return getBigIntegerBytes(getV(passwordBytes, algo));
        }
        return null;
    }

    public static TLRPC$TL_inputCheckPasswordSRP startCheck(byte[] x_bytes, long srp_id, byte[] srp_B, TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow algo) {
        if (x_bytes != null && srp_B != null && srp_B.length != 0 && Utilities.isGoodPrime(algo.p, algo.g)) {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(algo.g);
            byte[] bigIntegerBytes = getBigIntegerBytes(bigIntegerValueOf);
            BigInteger bigInteger = new BigInteger(1, algo.p);
            BigInteger bigInteger2 = new BigInteger(1, Utilities.computeSHA256(algo.p, bigIntegerBytes));
            BigInteger bigInteger3 = new BigInteger(1, x_bytes);
            byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            Utilities.random.nextBytes(bArr);
            BigInteger bigInteger4 = new BigInteger(1, bArr);
            byte[] bigIntegerBytes2 = getBigIntegerBytes(bigIntegerValueOf.modPow(bigInteger4, bigInteger));
            BigInteger bigInteger5 = new BigInteger(1, srp_B);
            BigInteger bigInteger6 = BigInteger.ZERO;
            if (bigInteger5.compareTo(bigInteger6) > 0 && bigInteger5.compareTo(bigInteger) < 0) {
                byte[] bigIntegerBytes3 = getBigIntegerBytes(bigInteger5);
                BigInteger bigInteger7 = new BigInteger(1, Utilities.computeSHA256(bigIntegerBytes2, bigIntegerBytes3));
                if (bigInteger7.compareTo(bigInteger6) == 0) {
                    return null;
                }
                BigInteger bigIntegerSubtract = bigInteger5.subtract(bigInteger2.multiply(bigIntegerValueOf.modPow(bigInteger3, bigInteger)).mod(bigInteger));
                if (bigIntegerSubtract.compareTo(bigInteger6) < 0) {
                    bigIntegerSubtract = bigIntegerSubtract.add(bigInteger);
                }
                if (!Utilities.isGoodGaAndGb(bigIntegerSubtract, bigInteger)) {
                    return null;
                }
                byte[] bArrComputeSHA256 = Utilities.computeSHA256(getBigIntegerBytes(bigIntegerSubtract.modPow(bigInteger4.add(bigInteger7.multiply(bigInteger3)), bigInteger)));
                byte[] bArrComputeSHA2562 = Utilities.computeSHA256(algo.p);
                byte[] bArrComputeSHA2563 = Utilities.computeSHA256(bigIntegerBytes);
                for (int i = 0; i < bArrComputeSHA2562.length; i++) {
                    bArrComputeSHA2562[i] = (byte) (bArrComputeSHA2563[i] ^ bArrComputeSHA2562[i]);
                }
                TLRPC$TL_inputCheckPasswordSRP tLRPC$TL_inputCheckPasswordSRP = new TLRPC$TL_inputCheckPasswordSRP();
                tLRPC$TL_inputCheckPasswordSRP.M1 = Utilities.computeSHA256(bArrComputeSHA2562, Utilities.computeSHA256(algo.salt1), Utilities.computeSHA256(algo.salt2), bigIntegerBytes2, bigIntegerBytes3, bArrComputeSHA256);
                tLRPC$TL_inputCheckPasswordSRP.A = bigIntegerBytes2;
                tLRPC$TL_inputCheckPasswordSRP.srp_id = srp_id;
                return tLRPC$TL_inputCheckPasswordSRP;
            }
        }
        return null;
    }
}
