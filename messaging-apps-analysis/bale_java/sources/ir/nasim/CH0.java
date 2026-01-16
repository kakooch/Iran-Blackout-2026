package ir.nasim;

import android.gov.nist.core.Separators;
import org.xbill.DNS.TTL;

/* loaded from: classes3.dex */
public abstract class CH0 {
    public static int a(long j) {
        if (j <= TTL.MAX_VALUE && j >= -2147483648L) {
            return (int) j;
        }
        throw new RuntimeException("A cast to int has gone wrong. Please contact the mp4parser discussion group (" + j + Separators.RPAREN);
    }
}
