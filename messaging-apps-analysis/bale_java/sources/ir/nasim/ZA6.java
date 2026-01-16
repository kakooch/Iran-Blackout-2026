package ir.nasim;

import ir.nasim.Q12;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes6.dex */
public final class ZA6 {
    public static final a b = new a(null);
    public static final int c = SettingsModule.W4;
    private final SettingsModule a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public ZA6(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = settingsModule;
    }

    private final int a() {
        return this.a.w1();
    }

    private final int b() {
        return this.a.y1();
    }

    private final long c() {
        return this.a.N2();
    }

    private final long d() {
        return this.a.O2();
    }

    private final void f(int i) {
        this.a.C6(i);
    }

    private final void g(int i) {
        this.a.D6(i);
    }

    private final void h(long j) {
        this.a.e7(j);
    }

    private final boolean i(long j, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Q12.a aVar = Q12.b;
        return j > jCurrentTimeMillis - Q12.A(T12.s(i, W12.h));
    }

    public final boolean e() {
        C19406qI3.g("ShouldShowSwipeAnimationUseCase", "use case state: countShownSwipeTutorials: " + b() + ", lastShownSwipeTutorialTime: " + c() + ", lastTimeSimilarPostSwipe: " + d() + ", count3TimeTutorialShown: " + a(), new Object[0]);
        if (b() < 3 && !i(c(), 1)) {
            g(b() + 1);
            h(System.currentTimeMillis());
            C19406qI3.g("ShouldShowSwipeAnimationUseCase", "showing swipe animation case 1", new Object[0]);
            return true;
        }
        if (i(d(), 3) || a() >= 3 || i(c(), 3)) {
            C19406qI3.g("ShouldShowSwipeAnimationUseCase", "not showing swipe animation", new Object[0]);
            return false;
        }
        f(a() + 1);
        h(System.currentTimeMillis());
        C19406qI3.g("ShouldShowSwipeAnimationUseCase", "showing swipe animation case 2", new Object[0]);
        return true;
    }
}
