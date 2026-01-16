package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.features.mxp.entity.PuppetUser;

/* renamed from: ir.nasim.bo4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10557bo4 extends i.f {
    public static final C10557bo4 a = new C10557bo4();

    private C10557bo4() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ContactItem.MxpPuppetContactItem mxpPuppetContactItem, ContactItem.MxpPuppetContactItem mxpPuppetContactItem2) {
        AbstractC13042fc3.i(mxpPuppetContactItem, "oldItem");
        AbstractC13042fc3.i(mxpPuppetContactItem2, "newItem");
        return AbstractC13042fc3.d(mxpPuppetContactItem, mxpPuppetContactItem2);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(ContactItem.MxpPuppetContactItem mxpPuppetContactItem, ContactItem.MxpPuppetContactItem mxpPuppetContactItem2) {
        AbstractC13042fc3.i(mxpPuppetContactItem, "oldItem");
        AbstractC13042fc3.i(mxpPuppetContactItem2, "newItem");
        PuppetUser puppetUser = (PuppetUser) AbstractC15401jX0.s0(mxpPuppetContactItem.getPuppets());
        Integer numValueOf = puppetUser != null ? Integer.valueOf(puppetUser.getUserId()) : null;
        PuppetUser puppetUser2 = (PuppetUser) AbstractC15401jX0.s0(mxpPuppetContactItem2.getPuppets());
        return AbstractC13042fc3.d(numValueOf, puppetUser2 != null ? Integer.valueOf(puppetUser2.getUserId()) : null);
    }
}
