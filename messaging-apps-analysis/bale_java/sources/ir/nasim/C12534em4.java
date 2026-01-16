package ir.nasim;

import ir.nasim.AbstractC13460gG3;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.em4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12534em4 {
    private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    private final InterfaceC9336Zm4 b;
    private final InterfaceC10258bL6 c;

    /* renamed from: ir.nasim.em4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C14653iG3 f;
        final /* synthetic */ C14653iG3 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
            super(1);
            this.f = c14653iG3;
            this.g = c14653iG32;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13628gZ0 invoke(C13628gZ0 c13628gZ0) {
            return C12534em4.this.d(c13628gZ0, this.f, this.g);
        }
    }

    /* renamed from: ir.nasim.em4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ EnumC16433lG3 f;
        final /* synthetic */ AbstractC13460gG3 g;
        final /* synthetic */ C12534em4 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z, EnumC16433lG3 enumC16433lG3, AbstractC13460gG3 abstractC13460gG3, C12534em4 c12534em4) {
            super(1);
            this.e = z;
            this.f = enumC16433lG3;
            this.g = abstractC13460gG3;
            this.h = c12534em4;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13628gZ0 invoke(C13628gZ0 c13628gZ0) {
            C14653iG3 c14653iG3A;
            if (c13628gZ0 == null || (c14653iG3A = c13628gZ0.e()) == null) {
                c14653iG3A = C14653iG3.f.a();
            }
            C14653iG3 c14653iG3B = c13628gZ0 != null ? c13628gZ0.b() : null;
            if (this.e) {
                c14653iG3B = C14653iG3.f.a().i(this.f, this.g);
            } else {
                c14653iG3A = c14653iG3A.i(this.f, this.g);
            }
            return this.h.d(c13628gZ0, c14653iG3A, c14653iG3B);
        }
    }

    public C12534em4() {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(null);
        this.b = interfaceC9336Zm4A;
        this.c = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    private final AbstractC13460gG3 c(AbstractC13460gG3 abstractC13460gG3, AbstractC13460gG3 abstractC13460gG32, AbstractC13460gG3 abstractC13460gG33, AbstractC13460gG3 abstractC13460gG34) {
        return abstractC13460gG34 == null ? abstractC13460gG33 : (!(abstractC13460gG3 instanceof AbstractC13460gG3.b) || ((abstractC13460gG32 instanceof AbstractC13460gG3.c) && (abstractC13460gG34 instanceof AbstractC13460gG3.c)) || (abstractC13460gG34 instanceof AbstractC13460gG3.a)) ? abstractC13460gG34 : abstractC13460gG3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13628gZ0 d(C13628gZ0 c13628gZ0, C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
        AbstractC13460gG3 abstractC13460gG3B;
        AbstractC13460gG3 abstractC13460gG3B2;
        AbstractC13460gG3 abstractC13460gG3B3;
        if (c13628gZ0 == null || (abstractC13460gG3B = c13628gZ0.d()) == null) {
            abstractC13460gG3B = AbstractC13460gG3.c.b.b();
        }
        AbstractC13460gG3 abstractC13460gG3C = c(abstractC13460gG3B, c14653iG3.f(), c14653iG3.f(), c14653iG32 != null ? c14653iG32.f() : null);
        if (c13628gZ0 == null || (abstractC13460gG3B2 = c13628gZ0.c()) == null) {
            abstractC13460gG3B2 = AbstractC13460gG3.c.b.b();
        }
        AbstractC13460gG3 abstractC13460gG3C2 = c(abstractC13460gG3B2, c14653iG3.f(), c14653iG3.e(), c14653iG32 != null ? c14653iG32.e() : null);
        if (c13628gZ0 == null || (abstractC13460gG3B3 = c13628gZ0.a()) == null) {
            abstractC13460gG3B3 = AbstractC13460gG3.c.b.b();
        }
        return new C13628gZ0(abstractC13460gG3C, abstractC13460gG3C2, c(abstractC13460gG3B3, c14653iG3.f(), c14653iG3.d(), c14653iG32 != null ? c14653iG32.d() : null), c14653iG3, c14653iG32);
    }

    private final void e(UA2 ua2) {
        Object value;
        C13628gZ0 c13628gZ0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
        do {
            value = interfaceC9336Zm4.getValue();
            C13628gZ0 c13628gZ02 = (C13628gZ0) value;
            c13628gZ0 = (C13628gZ0) ua2.invoke(c13628gZ02);
            if (AbstractC13042fc3.d(c13628gZ02, c13628gZ0)) {
                return;
            }
        } while (!interfaceC9336Zm4.f(value, c13628gZ0));
        if (c13628gZ0 != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((UA2) it.next()).invoke(c13628gZ0);
            }
        }
    }

    public final void b(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        this.a.add(ua2);
        C13628gZ0 c13628gZ0 = (C13628gZ0) this.b.getValue();
        if (c13628gZ0 != null) {
            ua2.invoke(c13628gZ0);
        }
    }

    public final InterfaceC10258bL6 f() {
        return this.c;
    }

    public final void g(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        this.a.remove(ua2);
    }

    public final void h(C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
        AbstractC13042fc3.i(c14653iG3, "sourceLoadStates");
        e(new a(c14653iG3, c14653iG32));
    }

    public final void i(EnumC16433lG3 enumC16433lG3, boolean z, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(enumC16433lG3, "type");
        AbstractC13042fc3.i(abstractC13460gG3, "state");
        e(new b(z, enumC16433lG3, abstractC13460gG3, this));
    }
}
