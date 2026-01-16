package ir.nasim;

import ir.nasim.AbstractC9998au2;

/* renamed from: ir.nasim.du2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11999du2 implements AbstractC9998au2.b {
    private final InterfaceC9848af5 a;
    private final InterfaceC18438of5 b;
    private final C18637oz7 c;
    private final C15630ju2 d;
    private final C9265Ze5 e;
    private final UA2 f;

    /* renamed from: ir.nasim.du2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C18046nz7 c18046nz7) {
            return C11999du2.this.h(C18046nz7.b(c18046nz7, null, null, 0, 0, null, 30, null)).getValue();
        }
    }

    /* renamed from: ir.nasim.du2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C18046nz7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C18046nz7 c18046nz7) {
            super(1);
            this.f = c18046nz7;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC19228pz7 invoke(UA2 ua2) {
            InterfaceC19228pz7 interfaceC19228pz7A = C11999du2.this.d.a(this.f, C11999du2.this.g(), ua2, C11999du2.this.f);
            if (interfaceC19228pz7A == null && (interfaceC19228pz7A = C11999du2.this.e.a(this.f, C11999du2.this.g(), ua2, C11999du2.this.f)) == null) {
                throw new IllegalStateException("Could not load font");
            }
            return interfaceC19228pz7A;
        }
    }

    public C11999du2(InterfaceC9848af5 interfaceC9848af5, InterfaceC18438of5 interfaceC18438of5, C18637oz7 c18637oz7, C15630ju2 c15630ju2, C9265Ze5 c9265Ze5) {
        this.a = interfaceC9848af5;
        this.b = interfaceC18438of5;
        this.c = c18637oz7;
        this.d = c15630ju2;
        this.e = c9265Ze5;
        this.f = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC9664aL6 h(C18046nz7 c18046nz7) {
        return this.c.c(c18046nz7, new b(c18046nz7));
    }

    @Override // ir.nasim.AbstractC9998au2.b
    public InterfaceC9664aL6 b(AbstractC9998au2 abstractC9998au2, C4593Fu2 c4593Fu2, int i, int i2) {
        return h(new C18046nz7(this.b.b(abstractC9998au2), this.b.d(c4593Fu2), this.b.a(i), this.b.c(i2), this.a.b(), null));
    }

    public final InterfaceC9848af5 g() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C11999du2(InterfaceC9848af5 interfaceC9848af5, InterfaceC18438of5 interfaceC18438of5, C18637oz7 c18637oz7, C15630ju2 c15630ju2, C9265Ze5 c9265Ze5, int i, ED1 ed1) {
        this(interfaceC9848af5, (i & 2) != 0 ? InterfaceC18438of5.a.a() : interfaceC18438of5, (i & 4) != 0 ? AbstractC12612eu2.b() : c18637oz7, (i & 8) != 0 ? new C15630ju2(AbstractC12612eu2.a(), null, 2, 0 == true ? 1 : 0) : c15630ju2, (i & 16) != 0 ? new C9265Ze5() : c9265Ze5);
    }
}
