package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.jr4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C15602jr4 extends AbstractC8743Xd1 {
    private static final String e = HI3.f("NetworkNotRoamingCtrlr");

    public C15602jr4(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        super(C7686St7.c(context, interfaceC5684Kj7).d());
    }

    @Override // ir.nasim.AbstractC8743Xd1
    boolean b(C17810nb8 c17810nb8) {
        return c17810nb8.j.b() == EnumC22806vr4.NOT_ROAMING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC8743Xd1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(C20348rr4 c20348rr4) {
        return (c20348rr4.a() && c20348rr4.c()) ? false : true;
    }
}
