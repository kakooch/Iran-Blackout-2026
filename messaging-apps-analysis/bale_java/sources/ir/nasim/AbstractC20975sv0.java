package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.sv0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20975sv0 {
    public static final boolean b(long j, long j2) {
        return j == j2;
    }

    public static int c(long j) {
        return Long.hashCode(j);
    }

    public static String d(long j) {
        return "CallId(id=" + j + Separators.RPAREN;
    }

    public static long a(long j) {
        return j;
    }
}
