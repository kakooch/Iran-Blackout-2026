package ir.nasim;

import android.os.CancellationSignal;
import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.ib1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14850ib1 {

    /* renamed from: ir.nasim.ib1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ CancellationSignal e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CancellationSignal cancellationSignal) {
            super(1);
            this.e = cancellationSignal;
        }

        public final void a(Throwable th) {
            if (th != null) {
                this.e.cancel();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC13730gj3 c(InterfaceC20315ro1 interfaceC20315ro1, CancellationSignal cancellationSignal, InterfaceC14603iB2 interfaceC14603iB2) {
        final InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(interfaceC20315ro1, null, null, interfaceC14603iB2, 3, null);
        interfaceC13730gj3D.s(new a(cancellationSignal));
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: ir.nasim.hb1
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                AbstractC14850ib1.d(interfaceC13730gj3D);
            }
        });
        return interfaceC13730gj3D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(InterfaceC13730gj3 interfaceC13730gj3) {
        InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
    }
}
