package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import androidx.compose.ui.e;
import ir.nasim.C20908so3;
import ir.nasim.InterfaceC24551yo3;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
final class b extends e.c implements InterfaceC24551yo3 {
    private UA2 o;
    private UA2 p;

    public b(UA2 ua2, UA2 ua22) {
        this.o = ua2;
        this.p = ua22;
    }

    @Override // ir.nasim.InterfaceC24551yo3
    public boolean O0(KeyEvent keyEvent) {
        UA2 ua2 = this.p;
        if (ua2 != null) {
            return ((Boolean) ua2.invoke(C20908so3.a(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC24551yo3
    public boolean g1(KeyEvent keyEvent) {
        UA2 ua2 = this.o;
        if (ua2 != null) {
            return ((Boolean) ua2.invoke(C20908so3.a(keyEvent))).booleanValue();
        }
        return false;
    }

    public final void v2(UA2 ua2) {
        this.o = ua2;
    }

    public final void w2(UA2 ua2) {
        this.p = ua2;
    }
}
