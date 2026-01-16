package ir.nasim;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.br8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class CallableC10591br8 implements Callable {
    private final /* synthetic */ Context a;

    CallableC10591br8(Context context) {
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.a.getSharedPreferences("google_sdk_flags", 0);
    }
}
