package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.contact.data.ContactItem;

/* renamed from: ir.nasim.ff1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13097ff1 extends i.f {
    public static final C13097ff1 a = new C13097ff1();

    private C13097ff1() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ContactItem contactItem, ContactItem contactItem2) {
        AbstractC13042fc3.i(contactItem, "oldItem");
        AbstractC13042fc3.i(contactItem2, "newItem");
        if (contactItem.getClass() != contactItem2.getClass()) {
            return false;
        }
        if (contactItem instanceof ContactItem.BaleContactItem) {
            return C23799xY.a.a((ContactItem.BaleContactItem) contactItem, (ContactItem.BaleContactItem) contactItem2);
        }
        if (contactItem instanceof ContactItem.MxpPuppetContactItem) {
            return C10557bo4.a.a((ContactItem.MxpPuppetContactItem) contactItem, (ContactItem.MxpPuppetContactItem) contactItem2);
        }
        if (contactItem instanceof ContactItem.PhoneBookContactItem) {
            return N75.a.a((ContactItem.PhoneBookContactItem) contactItem, (ContactItem.PhoneBookContactItem) contactItem2);
        }
        if (contactItem instanceof ContactItem.SeparatorTitleItem) {
            return C13793gp6.a.a((ContactItem.SeparatorTitleItem) contactItem, (ContactItem.SeparatorTitleItem) contactItem2);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(ContactItem contactItem, ContactItem contactItem2) {
        AbstractC13042fc3.i(contactItem, "oldItem");
        AbstractC13042fc3.i(contactItem2, "newItem");
        if (contactItem.getClass() != contactItem2.getClass()) {
            return false;
        }
        if (contactItem instanceof ContactItem.BaleContactItem) {
            return C23799xY.a.b((ContactItem.BaleContactItem) contactItem, (ContactItem.BaleContactItem) contactItem2);
        }
        if (contactItem instanceof ContactItem.MxpPuppetContactItem) {
            return C10557bo4.a.b((ContactItem.MxpPuppetContactItem) contactItem, (ContactItem.MxpPuppetContactItem) contactItem2);
        }
        if (contactItem instanceof ContactItem.PhoneBookContactItem) {
            return N75.a.b((ContactItem.PhoneBookContactItem) contactItem, (ContactItem.PhoneBookContactItem) contactItem2);
        }
        if (contactItem instanceof ContactItem.SeparatorTitleItem) {
            return C13793gp6.a.b((ContactItem.SeparatorTitleItem) contactItem, (ContactItem.SeparatorTitleItem) contactItem2);
        }
        return true;
    }
}
