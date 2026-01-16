package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;

/* renamed from: ir.nasim.gp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13786gp {

    /* renamed from: ir.nasim.gp$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ FragmentManager e;
        final /* synthetic */ C7005Px2 f;
        final /* synthetic */ Context g;
        final /* synthetic */ Class h;
        final /* synthetic */ InterfaceC9664aL6 i;
        final /* synthetic */ C19814qz2 j;
        final /* synthetic */ Bundle k;
        final /* synthetic */ int l;

        /* renamed from: ir.nasim.gp$b$a */
        public static final class a implements DefaultLifecycleObserver {
            final /* synthetic */ C9663aL5 a;
            final /* synthetic */ Fragment b;

            a(C9663aL5 c9663aL5, Fragment fragment) {
                this.a = c9663aL5;
                this.b = fragment;
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
                this.a.a = false;
                this.b.getLifecycle().d(this);
            }
        }

        /* renamed from: ir.nasim.gp$b$b, reason: collision with other inner class name */
        public static final class C1262b implements KV1 {
            final /* synthetic */ FragmentManager a;
            final /* synthetic */ Fragment b;
            final /* synthetic */ C19814qz2 c;
            final /* synthetic */ C9663aL5 d;

            public C1262b(FragmentManager fragmentManager, Fragment fragment, C19814qz2 c19814qz2, C9663aL5 c9663aL5) {
                this.a = fragmentManager;
                this.b = fragment;
                this.c = c19814qz2;
                this.d = c9663aL5;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.c.a().setValue(this.a.D1(this.b));
                if (this.d.a) {
                    androidx.fragment.app.x xVarS = this.a.s();
                    xVarS.p(this.b);
                    xVarS.k();
                } else {
                    if (this.a.X0()) {
                        return;
                    }
                    androidx.fragment.app.x xVarS2 = this.a.s();
                    xVarS2.p(this.b);
                    xVarS2.j();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(FragmentManager fragmentManager, C7005Px2 c7005Px2, Context context, Class cls, InterfaceC9664aL6 interfaceC9664aL6, C19814qz2 c19814qz2, Bundle bundle, int i) {
            super(1);
            this.e = fragmentManager;
            this.f = c7005Px2;
            this.g = context;
            this.h = cls;
            this.i = interfaceC9664aL6;
            this.j = c19814qz2;
            this.k = bundle;
            this.l = i;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            C9663aL5 c9663aL5 = new C9663aL5();
            Fragment fragmentO0 = this.e.o0(this.f.a().getId());
            if (fragmentO0 == null) {
                fragmentO0 = this.e.B0().a(this.g.getClassLoader(), this.h.getName());
                C19814qz2 c19814qz2 = this.j;
                Bundle bundle = this.k;
                FragmentManager fragmentManager = this.e;
                C7005Px2 c7005Px2 = this.f;
                int i = this.l;
                fragmentO0.d8((Fragment.SavedState) c19814qz2.a().getValue());
                fragmentO0.a8(bundle);
                androidx.fragment.app.x xVarD = fragmentManager.s().v(true).d(c7005Px2.a(), fragmentO0, String.valueOf(i));
                if (fragmentManager.X0()) {
                    c9663aL5.a = true;
                    fragmentO0.getLifecycle().a(new a(c9663aL5, fragmentO0));
                    xVarD.k();
                } else {
                    xVarD.j();
                }
            }
            this.e.i1(this.f.a());
            UA2 ua2 = (UA2) this.i.getValue();
            AbstractC13042fc3.g(fragmentO0, "null cannot be cast to non-null type T of androidx.fragment.compose.AndroidFragmentKt.AndroidFragment$lambda$2");
            ua2.invoke(fragmentO0);
            return new C1262b(this.e, fragmentO0, this.j, c9663aL5);
        }
    }

    /* renamed from: ir.nasim.gp$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Class e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ C19814qz2 g;
        final /* synthetic */ Bundle h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Class cls, androidx.compose.ui.e eVar, C19814qz2 c19814qz2, Bundle bundle, UA2 ua2, int i, int i2) {
            super(2);
            this.e = cls;
            this.f = eVar;
            this.g = c19814qz2;
            this.h = bundle;
            this.i = ua2;
            this.j = i;
            this.k = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13786gp.a(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1), this.k);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(java.lang.Class r22, androidx.compose.ui.e r23, ir.nasim.C19814qz2 r24, android.os.Bundle r25, ir.nasim.UA2 r26, ir.nasim.InterfaceC22053ub1 r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13786gp.a(java.lang.Class, androidx.compose.ui.e, ir.nasim.qz2, android.os.Bundle, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* renamed from: ir.nasim.gp$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Fragment) obj);
            return C19938rB7.a;
        }

        public final void a(Fragment fragment) {
        }
    }
}
