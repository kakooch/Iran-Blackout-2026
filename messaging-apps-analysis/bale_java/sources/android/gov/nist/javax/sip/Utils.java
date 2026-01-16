package android.gov.nist.javax.sip;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import android.gov.nist.javax.sip.message.SIPResponse;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class Utils implements UtilsExt {
    private static int callIDCounter = 0;
    private static long counter = 0;
    private static int digesterPoolsSize = 20;
    private static Random rand;
    private static String signature;
    private static MessageDigest[] digesterPool = new MessageDigest[20];
    private static Utils instance = new Utils();
    private static final char[] toHex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        for (int i = 0; i < digesterPoolsSize; i++) {
            try {
                digesterPool[i] = MessageDigest.getInstance(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM);
            } catch (Exception e) {
                throw new RuntimeException("Could not intialize Digester ", e);
            }
        }
        Random random = new Random(System.nanoTime());
        rand = random;
        signature = toHexString(Integer.toString(Math.abs(random.nextInt() % AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)).getBytes());
    }

    public static Utils getInstance() {
        return instance;
    }

    public static String getQuotedString(String str) {
        return '\"' + str.replace(Separators.DOUBLE_QUOTE, "\\\"") + '\"';
    }

    public static String getSignature() {
        return signature;
    }

    public static void main(String[] strArr) {
        final HashSet hashSet = new HashSet();
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorServiceNewFixedThreadPool.execute(new Runnable() { // from class: android.gov.nist.javax.sip.Utils.1
                @Override // java.lang.Runnable
                public void run() {
                    for (int i2 = 0; i2 < 1000000; i2++) {
                        String strGenerateBranchId = Utils.getInstance().generateBranchId();
                        if (hashSet.contains(strGenerateBranchId)) {
                            throw new RuntimeException("Duplicate Branch ID");
                        }
                        hashSet.add(strGenerateBranchId);
                    }
                }
            });
        }
        System.out.println("Done!!");
    }

    protected static String reduceString(String str) {
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length();
        String str2 = "";
        for (int i = 0; i < length; i++) {
            if (lowerCase.charAt(i) != ' ' && lowerCase.charAt(i) != '\t') {
                str2 = str2 + lowerCase.charAt(i);
            }
        }
        return str2;
    }

    public static String toHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = toHex;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase(Locale.ENGLISH);
    }

    @Override // android.gov.nist.javax.sip.UtilsExt
    public String generateBranchId() {
        String str;
        long jNextLong = rand.nextLong();
        long j = counter;
        counter = 1 + j;
        long jCurrentTimeMillis = jNextLong + j + System.currentTimeMillis() + System.nanoTime();
        MessageDigest messageDigest = digesterPool[(int) Math.abs(jCurrentTimeMillis % digesterPoolsSize)];
        synchronized (messageDigest) {
            str = "z9hG4bK-" + signature + "-" + toHexString(messageDigest.digest(Long.toString(jCurrentTimeMillis).getBytes()));
        }
        return str;
    }

    @Override // android.gov.nist.javax.sip.UtilsExt
    public String generateCallIdentifier(String str) {
        String str2;
        long jNextLong = rand.nextLong();
        MessageDigest messageDigest = digesterPool[(int) Math.abs(jNextLong % digesterPoolsSize)];
        synchronized (messageDigest) {
            long jNanoTime = System.nanoTime() + System.currentTimeMillis();
            int i = callIDCounter;
            callIDCounter = i + 1;
            str2 = toHexString(messageDigest.digest(Long.toString(jNanoTime + i + jNextLong).getBytes())) + Separators.AT + str;
        }
        return str2;
    }

    @Override // android.gov.nist.javax.sip.UtilsExt
    public synchronized String generateTag() {
        return Integer.toHexString(rand.nextInt());
    }

    public boolean responseBelongsToUs(SIPResponse sIPResponse) {
        String branch = sIPResponse.getTopmostVia().getBranch();
        if (branch != null) {
            if (branch.startsWith("z9hG4bK-" + signature)) {
                return true;
            }
        }
        return false;
    }
}
