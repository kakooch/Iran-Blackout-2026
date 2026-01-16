package ir.nasim;

import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.w35, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22929w35 {

    /* renamed from: ir.nasim.w35$a */
    public interface a {
        void a(Status status);
    }

    public abstract void addStatusListener(a aVar);

    public abstract InterfaceC10069b16 await(long j, TimeUnit timeUnit);
}
