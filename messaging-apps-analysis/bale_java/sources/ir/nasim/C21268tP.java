package ir.nasim;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import ir.nasim.AbstractC14721iN;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C21268tP;
import java.util.List;

/* renamed from: ir.nasim.tP, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21268tP implements IN {
    public static final d Companion = new d(null);
    private static final InterfaceC9173Yu3 p;
    private static final InterfaceC9173Yu3 q;
    private static final InterfaceC9173Yu3 r;
    private final Context a;
    private boolean b;
    private InterfaceC14603iB2 c;
    private AudioManager.OnAudioFocusChangeListener d;
    private List e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private AbstractC24073y0 m;
    private Handler n;
    private HandlerThread o;

    /* renamed from: ir.nasim.tP$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        /* renamed from: ir.nasim.tP$a$a, reason: collision with other inner class name */
        public static final class C1575a implements InterfaceC14603iB2 {
            C1575a() {
            }

            public void a(List list, AbstractC14721iN abstractC14721iN) {
                AbstractC13042fc3.i(list, "audioDevices");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((List) obj, (AbstractC14721iN) obj2);
                return C19938rB7.a;
            }
        }

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C1575a invoke() {
            return new C1575a();
        }
    }

    /* renamed from: ir.nasim.tP$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return AbstractC10360bX0.p(AbstractC14721iN.a.class, AbstractC14721iN.d.class, AbstractC14721iN.c.class, AbstractC14721iN.b.class);
        }
    }

    /* renamed from: ir.nasim.tP$d */
    public static final class d {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final a.C1575a d() {
            return (a.C1575a) C21268tP.q.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AudioManager.OnAudioFocusChangeListener e() {
            return (AudioManager.OnAudioFocusChangeListener) C21268tP.p.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List f() {
            return (List) C21268tP.r.getValue();
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        p = AbstractC13269fw3.b(enumC4870Gx3, b.e);
        q = AbstractC13269fw3.b(enumC4870Gx3, a.e);
        r = AbstractC13269fw3.b(enumC4870Gx3, c.e);
    }

    public C21268tP(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.f = true;
        this.g = 3;
        this.h = 1;
        this.j = 2;
        this.k = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(C21268tP c21268tP) {
        AbstractC13042fc3.i(c21268tP, "this$0");
        Context context = c21268tP.a;
        boolean z = c21268tP.b;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListenerE = c21268tP.d;
        if (onAudioFocusChangeListenerE == null) {
            onAudioFocusChangeListenerE = Companion.e();
        }
        List listF = c21268tP.e;
        if (listF == null) {
            listF = Companion.f();
        }
        C19465qP c19465qP = new C19465qP(context, z, onAudioFocusChangeListenerE, listF);
        c19465qP.A(c21268tP.f);
        c19465qP.w(c21268tP.g);
        c19465qP.y(c21268tP.h);
        c19465qP.x(c21268tP.i);
        c19465qP.v(c21268tP.j);
        c19465qP.u(c21268tP.k);
        c19465qP.z(c21268tP.l);
        c21268tP.m = c19465qP;
        InterfaceC14603iB2 interfaceC14603iB2D = c21268tP.c;
        if (interfaceC14603iB2D == null) {
            interfaceC14603iB2D = Companion.d();
        }
        c19465qP.D(interfaceC14603iB2D);
        c19465qP.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(C21268tP c21268tP) {
        AbstractC13042fc3.i(c21268tP, "this$0");
        AbstractC24073y0 abstractC24073y0 = c21268tP.m;
        if (abstractC24073y0 != null) {
            abstractC24073y0.E();
        }
        c21268tP.m = null;
    }

    public final void f(int i) {
        this.k = i;
    }

    public final void g(int i) {
        this.j = i;
    }

    public final void h(int i) {
        this.g = i;
    }

    public final void i(int i) {
        this.i = i;
    }

    @Override // ir.nasim.IN
    public synchronized void start() {
        try {
            if (this.n != null || this.o != null) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.g(null, "AudioSwitchHandler called start multiple times?", new Object[0]);
                }
            }
            if (this.o == null) {
                HandlerThread handlerThread = new HandlerThread("AudioSwitchHandlerThread");
                handlerThread.start();
                this.o = handlerThread;
            }
            if (this.n == null) {
                HandlerThread handlerThread2 = this.o;
                AbstractC13042fc3.f(handlerThread2);
                this.n = new Handler(handlerThread2.getLooper());
            }
            if (this.m == null) {
                Handler handler = this.n;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Handler handler2 = this.n;
                if (handler2 != null) {
                    handler2.postAtFrontOfQueue(new Runnable() { // from class: ir.nasim.rP
                        @Override // java.lang.Runnable
                        public final void run() {
                            C21268tP.j(this.a);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.IN
    public synchronized void stop() {
        try {
            Handler handler = this.n;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.n;
            if (handler2 != null) {
                handler2.postAtFrontOfQueue(new Runnable() { // from class: ir.nasim.sP
                    @Override // java.lang.Runnable
                    public final void run() {
                        C21268tP.k(this.a);
                    }
                });
            }
            HandlerThread handlerThread = this.o;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.n = null;
            this.o = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: ir.nasim.tP$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AudioManager.OnAudioFocusChangeListener invoke() {
            return new AudioManager.OnAudioFocusChangeListener() { // from class: ir.nasim.uP
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i) {
                    C21268tP.b.c(i);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i) {
        }
    }
}
