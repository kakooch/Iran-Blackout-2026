package ir.nasim;

import ai.bale.proto.AdvertisementOuterClass$RequestGetAdProvider;
import ai.bale.proto.AdvertisementOuterClass$ResponseGetAdProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;

/* renamed from: ir.nasim.tG2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21190tG2 {
    private final C6287Mz a;
    private final C6565Ob b;
    private final C10856cJ6 c;

    /* renamed from: ir.nasim.tG2$a */
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
            return C21190tG2.this.b(this);
        }
    }

    /* renamed from: ir.nasim.tG2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21190tG2.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AdvertisementOuterClass$ResponseGetAdProvider defaultInstance = AdvertisementOuterClass$ResponseGetAdProvider.getDefaultInstance();
                AdvertisementOuterClass$RequestGetAdProvider.a aVarNewBuilder = AdvertisementOuterClass$RequestGetAdProvider.newBuilder();
                aVarNewBuilder.C(EnumC8025Uf.AdvertisementType_NATIVE);
                aVarNewBuilder.B(EnumC4938Hf.AdSpot_DIALOG);
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                AbstractC13042fc3.f(defaultInstance);
                C22871vx5 c22871vx5 = new C22871vx5("/bale.advertisement.v1.Advertisement/GetAdProvider", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = C21190tG2.this.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
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

    public C21190tG2(C6287Mz c6287Mz, C6565Ob c6565Ob, C10856cJ6 c10856cJ6) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(c6565Ob, "mapper");
        AbstractC13042fc3.i(c10856cJ6, "sponsoredAdvertisementMapper");
        this.a = c6287Mz;
        this.b = c6565Ob;
        this.c = c10856cJ6;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C21190tG2.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.tG2$a r0 = (ir.nasim.C21190tG2.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.tG2$a r0 = new ir.nasim.tG2$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.tG2 r0 = (ir.nasim.C21190tG2) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = ir.nasim.C12366eV1.b()
            ir.nasim.tG2$b r2 = new ir.nasim.tG2$b
            r4 = 0
            r2.<init>(r4)
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r0 = r5
        L4e:
            ir.nasim.Z06 r6 = (ir.nasim.Z06) r6
            boolean r1 = r6 instanceof ir.nasim.Z06.b
            if (r1 == 0) goto Lb3
            ir.nasim.Z06$b r6 = (ir.nasim.Z06.b) r6
            com.google.protobuf.P r6 = r6.a()
            ai.bale.proto.AdvertisementOuterClass$ResponseGetAdProvider r6 = (ai.bale.proto.AdvertisementOuterClass$ResponseGetAdProvider) r6
            ir.nasim.Ob r0 = r0.b
            java.util.List r6 = r6.getContentList()
            java.lang.String r1 = "getContentList(...)"
            ir.nasim.AbstractC13042fc3.h(r6, r1)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r6 = r6.iterator()
        L72:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L8b
            java.lang.Object r2 = r6.next()
            r3 = r2
            ai.bale.proto.AdvertisementStruct$AdContent r3 = (ai.bale.proto.AdvertisementStruct$AdContent) r3
            ai.bale.proto.AdvertisementStruct$AdContent$b r3 = r3.getTraitCase()
            ai.bale.proto.AdvertisementStruct$AdContent$b r4 = ai.bale.proto.AdvertisementStruct$AdContent.b.BALE_CUSTOM_AD
            if (r3 != r4) goto L72
            r1.add(r2)
            goto L72
        L8b:
            java.util.ArrayList r6 = new java.util.ArrayList
            r2 = 10
            int r2 = ir.nasim.ZW0.x(r1, r2)
            r6.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L9a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lae
            java.lang.Object r2 = r1.next()
            ai.bale.proto.AdvertisementStruct$AdContent r2 = (ai.bale.proto.AdvertisementStruct$AdContent) r2
            ai.bale.proto.AdvertisementStruct$BaleCustomAd r2 = r2.getBaleCustomAd()
            r6.add(r2)
            goto L9a
        Lae:
            java.util.List r6 = r0.a(r6)
            goto Lbb
        Lb3:
            boolean r6 = r6 instanceof ir.nasim.Z06.a
            if (r6 == 0) goto Lbc
            java.util.List r6 = ir.nasim.ZW0.m()
        Lbb:
            return r6
        Lbc:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21190tG2.b(ir.nasim.rm1):java.lang.Object");
    }
}
