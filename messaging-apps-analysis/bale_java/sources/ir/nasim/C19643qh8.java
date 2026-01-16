package ir.nasim;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.AbstractC2064h;
import com.google.android.gms.tasks.Task;

/* renamed from: ir.nasim.qh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19643qh8 extends TF6 {
    public C19643qh8(Activity activity) {
        super(activity);
    }

    @Override // ir.nasim.TF6
    public final Task A(final String str) {
        return p(AbstractC2064h.a().b(new InterfaceC13525gN5() { // from class: ir.nasim.Hv8
            @Override // ir.nasim.InterfaceC13525gN5
            public final void accept(Object obj, Object obj2) {
                C19643qh8 c19643qh8 = this.a;
                ((Vo8) ((uv8) obj).D()).E2(str, new BinderC14916ih8(c19643qh8, (C4982Hj7) obj2));
            }
        }).d(AbstractC20843sh8.d).e(1568).a());
    }

    @Override // ir.nasim.TF6
    public final Task z() {
        return p(AbstractC2064h.a().b(new InterfaceC13525gN5() { // from class: ir.nasim.Bv8
            @Override // ir.nasim.InterfaceC13525gN5
            public final void accept(Object obj, Object obj2) {
                ((Vo8) ((uv8) obj).D()).D2(new Nv8(this.a, (C4982Hj7) obj2));
            }
        }).d(AbstractC20843sh8.c).e(1567).a());
    }

    public C19643qh8(Context context) {
        super(context);
    }
}
