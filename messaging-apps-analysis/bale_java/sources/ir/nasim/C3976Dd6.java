package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import android.view.OrientationEventListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Dd6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3976Dd6 implements DefaultLifecycleObserver {
    private static final a g = new a(null);
    public static final int h = 8;
    private final AppCompatActivity a;
    private boolean b;
    private int c;
    private Integer d;
    private b e;
    private OrientationEventListener f;

    /* renamed from: ir.nasim.Dd6$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Dd6$b */
    private static abstract class b {

        /* renamed from: ir.nasim.Dd6$b$a */
        public static final class a extends b {
            public static final a a = new a();

            private a() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return -1215601405;
            }

            public String toString() {
                return "Idle";
            }
        }

        /* renamed from: ir.nasim.Dd6$b$b, reason: collision with other inner class name */
        public static final class C0324b extends b {
            public static final C0324b a = new C0324b();

            private C0324b() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0324b);
            }

            public int hashCode() {
                return -1716604180;
            }

            public String toString() {
                return "Landscape";
            }
        }

        /* renamed from: ir.nasim.Dd6$b$c */
        public static final class c extends b {
            private final C24411ya3 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(C24411ya3 c24411ya3) {
                super(null);
                AbstractC13042fc3.i(c24411ya3, "returnOrientationRange");
                this.a = c24411ya3;
            }

            public final C24411ya3 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "Portrait(returnOrientationRange=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.Dd6$b$d */
        public static final class d extends b {
            public static final d a = new d();

            private d() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof d);
            }

            public int hashCode() {
                return -732646232;
            }

            public String toString() {
                return "ReverseLandscape";
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Dd6$c */
    public static final class c extends OrientationEventListener {
        c(AppCompatActivity appCompatActivity) {
            super(appCompatActivity);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            C3976Dd6.this.c = i;
            b bVar = C3976Dd6.this.e;
            if (bVar instanceof b.a) {
                return;
            }
            if (bVar instanceof b.c) {
                if (i > 0 && (i >= 330 || i <= 30)) {
                    C3976Dd6.this.b = true;
                    return;
                }
                if (C3976Dd6.this.b) {
                    C24411ya3 c24411ya3A = ((b.c) bVar).a();
                    int iO = c24411ya3A.o();
                    if (i > c24411ya3A.t() || iO > i) {
                        return;
                    }
                    Integer num = C3976Dd6.this.d;
                    if (num != null) {
                        C3976Dd6 c3976Dd6 = C3976Dd6.this;
                        c3976Dd6.a.setRequestedOrientation(num.intValue());
                        c3976Dd6.d = null;
                    }
                    C3976Dd6.this.e = b.a.a;
                    C3976Dd6.this.b = false;
                    return;
                }
                return;
            }
            if (bVar instanceof b.C0324b) {
                if (i >= 240 && i <= 300) {
                    C3976Dd6.this.b = true;
                    return;
                }
                if (!C3976Dd6.this.b || i <= 0) {
                    return;
                }
                if (i >= 330 || i <= 30) {
                    Integer num2 = C3976Dd6.this.d;
                    if (num2 != null) {
                        C3976Dd6 c3976Dd62 = C3976Dd6.this;
                        c3976Dd62.a.setRequestedOrientation(num2.intValue());
                        c3976Dd62.d = null;
                    }
                    C3976Dd6.this.e = b.a.a;
                    C3976Dd6.this.b = false;
                    return;
                }
                return;
            }
            if (!(bVar instanceof b.d)) {
                throw new NoWhenBranchMatchedException();
            }
            if (i >= 60 && i <= 120) {
                C3976Dd6.this.b = true;
                return;
            }
            if (!C3976Dd6.this.b || i <= 0) {
                return;
            }
            if (i >= 330 || i <= 30) {
                Integer num3 = C3976Dd6.this.d;
                if (num3 != null) {
                    C3976Dd6 c3976Dd63 = C3976Dd6.this;
                    c3976Dd63.a.setRequestedOrientation(num3.intValue());
                    c3976Dd63.d = null;
                }
                C3976Dd6.this.e = b.a.a;
                C3976Dd6.this.b = false;
            }
        }
    }

    public C3976Dd6(AppCompatActivity appCompatActivity) {
        AbstractC13042fc3.i(appCompatActivity, "activity");
        this.a = appCompatActivity;
        this.e = b.a.a;
        appCompatActivity.getLifecycle().a(this);
    }

    public final boolean j() {
        try {
            this.b = false;
            this.d = Integer.valueOf(this.a.getRequestedOrientation());
            int i = this.c;
            if (30 > i || i >= 151) {
                this.e = b.C0324b.a;
                this.a.setRequestedOrientation(0);
            } else {
                this.e = b.d.a;
                this.a.setRequestedOrientation(8);
            }
            return true;
        } catch (Exception e) {
            C19406qI3.c("ScreenOrientationController", "requestLandscapeOrientation()", e);
            return false;
        }
    }

    public final boolean l() {
        try {
            this.b = false;
            int i = this.c;
            this.e = (180 > i || i >= 361) ? new b.c(new C24411ya3(60, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER)) : new b.c(new C24411ya3(SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, 300));
            this.d = Integer.valueOf(this.a.getRequestedOrientation());
            this.a.setRequestedOrientation(1);
            return true;
        } catch (Exception e) {
            C19406qI3.c("ScreenOrientationController", "requestPortraitOrientation()", e);
            return false;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        c cVar = new c(this.a);
        if (cVar.canDetectOrientation()) {
            cVar.enable();
        } else {
            cVar.disable();
        }
        this.f = cVar;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        interfaceC18633oz3.getLifecycle().d(this);
    }
}
