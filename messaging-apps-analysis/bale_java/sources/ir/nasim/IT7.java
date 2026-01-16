package ir.nasim;

import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class IT7 {
    private final MessageDigest a = MessageDigest.getInstance("SHA-256");

    public final String a(long j, long j2) {
        String str;
        MessageDigest messageDigest = this.a;
        AbstractC13042fc3.h(messageDigest, "messageDigest");
        synchronized (messageDigest) {
            MessageDigest messageDigest2 = this.a;
            byte[] bytes = String.valueOf(j + j2).getBytes(C12275eL0.b);
            AbstractC13042fc3.h(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest2.digest(bytes);
            AbstractC13042fc3.f(bArrDigest);
            str = "";
            for (byte b : bArrDigest) {
                String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                AbstractC13042fc3.h(str2, "format(...)");
                str = str + str2;
            }
        }
        return str;
    }
}
