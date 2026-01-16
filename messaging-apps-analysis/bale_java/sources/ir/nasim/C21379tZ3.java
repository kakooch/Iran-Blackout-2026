package ir.nasim;

import androidx.fragment.app.Fragment;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* renamed from: ir.nasim.tZ3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21379tZ3 extends AbstractC20423rz2 {
    private final C11458d25 l;
    private final ExPeerType m;
    private boolean n;
    private final boolean o;
    private List p;

    public /* synthetic */ C21379tZ3(Fragment fragment, C11458d25 c11458d25, ExPeerType exPeerType, boolean z, boolean z2, List list, int i, ED1 ed1) {
        this(fragment, c11458d25, exPeerType, z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? AbstractC10360bX0.m() : list);
    }

    @Override // ir.nasim.AbstractC20423rz2
    public Fragment B(int i) {
        if (this.o) {
            return i != 0 ? i != 1 ? C5151Ic5.INSTANCE.a() : RV7.INSTANCE.a(this.l, this.m) : C5151Ic5.INSTANCE.a();
        }
        int iIntValue = ((Number) this.p.get(i)).intValue();
        return iIntValue == RD5.media_picture ? C5151Ic5.INSTANCE.a() : iIntValue == RD5.media_video2 ? RV7.INSTANCE.a(this.l, this.m) : iIntValue == RD5.media_Document ? C8816Xl2.INSTANCE.a() : iIntValue == RD5.shared_media_audio ? FO.INSTANCE.a() : iIntValue == RD5.media_audio ? P08.INSTANCE.a() : iIntValue == RD5.group_members ? I24.INSTANCE.a() : iIntValue == RD5.mutual_group ? C3830Cn4.INSTANCE.a() : iIntValue == RD5.media_link ? C21137tA3.INSTANCE.a() : iIntValue == RD5.media_recommended_peer_bot ? C20008rJ5.INSTANCE.a() : C21137tA3.INSTANCE.a();
    }

    public final void T(boolean z) {
        if (this.n != z) {
            this.n = z;
            notifyDataSetChanged();
        }
    }

    public final void U(List list) {
        AbstractC13042fc3.i(list, "newTabs");
        this.p = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        if (this.o) {
            return 2;
        }
        return this.p.size();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C21379tZ3(Fragment fragment, C11458d25 c11458d25, ExPeerType exPeerType, boolean z, boolean z2, List list) {
        super(fragment);
        AbstractC13042fc3.i(fragment, "fr");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(list, "tabTypes");
        this.l = c11458d25;
        this.m = exPeerType;
        this.n = z;
        this.o = z2;
        this.p = list;
    }
}
