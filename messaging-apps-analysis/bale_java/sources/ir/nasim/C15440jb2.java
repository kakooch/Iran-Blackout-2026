package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.jb2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15440jb2 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;

    public C15440jb2(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C15440jb2 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C15440jb2(interfaceC7720Sx5);
    }

    public static String c(Context context) {
        return (String) AbstractC3561Bj5.c(AbstractC14240hb2.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.a.get());
    }
}
