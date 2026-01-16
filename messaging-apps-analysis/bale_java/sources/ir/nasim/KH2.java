package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.features.smiles.panel.gif.GifPreviewView;
import ir.nasim.features.smiles.panel.gif.GifRecyclerView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001\u001bB\u001f\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u0017J\u000f\u0010\u001e\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u0017J\u0017\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00132\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0013H\u0002¢\u0006\u0004\b'\u0010\u0017J\u000f\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010A\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u00107\u001a\u0004\b@\u0010\u001cR\u0016\u0010D\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lir/nasim/KH2;", "Landroidx/fragment/app/Fragment;", "Lir/nasim/DF6;", "Lir/nasim/CF6;", "smilesKeyboardListener", "Lir/nasim/EF6;", "smilesPanelListener", "<init>", "(Lir/nasim/CF6;Lir/nasim/EF6;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "()V", "k7", "T6", "", "a", "()Z", "onClose", "o4", "", ParameterNames.TEXT, "e9", "(Ljava/lang/String;)V", "Lir/nasim/QG2;", "gif", "f9", "(Lir/nasim/QG2;)V", "P8", "Landroidx/viewpager2/widget/ViewPager2;", "N8", "()Landroidx/viewpager2/widget/ViewPager2;", "b1", "Lir/nasim/CF6;", "c1", "Lir/nasim/EF6;", "Lir/nasim/oz2;", "d1", "Lir/nasim/bW7;", "M8", "()Lir/nasim/oz2;", "binding", "Lir/nasim/fI2;", "e1", "Lir/nasim/Yu3;", "O8", "()Lir/nasim/fI2;", "gifViewModel", "Lir/nasim/UG2;", "f1", "Lir/nasim/UG2;", "gifAdapter", "g1", "V8", "isComment", "h1", "Z", "isPreviewShowing", "Landroid/app/Dialog;", "i1", "Landroid/app/Dialog;", "gifPreviewDialog", "Lir/nasim/features/smiles/panel/gif/GifPreviewView;", "j1", "Lir/nasim/features/smiles/panel/gif/GifPreviewView;", "gifPreviewView", "k1", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class KH2 extends NW2 implements DF6 {

    /* renamed from: b1, reason: from kotlin metadata */
    private CF6 smilesKeyboardListener;

    /* renamed from: c1, reason: from kotlin metadata */
    private EF6 smilesPanelListener;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: e1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 gifViewModel;

    /* renamed from: f1, reason: from kotlin metadata */
    private UG2 gifAdapter;

    /* renamed from: g1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 isComment;

    /* renamed from: h1, reason: from kotlin metadata */
    private boolean isPreviewShowing;

    /* renamed from: i1, reason: from kotlin metadata */
    private Dialog gifPreviewDialog;

    /* renamed from: j1, reason: from kotlin metadata */
    private GifPreviewView gifPreviewView;
    static final /* synthetic */ InterfaceC5239Im3[] l1 = {AbstractC10882cM5.i(new C25226zw5(KH2.class, "binding", "getBinding()Lir/nasim/databinding/FragmentSmilesGifBinding;", 0))};

    /* renamed from: k1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m1 = 8;

    /* renamed from: ir.nasim.KH2$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final KH2 a(CF6 cf6, EF6 ef6, W25 w25, int i, boolean z, boolean z2) {
            AbstractC13042fc3.i(w25, "peerType");
            KH2 kh2 = new KH2(cf6, ef6);
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_PEER_TYPE", w25.ordinal());
            bundle.putInt("ARG_PEER_ID", i);
            bundle.putBoolean("ARG_IS_COMMENT", z);
            bundle.putBoolean("ARG_force_night_mode", z2);
            kh2.a8(bundle);
            return kh2;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ KH2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(KH2 kh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = kh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((EM2) this.c) == EM2.a) {
                    C18632oz2 c18632oz2M8 = this.d.M8();
                    c18632oz2M8.f.setVisibility(8);
                    c18632oz2M8.e.setVisibility(0);
                    c18632oz2M8.g.setVisibility(0);
                    c18632oz2M8.c.setVisibility(0);
                    c18632oz2M8.d.setVisibility(0);
                } else {
                    KH2 kh2 = this.d;
                    String strH6 = kh2.h6(kh2.V8() ? AbstractC12217eE5.no_stickers_permissoin_for_member_comment : AbstractC12217eE5.no_stickers_permissoin_for_member);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    kh2.e9(strH6);
                    C18632oz2 c18632oz2M82 = this.d.M8();
                    c18632oz2M82.f.setVisibility(0);
                    c18632oz2M82.b.setVisibility(8);
                    c18632oz2M82.e.setVisibility(8);
                    c18632oz2M82.g.setVisibility(8);
                    c18632oz2M82.c.setVisibility(8);
                    c18632oz2M82.d.setVisibility(8);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EM2 em2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(em2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.KH2$b$b, reason: collision with other inner class name */
        public static final class C0457b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.KH2$b$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.KH2$b$b$a$a, reason: collision with other inner class name */
                public static final class C0458a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0458a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.KH2.b.C0457b.a.C0458a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.KH2$b$b$a$a r0 = (ir.nasim.KH2.b.C0457b.a.C0458a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.KH2$b$b$a$a r0 = new ir.nasim.KH2$b$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.pH2 r5 = (ir.nasim.C18805pH2) r5
                        ir.nasim.EM2 r5 = r5.c()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KH2.b.C0457b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public C0457b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KH2.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new C0457b(KH2.this.O8().e1()));
                a aVar = new a(KH2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ KH2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(KH2 kh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = kh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c && this.d.M8().f.getVisibility() == 8) {
                    this.d.M8().b.setVisibility(0);
                    this.d.M8().e.setVisibility(8);
                } else if (this.d.M8().f.getVisibility() == 8) {
                    this.d.M8().b.setVisibility(8);
                    this.d.M8().e.setVisibility(0);
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.KH2$c$b$a$a, reason: collision with other inner class name */
                public static final class C0459a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0459a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.KH2.c.b.a.C0459a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.KH2$c$b$a$a r0 = (ir.nasim.KH2.c.b.a.C0459a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.KH2$c$b$a$a r0 = new ir.nasim.KH2$c$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.pH2 r5 = (ir.nasim.C18805pH2) r5
                        boolean r5 = r5.b()
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KH2.c.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KH2.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new b(KH2.this.O8().e1()));
                a aVar = new a(KH2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ KH2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(KH2 kh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = kh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Integer num = (Integer) this.c;
                if (num != null) {
                    KH2 kh2 = this.d;
                    int iIntValue = num.intValue();
                    androidx.lifecycle.h hVarU5 = kh2.U5();
                    InterfaceC15850kH2 interfaceC15850kH2 = hVarU5 instanceof InterfaceC15850kH2 ? (InterfaceC15850kH2) hVarU5 : null;
                    if (interfaceC15850kH2 != null) {
                        String strH6 = kh2.h6(iIntValue);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        InterfaceC15850kH2.d3(interfaceC15850kH2, strH6, null, 2, null);
                    }
                    kh2.O8().v1(null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Integer num, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(num, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.KH2$d$b$a$a, reason: collision with other inner class name */
                public static final class C0460a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0460a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.KH2.d.b.a.C0460a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.KH2$d$b$a$a r0 = (ir.nasim.KH2.d.b.a.C0460a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.KH2$d$b$a$a r0 = new ir.nasim.KH2$d$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.pH2 r5 = (ir.nasim.C18805pH2) r5
                        java.lang.Integer r5 = r5.d()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KH2.d.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KH2.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new b(KH2.this.O8().e1()));
                a aVar = new a(KH2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ KH2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(KH2 kh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = kh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = (List) this.c;
                UG2 ug2 = this.d.gifAdapter;
                if (ug2 != null) {
                    ug2.C(list);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.KH2$e$b$a$a, reason: collision with other inner class name */
                public static final class C0461a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0461a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.KH2.e.b.a.C0461a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.KH2$e$b$a$a r0 = (ir.nasim.KH2.e.b.a.C0461a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.KH2$e$b$a$a r0 = new ir.nasim.KH2$e$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.pH2 r5 = (ir.nasim.C18805pH2) r5
                        java.util.List r5 = r5.a()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KH2.e.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KH2.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new b(KH2.this.O8().e1()));
                a aVar = new a(KH2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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

    public static final class f extends AbstractC8614Ws3 implements UA2 {
        public f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C18632oz2.a(fragment.V7());
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public KH2() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C18632oz2 M8() {
        Object objA = this.binding.a(this, l1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C18632oz2) objA;
    }

    private final ViewPager2 N8() {
        ViewParent parent = M8().getRoot().getParent().getParent().getParent();
        AbstractC13042fc3.g(parent, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        return (ViewPager2) parent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12859fI2 O8() {
        return (C12859fI2) this.gifViewModel.getValue();
    }

    private final void P8() {
        Dialog dialog = new Dialog(S7());
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 48;
            layoutParams.windowAnimations = AbstractC23035wE5.previewDialogAnimation;
            window.setAttributes(layoutParams);
        }
        dialog.setCancelable(true);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.nasim.IH2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                KH2.Q8(this.a, dialogInterface);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.JH2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                KH2.R8(this.a, dialogInterface);
            }
        });
        this.gifPreviewDialog = dialog;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        GifPreviewView gifPreviewView = new GifPreviewView(contextS7, null, 0, new SA2() { // from class: ir.nasim.yH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KH2.S8(this.a);
            }
        }, new UA2() { // from class: ir.nasim.zH2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return KH2.T8(this.a, (QG2) obj);
            }
        }, new UA2() { // from class: ir.nasim.AH2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return KH2.U8(this.a, (QG2) obj);
            }
        }, 6, null);
        gifPreviewView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        gifPreviewView.bringToFront();
        Dialog dialog2 = this.gifPreviewDialog;
        if (dialog2 != null) {
            dialog2.setContentView(gifPreviewView, new LinearLayout.LayoutParams(-1, -1));
        }
        this.gifPreviewView = gifPreviewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q8(KH2 kh2, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(kh2, "this$0");
        GifPreviewView gifPreviewView = kh2.gifPreviewView;
        if (gifPreviewView != null) {
            gifPreviewView.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R8(KH2 kh2, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(kh2, "this$0");
        ViewParent parent = kh2.M8().getRoot().getParent().getParent().getParent();
        AbstractC13042fc3.g(parent, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        ((ViewPager2) parent).setUserInputEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S8(KH2 kh2) {
        AbstractC13042fc3.i(kh2, "this$0");
        kh2.isPreviewShowing = false;
        Dialog dialog = kh2.gifPreviewDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T8(KH2 kh2, QG2 qg2) {
        AbstractC13042fc3.i(kh2, "this$0");
        AbstractC13042fc3.i(qg2, "it");
        CF6 cf6 = kh2.smilesKeyboardListener;
        if (cf6 != null) {
            cf6.g(qg2);
        }
        kh2.O8().w1(qg2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U8(KH2 kh2, QG2 qg2) {
        AbstractC13042fc3.i(kh2, "this$0");
        AbstractC13042fc3.i(qg2, "it");
        kh2.O8().q1(qg2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean W8(KH2 kh2) {
        AbstractC13042fc3.i(kh2, "this$0");
        Bundle bundleE5 = kh2.E5();
        if (bundleE5 != null) {
            return bundleE5.getBoolean("ARG_IS_COMMENT", false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X8(final KH2 kh2, View view) {
        AbstractC13042fc3.i(kh2, "this$0");
        kh2.O8().l1(new SA2() { // from class: ir.nasim.HH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KH2.Y8(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y8(KH2 kh2) {
        AbstractC13042fc3.i(kh2, "this$0");
        Toast.makeText(kh2.S7(), AbstractC12217eE5.toast_chat_not_found, 0).show();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z8(KH2 kh2, View view) {
        AbstractC13042fc3.i(kh2, "this$0");
        kh2.O8().u1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a9(KH2 kh2, QG2 qg2) {
        AbstractC13042fc3.i(kh2, "this$0");
        AbstractC13042fc3.i(qg2, "it");
        CF6 cf6 = kh2.smilesKeyboardListener;
        if (cf6 != null) {
            cf6.g(qg2);
        }
        kh2.O8().w1(qg2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b9(KH2 kh2, QG2 qg2) {
        AbstractC13042fc3.i(kh2, "this$0");
        AbstractC13042fc3.i(qg2, "it");
        kh2.f9(qg2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c9(KH2 kh2) {
        AbstractC13042fc3.i(kh2, "this$0");
        return kh2.isPreviewShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GifPreviewView d9(KH2 kh2) {
        AbstractC13042fc3.i(kh2, "this$0");
        return kh2.gifPreviewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e9(String text) {
        C18632oz2 c18632oz2M8 = M8();
        c18632oz2M8.f.setText(text);
        c18632oz2M8.f.setTypeface(C6011Lu2.i());
    }

    private final void f9(QG2 gif) {
        N8().setUserInputEnabled(false);
        this.isPreviewShowing = true;
        if (this.gifPreviewDialog == null) {
            P8();
        }
        Dialog dialog = this.gifPreviewDialog;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        GifPreviewView gifPreviewView = this.gifPreviewView;
        if (gifPreviewView != null) {
            gifPreviewView.i(gif);
        }
        Dialog dialog2 = this.gifPreviewDialog;
        if (dialog2 != null) {
            dialog2.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        if (R7().getBoolean("ARG_force_night_mode", false)) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            inflater = LayoutInflater.from(AbstractC20790sc5.b(contextS7, 0, 1, null));
        }
        ConstraintLayout root = C18632oz2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void T6() {
        M8().e.setAdapter(null);
        this.gifAdapter = null;
        super.T6();
    }

    public final boolean V8() {
        return ((Boolean) this.isComment.getValue()).booleanValue();
    }

    @Override // ir.nasim.DF6
    public boolean a() {
        if (v6()) {
            return false;
        }
        return O8().j1();
    }

    @Override // androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        EF6 ef6 = this.smilesPanelListener;
        if (ef6 != null) {
            ef6.a(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k7() {
        super.k7();
        GifPreviewView gifPreviewView = this.gifPreviewView;
        if (gifPreviewView != null) {
            gifPreviewView.j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        EF6 ef6;
        AbstractC13042fc3.i(view, "view");
        M8().g.setTypeface(C6011Lu2.k());
        M8().b.setTypeface(C6011Lu2.i());
        M8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xH2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KH2.X8(this.a, view2);
            }
        });
        M8().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BH2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KH2.Z8(this.a, view2);
            }
        });
        this.gifAdapter = new UG2(new UA2() { // from class: ir.nasim.CH2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return KH2.a9(this.a, (QG2) obj);
            }
        }, new UA2() { // from class: ir.nasim.DH2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(KH2.b9(this.a, (QG2) obj));
            }
        });
        GifRecyclerView gifRecyclerView = M8().e;
        gifRecyclerView.setLayoutDirection(1);
        gifRecyclerView.setLayoutManager(new GridLayoutManager(S7(), 3));
        gifRecyclerView.setAdapter(this.gifAdapter);
        gifRecyclerView.setShowPreviewStateProvider(new SA2() { // from class: ir.nasim.EH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(KH2.c9(this.a));
            }
        });
        gifRecyclerView.setShowPreviewViewProvider(new SA2() { // from class: ir.nasim.FH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return KH2.d9(this.a);
            }
        });
        j.b bVar = j.b.STARTED;
        AbstractC16751lo1.c(this, bVar, new b(null));
        AbstractC16751lo1.c(this, bVar, new c(null));
        AbstractC16751lo1.c(this, bVar, new d(null));
        AbstractC16751lo1.c(this, bVar, new e(null));
        if (O8().s1()) {
            O8().p1();
        }
        if (!O8().t1() || (ef6 = this.smilesPanelListener) == null) {
            return;
        }
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        ef6.b(interfaceC18633oz3P6);
    }

    @Override // ir.nasim.DF6
    public void onClose() {
        O8().k1();
    }

    public /* synthetic */ KH2(CF6 cf6, EF6 ef6, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? null : cf6, (i2 & 2) != 0 ? null : ef6);
    }

    public KH2(CF6 cf6, EF6 ef6) {
        this.smilesKeyboardListener = cf6;
        this.smilesPanelListener = ef6;
        this.binding = AbstractC6056Lz2.f(this, new f(), AbstractC20046rN7.c());
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new h(new g(this)));
        this.gifViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C12859fI2.class), new i(interfaceC9173Yu3B), new j(null, interfaceC9173Yu3B), new k(this, interfaceC9173Yu3B));
        this.isComment = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.GH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(KH2.W8(this.a));
            }
        });
    }

    @Override // ir.nasim.DF6
    public void o4() {
    }
}
