package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.contact.data.ContactItem;

/* renamed from: ir.nasim.xY, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23799xY extends i.f {
    public static final C23799xY a = new C23799xY();

    private C23799xY() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ContactItem.BaleContactItem baleContactItem, ContactItem.BaleContactItem baleContactItem2) {
        AbstractC13042fc3.i(baleContactItem, "oldItem");
        AbstractC13042fc3.i(baleContactItem2, "newItem");
        return AbstractC13042fc3.d(baleContactItem, baleContactItem2);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(ContactItem.BaleContactItem baleContactItem, ContactItem.BaleContactItem baleContactItem2) {
        AbstractC13042fc3.i(baleContactItem, "oldItem");
        AbstractC13042fc3.i(baleContactItem2, "newItem");
        return baleContactItem.getId() == baleContactItem2.getId();
    }
}
