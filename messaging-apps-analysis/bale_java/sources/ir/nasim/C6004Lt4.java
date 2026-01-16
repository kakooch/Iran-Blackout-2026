package ir.nasim;

import ai.bale.proto.GiftpacketStruct$GiftReceiver;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.List;

/* renamed from: ir.nasim.Lt4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6004Lt4 extends RecyclerView.h {
    private List d;
    private Context e;
    private ExPeerType f;
    private final boolean g;
    private final boolean h;

    /* renamed from: ir.nasim.Lt4$a */
    public static final class a extends RecyclerView.C {
        private final TextView u;
        private final TextView v;
        private final TextView w;
        private final AvatarViewGlide x;
        private final ImageView y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            AbstractC13042fc3.i(view, "itemView");
            View viewFindViewById = view.findViewById(BC5.gift_packet_result_list_item_amount);
            AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
            this.u = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(BC5.gift_packet_result_list_item_name);
            AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
            this.v = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(BC5.gift_packet_result_list_item_date);
            AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
            this.w = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(BC5.gift_packet_result_list_item_avatar);
            AbstractC13042fc3.h(viewFindViewById4, "findViewById(...)");
            this.x = (AvatarViewGlide) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(BC5.gift_packet_result_list_item_lucky_badge);
            AbstractC13042fc3.h(viewFindViewById5, "findViewById(...)");
            this.y = (ImageView) viewFindViewById5;
        }

        public final AvatarViewGlide C0() {
            return this.x;
        }

        public final ImageView D0() {
            return this.y;
        }

        public final TextView E0() {
            return this.u;
        }

        public final TextView F0() {
            return this.w;
        }

        public final TextView H0() {
            return this.v;
        }
    }

    public /* synthetic */ C6004Lt4(List list, Context context, ExPeerType exPeerType, boolean z, boolean z2, int i, ED1 ed1) {
        this(list, context, exPeerType, z, (i & 16) != 0 ? false : z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(C6004Lt4 c6004Lt4, View view) {
        AbstractC13042fc3.i(c6004Lt4, "this$0");
        AbstractC23658xI2.k(c6004Lt4.e, c6004Lt4.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) throws Resources.NotFoundException {
        String str;
        AbstractC13042fc3.i(aVar, "holder");
        if (this.h) {
            long amount = ((GiftpacketStruct$GiftReceiver) this.d.get(i)).getAmount();
            TextView textViewE0 = aVar.E0();
            if (amount >= 1000) {
                str = XY6.v(String.valueOf(amount / 1000.0d)) + Separators.SP + this.e.getString(AbstractC12217eE5.wallet_gold);
            } else {
                str = XY6.d(String.valueOf(amount)) + Separators.SP + this.e.getString(AbstractC12217eE5.wallet_gold_mill);
            }
            textViewE0.setText(str);
        } else {
            aVar.E0().setText(XY6.e(XY6.c(String.valueOf(((GiftpacketStruct$GiftReceiver) this.d.get(i)).getAmount()), (char) 0, 2, null)) + this.e.getResources().getString(AbstractC12217eE5.rail_with_before_space));
        }
        aVar.E0().setTypeface(C6011Lu2.i());
        aVar.C0().B(22.0f, true);
        VL3 vl3K0 = AbstractC5969Lp4.d().k0();
        C21231tK7 c21231tK7 = vl3K0 != null ? (C21231tK7) vl3K0.n(((GiftpacketStruct$GiftReceiver) this.d.get(i)).getUserId()) : null;
        if (c21231tK7 != null) {
            aVar.H0().setText((CharSequence) c21231tK7.r().b());
            AvatarViewGlide.u(aVar.C0(), c21231tK7, null, 2, null);
        } else {
            aVar.H0().setText(this.e.getResources().getString(AbstractC12217eE5.gift_packet_anonymous_name));
        }
        aVar.H0().setTypeface(C6011Lu2.k());
        if (i != 0 || this.d.size() <= 0 || this.f == ExPeerType.PRIVATE || !this.g) {
            aVar.D0().setVisibility(8);
        } else {
            aVar.D0().setVisibility(0);
        }
        aVar.D0().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Kt4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C6004Lt4.B(this.a, view);
            }
        });
        CharSequence charSequence = DateFormat.format("HH:mm", ((GiftpacketStruct$GiftReceiver) this.d.get(i)).getDate());
        String str2 = ((Object) charSequence) + " - " + C14593iA1.h(this.e, ((GiftpacketStruct$GiftReceiver) this.d.get(i)).getDate(), false, 4, null);
        aVar.F0().setTypeface(C6011Lu2.k());
        aVar.F0().setText(str2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.new_gift_packet_result_list_item, viewGroup, false);
        AbstractC13042fc3.f(viewInflate);
        return new a(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    public C6004Lt4(List list, Context context, ExPeerType exPeerType, boolean z, boolean z2) {
        AbstractC13042fc3.i(list, "list");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.d = list;
        this.e = context;
        this.f = exPeerType;
        this.g = z;
        this.h = z2;
    }
}
