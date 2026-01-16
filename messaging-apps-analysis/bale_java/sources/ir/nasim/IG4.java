package ir.nasim;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class IG4 implements NG4 {
    @Override // ir.nasim.NG4
    public final void d(PG4 pg4) {
        Objects.requireNonNull(pg4, "observer is null");
        try {
            PG4 pg4F = D76.f(this, pg4);
            Objects.requireNonNull(pg4F, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            j(pg4F);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC14250hc2.b(th);
            D76.d(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final IG4 f(long j, TimeUnit timeUnit, AbstractC3967Dc6 abstractC3967Dc6) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(abstractC3967Dc6, "scheduler is null");
        return D76.c(new JG4(this, j, timeUnit, abstractC3967Dc6));
    }

    public final IG4 g() {
        return D76.c(new MG4(this));
    }

    public final GV1 h(InterfaceC23859xe1 interfaceC23859xe1) {
        return i(interfaceC23859xe1, HB2.f, HB2.c);
    }

    public final GV1 i(InterfaceC23859xe1 interfaceC23859xe1, InterfaceC23859xe1 interfaceC23859xe12, H4 h4) {
        Objects.requireNonNull(interfaceC23859xe1, "onNext is null");
        Objects.requireNonNull(interfaceC23859xe12, "onError is null");
        Objects.requireNonNull(h4, "onComplete is null");
        C8880Xs3 c8880Xs3 = new C8880Xs3(interfaceC23859xe1, interfaceC23859xe12, h4, HB2.a());
        d(c8880Xs3);
        return c8880Xs3;
    }

    protected abstract void j(PG4 pg4);
}
