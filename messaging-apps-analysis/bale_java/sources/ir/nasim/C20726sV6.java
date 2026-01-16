package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.sV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20726sV6 implements InterfaceC14123hO3 {
    private final Context a;

    public C20726sV6(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C19526qV6 a(EnumC20117rV6 enumC20117rV6) {
        AbstractC13042fc3.i(enumC20117rV6, "input");
        int iS = enumC20117rV6.s();
        Drawable drawableF = AbstractC4043Dl1.f(this.a, enumC20117rV6.j());
        AbstractC13042fc3.f(drawableF);
        return new C19526qV6(iS, drawableF, false, false);
    }
}
