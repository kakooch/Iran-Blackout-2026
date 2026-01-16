package ir.nasim;

import ai.bale.proto.StoryOuterClass$RequestReactToStory;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.StringValue;

/* loaded from: classes7.dex */
public final class HH5 {
    private final C10330bT6 a;
    private final InterfaceC9336Zm4 b;
    private final InterfaceC10258bL6 c;

    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return HH5.this.c(this);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ HH5 e;
        final /* synthetic */ EnumC10088b35 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, HH5 hh5, EnumC10088b35 enumC10088b35, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = str2;
            this.e = hh5;
            this.f = enumC10088b35;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryOuterClass$RequestReactToStory.a aVarB = StoryOuterClass$RequestReactToStory.newBuilder().A("").C(PU6.StoryReactionType_Emoji).D(this.c).B(StringValue.of(this.d));
                C10330bT6 c10330bT6 = this.e.a;
                EnumC10088b35 enumC10088b35 = this.f;
                AbstractC13042fc3.f(aVarB);
                this.b = 1;
                obj = c10330bT6.b(enumC10088b35, aVarB, this);
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ HH5 d;
        final /* synthetic */ EnumC10088b35 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, HH5 hh5, EnumC10088b35 enumC10088b35, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = hh5;
            this.e = enumC10088b35;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryOuterClass$RequestReactToStory.a aVarD = StoryOuterClass$RequestReactToStory.newBuilder().A("").C(PU6.StoryReactionType_Remove_Emoji).D(this.c);
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public HH5(C10330bT6 c10330bT6) {
        AbstractC13042fc3.i(c10330bT6, "storyReactionApi");
        this.a = c10330bT6;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.b = interfaceC9336Zm4A;
        this.c = interfaceC9336Zm4A;
    }

    public final InterfaceC10258bL6 b() {
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ir.nasim.HH5.a
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.HH5$a r0 = (ir.nasim.HH5.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.HH5$a r0 = new ir.nasim.HH5$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L44
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            ir.nasim.AbstractC10685c16.b(r10)
            goto Lc2
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L38:
            ir.nasim.AbstractC10685c16.b(r10)
            goto L6d
        L3c:
            java.lang.Object r2 = r0.a
            ir.nasim.HH5 r2 = (ir.nasim.HH5) r2
            ir.nasim.AbstractC10685c16.b(r10)
            goto L55
        L44:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.bT6 r10 = r9.a
            r0.a = r9
            r0.d = r5
            java.lang.Object r10 = r10.a(r0)
            if (r10 != r1) goto L54
            return r1
        L54:
            r2 = r9
        L55:
            ir.nasim.Z06 r10 = (ir.nasim.Z06) r10
            boolean r5 = r10 instanceof ir.nasim.Z06.a
            r6 = 0
            if (r5 == 0) goto L70
            ir.nasim.Zm4 r10 = r2.b
            java.util.List r2 = ir.nasim.ZW0.m()
            r0.a = r6
            r0.d = r4
            java.lang.Object r10 = r10.a(r2, r0)
            if (r10 != r1) goto L6d
            return r1
        L6d:
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            return r10
        L70:
            boolean r4 = r10 instanceof ir.nasim.Z06.b
            if (r4 == 0) goto Lc5
            ir.nasim.Zm4 r2 = r2.b
            ir.nasim.Z06$b r10 = (ir.nasim.Z06.b) r10
            com.google.protobuf.P r10 = r10.a()
            ai.bale.proto.StoryOuterClass$ResponseGetStoryReactionEmojis r10 = (ai.bale.proto.StoryOuterClass$ResponseGetStoryReactionEmojis) r10
            java.util.List r10 = r10.getEmojisOrBuilderList()
            java.lang.String r4 = "getEmojisOrBuilderList(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r4)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = ir.nasim.ZW0.x(r10, r5)
            r4.<init>(r5)
            java.util.Iterator r10 = r10.iterator()
        L98:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto Lb7
            java.lang.Object r5 = r10.next()
            ir.nasim.qU6 r5 = (ir.nasim.InterfaceC19517qU6) r5
            ir.nasim.fH5 r7 = new ir.nasim.fH5
            java.lang.String r5 = r5.getEmoji()
            java.lang.String r8 = "getEmoji(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r8)
            r8 = 0
            r7.<init>(r5, r8)
            r4.add(r7)
            goto L98
        Lb7:
            r0.a = r6
            r0.d = r3
            java.lang.Object r10 = r2.a(r4, r0)
            if (r10 != r1) goto Lc2
            return r1
        Lc2:
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            return r10
        Lc5:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HH5.c(ir.nasim.rm1):java.lang.Object");
    }

    public final Object d(String str, EnumC10088b35 enumC10088b35, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(str, str2, this, enumC10088b35, null), interfaceC20295rm1);
    }

    public final Object e(String str, EnumC10088b35 enumC10088b35, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new c(str, this, enumC10088b35, null), interfaceC20295rm1);
    }
}
