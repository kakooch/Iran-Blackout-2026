package ir.nasim;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes3.dex */
final class Ov8 extends ContentObserver {
    Ov8(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        Iv8.e.set(true);
    }
}
