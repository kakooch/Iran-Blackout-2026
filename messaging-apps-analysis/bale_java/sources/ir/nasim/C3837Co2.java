package ir.nasim;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: ir.nasim.Co2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3837Co2 {
    private final Context a;

    /* renamed from: ir.nasim.Co2$a */
    class a extends FingerprintManager.AuthenticationCallback {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i, CharSequence charSequence) {
            this.a.a(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.a.b();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            this.a.c(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.a.d(new d(C3837Co2.g(b.b(authenticationResult))));
        }
    }

    /* renamed from: ir.nasim.Co2$b */
    static class b {
        static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        public static FingerprintManager c(Context context) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            return null;
        }

        static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        public static e f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new e(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new e(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new e(cryptoObject.getMac());
            }
            return null;
        }

        public static FingerprintManager.CryptoObject g(e eVar) {
            if (eVar == null) {
                return null;
            }
            if (eVar.a() != null) {
                return new FingerprintManager.CryptoObject(eVar.a());
            }
            if (eVar.c() != null) {
                return new FingerprintManager.CryptoObject(eVar.c());
            }
            if (eVar.b() != null) {
                return new FingerprintManager.CryptoObject(eVar.b());
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.Co2$c */
    public static abstract class c {
        public abstract void a(int i, CharSequence charSequence);

        public abstract void b();

        public abstract void c(int i, CharSequence charSequence);

        public abstract void d(d dVar);
    }

    /* renamed from: ir.nasim.Co2$d */
    public static final class d {
        private final e a;

        public d(e eVar) {
            this.a = eVar;
        }

        public e a() {
            return this.a;
        }
    }

    private C3837Co2(Context context) {
        this.a = context;
    }

    public static C3837Co2 c(Context context) {
        return new C3837Co2(context);
    }

    private static FingerprintManager d(Context context) {
        return b.c(context);
    }

    static e g(FingerprintManager.CryptoObject cryptoObject) {
        return b.f(cryptoObject);
    }

    private static FingerprintManager.AuthenticationCallback h(c cVar) {
        return new a(cVar);
    }

    private static FingerprintManager.CryptoObject i(e eVar) {
        return b.g(eVar);
    }

    public void a(e eVar, int i, CancellationSignal cancellationSignal, c cVar, Handler handler) {
        FingerprintManager fingerprintManagerD = d(this.a);
        if (fingerprintManagerD != null) {
            b.a(fingerprintManagerD, i(eVar), cancellationSignal, i, h(cVar), handler);
        }
    }

    public void b(e eVar, int i, QE0 qe0, c cVar, Handler handler) {
        a(eVar, i, qe0 != null ? (CancellationSignal) qe0.b() : null, cVar, handler);
    }

    public boolean e() {
        FingerprintManager fingerprintManagerD = d(this.a);
        return fingerprintManagerD != null && b.d(fingerprintManagerD);
    }

    public boolean f() {
        FingerprintManager fingerprintManagerD = d(this.a);
        return fingerprintManagerD != null && b.e(fingerprintManagerD);
    }

    /* renamed from: ir.nasim.Co2$e */
    public static class e {
        private final Signature a;
        private final Cipher b;
        private final Mac c;

        public e(Signature signature) {
            this.a = signature;
            this.b = null;
            this.c = null;
        }

        public Cipher a() {
            return this.b;
        }

        public Mac b() {
            return this.c;
        }

        public Signature c() {
            return this.a;
        }

        public e(Cipher cipher) {
            this.b = cipher;
            this.a = null;
            this.c = null;
        }

        public e(Mac mac) {
            this.c = mac;
            this.b = null;
            this.a = null;
        }
    }
}
