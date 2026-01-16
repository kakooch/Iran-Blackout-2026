package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes.dex */
public final class zzd extends AsyncTaskLoader<Void> implements SignInConnectionListener {
    private Semaphore zzcg;
    private Set<GoogleApiClient> zzch;

    public zzd(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzcg = new Semaphore(0);
        this.zzch = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.loader.content.AsyncTaskLoader
    /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final Void loadInBackground() throws InterruptedException {
        Iterator<GoogleApiClient> it = this.zzch.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().maybeSignIn(this)) {
                i++;
            }
        }
        try {
            this.zzcg.tryAcquire(i, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // androidx.loader.content.Loader
    protected final void onStartLoading() {
        this.zzcg.drainPermits();
        forceLoad();
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.zzcg.release();
    }
}
