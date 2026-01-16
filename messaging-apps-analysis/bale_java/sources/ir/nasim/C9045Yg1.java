package ir.nasim;

import ir.nasim.contact.data.ContactItem;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Yg1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9045Yg1 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ContactItem.BaleContactItem a(C3512Be1 c3512Be1) {
        AbstractC13042fc3.i(c3512Be1, "input");
        int iR = c3512Be1.r();
        String name = c3512Be1.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        boolean zS = c3512Be1.s();
        Avatar avatarQ = c3512Be1.q();
        return new ContactItem.BaleContactItem(iR, name, avatarQ != null ? new ContactItem.BaleContactItem.b.a(avatarQ) : null, zS);
    }
}
