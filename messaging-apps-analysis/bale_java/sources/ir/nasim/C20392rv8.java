package ir.nasim;

import android.content.Context;
import android.content.Intent;

/* renamed from: ir.nasim.rv8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C20392rv8 implements InterfaceC21590tn8 {
    final /* synthetic */ PI6 a;
    final /* synthetic */ Intent b;
    final /* synthetic */ Context c;
    final /* synthetic */ Ev8 d;

    C20392rv8(Ev8 ev8, PI6 pi6, Intent intent, Context context) {
        this.d = ev8;
        this.a = pi6;
        this.b = intent;
        this.c = context;
    }

    @Override // ir.nasim.InterfaceC21590tn8
    public final void e() {
        if (this.b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.d.a.b("Splits copied and verified more than once.", new Object[0]);
        } else {
            this.b.putExtra("triggered_from_app_after_verification", true);
            this.c.sendBroadcast(this.b);
        }
    }

    @Override // ir.nasim.InterfaceC21590tn8
    public final void l(int i) {
        Ev8 ev8 = this.d;
        ev8.g.post(new zv8(ev8, this.a, 6, i));
    }

    @Override // ir.nasim.InterfaceC21590tn8
    public final void zza() {
        Ev8 ev8 = this.d;
        ev8.g.post(new zv8(ev8, this.a, 5, 0));
    }
}
