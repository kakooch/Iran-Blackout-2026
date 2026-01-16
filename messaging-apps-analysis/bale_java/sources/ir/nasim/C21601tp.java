package ir.nasim;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

/* renamed from: ir.nasim.tp, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21601tp implements InterfaceC16192kr3 {
    private static final Object c = new Object();
    private static final String d = "tp";
    private final String a;
    private KeyStore b;

    /* renamed from: ir.nasim.tp$a */
    public static final class a {
        String a = null;
        KeyStore b;

        public a() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
            this.b = null;
            if (!C21601tp.g()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.b = keyStore;
                keyStore.load(null);
            } catch (IOException | GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public C21601tp() {
        this(new a());
    }

    static boolean d(String str) {
        C21601tp c21601tp = new C21601tp();
        synchronized (c) {
            try {
                if (c21601tp.f(str)) {
                    return false;
                }
                e(str);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void e(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        String strB = AbstractC12327eQ7.b("android-keystore://", str);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(strB, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
        keyGenerator.generateKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g() {
        return true;
    }

    private static void h() throws InterruptedException {
        try {
            Thread.sleep((int) (Math.random() * 40.0d));
        } catch (InterruptedException unused) {
        }
    }

    private static InterfaceC3780Ci i(InterfaceC3780Ci interfaceC3780Ci) throws KeyStoreException {
        byte[] bArrA = AbstractC16435lG5.a(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(bArrA, interfaceC3780Ci.b(interfaceC3780Ci.a(bArrA, bArr), bArr))) {
            return interfaceC3780Ci;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    @Override // ir.nasim.InterfaceC16192kr3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.a     // Catch: java.lang.Throwable -> Le
            r1 = 1
            if (r0 == 0) goto L10
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L10
            monitor-exit(r2)
            return r1
        Le:
            r3 = move-exception
            goto L26
        L10:
            java.lang.String r0 = r2.a     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L23
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Throwable -> Le
            java.lang.String r3 = r3.toLowerCase(r0)     // Catch: java.lang.Throwable -> Le
            java.lang.String r0 = "android-keystore://"
            boolean r3 = r3.startsWith(r0)     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L23
            goto L24
        L23:
            r1 = 0
        L24:
            monitor-exit(r2)
            return r1
        L26:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21601tp.a(java.lang.String):boolean");
    }

    @Override // ir.nasim.InterfaceC16192kr3
    public synchronized InterfaceC3780Ci b(String str) {
        try {
            String str2 = this.a;
            if (str2 != null && !str2.equals(str)) {
                throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.a, str));
            }
        } catch (Throwable th) {
            throw th;
        }
        return i(new C20914sp(AbstractC12327eQ7.b("android-keystore://", str), this.b));
    }

    synchronized boolean f(String str) {
        String strB;
        strB = AbstractC12327eQ7.b("android-keystore://", str);
        try {
        } catch (NullPointerException unused) {
            Log.w(d, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            try {
                h();
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.b = keyStore;
                keyStore.load(null);
                return this.b.containsAlias(strB);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            }
        }
        return this.b.containsAlias(strB);
    }

    private C21601tp(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
    }
}
