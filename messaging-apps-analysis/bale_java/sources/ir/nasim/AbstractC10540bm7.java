package ir.nasim;

import android.view.InputDevice;
import android.view.KeyEvent;

/* renamed from: ir.nasim.bm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10540bm7 {

    /* renamed from: ir.nasim.bm7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC3630Br2 e;
        final /* synthetic */ C6542Ny3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC3630Br2 interfaceC3630Br2, C6542Ny3 c6542Ny3) {
            super(1);
            this.e = interfaceC3630Br2;
            this.f = c6542Ny3;
        }

        public final Boolean a(KeyEvent keyEvent) {
            InputDevice device = keyEvent.getDevice();
            boolean zF = false;
            if (device != null && device.supportsSource(513) && !device.isVirtual() && AbstractC22775vo3.e(AbstractC23371wo3.b(keyEvent), AbstractC22775vo3.a.a()) && keyEvent.getSource() != 257) {
                if (AbstractC10540bm7.c(keyEvent, 19)) {
                    zF = this.e.f(androidx.compose.ui.focus.d.b.h());
                } else if (AbstractC10540bm7.c(keyEvent, 20)) {
                    zF = this.e.f(androidx.compose.ui.focus.d.b.a());
                } else if (AbstractC10540bm7.c(keyEvent, 21)) {
                    zF = this.e.f(androidx.compose.ui.focus.d.b.d());
                } else if (AbstractC10540bm7.c(keyEvent, 22)) {
                    zF = this.e.f(androidx.compose.ui.focus.d.b.g());
                } else if (AbstractC10540bm7.c(keyEvent, 23)) {
                    InterfaceC20600sH6 interfaceC20600sH6J = this.f.j();
                    if (interfaceC20600sH6J != null) {
                        interfaceC20600sH6J.a();
                    }
                    zF = true;
                }
            }
            return Boolean.valueOf(zF);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((C20908so3) obj).f());
        }
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, C6542Ny3 c6542Ny3, InterfaceC3630Br2 interfaceC3630Br2) {
        return androidx.compose.ui.input.key.a.b(eVar, new a(interfaceC3630Br2, c6542Ny3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(KeyEvent keyEvent, int i) {
        return AbstractC9353Zo3.b(AbstractC23371wo3.a(keyEvent)) == i;
    }
}
