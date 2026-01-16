package ir.nasim;

import android.util.Base64;
import java.security.MessageDigest;

/* loaded from: classes5.dex */
public final class JE2 {
    private final MessageDigest a = MessageDigest.getInstance("SHA-256");

    public final String a(long j, long j2) {
        MessageDigest messageDigest = this.a;
        byte[] bytes = (j + "_" + j2).getBytes(C12275eL0.b);
        AbstractC13042fc3.h(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(messageDigest.digest(bytes), 8);
        AbstractC13042fc3.h(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
