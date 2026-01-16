package ir.nasim;

import android.content.Context;
import android.os.Build;

/* renamed from: ir.nasim.Cr4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3866Cr4 extends AbstractC8743Xd1 {
    public C3866Cr4(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        super(C7686St7.c(context, interfaceC5684Kj7).d());
    }

    @Override // ir.nasim.AbstractC8743Xd1
    boolean b(C17810nb8 c17810nb8) {
        return c17810nb8.j.b() == EnumC22806vr4.UNMETERED || (Build.VERSION.SDK_INT >= 30 && c17810nb8.j.b() == EnumC22806vr4.TEMPORARILY_UNMETERED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC8743Xd1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(C20348rr4 c20348rr4) {
        return !c20348rr4.a() || c20348rr4.b();
    }
}
