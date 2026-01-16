package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* loaded from: classes2.dex */
public final class IU3 {
    private final String a;
    private final KeyGenParameterSpec b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.AES256_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static final class b {
        final String a;
        KeyGenParameterSpec b;
        c c;
        boolean d;
        int e;
        boolean f;
        final Context g;

        static class a {

            /* renamed from: ir.nasim.IU3$b$a$a, reason: collision with other inner class name */
            static class C0419a {
                static void a(KeyGenParameterSpec.Builder builder) {
                    builder.setIsStrongBoxBacked(true);
                }
            }

            /* renamed from: ir.nasim.IU3$b$a$b, reason: collision with other inner class name */
            static class C0420b {
                static void a(KeyGenParameterSpec.Builder builder, int i, int i2) {
                    builder.setUserAuthenticationParameters(i, i2);
                }
            }

            static IU3 a(b bVar) {
                c cVar = bVar.c;
                if (cVar == null && bVar.b == null) {
                    throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
                }
                if (cVar == c.AES256_GCM) {
                    KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(bVar.a, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256);
                    if (bVar.d) {
                        keySize.setUserAuthenticationRequired(true);
                        if (Build.VERSION.SDK_INT >= 30) {
                            C0420b.a(keySize, bVar.e, 3);
                        } else {
                            keySize.setUserAuthenticationValidityDurationSeconds(bVar.e);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 28 && bVar.f && bVar.g.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                        C0419a.a(keySize);
                    }
                    bVar.b = keySize.build();
                }
                KeyGenParameterSpec keyGenParameterSpec = bVar.b;
                if (keyGenParameterSpec != null) {
                    return new IU3(LU3.c(keyGenParameterSpec), bVar.b);
                }
                throw new NullPointerException("KeyGenParameterSpec was null after build() check");
            }

            static String b(KeyGenParameterSpec keyGenParameterSpec) {
                return keyGenParameterSpec.getKeystoreAlias();
            }
        }

        public b(Context context) {
            this(context, "_androidx_security_master_key_");
        }

        public IU3 a() {
            return a.a(this);
        }

        public b b(c cVar) {
            if (a.a[cVar.ordinal()] == 1) {
                if (this.b != null) {
                    throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
                }
                this.c = cVar;
                return this;
            }
            throw new IllegalArgumentException("Unsupported scheme: " + cVar);
        }

        public b(Context context, String str) {
            this.g = context.getApplicationContext();
            this.a = str;
        }
    }

    public enum c {
        AES256_GCM
    }

    IU3(String str, Object obj) {
        this.a = str;
        this.b = (KeyGenParameterSpec) obj;
    }

    String a() {
        return this.a;
    }

    public boolean b() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.containsAlias(this.a);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            return false;
        }
    }

    public String toString() {
        return "MasterKey{keyAlias=" + this.a + ", isKeyStoreBacked=" + b() + "}";
    }
}
