package ir.nasim;

import android.app.Activity;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.internal.AbstractC2064h;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.Task;

/* renamed from: ir.nasim.pl8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19092pl8 extends com.google.android.gms.common.api.b implements InterfaceC13272fw6 {
    public C19092pl8(Activity activity) {
        super(activity, C14946ik8.l, (a.d) a.d.P, b.a.c);
    }

    @Override // ir.nasim.InterfaceC13272fw6
    public final Task e(final LocationSettingsRequest locationSettingsRequest) {
        return l(AbstractC2064h.a().b(new InterfaceC13525gN5() { // from class: ir.nasim.ll8
            @Override // ir.nasim.InterfaceC13525gN5
            public final void accept(Object obj, Object obj2) {
                LocationSettingsRequest locationSettingsRequest2 = locationSettingsRequest;
                com.google.android.gms.internal.location.i iVar = (com.google.android.gms.internal.location.i) obj;
                C4982Hj7 c4982Hj7 = (C4982Hj7) obj2;
                AbstractC3795Cj5.b(locationSettingsRequest2 != null, "locationSettingsRequest can't be null");
                ((InterfaceC11374ct8) iVar.D()).Q0(locationSettingsRequest2, new Cl8(c4982Hj7), null);
            }
        }).e(2426).a());
    }
}
