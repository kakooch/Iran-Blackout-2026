package ir.nasim;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.aq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class CallableC9964aq8 implements Callable {
    private final /* synthetic */ SharedPreferences a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    CallableC9964aq8(SharedPreferences sharedPreferences, String str, String str2) {
        this.a = sharedPreferences;
        this.b = str;
        this.c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.a.getString(this.b, this.c);
    }
}
