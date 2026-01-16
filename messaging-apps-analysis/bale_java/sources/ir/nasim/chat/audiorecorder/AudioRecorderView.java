package ir.nasim.chat.audiorecorder;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC12152e76;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15208jB5;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC8965Xz5;
import ir.nasim.AbstractC9582aC5;
import ir.nasim.C10287bP;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C6011Lu2;
import ir.nasim.DD5;
import ir.nasim.DY6;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.Q12;
import ir.nasim.SA2;
import ir.nasim.T12;
import ir.nasim.W12;
import ir.nasim.chat.audiorecorder.AudioRecorderView;
import java.util.Arrays;
import kotlin.Metadata;
import org.xbill.DNS.WKSRecord;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 i2\u00020\u0001:\u0003jklB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u0019J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0001\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010\u0013J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020 H\u0002¢\u0006\u0004\b%\u0010#J\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010\u0019J\u000f\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u0019J!\u0010*\u001a\u00020\f2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010\u0019J!\u0010.\u001a\u00020-2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(H\u0002¢\u0006\u0004\b.\u0010/J\u001d\u00101\u001a\u00020\f*\u0002002\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u00020\u0014H\u0003¢\u0006\u0004\b5\u00106J\u0013\u00108\u001a\u00020\f*\u000207H\u0002¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020\f*\u000207H\u0002¢\u0006\u0004\b:\u00109J\u0013\u0010;\u001a\u00020\f*\u000207H\u0002¢\u0006\u0004\b;\u00109J\u0013\u0010<\u001a\u00020\f*\u000207H\u0002¢\u0006\u0004\b<\u00109J!\u0010=\u001a\u00020\f2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(H\u0002¢\u0006\u0004\b=\u0010+J\u000f\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010\u0019J\u000f\u0010?\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010\u0019J\u000f\u0010@\u001a\u00020\fH\u0002¢\u0006\u0004\b@\u0010\u0019J\u0017\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u0011H\u0002¢\u0006\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR*\u0010R\u001a\u00020J2\u0006\u0010K\u001a\u00020J8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010WR\u0016\u0010]\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\\R$\u0010h\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g¨\u0006m"}, d2 = {"Lir/nasim/chat/audiorecorder/AudioRecorderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "Lir/nasim/rB7;", "onMeasure", "(II)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "startTime", "X0", "(J)V", "F0", "()V", "P0", "id", "Landroid/view/animation/Animation;", "D0", "(I)Landroid/view/animation/Animation;", "B0", "", "slideY", "e1", "(F)V", "slideX", "d1", "H0", "f1", "Lkotlin/Function0;", "doOnEnd", "a1", "(Lir/nasim/SA2;)V", "V0", "Landroid/view/View;", "m1", "(Lir/nasim/SA2;)Landroid/view/View;", "Landroid/widget/TextView;", "q1", "(Landroid/widget/TextView;J)V", "time", "", "C0", "(J)Ljava/lang/String;", "Landroid/widget/ImageView;", "x0", "(Landroid/widget/ImageView;)V", "s1", "z0", "y0", "i1", "Y0", "o1", "g1", "isBound", "c1", "(Z)V", "Lir/nasim/bP;", "y", "Lir/nasim/Yu3;", "getBinding", "()Lir/nasim/bP;", "binding", "Lir/nasim/chat/audiorecorder/AudioRecorderView$c;", "value", "z", "Lir/nasim/chat/audiorecorder/AudioRecorderView$c;", "getState", "()Lir/nasim/chat/audiorecorder/AudioRecorderView$c;", "setState", "(Lir/nasim/chat/audiorecorder/AudioRecorderView$c;)V", "state", "A", "Z", "canBeLocked", "B", TokenNames.F, "firstTouchPointX", "D", "firstTouchPointY", "G", TokenNames.I, "maxSlideX", "H", "J", "previousUpOrCancelEventTime", "firstPointerId", "Lir/nasim/chat/audiorecorder/AudioRecorderView$b;", "Lir/nasim/chat/audiorecorder/AudioRecorderView$b;", "getListener", "()Lir/nasim/chat/audiorecorder/AudioRecorderView$b;", "setListener", "(Lir/nasim/chat/audiorecorder/AudioRecorderView$b;)V", "listener", "A0", "b", "c", "a", "chat_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class AudioRecorderView extends ConstraintLayout {
    private static final a A0 = new a(null);
    public static final int B0 = 8;
    private static final int C0 = (int) ((WKSRecord.Service.EMFIS_DATA * AbstractC3742Cd6.c()) + 0.5d);

    /* renamed from: A, reason: from kotlin metadata */
    private boolean canBeLocked;

    /* renamed from: B, reason: from kotlin metadata */
    private float firstTouchPointX;

    /* renamed from: D, reason: from kotlin metadata */
    private float firstTouchPointY;

    /* renamed from: G, reason: from kotlin metadata */
    private int maxSlideX;

    /* renamed from: H, reason: from kotlin metadata */
    private long previousUpOrCancelEventTime;

    /* renamed from: J, reason: from kotlin metadata */
    private int firstPointerId;

    /* renamed from: y, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 binding;

    /* renamed from: z, reason: from kotlin metadata */
    private c state;

    /* renamed from: z0, reason: from kotlin metadata */
    private b listener;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        void a(View view);

        void b(View view);

        void d();

        boolean e();

        void f();

        void g();

        void h();

        void i();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {
        public static final c a = new a("IDLE", 0);
        public static final c b = new C0982c("RECORDING", 1);
        public static final c c = new d("RECORDING_LOCKED", 2);
        public static final c d = new b("RECORDED", 3);
        private static final /* synthetic */ c[] e;
        private static final /* synthetic */ F92 f;

        static final class a extends c {
            a(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.c
            public boolean j(c cVar) {
                AbstractC13042fc3.i(cVar, "currentState");
                return true;
            }
        }

        static final class b extends c {
            b(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.c
            public boolean j(c cVar) {
                AbstractC13042fc3.i(cVar, "currentState");
                return cVar == c.b || cVar == c.c;
            }
        }

        /* renamed from: ir.nasim.chat.audiorecorder.AudioRecorderView$c$c, reason: collision with other inner class name */
        static final class C0982c extends c {
            C0982c(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.c
            public boolean j(c cVar) {
                AbstractC13042fc3.i(cVar, "currentState");
                return cVar == c.a;
            }
        }

        static final class d extends c {
            d(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.c
            public boolean j(c cVar) {
                AbstractC13042fc3.i(cVar, "currentState");
                return cVar == c.b || cVar == c.d;
            }
        }

        static {
            c[] cVarArrA = a();
            e = cVarArrA;
            f = G92.a(cVarArrA);
        }

        public /* synthetic */ c(String str, int i, ED1 ed1) {
            this(str, i);
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b, c, d};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) e.clone();
        }

        public abstract boolean j(c cVar);

        public final boolean p() {
            return this == b || this == c;
        }

        private c(String str, int i) {
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        final /* synthetic */ ViewSwitcher a;

        public d(ViewSwitcher viewSwitcher) {
            this.a = viewSwitcher;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            this.a.setDisplayedChild(1);
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        final /* synthetic */ ViewSwitcher a;

        public e(ViewSwitcher viewSwitcher) {
            this.a = viewSwitcher;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            this.a.setDisplayedChild(1);
        }
    }

    static final class f implements Runnable {
        private final /* synthetic */ SA2 a;

        f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "function");
            this.a = sa2;
        }

        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.a.invoke();
        }
    }

    public static final class g implements View.OnLayoutChangeListener {
        final /* synthetic */ SA2 b;

        public g(SA2 sa2) {
            this.b = sa2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            if (AudioRecorderView.this.getState() != c.a) {
                view.setTranslationX(view.getWidth());
                view.setVisibility(0);
                ViewPropertyAnimator viewPropertyAnimatorTranslationX = view.animate().translationX(0.0f);
                SA2 sa2 = this.b;
                viewPropertyAnimatorTranslationX.withEndAction(sa2 != null ? new f(sa2) : null).setDuration(130L);
                AudioRecorderView.j1(AudioRecorderView.this, null, 1, null);
            }
        }
    }

    public static final class h implements Runnable {
        private long a;
        final /* synthetic */ long b;
        final /* synthetic */ TextView c;
        final /* synthetic */ AudioRecorderView d;

        h(long j, TextView textView, AudioRecorderView audioRecorderView) {
            this.b = j;
            this.c = textView;
            this.d = audioRecorderView;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.c.setText(AbstractC12152e76.b(this.d.C0(jCurrentTimeMillis - this.b)));
            if (this.d.getState().p()) {
                this.c.postDelayed(this, AbstractC23053wG5.f(100 - (jCurrentTimeMillis - this.a), 0L));
                this.a = jCurrentTimeMillis;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AudioRecorderView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10287bP A0(Context context, AudioRecorderView audioRecorderView) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        C10287bP c10287bPB = C10287bP.b(LayoutInflater.from(context), audioRecorderView);
        c10287bPB.b.setTypeface(C6011Lu2.k());
        c10287bPB.d.setTypeface(C6011Lu2.k());
        c10287bPB.c.setTypeface(C6011Lu2.i());
        ViewSwitcher viewSwitcher = c10287bPB.h;
        viewSwitcher.setInAnimation(audioRecorderView.D0(R.anim.fade_in));
        viewSwitcher.setOutAnimation(audioRecorderView.D0(R.anim.fade_out));
        ViewSwitcher viewSwitcher2 = c10287bPB.j;
        viewSwitcher2.setInAnimation(audioRecorderView.D0(AbstractC8965Xz5.slide_in_top));
        viewSwitcher2.setOutAnimation(audioRecorderView.D0(AbstractC8965Xz5.slide_out_bottom));
        TextView textView = c10287bPB.d;
        textView.setMinWidth(AbstractC20723sV3.d(textView.getPaint().measureText("99:99.9")));
        return c10287bPB;
    }

    private final boolean B0(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            return System.currentTimeMillis() - this.previousUpOrCancelEventTime >= 400;
        }
        if (action == 1 || action == 3) {
            this.previousUpOrCancelEventTime = System.currentTimeMillis();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String C0(long time) {
        long jT = T12.t(time, W12.d);
        long j = 60;
        long jB = Q12.B(jT) % j;
        long jD = Q12.D(jT) % j;
        if (Q12.y(jT) > 0) {
            DY6 dy6 = DY6.a;
            String str = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(Q12.y(jT)), Long.valueOf(jB), Long.valueOf(jD)}, 3));
            AbstractC13042fc3.h(str, "format(...)");
            return str;
        }
        DY6 dy62 = DY6.a;
        String str2 = String.format("%d:%02d.%d", Arrays.copyOf(new Object[]{Long.valueOf(jB), Long.valueOf(jD), Long.valueOf((Q12.A(jT) / 100) % 10)}, 3));
        AbstractC13042fc3.h(str2, "format(...)");
        return str2;
    }

    private final Animation D0(int id) throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), id);
        animationLoadAnimation.setDuration(130L);
        return animationLoadAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G0(C10287bP c10287bP, AudioRecorderView audioRecorderView) {
        AbstractC13042fc3.i(c10287bP, "$this_with");
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        ViewSwitcher viewSwitcher = c10287bP.j;
        AbstractC13042fc3.f(viewSwitcher);
        ViewGroup.LayoutParams layoutParams = viewSwitcher.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.d = -1;
        layoutParams2.f = c10287bP.i.getId();
        layoutParams2.g = -1;
        viewSwitcher.setLayoutParams(layoutParams2);
        viewSwitcher.setDisplayedChild(0);
        viewSwitcher.getChildAt(1).setOnClickListener(null);
        ViewSwitcher viewSwitcher2 = c10287bP.h;
        viewSwitcher2.setDisplayedChild(0);
        viewSwitcher2.setOnClickListener(null);
        AppCompatImageView appCompatImageView = c10287bP.i;
        appCompatImageView.setOnClickListener(null);
        AbstractC13042fc3.f(appCompatImageView);
        audioRecorderView.z0(appCompatImageView);
        audioRecorderView.g1();
        audioRecorderView.o1();
        audioRecorderView.f1();
        audioRecorderView.c1(true);
        c10287bP.f.setImageResource(AbstractC15208jB5.bold_lock);
        return C19938rB7.a;
    }

    private final void H0() {
        final C10287bP binding = getBinding();
        C19406qI3.a("AudioRecorderView", "goToLockedState(currentState: " + this.state + Separators.RPAREN, new Object[0]);
        c cVar = this.state;
        c cVar2 = c.c;
        if (cVar == cVar2) {
            return;
        }
        if (!cVar2.j(cVar)) {
            C19406qI3.j("AudioRecorderView", "goToLockedState() called on an invalid state(" + this.state + ").", new Object[0]);
            return;
        }
        setState(cVar2);
        i1(new SA2() { // from class: ir.nasim.VO
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AudioRecorderView.I0(binding);
            }
        });
        binding.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.WO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecorderView.J0(this.a, view);
            }
        });
        AppCompatImageView appCompatImageView = binding.i;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecorderView.K0(this.a, view);
            }
        });
        AbstractC13042fc3.f(appCompatImageView);
        y0(appCompatImageView);
        appCompatImageView.animate().translationX(0.0f).setDuration(130L);
        ViewSwitcher viewSwitcher = binding.j;
        AbstractC13042fc3.f(viewSwitcher);
        ViewGroup.LayoutParams layoutParams = viewSwitcher.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.f = -1;
        layoutParams2.d = 0;
        layoutParams2.g = 0;
        viewSwitcher.setLayoutParams(layoutParams2);
        if (!viewSwitcher.isLaidOut() || viewSwitcher.isLayoutRequested()) {
            viewSwitcher.addOnLayoutChangeListener(new d(viewSwitcher));
        } else {
            viewSwitcher.setDisplayedChild(1);
        }
        binding.c.setText(DD5.chat_voice_record_lock_cancel);
        viewSwitcher.getChildAt(1).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.YO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecorderView.L0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I0(C10287bP c10287bP) {
        AbstractC13042fc3.i(c10287bP, "$this_with");
        c10287bP.h.setDisplayedChild(1);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(AudioRecorderView audioRecorderView, View view) {
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        b bVar = audioRecorderView.listener;
        if (bVar != null) {
            bVar.g();
        }
        audioRecorderView.P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(AudioRecorderView audioRecorderView, View view) {
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        b bVar = audioRecorderView.listener;
        if (bVar != null) {
            bVar.d();
        }
        audioRecorderView.F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(AudioRecorderView audioRecorderView, View view) {
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        b bVar = audioRecorderView.listener;
        if (bVar != null) {
            bVar.f();
        }
        audioRecorderView.F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(AudioRecorderView audioRecorderView, View view) {
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        b bVar = audioRecorderView.listener;
        if (bVar != null) {
            bVar.d();
        }
        audioRecorderView.F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(AudioRecorderView audioRecorderView, View view) {
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        b bVar = audioRecorderView.listener;
        if (bVar != null) {
            bVar.f();
        }
        audioRecorderView.F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(AudioRecorderView audioRecorderView, View view) {
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        b bVar = audioRecorderView.listener;
        if (bVar != null) {
            bVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(AudioRecorderView audioRecorderView, View view) {
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        b bVar = audioRecorderView.listener;
        if (bVar != null) {
            bVar.f();
        }
        audioRecorderView.F0();
    }

    private final void V0() {
        final C10287bP binding = getBinding();
        C19406qI3.a("AudioRecorderView", "goToRecordingState(currentState: " + this.state + Separators.RPAREN, new Object[0]);
        c cVar = this.state;
        c cVar2 = c.b;
        if (cVar == cVar2) {
            return;
        }
        if (!cVar2.j(cVar)) {
            C19406qI3.j("AudioRecorderView", "goToRecordingState() called on an invalid state.", new Object[0]);
            return;
        }
        b bVar = this.listener;
        if (bVar == null || !bVar.e()) {
            return;
        }
        setState(cVar2);
        b bVar2 = this.listener;
        if (bVar2 != null) {
            ViewSwitcher viewSwitcher = binding.h;
            AbstractC13042fc3.h(viewSwitcher, "lockViewSwitcher");
            bVar2.b(viewSwitcher);
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        e1(0.0f);
        d1(0.0f);
        c1(false);
        m1(new SA2() { // from class: ir.nasim.UO
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AudioRecorderView.W0(this.a, binding, jCurrentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W0(AudioRecorderView audioRecorderView, C10287bP c10287bP, long j) {
        AbstractC13042fc3.i(audioRecorderView, "this$0");
        AbstractC13042fc3.i(c10287bP, "$this_with");
        TextView textView = c10287bP.d;
        AbstractC13042fc3.h(textView, "durationTextView");
        audioRecorderView.q1(textView, j);
        AppCompatImageView appCompatImageView = c10287bP.e;
        AbstractC13042fc3.h(appCompatImageView, "endImageView");
        audioRecorderView.x0(appCompatImageView);
        return C19938rB7.a;
    }

    private final void Y0() {
        final ViewSwitcher viewSwitcher = getBinding().h;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = viewSwitcher.animate();
        AbstractC13042fc3.f(viewSwitcher);
        ViewGroup.LayoutParams layoutParams = viewSwitcher.getLayoutParams();
        viewPropertyAnimatorAnimate.translationY(((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r2.bottomMargin : 0) + viewSwitcher.getHeight()).scaleX(0.0f).scaleY(0.0f).withEndAction(new Runnable() { // from class: ir.nasim.TO
            @Override // java.lang.Runnable
            public final void run() {
                AudioRecorderView.Z0(viewSwitcher);
            }
        }).setDuration(130L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(ViewSwitcher viewSwitcher) {
        AbstractC13042fc3.i(viewSwitcher, "$this_with");
        viewSwitcher.setVisibility(8);
    }

    private final void a1(final SA2 doOnEnd) {
        final View root = getBinding().getRoot();
        Animation animation = root.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        root.clearAnimation();
        root.animate().translationX(root.getWidth()).withEndAction(new Runnable() { // from class: ir.nasim.LO
            @Override // java.lang.Runnable
            public final void run() {
                AudioRecorderView.b1(doOnEnd, root);
            }
        }).setDuration(130L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(SA2 sa2, View view) {
        AbstractC13042fc3.i(view, "$this_with");
        if (sa2 != null) {
            sa2.invoke();
        }
        view.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.view.ViewGroup] */
    private final void c1(boolean isBound) {
        ViewParent parent = getParent();
        AudioRecorderView audioRecorderView = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        AudioRecorderView audioRecorderView2 = this;
        while (audioRecorderView != null) {
            audioRecorderView.setClipChildren(isBound);
            audioRecorderView.setClipToPadding(isBound);
            audioRecorderView.bringChildToFront(audioRecorderView2);
            if (audioRecorderView.getId() != AbstractC9582aC5.container) {
                ViewParent parent2 = audioRecorderView.getParent();
                if (parent2 instanceof ViewGroup) {
                    ?? r1 = (ViewGroup) parent2;
                    audioRecorderView2 = audioRecorderView;
                    audioRecorderView = r1;
                } else {
                    audioRecorderView2 = audioRecorderView;
                }
            }
            audioRecorderView = null;
        }
    }

    private final void d1(float slideX) {
        C10287bP binding = getBinding();
        float f2 = -slideX;
        int left = binding.j.getLeft() - binding.d.getRight();
        TextView textView = binding.b;
        textView.setTranslationX(f2);
        textView.setAlpha(1.0f - (slideX / left));
        binding.i.setTranslationX(f2);
    }

    private final void e1(float slideY) {
        C10287bP binding = getBinding();
        if (this.canBeLocked) {
            ViewSwitcher viewSwitcher = binding.h;
            Animation animation = viewSwitcher.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            viewSwitcher.clearAnimation();
            viewSwitcher.setTranslationY(-slideY);
        }
    }

    private final void f1() {
        this.canBeLocked = true;
        this.firstTouchPointX = 0.0f;
        this.firstTouchPointY = 0.0f;
        this.firstPointerId = -1;
    }

    private final void g1() {
        final TextView textView = getBinding().b;
        textView.animate().alpha(1.0f).withStartAction(new Runnable() { // from class: ir.nasim.NO
            @Override // java.lang.Runnable
            public final void run() {
                AudioRecorderView.h1(textView);
            }
        }).setDuration(130L);
    }

    private final C10287bP getBinding() {
        return (C10287bP) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(TextView textView) {
        AbstractC13042fc3.i(textView, "$this_with");
        textView.setVisibility(0);
    }

    private final void i1(final SA2 doOnEnd) {
        final ViewSwitcher viewSwitcher = getBinding().h;
        viewSwitcher.animate().withStartAction(new Runnable() { // from class: ir.nasim.KO
            @Override // java.lang.Runnable
            public final void run() {
                AudioRecorderView.k1(viewSwitcher);
            }
        }).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).withEndAction(doOnEnd != null ? new Runnable() { // from class: ir.nasim.SO
            @Override // java.lang.Runnable
            public final void run() {
                AudioRecorderView.l1(doOnEnd);
            }
        } : null).setDuration(130L);
    }

    static /* synthetic */ void j1(AudioRecorderView audioRecorderView, SA2 sa2, int i, Object obj) {
        if ((i & 1) != 0) {
            sa2 = null;
        }
        audioRecorderView.i1(sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(ViewSwitcher viewSwitcher) {
        AbstractC13042fc3.i(viewSwitcher, "$this_with");
        viewSwitcher.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(SA2 sa2) {
        sa2.invoke();
    }

    private final View m1(SA2 doOnEnd) {
        View root = getBinding().getRoot();
        Animation animation = root.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        root.clearAnimation();
        AbstractC13042fc3.f(root);
        root.setVisibility(4);
        root.requestLayout();
        if (!root.isLaidOut() || root.isLayoutRequested()) {
            root.addOnLayoutChangeListener(new g(doOnEnd));
        } else if (getState() != c.a) {
            root.setTranslationX(root.getWidth());
            root.setVisibility(0);
            root.animate().translationX(0.0f).withEndAction(doOnEnd != null ? new f(doOnEnd) : null).setDuration(130L);
            j1(this, null, 1, null);
        }
        AbstractC13042fc3.h(root, "with(...)");
        return root;
    }

    private final void o1() {
        final ViewSwitcher viewSwitcher = getBinding().j;
        viewSwitcher.animate().alpha(1.0f).withStartAction(new Runnable() { // from class: ir.nasim.MO
            @Override // java.lang.Runnable
            public final void run() {
                AudioRecorderView.p1(viewSwitcher);
            }
        }).setDuration(130L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(ViewSwitcher viewSwitcher) {
        AbstractC13042fc3.i(viewSwitcher, "$this_with");
        viewSwitcher.setVisibility(0);
    }

    private final void q1(TextView textView, long j) {
        textView.setText(AbstractC12152e76.b(C0(0L)));
        textView.post(new h(j, textView, this));
    }

    private final void s1(ImageView imageView) {
        Animation animation = imageView.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        imageView.clearAnimation();
        imageView.setAlpha(0.0f);
    }

    private final void setState(c cVar) {
        C19406qI3.a("AudioRecorderView", "newState: " + cVar, new Object[0]);
        this.state = cVar;
    }

    private final void x0(ImageView imageView) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
        imageView.setAnimation(alphaAnimation);
        imageView.setAlpha(1.0f);
        imageView.animate();
    }

    private final void y0(ImageView imageView) {
        imageView.setImageResource(AbstractC15208jB5.bold_send_2);
        double d2 = 10;
        imageView.setPadding((int) ((2 * AbstractC3742Cd6.c()) + 0.5d), (int) ((AbstractC3742Cd6.c() * d2) + 0.5d), 0, (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d));
    }

    private final void z0(ImageView imageView) {
        imageView.setImageResource(AbstractC15208jB5.bold_voice);
        int iC = (int) ((10 * AbstractC3742Cd6.c()) + 0.5d);
        imageView.setPadding(iC, iC, iC, iC);
    }

    public final void F0() {
        final C10287bP binding = getBinding();
        C19406qI3.a("AudioRecorderView", "goToIdleState(currentState: " + this.state + Separators.RPAREN, new Object[0]);
        c cVar = this.state;
        c cVar2 = c.a;
        if (cVar == cVar2) {
            return;
        }
        if (!cVar2.j(cVar)) {
            C19406qI3.j("AudioRecorderView", "goToIdleState() called on an invalid state(" + this.state + ").", new Object[0]);
            return;
        }
        setState(cVar2);
        b bVar = this.listener;
        if (bVar != null) {
            ViewSwitcher viewSwitcher = binding.h;
            AbstractC13042fc3.h(viewSwitcher, "lockViewSwitcher");
            bVar.a(viewSwitcher);
        }
        a1(new SA2() { // from class: ir.nasim.aP
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AudioRecorderView.G0(binding, this);
            }
        });
    }

    public final void P0() {
        C10287bP binding = getBinding();
        C19406qI3.a("AudioRecorderView", "goToRecordedState(currentState: " + this.state + Separators.RPAREN, new Object[0]);
        c cVar = this.state;
        c cVar2 = c.d;
        if (cVar == cVar2) {
            return;
        }
        if (!cVar2.j(cVar)) {
            C19406qI3.j("AudioRecorderView", "goToRecordedState() called on an invalid state(" + this.state + ").", new Object[0]);
            return;
        }
        setState(cVar2);
        AppCompatImageView appCompatImageView = binding.i;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.OO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecorderView.R0(this.a, view);
            }
        });
        AbstractC13042fc3.f(appCompatImageView);
        y0(appCompatImageView);
        AppCompatImageView appCompatImageView2 = binding.e;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.PO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecorderView.S0(this.a, view);
            }
        });
        AbstractC13042fc3.f(appCompatImageView2);
        s1(appCompatImageView2);
        ViewSwitcher viewSwitcher = binding.h;
        viewSwitcher.setContentDescription(viewSwitcher.getContext().getString(DD5.media_audio));
        binding.f.setImageResource(AbstractC15208jB5.bold_voice);
        viewSwitcher.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.QO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecorderView.T0(this.a, view);
            }
        });
        viewSwitcher.setDisplayedChild(0);
        j1(this, null, 1, null);
        ViewSwitcher viewSwitcher2 = binding.j;
        AbstractC13042fc3.f(viewSwitcher2);
        ViewGroup.LayoutParams layoutParams = viewSwitcher2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.f = -1;
        layoutParams2.d = 0;
        layoutParams2.g = 0;
        viewSwitcher2.setLayoutParams(layoutParams2);
        if (!viewSwitcher2.isLaidOut() || viewSwitcher2.isLayoutRequested()) {
            viewSwitcher2.addOnLayoutChangeListener(new e(viewSwitcher2));
        } else {
            viewSwitcher2.setDisplayedChild(1);
        }
        binding.c.setText(DD5.chat_voice_record_recorded_cancel);
        viewSwitcher2.getChildAt(1).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.RO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecorderView.U0(this.a, view);
            }
        });
    }

    public final void X0(long startTime) {
        C10287bP binding = getBinding();
        TextView textView = binding.d;
        AbstractC13042fc3.h(textView, "durationTextView");
        q1(textView, startTime);
        AppCompatImageView appCompatImageView = binding.e;
        AbstractC13042fc3.h(appCompatImageView, "endImageView");
        x0(appCompatImageView);
        H0();
    }

    public final b getListener() {
        return this.listener;
    }

    public final c getState() {
        return this.state;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        getBinding();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.maxSlideX = Math.min((getMeasuredWidth() * 2) / 3, C0);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00f3  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.chat.audiorecorder.AudioRecorderView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setListener(b bVar) {
        this.listener = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AudioRecorderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ AudioRecorderView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecorderView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.binding = AbstractC13269fw3.b(EnumC4870Gx3.c, new SA2() { // from class: ir.nasim.ZO
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AudioRecorderView.A0(context, this);
            }
        });
        this.state = c.a;
        this.canBeLocked = true;
        this.maxSlideX = C0;
        this.firstPointerId = -1;
        setClipChildren(false);
        setClipToPadding(false);
        setLayoutDirection(1);
        if (isInEditMode()) {
            getBinding();
        }
    }
}
