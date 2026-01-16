package ir.nasim;

import ir.nasim.C22023uY;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.ah1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9864ah1 implements InterfaceC20468s37 {
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object a(C3512Be1 c3512Be1, InterfaceC20295rm1 interfaceC20295rm1) {
        int iR = c3512Be1.r();
        String name = c3512Be1.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        boolean zS = c3512Be1.s();
        Avatar avatarQ = c3512Be1.q();
        return new C22023uY(iR, name, avatarQ != null ? new C22023uY.a.C1635a(avatarQ) : null, zS, null, 16, null);
    }
}
