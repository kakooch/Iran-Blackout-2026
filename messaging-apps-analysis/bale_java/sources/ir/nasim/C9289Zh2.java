package ir.nasim;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C13388g85;
import ir.nasim.C9289Zh2;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import java.io.File;
import java.util.ArrayList;

/* renamed from: ir.nasim.Zh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9289Zh2 extends JA2 {
    public static final a T0 = new a(null);
    public static final int U0 = 8;
    private final C11258ci2 M0;
    private final C14970in2 N0;
    private final VI2 O0;
    private final C10495bi2 P0;
    private AbstractC15520jj2.e Q0;
    private InterfaceC7857Tm2 R0;
    private C8610Ws S0;

    /* renamed from: ir.nasim.Zh2$a */
    public static final class a {
        private a() {
        }

        public final C9289Zh2 a(ViewGroup viewGroup, InterfaceC13138fj2 interfaceC13138fj2, C14970in2 c14970in2, VI2 vi2, O98 o98) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            AbstractC13042fc3.i(c14970in2, "filesModule");
            AbstractC13042fc3.i(vi2, "glideRequest");
            C11258ci2 c11258ci2C = C11258ci2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11258ci2C, "inflate(...)");
            return new C9289Zh2(c11258ci2C, interfaceC13138fj2, o98, c14970in2, vi2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Zh2$b */
    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(C9289Zh2 c9289Zh2, b bVar, View view) {
            AbstractC13042fc3.i(c9289Zh2, "this$0");
            AbstractC13042fc3.i(bVar, "this$1");
            C14970in2 c14970in2 = c9289Zh2.N0;
            AbstractC15520jj2.e eVar = c9289Zh2.Q0;
            if (eVar == null) {
                AbstractC13042fc3.y("feedPhotoMessage");
                eVar = null;
            }
            c9289Zh2.R0 = c14970in2.D(eVar.d(), true, bVar, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            C10495bi2 c10495bi2 = C9289Zh2.this.P0;
            FrameLayout frameLayout = c10495bi2.d;
            AbstractC13042fc3.h(frameLayout, "feedStateContainerGif");
            frameLayout.setVisibility(0);
            ImageView imageView = c10495bi2.e;
            AbstractC13042fc3.h(imageView, "feedStateGifIv");
            imageView.setVisibility(8);
            CircleProgressBar circleProgressBar = c10495bi2.c;
            AbstractC13042fc3.h(circleProgressBar, "feedProgressGif");
            circleProgressBar.setVisibility(0);
            c10495bi2.c.setValue((int) (f * 100));
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) throws InterruptedException {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            C10495bi2 c10495bi2 = C9289Zh2.this.P0;
            C9289Zh2 c9289Zh2 = C9289Zh2.this;
            FrameLayout frameLayout = c10495bi2.d;
            AbstractC13042fc3.h(frameLayout, "feedStateContainerGif");
            frameLayout.setVisibility(8);
            ImageView imageView = c10495bi2.e;
            AbstractC13042fc3.h(imageView, "feedStateGifIv");
            imageView.setVisibility(8);
            CircleProgressBar circleProgressBar = c10495bi2.c;
            AbstractC13042fc3.h(circleProgressBar, "feedProgressGif");
            circleProgressBar.setVisibility(8);
            C8610Ws c8610Ws = new C8610Ws(new File(interfaceC3346Am2.getDescriptor()), false);
            c9289Zh2.X3(c8610Ws);
            c9289Zh2.S0 = c8610Ws;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            C10495bi2 c10495bi2 = C9289Zh2.this.P0;
            FrameLayout frameLayout = c10495bi2.d;
            AbstractC13042fc3.h(frameLayout, "feedStateContainerGif");
            frameLayout.setVisibility(0);
            ImageView imageView = c10495bi2.e;
            AbstractC13042fc3.h(imageView, "feedStateGifIv");
            imageView.setVisibility(0);
            CircleProgressBar circleProgressBar = c10495bi2.c;
            AbstractC13042fc3.h(circleProgressBar, "feedProgressGif");
            circleProgressBar.setVisibility(8);
            c10495bi2.e.setImageResource(AbstractC18163oB5.ic_feed_retry);
            ImageView imageView2 = C9289Zh2.this.P0.e;
            final C9289Zh2 c9289Zh2 = C9289Zh2.this;
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ai2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C9289Zh2.b.b(c9289Zh2, this, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9289Zh2(C11258ci2 c11258ci2, InterfaceC13138fj2 interfaceC13138fj2, O98 o98, C14970in2 c14970in2, VI2 vi2) {
        super(o98, c11258ci2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11258ci2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(vi2, "glideRequest");
        this.M0 = c11258ci2;
        this.N0 = c14970in2;
        this.O0 = vi2;
        ViewStub viewStub = l1().t;
        viewStub.setLayoutResource(HC5.feed_full_screen_gif_holder);
        viewStub.setInflatedId(viewStub.getId());
        this.P0 = C10495bi2.a(viewStub.inflate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U3(C9289Zh2 c9289Zh2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c9289Zh2, "this$0");
        C4485Fi2 c4485Fi2Q1 = c9289Zh2.q1();
        AbstractC13042fc3.f(motionEvent);
        return c4485Fi2Q1.onTouchEvent(motionEvent);
    }

    private final InterfaceC8091Um2 V3() {
        return new b();
    }

    private final void W3(ImageView imageView, byte[] bArr) {
        this.O0.z(bArr).Q0(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X3(C8610Ws c8610Ws) throws InterruptedException {
        c8610Ws.start();
        c8610Ws.S(this.P0.f);
        this.O0.n(this.P0.f);
        this.P0.f.setImageDrawable(c8610Ws);
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

    public void T3(C5886Lg2 c5886Lg2, AbstractC15520jj2.c cVar) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(cVar, DialogEntity.COLUMN_MESSAGE);
        super.H2(c5886Lg2, cVar);
        this.Q0 = cVar;
        TextView textView = l1().o;
        AbstractC13042fc3.h(textView, "feedPhotoText");
        f3(textView, c5886Lg2, cVar.c(), t1());
        this.P0.d.getBackground().setColorFilter(new PorterDuffColorFilter(AbstractC4043Dl1.c(this.a.getContext(), AA5.onBackground_fixed), PorterDuff.Mode.MULTIPLY));
        CircleProgressBar circleProgressBar = this.P0.c;
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        circleProgressBar.setColor(OY0.b(context, AbstractC13999hA5.colorOnPrimary));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        circleProgressBar.setBgColor(c5495Jo7.y0(OY0.b(context2, AbstractC13999hA5.colorOnPrimary), 40));
        ImageView imageView = this.P0.f;
        AbstractC13042fc3.h(imageView, "gifContainer");
        W3(imageView, cVar.f());
        this.R0 = this.N0.D(cVar.d(), true, V3(), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        this.P0.f.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.Yh2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C9289Zh2.U3(this.a, view, motionEvent);
            }
        });
    }

    @Override // ir.nasim.JA2, ir.nasim.AbstractC13019fa0
    public void a() {
        super.a();
        ImageView imageView = this.P0.f;
        imageView.setImageDrawable(null);
        this.O0.n(imageView);
        this.P0.f.setImageDrawable(null);
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.R0;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
        this.R0 = null;
        C8610Ws c8610Ws = this.S0;
        if (c8610Ws != null) {
            AbstractC14228ha0.b(c8610Ws);
        }
        this.S0 = null;
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
