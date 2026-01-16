package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.contact.data.ContactItem;

/* renamed from: ir.nasim.gp6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13793gp6 extends i.f {
    public static final C13793gp6 a = new C13793gp6();

    private C13793gp6() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ContactItem.SeparatorTitleItem separatorTitleItem, ContactItem.SeparatorTitleItem separatorTitleItem2) {
        AbstractC13042fc3.i(separatorTitleItem, "oldItem");
        AbstractC13042fc3.i(separatorTitleItem2, "newItem");
        return AbstractC13042fc3.d(separatorTitleItem, separatorTitleItem2);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(ContactItem.SeparatorTitleItem separatorTitleItem, ContactItem.SeparatorTitleItem separatorTitleItem2) {
        AbstractC13042fc3.i(separatorTitleItem, "oldItem");
        AbstractC13042fc3.i(separatorTitleItem2, "newItem");
        return separatorTitleItem.getTextResourceId() == separatorTitleItem2.getTextResourceId();
    }
}
