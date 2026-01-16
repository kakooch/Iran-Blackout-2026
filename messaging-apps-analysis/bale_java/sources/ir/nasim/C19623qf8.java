package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* renamed from: ir.nasim.qf8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C19623qf8 implements Gf8 {
    final /* synthetic */ FrameLayout a;
    final /* synthetic */ LayoutInflater b;
    final /* synthetic */ ViewGroup c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ BG1 e;

    C19623qf8(BG1 bg1, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = bg1;
        this.a = frameLayout;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.d = bundle;
    }

    @Override // ir.nasim.Gf8
    public final void a(InterfaceC15678jz3 interfaceC15678jz3) {
        this.a.removeAllViews();
        this.a.addView(this.e.a.b(this.b, this.c, this.d));
    }

    @Override // ir.nasim.Gf8
    public final int b() {
        return 2;
    }
}
