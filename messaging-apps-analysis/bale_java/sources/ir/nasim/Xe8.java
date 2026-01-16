package ir.nasim;

import android.os.Looper;
import com.google.android.gms.common.api.internal.AbstractC2058b;

/* loaded from: classes3.dex */
public final class Xe8 extends Re8 {
    private final com.google.android.gms.common.api.b c;

    public Xe8(com.google.android.gms.common.api.b bVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.c = bVar;
    }

    @Override // com.google.android.gms.common.api.c
    public final AbstractC2058b a(AbstractC2058b abstractC2058b) {
        return this.c.o(abstractC2058b);
    }

    @Override // com.google.android.gms.common.api.c
    public final Looper c() {
        return this.c.t();
    }
}
