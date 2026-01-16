package ir.nasim;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C23345wl7;

/* renamed from: ir.nasim.Rl7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C7380Rl7 extends AbstractC10505bj2 {
    public static final a J0 = new a(null);
    public static final int K0 = 8;
    private final C4260Ej2 G0;
    private final int H0;
    private AbstractC15520jj2.f I0;

    /* renamed from: ir.nasim.Rl7$a */
    public static final class a {
        private a() {
        }

        public final C7380Rl7 a(ViewGroup viewGroup, InterfaceC13138fj2 interfaceC13138fj2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            C11268cj2 c11268cj2C = C11268cj2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11268cj2C, "inflate(...)");
            return new C7380Rl7(c11268cj2C, interfaceC13138fj2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7380Rl7(C11268cj2 c11268cj2, InterfaceC13138fj2 interfaceC13138fj2) {
        super(c11268cj2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11268cj2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.H0 = 10;
        ViewStub viewStub = c11268cj2.g;
        viewStub.setLayoutResource(HC5.feed_text_holder);
        viewStub.setInflatedId(viewStub.getId());
        this.G0 = C4260Ej2.a(viewStub.inflate());
    }

    private final void C3() {
        this.G0.b.setTextSize(C20837sh2.a.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O3(C7380Rl7 c7380Rl7, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(c7380Rl7, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        c7380Rl7.b3(c4743Gj2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P3(C7380Rl7 c7380Rl7, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(c7380Rl7, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        c7380Rl7.Y2(new C8755Xe4(c4743Gj2.f().I0().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null), c4743Gj2.e());
        return C19938rB7.a;
    }

    private final void T3(final TextView textView, final long j, final float f, final UA2 ua2, final UA2 ua22) {
        final C12280eL5 c12280eL5 = new C12280eL5();
        final C10873cL5 c10873cL5 = new C10873cL5();
        final C10873cL5 c10873cL52 = new C10873cL5();
        final C9663aL5 c9663aL5 = new C9663aL5();
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.Pl7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C7380Rl7.V3(c10873cL5, c10873cL52, c9663aL5, f, textView, c12280eL5, j, ua2, ua22, view, motionEvent);
            }
        });
    }

    static /* synthetic */ void U3(C7380Rl7 c7380Rl7, TextView textView, long j, float f, UA2 ua2, UA2 ua22, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 500;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            f = 10.0f;
        }
        c7380Rl7.T3(textView, j2, f, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V3(C10873cL5 c10873cL5, C10873cL5 c10873cL52, C9663aL5 c9663aL5, float f, final TextView textView, final C12280eL5 c12280eL5, final long j, UA2 ua2, final UA2 ua22, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c10873cL5, "$lastTouchX");
        AbstractC13042fc3.i(c10873cL52, "$lastTouchY");
        AbstractC13042fc3.i(c9663aL5, "$isDragging");
        AbstractC13042fc3.i(textView, "$textView");
        AbstractC13042fc3.i(c12280eL5, "$lastTapTime");
        AbstractC13042fc3.i(ua2, "$onDoubleTap");
        AbstractC13042fc3.i(ua22, "$onSingleTap");
        int action = motionEvent.getAction();
        if (action == 0) {
            c10873cL5.a = motionEvent.getX();
            c10873cL52.a = motionEvent.getY();
            c9663aL5.a = false;
        } else if (action == 1) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (textView.getLayout().getLineForVertical((int) motionEvent.getY()) == textView.getLineCount() - 1 || c9663aL5.a) {
                return false;
            }
            if (jElapsedRealtime - c12280eL5.a < j) {
                ua2.invoke(textView);
            } else {
                textView.postDelayed(new Runnable() { // from class: ir.nasim.Ql7
                    @Override // java.lang.Runnable
                    public final void run() {
                        C7380Rl7.W3(c12280eL5, j, ua22, textView);
                    }
                }, j);
            }
            c12280eL5.a = jElapsedRealtime;
        } else if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - c10873cL5.a);
            float fAbs2 = Math.abs(motionEvent.getY() - c10873cL52.a);
            if (fAbs > f || fAbs2 > f) {
                c9663aL5.a = true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W3(C12280eL5 c12280eL5, long j, UA2 ua2, TextView textView) {
        AbstractC13042fc3.i(c12280eL5, "$lastTapTime");
        AbstractC13042fc3.i(ua2, "$onSingleTap");
        AbstractC13042fc3.i(textView, "$textView");
        if (SystemClock.elapsedRealtime() - c12280eL5.a >= j) {
            ua2.invoke(textView);
        }
    }

    @Override // ir.nasim.AbstractC10505bj2
    public void E2(AbstractC15520jj2 abstractC15520jj2) {
        AbstractC13042fc3.i(abstractC15520jj2, "feedMessage");
        super.E2(abstractC15520jj2);
        C3();
        this.I0 = (AbstractC15520jj2.f) abstractC15520jj2;
        TextView textView = l1().d;
        AbstractC13042fc3.h(textView, "feedCaption");
        textView.setVisibility(8);
        this.G0.b.setMovementMethod(t1());
        final C4743Gj2 c4743Gj2F3 = f3();
        if (c4743Gj2F3 != null) {
            TextView textView2 = this.G0.b;
            AbstractC13042fc3.h(textView2, "feedText");
            U3(this, textView2, 0L, 0.0f, new UA2() { // from class: ir.nasim.Nl7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C7380Rl7.O3(this.a, c4743Gj2F3, (View) obj);
                }
            }, new UA2() { // from class: ir.nasim.Ol7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C7380Rl7.P3(this.a, c4743Gj2F3, (View) obj);
                }
            }, 6, null);
        }
    }

    @Override // ir.nasim.AbstractC13019fa0
    /* renamed from: S3, reason: merged with bridge method [inline-methods] */
    public C23345wl7 T0() {
        C23345wl7.a aVar = C23345wl7.g;
        AbstractC15520jj2.f fVar = this.I0;
        if (fVar == null) {
            AbstractC13042fc3.y("feedTextMessage");
            fVar = null;
        }
        return C23345wl7.a.c(aVar, fVar.c(), null, 2, null);
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        AbstractC15520jj2.f fVar = this.I0;
        if (fVar == null) {
            AbstractC13042fc3.y("feedTextMessage");
            fVar = null;
        }
        return !(fVar.c().length() == 0);
    }

    @Override // ir.nasim.AbstractC10505bj2
    public void t3(AbstractC15520jj2 abstractC15520jj2) {
        C12800fB6 c12800fB6H3;
        AbstractC13042fc3.i(abstractC15520jj2, "feedMessage");
        CharSequence charSequenceE = p1().e(((AbstractC15520jj2.f) abstractC15520jj2).c());
        if (charSequenceE == null || (c12800fB6H3 = h3()) == null) {
            return;
        }
        TextView textView = this.G0.b;
        AbstractC13042fc3.h(textView, "feedText");
        c12800fB6H3.t(textView, charSequenceE, false);
    }

    @Override // ir.nasim.AbstractC13019fa0
    public int x1() {
        return this.H0;
    }

    @Override // ir.nasim.AbstractC13019fa0
    public void c1() {
    }
}
