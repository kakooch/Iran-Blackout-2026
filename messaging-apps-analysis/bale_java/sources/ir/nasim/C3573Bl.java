package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C19907r85;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.Bl, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3573Bl extends RecyclerView.C {
    public static final a A = new a(null);
    public static final int B = 8;
    private final C3807Cl u;
    private final InterfaceC21561tl v;
    private final C14970in2 w;
    private AbstractC15520jj2.a x;
    private XV4 y;
    private C19907r85 z;

    /* renamed from: ir.nasim.Bl$a */
    public static final class a {
        private a() {
        }

        public final C3573Bl a(ViewGroup viewGroup, InterfaceC21561tl interfaceC21561tl, C14970in2 c14970in2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC21561tl, "albumItemListener");
            AbstractC13042fc3.i(c14970in2, "filesModule");
            C3807Cl c3807ClC = C3807Cl.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c3807ClC, "inflate(...)");
            return new C3573Bl(c3807ClC, interfaceC21561tl, c14970in2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3573Bl(C3807Cl c3807Cl, InterfaceC21561tl interfaceC21561tl, C14970in2 c14970in2) {
        super(c3807Cl.getRoot());
        AbstractC13042fc3.i(c3807Cl, "binding");
        AbstractC13042fc3.i(interfaceC21561tl, "albumItemListener");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.u = c3807Cl;
        this.v = interfaceC21561tl;
        this.w = c14970in2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J0(C3573Bl c3573Bl, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(c3573Bl, "this$0");
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        ImageViewCrossFade imageViewCrossFade = c3573Bl.u.b;
        String descriptor = interfaceC3346Am2.getDescriptor();
        C20107rU5 c20107rU5 = new C20107rU5();
        XV4 xv4 = c3573Bl.y;
        XV4 xv42 = null;
        if (xv4 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv4 = null;
        }
        int iIntValue = ((Number) xv4.e()).intValue();
        XV4 xv43 = c3573Bl.y;
        if (xv43 == null) {
            AbstractC13042fc3.y("finalMeasure");
        } else {
            xv42 = xv43;
        }
        AbstractC6302Na0 abstractC6302Na0U0 = ((C20107rU5) c20107rU5.c0(iIntValue, ((Number) xv42.f()).intValue())).u0(new LH0());
        AbstractC13042fc3.h(abstractC6302Na0U0, "transform(...)");
        imageViewCrossFade.m(descriptor, (C20107rU5) abstractC6302Na0U0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L0(C3573Bl c3573Bl) {
        AbstractC13042fc3.i(c3573Bl, "this$0");
        C14970in2 c14970in2 = c3573Bl.w;
        AbstractC15520jj2.a aVar = c3573Bl.x;
        if (aVar == null) {
            AbstractC13042fc3.y("albumItem");
            aVar = null;
        }
        c14970in2.H(aVar.b().d().getFileId());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M0(C3573Bl c3573Bl, long j, String str, long j2, long j3) {
        AbstractC13042fc3.i(c3573Bl, "this$0");
        AbstractC13042fc3.i(str, "mimeType");
        c3573Bl.v.b(j, str, j2, j3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N0(C3573Bl c3573Bl, InterfaceC8091Um2 interfaceC8091Um2) {
        AbstractC13042fc3.i(c3573Bl, "this$0");
        AbstractC13042fc3.i(interfaceC8091Um2, "callback");
        C14970in2 c14970in2 = c3573Bl.w;
        AbstractC15520jj2.a aVar = c3573Bl.x;
        if (aVar == null) {
            AbstractC13042fc3.y("albumItem");
            aVar = null;
        }
        c14970in2.D(aVar.b().d(), true, interfaceC8091Um2, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        return C19938rB7.a;
    }

    public final void H0(AbstractC15520jj2.a aVar, XV4 xv4) {
        AbstractC13042fc3.i(aVar, "feedMessage");
        AbstractC13042fc3.i(xv4, "size");
        this.x = aVar;
        this.y = xv4;
        ConstraintLayout root = this.u.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = ((Number) xv4.e()).intValue();
        layoutParams.height = ((Number) xv4.f()).intValue();
        root.setLayoutParams(layoutParams);
        CircleProgressBar circleProgressBar = this.u.c;
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        circleProgressBar.setColor(OY0.b(context, AbstractC13999hA5.colorOnPrimary));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        circleProgressBar.setBgColor(c5495Jo7.y0(OY0.b(context2, AbstractC13999hA5.colorOnPrimary), 40));
        ImageViewCrossFade imageViewCrossFade = this.u.b;
        byte[] bArrF = aVar.b().f();
        AbstractC6302Na0 abstractC6302Na0Y0 = ((C20107rU5) new C20107rU5().c0(((Number) xv4.e()).intValue(), ((Number) xv4.f()).intValue())).y0(new C5191Ih0(10, 3), new LH0());
        AbstractC13042fc3.h(abstractC6302Na0Y0, "transform(...)");
        imageViewCrossFade.o(bArrF, (C20107rU5) abstractC6302Na0Y0);
        C19907r85.a aVar2 = C19907r85.k;
        AbstractC15520jj2.a aVar3 = this.x;
        if (aVar3 == null) {
            AbstractC13042fc3.y("albumItem");
            aVar3 = null;
        }
        FileReference fileReferenceD = aVar3.b().d();
        FrameLayout frameLayout = this.u.d;
        AbstractC13042fc3.h(frameLayout, "feedStateContainerPhoto");
        ImageView imageView = this.u.e;
        AbstractC13042fc3.h(imageView, "feedStatePhotoIv");
        CircleProgressBar circleProgressBar2 = this.u.c;
        AbstractC13042fc3.h(circleProgressBar2, "feedProgressPhoto");
        C19907r85 c19907r85B = aVar2.b(fileReferenceD, frameLayout, imageView, circleProgressBar2, new UA2() { // from class: ir.nasim.xl
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C3573Bl.J0(this.a, (InterfaceC3346Am2) obj);
            }
        }, new SA2() { // from class: ir.nasim.yl
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3573Bl.L0(this.a);
            }
        }, new InterfaceC16978mB2() { // from class: ir.nasim.zl
            @Override // ir.nasim.InterfaceC16978mB2
            public final Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                return C3573Bl.M0(this.a, ((Long) obj).longValue(), (String) obj2, ((Long) obj3).longValue(), ((Long) obj4).longValue());
            }
        }, new UA2() { // from class: ir.nasim.Al
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C3573Bl.N0(this.a, (InterfaceC8091Um2) obj);
            }
        }, (256 & 256) != 0 ? null : null);
        c19907r85B.b();
        this.z = c19907r85B;
    }
}
