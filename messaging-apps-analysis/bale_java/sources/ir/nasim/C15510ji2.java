package ir.nasim;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.chrisbanes.photoview.PhotoView;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C13388g85;
import ir.nasim.C19907r85;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import java.util.ArrayList;

/* renamed from: ir.nasim.ji2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15510ji2 extends JA2 {
    public static final b T0 = new b(null);
    public static final int U0 = 8;
    private final C11258ci2 M0;
    private final C14970in2 N0;
    private final VI2 O0;
    private final C16101ki2 P0;
    private AbstractC15520jj2.e Q0;
    private InterfaceC7857Tm2 R0;
    private C19907r85 S0;

    /* renamed from: ir.nasim.ji2$a */
    public static final class a implements GestureDetector.OnDoubleTapListener {
        a() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            SA2 sa2A = C15510ji2.this.r1().a();
            if (sa2A != null) {
                return ((Boolean) sa2A.invoke()).booleanValue();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            return true;
        }
    }

    /* renamed from: ir.nasim.ji2$b */
    public static final class b {
        private b() {
        }

        public final C15510ji2 a(ViewGroup viewGroup, InterfaceC13138fj2 interfaceC13138fj2, C14970in2 c14970in2, VI2 vi2, O98 o98) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            AbstractC13042fc3.i(c14970in2, "filesModule");
            AbstractC13042fc3.i(vi2, "glideRequest");
            C11258ci2 c11258ci2C = C11258ci2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11258ci2C, "inflate(...)");
            return new C15510ji2(c11258ci2C, interfaceC13138fj2, o98, c14970in2, vi2);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15510ji2(C11258ci2 c11258ci2, InterfaceC13138fj2 interfaceC13138fj2, O98 o98, C14970in2 c14970in2, VI2 vi2) {
        super(o98, c11258ci2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11258ci2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(vi2, "glideRequest");
        this.M0 = c11258ci2;
        this.N0 = c14970in2;
        this.O0 = vi2;
        ViewStub viewStub = l1().t;
        viewStub.setLayoutResource(HC5.feed_full_screen_photo_holder);
        viewStub.setInflatedId(viewStub.getId());
        C16101ki2 c16101ki2A = C16101ki2.a(viewStub.inflate());
        this.P0 = c16101ki2A;
        c16101ki2A.f.setOnDoubleTapListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U3(C15510ji2 c15510ji2) {
        AbstractC13042fc3.i(c15510ji2, "this$0");
        if (!c15510ji2.t3()) {
            return false;
        }
        TextView textView = c15510ji2.l1().o;
        AbstractC13042fc3.h(textView, "feedPhotoText");
        c15510ji2.c3(textView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V3(C15510ji2 c15510ji2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c15510ji2, "this$0");
        C4485Fi2 c4485Fi2Q1 = c15510ji2.q1();
        AbstractC13042fc3.f(motionEvent);
        return c4485Fi2Q1.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W3(C15510ji2 c15510ji2, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(c15510ji2, "this$0");
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        c15510ji2.O0.y(interfaceC3346Am2.getDescriptor()).Q0(c15510ji2.P0.f);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X3(C15510ji2 c15510ji2) {
        AbstractC13042fc3.i(c15510ji2, "this$0");
        C14970in2 c14970in2 = c15510ji2.N0;
        AbstractC15520jj2.e eVar = c15510ji2.Q0;
        if (eVar == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar = null;
        }
        c14970in2.H(eVar.d().getFileId());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b4(C15510ji2 c15510ji2, long j, String str, long j2, long j3) {
        AbstractC13042fc3.i(c15510ji2, "this$0");
        AbstractC13042fc3.i(str, "mimeType");
        c15510ji2.s1().b(j, str, j2, j3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c4(C15510ji2 c15510ji2, InterfaceC8091Um2 interfaceC8091Um2) {
        AbstractC13042fc3.i(c15510ji2, "this$0");
        AbstractC13042fc3.i(interfaceC8091Um2, "callback");
        C14970in2 c14970in2 = c15510ji2.N0;
        AbstractC15520jj2.e eVar = c15510ji2.Q0;
        if (eVar == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar = null;
        }
        c14970in2.D(eVar.d(), true, interfaceC8091Um2, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        return C19938rB7.a;
    }

    private final void d4(PhotoView photoView, byte[] bArr) {
        this.O0.z(bArr).u0(new C5191Ih0(10, 3)).Q0(photoView);
    }

    @Override // ir.nasim.AbstractC13019fa0
    public AbstractC17457n0 T0() {
        C13388g85.a aVar = C13388g85.l;
        AbstractC15520jj2.e eVar = this.Q0;
        AbstractC15520jj2.e eVar2 = null;
        if (eVar == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar = null;
        }
        FileReference fileReferenceD = eVar.d();
        ArrayList arrayList = new ArrayList();
        AbstractC15520jj2.e eVar3 = this.Q0;
        if (eVar3 == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar3 = null;
        }
        int iG = eVar3.g();
        AbstractC15520jj2.e eVar4 = this.Q0;
        if (eVar4 == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar4 = null;
        }
        int iE = eVar4.e();
        AbstractC15520jj2.e eVar5 = this.Q0;
        if (eVar5 == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar5 = null;
        }
        int iG2 = eVar5.g();
        AbstractC15520jj2.e eVar6 = this.Q0;
        if (eVar6 == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar6 = null;
        }
        int iE2 = eVar6.e();
        AbstractC15520jj2.e eVar7 = this.Q0;
        if (eVar7 == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
        } else {
            eVar2 = eVar7;
        }
        return aVar.b(fileReferenceD, arrayList, iG, iE, new C22694vg2(iG2, iE2, eVar2.f()));
    }

    public void T3(C5886Lg2 c5886Lg2, AbstractC15520jj2.e eVar) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(eVar, DialogEntity.COLUMN_MESSAGE);
        super.H2(c5886Lg2, eVar);
        this.Q0 = eVar;
        TextView textView = l1().o;
        AbstractC13042fc3.h(textView, "feedPhotoText");
        f3(textView, c5886Lg2, eVar.c(), t1());
        this.P0.d.getBackground().setColorFilter(new PorterDuffColorFilter(AbstractC4043Dl1.c(this.a.getContext(), AA5.onBackground_fixed), PorterDuff.Mode.MULTIPLY));
        r1().g(new SA2() { // from class: ir.nasim.di2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C15510ji2.U3(this.a));
            }
        });
        CircleProgressBar circleProgressBar = this.P0.c;
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        circleProgressBar.setColor(OY0.b(context, AbstractC13999hA5.colorOnPrimary));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        circleProgressBar.setBgColor(c5495Jo7.y0(OY0.b(context2, AbstractC13999hA5.colorOnPrimary), 40));
        PhotoView photoView = this.P0.f;
        AbstractC13042fc3.h(photoView, "imageContainer");
        d4(photoView, eVar.f());
        this.P0.f.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.ei2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C15510ji2.V3(this.a, view, motionEvent);
            }
        });
        C19907r85.a aVar = C19907r85.k;
        AbstractC15520jj2.e eVar2 = this.Q0;
        if (eVar2 == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar2 = null;
        }
        FileReference fileReferenceD = eVar2.d();
        FrameLayout frameLayout = this.P0.d;
        AbstractC13042fc3.h(frameLayout, "feedStateContainerPhoto");
        ImageView imageView = this.P0.e;
        AbstractC13042fc3.h(imageView, "feedStatePhotoIv");
        CircleProgressBar circleProgressBar2 = this.P0.c;
        AbstractC13042fc3.h(circleProgressBar2, "feedProgressPhoto");
        C19907r85 c19907r85B = aVar.b(fileReferenceD, frameLayout, imageView, circleProgressBar2, new UA2() { // from class: ir.nasim.fi2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15510ji2.W3(this.a, (InterfaceC3346Am2) obj);
            }
        }, new SA2() { // from class: ir.nasim.gi2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15510ji2.X3(this.a);
            }
        }, new InterfaceC16978mB2() { // from class: ir.nasim.hi2
            @Override // ir.nasim.InterfaceC16978mB2
            public final Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                return C15510ji2.b4(this.a, ((Long) obj).longValue(), (String) obj2, ((Long) obj3).longValue(), ((Long) obj4).longValue());
            }
        }, new UA2() { // from class: ir.nasim.ii2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15510ji2.c4(this.a, (InterfaceC8091Um2) obj);
            }
        }, (256 & 256) != 0 ? null : null);
        c19907r85B.b();
        this.S0 = c19907r85B;
    }

    @Override // ir.nasim.JA2, ir.nasim.AbstractC13019fa0
    public void a() {
        super.a();
        this.O0.n(this.P0.f);
        this.P0.f.setImageDrawable(null);
        C19907r85 c19907r85 = this.S0;
        if (c19907r85 != null) {
            c19907r85.i();
        }
        this.S0 = null;
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.R0;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
        this.R0 = null;
    }

    @Override // ir.nasim.AbstractC13019fa0
    /* renamed from: l3 */
    public C11258ci2 l1() {
        return this.M0;
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        AbstractC15520jj2.e eVar = this.Q0;
        if (eVar == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar = null;
        }
        return !(eVar.c().length() == 0);
    }
}
