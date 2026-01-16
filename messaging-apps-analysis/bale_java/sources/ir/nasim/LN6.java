package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class LN6 {
    private static final Lock c = new ReentrantLock();
    private static LN6 d;
    private final Lock a = new ReentrantLock();
    private final SharedPreferences b;

    LN6(Context context) {
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static LN6 b(Context context) {
        AbstractC3795Cj5.j(context);
        Lock lock = c;
        lock.lock();
        try {
            if (d == null) {
                d = new LN6(context.getApplicationContext());
            }
            LN6 ln6 = d;
            lock.unlock();
            return ln6;
        } catch (Throwable th) {
            c.unlock();
            throw th;
        }
    }

    private static final String i(String str, String str2) {
        return str + ":" + str2;
    }

    public void a() {
        this.a.lock();
        try {
            this.b.edit().clear().apply();
        } finally {
            this.a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(i("googleSignInAccount", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.S1(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    public GoogleSignInOptions d() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(i("googleSignInOptions", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.X0(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String e() {
        return g("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        AbstractC3795Cj5.j(googleSignInAccount);
        AbstractC3795Cj5.j(googleSignInOptions);
        h("defaultGoogleSignInAccount", googleSignInAccount.T1());
        AbstractC3795Cj5.j(googleSignInAccount);
        AbstractC3795Cj5.j(googleSignInOptions);
        String strT1 = googleSignInAccount.T1();
        h(i("googleSignInAccount", strT1), googleSignInAccount.U1());
        h(i("googleSignInOptions", strT1), googleSignInOptions.V1());
    }

    protected final String g(String str) {
        this.a.lock();
        try {
            return this.b.getString(str, null);
        } finally {
            this.a.unlock();
        }
    }

    protected final void h(String str, String str2) {
        this.a.lock();
        try {
            this.b.edit().putString(str, str2).apply();
        } finally {
            this.a.unlock();
        }
    }
}
