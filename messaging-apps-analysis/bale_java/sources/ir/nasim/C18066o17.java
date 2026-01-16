package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.o17, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18066o17 extends RecyclerView.C {
    public static final a v = new a(null);
    public static final int w = 8;
    private final C18657p17 u;

    /* renamed from: ir.nasim.o17$a */
    public static final class a {
        private a() {
        }

        public final C18066o17 a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C18657p17 c18657p17C = C18657p17.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c18657p17C, "inflate(...)");
            return new C18066o17(c18657p17C);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18066o17(C18657p17 c18657p17) {
        super(c18657p17.getRoot());
        AbstractC13042fc3.i(c18657p17, "binding");
        this.u = c18657p17;
    }

    public final void C0(C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c17637nI7, "user");
        this.u.b.B(22.0f, true);
        AvatarViewGlide.v(this.u.b, c17637nI7.S(), c17637nI7.getName(), c17637nI7.n0(), c17637nI7.r0(), null, 16, null);
        if (c17637nI7.n0() == AbstractC5969Lp4.f()) {
            this.u.c.setImageResource(AbstractC18163oB5.ic_up_voted);
            this.u.d.setText(this.a.getContext().getText(ID5.feed_suggesters_you));
        } else {
            this.u.c.setImageResource(AbstractC18163oB5.ic_up_vote);
            this.u.d.setText(c17637nI7.getName());
        }
    }

    public final void a() {
        this.u.b.D();
    }
}
