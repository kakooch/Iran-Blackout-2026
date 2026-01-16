package ir.nasim.features.smiles.panel.gif;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C12366eV1;
import ir.nasim.C19938rB7;
import ir.nasim.C22078ud6;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.GY;
import ir.nasim.HG1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.OH2;
import ir.nasim.QG2;
import ir.nasim.RS4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.features.smiles.panel.gif.GifPreviewView;
import ir.nasim.features.smiles.widget.GifPreviewImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002&(Be\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\f¢\u0006\u0004\b$\u0010%R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010%R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00108R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00108¨\u0006E"}, d2 = {"Lir/nasim/features/smiles/panel/gif/GifPreviewView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "Lkotlin/Function0;", "Lir/nasim/rB7;", "onDismissed", "Lkotlin/Function1;", "Lir/nasim/QG2;", "onSendGifClicked", "onDeleteGifClicked", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILir/nasim/SA2;Lir/nasim/UA2;Lir/nasim/UA2;)V", "", "translation", "h", "(F)V", "gifWidth", "gifHeight", "g", "(II)V", "Landroid/view/MotionEvent;", "event", "initialY", "k", "(Landroid/view/MotionEvent;Ljava/lang/Float;)V", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "j", "()V", "gif", "i", "(Lir/nasim/QG2;)V", "a", "Lir/nasim/SA2;", "b", "Lir/nasim/UA2;", "c", "Lir/nasim/OH2;", "d", "Lir/nasim/OH2;", "binding", "e", "Lir/nasim/QG2;", "getGif", "()Lir/nasim/QG2;", "setGif", "Lir/nasim/features/smiles/panel/gif/GifPreviewView$b;", "f", "Lir/nasim/features/smiles/panel/gif/GifPreviewView$b;", "gifPreviewState", TokenNames.F, "minDistance", TokenNames.I, "mTouchSlop", "Lir/nasim/gj3;", "Lir/nasim/gj3;", "tooLongLockedStateJob", "Lir/nasim/GY;", "Lir/nasim/Yu3;", "getPreviewContextMenu", "()Lir/nasim/GY;", "previewContextMenu", "l", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class GifPreviewView extends LinearLayout {
    public static final int m = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private SA2 onDismissed;

    /* renamed from: b, reason: from kotlin metadata */
    private UA2 onSendGifClicked;

    /* renamed from: c, reason: from kotlin metadata */
    private UA2 onDeleteGifClicked;

    /* renamed from: d, reason: from kotlin metadata */
    private OH2 binding;

    /* renamed from: e, reason: from kotlin metadata */
    private QG2 gif;

    /* renamed from: f, reason: from kotlin metadata */
    private b gifPreviewState;

    /* renamed from: g, reason: from kotlin metadata */
    private float minDistance;

    /* renamed from: h, reason: from kotlin metadata */
    private final int mTouchSlop;

    /* renamed from: i, reason: from kotlin metadata */
    private InterfaceC13730gj3 tooLongLockedStateJob;

    /* renamed from: j, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 previewContextMenu;

    /* renamed from: k, reason: from kotlin metadata */
    private float initialY;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final b a = new b("UNLOCKED", 0);
        public static final b b = new b("LOCKED", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GifPreviewView.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            GifPreviewView.this.h(0.0f);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d implements InterfaceC8091Um2 {
        d() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QG2 gif = GifPreviewView.this.getGif();
            if (gif != null) {
                gif.h(interfaceC3346Am2.getDescriptor());
            }
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }
    }

    public /* synthetic */ GifPreviewView(Context context, AttributeSet attributeSet, int i, SA2 sa2, UA2 ua2, UA2 ua22, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? new SA2() { // from class: ir.nasim.PH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return GifPreviewView.e();
            }
        } : sa2, (i2 & 16) != 0 ? null : ua2, (i2 & 32) == 0 ? ua22 : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e() {
        return C19938rB7.a;
    }

    private final void g(int gifWidth, int gifHeight) {
        float f = gifWidth;
        float f2 = gifHeight;
        float fMin = Math.min(Math.min(AbstractC8943Xx1.c(315), C22078ud6.c() * 0.8f) / f, Math.min(AbstractC8943Xx1.c(420), C22078ud6.b() * 0.6f) / f2);
        int i = (int) (f * fMin);
        int i2 = (int) (f2 * fMin);
        GifPreviewImageView gifPreviewImageView = this.binding.b;
        ViewGroup.LayoutParams layoutParams = gifPreviewImageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        gifPreviewImageView.setLayoutParams(layoutParams);
    }

    private final GY getPreviewContextMenu() {
        return (GY) this.previewContextMenu.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(float translation) {
        this.gifPreviewState = b.b;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.binding.d, "translationY", translation, 0.0f);
        objectAnimatorOfFloat.setDuration(200L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.binding.c, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(100L);
        objectAnimatorOfFloat2.setStartDelay(100L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.start();
        getPreviewContextMenu().showAtLocation(this, 48, 0, AbstractC8943Xx1.c(128) + this.binding.b.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GY l(final GifPreviewView gifPreviewView) {
        AbstractC13042fc3.i(gifPreviewView, "this$0");
        AbstractC8081Ul1.b bVarK = AbstractC8081Ul1.b.k(AbstractC8081Ul1.b.k(new AbstractC8081Ul1.b(), AbstractC12217eE5.send_gif, KB5.send, null, new SA2() { // from class: ir.nasim.RH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return GifPreviewView.m(this.a);
            }
        }, 4, null), AbstractC12217eE5.remove_from_gifs, KB5.delete, null, new SA2() { // from class: ir.nasim.SH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return GifPreviewView.n(this.a);
            }
        }, 4, null);
        GifPreviewImageView gifPreviewImageView = gifPreviewView.binding.b;
        AbstractC13042fc3.h(gifPreviewImageView, "imgGifPreview");
        GY gyB = new GY.a(gifPreviewView, gifPreviewImageView, null, 4, null).d(true).g(new RS4(4.0f, 4.0f, 4.0f, 2.0f)).b(bVarK);
        gyB.setOutsideTouchable(false);
        gyB.setFocusable(false);
        return gyB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(GifPreviewView gifPreviewView) {
        UA2 ua2;
        AbstractC13042fc3.i(gifPreviewView, "this$0");
        QG2 qg2 = gifPreviewView.gif;
        if (qg2 != null && (ua2 = gifPreviewView.onSendGifClicked) != null) {
            ua2.invoke(qg2);
        }
        gifPreviewView.j();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(GifPreviewView gifPreviewView) {
        UA2 ua2;
        AbstractC13042fc3.i(gifPreviewView, "this$0");
        QG2 qg2 = gifPreviewView.gif;
        if (qg2 != null && (ua2 = gifPreviewView.onDeleteGifClicked) != null) {
            ua2.invoke(qg2);
        }
        gifPreviewView.j();
        return C19938rB7.a;
    }

    public final QG2 getGif() {
        return this.gif;
    }

    public final void i(QG2 gif) {
        AbstractC13042fc3.i(gif, "gif");
        this.tooLongLockedStateJob = AbstractC10533bm0.d(AbstractC20906so1.a(C12366eV1.c()), null, null, new c(null), 3, null);
        this.gif = gif;
        g(gif.g(), gif.d());
        this.binding.b.a(gif.c(), new d());
    }

    public final void j() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.tooLongLockedStateJob;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.binding.b.l();
        this.gifPreviewState = b.a;
        this.binding.d.setTranslationY(0.0f);
        this.binding.c.setAlpha(1.0f);
        this.onDismissed.invoke();
        getPreviewContextMenu().dismiss();
    }

    public final void k(MotionEvent event, Float initialY) {
        this.initialY = initialY != null ? initialY.floatValue() : 0.0f;
        dispatchTouchEvent(event);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 2) {
            if (this.gifPreviewState == b.b) {
                return true;
            }
            float rawY = event.getRawY() - this.initialY;
            if (rawY <= (-this.minDistance)) {
                InterfaceC13730gj3 interfaceC13730gj3 = this.tooLongLockedStateJob;
                if (interfaceC13730gj3 != null) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                }
                h(rawY);
            } else if (rawY <= (-this.mTouchSlop)) {
                InterfaceC13730gj3 interfaceC13730gj32 = this.tooLongLockedStateJob;
                if (interfaceC13730gj32 != null) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
                }
                this.binding.d.setTranslationY(rawY + this.mTouchSlop);
            }
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            InterfaceC13730gj3 interfaceC13730gj33 = this.tooLongLockedStateJob;
            if (interfaceC13730gj33 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj33, null, 1, null);
            }
            if (this.gifPreviewState == b.a) {
                j();
            }
        } else {
            InterfaceC13730gj3 interfaceC13730gj34 = this.tooLongLockedStateJob;
            if (interfaceC13730gj34 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj34, null, 1, null);
            }
        }
        return true;
    }

    public final void setGif(QG2 qg2) {
        this.gif = qg2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifPreviewView(Context context, AttributeSet attributeSet, int i, SA2 sa2, UA2 ua2, UA2 ua22) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(sa2, "onDismissed");
        this.onDismissed = sa2;
        this.onSendGifClicked = ua2;
        this.onDeleteGifClicked = ua22;
        OH2 oh2C = OH2.c(LayoutInflater.from(context), this, true);
        AbstractC13042fc3.h(oh2C, "inflate(...)");
        this.binding = oh2C;
        this.gifPreviewState = b.a;
        this.minDistance = TypedValue.applyDimension(1, 25.0f, getResources().getDisplayMetrics());
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.previewContextMenu = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.QH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return GifPreviewView.l(this.a);
            }
        });
    }
}
