package ir.nasim;

import android.location.Location;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.model.LatLng;
import ir.nasim.features.map.data.GetLocationStateUseCase;
import java.util.List;

/* renamed from: ir.nasim.bO3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10282bO3 extends VW7 {
    private final LocationRequest b;
    private InterfaceC9336Zm4 c;
    private final InterfaceC9173Yu3 d;
    private InterfaceC9336Zm4 e;
    private InterfaceC9336Zm4 f;
    private final InterfaceC10258bL6 g;

    /* renamed from: ir.nasim.bO3$a */
    public static final class a extends LocationCallback {
        a() {
        }

        @Override // com.google.android.gms.location.LocationCallback
        public void onLocationResult(LocationResult locationResult) {
            Object value;
            AbstractC13042fc3.i(locationResult, "googleMap");
            List<Location> listS = locationResult.S();
            AbstractC13042fc3.h(listS, "getLocations(...)");
            C10282bO3 c10282bO3 = C10282bO3.this;
            for (Location location : listS) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = c10282bO3.c;
                do {
                    value = interfaceC9336Zm4.getValue();
                    if (((LatLng) value) == null) {
                        c10282bO3.Z0(true);
                    }
                } while (!interfaceC9336Zm4.f(value, new LatLng(location.getLatitude(), location.getLongitude())));
            }
        }
    }

    public C10282bO3(GetLocationStateUseCase getLocationStateUseCase) {
        AbstractC13042fc3.i(getLocationStateUseCase, "locationStateUseCase");
        LocationRequest locationRequestA = new LocationRequest.a(1000L).c(2000L).e(100).a();
        AbstractC13042fc3.h(locationRequestA, "build(...)");
        this.b = locationRequestA;
        this.c = AbstractC12281eL6.a(null);
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.aO3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10282bO3.Y0(this.a);
            }
        });
        this.e = AbstractC12281eL6.a(Boolean.FALSE);
        this.f = AbstractC12281eL6.a(1);
        this.g = getLocationStateUseCase.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a Y0(C10282bO3 c10282bO3) {
        AbstractC13042fc3.i(c10282bO3, "this$0");
        return c10282bO3.new a();
    }

    public final LocationCallback S0() {
        return (LocationCallback) this.d.getValue();
    }

    public final LocationRequest T0() {
        return this.b;
    }

    public final InterfaceC10258bL6 U0() {
        return AbstractC6459Nq2.c(this.c);
    }

    public final InterfaceC10258bL6 V0() {
        return AbstractC6459Nq2.c(this.f);
    }

    public final InterfaceC10258bL6 W0() {
        return AbstractC6459Nq2.c(this.e);
    }

    public final InterfaceC10258bL6 X0() {
        return this.g;
    }

    public final void Z0(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void a1(int i) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Number) value).intValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i)));
    }
}
