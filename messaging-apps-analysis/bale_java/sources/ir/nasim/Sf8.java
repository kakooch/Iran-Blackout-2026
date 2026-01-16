package ir.nasim;

import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC22929w35;
import ir.nasim.AbstractC23519x35;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class Sf8 implements AbstractC22929w35.a {
    final /* synthetic */ AbstractC22929w35 a;
    final /* synthetic */ C4982Hj7 b;
    final /* synthetic */ AbstractC23519x35.a c;
    final /* synthetic */ Uf8 d;

    Sf8(AbstractC22929w35 abstractC22929w35, C4982Hj7 c4982Hj7, AbstractC23519x35.a aVar, Uf8 uf8) {
        this.a = abstractC22929w35;
        this.b = c4982Hj7;
        this.c = aVar;
        this.d = uf8;
    }

    @Override // ir.nasim.AbstractC22929w35.a
    public final void a(Status status) {
        if (!status.x0()) {
            this.b.b(AbstractC10033ay.a(status));
        } else {
            this.b.c(this.c.a(this.a.await(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
