package ir.nasim;

import android.content.Context;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

/* renamed from: ir.nasim.xu8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24026xu8 implements JE {
    private final JE a;
    private final JE b;

    public C24026xu8(Context context) {
        this.a = new Lt8(context, com.google.android.gms.common.b.f());
        this.b = Fr8.c(context);
    }

    public static /* synthetic */ Task a(C24026xu8 c24026xu8, Task task) {
        if (task.p() || task.n()) {
            return task;
        }
        Exception excK = task.k();
        if (!(excK instanceof ApiException)) {
            return task;
        }
        int statusCode = ((ApiException) excK).getStatusCode();
        return (statusCode == 43001 || statusCode == 43002 || statusCode == 43003 || statusCode == 17) ? c24026xu8.b.f() : statusCode == 43000 ? AbstractC9078Yj7.d(new Exception("Failed to get app set ID due to an internal error. Please try again later.")) : statusCode != 15 ? task : AbstractC9078Yj7.d(new Exception("The operation to get app set ID timed out. Please try again later."));
    }

    @Override // ir.nasim.JE
    public final Task f() {
        return this.a.f().i(new InterfaceC20886sm1() { // from class: ir.nasim.ou8
            @Override // ir.nasim.InterfaceC20886sm1
            public final Object a(Task task) {
                return C24026xu8.a(this.a, task);
            }
        });
    }
}
