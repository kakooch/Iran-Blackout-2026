package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.yM2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24284yM2 implements InterfaceC20468s37 {
    private final Context a;
    private final int b;

    public C24284yM2(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object a(C23104wM2 c23104wM2, InterfaceC20295rm1 interfaceC20295rm1) {
        C21231tK7 c21231tK7G = c23104wM2.g();
        Object objB = c21231tK7G.r().b();
        AbstractC13042fc3.h(objB, "get(...)");
        String str = (String) objB;
        int iO = c21231tK7G.o();
        int iF = c23104wM2.f();
        Avatar avatar = (Avatar) c21231tK7G.h().b();
        boolean zJ = c23104wM2.j();
        boolean z = c21231tK7G.o() == this.b;
        int iB = c23104wM2.b();
        long jA = c23104wM2.a();
        Integer numE = c23104wM2.e();
        int iIntValue = numE != null ? numE.intValue() : 0;
        boolean zY = c21231tK7G.y();
        C24119y45 c24119y45C = c23104wM2.c();
        return new Q14(str, iF, iO, avatar, zJ, z, iB, jA, iIntValue, zY, c24119y45C != null ? AbstractC6392Nk0.a(c24119y45C.n()) : null, c23104wM2.d());
    }
}
