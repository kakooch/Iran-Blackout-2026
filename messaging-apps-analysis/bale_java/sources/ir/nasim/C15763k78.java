package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.k78, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15763k78 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C15763k78(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C15763k78 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C15763k78(interfaceC7720Sx5);
    }

    public static InterfaceC13220fr4 c(Context context) {
        return (InterfaceC13220fr4) AbstractC4746Gj5.d(C12745f78.a.e(context));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC13220fr4 get() {
        return c((Context) this.a.get());
    }
}
