package ir.resaneh1.iptv.apiIPTV;

import org.rbmain.messenger.ApplicationLoader;
import retrofit2.Call;
import retrofit2.Callback;

/* loaded from: classes3.dex */
public abstract class CallbackWithRetry<T> implements Callback<T> {
    private final Call<T> call;
    public int retriedCount = 0;

    public CallbackWithRetry(Call<T> call) {
        this.call = call;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<T> call, Throwable th) {
        if (call.isCanceled()) {
            return;
        }
        FaildRequestHandler.getInstance().ShowNetwrokConnectionProblemDialog(ApplicationLoader.applicationContext, this);
    }

    public void retry() {
        this.retriedCount++;
        this.call.mo2129clone().enqueue(this);
    }
}
