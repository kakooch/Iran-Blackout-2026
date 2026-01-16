package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.KX0;

/* renamed from: ir.nasim.g02, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13305g02 extends AbstractC24968zW2 {
    public static final a o1 = new a(null);
    public static final int p1 = 8;
    private final InterfaceC15279jJ4 h1;
    private int i1;
    private b j1;
    private boolean k1;
    private EnumC4624Fx6 l1;
    private C17432mx2 m1;
    public C15753k68 n1;

    /* renamed from: ir.nasim.g02$a */
    public static final class a {
        private a() {
        }

        public final C13305g02 a(InterfaceC15279jJ4 interfaceC15279jJ4) {
            AbstractC13042fc3.i(interfaceC15279jJ4, "onFragmentCloseListener");
            return new C13305g02(interfaceC15279jJ4);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.g02$b */
    public interface b {
        void a(int i);

        void b(int i, int i2, EnumC4624Fx6 enumC4624Fx6);
    }

    /* renamed from: ir.nasim.g02$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4624Fx6.values().length];
            try {
                iArr[EnumC4624Fx6.BRUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC4624Fx6.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC4624Fx6.OVAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC4624Fx6.LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.g02$d */
    public static final class d implements KX0.b {
        d() {
        }

        @Override // ir.nasim.KX0.b
        public void a(int i) {
            b bVar;
            C13305g02.this.i1 = i;
            if (C13305g02.this.k1 || (bVar = C13305g02.this.j1) == null) {
                return;
            }
            C17432mx2 c17432mx2 = C13305g02.this.m1;
            if (c17432mx2 == null) {
                AbstractC13042fc3.y("binding");
                c17432mx2 = null;
            }
            bVar.b(c17432mx2.i.getProgress(), i, C13305g02.this.l1);
        }
    }

    public C13305g02(InterfaceC15279jJ4 interfaceC15279jJ4) {
        AbstractC13042fc3.i(interfaceC15279jJ4, "onFragmentCloseListener");
        this.h1 = interfaceC15279jJ4;
        this.l1 = EnumC4624Fx6.BRUSH;
    }

    private final void ea() {
        C17432mx2 c17432mx2 = this.m1;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        c17432mx2.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.c02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13305g02.fa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(C13305g02 c13305g02, View view) {
        AbstractC13042fc3.i(c13305g02, "this$0");
        c13305g02.k1 = false;
        c13305g02.l1 = EnumC4624Fx6.OVAL;
        b bVar = c13305g02.j1;
        if (bVar != null) {
            C17432mx2 c17432mx2 = c13305g02.m1;
            if (c17432mx2 == null) {
                AbstractC13042fc3.y("binding");
                c17432mx2 = null;
            }
            bVar.b(c17432mx2.i.getProgress(), c13305g02.i1, c13305g02.l1);
        }
        c13305g02.ua();
    }

    private final void ga() {
        C17432mx2 c17432mx2 = this.m1;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        RecyclerView recyclerView = c17432mx2.b;
        recyclerView.setLayoutManager(new LinearLayoutManager(A5(), 0, false));
        recyclerView.setHasFixedSize(true);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        KX0 kx0 = new KX0(contextS7, this.i1);
        kx0.E(new d());
        recyclerView.setAdapter(kx0);
    }

    private final void ha() {
        C17432mx2 c17432mx2 = this.m1;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        c17432mx2.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.d02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13305g02.ia(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(C13305g02 c13305g02, View view) {
        AbstractC13042fc3.i(c13305g02, "this$0");
        c13305g02.Q7().onBackPressed();
    }

    private final C19938rB7 ja() {
        C17432mx2 c17432mx2 = this.m1;
        C17432mx2 c17432mx22 = null;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        c17432mx2.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.b02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13305g02.ka(this.a, view);
            }
        });
        b bVar = this.j1;
        if (bVar == null) {
            return null;
        }
        C17432mx2 c17432mx23 = this.m1;
        if (c17432mx23 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c17432mx22 = c17432mx23;
        }
        bVar.b(c17432mx22.i.getProgress(), this.i1, EnumC4624Fx6.BRUSH);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ka(C13305g02 c13305g02, View view) {
        AbstractC13042fc3.i(c13305g02, "this$0");
        c13305g02.k1 = false;
        c13305g02.l1 = EnumC4624Fx6.BRUSH;
        b bVar = c13305g02.j1;
        if (bVar != null) {
            C17432mx2 c17432mx2 = c13305g02.m1;
            if (c17432mx2 == null) {
                AbstractC13042fc3.y("binding");
                c17432mx2 = null;
            }
            bVar.b(c17432mx2.i.getProgress(), c13305g02.i1, c13305g02.l1);
        }
        c13305g02.ua();
    }

    private final void la() {
        C17432mx2 c17432mx2 = this.m1;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        c17432mx2.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.e02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13305g02.ma(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(C13305g02 c13305g02, View view) {
        AbstractC13042fc3.i(c13305g02, "this$0");
        c13305g02.k1 = true;
        b bVar = c13305g02.j1;
        if (bVar != null) {
            C17432mx2 c17432mx2 = c13305g02.m1;
            if (c17432mx2 == null) {
                AbstractC13042fc3.y("binding");
                c17432mx2 = null;
            }
            bVar.a(c17432mx2.i.getProgress());
        }
        c13305g02.ua();
    }

    private final void na() {
        C17432mx2 c17432mx2 = this.m1;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        c17432mx2.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.f02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13305g02.oa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(C13305g02 c13305g02, View view) {
        AbstractC13042fc3.i(c13305g02, "this$0");
        c13305g02.k1 = false;
        c13305g02.l1 = EnumC4624Fx6.LINE;
        b bVar = c13305g02.j1;
        if (bVar != null) {
            C17432mx2 c17432mx2 = c13305g02.m1;
            if (c17432mx2 == null) {
                AbstractC13042fc3.y("binding");
                c17432mx2 = null;
            }
            bVar.b(c17432mx2.i.getProgress(), c13305g02.i1, c13305g02.l1);
        }
        c13305g02.ua();
    }

    private final void pa() {
        C17432mx2 c17432mx2 = this.m1;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        c17432mx2.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.a02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13305g02.qa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(C13305g02 c13305g02, View view) {
        AbstractC13042fc3.i(c13305g02, "this$0");
        c13305g02.k1 = false;
        c13305g02.l1 = EnumC4624Fx6.RECTANGLE;
        b bVar = c13305g02.j1;
        if (bVar != null) {
            C17432mx2 c17432mx2 = c13305g02.m1;
            if (c17432mx2 == null) {
                AbstractC13042fc3.y("binding");
                c17432mx2 = null;
            }
            bVar.b(c17432mx2.i.getProgress(), c13305g02.i1, c13305g02.l1);
        }
        c13305g02.ua();
    }

    private final void ra() {
        C17432mx2 c17432mx2 = this.m1;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        c17432mx2.i.setOnSeekBarChangeListener(new e());
    }

    private final void ua() {
        C17432mx2 c17432mx2 = this.m1;
        C17432mx2 c17432mx22 = null;
        if (c17432mx2 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2 = null;
        }
        c17432mx2.f.setImageResource(KB5.ic_draw_eraser);
        C17432mx2 c17432mx23 = this.m1;
        if (c17432mx23 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx23 = null;
        }
        c17432mx23.e.setImageResource(KB5.ic_draw_shape);
        C17432mx2 c17432mx24 = this.m1;
        if (c17432mx24 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx24 = null;
        }
        c17432mx24.h.setImageResource(KB5.ic_draw_rectangle);
        C17432mx2 c17432mx25 = this.m1;
        if (c17432mx25 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx25 = null;
        }
        c17432mx25.c.setImageResource(KB5.ic_draw_circle);
        C17432mx2 c17432mx26 = this.m1;
        if (c17432mx26 == null) {
            AbstractC13042fc3.y("binding");
            c17432mx26 = null;
        }
        c17432mx26.g.setImageResource(KB5.ic_draw_line);
        if (this.k1) {
            C17432mx2 c17432mx27 = this.m1;
            if (c17432mx27 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c17432mx22 = c17432mx27;
            }
            c17432mx22.f.setImageResource(KB5.ic_draw_eraser_select);
            return;
        }
        int i = c.a[this.l1.ordinal()];
        if (i == 1) {
            C17432mx2 c17432mx28 = this.m1;
            if (c17432mx28 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c17432mx22 = c17432mx28;
            }
            c17432mx22.e.setImageResource(KB5.ic_draw_shape_select);
            return;
        }
        if (i == 2) {
            C17432mx2 c17432mx29 = this.m1;
            if (c17432mx29 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c17432mx22 = c17432mx29;
            }
            c17432mx22.h.setImageResource(KB5.ic_draw_rectangle_select);
            return;
        }
        if (i == 3) {
            C17432mx2 c17432mx210 = this.m1;
            if (c17432mx210 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c17432mx22 = c17432mx210;
            }
            c17432mx22.c.setImageResource(KB5.ic_draw_circle_select);
            return;
        }
        if (i != 4) {
            C17432mx2 c17432mx211 = this.m1;
            if (c17432mx211 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c17432mx22 = c17432mx211;
            }
            c17432mx22.e.setImageResource(KB5.ic_draw_shape_select);
            return;
        }
        C17432mx2 c17432mx212 = this.m1;
        if (c17432mx212 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c17432mx22 = c17432mx212;
        }
        c17432mx22.g.setImageResource(KB5.ic_draw_line_select);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        C17432mx2 c17432mx2C = C17432mx2.c(layoutInflater, viewGroup, false);
        this.m1 = c17432mx2C;
        if (c17432mx2C == null) {
            AbstractC13042fc3.y("binding");
            c17432mx2C = null;
        }
        CoordinatorLayout root = c17432mx2C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        this.h1.onClose();
        super.T6();
        sa().f();
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        sa().i();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        this.i1 = AbstractC4043Dl1.c(S7(), TA5.white);
        ga();
        ha();
        ra();
        la();
        ja();
        pa();
        ea();
        na();
        ua();
    }

    public final C15753k68 sa() {
        C15753k68 c15753k68 = this.n1;
        if (c15753k68 != null) {
            return c15753k68;
        }
        AbstractC13042fc3.y("minimizeManager");
        return null;
    }

    public final void ta(b bVar) {
        AbstractC13042fc3.i(bVar, "drawEditorListener");
        this.j1 = bVar;
    }

    /* renamed from: ir.nasim.g02$e */
    public static final class e implements SeekBar.OnSeekBarChangeListener {
        e() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (!C13305g02.this.k1) {
                b bVar = C13305g02.this.j1;
                if (bVar != null) {
                    bVar.b(i, C13305g02.this.i1, C13305g02.this.l1);
                    return;
                }
                return;
            }
            b bVar2 = C13305g02.this.j1;
            if (bVar2 != null) {
                C17432mx2 c17432mx2 = C13305g02.this.m1;
                if (c17432mx2 == null) {
                    AbstractC13042fc3.y("binding");
                    c17432mx2 = null;
                }
                bVar2.a(c17432mx2.i.getProgress());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
