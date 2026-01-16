package ir.nasim;

/* renamed from: ir.nasim.rq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC20342rq8 implements Pr8 {
    @Override // ir.nasim.Pr8
    public final /* synthetic */ Pr8 N0(byte[] bArr, com.google.android.gms.internal.measurement.H0 h0) {
        return h(bArr, 0, bArr.length, h0);
    }

    public abstract AbstractC20342rq8 f(byte[] bArr, int i, int i2);

    public abstract AbstractC20342rq8 h(byte[] bArr, int i, int i2, com.google.android.gms.internal.measurement.H0 h0);

    @Override // ir.nasim.Pr8
    public final /* synthetic */ Pr8 x0(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }
}
