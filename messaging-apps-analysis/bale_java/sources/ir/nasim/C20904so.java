package ir.nasim;

import android.os.Build;
import android.view.ViewConfiguration;
import java.util.List;

/* renamed from: ir.nasim.so, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C20904so implements InterfaceC7307Rd6 {
    private final ViewConfiguration a;

    public C20904so(ViewConfiguration viewConfiguration) {
        this.a = viewConfiguration;
    }

    @Override // ir.nasim.InterfaceC7307Rd6
    public long b(WH1 wh1, C3534Bg5 c3534Bg5, long j) {
        int i = Build.VERSION.SDK_INT;
        float f = -(i > 26 ? C18945pW7.a.b(this.a) : wh1.w1(C17784nZ1.q(64)));
        float f2 = -(i > 26 ? C18945pW7.a.a(this.a) : wh1.w1(C17784nZ1.q(64)));
        List listC = c3534Bg5.c();
        ZG4 zg4D = ZG4.d(ZG4.b.c());
        int size = listC.size();
        for (int i2 = 0; i2 < size; i2++) {
            zg4D = ZG4.d(ZG4.q(zg4D.t(), ((C6616Og5) listC.get(i2)).m()));
        }
        long jT = zg4D.t();
        return ZG4.e((Float.floatToRawIntBits(Float.intBitsToFloat((int) (jT >> 32)) * f2) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (jT & 4294967295L)) * f) & 4294967295L));
    }
}
