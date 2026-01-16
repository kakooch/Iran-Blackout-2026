package ir.eitaa.messenger.support.fingerprint;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import androidx.core.os.CancellationSignal;
import ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompatApi23;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class FingerprintManagerCompat {
    static final FingerprintManagerCompatImpl IMPL;
    private Context mContext;

    public static abstract class AuthenticationCallback {
        public abstract void onAuthenticationError(int errMsgId, CharSequence errString);

        public abstract void onAuthenticationFailed();

        public abstract void onAuthenticationHelp(int helpMsgId, CharSequence helpString);

        public abstract void onAuthenticationSucceeded(AuthenticationResult result);
    }

    private interface FingerprintManagerCompatImpl {
        void authenticate(Context context, CryptoObject crypto, int flags, CancellationSignal cancel, AuthenticationCallback callback, Handler handler);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    private static class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public void authenticate(Context context, CryptoObject crypto, int flags, CancellationSignal cancel, AuthenticationCallback callback, Handler handler) {
        }

        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean hasEnrolledFingerprints(Context context) {
            return false;
        }

        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean isHardwareDetected(Context context) {
            return false;
        }
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            IMPL = new Api23FingerprintManagerCompatImpl();
        } else {
            IMPL = new LegacyFingerprintManagerCompatImpl();
        }
    }

    public boolean hasEnrolledFingerprints() {
        return IMPL.hasEnrolledFingerprints(this.mContext);
    }

    public boolean isHardwareDetected() {
        return IMPL.isHardwareDetected(this.mContext);
    }

    public void authenticate(CryptoObject crypto, int flags, CancellationSignal cancel, AuthenticationCallback callback, Handler handler) {
        IMPL.authenticate(this.mContext, crypto, flags, cancel, callback, handler);
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }
    }

    public static final class AuthenticationResult {
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject crypto) {
            this.mCryptoObject = crypto;
        }
    }

    private static class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean hasEnrolledFingerprints(Context context) {
            return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
        }

        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean isHardwareDetected(Context context) {
            return FingerprintManagerCompatApi23.isHardwareDetected(context);
        }

        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public void authenticate(Context context, CryptoObject crypto, int flags, CancellationSignal cancel, AuthenticationCallback callback, Handler handler) {
            FingerprintManagerCompatApi23.authenticate(context, wrapCryptoObject(crypto), flags, cancel != null ? cancel.getCancellationSignalObject() : null, wrapCallback(callback), handler);
        }

        private static FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        static CryptoObject unwrapCryptoObject(FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        private static FingerprintManagerCompatApi23.AuthenticationCallback wrapCallback(final AuthenticationCallback callback) {
            return new FingerprintManagerCompatApi23.AuthenticationCallback() { // from class: ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.1
                @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationError(int errMsgId, CharSequence errString) {
                    callback.onAuthenticationError(errMsgId, errString);
                }

                @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
                    callback.onAuthenticationHelp(helpMsgId, helpString);
                }

                @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal result) {
                    callback.onAuthenticationSucceeded(new AuthenticationResult(Api23FingerprintManagerCompatImpl.unwrapCryptoObject(result.getCryptoObject())));
                }

                @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationFailed() {
                    callback.onAuthenticationFailed();
                }
            };
        }
    }
}
