package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14374ho4;
import ir.nasim.features.mxp.entity.PuppetUser;
import java.util.List;

/* renamed from: ir.nasim.ho4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14374ho4 extends RecyclerView.h {
    private List d;
    private final UA2 e;

    /* renamed from: ir.nasim.ho4$a */
    public final class a extends RecyclerView.C {
        private final C9272Zf3 u;
        final /* synthetic */ C14374ho4 v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C14374ho4 c14374ho4, C9272Zf3 c9272Zf3) {
            super(c9272Zf3.getRoot());
            AbstractC13042fc3.i(c9272Zf3, "binding");
            this.v = c14374ho4;
            this.u = c9272Zf3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void E0(C14374ho4 c14374ho4, PuppetUser puppetUser, View view) {
            AbstractC13042fc3.i(c14374ho4, "this$0");
            AbstractC13042fc3.i(puppetUser, "$item");
            c14374ho4.e.invoke(puppetUser);
        }

        public final void D0(final PuppetUser puppetUser) {
            AbstractC13042fc3.i(puppetUser, "item");
            C9272Zf3 c9272Zf3 = this.u;
            final C14374ho4 c14374ho4 = this.v;
            c9272Zf3.d.setText(puppetUser.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_PUPPET_TYPE java.lang.String().q());
            c9272Zf3.b.setImageResource(puppetUser.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_PUPPET_TYPE java.lang.String().p());
            c9272Zf3.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.go4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C14374ho4.a.E0(c14374ho4, puppetUser, view);
                }
            });
        }
    }

    public C14374ho4(List list, UA2 ua2) {
        AbstractC13042fc3.i(list, "dataList");
        AbstractC13042fc3.i(ua2, "onSelect");
        this.d = list;
        this.e = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        AbstractC13042fc3.i(aVar, "holder");
        aVar.D0((PuppetUser) this.d.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C9272Zf3 c9272Zf3C = C9272Zf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c9272Zf3C, "inflate(...)");
        return new a(this, c9272Zf3C);
    }

    public final void C(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }
}
