package ir.nasim;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C5787Kv2;
import ir.nasim.O98;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 T2\u00020\u0001:\u0001UB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001bR\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001bR\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001bR\u0018\u0010-\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010#R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00105R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R(\u0010C\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0.\u0012\u0004\u0012\u00020\u00060?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010S\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006X²\u0006\u0012\u0010G\u001a\b\u0012\u0004\u0012\u00020@0.8\nX\u008a\u0084\u0002²\u0006\u0012\u0010V\u001a\b\u0012\u0004\u0012\u00020@0.8\nX\u008a\u0084\u0002²\u0006\u0012\u0010V\u001a\b\u0012\u0004\u0012\u00020@0.8\nX\u008a\u0084\u0002²\u0006\f\u0010W\u001a\u0002038\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Kv2;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Landroid/view/View;", "view", "Lir/nasim/rB7;", "C9", "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "U6", "Lkotlin/Function0;", "s1", "Lir/nasim/SA2;", "onDismiss", "Landroidx/fragment/app/Fragment;", "t1", "Landroidx/fragment/app/Fragment;", "fragment", "Lir/nasim/d25;", "u1", "Lir/nasim/d25;", "peer", "Landroid/content/ClipData;", "v1", "copyMessage", "w1", "sharePost", "x1", "addPostToStory", "y1", "forwardedPeer", "", "Lir/nasim/J44;", "z1", "Ljava/util/List;", "messages", "", "A1", "Z", "shouldShowToast", "B1", "showSharingOptions", "C1", "canAddToStory", "Lir/nasim/n0;", "D1", "Lir/nasim/n0;", "content", "Lkotlin/Function1;", "Lir/nasim/Tw2;", "E1", "Lir/nasim/UA2;", "onSuccess", "Landroidx/compose/ui/platform/ComposeView;", "F1", "Landroidx/compose/ui/platform/ComposeView;", DialogEntity.TABLE_NAME, "G1", "sharingOptions", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "H1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "behavior", "Lir/nasim/Et4;", "I1", "Lir/nasim/Yu3;", "z9", "()Lir/nasim/Et4;", "viewModel", "J1", "a", "selectedDialogs", "isDownloaded", "chat_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Kv2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5787Kv2 extends LW2 {

    /* renamed from: J1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int K1 = 8;

    /* renamed from: A1, reason: from kotlin metadata */
    private boolean shouldShowToast;

    /* renamed from: C1, reason: from kotlin metadata */
    private boolean canAddToStory;

    /* renamed from: D1, reason: from kotlin metadata */
    private AbstractC17457n0 content;

    /* renamed from: F1, reason: from kotlin metadata */
    private ComposeView dialogs;

    /* renamed from: G1, reason: from kotlin metadata */
    private ComposeView sharingOptions;

    /* renamed from: H1, reason: from kotlin metadata */
    private BottomSheetBehavior behavior;

    /* renamed from: I1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: s1, reason: from kotlin metadata */
    private SA2 onDismiss;

    /* renamed from: t1, reason: from kotlin metadata */
    private Fragment fragment;

    /* renamed from: u1, reason: from kotlin metadata */
    private C11458d25 peer;

    /* renamed from: v1, reason: from kotlin metadata */
    private SA2 copyMessage;

    /* renamed from: w1, reason: from kotlin metadata */
    private SA2 sharePost;

    /* renamed from: x1, reason: from kotlin metadata */
    private SA2 addPostToStory;

    /* renamed from: y1, reason: from kotlin metadata */
    private C11458d25 forwardedPeer;

    /* renamed from: z1, reason: from kotlin metadata */
    private List messages;

    /* renamed from: B1, reason: from kotlin metadata */
    private boolean showSharingOptions = true;

    /* renamed from: E1, reason: from kotlin metadata */
    private UA2 onSuccess = new UA2() { // from class: ir.nasim.Hv2
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return C5787Kv2.B9((List) obj);
        }
    };

    /* renamed from: ir.nasim.Kv2$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C5787Kv2 a(Fragment fragment, C11458d25 c11458d25, SA2 sa2, C11458d25 c11458d252, List list, boolean z, boolean z2, SA2 sa22, SA2 sa23, SA2 sa24, AbstractC17457n0 abstractC17457n0, UA2 ua2, boolean z3) {
            AbstractC13042fc3.i(fragment, "fragment");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(sa2, "onDismiss");
            AbstractC13042fc3.i(c11458d252, "forwardedPeer");
            AbstractC13042fc3.i(list, "messages");
            AbstractC13042fc3.i(sa22, "copyMessage");
            AbstractC13042fc3.i(sa23, "addPostToStory");
            AbstractC13042fc3.i(sa24, "sharePost");
            AbstractC13042fc3.i(ua2, "onSuccess");
            C5787Kv2 c5787Kv2 = new C5787Kv2();
            c5787Kv2.fragment = fragment;
            c5787Kv2.peer = c11458d25;
            c5787Kv2.onDismiss = sa2;
            c5787Kv2.copyMessage = sa22;
            c5787Kv2.forwardedPeer = c11458d252;
            c5787Kv2.messages = list;
            c5787Kv2.shouldShowToast = z;
            c5787Kv2.addPostToStory = sa23;
            c5787Kv2.showSharingOptions = z2;
            c5787Kv2.content = abstractC17457n0;
            c5787Kv2.sharePost = sa24;
            c5787Kv2.canAddToStory = z3;
            c5787Kv2.onSuccess = ua2;
            return c5787Kv2;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Kv2$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Kv2$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ boolean c;
            final /* synthetic */ C5787Kv2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z, C5787Kv2 c5787Kv2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = z;
                this.d = c5787Kv2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                BottomSheetBehavior bottomSheetBehavior;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c && (bottomSheetBehavior = this.d.behavior) != null) {
                    bottomSheetBehavior.J0(3);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Kv2$b$b, reason: collision with other inner class name */
        static final class C0472b implements InterfaceC14603iB2 {
            final /* synthetic */ C5787Kv2 a;
            final /* synthetic */ InterfaceC9664aL6 b;
            final /* synthetic */ InterfaceC9664aL6 c;

            C0472b(C5787Kv2 c5787Kv2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
                this.a = c5787Kv2;
                this.b = interfaceC9664aL6;
                this.c = interfaceC9664aL62;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C5787Kv2 c5787Kv2, C7947Tw2 c7947Tw2) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                AbstractC13042fc3.i(c7947Tw2, "it");
                c5787Kv2.z9().l1(c7947Tw2);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(C5787Kv2 c5787Kv2, C7947Tw2 c7947Tw2) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                AbstractC13042fc3.i(c7947Tw2, "it");
                c5787Kv2.z9().H1(c7947Tw2);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C5787Kv2 c5787Kv2, String str) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                AbstractC13042fc3.i(str, "it");
                c5787Kv2.z9().I1(str);
                return C19938rB7.a;
            }

            public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                List listM1 = AbstractC15401jX0.m1(b.d(this.b));
                int iX1 = this.a.z9().x1();
                List listF = b.f(this.c);
                interfaceC22053ub1.W(30175330);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv2 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Lv2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C5787Kv2.b.C0472b.f(c5787Kv2, (C7947Tw2) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(30171459);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv22 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Mv2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C5787Kv2.b.C0472b.h(c5787Kv22, (C7947Tw2) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(30181075);
                boolean zD3 = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv23 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.Nv2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C5787Kv2.b.C0472b.i(c5787Kv23, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC5328Iw2.L(listF, listM1, ua2, ua22, (UA2) objB3, iX1, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List d(InterfaceC9664aL6 interfaceC9664aL6) {
            return (List) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List f(InterfaceC9664aL6 interfaceC9664aL6) {
            return (List) interfaceC9664aL6.getValue();
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(C5787Kv2.this.z9().w1(), null, interfaceC22053ub1, 0, 1);
            InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(C5787Kv2.this.z9().y1(), null, interfaceC22053ub1, 0, 1);
            boolean zV0 = AbstractC5328Iw2.V0(interfaceC22053ub1, 0);
            Boolean boolValueOf = Boolean.valueOf(zV0);
            interfaceC22053ub1.W(912580119);
            boolean zA = interfaceC22053ub1.a(zV0) | interfaceC22053ub1.D(C5787Kv2.this);
            C5787Kv2 c5787Kv2 = C5787Kv2.this;
            Object objB = interfaceC22053ub1.B();
            if (zA || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(zV0, c5787Kv2, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            M10.f(false, AbstractC19242q11.e(-1332150452, true, new C0472b(C5787Kv2.this, interfaceC9664aL6B, interfaceC9664aL6B2), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Kv2$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Kv2$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C5787Kv2 a;
            final /* synthetic */ InterfaceC9664aL6 b;
            final /* synthetic */ InterfaceC9664aL6 c;

            a(C5787Kv2 c5787Kv2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
                this.a = c5787Kv2;
                this.b = interfaceC9664aL6;
                this.c = interfaceC9664aL62;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(C5787Kv2 c5787Kv2) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                SA2 sa2 = c5787Kv2.onDismiss;
                if (sa2 != null) {
                    sa2.invoke();
                }
                c5787Kv2.u8();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(final C5787Kv2 c5787Kv2, String str) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                AbstractC13042fc3.i(str, "it");
                C4352Et4 c4352Et4Z9 = c5787Kv2.z9();
                C11458d25 c11458d25 = c5787Kv2.forwardedPeer;
                AbstractC13042fc3.f(c11458d25);
                List listM = c5787Kv2.messages;
                if (listM == null) {
                    listM = AbstractC10360bX0.m();
                }
                c4352Et4Z9.t1(c11458d25, listM, str, c5787Kv2.shouldShowToast, new UA2() { // from class: ir.nasim.Uv2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C5787Kv2.c.a.p(c5787Kv2, (List) obj);
                    }
                });
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(C5787Kv2 c5787Kv2, List list) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                AbstractC13042fc3.i(list, "it");
                c5787Kv2.onSuccess.invoke(list);
                c5787Kv2.u8();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 t(C5787Kv2 c5787Kv2) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                SA2 sa2 = c5787Kv2.copyMessage;
                if (sa2 != null) {
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 v(C5787Kv2 c5787Kv2) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                c5787Kv2.u8();
                SA2 sa2 = c5787Kv2.sharePost;
                if (sa2 != null) {
                    sa2.invoke();
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 w(C5787Kv2 c5787Kv2) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                SA2 sa2 = c5787Kv2.addPostToStory;
                if (sa2 != null) {
                    sa2.invoke();
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 x(C5787Kv2 c5787Kv2, C7947Tw2 c7947Tw2) {
                AbstractC13042fc3.i(c5787Kv2, "this$0");
                AbstractC13042fc3.i(c7947Tw2, "it");
                c5787Kv2.z9().H1(c7947Tw2);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                k((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }

            public final void k(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                C11458d25 c11458d25;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                Fragment fragment = this.a.fragment;
                if (fragment == null || (c11458d25 = this.a.peer) == null) {
                    return;
                }
                boolean z = c.f(this.b) && this.a.canAddToStory;
                boolean z2 = this.a.showSharingOptions;
                int iX1 = this.a.z9().x1();
                List listD = c.d(this.c);
                interfaceC22053ub1.W(30200804);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv2 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Ov2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C5787Kv2.c.a.n(c5787Kv2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(30214144);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv22 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Pv2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C5787Kv2.c.a.t(c5787Kv22);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                SA2 sa22 = (SA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(30241348);
                boolean zD3 = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv23 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.Qv2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C5787Kv2.c.a.v(c5787Kv23);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                SA2 sa23 = (SA2) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(30248131);
                boolean zD4 = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv24 = this.a;
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.Rv2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C5787Kv2.c.a.w(c5787Kv24);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                SA2 sa24 = (SA2) objB4;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(30237539);
                boolean zD5 = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv25 = this.a;
                Object objB5 = interfaceC22053ub1.B();
                if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new UA2() { // from class: ir.nasim.Sv2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C5787Kv2.c.a.x(c5787Kv25, (C7947Tw2) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                UA2 ua2 = (UA2) objB5;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(30218274);
                boolean zD6 = interfaceC22053ub1.D(this.a);
                final C5787Kv2 c5787Kv26 = this.a;
                Object objB6 = interfaceC22053ub1.B();
                if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                    objB6 = new UA2() { // from class: ir.nasim.Tv2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C5787Kv2.c.a.o(c5787Kv26, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB6);
                }
                interfaceC22053ub1.Q();
                AbstractC5328Iw2.q0(listD, z, z2, sa2, sa22, sa23, sa24, ua2, iX1, (UA2) objB6, fragment, c11458d25, interfaceC22053ub1, 0, 0);
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List d(InterfaceC9664aL6 interfaceC9664aL6) {
            return (List) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean f(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(C5787Kv2.this.z9().y1(), null, interfaceC22053ub1, 0, 1);
            M10.f(false, AbstractC19242q11.e(2078081037, true, new a(C5787Kv2.this, AbstractC10222bH6.b(C5787Kv2.this.z9().E1(), null, interfaceC22053ub1, 0, 1), interfaceC9664aL6B), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Kv2$d */
    public static final class d extends BottomSheetBehavior.f {
        d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, float f) {
            AbstractC13042fc3.i(view, "bottomSheet");
            if (f < -0.8f) {
                ComposeView composeView = C5787Kv2.this.sharingOptions;
                if (composeView != null) {
                    composeView.setVisibility(8);
                    return;
                }
                return;
            }
            ComposeView composeView2 = C5787Kv2.this.sharingOptions;
            if (composeView2 != null) {
                composeView2.setVisibility(0);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View view, int i) {
            AbstractC13042fc3.i(view, "bottomSheet");
        }
    }

    /* renamed from: ir.nasim.Kv2$e */
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

    /* renamed from: ir.nasim.Kv2$f */
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

    /* renamed from: ir.nasim.Kv2$g */
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

    /* renamed from: ir.nasim.Kv2$h */
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

    /* renamed from: ir.nasim.Kv2$i */
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

    public C5787Kv2() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C4352Et4.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(com.google.android.material.bottomsheet.a aVar, C5787Kv2 c5787Kv2, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(aVar, "$dialog");
        AbstractC13042fc3.i(c5787Kv2, "this$0");
        View viewFindViewById = aVar.findViewById(WB5.design_bottom_sheet);
        if (viewFindViewById != null) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = -1;
            viewFindViewById.setLayoutParams(layoutParams);
        }
        View viewFindViewById2 = aVar.findViewById(WB5.design_bottom_sheet);
        AbstractC13042fc3.g(viewFindViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
        View viewFindViewById3 = aVar.findViewById(WB5.container);
        AbstractC13042fc3.g(viewFindViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) viewFindViewById3;
        ComposeView composeView = c5787Kv2.sharingOptions;
        ViewParent parent = composeView != null ? composeView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(c5787Kv2.sharingOptions);
        }
        ComposeView composeView2 = c5787Kv2.sharingOptions;
        int childCount = frameLayout.getChildCount();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        C19938rB7 c19938rB7 = C19938rB7.a;
        frameLayout.addView(composeView2, childCount, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B9(List list) {
        AbstractC13042fc3.i(list, "it");
        return C19938rB7.a;
    }

    private final void C9(View view) {
        AbstractC12990fW7.E0(view, new InterfaceC22474vI4() { // from class: ir.nasim.Jv2
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view2, O98 o98) {
                return C5787Kv2.D9(view2, o98);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 D9(View view, O98 o98) {
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.i());
        AbstractC13042fc3.h(l93F, "getInsets(...)");
        L93 l93F2 = o98.f(O98.m.d());
        AbstractC13042fc3.h(l93F2, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = l93F.b;
        view.setLayoutParams(marginLayoutParams);
        if (l93F2.d > 0) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.topMargin = l93F.b;
            view.setLayoutParams(marginLayoutParams2);
        }
        return o98;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4352Et4 z9() {
        return (C4352Et4) this.viewModel.getValue();
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        Dialog dialogB8 = super.B8(savedInstanceState);
        AbstractC13042fc3.g(dialogB8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogB8;
        Window window = aVar.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.Iv2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C5787Kv2.A9(aVar, this, dialogInterface);
            }
        });
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        I8(0, AbstractC22439vE5.Theme_ForwardBottomSheet);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        AbstractC17457n0 abstractC17457n0 = this.content;
        if (abstractC17457n0 != null) {
            z9().s1(abstractC17457n0);
            z9().J1(this.messages);
        }
        View viewInflate = inflater.inflate(AbstractC10185bD5.fragment_forward_modal, container, false);
        this.dialogs = (ComposeView) viewInflate.findViewById(AbstractC9582aC5.dialog_list);
        this.sharingOptions = (ComposeView) viewInflate.findViewById(AbstractC9582aC5.sharing_options);
        ComposeView composeView = this.dialogs;
        if (composeView != null) {
            composeView.setViewCompositionStrategy(v.d.b);
            composeView.setContent(AbstractC19242q11.c(-1867778927, true, new b()));
            C9(composeView);
        }
        ComposeView composeView2 = this.sharingOptions;
        if (composeView2 != null) {
            composeView2.setViewCompositionStrategy(v.d.b);
            composeView2.setContent(AbstractC19242q11.c(1542452562, true, new c()));
            C9(composeView2);
        }
        AbstractC13042fc3.f(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void U6() {
        super.U6();
        this.dialogs = null;
        this.sharingOptions = null;
        this.sharePost = null;
        this.copyMessage = null;
        this.addPostToStory = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        View viewFindViewById;
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Dialog dialogY8 = y8();
        if (dialogY8 == null || (viewFindViewById = dialogY8.findViewById(WB5.design_bottom_sheet)) == null) {
            return;
        }
        BottomSheetBehavior bottomSheetBehaviorF0 = BottomSheetBehavior.f0(viewFindViewById);
        this.behavior = bottomSheetBehaviorF0;
        if (bottomSheetBehaviorF0 != null) {
            bottomSheetBehaviorF0.J0(4);
        }
        BottomSheetBehavior bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.x0(true);
        }
        BottomSheetBehavior bottomSheetBehavior2 = this.behavior;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.z0(false);
        }
        BottomSheetBehavior bottomSheetBehavior3 = this.behavior;
        if (bottomSheetBehavior3 != null) {
            bottomSheetBehavior3.I0(true);
        }
        BottomSheetBehavior bottomSheetBehavior4 = this.behavior;
        if (bottomSheetBehavior4 != null) {
            bottomSheetBehavior4.C0(true);
        }
        BottomSheetBehavior bottomSheetBehavior5 = this.behavior;
        if (bottomSheetBehavior5 != null) {
            bottomSheetBehavior5.W(new d());
        }
    }
}
