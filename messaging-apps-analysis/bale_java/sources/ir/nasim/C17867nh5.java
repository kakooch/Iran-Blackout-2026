package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Rect;
import android.text.Spannable;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.C20882sl7;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.N15;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.nh5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17867nh5 extends C20882sl7 {
    public static final b B = new b(null);
    public static final int D = 8;
    private final GestureDetector A;
    private final ConstraintLayout r;
    private final C13099ff3 s;
    private String t;
    private boolean u;
    private C13121fh5 v;
    private final Map w;
    private final Map x;
    private C17476n18 y;
    private int z;

    /* renamed from: ir.nasim.nh5$a */
    public static final class a extends RecyclerView.o {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
            AbstractC13042fc3.i(rect, "outRect");
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(recyclerView, "parent");
            AbstractC13042fc3.i(zVar, "state");
            if (recyclerView.getChildAdapterPosition(view) != 0) {
                if (JF5.g()) {
                    rect.set(0, 0, -C22078ud6.a(8.0f), 0);
                } else {
                    rect.set(-C22078ud6.a(8.0f), 0, 0, 0);
                }
            }
        }
    }

    /* renamed from: ir.nasim.nh5$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.nh5$c */
    public static final class c extends C20882sl7.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C17867nh5(c15481jf3, z, c(), null);
        }
    }

    public /* synthetic */ C17867nh5(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c15481jf3, z, abstractC23538x54);
    }

    private final void f1(final C13121fh5 c13121fh5, final long j) {
        C16885m18 c16885m18C;
        C13099ff3 c13099ff3 = this.s;
        Spannable spannableF = AbstractC5730Kp.f(c13121fh5.e(), null, null, null);
        c13099ff3.e.setMovementMethod(y0());
        c13099ff3.e.setText(spannableF);
        C16885m18 c16885m18C2 = c13121fh5.c();
        List listQ = c16885m18C2 != null ? c16885m18C2.q() : null;
        this.u = listQ == null || listQ.isEmpty() || !((c16885m18C = c13121fh5.c()) == null || c16885m18C.y());
        EnumC9058Yh5 enumC9058Yh5D = c13121fh5.d();
        boolean zG = c13121fh5.g();
        C16885m18 c16885m18C3 = c13121fh5.c();
        boolean zY = c16885m18C3 != null ? c16885m18C3.y() : false;
        C16885m18 c16885m18C4 = c13121fh5.c();
        String strJ1 = j1(enumC9058Yh5D, zG, zY, c16885m18C4 != null ? c16885m18C4.w() : 0);
        this.t = strJ1;
        c13099ff3.f.setText(strJ1);
        boolean z = this.u;
        C16885m18 c16885m18C5 = c13121fh5.c();
        v1(c13121fh5, z, c16885m18C5 != null ? c16885m18C5.y() : false);
        u1(c13121fh5.c());
        LinearLayout linearLayout = c13099ff3.b;
        AbstractC13042fc3.h(linearLayout, "answersLayout");
        o1(linearLayout, c13121fh5, j);
        C16885m18 c16885m18C6 = c13121fh5.c();
        if (c16885m18C6 != null) {
            s1(c16885m18C6);
        }
        i1();
        C16885m18 c16885m18C7 = c13121fh5.c();
        this.z = c16885m18C7 != null ? c16885m18C7.w() : 0;
        this.s.f.setTextColor(AbstractC4043Dl1.c(x0().getRoot().getContext(), J0() ? TA5.bubble_in_secondary_light : TA5.bubble_out_secondary_light));
        c13099ff3.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kh5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17867nh5.g1(this.a, c13121fh5, view);
            }
        });
        c13099ff3.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lh5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17867nh5.h1(this.a, c13121fh5, j, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(C17867nh5 c17867nh5, C13121fh5 c13121fh5, View view) {
        AbstractC13042fc3.i(c17867nh5, "this$0");
        AbstractC13042fc3.i(c13121fh5, "$poll");
        c17867nh5.z0().g().b(c13121fh5.b(), c13121fh5.e(), c13121fh5.a(), c17867nh5.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(C17867nh5 c17867nh5, C13121fh5 c13121fh5, long j, View view) {
        AbstractC13042fc3.i(c17867nh5, "this$0");
        AbstractC13042fc3.i(c13121fh5, "$poll");
        c17867nh5.z0().g().a(c13121fh5.b(), AbstractC15401jX0.m1(c17867nh5.w.values()), j);
    }

    private final void i1() {
        List listF;
        C13121fh5 c13121fh5 = this.v;
        C13121fh5 c13121fh52 = null;
        if (c13121fh5 == null) {
            AbstractC13042fc3.y("poll");
            c13121fh5 = null;
        }
        if (c13121fh5.g()) {
            listF = AbstractC10360bX0.m();
        } else {
            C13121fh5 c13121fh53 = this.v;
            if (c13121fh53 == null) {
                AbstractC13042fc3.y("poll");
            } else {
                c13121fh52 = c13121fh53;
            }
            listF = c13121fh52.f();
        }
        if (listF != null && listF.isEmpty()) {
            m1();
            return;
        }
        this.s.g.setVisibility(0);
        if (listF != null) {
            this.y.C(AbstractC15401jX0.f1(listF, 3));
        }
    }

    private final String j1(EnumC9058Yh5 enumC9058Yh5, boolean z, boolean z2, int i) {
        String str;
        Context context = this.s.getRoot().getContext();
        if (z2) {
            String string = context.getString(AbstractC12217eE5.final_result_of_the_poll);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        String string2 = z ? context.getString(AbstractC12217eE5.unknown_poll) : context.getString(AbstractC12217eE5.poll);
        AbstractC13042fc3.f(string2);
        if (i > 0) {
            str = Separators.LPAREN + AbstractC12152e76.c(String.valueOf(i)) + Separators.SP + context.getString(AbstractC12217eE5.poll_vote) + Separators.RPAREN;
        } else {
            str = "";
        }
        if (enumC9058Yh5 != EnumC9058Yh5.a) {
            return string2 + Separators.SP + str;
        }
        return string2 + "  " + str + Separators.SP + context.getString(AbstractC12217eE5.you_can_choose_multiple_choice);
    }

    private final int k1(int i, int i2) {
        if (i2 > 0) {
            return AbstractC20723sV3.c((i * 100.0d) / i2);
        }
        return 0;
    }

    private final void l1(C13121fh5 c13121fh5, long j, int i, int i2) {
        if (this.u) {
            if (c13121fh5.d() == EnumC9058Yh5.a) {
                t1(i);
            } else {
                z0().g().a(c13121fh5.b(), AbstractC9766aX0.e(Integer.valueOf(i2)), j);
            }
        }
    }

    private final void m1() {
        this.s.g.setVisibility(8);
    }

    private final int n1(int i) {
        return (i - x0().getRoot().getPaddingLeft()) - x0().getRoot().getPaddingRight();
    }

    private final void o1(LinearLayout linearLayout, final C13121fh5 c13121fh5, final long j) {
        this.s.b.removeAllViews();
        int i = 0;
        for (Object obj : c13121fh5.a()) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            Context context = linearLayout.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            final int i3 = i;
            this.x.put(Integer.valueOf(i), new C14303hh5(context, linearLayout, i, (String) obj, J0(), y0(), new UA2() { // from class: ir.nasim.mh5
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C17867nh5.p1(this.a, c13121fh5, j, i3, ((Integer) obj2).intValue());
                }
            }));
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p1(C17867nh5 c17867nh5, C13121fh5 c13121fh5, long j, int i, int i2) {
        AbstractC13042fc3.i(c17867nh5, "this$0");
        AbstractC13042fc3.i(c13121fh5, "$poll");
        c17867nh5.l1(c13121fh5, j, i, i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q1(C17867nh5 c17867nh5, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c17867nh5, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c17867nh5.s.d.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r1(C17867nh5 c17867nh5, C8967Xz7 c8967Xz7, Map.Entry entry, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c17867nh5, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(entry, "$it");
        AbstractC13042fc3.i(view, "<unused var>");
        C13121fh5 c13121fh5 = c17867nh5.v;
        if (c13121fh5 == null) {
            AbstractC13042fc3.y("poll");
            c13121fh5 = null;
        }
        c17867nh5.l1(c13121fh5, c8967Xz7.h().i(), ((Number) entry.getKey()).intValue(), ((Number) entry.getKey()).intValue());
        return true;
    }

    private final void s1(C16885m18 c16885m18) {
        Object next;
        C13121fh5 c13121fh5 = this.v;
        C13121fh5 c13121fh52 = null;
        if (c13121fh5 == null) {
            AbstractC13042fc3.y("poll");
            c13121fh5 = null;
        }
        v1(c13121fh5, c16885m18.q().isEmpty(), c16885m18.y());
        u1(c16885m18);
        Iterator it = c16885m18.r().iterator();
        while (it.hasNext()) {
            ((C4011Dh5) it.next()).r();
        }
        List listQ = c16885m18.q();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listQ, 10));
        Iterator it2 = listQ.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf((int) ((Number) it2.next()).longValue()));
        }
        for (Map.Entry entry : this.x.entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            C14303hh5 c14303hh5 = (C14303hh5) entry.getValue();
            boolean zContains = arrayList.contains(Integer.valueOf(iIntValue));
            if (!c16885m18.q().isEmpty()) {
                C13121fh5 c13121fh53 = this.v;
                if (c13121fh53 == null) {
                    AbstractC13042fc3.y("poll");
                    c13121fh53 = null;
                }
                c14303hh5.h(zContains, c13121fh53.d(), J0());
            } else {
                c14303hh5.e(J0());
            }
            Iterator it3 = c16885m18.r().iterator();
            while (true) {
                if (it3.hasNext()) {
                    next = it3.next();
                    if (((C4011Dh5) next).q() == iIntValue) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            C4011Dh5 c4011Dh5 = (C4011Dh5) next;
            boolean z = false;
            int iR = c4011Dh5 != null ? c4011Dh5.r() : 0;
            c14303hh5.c(k1(iR, c16885m18.w()), (c16885m18.q().isEmpty() ^ true) || c16885m18.y(), iR);
            if (c16885m18.q().isEmpty() && !c16885m18.y()) {
                z = true;
            }
            c14303hh5.k(z);
            c14303hh5.j(zContains, k1(iR, c16885m18.w()), !c16885m18.q().isEmpty());
        }
        if (c16885m18.y()) {
            return;
        }
        C13121fh5 c13121fh54 = this.v;
        if (c13121fh54 == null) {
            AbstractC13042fc3.y("poll");
            c13121fh54 = null;
        }
        EnumC9058Yh5 enumC9058Yh5D = c13121fh54.d();
        C13121fh5 c13121fh55 = this.v;
        if (c13121fh55 == null) {
            AbstractC13042fc3.y("poll");
        } else {
            c13121fh52 = c13121fh55;
        }
        j1(enumC9058Yh5D, c13121fh52.g(), c16885m18.y(), c16885m18.w());
    }

    private final void t1(int i) {
        C14303hh5 c14303hh5 = (C14303hh5) this.x.get(Integer.valueOf(i));
        if (c14303hh5 == null) {
            return;
        }
        if (this.w.remove(c14303hh5) == null) {
            this.w.put(c14303hh5, Integer.valueOf(i));
        }
        c14303hh5.f(this.w.containsKey(c14303hh5), J0());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void u1(ir.nasim.C16885m18 r5) {
        /*
            r4 = this;
            ir.nasim.ff3 r0 = r4.s
            ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView r0 = r0.d
            java.lang.String r1 = "seeResultsTextView"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            r1 = 0
            if (r5 == 0) goto L31
            java.util.List r2 = r5.q()
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 != 0) goto L20
            boolean r5 = r5.y()
            if (r5 == 0) goto L31
        L20:
            ir.nasim.fh5 r5 = r4.v
            if (r5 != 0) goto L2a
            java.lang.String r5 = "poll"
            ir.nasim.AbstractC13042fc3.y(r5)
            r5 = 0
        L2a:
            boolean r5 = r5.g()
            if (r5 != 0) goto L31
            goto L32
        L31:
            r3 = r1
        L32:
            if (r3 == 0) goto L35
            goto L37
        L35:
            r1 = 8
        L37:
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17867nh5.u1(ir.nasim.m18):void");
    }

    private final void v1(C13121fh5 c13121fh5, boolean z, boolean z2) {
        MaterialButton materialButton = this.s.c;
        AbstractC13042fc3.h(materialButton, "btnSubmit");
        materialButton.setVisibility(c13121fh5.d() == EnumC9058Yh5.a && z && !z2 ? 0 : 8);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void a() {
        super.a();
        m1();
        Iterator it = this.x.values().iterator();
        while (it.hasNext()) {
            ((C14303hh5) it.next()).i();
        }
        this.x.clear();
        this.w.clear();
        this.s.c.setOnClickListener(null);
        this.s.d.setOnClickListener(null);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.poll.Poll");
        this.v = (C13121fh5) objF;
        ConstraintLayout root = this.s.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = n1(((Number) xv4.e()).intValue());
        root.setLayoutParams(layoutParams2);
        C13121fh5 c13121fh5 = this.v;
        if (c13121fh5 == null) {
            AbstractC13042fc3.y("poll");
            c13121fh5 = null;
        }
        f1(c13121fh5, c8967Xz7.h().i());
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(View view, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC12990fW7.c(this.s.d, x0().getRoot().getContext().getString(AbstractC12217eE5.see_results), new InterfaceC10698c3() { // from class: ir.nasim.ih5
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C17867nh5.q1(this.a, view2, aVar);
            }
        });
        for (final Map.Entry entry : this.x.entrySet()) {
            AbstractC12990fW7.c(view, ((C14303hh5) entry.getValue()).d(), new InterfaceC10698c3() { // from class: ir.nasim.jh5
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C17867nh5.r1(this.a, c8967Xz7, entry, view2, aVar);
                }
            });
        }
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        boolean z = false;
        C13121fh5 c13121fh5 = null;
        if (!(n15 instanceof N15.o)) {
            if (!(n15 instanceof N15.q)) {
                super.z(n15);
                return;
            }
            C13121fh5 c13121fh52 = this.v;
            if (c13121fh52 == null) {
                AbstractC13042fc3.y("poll");
            } else {
                c13121fh5 = c13121fh52;
            }
            if (!c13121fh5.g()) {
                N15.q qVar = (N15.q) n15;
                if (!qVar.b().isEmpty()) {
                    this.s.g.setVisibility(0);
                    this.y.C(AbstractC15401jX0.f1(qVar.b(), 3));
                    return;
                }
            }
            m1();
            return;
        }
        N15.o oVar = (N15.o) n15;
        s1(oVar.b());
        boolean zY = oVar.b().y();
        boolean z2 = !oVar.b().q().isEmpty();
        this.z = oVar.b().w();
        if (!zY && !z2) {
            z = true;
        }
        this.u = z;
        if (z) {
            this.w.clear();
        }
        Iterator it = this.x.values().iterator();
        while (it.hasNext()) {
            ((C14303hh5) it.next()).k(this.u);
        }
        MessageEmojiTextView messageEmojiTextView = this.s.f;
        C13121fh5 c13121fh53 = this.v;
        if (c13121fh53 == null) {
            AbstractC13042fc3.y("poll");
            c13121fh53 = null;
        }
        EnumC9058Yh5 enumC9058Yh5D = c13121fh53.d();
        C13121fh5 c13121fh54 = this.v;
        if (c13121fh54 == null) {
            AbstractC13042fc3.y("poll");
        } else {
            c13121fh5 = c13121fh54;
        }
        messageEmojiTextView.setText(j1(enumC9058Yh5D, c13121fh5.g(), oVar.b().y(), oVar.b().w()));
        i1();
    }

    private C17867nh5(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        ConstraintLayout root = c15481jf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        this.r = root;
        this.t = "";
        this.u = true;
        this.w = new LinkedHashMap();
        this.x = new LinkedHashMap();
        this.A = new GestureDetector(c15481jf3.getRoot().getContext(), A0());
        C13099ff3 c13099ff3A = C13099ff3.a(R0(AbstractC12208eD5.item_chat_poll_bubble));
        c13099ff3A.f.setTypeface(C6011Lu2.k());
        c13099ff3A.c.setTypeface(C6011Lu2.k());
        c13099ff3A.e.setTypeface(C6011Lu2.i());
        c13099ff3A.g.setLayoutManager(new LinearLayoutManager(c13099ff3A.getRoot().getContext(), 0, false));
        C17476n18 c17476n18 = new C17476n18(48, null, 2, null);
        this.y = c17476n18;
        c13099ff3A.g.setAdapter(c17476n18);
        c13099ff3A.g.addItemDecoration(new a());
        this.s = c13099ff3A;
    }
}
