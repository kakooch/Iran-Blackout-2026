package ir.nasim;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: ir.nasim.np8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C17950np8 extends ContentObserver {
    final /* synthetic */ C18541op8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C17950np8(C18541op8 c18541op8, Handler handler) {
        super(null);
        this.a = c18541op8;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.f();
    }
}
