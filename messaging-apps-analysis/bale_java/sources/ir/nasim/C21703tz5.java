package ir.nasim;

/* renamed from: ir.nasim.tz5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21703tz5 {
    private final boolean a;

    C21703tz5(boolean z) {
        this.a = z;
    }

    public void a(C12092e16[] c12092e16Arr) {
        if (!this.a || c12092e16Arr == null || c12092e16Arr.length < 3) {
            return;
        }
        C12092e16 c12092e16 = c12092e16Arr[0];
        c12092e16Arr[0] = c12092e16Arr[2];
        c12092e16Arr[2] = c12092e16;
    }
}
