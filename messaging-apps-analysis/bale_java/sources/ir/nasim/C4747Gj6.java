package ir.nasim;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C4747Gj6;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u000bJ\u0019\u0010\u001b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ\u000f\u0010\u001c\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J-\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082D¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lir/nasim/Gj6;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/app/Activity;", "parent", "Landroid/widget/FrameLayout;", "Ca", "(Landroid/app/Activity;)Landroid/widget/FrameLayout;", "Landroid/widget/LinearLayout;", "Aa", "(Landroid/app/Activity;)Landroid/widget/LinearLayout;", "wa", "ma", "sa", "ua", "qa", "Landroid/view/View;", "Ga", "(Landroid/app/Activity;)Landroid/view/View;", "Da", "Landroid/widget/Switch;", "switchView", "Lir/nasim/rB7;", "Ia", "(Landroid/widget/Switch;)V", "oa", "ya", "Ra", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/Sg3;", "h1", "Lir/nasim/Sg3;", "Ma", "()Lir/nasim/Sg3;", "setJaryanNavigator", "(Lir/nasim/Sg3;)V", "jaryanNavigator", "Lir/nasim/wb0;", "i1", "Lir/nasim/wb0;", "La", "()Lir/nasim/wb0;", "setBaseSettingsNavigator", "(Lir/nasim/wb0;)V", "baseSettingsNavigator", "Lir/nasim/ok6;", "j1", "Lir/nasim/Yu3;", "Na", "()Lir/nasim/ok6;", "viewModel", "Landroid/widget/TextView;", "k1", "Landroid/widget/TextView;", "loading", "l1", "Landroid/widget/LinearLayout;", "authItems", "", "m1", "Z", "isDeleteAccountEnable", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Gj6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4747Gj6 extends IX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    public InterfaceC7565Sg3 jaryanNavigator;

    /* renamed from: i1, reason: from kotlin metadata */
    public InterfaceC23238wb0 baseSettingsNavigator;

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: k1, reason: from kotlin metadata */
    private TextView loading;

    /* renamed from: l1, reason: from kotlin metadata */
    private LinearLayout authItems;

    /* renamed from: m1, reason: from kotlin metadata */
    private final boolean isDeleteAccountEnable;

    /* renamed from: ir.nasim.Gj6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Activity d;
        final /* synthetic */ Switch e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, Switch r3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = activity;
            this.e = r3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4747Gj6.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objY0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18489ok6 c18489ok6Na = C4747Gj6.this.Na();
                this.b = 1;
                objY0 = c18489ok6Na.Y0(this);
                if (objY0 == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objY0 = ((C9475a16) obj).l();
            }
            Activity activity = this.d;
            Switch r1 = this.e;
            C4747Gj6 c4747Gj6 = C4747Gj6.this;
            if (C9475a16.e(objY0) != null) {
                Toast.makeText(activity, AbstractC12217eE5.error_unknown, 0).show();
                r1.setChecked(true);
                c4747Gj6.P8();
            }
            C4747Gj6 c4747Gj62 = C4747Gj6.this;
            if (C9475a16.j(objY0)) {
                c4747Gj62.P8();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gj6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Switch d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Switch r2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = r2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4747Gj6.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objU0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18489ok6 c18489ok6Na = C4747Gj6.this.Na();
                this.b = 1;
                objU0 = c18489ok6Na.U0(this);
                if (objU0 == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objU0 = ((C9475a16) obj).l();
            }
            C4747Gj6 c4747Gj6 = C4747Gj6.this;
            Switch r1 = this.d;
            if (C9475a16.e(objU0) != null) {
                Toast.makeText(c4747Gj6.S7(), AbstractC12217eE5.error_unknown, 0).show();
                r1.setChecked(false);
                c4747Gj6.P8();
            }
            C4747Gj6 c4747Gj62 = C4747Gj6.this;
            if (C9475a16.j(objU0)) {
                c4747Gj62.P8();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gj6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4747Gj6.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objW0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4747Gj6.this.D9(AbstractC12217eE5.progress_common);
                C18489ok6 c18489ok6Na = C4747Gj6.this.Na();
                this.b = 1;
                objW0 = c18489ok6Na.W0(this);
                if (objW0 == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objW0 = ((C9475a16) obj).l();
            }
            C4747Gj6 c4747Gj6 = C4747Gj6.this;
            if (C9475a16.j(objW0)) {
                c4747Gj6.Ra();
                c4747Gj6.P8();
            }
            C4747Gj6 c4747Gj62 = C4747Gj6.this;
            Throwable thE = C9475a16.e(objW0);
            if (thE != null) {
                c4747Gj62.Ra();
                Context contextS7 = c4747Gj62.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                String strH6 = c4747Gj62.h6(AbstractC12217eE5.forbidden_terminate_all_sessions_title);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC13042fc3.g(thE, "null cannot be cast to non-null type java.lang.Exception");
                C24398yZ.h(contextS7, c4747Gj62, strH6, QQ.a((Exception) thE));
                c4747Gj62.P8();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gj6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Gj6$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C4747Gj6 c;
            final /* synthetic */ C6511Nv d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C4747Gj6 c4747Gj6, C6511Nv c6511Nv, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c4747Gj6;
                this.d = c6511Nv;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objX0;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.c.D9(AbstractC12217eE5.progress_common);
                    C18489ok6 c18489ok6Na = this.c.Na();
                    int iW = this.d.w();
                    this.b = 1;
                    objX0 = c18489ok6Na.X0(iW, this);
                    if (objX0 == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objX0 = ((C9475a16) obj).l();
                }
                C4747Gj6 c4747Gj6 = this.c;
                if (C9475a16.j(objX0)) {
                    Toast.makeText(c4747Gj6.A5(), AbstractC12217eE5.success_ok, 0).show();
                    c4747Gj6.Ra();
                    c4747Gj6.P8();
                }
                C4747Gj6 c4747Gj62 = this.c;
                Throwable thE = C9475a16.e(objX0);
                if (thE != null) {
                    Context contextS7 = c4747Gj62.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    String strH6 = c4747Gj62.h6(AbstractC12217eE5.forbidden_terminate_session_title);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    AbstractC13042fc3.g(thE, "null cannot be cast to non-null type java.lang.Exception");
                    C24398yZ.h(contextS7, c4747Gj62, strH6, QQ.a((Exception) thE));
                    c4747Gj62.Ra();
                    c4747Gj62.P8();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void K(final C4747Gj6 c4747Gj6, List list) {
            c4747Gj6.a9(c4747Gj6.loading, false);
            LinearLayout linearLayout = c4747Gj6.authItems;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            ArrayList arrayList = new ArrayList(list);
            final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.Jj6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Integer.valueOf(C4747Gj6.d.L((C6511Nv) obj, (C6511Nv) obj2));
                }
            };
            AbstractC12992fX0.B(arrayList, new Comparator() { // from class: ir.nasim.Kj6
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C4747Gj6.d.M(interfaceC14603iB2, obj, obj2);
                }
            });
            Iterator it = arrayList.iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            while (it.hasNext()) {
                final C6511Nv c6511Nv = (C6511Nv) it.next();
                if (c4747Gj6.A5() == null) {
                    return;
                }
                View viewInflate = c4747Gj6.Q7().getLayoutInflater().inflate(AbstractC12208eD5.adapter_auth, (ViewGroup) c4747Gj6.authItems, false);
                C5495Jo7 c5495Jo7 = C5495Jo7.a;
                viewInflate.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
                boolean z = c6511Nv.r() == EnumC6017Lv.THISDEVICE;
                String strH6 = z ? c4747Gj6.h6(AbstractC12217eE5.security_this_title) : "";
                String str = strH6 + c6511Nv.u();
                View viewFindViewById = viewInflate.findViewById(BC5.date);
                AbstractC13042fc3.g(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                Context contextS7 = c4747Gj6.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                ((TextView) viewFindViewById).setText(C14593iA1.l(contextS7, c6511Nv.s() * 1000, false, 4, null));
                View viewFindViewById2 = viewInflate.findViewById(BC5.date);
                AbstractC13042fc3.g(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) viewFindViewById2).setTextColor(c5495Jo7.f1());
                View viewFindViewById3 = viewInflate.findViewById(BC5.appTitle);
                AbstractC13042fc3.g(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) viewFindViewById3).setText(c6511Nv.q());
                View viewFindViewById4 = viewInflate.findViewById(BC5.appTitle);
                AbstractC13042fc3.g(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) viewFindViewById4).setTextColor(c5495Jo7.f1());
                View viewFindViewById5 = viewInflate.findViewById(BC5.deviceTitle);
                AbstractC13042fc3.g(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) viewFindViewById5).setText(str);
                View viewFindViewById6 = viewInflate.findViewById(BC5.deviceTitle);
                AbstractC13042fc3.g(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) viewFindViewById6).setTextColor(c5495Jo7.g1());
                if (!z) {
                    viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Lj6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C4747Gj6.d.P(c4747Gj6, c6511Nv, view);
                        }
                    });
                }
                LinearLayout linearLayout2 = c4747Gj6.authItems;
                if (linearLayout2 != null) {
                    linearLayout2.addView(viewInflate);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int L(C6511Nv c6511Nv, C6511Nv c6511Nv2) {
            return c6511Nv2.s() - c6511Nv.s();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int M(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
            return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void P(final C4747Gj6 c4747Gj6, final C6511Nv c6511Nv, View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(c4747Gj6.A5(), AbstractC23035wE5.AlertDialogStyle);
            String strH6 = c4747Gj6.h6(AbstractC12217eE5.security_terminate_this_message);
            AbstractC13042fc3.h(strH6, "getString(...)");
            String strU = c6511Nv.u();
            AbstractC13042fc3.h(strU, "getDeviceTitle(...)");
            builder.setMessage(AbstractC20153rZ6.M(strH6, "{device}", strU, false, 4, null)).setPositiveButton(AbstractC12217eE5.dialog_yes, new DialogInterface.OnClickListener() { // from class: ir.nasim.Mj6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C4747Gj6.d.Q(c4747Gj6, c6511Nv, dialogInterface, i);
                }
            }).setNegativeButton(AbstractC12217eE5.dialog_no, (DialogInterface.OnClickListener) null).show().setCanceledOnTouchOutside(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Q(C4747Gj6 c4747Gj6, C6511Nv c6511Nv, DialogInterface dialogInterface, int i) {
            AbstractC10533bm0.d(AbstractC16751lo1.a(c4747Gj6), null, null, new a(c4747Gj6, c6511Nv, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void R(C4747Gj6 c4747Gj6) {
            TextView textView = c4747Gj6.loading;
            if (textView != null) {
                textView.setText(AbstractC12217eE5.security_toast_unable_to_load);
            }
            TextView textView2 = c4747Gj6.loading;
            if (textView2 != null) {
                textView2.setClickable(true);
            }
            c4747Gj6.L9(c4747Gj6.loading, false);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4747Gj6.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objT0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18489ok6 c18489ok6Na = C4747Gj6.this.Na();
                this.b = 1;
                objT0 = c18489ok6Na.T0(this);
                if (objT0 == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objT0 = ((C9475a16) obj).l();
            }
            final C4747Gj6 c4747Gj6 = C4747Gj6.this;
            if (C9475a16.j(objT0)) {
                final List list = (List) objT0;
                AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Hj6
                    @Override // java.lang.Runnable
                    public final void run() {
                        C4747Gj6.d.K(c4747Gj6, list);
                    }
                });
            }
            final C4747Gj6 c4747Gj62 = C4747Gj6.this;
            if (C9475a16.e(objT0) != null) {
                AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Ij6
                    @Override // java.lang.Runnable
                    public final void run() {
                        C4747Gj6.d.R(c4747Gj62);
                    }
                });
            }
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Gj6$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Gj6$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Gj6$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Gj6$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.Gj6$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C4747Gj6() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C18489ok6.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
        this.isDeleteAccountEnable = true;
    }

    private final LinearLayout Aa(Activity parent) {
        LinearLayout linearLayout = new LinearLayout(parent);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Cj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.Ba(this.a, view);
            }
        });
        TextView textView = new TextView(parent);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.two_f_a_setting);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.addView(textView);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        C22042ua0.A9(c4747Gj6, c4747Gj6.La().c(), false, null, 6, null);
    }

    private final FrameLayout Ca(Activity parent) {
        FrameLayout frameLayout = new FrameLayout(parent);
        frameLayout.setLayoutParams(C14433hu3.a(-1, 16.0f));
        frameLayout.setBackgroundColor(C5495Jo7.a.o());
        View view = new View(parent);
        view.setLayoutParams(C14433hu3.c(-1, 4, 48));
        view.setBackgroundDrawable(parent.getResources().getDrawable(KB5.card_shadow_bottom));
        View view2 = new View(parent);
        view2.setLayoutParams(C14433hu3.c(-1, 1, 80));
        view2.setBackgroundDrawable(parent.getResources().getDrawable(KB5.card_shadow_top));
        frameLayout.addView(view);
        frameLayout.addView(view2);
        return frameLayout;
    }

    private final View Da(final Activity parent) {
        View viewInflate = LayoutInflater.from(parent).inflate(AbstractC12208eD5.setting_row_switch_new, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(BC5.setting_row_tv_title);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.mxp_setting_title);
        textView.setGravity(8388611);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.setting_row_tv_subtitle);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(AbstractC12217eE5.mxp_setting_hint);
        textView2.setGravity(8388611);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTypeface(C6011Lu2.k());
        final Switch r1 = (Switch) viewInflate.findViewById(BC5.setting_row_switch);
        r1.setChecked(Na().S0());
        r1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ej6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.Ea(this.a, r1, parent, view);
            }
        });
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Fj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.Fa(r1, view);
            }
        });
        AbstractC13042fc3.f(viewInflate);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(C4747Gj6 c4747Gj6, Switch r7, Activity activity, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        if (c4747Gj6.Na().S0()) {
            c4747Gj6.D9(AbstractC12217eE5.progress_common);
            AbstractC10533bm0.d(AbstractC16751lo1.a(c4747Gj6), null, null, c4747Gj6.new a(activity, r7, null), 3, null);
        } else {
            AbstractC13042fc3.f(r7);
            c4747Gj6.Ia(r7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(Switch r0, View view) {
        r0.performClick();
    }

    private final View Ga(Activity parent) {
        View viewInflate = LayoutInflater.from(parent).inflate(AbstractC12208eD5.setting_row_switch_new, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(BC5.setting_row_tv_title);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.sync_contacts);
        textView.setGravity(8388611);
        textView.setTextColor(C5495Jo7.a.g1());
        textView.setTypeface(C6011Lu2.k());
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.setting_row_tv_subtitle);
        AbstractC13042fc3.f(textView2);
        textView2.setVisibility(8);
        final Switch r0 = (Switch) viewInflate.findViewById(BC5.setting_row_switch);
        r0.setChecked(Na().R0());
        r0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.Ha(this.a, r0, view);
            }
        });
        AbstractC13042fc3.f(viewInflate);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(C4747Gj6 c4747Gj6, Switch r1, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        c4747Gj6.Na().V0(r1.isChecked());
    }

    private final void Ia(final Switch switchView) {
        final C12889fL5 c12889fL5 = new C12889fL5();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        MY myA = new NY(contextS7).B(h6(AbstractC12217eE5.mxp_dialog_title)).i(h6(AbstractC12217eE5.mxp_dialog_desc)).x(h6(AbstractC12217eE5.mxp_dialog_confirm)).E(4).k(4).u(h6(AbstractC12217eE5.mxp_dialog_cancel)).v(new View.OnClickListener() { // from class: ir.nasim.vj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.Ja(this.a, switchView, c12889fL5, view);
            }
        }).s(new View.OnClickListener() { // from class: ir.nasim.wj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.Ka(c12889fL5, switchView, view);
            }
        }).c(false).a();
        c12889fL5.a = myA;
        myA.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(C4747Gj6 c4747Gj6, Switch r7, C12889fL5 c12889fL5, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        AbstractC13042fc3.i(r7, "$switchView");
        AbstractC13042fc3.i(c12889fL5, "$mxpDialog");
        c4747Gj6.D9(AbstractC12217eE5.progress_common);
        AbstractC10533bm0.d(AbstractC16751lo1.a(c4747Gj6), null, null, c4747Gj6.new b(r7, null), 3, null);
        r7.setChecked(true);
        MY my = (MY) c12889fL5.a;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(C12889fL5 c12889fL5, Switch r1, View view) {
        AbstractC13042fc3.i(c12889fL5, "$mxpDialog");
        AbstractC13042fc3.i(r1, "$switchView");
        MY my = (MY) c12889fL5.a;
        if (my != null) {
            my.o();
        }
        r1.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C18489ok6 Na() {
        return (C18489ok6) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        c4747Gj6.Ra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(Activity activity, final C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(activity, "$parent");
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        new AlertDialog.Builder(activity, AbstractC23035wE5.AlertDialogStyle).setMessage(AbstractC12217eE5.security_terminate_message).setNegativeButton(AbstractC12217eE5.dialog_yes, new DialogInterface.OnClickListener() { // from class: ir.nasim.Dj6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C4747Gj6.Qa(this.a, dialogInterface, i2);
            }
        }).setPositiveButton(AbstractC12217eE5.dialog_no, (DialogInterface.OnClickListener) null).show().getButton(-2).setTextColor(C5495Jo7.a.B0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(C4747Gj6 c4747Gj6, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        AbstractC10533bm0.d(AbstractC16751lo1.a(c4747Gj6), null, null, c4747Gj6.new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ra() {
        TextView textView = this.loading;
        if (textView != null) {
            textView.setText(AbstractC12217eE5.security_authorized_loading);
        }
        TextView textView2 = this.loading;
        if (textView2 != null) {
            textView2.setClickable(true);
        }
        L9(this.loading, false);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new d(null), 3, null);
    }

    private final LinearLayout ma(Activity parent) {
        LinearLayout linearLayout = new LinearLayout(parent);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.na(this.a, view);
            }
        });
        TextView textView = new TextView(parent);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.call_header);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(C14433hu3.d(-1, -2));
        TextView textView2 = new TextView(parent);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(AbstractC12217eE5.call_hint);
        textView2.setGravity(8388611);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTypeface(C6011Lu2.k());
        textView2.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        C22042ua0.A9(c4747Gj6, C20421rz0.INSTANCE.a(), false, null, 6, null);
    }

    private final LinearLayout oa(Activity parent) {
        LinearLayout linearLayout = new LinearLayout(parent);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Bj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.pa(this.a, view);
            }
        });
        TextView textView = new TextView(parent);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.cardToCardPolicy_header);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(C14433hu3.d(-1, -2));
        TextView textView2 = new TextView(parent);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(AbstractC12217eE5.cardToCardPolicy_hint);
        textView2.setGravity(8388611);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTypeface(C6011Lu2.k());
        textView2.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        C22042ua0.A9(c4747Gj6, C21197tH0.INSTANCE.a(), false, null, 6, null);
    }

    private final LinearLayout qa(Activity parent) {
        LinearLayout linearLayout = new LinearLayout(parent);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.ra(this.a, view);
            }
        });
        TextView textView = new TextView(parent);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.deleteAccount_header);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(C14433hu3.d(-1, -2));
        TextView textView2 = new TextView(parent);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(AbstractC12217eE5.deleteAccount_hint);
        textView2.setGravity(8388611);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTypeface(C6011Lu2.k());
        textView2.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        C22042ua0.A9(c4747Gj6, C13467gH1.INSTANCE.a(), false, null, 6, null);
    }

    private final LinearLayout sa(Activity parent) {
        LinearLayout linearLayout = new LinearLayout(parent);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Aj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.ta(this.a, view);
            }
        });
        TextView textView = new TextView(parent);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.inviteToGroup_header);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(C14433hu3.d(-1, -2));
        TextView textView2 = new TextView(parent);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(AbstractC12217eE5.inviteToGroup_hint);
        textView2.setGravity(8388611);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTypeface(C6011Lu2.k());
        textView2.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        C22042ua0.A9(c4747Gj6, C20215re3.INSTANCE.a(), false, null, 6, null);
    }

    private final LinearLayout ua(Activity parent) {
        LinearLayout linearLayout = new LinearLayout(parent);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.uj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.va(this.a, view);
            }
        });
        TextView textView = new TextView(parent);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.lastseen_header);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(C14433hu3.d(-1, -2));
        TextView textView2 = new TextView(parent);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(AbstractC12217eE5.lastseen_hint);
        textView2.setGravity(8388611);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTypeface(C6011Lu2.k());
        textView2.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        C22042ua0.A9(c4747Gj6, C5068Ht3.INSTANCE.a(), false, null, 6, null);
    }

    private final LinearLayout wa(Activity parent) {
        LinearLayout linearLayout = new LinearLayout(parent);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.xa(this.a, view);
            }
        });
        TextView textView = new TextView(parent);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.passcode_header);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(C14433hu3.d(-1, -2));
        TextView textView2 = new TextView(parent);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(AbstractC12217eE5.passcode_hint);
        textView2.setGravity(8388611);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTypeface(C6011Lu2.k());
        textView2.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        if (C23073wI7.n) {
            C22042ua0.A9(c4747Gj6, C18951pX4.INSTANCE.a(false), false, null, 6, null);
        } else {
            C22042ua0.A9(c4747Gj6, C22019uX4.INSTANCE.a(), false, null, 6, null);
        }
    }

    private final LinearLayout ya(Activity parent) {
        LinearLayout linearLayout = new LinearLayout(parent);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.za(this.a, view);
            }
        });
        TextView textView = new TextView(parent);
        textView.setTextSize(2, 17.0f);
        textView.setText(AbstractC12217eE5.story);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.g1());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(C14433hu3.d(-1, -2));
        TextView textView2 = new TextView(parent);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(AbstractC12217eE5.story_privacy_settings_info);
        textView2.setGravity(8388611);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTypeface(C6011Lu2.k());
        textView2.setLayoutParams(C14433hu3.d(-1, -2));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(C4747Gj6 c4747Gj6, View view) {
        AbstractC13042fc3.i(c4747Gj6, "this$0");
        C22042ua0.A9(c4747Gj6, c4747Gj6.Ma().d(), false, null, 6, null);
    }

    public final InterfaceC23238wb0 La() {
        InterfaceC23238wb0 interfaceC23238wb0 = this.baseSettingsNavigator;
        if (interfaceC23238wb0 != null) {
            return interfaceC23238wb0;
        }
        AbstractC13042fc3.y("baseSettingsNavigator");
        return null;
    }

    public final InterfaceC7565Sg3 Ma() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.jaryanNavigator;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i2;
        AbstractC13042fc3.i(inflater, "inflater");
        View viewInflate = inflater.inflate(AbstractC12208eD5.fr_settings_encryption, container, false);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewInflate.setBackgroundColor(c5495Jo7.o());
        final FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(BC5.linearContainer);
        LinearLayout linearLayoutWa = wa(fragmentActivityQ7);
        LinearLayout linearLayoutMa = ma(fragmentActivityQ7);
        LinearLayout linearLayoutYa = ya(fragmentActivityQ7);
        LinearLayout linearLayoutSa = sa(fragmentActivityQ7);
        LinearLayout linearLayoutUa = ua(fragmentActivityQ7);
        LinearLayout linearLayoutAa = Aa(fragmentActivityQ7);
        LinearLayout linearLayoutQa = this.isDeleteAccountEnable ? qa(fragmentActivityQ7) : null;
        LinearLayout linearLayoutOa = oa(fragmentActivityQ7);
        linearLayout.addView(linearLayoutSa, 1);
        linearLayout.addView(linearLayoutUa, 2);
        linearLayout.addView(linearLayoutOa, 3);
        linearLayout.addView(linearLayoutMa, 4);
        linearLayout.addView(linearLayoutYa, 5);
        linearLayout.addView(Ca(fragmentActivityQ7), 6);
        linearLayout.addView(linearLayoutWa, 7);
        if (C8386Vt0.a.Nb()) {
            linearLayout.addView(Ca(fragmentActivityQ7), 8);
            linearLayout.addView(linearLayoutAa, 9);
            i2 = 10;
        } else {
            i2 = 8;
        }
        View viewGa = Ga(fragmentActivityQ7);
        linearLayout.addView(Ca(fragmentActivityQ7), i2);
        int i3 = i2 + 2;
        linearLayout.addView(viewGa, i2 + 1);
        if (C8386Vt0.Y7()) {
            View viewDa = Da(fragmentActivityQ7);
            linearLayout.addView(Ca(fragmentActivityQ7), i3);
            i3 = i2 + 4;
            linearLayout.addView(viewDa, i2 + 3);
        }
        int i4 = i3 + 1;
        linearLayout.addView(Ca(fragmentActivityQ7), i3);
        if (this.isDeleteAccountEnable) {
            linearLayout.addView(linearLayoutQa, i4);
            linearLayout.addView(Ca(fragmentActivityQ7), i3 + 2);
        }
        viewInflate.findViewById(BC5.big_divider).setBackgroundColor(c5495Jo7.o());
        View viewFindViewById = viewInflate.findViewById(BC5.security_settings_title);
        AbstractC13042fc3.g(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setTextColor(c5495Jo7.W0());
        TextView textView = (TextView) viewInflate.findViewById(BC5.loading);
        textView.setTextColor(c5495Jo7.g0());
        textView.setVisibility(8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.Oa(this.a, view);
            }
        });
        this.loading = textView;
        View viewFindViewById2 = viewInflate.findViewById(BC5.authItems);
        AbstractC13042fc3.g(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.authItems = (LinearLayout) viewFindViewById2;
        viewInflate.findViewById(BC5.divider).setBackgroundColor(c5495Jo7.o());
        linearLayout.setBackgroundColor(c5495Jo7.O0());
        viewInflate.findViewById(BC5.terminateSessions).setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        viewInflate.findViewById(BC5.terminateSessions).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xj6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4747Gj6.Pa(fragmentActivityQ7, this, view);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(BC5.settings_terminate_sessions_title);
        AbstractC13042fc3.g(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById3).setTextColor(c5495Jo7.g1());
        View viewFindViewById4 = viewInflate.findViewById(BC5.settings_terminate_sessions_hint);
        AbstractC13042fc3.g(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById4).setTextColor(c5495Jo7.f1());
        Ra();
        View viewFindViewById5 = viewInflate.findViewById(BC5.security_settings_toolbar);
        AbstractC13042fc3.g(viewFindViewById5, "null cannot be cast to non-null type ir.nasim.components.appbar.view.BaleToolbar");
        FragmentActivity fragmentActivityQ72 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ72, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default((BaleToolbar) viewFindViewById5, fragmentActivityQ72, true, false, 4, null);
        return viewInflate;
    }
}
