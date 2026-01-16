package ir.nasim;

import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;

/* renamed from: ir.nasim.kG5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC15844kG5 {
    private static final ThreadLocal a = new a();

    /* renamed from: ir.nasim.kG5$a */
    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SecureRandom initialValue() {
            return AbstractC15844kG5.d();
        }
    }

    private static SecureRandom b() {
        try {
            try {
                try {
                    try {
                        return SecureRandom.getInstance("SHA1PRNG", "GmsCore_OpenSSL");
                    } catch (GeneralSecurityException unused) {
                        return new SecureRandom();
                    }
                } catch (GeneralSecurityException unused2) {
                    return SecureRandom.getInstance("SHA1PRNG", "Conscrypt");
                }
            } catch (GeneralSecurityException unused3) {
                return SecureRandom.getInstance("SHA1PRNG", "AndroidOpenSSL");
            }
        } catch (GeneralSecurityException unused4) {
            return SecureRandom.getInstance("SHA1PRNG", c());
        }
    }

    private static Provider c() throws GeneralSecurityException {
        try {
            return (Provider) Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", null).invoke(null, null);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            throw new GeneralSecurityException("Failed to get Conscrypt provider", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom d() {
        SecureRandom secureRandomB = b();
        secureRandomB.nextLong();
        return secureRandomB;
    }

    public static byte[] e(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) a.get()).nextBytes(bArr);
        return bArr;
    }
}
