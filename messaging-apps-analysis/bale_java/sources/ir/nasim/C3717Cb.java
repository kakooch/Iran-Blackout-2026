package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: ir.nasim.Cb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3717Cb extends DY2 {
    private final String c;
    private final C23104wM2[] d;
    private final C14733iO2 e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.Cb$a */
    class a extends DW7 {
        private TextView b;
        private TextView c;
        private AvatarViewGlide d;
        private ImageView e;
        private C21231tK7 f;
        private C14733iO2 g;

        private void h(Context context) {
            C6214Mq7 c6214Mq7 = new C6214Mq7(context.getResources().getDrawable(KB5.ba_chat_bot_item_icon), C5495Jo7.a.g1());
            if (JF5.g()) {
                this.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, c6214Mq7, (Drawable) null);
            } else {
                this.b.setCompoundDrawablesWithIntrinsicBounds(c6214Mq7, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object i(C23104wM2 c23104wM2, Context context) {
            if (c23104wM2.e() == null) {
                return C19938rB7.a;
            }
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c23104wM2.e().intValue());
            if (c21231tK7 == null) {
                return C19938rB7.a;
            }
            this.c.setText(context.getString(AbstractC12217eE5.group_admin_adder, c21231tK7.r().b()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.DW7
        public void d(boolean z) {
            if (z) {
                this.d.D();
            }
        }

        @Override // ir.nasim.DW7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(final C23104wM2 c23104wM2, int i, final Context context) {
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c23104wM2.f());
            this.f = c21231tK7;
            if (c21231tK7 == null || this.g == null) {
                return;
            }
            try {
                if (c21231tK7.y()) {
                    h(context);
                }
                this.d.r(this.f);
                this.b.setText((CharSequence) this.f.r().b());
            } catch (Exception e) {
                C19406qI3.d("AdminsAdapter", e);
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
            if (this.g.x() == this.f.o()) {
                this.c.setTextColor(C5495Jo7.a.T());
                if (this.g.q() == ZN2.CHANNEL) {
                    this.c.setText(AbstractC12217eE5.channel_owner);
                } else {
                    this.c.setText(AbstractC12217eE5.group_owner);
                }
            } else {
                this.c.setTextColor(C5495Jo7.a.o0());
                this.c.setText("");
                GM2.d(this.g, new SA2() { // from class: ir.nasim.Ab
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return this.a.i(c23104wM2, context);
                    }
                });
            }
            boolean z = AbstractC5969Lp4.f() == this.g.x();
            boolean z2 = C3717Cb.this.d[i].e() != null && C3717Cb.this.d[i].e().intValue() == AbstractC5969Lp4.f();
            if (z) {
                if (this.f.o() != AbstractC5969Lp4.f()) {
                    this.e.setVisibility(0);
                    return;
                } else {
                    this.e.setVisibility(8);
                    return;
                }
            }
            if (this.f.o() == AbstractC5969Lp4.f()) {
                this.e.setVisibility(0);
            } else if (!z2 || this.f.o() == this.g.x()) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
        }

        @Override // ir.nasim.DW7
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public View c(C23104wM2 c23104wM2, ViewGroup viewGroup, Context context) {
            View viewInflate = ((Activity) context).getLayoutInflater().inflate(AbstractC12208eD5.fragment_admin_list_item, viewGroup, false);
            this.b = (TextView) viewInflate.findViewById(BC5.name);
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) viewInflate.findViewById(BC5.avatar);
            this.d = avatarViewGlide;
            avatarViewGlide.B(24.0f, true);
            this.c = (TextView) viewInflate.findViewById(BC5.description_ad);
            this.e = (ImageView) viewInflate.findViewById(BC5.menu_current_item);
            TextView textView = (TextView) viewInflate.findViewById(BC5.name);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(c5495Jo7.g0());
            viewInflate.findViewById(BC5.divider).setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
            viewInflate.setBackgroundDrawable(AbstractC4310Eo7.g());
            return viewInflate;
        }

        private a() {
            this.g = C3717Cb.this.e;
        }
    }

    public C3717Cb(Collection collection, Context context, C14733iO2 c14733iO2) {
        super(context);
        this.c = "AdminsAdapter";
        this.d = (C23104wM2[]) collection.toArray(new C23104wM2[0]);
        this.e = c14733iO2;
        C5735Kp4.w().i().d1(i());
    }

    private ArrayList i() {
        ArrayList arrayList = new ArrayList();
        for (C23104wM2 c23104wM2 : this.d) {
            arrayList.add(Integer.valueOf(c23104wM2.f()));
        }
        return arrayList;
    }

    @Override // ir.nasim.DY2
    public void b() {
        super.b();
        C5735Kp4.w().i().c1(i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.DY2
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public DW7 a(C23104wM2 c23104wM2) {
        return new a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.length;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.d[i].f();
    }

    @Override // ir.nasim.DY2, android.widget.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C23104wM2 getItem(int i) {
        return this.d[i];
    }
}
