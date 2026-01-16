package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.j44, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15138j44 extends DY2 {
    private final int c;
    private final boolean d;
    private List e;
    private String f;
    private final int g;
    private HV1 h;

    /* renamed from: ir.nasim.j44$a */
    private final class a extends DW7 {
        private TextView b;
        private TextView c;
        private AvatarViewGlide d;

        public a() {
        }

        @Override // ir.nasim.DW7
        public void d(boolean z) {
            AvatarViewGlide avatarViewGlide;
            if (!z || (avatarViewGlide = this.d) == null) {
                return;
            }
            avatarViewGlide.D();
        }

        @Override // ir.nasim.DW7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(Y34 y34, int i, Context context) {
            AvatarViewGlide avatarViewGlide;
            AbstractC13042fc3.i(y34, "data");
            AbstractC13042fc3.i(context, "context");
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(y34.e());
            if (c21231tK7 != null && (avatarViewGlide = this.d) != null) {
                AvatarViewGlide.u(avatarViewGlide, c21231tK7, null, 2, null);
            }
            CharSequence charSequenceB = y34.b();
            if (charSequenceB != null && charSequenceB.length() != 0 && y34.a() != null) {
                String string = charSequenceB.toString();
                List listA = y34.a();
                AbstractC13042fc3.h(listA, "getMentionMatches(...)");
                charSequenceB = C18449og6.b(string, listA, C15138j44.this.g);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(charSequenceB);
            }
            CharSequence charSequenceD = y34.d();
            if (charSequenceD != null && charSequenceD.length() != 0 && y34.c() != null) {
                String string2 = charSequenceD.toString();
                List listC = y34.c();
                AbstractC13042fc3.h(listC, "getOriginalMatches(...)");
                charSequenceD = C18449og6.b(string2, listC, C15138j44.this.g);
            }
            TextView textView2 = this.c;
            if (textView2 != null) {
                textView2.setText(charSequenceD);
            }
        }

        @Override // ir.nasim.DW7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public View c(Y34 y34, ViewGroup viewGroup, Context context) {
            AbstractC13042fc3.i(y34, "data");
            AbstractC13042fc3.i(context, "context");
            View viewInflate = ((Activity) context).getLayoutInflater().inflate(AbstractC12208eD5.fragment_chat_mention_item, viewGroup, false);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            viewInflate.setBackgroundColor(c5495Jo7.f0());
            viewInflate.findViewById(BC5.container).setBackgroundResource(KB5.selector);
            viewInflate.findViewById(BC5.divider).setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
            TextView textView = (TextView) viewInflate.findViewById(BC5.name);
            this.b = textView;
            if (textView != null) {
                textView.setTextColor(c5495Jo7.g0());
            }
            TextView textView2 = (TextView) viewInflate.findViewById(BC5.mentionHint);
            this.c = textView2;
            if (textView2 != null) {
                textView2.setTextColor(c5495Jo7.y0(c5495Jo7.g0(), 48));
            }
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) viewInflate.findViewById(BC5.avatar);
            this.d = avatarViewGlide;
            if (avatarViewGlide != null) {
                avatarViewGlide.B(16.0f, true);
            }
            AbstractC13042fc3.f(viewInflate);
            return viewInflate;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15138j44(int i, Context context, boolean z) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.c = i;
        this.d = z;
        this.e = new ArrayList();
        this.g = C5495Jo7.a.t2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(C15138j44 c15138j44, Runnable runnable, List list) {
        AbstractC13042fc3.i(c15138j44, "this$0");
        AbstractC13042fc3.i(runnable, "$callback");
        AbstractC13042fc3.i(list, "it");
        if (c15138j44.f == null) {
            return C19938rB7.a;
        }
        c15138j44.e = list;
        c15138j44.notifyDataSetChanged();
        runnable.run();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n(C15138j44 c15138j44, String str) {
        AbstractC13042fc3.i(c15138j44, "this$0");
        return AbstractC5969Lp4.d().H(c15138j44.c, str, Boolean.valueOf(c15138j44.d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(C15138j44 c15138j44, Runnable runnable, List list) {
        AbstractC13042fc3.i(c15138j44, "this$0");
        AbstractC13042fc3.i(runnable, "$callback");
        AbstractC13042fc3.i(list, "members");
        if (c15138j44.f == null) {
            return;
        }
        c15138j44.e = list;
        c15138j44.notifyDataSetChanged();
        runnable.run();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return ((Y34) this.e.get(i)).e();
    }

    public final void i() {
        this.f = null;
        this.e = new ArrayList();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.DY2
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public DW7 a(Y34 y34) {
        AbstractC13042fc3.i(y34, "obj");
        return new a();
    }

    @Override // ir.nasim.DY2, android.widget.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Y34 getItem(int i) {
        return (Y34) this.e.get(i);
    }

    public final void l(final String str, final Runnable runnable) {
        AbstractC13042fc3.i(runnable, "callback");
        if (str == null || AbstractC13042fc3.d(str, this.f)) {
            return;
        }
        HV1 hv1 = this.h;
        if (hv1 != null) {
            hv1.dispose();
        }
        this.f = str;
        if (C8386Vt0.a.F8()) {
            AbstractC5969Lp4.d().o2().E().G2(this.c, str, this.d, new UA2() { // from class: ir.nasim.g44
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C15138j44.m(this.a, runnable, (List) obj);
                }
            });
            return;
        }
        C9248Zc6 c9248Zc6G = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.h44
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return C15138j44.n(this.a, str);
            }
        }).h(EnumC11723dV1.IO).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.i44
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                C15138j44.o(this.a, runnable, (List) obj);
            }
        });
        AbstractC13042fc3.h(c9248Zc6G, "onSuccess(...)");
        this.h = SZ.e(c9248Zc6G);
    }
}
