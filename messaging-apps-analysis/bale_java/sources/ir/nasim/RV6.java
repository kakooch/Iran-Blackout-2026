package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C13305g02;
import ir.nasim.C5702Kl7;
import ir.nasim.C8975Ya6;
import ir.nasim.D20;
import ir.nasim.InterfaceC10891cN5;
import ir.nasim.InterfaceC21793u85;
import ir.nasim.RV6;
import ir.nasim.story.model.StoryWidget;
import ir.nasim.story.ui.viewfragment.views.PreparingStoryView;
import ja.burhanrashid52.photoeditor.PhotoEditorView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public final class RV6 extends UX2 implements InterfaceC15279jJ4, LJ4 {
    public static final a v1 = new a(null);
    public static final int w1 = 8;
    private String h1;
    private final boolean i1;
    private final boolean j1;
    private final boolean k1;
    private List l1;
    private C14189hV6 m1;
    private C3463Az2 n1;
    private final InterfaceC9173Yu3 o1;
    private final InterfaceC9173Yu3 p1;
    private D20 q1;
    private D20 r1;
    public InterfaceC21793u85 s1;
    private boolean t1;
    public PeersStruct$ExPeer u1;

    public static final class a {
        private a() {
        }

        public final RV6 a(String str, boolean z, boolean z2, boolean z3, List list, C14189hV6 c14189hV6) {
            AbstractC13042fc3.i(str, "fileAddress");
            AbstractC13042fc3.i(list, "storyWidgets");
            return new RV6(str, z, z2, z3, AbstractC15401jX0.p1(list), c14189hV6);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements C13305g02.b {
        b() {
        }

        @Override // ir.nasim.C13305g02.b
        public void a(int i) {
            RV6.this.Qa().e(new C12645ex6().f(100).g(i));
            RV6.this.Qa().a(true);
            RV6.this.Qa().f();
        }

        @Override // ir.nasim.C13305g02.b
        public void b(int i, int i2, EnumC4624Fx6 enumC4624Fx6) {
            AbstractC13042fc3.i(enumC4624Fx6, "shapeType");
            RV6.this.Qa().e(new C12645ex6().f(100).h(enumC4624Fx6).g(i).e(i2));
            RV6.this.Qa().a(true);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C3463Az2 e;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C3463Az2 a;
            final /* synthetic */ RV6 b;
            final /* synthetic */ InterfaceC20315ro1 c;

            a(C3463Az2 c3463Az2, RV6 rv6, InterfaceC20315ro1 interfaceC20315ro1) {
                this.a = c3463Az2;
                this.b = rv6;
                this.c = interfaceC20315ro1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void h(C3463Az2 c3463Az2, RV6 rv6, C21346tV6 c21346tV6, CompoundButton compoundButton, boolean z) {
                AbstractC13042fc3.i(c3463Az2, "$this_with");
                AbstractC13042fc3.i(rv6, "this$0");
                AbstractC13042fc3.i(c21346tV6, "$storyTag");
                c3463Az2.s.setSelected(z);
                if (z) {
                    c3463Az2.r.setButtonTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(rv6.S7(), TA5.colorPrimary_light)));
                } else {
                    c3463Az2.r.setButtonTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(rv6.S7(), TA5.n600_light)));
                }
                rv6.m1 = z ? new C14189hV6(c21346tV6.b(), false) : null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void i(C3463Az2 c3463Az2, View view) {
                AbstractC13042fc3.i(c3463Az2, "$this_with");
                c3463Az2.r.performClick();
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC10891cN5 interfaceC10891cN5, InterfaceC20295rm1 interfaceC20295rm1) {
                if (!(interfaceC10891cN5 instanceof InterfaceC10891cN5.c)) {
                    return C19938rB7.a;
                }
                final C21346tV6 c21346tV6 = (C21346tV6) ((InterfaceC10891cN5.c) interfaceC10891cN5).a();
                this.a.s.setVisibility(0);
                this.a.c.setBackgroundColor(AbstractC4043Dl1.c(this.b.S7(), GA5.story_footer_background));
                if (c21346tV6.b() == 1) {
                    Drawable drawableB = AbstractC9594aE.b(this.b.S7(), AbstractC23008wB5.ic_tab_story);
                    if (drawableB != null) {
                        try {
                            drawableB.setTint(Color.parseColor(c21346tV6.a()));
                        } catch (Exception e) {
                            C19406qI3.d("StoryUploadFragment", e);
                        }
                    }
                    this.a.t.setImageDrawable(drawableB);
                } else if (c21346tV6.b() == 2 || c21346tV6.b() == 3) {
                    Context contextS7 = this.b.S7();
                    EnumC20117rV6 enumC20117rV6A = EnumC20117rV6.h.a(c21346tV6.b());
                    this.a.t.setImageDrawable(AbstractC9594aE.b(contextS7, enumC20117rV6A != null ? enumC20117rV6A.j() : 0));
                }
                this.a.u.setText(c21346tV6.c());
                final C3463Az2 c3463Az2 = this.a;
                AppCompatCheckBox appCompatCheckBox = c3463Az2.r;
                final RV6 rv6 = this.b;
                appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.SV6
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        RV6.c.a.h(c3463Az2, rv6, c21346tV6, compoundButton, z);
                    }
                });
                final C3463Az2 c3463Az22 = this.a;
                c3463Az22.s.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.TV6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RV6.c.a.i(c3463Az22, view);
                    }
                });
                AbstractC20906so1.d(this.c, null, 1, null);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C3463Az2 c3463Az2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c3463Az2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = RV6.this.new c(this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2T6 = RV6.this.Ra().t6();
                a aVar = new a(this.e, RV6.this, interfaceC20315ro1);
                this.b = 1;
                if (interfaceC4557Fq2T6.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d implements C5702Kl7.b {
        d() {
        }

        @Override // ir.nasim.C5702Kl7.b
        public void a(String str, int i) {
            Typeface typefaceH = VW5.h(RV6.this.S7(), MB5.iran_sans_regular);
            C9940ao7 c9940ao7 = new C9940ao7();
            c9940ao7.m(30.0f);
            c9940ao7.k(i);
            if (typefaceH != null) {
                c9940ao7.l(typefaceH);
            }
            RV6.this.Qa().g(str, c9940ao7);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ RV6 a;
            final /* synthetic */ InterfaceC20315ro1 b;

            a(RV6 rv6, InterfaceC20315ro1 interfaceC20315ro1) {
                this.a = rv6;
                this.b = interfaceC20315ro1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC10891cN5 interfaceC10891cN5, InterfaceC20295rm1 interfaceC20295rm1) {
                if (interfaceC10891cN5 instanceof InterfaceC10891cN5.c) {
                    this.a.Ua((C21346tV6) ((InterfaceC10891cN5.c) interfaceC10891cN5).a());
                    AbstractC20906so1.d(this.b, null, 1, null);
                }
                return C19938rB7.a;
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = RV6.this.new e(interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2T6 = RV6.this.Ra().t6();
                a aVar = new a(RV6.this, interfaceC20315ro1);
                this.b = 1;
                if (interfaceC4557Fq2T6.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class f implements C5702Kl7.b {
        final /* synthetic */ View a;
        final /* synthetic */ RV6 b;

        f(View view, RV6 rv6) {
            this.a = view;
            this.b = rv6;
        }

        @Override // ir.nasim.C5702Kl7.b
        public void a(String str, int i) {
            C9940ao7 c9940ao7 = new C9940ao7();
            c9940ao7.k(i);
            if (this.a != null) {
                this.b.Qa().i(this.a, str, c9940ao7);
            }
        }
    }

    public static final class g implements InterfaceC21793u85.b {
        g() {
        }

        @Override // ir.nasim.InterfaceC21793u85.b
        public void a(Exception exc) {
            AbstractC13042fc3.i(exc, "exception");
            RV6.this.R4();
            RV6 rv6 = RV6.this;
            rv6.J9(rv6.h6(SD5.story_upload_error));
        }

        @Override // ir.nasim.InterfaceC21793u85.b
        public void b(String str) {
            AbstractC13042fc3.i(str, "imagePath");
            RV6.this.R4();
            RV6.this.Ra().p6(str, RV6.this.Pa(), (4 & 4) != 0 ? null : RV6.this.m1, (4 & 8) != 0 ? null : RV6.this.l1, (4 & 16) != 0 ? null : null);
            RV6 rv6 = RV6.this;
            C22042ua0.m9(rv6, rv6, false, 2, null);
            RV6 rv62 = RV6.this;
            List listC0 = rv62.Q7().B0().C0();
            AbstractC13042fc3.h(listC0, "getFragments(...)");
            Object objC0 = AbstractC15401jX0.C0(listC0);
            AbstractC13042fc3.h(objC0, "last(...)");
            C22042ua0.m9(rv62, (Fragment) objC0, false, 2, null);
            RV6 rv63 = RV6.this;
            C22042ua0.A9(rv63, MW6.INSTANCE.a(rv63.Pa().getId(), new ArrayList(), (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? -1 : 0), false, null, 6, null);
        }
    }

    public RV6(String str, boolean z, boolean z2, boolean z3, List list, C14189hV6 c14189hV6) {
        AbstractC13042fc3.i(str, "fileAddress");
        AbstractC13042fc3.i(list, "storyWidgets");
        this.h1 = str;
        this.i1 = z;
        this.j1 = z2;
        this.k1 = z3;
        this.l1 = list;
        this.m1 = c14189hV6;
        this.o1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.AV6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return RV6.kb(this.a);
            }
        });
        this.p1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.IV6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return RV6.oa(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        AbstractC13610gX0.K(rv6.l1, new UA2() { // from class: ir.nasim.HV6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(RV6.Ba((StoryWidget) obj));
            }
        });
        rv6.ib();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ba(StoryWidget storyWidget) {
        AbstractC13042fc3.i(storyWidget, "it");
        return storyWidget instanceof StoryWidget.LinkWidget;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        rv6.eb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        rv6.fb(false);
        C3463Az2 c3463Az2 = rv6.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        c3463Az2.p.setSelected(false);
    }

    private final void Ea() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        ConstraintLayout constraintLayout = c3463Az2.l;
        if (this.i1) {
            gb(false);
            constraintLayout.setBackgroundColor(-16777216);
            if (Ra().C3().isEmpty() || Ra().C3().size() < Ra().B3()) {
                cb(AbstractC23008wB5.empty_image);
                return;
            }
            InterfaceC3346Am2 interfaceC3346Am2 = (InterfaceC3346Am2) Ra().C3().get(0);
            if (interfaceC3346Am2 != null) {
                db(interfaceC3346Am2.getDescriptor());
            }
        }
    }

    private final void Fa() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        PreparingStoryView preparingStoryView = c3463Az2.n;
        String strH6 = h6(SD5.preparing_story);
        AbstractC13042fc3.h(strH6, "getString(...)");
        preparingStoryView.setText(strH6);
    }

    private final void Ga() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        final TextView textView = c3463Az2.y;
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.Ha(this.a, textView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(RV6 rv6, TextView textView, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        AbstractC13042fc3.i(textView, "$this_with");
        if (!rv6.Ra().Z4(rv6.h1) && (!AbstractC20762sZ6.n0(rv6.h1))) {
            rv6.L2(SD5.error_eccured);
            C19406qI3.b("StoryUploadFragment", "uploadButton, Video not supported in this fragment!");
        } else if ((rv6.Qa().d() || !rv6.i1) && rv6.i1) {
            C17468n10 c17468n10Oa = rv6.Oa();
            String string = textView.getContext().getString(SD5.story_empty_text_not_allowed);
            AbstractC13042fc3.h(string, "getString(...)");
            c17468n10Oa.o(string);
        } else {
            rv6.t2(SD5.avatar_loading);
            rv6.Za();
            if (rv6.j1) {
                rv6.Va(5);
            }
            rv6.Ya();
        }
        if (rv6.k1) {
            C23144wQ6.a.b(EnumC17253mf2.a);
        }
    }

    private final InterfaceC13730gj3 Ia() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        c3463Az2.s.setVisibility(8);
        return AbstractC19455qN7.g(this, null, new c(c3463Az2, null), 1, null);
    }

    private final void Ja() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        ImageView imageView = c3463Az2.v;
        if (!Ra().Z4(this.h1) && (!AbstractC20762sZ6.n0(this.h1))) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.KV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.Ka(this.a, view);
            }
        });
        if (this.i1) {
            imageView.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        C5702Kl7 c5702Kl7B = C5702Kl7.a.b(C5702Kl7.s1, rv6, null, 0, 6, null);
        c5702Kl7B.T8(rv6.new d());
        c5702Kl7B.K8(rv6.Q7().B0(), "");
        rv6.hb(false);
    }

    private final void La() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        final ImageView imageView = c3463Az2.x;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.Ma(this.a, imageView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(RV6 rv6, ImageView imageView, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        AbstractC13042fc3.i(imageView, "$this_with");
        rv6.Qa().h();
        imageView.setVisibility(rv6.Qa().d() ? 8 : 0);
    }

    private final void Na() {
        Ea();
        pa();
        Ga();
        va();
        Ja();
        ta();
        La();
        ra();
        Ia();
        xa();
        Fa();
    }

    private final C17468n10 Oa() {
        return (C17468n10) this.p1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 Ra() {
        return (C10366bX6) this.o1.getValue();
    }

    private final void Sa() {
        if (Ra().j4()) {
            return;
        }
        C3463Az2 c3463Az2 = this.n1;
        C3463Az2 c3463Az22 = null;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        if (c3463Az2.d.getVisibility() == 0) {
            D20.a aVarC = C10600bs7.a.c(p6());
            String strH6 = h6(SD5.story_change_background_tooltip);
            AbstractC13042fc3.h(strH6, "getString(...)");
            aVarC.X1(strH6);
            D20 d20A = aVarC.a();
            C3463Az2 c3463Az23 = this.n1;
            if (c3463Az23 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c3463Az22 = c3463Az23;
            }
            ImageView imageView = c3463Az22.d;
            AbstractC13042fc3.h(imageView, "changeBackgroundIcon");
            D20.K0(d20A, imageView, JF5.g() ? 0 : C22078ud6.a(132.0f), 0, 4, null);
            this.q1 = d20A;
            Ra().U5();
        }
    }

    private final void Ta() {
        C3463Az2 c3463Az2 = null;
        if (StoryWidget.Unknown.a.f0(this.l1) != null) {
            C3463Az2 c3463Az22 = this.n1;
            if (c3463Az22 == null) {
                AbstractC13042fc3.y("binding");
                c3463Az22 = null;
            }
            c3463Az22.j.setImageResource(AbstractC23008wB5.ic_story_insert_link_disabled);
            C3463Az2 c3463Az23 = this.n1;
            if (c3463Az23 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c3463Az2 = c3463Az23;
            }
            c3463Az2.j.setEnabled(false);
            return;
        }
        C3463Az2 c3463Az24 = this.n1;
        if (c3463Az24 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az24 = null;
        }
        c3463Az24.j.setImageResource(AbstractC23008wB5.ic_story_insert_link);
        C3463Az2 c3463Az25 = this.n1;
        if (c3463Az25 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c3463Az2 = c3463Az25;
        }
        c3463Az2.j.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ua(C21346tV6 c21346tV6) {
        EnumC20117rV6 enumC20117rV6A = EnumC20117rV6.h.a(c21346tV6.b());
        if (enumC20117rV6A == null || Ra().t4() || Ra().A4()) {
            return;
        }
        C3463Az2 c3463Az2 = this.n1;
        C3463Az2 c3463Az22 = null;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        if (c3463Az2.s.getVisibility() == 0) {
            D20.a aVarD = C10600bs7.a.d(p6());
            String strH6 = h6(enumC20117rV6A.y());
            AbstractC13042fc3.h(strH6, "getString(...)");
            aVarD.X1(strH6);
            D20 d20A = aVarD.a();
            C3463Az2 c3463Az23 = this.n1;
            if (c3463Az23 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c3463Az22 = c3463Az23;
            }
            AppCompatCheckBox appCompatCheckBox = c3463Az22.r;
            AbstractC13042fc3.h(appCompatCheckBox, "tagCheckbox");
            d20A.M0(appCompatCheckBox, 0, C22078ud6.a(-10.0f));
            this.r1 = d20A;
            Ra().V5();
            Ra().W5();
        }
    }

    private final void Va(int i) {
        HashMap map = new HashMap();
        map.put("action_type", Integer.valueOf(i));
        C3343Am.i("story_pic", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Wa(RV6 rv6, String str, Bundle bundle) {
        AbstractC13042fc3.i(rv6, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        String string = bundle.getString("KEY_LINK");
        if (string != null) {
            List list = rv6.l1;
            String string2 = bundle.getString("KEY_LINK_TITLE");
            if (string2 == null) {
                string2 = "";
            }
            list.add(new StoryWidget.LinkWidget(string, string2, null, 4, null));
            rv6.ib();
        }
        return C19938rB7.a;
    }

    private final void Xa(StoryWidget.LinkWidget linkWidget) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(linkWidget.a()));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        if (c18987pb3.k0(intent, fragmentActivityQ7)) {
            return;
        }
        String strA = linkWidget.a();
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        aVar.A(contextS7, Uri.parse(strA));
    }

    private final void Ya() {
        String strL = C4053Dm2.l("edited_image", "jpg");
        if (strL == null) {
            return;
        }
        C8975Ya6 c8975Ya6A = new C8975Ya6.a().f(true).g(true).a();
        if (AbstractC4043Dl1.a(S7(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0 && AbstractC4043Dl1.a(S7(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            P7(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
        }
        Qa().b(strL, c8975Ya6A, new g());
    }

    private final void Za() {
        HashMap map = new HashMap();
        if (this.i1) {
            if (this.t1) {
                map.put("action_type", 6);
            } else {
                map.put("action_type", 3);
            }
        } else if (Qa().d()) {
            map.put("action_type", 1);
        } else {
            map.put("action_type", 2);
        }
        C3343Am.i("story_pic", map);
    }

    private final void cb(int i) {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        PhotoEditorView photoEditorView = c3463Az2.m;
        String string = S7().getString(SD5.story_size_dimension_width_height);
        AbstractC13042fc3.h(string, "getString(...)");
        List listN0 = AbstractC20762sZ6.N0(string, new String[]{":"}, false, 0, 6, null);
        QI2.a.s(photoEditorView.getSource(), i, Float.parseFloat((String) listN0.get(0)) / Float.parseFloat((String) listN0.get(1)), true);
    }

    private final void db(String str) {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        PhotoEditorView photoEditorView = c3463Az2.m;
        String string = S7().getString(SD5.story_size_dimension_width_height);
        AbstractC13042fc3.h(string, "getString(...)");
        List listN0 = AbstractC20762sZ6.N0(string, new String[]{":"}, false, 0, 6, null);
        QI2.a.t(photoEditorView.getSource(), str, Float.parseFloat((String) listN0.get(0)) / Float.parseFloat((String) listN0.get(1)), true);
    }

    private final void eb() {
        C14153hR6.INSTANCE.a(StoryWidget.Unknown.a.f0(this.l1)).K8(Q7().B0(), null);
    }

    private final void fb(boolean z) {
        C3463Az2 c3463Az2 = this.n1;
        C3463Az2 c3463Az22 = null;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        c3463Az2.k.setVisibility(z ? 0 : 8);
        C3463Az2 c3463Az23 = this.n1;
        if (c3463Az23 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az23 = null;
        }
        c3463Az23.h.setVisibility(z ? 8 : 0);
        C3463Az2 c3463Az24 = this.n1;
        if (c3463Az24 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c3463Az22 = c3463Az24;
        }
        c3463Az22.i.setVisibility(z ? 8 : 0);
    }

    private final void gb(boolean z) {
        C3463Az2 c3463Az2 = this.n1;
        C3463Az2 c3463Az22 = null;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        ConstraintLayout constraintLayout = c3463Az2.w;
        AbstractC13042fc3.h(constraintLayout, "topLayout");
        constraintLayout.setVisibility(z ^ true ? 0 : 8);
        C3463Az2 c3463Az23 = this.n1;
        if (c3463Az23 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az23 = null;
        }
        ConstraintLayout constraintLayout2 = c3463Az23.c;
        AbstractC13042fc3.h(constraintLayout2, "bottomContainer");
        constraintLayout2.setVisibility(z ^ true ? 0 : 8);
        C3463Az2 c3463Az24 = this.n1;
        if (c3463Az24 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c3463Az22 = c3463Az24;
        }
        PreparingStoryView preparingStoryView = c3463Az22.n;
        AbstractC13042fc3.h(preparingStoryView, "preparingStoryView");
        preparingStoryView.setVisibility(z ? 0 : 8);
    }

    private final void hb(boolean z) {
        C3463Az2 c3463Az2 = null;
        if (z) {
            C3463Az2 c3463Az22 = this.n1;
            if (c3463Az22 == null) {
                AbstractC13042fc3.y("binding");
                c3463Az22 = null;
            }
            c3463Az22.c.setVisibility(0);
            C3463Az2 c3463Az23 = this.n1;
            if (c3463Az23 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c3463Az2 = c3463Az23;
            }
            c3463Az2.w.setVisibility(0);
            return;
        }
        C3463Az2 c3463Az24 = this.n1;
        if (c3463Az24 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az24 = null;
        }
        c3463Az24.c.setVisibility(8);
        C3463Az2 c3463Az25 = this.n1;
        if (c3463Az25 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c3463Az2 = c3463Az25;
        }
        c3463Az2.w.setVisibility(8);
    }

    private final C19938rB7 ib() {
        C3463Az2 c3463Az2 = this.n1;
        C3463Az2 c3463Az22 = null;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        final ConstraintLayout constraintLayout = c3463Az2.p;
        constraintLayout.setVisibility(8);
        fb(false);
        Ta();
        StoryWidget.LinkWidget linkWidgetF0 = StoryWidget.Unknown.a.f0(this.l1);
        if (linkWidgetF0 == null) {
            return null;
        }
        constraintLayout.setVisibility(0);
        constraintLayout.setSelected(false);
        C3463Az2 c3463Az23 = this.n1;
        if (c3463Az23 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c3463Az22 = c3463Az23;
        }
        AppCompatTextView appCompatTextView = c3463Az22.q;
        String title = linkWidgetF0.getTitle();
        if (title.length() == 0) {
            title = linkWidgetF0.a();
        }
        appCompatTextView.setText(title);
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.DV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.jb(constraintLayout, this, view);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jb(ConstraintLayout constraintLayout, RV6 rv6, View view) {
        AbstractC13042fc3.i(constraintLayout, "$this_with");
        AbstractC13042fc3.i(rv6, "this$0");
        constraintLayout.setSelected(!constraintLayout.isSelected());
        rv6.fb(constraintLayout.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 kb(RV6 rv6) {
        AbstractC13042fc3.i(rv6, "this$0");
        FragmentActivity fragmentActivityQ7 = rv6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 oa(RV6 rv6) {
        AbstractC13042fc3.i(rv6, "this$0");
        C3463Az2 c3463Az2 = rv6.n1;
        C3463Az2 c3463Az22 = null;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        ConstraintLayout constraintLayoutB = c3463Az2.getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(constraintLayoutB, null, 0, 6, null);
        C3463Az2 c3463Az23 = rv6.n1;
        if (c3463Az23 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c3463Az22 = c3463Az23;
        }
        c17468n10.k(c3463Az22.y);
        c17468n10.m(-1);
        return c17468n10;
    }

    private final void pa() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        ImageView imageView = c3463Az2.i;
        if (JF5.g()) {
            imageView.setRotation(180.0f);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.CV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.qa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        rv6.Q7().onBackPressed();
    }

    private final void ra() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        ImageView imageView = c3463Az2.d;
        if (!AbstractC20762sZ6.n0(this.h1)) {
            imageView.setVisibility(8);
        } else {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.LV6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RV6.sa(this.a, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        if (rv6.Ra().C3().isEmpty() || rv6.Ra().C3().size() < rv6.Ra().B3()) {
            C17468n10 c17468n10Oa = rv6.Oa();
            String strH6 = rv6.h6(SD5.story_loading_backgrounds);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c17468n10Oa.o(strH6);
            return;
        }
        InterfaceC3346Am2 interfaceC3346Am2X3 = rv6.Ra().X3();
        if (interfaceC3346Am2X3 != null) {
            rv6.db(interfaceC3346Am2X3.getDescriptor());
            rv6.t1 = true;
        }
    }

    private final void ta() {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        ImageView imageView = c3463Az2.f;
        if (Ra().Z4(this.h1) || !(!AbstractC20762sZ6.n0(this.h1))) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.EV6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RV6.ua(this.a, view);
                }
            });
        } else {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        C13305g02 c13305g02A = C13305g02.o1.a(rv6);
        c13305g02A.ta(rv6.new b());
        C22042ua0.A9(rv6, c13305g02A, false, null, 6, null);
        rv6.Qa().a(true);
        rv6.hb(false);
    }

    private final void va() {
        C3463Az2 c3463Az2 = this.n1;
        C3463Az2 c3463Az22 = null;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        final PhotoEditorView photoEditorView = c3463Az2.m;
        if (!this.i1 && Ra().Z4(this.h1)) {
            gb(false);
            db(this.h1);
        }
        photoEditorView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.wa(photoEditorView, this, view);
            }
        });
        Typeface typefaceH = VW5.h(S7(), MB5.iran_sans_regular);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        C3463Az2 c3463Az23 = this.n1;
        if (c3463Az23 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c3463Az22 = c3463Az23;
        }
        PhotoEditorView photoEditorView2 = c3463Az22.m;
        AbstractC13042fc3.h(photoEditorView2, "photoEditorView");
        bb(new InterfaceC21793u85.a(contextS7, photoEditorView2).f(true).d(false).e(typefaceH).a());
        Qa().c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(PhotoEditorView photoEditorView, RV6 rv6, View view) {
        AbstractC13042fc3.i(photoEditorView, "$this_with");
        AbstractC13042fc3.i(rv6, "this$0");
        if (photoEditorView.getDrawingView().getIsDrawingEnabled()) {
            return;
        }
        C3463Az2 c3463Az2 = rv6.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        c3463Az2.v.performClick();
    }

    private final C19938rB7 xa() {
        C3463Az2 c3463Az2 = this.n1;
        C3463Az2 c3463Az22 = null;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        c3463Az2.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.MV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.ya(this.a, view);
            }
        });
        C3463Az2 c3463Az23 = this.n1;
        if (c3463Az23 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az23 = null;
        }
        c3463Az23.z.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.NV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.za(this.a, view);
            }
        });
        C3463Az2 c3463Az24 = this.n1;
        if (c3463Az24 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az24 = null;
        }
        c3463Az24.o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.OV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.Aa(this.a, view);
            }
        });
        C3463Az2 c3463Az25 = this.n1;
        if (c3463Az25 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az25 = null;
        }
        c3463Az25.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.PV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.Ca(this.a, view);
            }
        });
        C3463Az2 c3463Az26 = this.n1;
        if (c3463Az26 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c3463Az22 = c3463Az26;
        }
        c3463Az22.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.QV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RV6.Da(this.a, view);
            }
        });
        return ib();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ya(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        rv6.eb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(RV6 rv6, View view) {
        AbstractC13042fc3.i(rv6, "this$0");
        StoryWidget.LinkWidget linkWidgetF0 = StoryWidget.Unknown.a.f0(rv6.l1);
        if (linkWidgetF0 != null) {
            rv6.Xa(linkWidgetF0);
        }
    }

    @Override // ir.nasim.LJ4
    public void E3(ZX7 zx7, int i) {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        c3463Az2.y.setEnabled(true);
    }

    public final PeersStruct$ExPeer Pa() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.u1;
        if (peersStruct$ExPeer != null) {
            return peersStruct$ExPeer;
        }
        AbstractC13042fc3.y("exPeer");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        this.n1 = C3463Az2.c(layoutInflater, viewGroup, false);
        if (this.j1) {
            Va(4);
        }
        ab(Ra().i4());
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        ConstraintLayout constraintLayoutB = c3463Az2.getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        return constraintLayoutB;
    }

    public final InterfaceC21793u85 Qa() {
        InterfaceC21793u85 interfaceC21793u85 = this.s1;
        if (interfaceC21793u85 != null) {
            return interfaceC21793u85;
        }
        AbstractC13042fc3.y("photoEditor");
        return null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        Ra().d6();
    }

    public final void ab(PeersStruct$ExPeer peersStruct$ExPeer) {
        AbstractC13042fc3.i(peersStruct$ExPeer, "<set-?>");
        this.u1 = peersStruct$ExPeer;
    }

    public final void bb(InterfaceC21793u85 interfaceC21793u85) {
        AbstractC13042fc3.i(interfaceC21793u85, "<set-?>");
        this.s1 = interfaceC21793u85;
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        Ra().Y4();
    }

    @Override // ir.nasim.LJ4
    public void j0(View view, String str, int i) {
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        if (c3463Az2.m.getDrawingView().getIsDrawingEnabled()) {
            return;
        }
        C5702Kl7 c5702Kl7A = C5702Kl7.s1.a(this, str, i);
        c5702Kl7A.T8(new f(view, this));
        c5702Kl7A.K8(Q7().B0(), "");
        hb(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        Ra().y5();
        Na();
        AbstractC18623oy2.d(this, "REQUEST_CODE_LINK_BOTTOM_SHEET", new InterfaceC14603iB2() { // from class: ir.nasim.JV6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return RV6.Wa(this.a, (String) obj, (Bundle) obj2);
            }
        });
    }

    @Override // ir.nasim.InterfaceC15279jJ4
    public void onClose() {
        hb(true);
        Qa().a(false);
        C3463Az2 c3463Az2 = this.n1;
        if (c3463Az2 == null) {
            AbstractC13042fc3.y("binding");
            c3463Az2 = null;
        }
        c3463Az2.x.setVisibility(Qa().d() ? 8 : 0);
        Sa();
        AbstractC19455qN7.g(this, null, new e(null), 1, null);
    }

    @Override // ir.nasim.LJ4
    public void F1(ZX7 zx7) {
    }

    @Override // ir.nasim.LJ4
    public void O1(ZX7 zx7) {
    }

    @Override // ir.nasim.LJ4
    public void Y0(MotionEvent motionEvent) {
    }

    @Override // ir.nasim.LJ4
    public void z0(ZX7 zx7, int i) {
    }
}
