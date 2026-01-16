package ir.nasim;

import com.google.android.gms.location.LocationSettingsResult;

/* loaded from: classes3.dex */
final class Cl8 extends AbstractBinderC25210zu8 {
    final /* synthetic */ C4982Hj7 a;

    Cl8(C4982Hj7 c4982Hj7) {
        this.a = c4982Hj7;
    }

    @Override // ir.nasim.Ju8
    public final void W(LocationSettingsResult locationSettingsResult) {
        AbstractC6884Pj7.b(locationSettingsResult.j(), new C12860fI3(locationSettingsResult), this.a);
    }
}
