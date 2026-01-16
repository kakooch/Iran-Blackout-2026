package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.AQ6;
import ir.nasim.AbstractC23640xG2;
import ir.nasim.W9;
import ir.nasim.core.network.RpcTimeoutException;
import ir.nasim.story.ui.storyadder.StoryAdderSourceCallerEnum;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001NB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J!\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001dH\u0016¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001d¢\u0006\u0004\b+\u0010)R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010*\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020\"8\u0002X\u0082D¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lir/nasim/AQ6;", "Lir/nasim/ua0;", "Lir/nasim/eK4;", "<init>", "()V", "Lir/nasim/rB7;", "ma", "ia", "da", "qa", "ha", "pa", "ra", "la", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "i9", "T6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "na", "", "ga", "()Z", "Lir/nasim/eR6;", "item", "", "position", "K2", "(Lir/nasim/eR6;I)V", "r", ParameterNames.HIDDEN, "W6", "(Z)V", "fromTooltip", "oa", "Lir/nasim/wz2;", "h1", "Lir/nasim/bW7;", "ja", "()Lir/nasim/wz2;", "binding", "Lir/nasim/YO6;", "i1", "Lir/nasim/YO6;", "storyAdapter", "Lir/nasim/OQ6;", "j1", "Lir/nasim/OQ6;", "storyHeaderAdapter", "k1", "Z", "Lir/nasim/bX6;", "l1", "Lir/nasim/Yu3;", "ka", "()Lir/nasim/bX6;", "viewModel", "m1", TokenNames.I, "LIST_SIZE_TO_START_SCROLL", "Lir/nasim/wV6;", "n1", "Lir/nasim/wV6;", "storyToJaryan", "Landroidx/recyclerview/widget/RecyclerView$o;", "o1", "Landroidx/recyclerview/widget/RecyclerView$o;", "storyItemDecoration", "p1", "a", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class AQ6 extends RX2 implements InterfaceC12270eK4 {

    /* renamed from: i1, reason: from kotlin metadata */
    private YO6 storyAdapter;

    /* renamed from: j1, reason: from kotlin metadata */
    private OQ6 storyHeaderAdapter;

    /* renamed from: k1, reason: from kotlin metadata */
    private boolean fromTooltip;

    /* renamed from: n1, reason: from kotlin metadata */
    private InterfaceC23189wV6 storyToJaryan;

    /* renamed from: o1, reason: from kotlin metadata */
    private RecyclerView.o storyItemDecoration;
    static final /* synthetic */ InterfaceC5239Im3[] q1 = {AbstractC10882cM5.i(new C25226zw5(AQ6.class, "binding", "getBinding()Lir/nasim/story/databinding/FragmentStoryBinding;", 0))};
    public static final int r1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new f(), AbstractC20046rN7.c());

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.zQ6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AQ6.sa(this.a);
        }
    });

    /* renamed from: m1, reason: from kotlin metadata */
    private final int LIST_SIZE_TO_START_SCROLL = 5;

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ AQ6 a;

            a(AQ6 aq6) {
                this.a = aq6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(W9 w9, InterfaceC20295rm1 interfaceC20295rm1) {
                InterfaceC23189wV6 interfaceC23189wV6;
                if (AbstractC13042fc3.d(w9, W9.a.a) && (interfaceC23189wV6 = this.a.storyToJaryan) != null) {
                    String strH6 = this.a.h6(AbstractC12217eE5.story_add_story_restricted_error);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    interfaceC23189wV6.U2(strH6);
                }
                return C19938rB7.a;
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AQ6.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6A3 = AQ6.this.ka().A3();
                a aVar = new a(AQ6.this);
                this.b = 1;
                if (interfaceC10258bL6A3.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class c extends RecyclerView.o {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        private static final void l(int i, Rect rect, int i2) {
            if (i == 0) {
                rect.left = AbstractC8943Xx1.c(12);
                rect.right = AbstractC8943Xx1.c(3);
            } else if (i2 <= 0 || i != i2 - 1) {
                rect.left = AbstractC8943Xx1.c(3);
                rect.right = AbstractC8943Xx1.c(3);
            } else {
                rect.left = AbstractC8943Xx1.c(3);
                rect.right = AbstractC8943Xx1.c(12);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
            int i;
            AbstractC13042fc3.i(rect, "outRect");
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(recyclerView, "parent");
            AbstractC13042fc3.i(zVar, "state");
            super.g(rect, view, recyclerView, zVar);
            int iB = zVar.b();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == -1) {
                return;
            }
            if (!C8386Vt0.a.cb()) {
                l(childAdapterPosition, rect, iB);
                return;
            }
            int width = recyclerView.getWidth();
            if (width == 0 || (i = this.a) == 0) {
                return;
            }
            int iE = AbstractC23053wG5.e((width - (i * iB)) / (iB + 1), 0);
            if (iE < 3) {
                l(childAdapterPosition, rect, iB);
            } else {
                rect.left = iE;
            }
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ AQ6 a;

            a(AQ6 aq6) {
                this.a = aq6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 g(AQ6 aq6) {
                AbstractC13042fc3.i(aq6, "this$0");
                aq6.na();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object a(AbstractC23640xG2 abstractC23640xG2, InterfaceC20295rm1 interfaceC20295rm1) {
                C12335eR6 c12335eR6;
                InterfaceC23189wV6 interfaceC23189wV6 = this.a.storyToJaryan;
                if (interfaceC23189wV6 != null) {
                    interfaceC23189wV6.A0();
                }
                this.a.la();
                if ((abstractC23640xG2 instanceof AbstractC23640xG2.a) && !(((AbstractC23640xG2.a) abstractC23640xG2).a() instanceof RpcTimeoutException)) {
                    InterfaceC23189wV6 interfaceC23189wV62 = this.a.storyToJaryan;
                    if (interfaceC23189wV62 != null) {
                        String strH6 = this.a.h6(SD5.story_get_story_server_error);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        final AQ6 aq6 = this.a;
                        InterfaceC23189wV6.u3(interfaceC23189wV62, strH6, null, new SA2() { // from class: ir.nasim.BQ6
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AQ6.d.a.g(aq6);
                            }
                        }, 2, null);
                    }
                    C19406qI3.a("story", "S E L U", new Object[0]);
                    this.a.ka().v5();
                } else if (abstractC23640xG2 instanceof AbstractC23640xG2.b) {
                    C19406qI3.a("story", "S L U", new Object[0]);
                    AbstractC23640xG2.b bVar = (AbstractC23640xG2.b) abstractC23640xG2;
                    Object objA = bVar.a();
                    AQ6 aq62 = this.a;
                    C18502om c18502om = (C18502om) objA;
                    OQ6 oq6 = aq62.storyHeaderAdapter;
                    if (oq6 != null) {
                        List<C12335eR6> listE = AbstractC9766aX0.e(c18502om.d());
                        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listE, 10));
                        for (C12335eR6 c12335eR62 : listE) {
                            if (c12335eR62 == null) {
                                c12335eR6 = null;
                            } else {
                                C11692dR6 c11692dR6B = c12335eR62.b();
                                QQ6 qq6A = c12335eR62.a();
                                c12335eR6 = new C12335eR6(c11692dR6B, qq6A.b((1048575 & 1) != 0 ? qq6A.a : 0L, (1048575 & 2) != 0 ? qq6A.b : null, (1048575 & 4) != 0 ? qq6A.c : null, (1048575 & 8) != 0 ? qq6A.d : null, (1048575 & 16) != 0 ? qq6A.e : 0L, (1048575 & 32) != 0 ? qq6A.f : 0, (1048575 & 64) != 0 ? qq6A.g : null, (1048575 & 128) != 0 ? qq6A.h : null, (1048575 & 256) != 0 ? qq6A.i : null, (1048575 & 512) != 0 ? qq6A.j : null, (1048575 & 1024) != 0 ? qq6A.k : null, (1048575 & 2048) != 0 ? qq6A.l : false, (1048575 & 4096) != 0 ? qq6A.m : null, (1048575 & 8192) != 0 ? qq6A.n : null, (1048575 & 16384) != 0 ? qq6A.o : false, (1048575 & 32768) != 0 ? qq6A.p : null, (1048575 & 65536) != 0 ? qq6A.q : false, (1048575 & 131072) != 0 ? qq6A.r : null, (1048575 & 262144) != 0 ? qq6A.s : null, (1048575 & 524288) != 0 ? qq6A.t : null));
                            }
                            arrayList.add(c12335eR6);
                        }
                        oq6.C(arrayList);
                    }
                    YO6 yo6 = aq62.storyAdapter;
                    if (yo6 != null) {
                        List<C12335eR6> listR0 = AbstractC15401jX0.R0(AbstractC15401jX0.R0(AbstractC15401jX0.R0(c18502om.c(), c18502om.b()), c18502om.e()), c18502om.f());
                        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listR0, 10));
                        for (C12335eR6 c12335eR63 : listR0) {
                            C11692dR6 c11692dR6B2 = c12335eR63.b();
                            QQ6 qq6A2 = c12335eR63.a();
                            arrayList2.add(new C12335eR6(c11692dR6B2, qq6A2.b((1048575 & 1) != 0 ? qq6A2.a : 0L, (1048575 & 2) != 0 ? qq6A2.b : null, (1048575 & 4) != 0 ? qq6A2.c : null, (1048575 & 8) != 0 ? qq6A2.d : null, (1048575 & 16) != 0 ? qq6A2.e : 0L, (1048575 & 32) != 0 ? qq6A2.f : 0, (1048575 & 64) != 0 ? qq6A2.g : null, (1048575 & 128) != 0 ? qq6A2.h : null, (1048575 & 256) != 0 ? qq6A2.i : null, (1048575 & 512) != 0 ? qq6A2.j : null, (1048575 & 1024) != 0 ? qq6A2.k : null, (1048575 & 2048) != 0 ? qq6A2.l : false, (1048575 & 4096) != 0 ? qq6A2.m : null, (1048575 & 8192) != 0 ? qq6A2.n : null, (1048575 & 16384) != 0 ? qq6A2.o : false, (1048575 & 32768) != 0 ? qq6A2.p : null, (1048575 & 65536) != 0 ? qq6A2.q : false, (1048575 & 131072) != 0 ? qq6A2.r : null, (1048575 & 262144) != 0 ? qq6A2.s : null, (1048575 & 524288) != 0 ? qq6A2.t : null)));
                        }
                        yo6.C(arrayList2);
                    }
                    AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -1);
                    if (((C18502om) bVar.a()).a().size() < this.a.LIST_SIZE_TO_START_SCROLL) {
                        layoutParams.g(0);
                    } else {
                        layoutParams.g(1);
                    }
                    this.a.qa();
                }
                return C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AQ6.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(AQ6.this.ka().H3());
                a aVar = new a(AQ6.this);
                this.b = 1;
                if (interfaceC4557Fq2F.b(aVar, this) == objE) {
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
        Object b;
        Object c;
        int d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AQ6.this.new e(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.d
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 != r3) goto L18
                java.lang.Object r0 = r10.c
                android.view.View r0 = (android.view.View) r0
                java.lang.Object r1 = r10.b
                ir.nasim.AQ6 r1 = (ir.nasim.AQ6) r1
                ir.nasim.AbstractC10685c16.b(r11)
                goto L5e
            L18:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L20:
                ir.nasim.AbstractC10685c16.b(r11)
                ir.nasim.Vt0 r11 = ir.nasim.C8386Vt0.a
                boolean r11 = r11.W6()
                if (r11 == 0) goto L97
                ir.nasim.AQ6 r11 = ir.nasim.AQ6.this
                ir.nasim.bX6 r11 = ir.nasim.AQ6.aa(r11)
                boolean r11 = r11.L3()
                if (r11 != 0) goto L97
                ir.nasim.AQ6 r11 = ir.nasim.AQ6.this
                ir.nasim.wz2 r11 = ir.nasim.AQ6.V9(r11)
                androidx.recyclerview.widget.RecyclerView r11 = r11.c
                int r1 = ir.nasim.AbstractC18172oC5.own_story_layout
                android.view.View r11 = r11.findViewById(r1)
                if (r11 == 0) goto L97
                ir.nasim.AQ6 r1 = ir.nasim.AQ6.this
                ir.nasim.wV6 r4 = ir.nasim.AQ6.Z9(r1)
                if (r4 == 0) goto L69
                r10.b = r1
                r10.c = r11
                r10.d = r3
                java.lang.Object r4 = r4.q1(r10)
                if (r4 != r0) goto L5c
                return r0
            L5c:
                r0 = r11
                r11 = r4
            L5e:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                r5 = r0
                if (r11 != r3) goto L6a
                r2 = r3
                goto L6a
            L69:
                r5 = r11
            L6a:
                if (r2 == 0) goto L97
                ir.nasim.bs7 r11 = ir.nasim.C10600bs7.a
                ir.nasim.D20$a r11 = r11.c(r1)
                r0 = 1048576000(0x3e800000, float:0.25)
                r11.a1(r0)
                int r0 = ir.nasim.SD5.story_hafez_faal_tooltip_text
                java.lang.String r0 = r1.h6(r0)
                java.lang.String r2 = "getString(...)"
                ir.nasim.AbstractC13042fc3.h(r0, r2)
                r11.X1(r0)
                ir.nasim.D20 r4 = r11.a()
                r8 = 6
                r9 = 0
                r6 = 0
                r7 = 0
                ir.nasim.D20.K0(r4, r5, r6, r7, r8, r9)
                ir.nasim.bX6 r11 = ir.nasim.AQ6.aa(r1)
                r11.N5()
            L97:
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AQ6.e.invokeSuspend(java.lang.Object):java.lang.Object");
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
            return C23476wz2.a(fragment.V7());
        }
    }

    private final void da() {
        final RecyclerView recyclerView = ja().c;
        recyclerView.setLayoutManager(new LinearLayoutManager(S7(), 0, true));
        recyclerView.setAdapter(new androidx.recyclerview.widget.f(this.storyHeaderAdapter, this.storyAdapter));
        RecyclerView.o oVar = this.storyItemDecoration;
        if (oVar == null) {
            AbstractC13042fc3.y("storyItemDecoration");
            oVar = null;
        }
        recyclerView.addItemDecoration(oVar);
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ir.nasim.yQ6
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AQ6.ea(recyclerView, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        recyclerView.setLayoutDirection(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(final RecyclerView recyclerView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AbstractC13042fc3.i(recyclerView, "$this_with");
        if (!C8386Vt0.a.cb() || i7 - i5 == i3 - i) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: ir.nasim.xQ6
            @Override // java.lang.Runnable
            public final void run() {
                AQ6.fa(recyclerView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "$this_with");
        recyclerView.invalidateItemDecorations();
        recyclerView.requestLayout();
    }

    private final void ha() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(null), 3, null);
    }

    private final void ia() {
        this.storyItemDecoration = new c(b6().getDimensionPixelSize(AbstractC14008hB5.story_item_width));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C23476wz2 ja() {
        Object objA = this.binding.a(this, q1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C23476wz2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 ka() {
        return (C10366bX6) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
        ja().b.setVisibility(8);
        ja().c.setVisibility(0);
    }

    private final void ma() {
        ia();
        da();
    }

    private final void pa() {
        this.storyAdapter = new YO6(this);
        this.storyHeaderAdapter = new OQ6(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new e(null), 3, null);
    }

    private final void ra() {
        ja().b.setVisibility(0);
        ja().c.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 sa(AQ6 aq6) {
        AbstractC13042fc3.i(aq6, "this$0");
        FragmentActivity fragmentActivityQ7 = aq6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    @Override // ir.nasim.InterfaceC12270eK4
    public void K2(C12335eR6 item, int position) {
        AbstractC13042fc3.i(item, "item");
        C22042ua0 c22042ua0A = MW6.INSTANCE.a(item.b().a(), ka().I4(item.b()), (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : WV6.c, (60 & 32) != 0 ? -1 : position);
        Fragment fragmentU5 = U5();
        AbstractC22105ug3 abstractC22105ug3 = fragmentU5 instanceof AbstractC22105ug3 ? (AbstractC22105ug3) fragmentU5 : null;
        if (abstractC22105ug3 != null) {
            abstractC22105ug3.Q9();
        }
        C22042ua0.w9(this, c22042ua0A, false, null, 6, null);
        if (this.fromTooltip) {
            ka().I5();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        FrameLayout root = C23476wz2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        ka().d6();
    }

    @Override // androidx.fragment.app.Fragment
    public void W6(boolean hidden) {
        super.W6(hidden);
        if (hidden) {
            return;
        }
        na();
    }

    public final boolean ga() {
        return ka().M2();
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        ka().Y4();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        androidx.lifecycle.h hVarU5 = U5();
        this.storyToJaryan = hVarU5 instanceof InterfaceC23189wV6 ? (InterfaceC23189wV6) hVarU5 : null;
        ha();
        pa();
        ma();
        if (ka().H3().getValue() instanceof AbstractC23640xG2.a) {
            ka().v5();
        }
        AbstractC19455qN7.g(this, null, new d(null), 1, null);
        ra();
        ka().g4();
    }

    public final void na() {
        List listZ;
        YO6 yo6 = this.storyAdapter;
        if (yo6 != null && (listZ = yo6.z()) != null && listZ.isEmpty()) {
            ra();
        }
        ka().g4();
    }

    public final void oa(boolean fromTooltip) {
        this.fromTooltip = fromTooltip;
    }

    @Override // ir.nasim.InterfaceC12270eK4
    public void r() {
        Fragment fragmentU5 = U5();
        AbstractC22105ug3 abstractC22105ug3 = fragmentU5 instanceof AbstractC22105ug3 ? (AbstractC22105ug3) fragmentU5 : null;
        if (abstractC22105ug3 != null) {
            abstractC22105ug3.Q9();
        }
        ka().T5(ka().T3());
        x9(C20672sP6.INSTANCE.a(StoryAdderSourceCallerEnum.c));
    }
}
