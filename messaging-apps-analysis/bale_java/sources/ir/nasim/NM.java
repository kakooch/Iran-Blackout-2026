package ir.nasim;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C20882sl7;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.M44;
import ir.nasim.MW1;
import ir.nasim.N15;
import ir.nasim.NM;
import ir.nasim.X2;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.holder.bubble.voicetotext.AudioToTextImageButton;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.ContentHeightMatchedTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes5.dex */
public final class NM extends C20882sl7 implements O44, WZ {
    public static final a C0 = new a(null);
    public static final int D0 = 8;
    private final InterfaceC9173Yu3 A;
    private final PM A0;
    private AbstractC17683nO B;
    private final InterfaceC9173Yu3 B0;
    private long D;
    private String G;
    private T74 H;
    private C8967Xz7 J;
    private final AccessibilityManager Y;
    private View Z;
    private final XZ r;
    private final long s;
    private final long t;
    private final boolean u;
    private final ConstraintLayout v;
    private final C7547Se3 w;
    private C22007uW1 x;
    private boolean y;
    private boolean z;
    private final InterfaceC9173Yu3 z0;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b extends View.AccessibilityDelegate {
        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            AbstractC13042fc3.i(view, "host");
            if (i == 32768) {
                i = 65536;
            }
            super.sendAccessibilityEvent(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            AbstractC13042fc3.i(view, "host");
            AbstractC13042fc3.i(accessibilityEvent, "event");
            if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 4) {
                return;
            }
            super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public static final class c extends C20882sl7.b {
        private final long c;
        private final long d;
        private final boolean e;
        private final XZ f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z, long j, long j2, boolean z2, XZ xz, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(xz, "lifecycleOwner");
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.c = j;
            this.d = j2;
            this.e = z2;
            this.f = xz;
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new NM(c15481jf3, z, c(), this.f, this.c, this.d, this.e, null);
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC9477a18.values().length];
            try {
                iArr[EnumC9477a18.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC9477a18.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC9477a18.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[DocumentStateButton.a.values().length];
            try {
                iArr2[DocumentStateButton.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DocumentStateButton.a.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DocumentStateButton.a.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DocumentStateButton.a.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        final /* synthetic */ MessageEmojiTextView a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ NM d;
        final /* synthetic */ C8967Xz7 e;

        public e(MessageEmojiTextView messageEmojiTextView, int i, boolean z, NM nm, C8967Xz7 c8967Xz7) {
            this.a = messageEmojiTextView;
            this.b = i;
            this.c = z;
            this.d = nm;
            this.e = c8967Xz7;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            Layout layout = this.a.getLayout();
            if (Math.abs((layout != null ? layout.getLineCount() : this.a.getLineCount()) - this.b) >= 8 && this.c) {
                this.a.post(this.d.new f(this.e));
            }
            this.d.B0().r();
        }
    }

    static final class f implements Runnable {
        final /* synthetic */ C8967Xz7 b;

        f(C8967Xz7 c8967Xz7) {
            this.b = c8967Xz7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NM.this.z0().d().a(this.b.j());
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C8967Xz7 d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NM d;
            final /* synthetic */ C8967Xz7 e;

            /* renamed from: ir.nasim.NM$g$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0531a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC9477a18.values().length];
                    try {
                        iArr[EnumC9477a18.b.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC9477a18.c.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC9477a18.d.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(NM nm, C8967Xz7 c8967Xz7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = nm;
                this.e = c8967Xz7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    ir.nasim.AbstractC13660gc3.e()
                    int r0 = r5.b
                    if (r0 != 0) goto Lb8
                    ir.nasim.AbstractC10685c16.b(r6)
                    java.lang.Object r6 = r5.c
                    ir.nasim.a18 r6 = (ir.nasim.EnumC9477a18) r6
                    int[] r0 = ir.nasim.NM.g.a.C0531a.a
                    int r6 = r6.ordinal()
                    r6 = r0[r6]
                    r0 = 1
                    java.lang.String r1 = "getString(...)"
                    if (r6 == r0) goto L88
                    r0 = 2
                    if (r6 == r0) goto L88
                    r0 = 3
                    if (r6 != r0) goto L82
                    ir.nasim.NM r6 = r5.d
                    ir.nasim.Xz7 r0 = r5.e
                    ir.nasim.J44 r0 = r0.j()
                    ir.nasim.n0 r0 = r0.F()
                    boolean r2 = r0 instanceof ir.nasim.J08
                    if (r2 == 0) goto L34
                    ir.nasim.J08 r0 = (ir.nasim.J08) r0
                    goto L35
                L34:
                    r0 = 0
                L35:
                    if (r0 == 0) goto L56
                    ir.nasim.Xz7 r2 = r5.e
                    java.lang.String r2 = r2.e()
                    ir.nasim.NM r3 = r5.d
                    ir.nasim.jf3 r3 = r3.x0()
                    androidx.constraintlayout.widget.ConstraintLayout r3 = r3.getRoot()
                    android.content.Context r3 = r3.getContext()
                    java.lang.String r4 = "getContext(...)"
                    ir.nasim.AbstractC13042fc3.h(r3, r4)
                    java.lang.String r0 = r0.M(r2, r3)
                    if (r0 != 0) goto L5c
                L56:
                    ir.nasim.Xz7 r0 = r5.e
                    java.lang.String r0 = r0.e()
                L5c:
                    ir.nasim.NM.r1(r6, r0)
                    ir.nasim.NM r6 = r5.d
                    ir.nasim.jf3 r6 = r6.x0()
                    androidx.constraintlayout.widget.ConstraintLayout r6 = r6.getRoot()
                    android.content.Context r6 = r6.getContext()
                    int r0 = ir.nasim.AbstractC12217eE5.voice_to_text_off_c_d
                    java.lang.String r6 = r6.getString(r0)
                    ir.nasim.AbstractC13042fc3.h(r6, r1)
                    ir.nasim.NM r0 = r5.d
                    ir.nasim.Se3 r0 = r0.X1()
                    ir.nasim.features.conversation.messages.content.adapter.holder.bubble.voicetotext.AudioToTextImageButton r0 = r0.i
                    r0.setContentDescription(r6)
                    goto Lb5
                L82:
                    kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                    r6.<init>()
                    throw r6
                L88:
                    ir.nasim.NM r6 = r5.d
                    ir.nasim.Xz7 r0 = r5.e
                    java.lang.String r0 = r0.e()
                    ir.nasim.NM.r1(r6, r0)
                    ir.nasim.NM r6 = r5.d
                    ir.nasim.jf3 r6 = r6.x0()
                    androidx.constraintlayout.widget.ConstraintLayout r6 = r6.getRoot()
                    android.content.Context r6 = r6.getContext()
                    int r0 = ir.nasim.AbstractC12217eE5.voice_to_text_on_c_d
                    java.lang.String r6 = r6.getString(r0)
                    ir.nasim.AbstractC13042fc3.h(r6, r1)
                    ir.nasim.NM r0 = r5.d
                    ir.nasim.Se3 r0 = r0.X1()
                    ir.nasim.features.conversation.messages.content.adapter.holder.bubble.voicetotext.AudioToTextImageButton r0 = r0.i
                    r0.setContentDescription(r6)
                Lb5:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                Lb8:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NM.g.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EnumC9477a18 enumC9477a18, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enumC9477a18, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C8967Xz7 c8967Xz7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c8967Xz7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NM.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 state = NM.this.X1().i.getState();
                a aVar = new a(NM.this, this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(state, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class h extends AbstractC17683nO {
        final /* synthetic */ C9663aL5 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;

        h(C9663aL5 c9663aL5, boolean z, boolean z2) {
            this.b = c9663aL5;
            this.c = z;
            this.d = z2;
        }

        @Override // ir.nasim.AbstractC17683nO
        public void c(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            NM nm = NM.this;
            C9663aL5 c9663aL5 = this.b;
            boolean z = this.c;
            boolean z2 = this.d;
            if (AbstractC13042fc3.d(vl.d(), NM.this.H)) {
                C7547Se3 c7547Se3X1 = nm.X1();
                AppCompatSeekBar appCompatSeekBar = c7547Se3X1.e;
                appCompatSeekBar.setProgress(0);
                AbstractC13042fc3.f(appCompatSeekBar);
                nm.n2(appCompatSeekBar, false);
                nm.d2(appCompatSeekBar, z2, z2);
                ContentHeightMatchedTextView contentHeightMatchedTextView = c7547Se3X1.b;
                AbstractC13042fc3.h(contentHeightMatchedTextView, "audioArtist");
                nm.d2(contentHeightMatchedTextView, z, z2);
                c7547Se3X1.c.r(AbstractC17636nI6.i(nm.G));
                nm.u2(false);
                c9663aL5.a = true;
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void f(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            NM nm = NM.this;
            if (AbstractC13042fc3.d(vl.d(), NM.this.H)) {
                View view = nm.Z;
                if (view != null) {
                    nm.s2(view);
                }
                nm.u2(false);
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void g(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            NM nm = NM.this;
            boolean z = this.d;
            C9663aL5 c9663aL5 = this.b;
            if (AbstractC13042fc3.d(vl.d(), NM.this.H)) {
                C7547Se3 c7547Se3X1 = nm.X1();
                View view = nm.Z;
                if (view != null) {
                    nm.s2(view);
                }
                AppCompatSeekBar appCompatSeekBar = c7547Se3X1.e;
                AbstractC13042fc3.f(appCompatSeekBar);
                nm.d2(appCompatSeekBar, true, z);
                nm.n2(appCompatSeekBar, true);
                if (c9663aL5.a) {
                    appCompatSeekBar.setProgress(0);
                    nm.v2(0L);
                    c9663aL5.a = false;
                }
                ContentHeightMatchedTextView contentHeightMatchedTextView = c7547Se3X1.b;
                AbstractC13042fc3.h(contentHeightMatchedTextView, "audioArtist");
                nm.d2(contentHeightMatchedTextView, false, z);
                nm.u2(true);
            }
        }

        @Override // ir.nasim.AbstractC17683nO
        public void h(VL vl, long j) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            NM nm = NM.this;
            if (AbstractC13042fc3.d(vl.d(), NM.this.H)) {
                nm.X1().e.setProgress((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
                nm.v2(j);
            }
        }
    }

    public static final class i extends GestureDetector.SimpleOnGestureListener {
        private final int a;
        private final int b = 8;
        final /* synthetic */ AppCompatSeekBar c;

        i(AppCompatSeekBar appCompatSeekBar) {
            this.c = appCompatSeekBar;
            this.a = ViewConfiguration.get(appCompatSeekBar.getContext()).getScaledTouchSlop();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AbstractC13042fc3.i(motionEvent2, "e2");
            if (motionEvent == null) {
                return false;
            }
            AppCompatSeekBar appCompatSeekBar = this.c;
            float fAbs = Math.abs(motionEvent2.getX() - motionEvent.getX());
            return appCompatSeekBar.onTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent2.getEventTime() - motionEvent.getEventTime(), 2, fAbs, Math.abs(motionEvent2.getY() - motionEvent.getY()), 1)) || (((float) this.b) < fAbs && fAbs < ((float) this.a));
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C8967Xz7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(C8967Xz7 c8967Xz7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c8967Xz7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NM.this.new k(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            NM nm = NM.this;
            C8967Xz7 c8967Xz7 = this.d;
            NM.F1(nm, c8967Xz7, c8967Xz7.d(), false, 4, null);
            AudioToTextImageButton audioToTextImageButton = NM.this.X1().i;
            EnumC9477a18 enumC9477a18 = EnumC9477a18.b;
            audioToTextImageButton.setState(enumC9477a18);
            NM.this.z0().d().f(this.d, enumC9477a18, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ NM(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54, XZ xz, long j2, long j3, boolean z2, ED1 ed1) {
        this(c15481jf3, z, abstractC23538x54, xz, j2, j3, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23709xO C1() {
        return C23709xO.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(NM nm, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        nm.j(c8967Xz7.c());
        InterfaceC22948w54 interfaceC22948w54B = nm.z0().b();
        ImageView imageView = nm.w.h;
        AbstractC13042fc3.h(imageView, "moreOptions");
        interfaceC22948w54B.e(imageView, c8967Xz7);
    }

    public static /* synthetic */ void F1(NM nm, C8967Xz7 c8967Xz7, Spannable spannable, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        nm.E1(c8967Xz7, spannable, z);
    }

    private final void G1(AbstractC17757nW1.a aVar) {
        H1(aVar.e().b());
        C7547Se3 c7547Se3 = this.w;
        c7547Se3.d.r(aVar.h());
        c7547Se3.b.r(aVar.d());
        ImageView imageView = c7547Se3.h;
        AbstractC13042fc3.h(imageView, "moreOptions");
        imageView.setVisibility(aVar.i() ? 0 : 8);
        FrameLayout frameLayout = c7547Se3.g;
        AbstractC13042fc3.h(frameLayout, "frameLayout");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = AbstractC8943Xx1.c(aVar.i() ? 7 : 10);
        frameLayout.setLayoutParams(layoutParams2);
    }

    private final void H1(long j2) {
        this.D = j2;
        this.G = q2(j2);
        long j3 = this.D;
        if (j3 > 0) {
            this.w.e.setMax((int) (j3 / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
        }
    }

    private final void I1(C8967Xz7 c8967Xz7) {
        AbstractC10533bm0.d(U1(), null, null, new g(c8967Xz7, null), 3, null);
    }

    private final void J1(final C8967Xz7 c8967Xz7, final AbstractC17757nW1.a aVar) {
        final C7547Se3 c7547Se3 = this.w;
        this.H = aVar.f();
        h2(aVar);
        G1(aVar);
        c7547Se3.f.setOnClickListener(new UA2() { // from class: ir.nasim.KM
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return NM.K1(this.a, c8967Xz7, (DocumentStateButton.a) obj);
            }
        });
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
        C22007uW1 c22007uW1 = new C22007uW1(c14970in2D, aVar, null, 4, null);
        C13519gN c13519gN = C13519gN.a;
        AppCompatSeekBar appCompatSeekBar = c7547Se3.e;
        AbstractC13042fc3.h(appCompatSeekBar, "audioSeekbar");
        ContentHeightMatchedTextView contentHeightMatchedTextView = c7547Se3.b;
        AbstractC13042fc3.h(contentHeightMatchedTextView, "audioArtist");
        ContentHeightMatchedTextView contentHeightMatchedTextView2 = c7547Se3.c;
        AbstractC13042fc3.h(contentHeightMatchedTextView2, "audioDetails");
        c22007uW1.I(new YL(c13519gN, aVar, appCompatSeekBar, contentHeightMatchedTextView, contentHeightMatchedTextView2, new UA2() { // from class: ir.nasim.LM
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return NM.L1(this.a, c7547Se3, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.MM
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return NM.M1(this.a, ((Long) obj).longValue());
            }
        }));
        DocumentStateButton documentStateButton = c7547Se3.f;
        AbstractC13042fc3.h(documentStateButton, "documentStateButton");
        c22007uW1.I(new OW1(documentStateButton, Integer.valueOf(W1(C23709xO.a.x(aVar.e()))), true));
        c22007uW1.I(new CW1(new SA2() { // from class: ir.nasim.yM
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NM.N1(this.a, aVar);
            }
        }));
        ConstraintLayout root = x0().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        c22007uW1.I(new GX1(root, AbstractC12217eE5.media_audio, null, null, 12, null));
        AbstractC4767Gm.a(c22007uW1, aVar.b(), G0(), "audio/mp3");
        c22007uW1.l();
        this.x = c22007uW1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K1(NM nm, C8967Xz7 c8967Xz7, DocumentStateButton.a aVar) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(aVar, "it");
        int i2 = d.b[aVar.ordinal()];
        if (i2 == 1) {
            C22007uW1 c22007uW1 = nm.x;
            if (c22007uW1 != null) {
                c22007uW1.L();
            }
        } else if (i2 == 2) {
            InterfaceC24373yW1.h(nm.z0().d(), c8967Xz7, null, null, 6, null);
        } else if (i2 == 3) {
            C22007uW1 c22007uW12 = nm.x;
            if (c22007uW12 != null) {
                c22007uW12.H();
            }
        } else {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            nm.z0().b().l(c8967Xz7);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L1(NM nm, C7547Se3 c7547Se3, boolean z) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(c7547Se3, "$this_with");
        AppCompatSeekBar appCompatSeekBar = c7547Se3.e;
        AbstractC13042fc3.h(appCompatSeekBar, "audioSeekbar");
        nm.n2(appCompatSeekBar, z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M1(NM nm, long j2) {
        AbstractC13042fc3.i(nm, "this$0");
        nm.H1(j2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N1(NM nm, AbstractC17757nW1.a aVar) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(aVar, "$document");
        nm.z = aVar.i();
        nm.y = true;
        return C19938rB7.a;
    }

    private final void O1(final AbstractC17757nW1.a aVar, final C8967Xz7 c8967Xz7) {
        AudioToTextImageButton audioToTextImageButton = this.w.i;
        EnumC9477a18 enumC9477a18 = EnumC9477a18.b;
        audioToTextImageButton.setState(enumC9477a18);
        AbstractC17457n0 abstractC17457n0F = c8967Xz7.j().F();
        J08 j08 = abstractC17457n0F instanceof J08 ? (J08) abstractC17457n0F : null;
        VoiceTranscript voiceTranscriptJ = j08 != null ? j08.J() : null;
        EnumC9477a18 voiceTranscriptState = voiceTranscriptJ != null ? voiceTranscriptJ.getVoiceTranscriptState() : null;
        int i2 = voiceTranscriptState == null ? -1 : d.a[voiceTranscriptState.ordinal()];
        if (i2 != -1) {
            if (i2 == 1) {
                this.w.i.setState(enumC9477a18);
                E1(c8967Xz7, c8967Xz7.d(), false);
            } else if (i2 == 2) {
                this.w.i.setState(EnumC9477a18.c);
                if (aVar.e().b() >= this.t) {
                    String string = x0().getRoot().getContext().getString(AbstractC12217eE5.voice_to_text_loading);
                    AbstractC13042fc3.h(string, "getString(...)");
                    E1(c8967Xz7, AbstractC17636nI6.i(string), false);
                }
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                this.w.i.setState(EnumC9477a18.d);
                String voiceTranscript = voiceTranscriptJ.getVoiceTranscript();
                E1(c8967Xz7, voiceTranscript != null ? AbstractC17636nI6.i(voiceTranscript) : null, false);
            }
        }
        AudioToTextImageButton audioToTextImageButton2 = this.w.i;
        AbstractC13042fc3.f(audioToTextImageButton2);
        audioToTextImageButton2.setVisibility(aVar.i() ^ true ? 0 : 8);
        audioToTextImageButton2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.JM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NM.P1(this.a, aVar, c8967Xz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(NM nm, AbstractC17757nW1.a aVar, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(aVar, "$data");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        nm.g2(aVar, c8967Xz7);
    }

    private final AbstractC17683nO Q1(boolean z, boolean z2) {
        C9663aL5 c9663aL5 = new C9663aL5();
        c9663aL5.a = !z;
        return new h(c9663aL5, z2, !z2);
    }

    private final GestureDetector R1(AppCompatSeekBar appCompatSeekBar) {
        return new GestureDetector(appCompatSeekBar.getContext(), new i(appCompatSeekBar));
    }

    private final j S1() {
        return new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GestureDetector T1(NM nm) {
        AbstractC13042fc3.i(nm, "this$0");
        AppCompatSeekBar appCompatSeekBar = nm.w.e;
        AbstractC13042fc3.h(appCompatSeekBar, "audioSeekbar");
        return nm.R1(appCompatSeekBar);
    }

    private final C23709xO V1() {
        return (C23709xO) this.A.getValue();
    }

    private final int W1(boolean z) {
        return z ? KB5.bubble_document_state_pause : KB5.bubble_document_state_play;
    }

    private final GestureDetector Y1() {
        return (GestureDetector) this.B0.getValue();
    }

    private final SpannableStringBuilder a2(long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) q2(j2));
        spannableStringBuilder.append((CharSequence) " / ");
        spannableStringBuilder.append((CharSequence) this.G);
        return spannableStringBuilder;
    }

    private final PM b2() {
        return (PM) this.z0.getValue();
    }

    private final boolean c2(VL vl) {
        VL vlM = C23709xO.a.M();
        return AbstractC13042fc3.d(vlM != null ? vlM.d() : null, vl.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(View view, boolean z, boolean z2) {
        if (z2) {
            view.setVisibility(z ? 0 : 8);
        } else {
            view.setVisibility(z ^ true ? 4 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(C7547Se3 c7547Se3, View view) {
        AbstractC13042fc3.i(c7547Se3, "$this_apply");
        c7547Se3.f.callOnClick();
    }

    private final int f2(int i2) {
        return Math.min(i2, (int) (this.w.getRoot().getResources().getDisplayMetrics().widthPixels * 0.75d));
    }

    private final void g2(AbstractC17757nW1.a aVar, C8967Xz7 c8967Xz7) {
        int i2 = d.a[((EnumC9477a18) this.w.i.getState().getValue()).ordinal()];
        if (i2 == 1) {
            if (aVar.e().b() < this.s) {
                i2(c8967Xz7, aVar);
                return;
            }
            InterfaceC24373yW1 interfaceC24373yW1D = z0().d();
            String string = x0().getRoot().getContext().getString(AbstractC12217eE5.error_voice_to_text_dur);
            AbstractC13042fc3.h(string, "getString(...)");
            interfaceC24373yW1D.g(string);
            return;
        }
        if (i2 == 2) {
            this.w.i.setState(EnumC9477a18.b);
            return;
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        F1(this, c8967Xz7, c8967Xz7.d(), false, 4, null);
        AudioToTextImageButton audioToTextImageButton = this.w.i;
        EnumC9477a18 enumC9477a18 = EnumC9477a18.b;
        audioToTextImageButton.setState(enumC9477a18);
        z0().d().f(c8967Xz7, enumC9477a18, null);
    }

    private final void h2(AbstractC17757nW1.a aVar) {
        r2();
        boolean zC2 = c2(aVar.e());
        C23709xO c23709xOV1 = V1();
        AbstractC17683nO abstractC17683nOQ1 = Q1(zC2, aVar.i());
        this.B = abstractC17683nOQ1;
        c23709xOV1.u(abstractC17683nOQ1);
    }

    private final void i2(final C8967Xz7 c8967Xz7, AbstractC17757nW1.a aVar) {
        C11920dm2 c11920dm2A;
        FileReference fileReferenceB;
        String voiceTranscript;
        AbstractC17457n0 abstractC17457n0F = c8967Xz7.j().F();
        J08 j08 = abstractC17457n0F instanceof J08 ? (J08) abstractC17457n0F : null;
        VoiceTranscript voiceTranscriptJ = j08 != null ? j08.J() : null;
        if (voiceTranscriptJ != null && (voiceTranscript = voiceTranscriptJ.getVoiceTranscript()) != null && !AbstractC20762sZ6.n0(voiceTranscript)) {
            C19406qI3.a("AudioBubble", "transcriptVoice is already exist", new Object[0]);
            AudioToTextImageButton audioToTextImageButton = this.w.i;
            EnumC9477a18 enumC9477a18 = EnumC9477a18.d;
            audioToTextImageButton.setState(enumC9477a18);
            F1(this, c8967Xz7, AbstractC17636nI6.i(voiceTranscriptJ.getVoiceTranscript()), false, 4, null);
            z0().d().f(c8967Xz7, enumC9477a18, voiceTranscriptJ.getVoiceTranscript());
            return;
        }
        C19406qI3.a("AudioBubble", "transcriptVoice is not already exist, should downloaded", new Object[0]);
        this.w.i.setState(EnumC9477a18.c);
        if (aVar.e().b() >= this.t) {
            String string = x0().getRoot().getContext().getString(AbstractC12217eE5.voice_to_text_loading);
            AbstractC13042fc3.h(string, "getString(...)");
            F1(this, c8967Xz7, AbstractC17636nI6.i(string), false, 4, null);
        }
        MW1 mw1B = aVar.b();
        MW1.b bVar = mw1B instanceof MW1.b ? (MW1.b) mw1B : null;
        C12056dy fileLocation = (bVar == null || (c11920dm2A = bVar.a()) == null || (fileReferenceB = c11920dm2A.b()) == null) ? null : fileReferenceB.getFileLocation();
        if (fileLocation != null) {
            z0().d().e(fileLocation.getFileId(), fileLocation.getAccessHash(), c8967Xz7, aVar, new SA2() { // from class: ir.nasim.zM
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return NM.j2(this.a, c8967Xz7);
                }
            });
            return;
        }
        C19406qI3.a("AudioBubble", "fileLocation is null", new Object[0]);
        F1(this, c8967Xz7, c8967Xz7.d(), false, 4, null);
        AudioToTextImageButton audioToTextImageButton2 = this.w.i;
        EnumC9477a18 enumC9477a182 = EnumC9477a18.b;
        audioToTextImageButton2.setState(enumC9477a182);
        z0().d().f(c8967Xz7, enumC9477a182, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j2(NM nm, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC10533bm0.d(nm.U1(), null, null, nm.new k(c8967Xz7, null), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(final NM nm, View view, AbstractC17757nW1.a aVar, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(view, "$accessibleView");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        nm.w.getRoot().setAccessibilityTraversalAfter(view.getId());
        String string = (aVar != null ? aVar.e() : null) == null ? view.getContext().getString(AbstractC12217eE5.voice_downloaded_content_description) : !nm.y ? view.getContext().getString(AbstractC12217eE5.item_not_downloaded_content_description) : nm.V1().x(aVar.e()) ? view.getContext().getString(AbstractC12217eE5.voice_downloaded_pause_content_description) : view.getContext().getString(AbstractC12217eE5.voice_downloaded_content_description);
        AbstractC13042fc3.f(string);
        if (C8386Vt0.a.Tb() && nm.u) {
            String string2 = nm.w.i.a() ? view.getContext().getString(AbstractC12217eE5.voice_to_text_off_c_d) : view.getContext().getString(AbstractC12217eE5.voice_to_text_on_c_d);
            AbstractC13042fc3.f(string2);
            nm.w.i.setContentDescription(string2);
        }
        CharSequence contentDescription = nm.w.f.getContentDescription();
        if (contentDescription == null || contentDescription.length() == 0) {
            return;
        }
        AbstractC12990fW7.l0(view, X2.a.j, AbstractC15401jX0.A0(AbstractC15401jX0.k0(AbstractC20762sZ6.N0(contentDescription, new String[]{","}, false, 0, 6, null), 1), null, null, null, 0, null, null, 63, null), new InterfaceC10698c3() { // from class: ir.nasim.AM
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar2) {
                return NM.l2(view2, aVar2);
            }
        });
        X2.a aVar2 = X2.a.i;
        String str = (String) AbstractC15401jX0.q0(AbstractC20762sZ6.N0(contentDescription, new String[]{","}, false, 0, 6, null));
        if (str != null) {
            string = str;
        }
        AbstractC12990fW7.l0(view, aVar2, string, new InterfaceC10698c3() { // from class: ir.nasim.BM
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar3) {
                return NM.m2(this.a, view2, aVar3);
            }
        });
        super.w(view, c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l2(View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(view, "<unused var>");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m2(NM nm, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        nm.w.f.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n2(final AppCompatSeekBar appCompatSeekBar, final boolean z) {
        appCompatSeekBar.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.CM
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return NM.o2(z, appCompatSeekBar, this, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o2(boolean z, AppCompatSeekBar appCompatSeekBar, NM nm, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(appCompatSeekBar, "$this_setOnTouchListener");
        AbstractC13042fc3.i(nm, "this$0");
        if (z) {
            return motionEvent.getAction() == 1 ? appCompatSeekBar.onTouchEvent(motionEvent) : nm.Y1().onTouchEvent(motionEvent);
        }
        return false;
    }

    private final ContentHeightMatchedTextView p2() {
        C7547Se3 c7547Se3 = this.w;
        ContentHeightMatchedTextView contentHeightMatchedTextView = c7547Se3.d;
        contentHeightMatchedTextView.setTypeface(C6011Lu2.k());
        C3335Al0 c3335Al0 = C3335Al0.a;
        contentHeightMatchedTextView.setTextSize(c3335Al0.c());
        ContentHeightMatchedTextView contentHeightMatchedTextView2 = c7547Se3.b;
        contentHeightMatchedTextView2.setTypeface(C6011Lu2.k());
        contentHeightMatchedTextView2.setTextSize(c3335Al0.a());
        ContentHeightMatchedTextView contentHeightMatchedTextView3 = c7547Se3.c;
        contentHeightMatchedTextView3.setTypeface(C6011Lu2.k());
        contentHeightMatchedTextView3.setTextSize(c3335Al0.b());
        AbstractC13042fc3.h(contentHeightMatchedTextView3, "with(...)");
        return contentHeightMatchedTextView3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PM q1(C15481jf3 c15481jf3) {
        AbstractC13042fc3.i(c15481jf3, "$binding");
        MessageReactionView messageReactionView = c15481jf3.k;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        MessageEmojiTextView messageEmojiTextView = c15481jf3.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        CommentContainerView commentContainerView = c15481jf3.e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        return new PM(messageReactionView, messageStateView, messageEmojiTextView, commentContainerView);
    }

    private final String q2(long j2) {
        return XY6.v(C17959nq7.a.a((int) (j2 / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)));
    }

    private final void r2() {
        AbstractC17683nO abstractC17683nO = this.B;
        if (abstractC17683nO != null) {
            V1().z0(abstractC17683nO);
        }
        this.B = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(View view) {
        VL vlE;
        Context context;
        int i2;
        C8967Xz7 c8967Xz7 = this.J;
        CharSequence contentDescription = null;
        Object objF = c8967Xz7 != null ? c8967Xz7.f() : null;
        AbstractC17757nW1.a aVar = objF instanceof AbstractC17757nW1.a ? (AbstractC17757nW1.a) objF : null;
        if (aVar != null && (vlE = aVar.e()) != null) {
            if (C23709xO.a.x(vlE)) {
                context = view.getContext();
                i2 = AbstractC12217eE5.play;
            } else {
                context = view.getContext();
                i2 = AbstractC12217eE5.pause;
            }
            contentDescription = context.getString(i2);
        }
        X2.a aVar2 = X2.a.i;
        if (contentDescription == null) {
            contentDescription = this.w.f.getContentDescription();
        }
        AbstractC12990fW7.l0(view, aVar2, contentDescription, new InterfaceC10698c3() { // from class: ir.nasim.DM
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar3) {
                return NM.t2(this.a, view2, aVar3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t2(NM nm, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(nm, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        nm.w.f.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2(boolean z) {
        this.w.f.c(Integer.valueOf(W1(z)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v2(long j2) {
        this.w.c.r(a2(j2));
    }

    @Override // ir.nasim.C20882sl7
    protected int C0() {
        return 4;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.v;
    }

    public final void E1(C8967Xz7 c8967Xz7, Spannable spannable, boolean z) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        MessageEmojiTextView messageEmojiTextView = x0().i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        int lineCount = (z && messageEmojiTextView.isLaidOut()) ? messageEmojiTextView.getLineCount() : 0;
        super.Y(c8967Xz7, spannable);
        ConstraintLayout constraintLayout = x0().f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        if (!constraintLayout.isLaidOut() || constraintLayout.isLayoutRequested()) {
            constraintLayout.addOnLayoutChangeListener(new e(messageEmojiTextView, lineCount, z, this, c8967Xz7));
            return;
        }
        Layout layout = messageEmojiTextView.getLayout();
        if (Math.abs((layout != null ? layout.getLineCount() : messageEmojiTextView.getLineCount()) - lineCount) >= 8 && z) {
            messageEmojiTextView.post(new f(c8967Xz7));
        }
        B0().r();
    }

    @Override // ir.nasim.C20882sl7
    protected Spannable F0(C8967Xz7 c8967Xz7) {
        VoiceTranscript voiceTranscriptJ;
        String voiceTranscript;
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        if (!this.w.i.a()) {
            return super.F0(c8967Xz7);
        }
        AbstractC17457n0 abstractC17457n0F = c8967Xz7.j().F();
        SpannableString spannableStringI = null;
        J08 j08 = abstractC17457n0F instanceof J08 ? (J08) abstractC17457n0F : null;
        if (j08 != null && (voiceTranscriptJ = j08.J()) != null && (voiceTranscript = voiceTranscriptJ.getVoiceTranscript()) != null) {
            if (AbstractC20762sZ6.n0(voiceTranscript)) {
                voiceTranscript = null;
            }
            if (voiceTranscript != null) {
                spannableStringI = AbstractC17636nI6.i(voiceTranscript);
            }
        }
        return spannableStringI != null ? spannableStringI : super.F0(c8967Xz7);
    }

    public final AbstractC15087iz3 U1() {
        return AbstractC19224pz3.a(this.r);
    }

    @Override // ir.nasim.C20882sl7
    protected void X0(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        B0().s((f2(((Number) xv4.e()).intValue()) - x0().getRoot().getPaddingLeft()) - x0().getRoot().getPaddingRight());
    }

    public final C7547Se3 X1() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C20882sl7
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public PM B0() {
        return this.A0;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void a() {
        super.a();
        this.r.V4(this);
        r2();
        C22007uW1 c22007uW1 = this.x;
        if (c22007uW1 != null) {
            c22007uW1.R();
        }
        this.x = null;
        this.y = false;
        this.z = false;
    }

    @Override // ir.nasim.O44
    public void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
        aVar.M(this.z);
        aVar.Y(this.y);
        aVar.J(this.w.i.a() && C8386Vt0.a.Tb());
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void o(final C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        this.J = c8967Xz7;
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        ConstraintLayout root = x0().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = f2(((Number) xv4.e()).intValue());
        root.setLayoutParams(layoutParams2);
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Document.Audio");
        J1(c8967Xz7, (AbstractC17757nW1.a) objF);
        Z0();
        this.w.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NM.D1(this.a, c8967Xz7, view);
            }
        });
        this.r.q4(this);
        if (C8386Vt0.a.Tb() && this.u && !((AbstractC17757nW1.a) c8967Xz7.f()).i()) {
            O1((AbstractC17757nW1.a) c8967Xz7.f(), c8967Xz7);
        }
        if (c8967Xz7.i() != null) {
            B0().u();
        }
        I1(c8967Xz7);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(final View view, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        this.Z = view;
        Object objF = c8967Xz7.f();
        final AbstractC17757nW1.a aVar = objF instanceof AbstractC17757nW1.a ? (AbstractC17757nW1.a) objF : null;
        this.w.getRoot().postDelayed(new Runnable() { // from class: ir.nasim.xM
            @Override // java.lang.Runnable
            public final void run() {
                NM.k2(this.a, view, aVar, c8967Xz7);
            }
        }, 100L);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.i) {
            C22007uW1 c22007uW1 = this.x;
            if (c22007uW1 != null) {
                c22007uW1.K(((N15.i) n15).b());
            }
        } else if (n15 instanceof N15.w) {
            N15.w wVar = (N15.w) n15;
            this.J = wVar.b();
            Object objF = wVar.b().f();
            AbstractC17757nW1.a aVar = objF instanceof AbstractC17757nW1.a ? (AbstractC17757nW1.a) objF : null;
            if (aVar != null && C8386Vt0.a.Tb() && this.u && !aVar.i()) {
                O1(aVar, wVar.b());
            }
        } else {
            super.z(n15);
        }
        CommentContainerView commentContainerView = x0().e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        if (commentContainerView.getVisibility() == 0) {
            B0().u();
        }
    }

    private NM(final C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54, XZ xz, long j2, long j3, boolean z2) {
        super(c15481jf3, z, abstractC23538x54);
        this.r = xz;
        this.s = j2;
        this.t = j3;
        this.u = z2;
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.v = constraintLayout;
        this.A = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.EM
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NM.C1();
            }
        });
        this.D = -1L;
        this.G = "-1";
        Object systemService = c15481jf3.getRoot().getContext().getSystemService("accessibility");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.Y = (AccessibilityManager) systemService;
        this.z0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.FM
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NM.q1(c15481jf3);
            }
        });
        this.A0 = b2();
        ViewStub viewStub = c15481jf3.g;
        AbstractC13042fc3.h(viewStub, "mainViewStub");
        ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        viewStub.setLayoutParams(layoutParams2);
        final C7547Se3 c7547Se3A = C7547Se3.a(R0(AbstractC12208eD5.item_chat_audio_bubble));
        DocumentStateButton documentStateButton = c7547Se3A.f;
        Context context = c15481jf3.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        documentStateButton.setTintColor(OY0.b(context, AbstractC21139tA5.colorOnPrimary));
        c7547Se3A.e.setOnSeekBarChangeListener(S1());
        Context context2 = c7547Se3A.getRoot().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        if (!C10082b3.c(context2)) {
            c7547Se3A.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NM.e2(c7547Se3A, view);
                }
            });
        }
        c7547Se3A.e.setAccessibilityDelegate(new b());
        this.w = c7547Se3A;
        p2();
        this.B0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.HM
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NM.T1(this.a);
            }
        });
    }

    public static final class j implements SeekBar.OnSeekBarChangeListener {
        private final SA2 a;
        private long b;

        j() {
            SA2 sa2 = new SA2() { // from class: ir.nasim.OM
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return Long.valueOf(NM.j.b());
                }
            };
            this.a = sa2;
            this.b = ((Number) sa2.invoke()).longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long b() {
            return System.currentTimeMillis();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            AbstractC13042fc3.i(seekBar, "seekbar");
            if (z) {
                long max = (NM.this.D * i) / seekBar.getMax();
                C23709xO.a.n0(max, NM.this.H);
                NM.this.v2(max);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SA2 sa2B;
            if (!NM.this.Y.isTouchExplorationEnabled() || ((Number) this.a.invoke()).longValue() - this.b < ViewConfiguration.getLongPressTimeout() || (sa2B = NM.this.A0().b()) == null) {
                return;
            }
            sa2B.invoke();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }
}
