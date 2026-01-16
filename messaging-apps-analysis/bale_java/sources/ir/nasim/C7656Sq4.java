package ir.nasim;

import android.content.Context;
import android.os.Build;

/* renamed from: ir.nasim.Sq4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C7656Sq4 extends AbstractC8743Xd1 {
    public C7656Sq4(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        super(C7686St7.c(context, interfaceC5684Kj7).d());
    }

    @Override // ir.nasim.AbstractC8743Xd1
    boolean b(C17810nb8 c17810nb8) {
        return c17810nb8.j.b() == EnumC22806vr4.CONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC8743Xd1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(C20348rr4 c20348rr4) {
        return Build.VERSION.SDK_INT >= 26 ? (c20348rr4.a() && c20348rr4.d()) ? false : true : !c20348rr4.a();
    }
}
