package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.AbstractC1970f;

/* renamed from: ir.nasim.Lo7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5963Lo7 {
    private static InterfaceC9336Zm4 a;
    private static androidx.lifecycle.r b;
    private static boolean c;

    /* renamed from: ir.nasim.Lo7$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Drawable drawableD = X38.d(this.c, C22078ud6.c(), C22078ud6.b());
            InterfaceC9336Zm4 interfaceC9336Zm4 = AbstractC5963Lo7.a;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, drawableD));
            AbstractC5963Lo7.d(false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(null);
        a = interfaceC9336Zm4A;
        b = AbstractC1970f.c(interfaceC9336Zm4A, null, 0L, 3, null);
    }

    public static final androidx.lifecycle.r b() {
        return b;
    }

    public static final void c(Context context) {
        AbstractC13042fc3.i(context, "context");
        if (c) {
            return;
        }
        c = true;
        AbstractC10533bm0.d(C17050mJ2.a, C12366eV1.b(), null, new a(context, null), 2, null);
    }

    public static final void d(boolean z) {
        c = z;
    }
}
