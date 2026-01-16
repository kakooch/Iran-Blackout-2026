package ir.nasim;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.ko8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class CallableC16167ko8 implements Callable {
    private final /* synthetic */ SharedPreferences a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Long c;

    CallableC16167ko8(SharedPreferences sharedPreferences, String str, Long l) {
        this.a = sharedPreferences;
        this.b = str;
        this.c = l;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return Long.valueOf(this.a.getLong(this.b, this.c.longValue()));
    }
}
