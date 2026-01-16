package ir.nasim;

import android.view.MotionEvent;
import androidx.compose.ui.viewinterop.AndroidViewHolder;

/* renamed from: ir.nasim.ah5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9868ah5 {

    /* renamed from: ir.nasim.ah5$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ TQ5 e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TQ5 tq5, UA2 ua2) {
            super(1);
            this.e = tq5;
            this.f = ua2;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ah5$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ TQ5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, TQ5 tq5) {
            super(3);
            this.e = ua2;
            this.f = tq5;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(374375707);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(374375707, i, -1, "androidx.compose.ui.input.pointer.pointerInteropFilter.<anonymous> (PointerInteropFilter.android.kt:77)");
            }
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new C9283Zg5();
                interfaceC22053ub1.s(objB);
            }
            C9283Zg5 c9283Zg5 = (C9283Zg5) objB;
            c9283Zg5.m(this.e);
            c9283Zg5.n(this.f);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return c9283Zg5;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.ah5$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AndroidViewHolder e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AndroidViewHolder androidViewHolder) {
            super(1);
            this.e = androidViewHolder;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(MotionEvent motionEvent) {
            boolean zDispatchTouchEvent;
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    zDispatchTouchEvent = this.e.dispatchTouchEvent(motionEvent);
                    break;
                default:
                    zDispatchTouchEvent = this.e.dispatchGenericMotionEvent(motionEvent);
                    break;
            }
            return Boolean.valueOf(zDispatchTouchEvent);
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, AndroidViewHolder androidViewHolder) {
        C9283Zg5 c9283Zg5 = new C9283Zg5();
        c9283Zg5.m(new c(androidViewHolder));
        TQ5 tq5 = new TQ5();
        c9283Zg5.n(tq5);
        androidViewHolder.setOnRequestDisallowInterceptTouchEvent$ui_release(tq5);
        return eVar.i(c9283Zg5);
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, TQ5 tq5, UA2 ua2) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new a(tq5, ua2) : Q93.a(), new b(ua2, tq5));
    }

    public static /* synthetic */ androidx.compose.ui.e c(androidx.compose.ui.e eVar, TQ5 tq5, UA2 ua2, int i, Object obj) {
        if ((i & 1) != 0) {
            tq5 = null;
        }
        return b(eVar, tq5, ua2);
    }
}
