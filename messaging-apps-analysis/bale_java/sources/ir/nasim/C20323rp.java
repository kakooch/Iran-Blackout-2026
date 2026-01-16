package ir.nasim;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* renamed from: ir.nasim.rp, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20323rp {
    private static final Object d = new Object();
    private static final String e = "rp";
    private final InterfaceC6201Mp3 a;
    private final InterfaceC3780Ci b;
    private C5734Kp3 c;

    /* renamed from: ir.nasim.rp$b */
    public static final class b {
        private Context a = null;
        private String b = null;
        private String c = null;
        private String d = null;
        private InterfaceC3780Ci e = null;
        private boolean f = true;
        private C6925Po3 g = null;
        private C6691Oo3 h = null;
        private C5734Kp3 i;

        private C5734Kp3 g() throws GeneralSecurityException {
            if (this.g == null) {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
            C5734Kp3 c5734Kp3A = C5734Kp3.i().a(this.g);
            C5734Kp3 c5734Kp3H = c5734Kp3A.h(c5734Kp3A.d().i().W(0).W());
            C20323rp.g(c5734Kp3H.d(), new C10665bz6(this.a, this.b, this.c), this.e);
            return c5734Kp3H;
        }

        private static byte[] h(Context context, String str, String str2) throws CharConversionException {
            if (str == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            Context applicationContext = context.getApplicationContext();
            try {
                String string = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).getString(str, null);
                if (string == null) {
                    return null;
                }
                return AbstractC21999uV2.a(string);
            } catch (ClassCastException | IllegalArgumentException unused) {
                throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
            }
        }

        private C5734Kp3 i(byte[] bArr) {
            return C5734Kp3.j(AbstractC14794iV0.a(C6832Pe0.b(bArr)));
        }

        private C5734Kp3 j(byte[] bArr) {
            try {
                this.e = new C21601tp().b(this.d);
                try {
                    return C5734Kp3.j(C5266Ip3.o(C6832Pe0.b(bArr), this.e));
                } catch (IOException | GeneralSecurityException e) {
                    try {
                        return i(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                try {
                    C5734Kp3 c5734Kp3I = i(bArr);
                    Log.w(C20323rp.e, "cannot use Android Keystore, it'll be disabled", e2);
                    return c5734Kp3I;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }

        private InterfaceC3780Ci k() throws KeyStoreException {
            if (!C20323rp.f()) {
                Log.w(C20323rp.e, "Android Keystore requires at least Android M");
                return null;
            }
            C21601tp c21601tp = new C21601tp();
            try {
                boolean zD = C21601tp.d(this.d);
                try {
                    return c21601tp.b(this.d);
                } catch (GeneralSecurityException | ProviderException e) {
                    if (!zD) {
                        throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.d), e);
                    }
                    Log.w(C20323rp.e, "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                Log.w(C20323rp.e, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        public synchronized C20323rp f() {
            C20323rp c20323rp;
            try {
                if (this.b == null) {
                    throw new IllegalArgumentException("keysetName cannot be null");
                }
                C6691Oo3 c6691Oo3 = this.h;
                if (c6691Oo3 != null && this.g == null) {
                    this.g = C6925Po3.a(AbstractC5981Lq7.a(c6691Oo3.f()));
                }
                synchronized (C20323rp.d) {
                    try {
                        byte[] bArrH = h(this.a, this.b, this.c);
                        if (bArrH == null) {
                            if (this.d != null) {
                                this.e = k();
                            }
                            this.i = g();
                        } else if (this.d == null || !C20323rp.f()) {
                            this.i = i(bArrH);
                        } else {
                            this.i = j(bArrH);
                        }
                        c20323rp = new C20323rp(this);
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
            return c20323rp;
        }

        public b l(C6925Po3 c6925Po3) {
            this.g = c6925Po3;
            return this;
        }

        public b m(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.f) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.d = str;
            return this;
        }

        public b n(Context context, String str, String str2) {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            if (str == null) {
                throw new IllegalArgumentException("need a keyset name");
            }
            this.a = context;
            this.b = str;
            this.c = str2;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(C5266Ip3 c5266Ip3, InterfaceC6201Mp3 interfaceC6201Mp3, InterfaceC3780Ci interfaceC3780Ci) throws GeneralSecurityException {
        try {
            if (interfaceC3780Ci != null) {
                c5266Ip3.s(interfaceC6201Mp3, interfaceC3780Ci);
            } else {
                AbstractC14794iV0.b(c5266Ip3, interfaceC6201Mp3);
            }
        } catch (IOException e2) {
            throw new GeneralSecurityException(e2);
        }
    }

    public synchronized C5266Ip3 e() {
        return this.c.d();
    }

    private C20323rp(b bVar) {
        this.a = new C10665bz6(bVar.a, bVar.b, bVar.c);
        this.b = bVar.e;
        this.c = bVar.i;
    }
}
