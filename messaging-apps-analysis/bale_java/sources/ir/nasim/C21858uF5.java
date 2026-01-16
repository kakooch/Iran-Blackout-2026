package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.uF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21858uF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C21858uF5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C21858uF5 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C21858uF5(interfaceC7720Sx5);
    }

    public static C8668Wy3 c(Context context) {
        return (C8668Wy3) AbstractC4746Gj5.d(C17017mF5.a.n(context));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C8668Wy3 get() {
        return c((Context) this.a.get());
    }
}
