package ir.nasim;

import android.content.Intent;

/* loaded from: classes3.dex */
final class Bf8 extends Cf8 {
    final /* synthetic */ Intent a;
    final /* synthetic */ InterfaceC16269kz3 b;

    Bf8(Intent intent, InterfaceC16269kz3 interfaceC16269kz3, int i) {
        this.a = intent;
        this.b = interfaceC16269kz3;
    }

    @Override // ir.nasim.Cf8
    public final void a() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, 2);
        }
    }
}
