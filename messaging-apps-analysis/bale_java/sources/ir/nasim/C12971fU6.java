package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import ir.nasim.C12971fU6;
import ir.nasim.C21753u45;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.story.model.StoryWidget;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.fU6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12971fU6 {
    private static StoryRecorder b;
    private static I35 d;
    private static AbstractC22357v6 e;
    private static InterfaceC12261eJ4 h;
    private static SA2 i;
    private static UA2 j;
    private static UA2 k;
    private static UA2 l;
    private static UA2 m;
    public static final C12971fU6 a = new C12971fU6();
    private static WeakReference c = new WeakReference(null);
    private static boolean f = true;
    private static a g = new a();
    public static final int n = 8;

    /* renamed from: ir.nasim.fU6$a */
    public static final class a implements InterfaceC13589gU6 {
        a() {
        }

        private final void k(C21753u45.d dVar, final String str, final int i) {
            I35 i35 = C12971fU6.d;
            if (i35 != null) {
                i35.e(new UA2() { // from class: ir.nasim.eU6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C12971fU6.a.l(i, str, ((Boolean) obj).booleanValue());
                    }
                });
            }
            AbstractC22357v6 abstractC22357v6 = C12971fU6.e;
            if (abstractC22357v6 != null) {
                abstractC22357v6.a(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 l(int i, String str, boolean z) throws Resources.NotFoundException {
            AbstractC13042fc3.i(str, "$permission");
            if (z) {
                StoryRecorder.K3(i, new String[]{str}, new int[]{0});
            } else {
                StoryRecorder.K3(i, new String[]{str}, new int[]{-1});
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public void a(String[] strArr, int i) {
            AbstractC13042fc3.i(strArr, "permission");
            k(C21753u45.d.f, (String) AbstractC10242bK.b0(strArr), i);
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public void b(String[] strArr, int i) {
            AbstractC13042fc3.i(strArr, "permission");
            k(C21753u45.d.j, (String) AbstractC10242bK.b0(strArr), i);
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public void c(boolean z) {
            UA2 ua2 = C12971fU6.l;
            if (ua2 != null) {
                ua2.invoke(Boolean.valueOf(z));
            }
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public boolean d() {
            return C12971fU6.f;
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public void e(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, UA2 ua2) {
            AbstractC13042fc3.i(lVar, "entry");
            AbstractC13042fc3.i(ua2, "result");
            InterfaceC12261eJ4 interfaceC12261eJ4 = C12971fU6.h;
            if (interfaceC12261eJ4 != null) {
                interfaceC12261eJ4.a(lVar, ua2);
            }
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public void f(InterfaceC19490qR6 interfaceC19490qR6) {
            AbstractC13042fc3.i(interfaceC19490qR6, "storyLinkEditor");
            UA2 ua2 = C12971fU6.j;
            if (ua2 != null) {
                ua2.invoke(StoryWidget.Unknown.a.f0(new C20081rR6().a(interfaceC19490qR6)));
            }
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public void g(InterfaceC19490qR6 interfaceC19490qR6) {
            AbstractC13042fc3.i(interfaceC19490qR6, "storyLinkEditor");
            UA2 ua2 = C12971fU6.k;
            if (ua2 != null) {
                ua2.invoke(StoryWidget.Unknown.a.f0(new C20081rR6().a(interfaceC19490qR6)));
            }
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public void h(C19526qV6 c19526qV6) {
            AbstractC13042fc3.i(c19526qV6, "storyTagEditor");
            UA2 ua2 = C12971fU6.m;
            if (ua2 != null) {
                ua2.invoke(c19526qV6);
            }
        }

        @Override // ir.nasim.InterfaceC13589gU6
        public void i(String[] strArr, int i) {
            AbstractC13042fc3.i(strArr, "permission");
            k(C21753u45.d.s, (String) AbstractC10242bK.b0(strArr), i);
        }
    }

    private C12971fU6() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(final AbstractC13141fj5 abstractC13141fj5, final InterfaceC14603iB2 interfaceC14603iB2, final SA2 sa2, final ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, boolean z) {
        AbstractC13042fc3.i(abstractC13141fj5, "$adapter");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onUploadStory");
        AbstractC13042fc3.i(sa2, "$onCloseEditor");
        AbstractC13042fc3.i(lVar, "storyEntry");
        z(a, lVar, 0L, false, z, 6, null).r(new InterfaceC12261eJ4() { // from class: ir.nasim.bU6
            @Override // ir.nasim.InterfaceC12261eJ4
            public final void a(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar2, UA2 ua2) {
                C12971fU6.n(abstractC13141fj5, lVar, interfaceC14603iB2, sa2, lVar2, ua2);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AbstractC13141fj5 abstractC13141fj5, ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar2, UA2 ua2) {
        AbstractC13042fc3.i(abstractC13141fj5, "$adapter");
        AbstractC13042fc3.i(lVar, "$storyEntry");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onUploadStory");
        AbstractC13042fc3.i(sa2, "$onCloseEditor");
        AbstractC13042fc3.i(lVar2, "<unused var>");
        AbstractC13042fc3.i(ua2, "<unused var>");
        interfaceC14603iB2.invoke(abstractC13141fj5.j(lVar), abstractC13141fj5.h(lVar));
        sa2.invoke();
        a.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        b = null;
        SA2 sa2 = i;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public static /* synthetic */ C12971fU6 x(C12971fU6 c12971fU6, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return c12971fU6.w(z, z2);
    }

    public static /* synthetic */ C12971fU6 z(C12971fU6 c12971fU6, ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, long j2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return c12971fU6.y(lVar, j2, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? true : z2);
    }

    public final void A() {
        if (b == null) {
            return;
        }
        StoryRecorder.I3();
    }

    public final void B() throws Resources.NotFoundException {
        if (b == null) {
            return;
        }
        StoryRecorder.M3();
    }

    public final C12971fU6 C(StoryWidget.LinkWidget linkWidget) {
        AbstractC13042fc3.i(linkWidget, "storyLink");
        StoryRecorder storyRecorder = b;
        if (storyRecorder != null) {
            storyRecorder.d4(new C20690sR6().a(linkWidget));
        }
        return this;
    }

    public final C12971fU6 D(EnumC20117rV6 enumC20117rV6, boolean z, boolean z2) {
        StoryRecorder storyRecorder;
        if (enumC20117rV6 != null && (storyRecorder = b) != null) {
            Fragment fragment = (Fragment) c.get();
            Context contextS7 = fragment != null ? fragment.S7() : null;
            AbstractC13042fc3.f(contextS7);
            storyRecorder.h4(C19526qV6.b(new C20726sV6(contextS7).a(enumC20117rV6), 0, null, z, z2, 3, null));
        }
        return this;
    }

    public final C12971fU6 E(String str, SA2 sa2) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(sa2, "onShown");
        StoryRecorder storyRecorder = b;
        if (storyRecorder != null) {
            storyRecorder.i4(str, sa2);
        }
        return this;
    }

    public final void l(Context context, C16731lm1 c16731lm1, C8967Xz7 c8967Xz7, ViewGroup viewGroup, IQ0 iq0, final SA2 sa2, final InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c16731lm1, "contextThemeWrapper");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(viewGroup, "rootView");
        AbstractC13042fc3.i(iq0, "chatType");
        AbstractC13042fc3.i(sa2, "onCloseEditor");
        AbstractC13042fc3.i(interfaceC14603iB2, "onUploadStory");
        final AbstractC13141fj5 c3833Cn7 = c8967Xz7.j().H() == null ? new C3833Cn7(context) : new G23(context);
        c3833Cn7.p(c16731lm1, c8967Xz7, viewGroup, iq0, interfaceC14603iB2, new InterfaceC14603iB2() { // from class: ir.nasim.dU6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C12971fU6.m(c3833Cn7, interfaceC14603iB2, sa2, (ir.nasim.tgwidgets.editor.ui.stories.recorder.l) obj, ((Boolean) obj2).booleanValue());
            }
        });
    }

    public final void o() {
        if (b == null) {
            return;
        }
        StoryRecorder.z2();
    }

    public final C12971fU6 p(Fragment fragment, AbstractC22357v6 abstractC22357v6, I35 i35, long j2) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(abstractC22357v6, "requestPermissionLauncher");
        AbstractC13042fc3.i(i35, "activityResultContracts");
        c = new WeakReference(fragment);
        e = abstractC22357v6;
        d = i35;
        if (b == null) {
            b = StoryRecorder.G2(fragment.Q7(), 0).g4(g).f4(j2);
        }
        StoryRecorder storyRecorder = b;
        if (storyRecorder != null) {
            storyRecorder.e4(new Runnable() { // from class: ir.nasim.cU6
                @Override // java.lang.Runnable
                public final void run() {
                    C12971fU6.q();
                }
            });
        }
        return this;
    }

    public final C12971fU6 r(InterfaceC12261eJ4 interfaceC12261eJ4) {
        AbstractC13042fc3.i(interfaceC12261eJ4, "listener");
        h = interfaceC12261eJ4;
        return this;
    }

    public final C12971fU6 s(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        k = ua2;
        return this;
    }

    public final C12971fU6 t(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        j = ua2;
        return this;
    }

    public final C12971fU6 u(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        m = ua2;
        return this;
    }

    public final C12971fU6 v(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        l = ua2;
        return this;
    }

    public final C12971fU6 w(boolean z, boolean z2) throws Resources.NotFoundException {
        f = z2;
        StoryRecorder storyRecorder = b;
        if (storyRecorder != null) {
            storyRecorder.Q3(null, z);
        }
        return this;
    }

    public final C12971fU6 y(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, long j2, boolean z, boolean z2) throws Resources.NotFoundException {
        AbstractC13042fc3.i(lVar, "storyEntry");
        f = z2;
        StoryRecorder storyRecorder = b;
        if (storyRecorder != null) {
            storyRecorder.R3(null, lVar, j2, z);
        }
        return this;
    }
}
