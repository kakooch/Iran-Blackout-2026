package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapi.zzaz;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@KeepName
/* loaded from: classes.dex */
public class SignInHubActivity extends FragmentActivity {
    private static boolean zzcw = false;
    private boolean zzcx = false;
    private SignInConfiguration zzcy;
    private boolean zzcz;
    private int zzda;
    private Intent zzdb;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    private class zzc implements LoaderManager.LoaderCallbacks<Void> {
        private zzc() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final void onLoaderReset(Loader<Void> loader) {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzd(SignInHubActivity.this, GoogleApiClient.getAllClients());
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final /* synthetic */ void onLoadFinished(Loader<Void> loader, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.zzda, SignInHubActivity.this.zzdb);
            SignInHubActivity.this.finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = (String) zzaz.checkNotNull(intent.getAction());
        if ("com.google.android.gms.auth.NO_IMPL".equals(str)) {
            zzc(12500);
            return;
        }
        if (!str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !str.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String strValueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", strValueOf.length() != 0 ? "Unknown action: ".concat(strValueOf) : new String("Unknown action: "));
            finish();
            return;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) ((Bundle) zzaz.checkNotNull(intent.getBundleExtra("config"))).getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.zzcy = signInConfiguration;
        if (bundle == null) {
            if (zzcw) {
                setResult(0);
                zzc(12502);
                return;
            }
            zzcw = true;
            Intent intent2 = new Intent(str);
            if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                intent2.setPackage("com.google.android.gms");
            } else {
                intent2.setPackage(getPackageName());
            }
            intent2.putExtra("config", this.zzcy);
            try {
                startActivityForResult(intent2, 40962);
                return;
            } catch (ActivityNotFoundException unused) {
                this.zzcx = true;
                Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                zzc(17);
                return;
            }
        }
        boolean z = bundle.getBoolean("signingInGoogleApiClients");
        this.zzcz = z;
        if (z) {
            this.zzda = bundle.getInt("signInResultCode");
            this.zzdb = (Intent) zzaz.checkNotNull((Intent) bundle.getParcelable("signInResultData"));
            zzv();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zzcz);
        if (this.zzcz) {
            bundle.putInt("signInResultCode", this.zzda);
            bundle.putParcelable("signInResultData", this.zzdb);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.zzcx) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                GoogleSignInAccount googleSignInAccount = signInAccount.getGoogleSignInAccount();
                zzq.zzd(this).zzc(this.zzcy.zzu(), (GoogleSignInAccount) zzaz.checkNotNull(googleSignInAccount));
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccount);
                this.zzcz = true;
                this.zzda = i2;
                this.zzdb = intent;
                zzv();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                zzc(intExtra);
                return;
            }
        }
        zzc(8);
    }

    private final void zzv() {
        getSupportLoaderManager().initLoader(0, null, new zzc());
        zzcw = false;
    }

    private final void zzc(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zzcw = false;
    }
}
