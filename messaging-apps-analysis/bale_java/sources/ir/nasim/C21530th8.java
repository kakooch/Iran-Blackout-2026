package ir.nasim;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: ir.nasim.th8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C21530th8 extends ContentObserver {
    private final /* synthetic */ C17870nh8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C21530th8(C17870nh8 c17870nh8, Handler handler) {
        super(null);
        this.a = c17870nh8;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.d();
        this.a.f();
    }
}
