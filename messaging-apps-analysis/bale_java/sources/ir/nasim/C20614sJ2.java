package ir.nasim;

import android.graphics.Bitmap;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.sJ2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20614sJ2 implements InterfaceC20468s37 {
    public static final int b = C14970in2.j;
    private final C14970in2 a;

    /* renamed from: ir.nasim.sJ2$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C20614sJ2.this.a(null, this);
        }
    }

    /* renamed from: ir.nasim.sJ2$b */
    public static final class b implements InterfaceC8807Xk2 {
        final /* synthetic */ HE0 a;

        b(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
            AbstractC24549yo1.c(this.a, new XV4(Boolean.FALSE, null));
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            AbstractC24549yo1.c(this.a, new XV4(Boolean.TRUE, interfaceC3346Am2.getDescriptor()));
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void e() {
            AbstractC24549yo1.c(this.a, new XV4(Boolean.FALSE, null));
        }
    }

    public C20614sJ2(C14970in2 c14970in2) {
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.a = c14970in2;
    }

    private final Bitmap c(C22694vg2 c22694vg2) {
        if (c22694vg2 == null) {
            return null;
        }
        try {
            byte[] bArrC = c22694vg2.c();
            if (bArrC == null) {
                return null;
            }
            if (!(bArrC.length == 0)) {
                return C16670lg0.b(c22694vg2.c());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.XV4 r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20614sJ2.a(ir.nasim.XV4, ir.nasim.rm1):java.lang.Object");
    }
}
