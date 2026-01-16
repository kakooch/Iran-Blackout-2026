package ir.nasim.features.map.data;

import android.content.Context;
import android.location.LocationManager;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.features.map.data.GetLocationStateUseCase;

/* loaded from: classes3.dex */
public final class GetLocationStateUseCase {
    private final Context a;
    private final InterfaceC20315ro1 b;
    private final AbstractC13778go1 c;
    private final InterfaceC9173Yu3 d;
    private final InterfaceC10258bL6 e;

    public GetLocationStateUseCase(Context context, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        this.a = context;
        this.b = interfaceC20315ro1;
        this.c = abstractC13778go1;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bG2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return GetLocationStateUseCase.g(this.a);
            }
        });
        this.e = AbstractC6459Nq2.o0(AbstractC6459Nq2.V(AbstractC6459Nq2.f(new GetLocationStateUseCase$isLocationOnState$1(this, null)), abstractC13778go1), interfaceC20315ro1, InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), Boolean.valueOf(f()));
    }

    private final LocationManager d() {
        return (LocationManager) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        return d().isProviderEnabled("gps");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationManager g(GetLocationStateUseCase getLocationStateUseCase) {
        AbstractC13042fc3.i(getLocationStateUseCase, "this$0");
        Object systemService = getLocationStateUseCase.a.getSystemService("location");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return (LocationManager) systemService;
    }

    public final InterfaceC10258bL6 e() {
        return this.e;
    }
}
