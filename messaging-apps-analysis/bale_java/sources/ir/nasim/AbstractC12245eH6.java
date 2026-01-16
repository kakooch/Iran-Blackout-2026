package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.Set;

/* renamed from: ir.nasim.eH6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract /* synthetic */ class AbstractC12245eH6 {

    /* renamed from: ir.nasim.eH6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC11938do1 d;
        final /* synthetic */ InterfaceC4557Fq2 e;

        /* renamed from: ir.nasim.eH6$a$a, reason: collision with other inner class name */
        static final class C1047a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC14415hs5 a;

            C1047a(InterfaceC14415hs5 interfaceC14415hs5) {
                this.a = interfaceC14415hs5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setValue(obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.eH6$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* renamed from: ir.nasim.eH6$a$b$a, reason: collision with other inner class name */
            static final class C1048a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC14415hs5 a;

                C1048a(InterfaceC14415hs5 interfaceC14415hs5) {
                    this.a = interfaceC14415hs5;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.setValue(obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2 = this.c;
                    C1048a c1048a = new C1048a(this.d);
                    this.b = 1;
                    if (interfaceC4557Fq2.b(c1048a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC11938do1 interfaceC11938do1, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC11938do1;
            this.e = interfaceC4557Fq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                if (AbstractC13042fc3.d(this.d, C18712p72.a)) {
                    InterfaceC4557Fq2 interfaceC4557Fq2 = this.e;
                    C1047a c1047a = new C1047a(interfaceC14415hs5);
                    this.b = 1;
                    if (interfaceC4557Fq2.b(c1047a, this) == objE) {
                        return objE;
                    }
                } else {
                    InterfaceC11938do1 interfaceC11938do1 = this.d;
                    b bVar = new b(this.e, interfaceC14415hs5, null);
                    this.b = 2;
                    if (AbstractC9323Zl0.g(interfaceC11938do1, bVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eH6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        int h;
        private /* synthetic */ Object i;
        final /* synthetic */ SA2 j;

        /* renamed from: ir.nasim.eH6$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C7620Sm4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C7620Sm4 c7620Sm4) {
                super(1);
                this.e = c7620Sm4;
            }

            public final void a(Object obj) {
                if (obj instanceof AbstractC15299jL6) {
                    ((AbstractC15299jL6) obj).A(androidx.compose.runtime.snapshots.e.a(4));
                }
                this.e.h(obj);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.eH6$b$b, reason: collision with other inner class name */
        static final class C1049b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC17639nJ0 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1049b(InterfaceC17639nJ0 interfaceC17639nJ0) {
                super(2);
                this.e = interfaceC17639nJ0;
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(java.util.Set r17, androidx.compose.runtime.snapshots.g r18) {
                /*
                    r16 = this;
                    r0 = r17
                    boolean r1 = r0 instanceof ir.nasim.C23844xc6
                    r2 = 4
                    if (r1 == 0) goto L64
                    r1 = r0
                    ir.nasim.xc6 r1 = (ir.nasim.C23844xc6) r1
                    ir.nasim.vc6 r1 = r1.f()
                    java.lang.Object[] r3 = r1.b
                    long[] r1 = r1.a
                    int r4 = r1.length
                    int r4 = r4 + (-2)
                    if (r4 < 0) goto L61
                    r5 = 0
                    r6 = r5
                L19:
                    r7 = r1[r6]
                    long r9 = ~r7
                    r11 = 7
                    long r9 = r9 << r11
                    long r9 = r9 & r7
                    r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                    long r9 = r9 & r11
                    int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                    if (r9 == 0) goto L5c
                    int r9 = r6 - r4
                    int r9 = ~r9
                    int r9 = r9 >>> 31
                    r10 = 8
                    int r9 = 8 - r9
                    r11 = r5
                L33:
                    if (r11 >= r9) goto L5a
                    r12 = 255(0xff, double:1.26E-321)
                    long r12 = r12 & r7
                    r14 = 128(0x80, double:6.3E-322)
                    int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                    if (r12 >= 0) goto L56
                    int r12 = r6 << 3
                    int r12 = r12 + r11
                    r12 = r3[r12]
                    boolean r13 = r12 instanceof ir.nasim.AbstractC15299jL6
                    if (r13 == 0) goto L53
                    ir.nasim.jL6 r12 = (ir.nasim.AbstractC15299jL6) r12
                    int r13 = androidx.compose.runtime.snapshots.e.a(r2)
                    boolean r12 = r12.z(r13)
                    if (r12 == 0) goto L56
                L53:
                    r1 = r16
                    goto L94
                L56:
                    long r7 = r7 >> r10
                    int r11 = r11 + 1
                    goto L33
                L5a:
                    if (r9 != r10) goto L61
                L5c:
                    if (r6 == r4) goto L61
                    int r6 = r6 + 1
                    goto L19
                L61:
                    r1 = r16
                    goto L99
                L64:
                    r1 = r0
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    boolean r3 = r1 instanceof java.util.Collection
                    if (r3 == 0) goto L75
                    r3 = r1
                    java.util.Collection r3 = (java.util.Collection) r3
                    boolean r3 = r3.isEmpty()
                    if (r3 == 0) goto L75
                    goto L61
                L75:
                    java.util.Iterator r1 = r1.iterator()
                L79:
                    boolean r3 = r1.hasNext()
                    if (r3 == 0) goto L61
                    java.lang.Object r3 = r1.next()
                    boolean r4 = r3 instanceof ir.nasim.AbstractC15299jL6
                    if (r4 == 0) goto L53
                    ir.nasim.jL6 r3 = (ir.nasim.AbstractC15299jL6) r3
                    int r4 = androidx.compose.runtime.snapshots.e.a(r2)
                    boolean r3 = r3.z(r4)
                    if (r3 == 0) goto L79
                    goto L53
                L94:
                    ir.nasim.nJ0 r2 = r1.e
                    r2.h(r0)
                L99:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC12245eH6.b.C1049b.a(java.util.Set, androidx.compose.runtime.snapshots.g):void");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Set) obj, (androidx.compose.runtime.snapshots.g) obj2);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.j = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.j, interfaceC20295rm1);
            bVar.i = obj;
            return bVar;
        }

        /* JADX WARN: Path cross not found for [B:34:0x00e1, B:38:0x00ea], limit reached: 76 */
        /* JADX WARN: Path cross not found for [B:42:0x00f9, B:58:0x0138], limit reached: 76 */
        /* JADX WARN: Path cross not found for [B:58:0x0138, B:42:0x00f9], limit reached: 76 */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00f9 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #1 {all -> 0x0055, blocks: (B:32:0x00dd, B:34:0x00e1, B:39:0x00eb, B:42:0x00f9, B:46:0x010f, B:48:0x0118, B:56:0x0134, B:57:0x0137, B:15:0x0050, B:43:0x0104, B:45:0x010c, B:54:0x0130, B:55:0x0133), top: B:71:0x0050, inners: #2 }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 334
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC12245eH6.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC9664aL6 b(InterfaceC4557Fq2 interfaceC4557Fq2, Object obj, InterfaceC11938do1 interfaceC11938do1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        InterfaceC11938do1 interfaceC11938do12 = interfaceC11938do1;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-606625098, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:64)");
        }
        boolean zD = interfaceC22053ub1.D(interfaceC11938do12) | interfaceC22053ub1.D(interfaceC4557Fq2);
        Object objB = interfaceC22053ub1.B();
        if (zD || objB == InterfaceC22053ub1.a.a()) {
            objB = new a(interfaceC11938do12, interfaceC4557Fq2, null);
            interfaceC22053ub1.s(objB);
        }
        int i3 = i >> 3;
        InterfaceC9664aL6 interfaceC9664aL6M = AbstractC10222bH6.m(obj, interfaceC4557Fq2, interfaceC11938do12, (InterfaceC14603iB2) objB, interfaceC22053ub1, (i3 & 14) | (i3 & 8) | ((i << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6M;
    }

    public static final InterfaceC9664aL6 c(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC11938do1 interfaceC11938do1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        InterfaceC11938do1 interfaceC11938do12 = interfaceC11938do1;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1439883919, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:48)");
        }
        InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(interfaceC10258bL6, interfaceC10258bL6.getValue(), interfaceC11938do12, interfaceC22053ub1, (i & 14) | ((i << 3) & 896), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(C7620Sm4 c7620Sm4, Set set) {
        Object[] objArr = c7620Sm4.b;
        long[] jArr = c7620Sm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && set.contains(objArr[(i << 3) + i3])) {
                        return true;
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return false;
                }
            }
            if (i == length) {
                return false;
            }
            i++;
        }
    }

    public static final InterfaceC4557Fq2 e(SA2 sa2) {
        return AbstractC6459Nq2.R(new b(sa2, null));
    }
}
