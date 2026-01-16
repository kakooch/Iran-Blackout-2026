package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.measurement.zzcl;

/* loaded from: classes3.dex */
final class Gl8 extends Cm8 {
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ Context g;
    final /* synthetic */ Bundle h;
    final /* synthetic */ C15566jn8 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Gl8(C15566jn8 c15566jn8, String str, String str2, Context context, Bundle bundle) {
        super(c15566jn8, true);
        this.i = c15566jn8;
        this.e = str;
        this.f = str2;
        this.g = context;
        this.h = bundle;
    }

    @Override // ir.nasim.Cm8
    public final void a() {
        String str;
        String str2;
        String str3;
        try {
            if (this.i.k(this.e, this.f)) {
                str3 = this.f;
                str2 = this.e;
                str = this.i.a;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            AbstractC3795Cj5.j(this.g);
            C15566jn8 c15566jn8 = this.i;
            c15566jn8.i = c15566jn8.p(this.g, true);
            if (this.i.i == null) {
                Log.w(this.i.a, "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(this.g, ModuleDescriptor.MODULE_ID);
            ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.i.i)).initialize(CG4.E2(this.g), new zzcl(74029L, Math.max(iA, r0), DynamiteModule.c(this.g, ModuleDescriptor.MODULE_ID) < iA, str, str2, str3, this.h, Pn8.a(this.g)), this.a);
        } catch (Exception e) {
            this.i.h(e, true, false);
        }
    }
}
