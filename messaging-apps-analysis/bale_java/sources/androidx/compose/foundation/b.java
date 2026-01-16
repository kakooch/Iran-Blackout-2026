package androidx.compose.foundation;

import ir.nasim.AbstractC12520el0;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.MK5;
import ir.nasim.Q93;
import ir.nasim.T93;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public abstract class b {

    public static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ AbstractC12520el0 f;
        final /* synthetic */ InterfaceC10031ax6 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(float f, AbstractC12520el0 abstractC12520el0, InterfaceC10031ax6 interfaceC10031ax6) {
            super(1);
            this.e = f;
            this.f = abstractC12520el0;
            this.g = interfaceC10031ax6;
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

    /* renamed from: androidx.compose.foundation.b$b, reason: collision with other inner class name */
    public static final class C0031b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ InterfaceC10031ax6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0031b(long j, InterfaceC10031ax6 interfaceC10031ax6) {
            super(1);
            this.e = j;
            this.f = interfaceC10031ax6;
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

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, AbstractC12520el0 abstractC12520el0, InterfaceC10031ax6 interfaceC10031ax6, float f) {
        return eVar.i(new BackgroundElement(0L, abstractC12520el0, f, interfaceC10031ax6, Q93.b() ? new a(f, abstractC12520el0, interfaceC10031ax6) : Q93.a(), 1, null));
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, AbstractC12520el0 abstractC12520el0, InterfaceC10031ax6 interfaceC10031ax6, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC10031ax6 = MK5.a();
        }
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        return a(eVar, abstractC12520el0, interfaceC10031ax6, f);
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, long j, InterfaceC10031ax6 interfaceC10031ax6) {
        return eVar.i(new BackgroundElement(j, null, 1.0f, interfaceC10031ax6, Q93.b() ? new C0031b(j, interfaceC10031ax6) : Q93.a(), 2, null));
    }

    public static /* synthetic */ androidx.compose.ui.e d(androidx.compose.ui.e eVar, long j, InterfaceC10031ax6 interfaceC10031ax6, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC10031ax6 = MK5.a();
        }
        return c(eVar, j, interfaceC10031ax6);
    }
}
