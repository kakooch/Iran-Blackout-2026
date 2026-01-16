package ir.nasim;

import ai.bale.proto.StoryOuterClass$RequestReactToStory;

/* loaded from: classes7.dex */
public final class JX7 {
    private final C10330bT6 a;
    private final VV6 b;
    private final IX7 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ JX7 d;
        final /* synthetic */ EnumC10088b35 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, JX7 jx7, EnumC10088b35 enumC10088b35, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = jx7;
            this.e = enumC10088b35;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryOuterClass$RequestReactToStory.a aVarD = StoryOuterClass$RequestReactToStory.newBuilder().A("").C(PU6.StoryReactionType_View).D(this.c);
                C10330bT6 c10330bT6 = this.d.a;
                EnumC10088b35 enumC10088b35 = this.e;
                AbstractC13042fc3.f(aVarD);
                this.b = 1;
                obj = c10330bT6.b(enumC10088b35, aVarD, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public JX7(C10330bT6 c10330bT6, VV6 vv6, IX7 ix7) {
        AbstractC13042fc3.i(c10330bT6, "storyReactionApi");
        AbstractC13042fc3.i(vv6, "storyViewApi");
        AbstractC13042fc3.i(ix7, "viewStoryDataStore");
        this.a = c10330bT6;
        this.b = vv6;
        this.c = ix7;
    }

    public final Object b(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = this.c.a(j, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    public final Object c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b.b(str, interfaceC20295rm1);
    }

    public final int d() {
        return this.c.b();
    }

    public final Object e(String str, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b.c(str, i, i2, interfaceC20295rm1);
    }

    public final Object f(QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.c.c(qq6, interfaceC20295rm1);
    }

    public final void g(int i) {
        this.c.d(i);
    }

    public final Object h(String str, EnumC10088b35 enumC10088b35, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new a(str, this, enumC10088b35, null), interfaceC20295rm1);
    }
}
