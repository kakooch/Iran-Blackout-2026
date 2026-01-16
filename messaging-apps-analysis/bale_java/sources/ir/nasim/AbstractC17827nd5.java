package ir.nasim;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: ir.nasim.nd5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17827nd5 {
    private static final Logger b = Logger.getLogger(C3679Bw6.class.getName());
    protected static final MessageDigest c;
    protected final byte[] a;

    static {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            b.log(Level.WARNING, "SHA-256 MessageDigest not available", (Throwable) e);
            messageDigest = null;
        }
        c = messageDigest;
    }

    protected AbstractC17827nd5(String str) {
        this.a = AbstractC23775xV2.a(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.AbstractC17827nd5 a(java.lang.String r6) {
        /*
            java.lang.String r0 = ":"
            r1 = 2
            java.lang.String[] r6 = r6.split(r0, r1)
            int r0 = r6.length
            if (r0 != r1) goto L67
            r0 = 0
            r2 = r6[r0]
            r3 = 1
            r6 = r6[r3]
            r2.hashCode()
            int r4 = r2.hashCode()
            r5 = -1
            switch(r4) {
                case -1850268089: goto L3c;
                case 76210602: goto L31;
                case 420314475: goto L28;
                case 1396381190: goto L1d;
                default: goto L1b;
            }
        L1b:
            r1 = r5
            goto L46
        L1d:
            java.lang.String r0 = "CERTPLAIN"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L26
            goto L1b
        L26:
            r1 = 3
            goto L46
        L28:
            java.lang.String r0 = "CERTSHA256"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L46
            goto L1b
        L31:
            java.lang.String r0 = "PLAIN"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L3a
            goto L1b
        L3a:
            r1 = r3
            goto L46
        L3c:
            java.lang.String r1 = "SHA256"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L45
            goto L1b
        L45:
            r1 = r0
        L46:
            switch(r1) {
                case 0: goto L61;
                case 1: goto L5b;
                case 2: goto L55;
                case 3: goto L4f;
                default: goto L49;
            }
        L49:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>()
            throw r6
        L4f:
            ir.nasim.QH0 r0 = new ir.nasim.QH0
            r0.<init>(r6)
            return r0
        L55:
            ir.nasim.RH0 r0 = new ir.nasim.RH0
            r0.<init>(r6)
            return r0
        L5b:
            ir.nasim.Ke5 r0 = new ir.nasim.Ke5
            r0.<init>(r6)
            return r0
        L61:
            ir.nasim.Bw6 r0 = new ir.nasim.Bw6
            r0.<init>(r6)
            return r0
        L67:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Invalid pin string, expected: 'format-specifier:hex-string'."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC17827nd5.a(java.lang.String):ir.nasim.nd5");
    }

    public abstract boolean b(X509Certificate x509Certificate);
}
