package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.contact.data.ContactItem;

/* loaded from: classes4.dex */
public final class N75 extends i.f {
    public static final N75 a = new N75();

    private N75() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ContactItem.PhoneBookContactItem phoneBookContactItem, ContactItem.PhoneBookContactItem phoneBookContactItem2) {
        AbstractC13042fc3.i(phoneBookContactItem, "oldItem");
        AbstractC13042fc3.i(phoneBookContactItem2, "newItem");
        return AbstractC13042fc3.d(phoneBookContactItem, phoneBookContactItem2);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(ContactItem.PhoneBookContactItem phoneBookContactItem, ContactItem.PhoneBookContactItem phoneBookContactItem2) {
        AbstractC13042fc3.i(phoneBookContactItem, "oldItem");
        AbstractC13042fc3.i(phoneBookContactItem2, "newItem");
        return phoneBookContactItem.getId() == phoneBookContactItem2.getId();
    }
}
