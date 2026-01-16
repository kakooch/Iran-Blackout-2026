package ir.nasim;

/* loaded from: classes3.dex */
public final class Ts8 implements Ss8 {
    public static final AbstractC11344cq8 a = new Lp8(Ap8.a("com.google.android.gms.measurement")).a().f("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // ir.nasim.Ss8
    public final boolean c() {
        return ((Boolean) a.b()).booleanValue();
    }

    @Override // ir.nasim.Ss8
    public final boolean zza() {
        return true;
    }
}
