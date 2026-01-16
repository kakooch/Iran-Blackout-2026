package ir.nasim;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes3.dex */
final class Io8 extends ContentObserver {
    Io8(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        AbstractC11334cp8.e.set(true);
    }
}
