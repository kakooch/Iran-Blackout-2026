package ir.nasim;

import ir.nasim.C9475a16;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* renamed from: ir.nasim.tm1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C21573tm1 implements Callback, UA2 {
    private final Call a;
    private final HE0 b;

    public C21573tm1(Call call, HE0 he0) {
        this.a = call;
        this.b = he0;
    }

    public void a(Throwable th) {
        try {
            this.a.cancel();
        } catch (Throwable unused) {
        }
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return C19938rB7.a;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        if (call.getCanceled()) {
            return;
        }
        HE0 he0 = this.b;
        C9475a16.a aVar = C9475a16.b;
        he0.resumeWith(C9475a16.b(AbstractC10685c16.a(iOException)));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        this.b.resumeWith(C9475a16.b(response));
    }
}
