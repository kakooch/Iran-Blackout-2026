package ir.nasim;

import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.gb1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ScrollCaptureCallbackC13648gb1 implements ScrollCaptureCallback {
    private final C7631Sn6 a;
    private final C25005za3 b;
    private final a c;
    private final View d;
    private final InterfaceC20315ro1 e;
    private final LM5 f;
    private int g;

    /* renamed from: ir.nasim.gb1$a */
    public interface a {
        void a();

        void b();
    }

    /* renamed from: ir.nasim.gb1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Runnable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Runnable runnable, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = runnable;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ScrollCaptureCallbackC13648gb1.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                LM5 lm5 = ScrollCaptureCallbackC13648gb1.this.f;
                this.b = 1;
                if (lm5.g(0.0f, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            ScrollCaptureCallbackC13648gb1.this.c.b();
            this.d.run();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gb1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ScrollCaptureSession d;
        final /* synthetic */ Rect e;
        final /* synthetic */ Consumer f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ScrollCaptureSession scrollCaptureSession, Rect rect, Consumer consumer, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = scrollCaptureSession;
            this.e = rect;
            this.f = consumer;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ScrollCaptureCallbackC13648gb1.this.new c(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ScrollCaptureCallbackC13648gb1 scrollCaptureCallbackC13648gb1 = ScrollCaptureCallbackC13648gb1.this;
                ScrollCaptureSession scrollCaptureSession = this.d;
                C25005za3 c25005za3D = EK5.d(this.e);
                this.b = 1;
                obj = scrollCaptureCallbackC13648gb1.e(scrollCaptureSession, c25005za3D, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.f.accept(EK5.a((C25005za3) obj));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gb1$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        int e;
        /* synthetic */ Object f;
        int h;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return ScrollCaptureCallbackC13648gb1.this.e(null, null, this);
        }
    }

    /* renamed from: ir.nasim.gb1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        boolean b;
        int c;
        /* synthetic */ float d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = ScrollCaptureCallbackC13648gb1.this.new f(interfaceC20295rm1);
            fVar.d = ((Number) obj).floatValue();
            return fVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Number) obj).floatValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            boolean z;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                float f = this.d;
                InterfaceC14603iB2 interfaceC14603iB2C = AbstractC7073Qd6.c(ScrollCaptureCallbackC13648gb1.this.a);
                if (interfaceC14603iB2C == null) {
                    M73.c("Required value was null.");
                    throw new KotlinNothingValueException();
                }
                boolean zB = ((C5629Kd6) ScrollCaptureCallbackC13648gb1.this.a.w().t(C8838Xn6.a.M())).b();
                if (zB) {
                    f = -f;
                }
                ZG4 zg4D = ZG4.d(ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)));
                this.b = zB;
                this.c = 1;
                obj = interfaceC14603iB2C.invoke(zg4D, this);
                if (obj == objE) {
                    return objE;
                }
                z = zB;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = this.b;
                AbstractC10685c16.b(obj);
            }
            long jT = ((ZG4) obj).t();
            return AbstractC6392Nk0.c(z ? -Float.intBitsToFloat((int) (jT & 4294967295L)) : Float.intBitsToFloat((int) (jT & 4294967295L)));
        }

        public final Object n(float f, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(Float.valueOf(f), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public ScrollCaptureCallbackC13648gb1(C7631Sn6 c7631Sn6, C25005za3 c25005za3, InterfaceC20315ro1 interfaceC20315ro1, a aVar, View view) {
        this.a = c7631Sn6;
        this.b = c25005za3;
        this.c = aVar;
        this.d = view;
        this.e = AbstractC20906so1.h(interfaceC20315ro1, RT1.a);
        this.f = new LM5(c25005za3.f(), new f(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(android.view.ScrollCaptureSession r9, ir.nasim.C25005za3 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ScrollCaptureCallbackC13648gb1.e(android.view.ScrollCaptureSession, ir.nasim.za3, ir.nasim.rm1):java.lang.Object");
    }

    public void onScrollCaptureEnd(Runnable runnable) {
        AbstractC10533bm0.d(this.e, C12798fB4.b, null, new b(runnable, null), 2, null);
    }

    public void onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Rect rect, Consumer consumer) {
        AbstractC14850ib1.c(this.e, cancellationSignal, new c(scrollCaptureSession, rect, consumer, null));
    }

    public void onScrollCaptureSearch(CancellationSignal cancellationSignal, Consumer consumer) {
        consumer.accept(EK5.a(this.b));
    }

    public void onScrollCaptureStart(ScrollCaptureSession scrollCaptureSession, CancellationSignal cancellationSignal, Runnable runnable) {
        this.f.d();
        this.g = 0;
        this.c.a();
        runnable.run();
    }

    /* renamed from: ir.nasim.gb1$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).longValue());
            return C19938rB7.a;
        }

        public final void a(long j) {
        }
    }
}
