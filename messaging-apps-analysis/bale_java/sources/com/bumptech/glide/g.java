package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13669gd2;
import ir.nasim.AbstractC23175wU1;
import ir.nasim.AbstractC3322Aj5;
import ir.nasim.AbstractC6302Na0;
import ir.nasim.C11769da2;
import ir.nasim.C19489qR5;
import ir.nasim.C20107rU5;
import ir.nasim.C23617xD6;
import ir.nasim.C3378Ap7;
import ir.nasim.C8358Vq;
import ir.nasim.CQ5;
import ir.nasim.EnumC6212Mq5;
import ir.nasim.IT5;
import ir.nasim.InterfaceC21549tj7;
import ir.nasim.PB2;
import ir.nasim.RP5;
import ir.nasim.YM7;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class g extends AbstractC6302Na0 implements Cloneable {
    protected static final C20107rU5 F0 = (C20107rU5) ((C20107rU5) ((C20107rU5) new C20107rU5().i(AbstractC23175wU1.c)).g0(EnumC6212Mq5.LOW)).p0(true);
    private final Context A;
    private g A0;
    private final h B;
    private Float B0;
    private boolean C0 = true;
    private final Class D;
    private boolean D0;
    private boolean E0;
    private final b G;
    private final d H;
    private i J;
    private Object Y;
    private List Z;
    private g z0;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC6212Mq5.values().length];
            b = iArr;
            try {
                iArr[EnumC6212Mq5.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC6212Mq5.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC6212Mq5.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EnumC6212Mq5.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected g(b bVar, h hVar, Class cls, Context context) {
        this.G = bVar;
        this.B = hVar;
        this.D = cls;
        this.A = context;
        this.J = hVar.s(cls);
        this.H = bVar.i();
        L0(hVar.q());
        b(hVar.r());
    }

    private g E0(g gVar) {
        return (g) ((g) gVar.q0(this.A.getTheme())).n0(C8358Vq.c(this.A));
    }

    private RP5 F0(InterfaceC21549tj7 interfaceC21549tj7, IT5 it5, AbstractC6302Na0 abstractC6302Na0, Executor executor) {
        return G0(new Object(), interfaceC21549tj7, it5, null, this.J, abstractC6302Na0.z(), abstractC6302Na0.w(), abstractC6302Na0.v(), abstractC6302Na0, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RP5 G0(Object obj, InterfaceC21549tj7 interfaceC21549tj7, IT5 it5, CQ5 cq5, i iVar, EnumC6212Mq5 enumC6212Mq5, int i, int i2, AbstractC6302Na0 abstractC6302Na0, Executor executor) {
        CQ5 cq52;
        CQ5 c11769da2;
        if (this.A0 != null) {
            c11769da2 = new C11769da2(obj, cq5);
            cq52 = c11769da2;
        } else {
            cq52 = null;
            c11769da2 = cq5;
        }
        RP5 rp5H0 = H0(obj, interfaceC21549tj7, it5, c11769da2, iVar, enumC6212Mq5, i, i2, abstractC6302Na0, executor);
        if (cq52 == null) {
            return rp5H0;
        }
        int iW = this.A0.w();
        int iV = this.A0.v();
        if (YM7.v(i, i2) && !this.A0.V()) {
            iW = abstractC6302Na0.w();
            iV = abstractC6302Na0.v();
        }
        g gVar = this.A0;
        C11769da2 c11769da22 = cq52;
        c11769da22.p(rp5H0, gVar.G0(obj, interfaceC21549tj7, it5, c11769da22, gVar.J, gVar.z(), iW, iV, this.A0, executor));
        return c11769da22;
    }

    private RP5 H0(Object obj, InterfaceC21549tj7 interfaceC21549tj7, IT5 it5, CQ5 cq5, i iVar, EnumC6212Mq5 enumC6212Mq5, int i, int i2, AbstractC6302Na0 abstractC6302Na0, Executor executor) {
        g gVar = this.z0;
        if (gVar == null) {
            if (this.B0 == null) {
                return e1(obj, interfaceC21549tj7, it5, abstractC6302Na0, cq5, iVar, enumC6212Mq5, i, i2, executor);
            }
            C3378Ap7 c3378Ap7 = new C3378Ap7(obj, cq5);
            c3378Ap7.o(e1(obj, interfaceC21549tj7, it5, abstractC6302Na0, c3378Ap7, iVar, enumC6212Mq5, i, i2, executor), e1(obj, interfaceC21549tj7, it5, abstractC6302Na0.clone().o0(this.B0.floatValue()), c3378Ap7, iVar, K0(enumC6212Mq5), i, i2, executor));
            return c3378Ap7;
        }
        if (this.E0) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        i iVar2 = gVar.C0 ? iVar : gVar.J;
        EnumC6212Mq5 enumC6212Mq5Z = gVar.L() ? this.z0.z() : K0(enumC6212Mq5);
        int iW = this.z0.w();
        int iV = this.z0.v();
        if (YM7.v(i, i2) && !this.z0.V()) {
            iW = abstractC6302Na0.w();
            iV = abstractC6302Na0.v();
        }
        C3378Ap7 c3378Ap72 = new C3378Ap7(obj, cq5);
        RP5 rp5E1 = e1(obj, interfaceC21549tj7, it5, abstractC6302Na0, c3378Ap72, iVar, enumC6212Mq5, i, i2, executor);
        this.E0 = true;
        g gVar2 = this.z0;
        RP5 rp5G0 = gVar2.G0(obj, interfaceC21549tj7, it5, c3378Ap72, iVar2, enumC6212Mq5Z, iW, iV, gVar2, executor);
        this.E0 = false;
        c3378Ap72.o(rp5E1, rp5G0);
        return c3378Ap72;
    }

    private EnumC6212Mq5 K0(EnumC6212Mq5 enumC6212Mq5) {
        int i = a.b[enumC6212Mq5.ordinal()];
        if (i == 1) {
            return EnumC6212Mq5.NORMAL;
        }
        if (i == 2) {
            return EnumC6212Mq5.HIGH;
        }
        if (i == 3 || i == 4) {
            return EnumC6212Mq5.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + z());
    }

    private void L0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            B0((IT5) it.next());
        }
    }

    private InterfaceC21549tj7 O0(InterfaceC21549tj7 interfaceC21549tj7, IT5 it5, AbstractC6302Na0 abstractC6302Na0, Executor executor) {
        AbstractC3322Aj5.d(interfaceC21549tj7);
        if (!this.D0) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        RP5 rp5F0 = F0(interfaceC21549tj7, it5, abstractC6302Na0, executor);
        RP5 request = interfaceC21549tj7.getRequest();
        if (rp5F0.j(request) && !R0(abstractC6302Na0, request)) {
            if (!((RP5) AbstractC3322Aj5.d(request)).isRunning()) {
                request.i();
            }
            return interfaceC21549tj7;
        }
        this.B.o(interfaceC21549tj7);
        interfaceC21549tj7.l(rp5F0);
        this.B.F(interfaceC21549tj7, rp5F0);
        return interfaceC21549tj7;
    }

    private boolean R0(AbstractC6302Na0 abstractC6302Na0, RP5 rp5) {
        return !abstractC6302Na0.K() && rp5.g();
    }

    private g c1(Object obj) {
        if (H()) {
            return clone().c1(obj);
        }
        this.Y = obj;
        this.D0 = true;
        return (g) l0();
    }

    private g d1(Uri uri, g gVar) {
        return (uri == null || !"android.resource".equals(uri.getScheme())) ? gVar : E0(gVar);
    }

    private RP5 e1(Object obj, InterfaceC21549tj7 interfaceC21549tj7, IT5 it5, AbstractC6302Na0 abstractC6302Na0, CQ5 cq5, i iVar, EnumC6212Mq5 enumC6212Mq5, int i, int i2, Executor executor) {
        Context context = this.A;
        d dVar = this.H;
        return C23617xD6.z(context, dVar, obj, this.Y, this.D, abstractC6302Na0, i, i2, enumC6212Mq5, interfaceC21549tj7, it5, this.Z, cq5, dVar.f(), iVar.c(), executor);
    }

    public g B0(IT5 it5) {
        if (H()) {
            return clone().B0(it5);
        }
        if (it5 != null) {
            if (this.Z == null) {
                this.Z = new ArrayList();
            }
            this.Z.add(it5);
        }
        return (g) l0();
    }

    @Override // ir.nasim.AbstractC6302Na0
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public g b(AbstractC6302Na0 abstractC6302Na0) {
        AbstractC3322Aj5.d(abstractC6302Na0);
        return (g) super.b(abstractC6302Na0);
    }

    @Override // ir.nasim.AbstractC6302Na0
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public g clone() {
        g gVar = (g) super.clone();
        gVar.J = gVar.J.clone();
        if (gVar.Z != null) {
            gVar.Z = new ArrayList(gVar.Z);
        }
        g gVar2 = gVar.z0;
        if (gVar2 != null) {
            gVar.z0 = gVar2.clone();
        }
        g gVar3 = gVar.A0;
        if (gVar3 != null) {
            gVar.A0 = gVar3.clone();
        }
        return gVar;
    }

    public InterfaceC21549tj7 M0(InterfaceC21549tj7 interfaceC21549tj7) {
        return P0(interfaceC21549tj7, null, AbstractC13669gd2.b());
    }

    InterfaceC21549tj7 P0(InterfaceC21549tj7 interfaceC21549tj7, IT5 it5, Executor executor) {
        return O0(interfaceC21549tj7, it5, this, executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.PX7 Q0(android.widget.ImageView r4) {
        /*
            r3 = this;
            ir.nasim.YM7.b()
            ir.nasim.AbstractC3322Aj5.d(r4)
            boolean r0 = r3.U()
            if (r0 != 0) goto L4c
            boolean r0 = r3.R()
            if (r0 == 0) goto L4c
            android.widget.ImageView$ScaleType r0 = r4.getScaleType()
            if (r0 == 0) goto L4c
            int[] r0 = com.bumptech.glide.g.a.a
            android.widget.ImageView$ScaleType r1 = r4.getScaleType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L43;
                case 2: goto L3a;
                case 3: goto L31;
                case 4: goto L31;
                case 5: goto L31;
                case 6: goto L28;
                default: goto L27;
            }
        L27:
            goto L4c
        L28:
            ir.nasim.Na0 r0 = r3.clone()
            ir.nasim.Na0 r0 = r0.Y()
            goto L4d
        L31:
            ir.nasim.Na0 r0 = r3.clone()
            ir.nasim.Na0 r0 = r0.Z()
            goto L4d
        L3a:
            ir.nasim.Na0 r0 = r3.clone()
            ir.nasim.Na0 r0 = r0.Y()
            goto L4d
        L43:
            ir.nasim.Na0 r0 = r3.clone()
            ir.nasim.Na0 r0 = r0.X()
            goto L4d
        L4c:
            r0 = r3
        L4d:
            com.bumptech.glide.d r1 = r3.H
            java.lang.Class r2 = r3.D
            ir.nasim.PX7 r4 = r1.a(r4, r2)
            r1 = 0
            java.util.concurrent.Executor r2 = ir.nasim.AbstractC13669gd2.b()
            ir.nasim.tj7 r4 = r3.O0(r4, r1, r0, r2)
            ir.nasim.PX7 r4 = (ir.nasim.PX7) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.g.Q0(android.widget.ImageView):ir.nasim.PX7");
    }

    public g S0(IT5 it5) {
        if (H()) {
            return clone().S0(it5);
        }
        this.Z = null;
        return B0(it5);
    }

    public g T0(Bitmap bitmap) {
        return c1(bitmap).b(C20107rU5.E0(AbstractC23175wU1.b));
    }

    public g U0(Drawable drawable) {
        return c1(drawable).b(C20107rU5.E0(AbstractC23175wU1.b));
    }

    public g V0(Uri uri) {
        return d1(uri, c1(uri));
    }

    public g W0(Integer num) {
        return E0(c1(num));
    }

    public g Y0(Object obj) {
        return c1(obj);
    }

    public g Z0(String str) {
        return c1(str);
    }

    public g a1(URL url) {
        return c1(url);
    }

    public g b1(byte[] bArr) {
        g gVarC1 = c1(bArr);
        if (!gVarC1.I()) {
            gVarC1 = gVarC1.b(C20107rU5.E0(AbstractC23175wU1.b));
        }
        return !gVarC1.Q() ? gVarC1.b(C20107rU5.G0(true)) : gVarC1;
    }

    @Override // ir.nasim.AbstractC6302Na0
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return super.equals(gVar) && Objects.equals(this.D, gVar.D) && this.J.equals(gVar.J) && Objects.equals(this.Y, gVar.Y) && Objects.equals(this.Z, gVar.Z) && Objects.equals(this.z0, gVar.z0) && Objects.equals(this.A0, gVar.A0) && Objects.equals(this.B0, gVar.B0) && this.C0 == gVar.C0 && this.D0 == gVar.D0;
    }

    public PB2 f1() {
        return g1(RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
    }

    public PB2 g1(int i, int i2) {
        C19489qR5 c19489qR5 = new C19489qR5(i, i2);
        return (PB2) P0(c19489qR5, c19489qR5, AbstractC13669gd2.a());
    }

    public g h1(g gVar) {
        if (H()) {
            return clone().h1(gVar);
        }
        this.z0 = gVar;
        return (g) l0();
    }

    @Override // ir.nasim.AbstractC6302Na0
    public int hashCode() {
        return YM7.r(this.D0, YM7.r(this.C0, YM7.q(this.B0, YM7.q(this.A0, YM7.q(this.z0, YM7.q(this.Z, YM7.q(this.Y, YM7.q(this.J, YM7.q(this.D, super.hashCode())))))))));
    }

    public g i1(i iVar) {
        if (H()) {
            return clone().i1(iVar);
        }
        this.J = (i) AbstractC3322Aj5.d(iVar);
        this.C0 = false;
        return (g) l0();
    }
}
