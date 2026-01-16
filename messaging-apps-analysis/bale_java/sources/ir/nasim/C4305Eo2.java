package ir.nasim;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;

/* renamed from: ir.nasim.Eo2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4305Eo2 {
    public static final C4305Eo2 a = new C4305Eo2();

    /* renamed from: ir.nasim.Eo2$a */
    public static abstract class a {
        public abstract void a(CharSequence charSequence);

        public abstract void b();

        public abstract void c();
    }

    /* renamed from: ir.nasim.Eo2$b */
    public static final class b extends FingerprintManager.AuthenticationCallback {
        final /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i, CharSequence charSequence) {
            AbstractC13042fc3.i(charSequence, "errString");
            this.a.a(charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.a.b();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            AbstractC13042fc3.i(charSequence, "helpString");
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            AbstractC13042fc3.i(authenticationResult, "result");
            this.a.c();
        }
    }

    private C4305Eo2() {
    }

    private final FingerprintManager b(Context context) {
        Object systemService = context.getSystemService((Class<Object>) FingerprintManager.class);
        AbstractC13042fc3.h(systemService, "getSystemService(...)");
        return (FingerprintManager) systemService;
    }

    private final FingerprintManager.AuthenticationCallback e(a aVar) {
        return new b(aVar);
    }

    public final void a(Context context, int i, Object obj, a aVar, Handler handler) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(aVar, "callback");
        try {
            b(context).authenticate(null, (CancellationSignal) obj, i, e(aVar), handler);
        } catch (Exception e) {
            C19406qI3.d("FingerprintManagerCompatApi23", e);
        }
    }

    public final boolean c(Context context) {
        AbstractC13042fc3.i(context, "context");
        try {
            return b(context).hasEnrolledFingerprints();
        } catch (Exception e) {
            C19406qI3.d("FingerprintManagerCompatApi23", e);
            return false;
        }
    }

    public final boolean d(Context context) {
        AbstractC13042fc3.i(context, "context");
        try {
            return b(context).isHardwareDetected();
        } catch (Exception e) {
            C19406qI3.d("FingerprintManagerCompatApi23", e);
            return false;
        }
    }
}
