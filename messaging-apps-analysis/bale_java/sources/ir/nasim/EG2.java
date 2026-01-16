package ir.nasim;

import android.content.Context;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.z0;
import ir.nasim.EG2;
import ir.nasim.InterfaceC15981kV7;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.RY1;
import ir.nasim.core.modules.file.entity.FileReference;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class EG2 {
    private static final a g = new a(null);
    public static final int h = 8;
    private final Cache a;
    private final InterfaceC12532em2 b;
    private final AbstractC13778go1 c;
    private final AbstractC13778go1 d;
    private final AbstractC13778go1 e;
    private final IT7 f;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ FileReference d;
        final /* synthetic */ EG2 e;
        final /* synthetic */ com.google.android.exoplayer2.E0 f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC10258bL6 c;
            final /* synthetic */ EG2 d;
            final /* synthetic */ FileReference e;

            /* renamed from: ir.nasim.EG2$b$a$a, reason: collision with other inner class name */
            static final class C0336a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;

                C0336a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0336a c0336a = new C0336a(interfaceC20295rm1);
                    c0336a.c = obj;
                    return c0336a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return AbstractC6392Nk0.a(((RY1) this.c) instanceof RY1.a);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0336a) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC10258bL6 interfaceC10258bL6, EG2 eg2, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC10258bL6;
                this.d = eg2;
                this.e = fileReference;
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
                    InterfaceC10258bL6 interfaceC10258bL6 = this.c;
                    C0336a c0336a = new C0336a(null);
                    this.b = 1;
                    if (AbstractC6459Nq2.H(interfaceC10258bL6, c0336a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    AbstractC10685c16.b(obj);
                }
                InterfaceC12532em2 interfaceC12532em2 = this.d.b;
                FileReference fileReference = this.e;
                this.b = 2;
                if (InterfaceC12532em2.a(interfaceC12532em2, fileReference, true, false, this, 4, null) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.EG2$b$b, reason: collision with other inner class name */
        static final class C0337b extends AbstractC19859r37 implements InterfaceC18160oB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ boolean d;
            /* synthetic */ Object e;
            final /* synthetic */ com.google.android.exoplayer2.E0 f;
            final /* synthetic */ EG2 g;
            final /* synthetic */ float h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0337b(com.google.android.exoplayer2.E0 e0, EG2 eg2, float f, InterfaceC20295rm1 interfaceC20295rm1) {
                super(5, interfaceC20295rm1);
                this.f = e0;
                this.g = eg2;
                this.h = f;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                float fA;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C17857ng5 c17857ng5 = (C17857ng5) this.c;
                boolean z = this.d;
                RY1 ry1 = (RY1) this.e;
                if (c17857ng5.d() == 3) {
                    boolean zF = c17857ng5.f();
                    com.google.android.exoplayer2.E0 e0 = this.f;
                    return new InterfaceC15981kV7.b(zF, e0.f() - e0.D0(), ry1 instanceof RY1.a, z);
                }
                boolean z2 = ry1 instanceof RY1.a;
                if (z2) {
                    fA = 1.0f;
                } else if (ry1 instanceof RY1.b) {
                    fA = ((RY1.b) ry1).a();
                } else {
                    if (!(ry1 instanceof RY1.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    fA = 0.0f;
                }
                return new InterfaceC15981kV7.a(fA, this.h, z2, z);
            }

            public final Object n(C17857ng5 c17857ng5, boolean z, RY1 ry1, C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                C0337b c0337b = new C0337b(this.f, this.g, this.h, interfaceC20295rm1);
                c0337b.c = c17857ng5;
                c0337b.d = z;
                c0337b.e = ry1;
                return c0337b.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC18160oB2
            public /* bridge */ /* synthetic */ Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return n((C17857ng5) obj, ((Boolean) obj2).booleanValue(), (RY1) obj3, (C19938rB7) obj4, (InterfaceC20295rm1) obj5);
            }
        }

        /* synthetic */ class c extends C23553x7 implements InterfaceC14603iB2 {
            c(Object obj) {
                super(2, obj, InterfaceC16756lo6.class, "trySend", "trySend-JP2dKIU(Ljava/lang/Object;)Ljava/lang/Object;", 12);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC15981kV7 interfaceC15981kV7, InterfaceC20295rm1 interfaceC20295rm1) {
                return b.y((InterfaceC16756lo6) this.a, interfaceC15981kV7, interfaceC20295rm1);
            }
        }

        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ EG2 d;
            final /* synthetic */ String e;
            final /* synthetic */ FileReference f;

            public static final class a implements Cache.a {
                final /* synthetic */ InterfaceC16204ks5 a;
                final /* synthetic */ EG2 b;
                final /* synthetic */ String c;
                final /* synthetic */ FileReference d;

                a(InterfaceC16204ks5 interfaceC16204ks5, EG2 eg2, String str, FileReference fileReference) {
                    this.a = interfaceC16204ks5;
                    this.b = eg2;
                    this.c = str;
                    this.d = fileReference;
                }

                @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
                public void a(Cache cache, AbstractC18533op0 abstractC18533op0, AbstractC18533op0 abstractC18533op02) {
                    AbstractC13042fc3.i(cache, "cache");
                    AbstractC13042fc3.i(abstractC18533op0, "oldSpan");
                    AbstractC13042fc3.i(abstractC18533op02, "newSpan");
                }

                @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
                public void b(Cache cache, AbstractC18533op0 abstractC18533op0) {
                    AbstractC13042fc3.i(cache, "cache");
                    AbstractC13042fc3.i(abstractC18533op0, "span");
                    this.a.h(this.b.j(cache, this.c, this.d));
                }

                @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
                public void c(Cache cache, AbstractC18533op0 abstractC18533op0) {
                    AbstractC13042fc3.i(cache, "cache");
                    AbstractC13042fc3.i(abstractC18533op0, "span");
                    this.a.h(this.b.j(cache, this.c, this.d));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(EG2 eg2, String str, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = eg2;
                this.e = str;
                this.f = fileReference;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(EG2 eg2, String str, a aVar) {
                eg2.a.n(str, aVar);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = new d(this.d, this.e, this.f, interfaceC20295rm1);
                dVar.c = obj;
                return dVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[RETURN] */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r8.b
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L29
                    if (r1 == r4) goto L21
                    if (r1 == r3) goto L1d
                    if (r1 != r2) goto L15
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L85
                L15:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L1d:
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L5a
                L21:
                    java.lang.Object r1 = r8.c
                    ir.nasim.ks5 r1 = (ir.nasim.InterfaceC16204ks5) r1
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L4e
                L29:
                    ir.nasim.AbstractC10685c16.b(r9)
                    java.lang.Object r9 = r8.c
                    r1 = r9
                    ir.nasim.ks5 r1 = (ir.nasim.InterfaceC16204ks5) r1
                    ir.nasim.EG2 r9 = r8.d
                    com.google.android.exoplayer2.upstream.cache.Cache r5 = ir.nasim.EG2.a(r9)
                    java.lang.String r6 = r8.e
                    ir.nasim.core.modules.file.entity.FileReference r7 = r8.f
                    ir.nasim.RY1 r9 = ir.nasim.EG2.e(r9, r5, r6, r7)
                    boolean r5 = r9 instanceof ir.nasim.RY1.a
                    if (r5 == 0) goto L5d
                    r8.c = r1
                    r8.b = r4
                    java.lang.Object r9 = r1.o(r9, r8)
                    if (r9 != r0) goto L4e
                    return r0
                L4e:
                    r9 = 0
                    r8.c = r9
                    r8.b = r3
                    java.lang.Object r9 = ir.nasim.AbstractC13822gs5.b(r1, r9, r8, r4, r9)
                    if (r9 != r0) goto L5a
                    return r0
                L5a:
                    ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                    return r9
                L5d:
                    ir.nasim.EG2$b$d$a r9 = new ir.nasim.EG2$b$d$a
                    ir.nasim.EG2 r3 = r8.d
                    java.lang.String r4 = r8.e
                    ir.nasim.core.modules.file.entity.FileReference r5 = r8.f
                    r9.<init>(r1, r3, r4, r5)
                    ir.nasim.EG2 r3 = r8.d
                    com.google.android.exoplayer2.upstream.cache.Cache r3 = ir.nasim.EG2.a(r3)
                    java.lang.String r4 = r8.e
                    r3.l(r4, r9)
                    ir.nasim.EG2 r3 = r8.d
                    java.lang.String r4 = r8.e
                    ir.nasim.FG2 r5 = new ir.nasim.FG2
                    r5.<init>()
                    r8.b = r2
                    java.lang.Object r9 = ir.nasim.AbstractC13822gs5.a(r1, r5, r8)
                    if (r9 != r0) goto L85
                    return r0
                L85:
                    ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EG2.b.d.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            int c;
            private /* synthetic */ Object d;
            final /* synthetic */ InterfaceC10258bL6 e;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;

                a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(interfaceC20295rm1);
                    aVar.c = obj;
                    return aVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C17857ng5 c17857ng5 = (C17857ng5) this.c;
                    return AbstractC6392Nk0.a(!AbstractC13042fc3.d(c17857ng5.e(), C12372eV7.e) && c17857ng5.c() && c17857ng5.g());
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(C17857ng5 c17857ng5, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(c17857ng5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = interfaceC10258bL6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                e eVar = new e(this.e, interfaceC20295rm1);
                eVar.d = obj;
                return eVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:34:0x00a0 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00af A[RETURN] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r1v6 */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r9.c
                    r2 = 0
                    r3 = 4
                    r4 = 3
                    r5 = 2
                    r6 = 1
                    if (r1 == 0) goto L3d
                    if (r1 == r6) goto L33
                    if (r1 == r5) goto L2b
                    if (r1 == r4) goto L22
                    if (r1 != r3) goto L1a
                    ir.nasim.AbstractC10685c16.b(r10)
                    goto Lb0
                L1a:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L22:
                    java.lang.Object r1 = r9.d
                    ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                    ir.nasim.AbstractC10685c16.b(r10)
                    goto La1
                L2b:
                    java.lang.Object r1 = r9.d
                    ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                    ir.nasim.AbstractC10685c16.b(r10)
                    goto L94
                L33:
                    int r1 = r9.b
                    java.lang.Object r7 = r9.d
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r10)
                    goto L7a
                L3d:
                    ir.nasim.AbstractC10685c16.b(r10)
                    java.lang.Object r10 = r9.d
                    r7 = r10
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.bL6 r10 = r9.e
                    java.lang.Object r10 = r10.getValue()
                    ir.nasim.ng5 r10 = (ir.nasim.C17857ng5) r10
                    ir.nasim.eV7 r1 = r10.e()
                    ir.nasim.eV7 r8 = ir.nasim.C12372eV7.e
                    boolean r1 = ir.nasim.AbstractC13042fc3.d(r1, r8)
                    if (r1 != 0) goto L67
                    boolean r1 = r10.c()
                    if (r1 == 0) goto L67
                    boolean r10 = r10.g()
                    if (r10 == 0) goto L67
                    r1 = r6
                    goto L69
                L67:
                    r10 = 0
                    r1 = r10
                L69:
                    java.lang.Boolean r10 = ir.nasim.AbstractC6392Nk0.a(r1)
                    r9.d = r7
                    r9.b = r1
                    r9.c = r6
                    java.lang.Object r10 = r7.a(r10, r9)
                    if (r10 != r0) goto L7a
                    return r0
                L7a:
                    if (r1 == 0) goto L7f
                    ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                    return r10
                L7f:
                    ir.nasim.bL6 r10 = r9.e
                    ir.nasim.Fq2 r10 = (ir.nasim.InterfaceC4557Fq2) r10
                    ir.nasim.EG2$b$e$a r1 = new ir.nasim.EG2$b$e$a
                    r1.<init>(r2)
                    r9.d = r7
                    r9.c = r5
                    java.lang.Object r10 = ir.nasim.AbstractC6459Nq2.H(r10, r1, r9)
                    if (r10 != r0) goto L93
                    return r0
                L93:
                    r1 = r7
                L94:
                    r9.d = r1
                    r9.c = r4
                    r4 = 200(0xc8, double:9.9E-322)
                    java.lang.Object r10 = ir.nasim.HG1.b(r4, r9)
                    if (r10 != r0) goto La1
                    return r0
                La1:
                    java.lang.Boolean r10 = ir.nasim.AbstractC6392Nk0.a(r6)
                    r9.d = r2
                    r9.c = r3
                    java.lang.Object r10 = r1.a(r10, r9)
                    if (r10 != r0) goto Lb0
                    return r0
                Lb0:
                    ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EG2.b.e.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((e) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ EG2 d;
            final /* synthetic */ com.google.android.exoplayer2.E0 e;
            final /* synthetic */ FileReference f;

            public static final class a implements z0.d {
                final /* synthetic */ C12889fL5 a;
                final /* synthetic */ InterfaceC16204ks5 b;
                final /* synthetic */ FileReference c;

                a(C12889fL5 c12889fL5, InterfaceC16204ks5 interfaceC16204ks5, FileReference fileReference) {
                    this.a = c12889fL5;
                    this.b = interfaceC16204ks5;
                    this.c = fileReference;
                }

                @Override // com.google.android.exoplayer2.z0.d
                public void E0(int i) {
                    C12889fL5 c12889fL5 = this.a;
                    C17857ng5 c17857ng5B = C17857ng5.b((C17857ng5) c12889fL5.a, false, false, false, null, i, 15, null);
                    this.b.h(c17857ng5B);
                    c12889fL5.a = c17857ng5B;
                }

                @Override // com.google.android.exoplayer2.z0.d
                public void f3(float f) {
                    C12889fL5 c12889fL5 = this.a;
                    C17857ng5 c17857ng5B = C17857ng5.b((C17857ng5) c12889fL5.a, f <= 0.0f, false, false, null, 0, 30, null);
                    this.b.h(c17857ng5B);
                    c12889fL5.a = c17857ng5B;
                }

                @Override // com.google.android.exoplayer2.z0.d
                public void l(C12372eV7 c12372eV7) {
                    AbstractC13042fc3.i(c12372eV7, "videoSize");
                    C12889fL5 c12889fL5 = this.a;
                    C17857ng5 c17857ng5B = C17857ng5.b((C17857ng5) c12889fL5.a, false, false, false, c12372eV7, 0, 23, null);
                    this.b.h(c17857ng5B);
                    c12889fL5.a = c17857ng5B;
                }

                @Override // com.google.android.exoplayer2.z0.d
                public void q2(PlaybackException playbackException) {
                    C19406qI3.c("GetVideoPlayerStateUseCase", "Error on " + this.c.getFileId() + ":", playbackException);
                }

                @Override // com.google.android.exoplayer2.z0.d
                public void r5(boolean z) {
                    C12889fL5 c12889fL5 = this.a;
                    C17857ng5 c17857ng5B = C17857ng5.b((C17857ng5) c12889fL5.a, false, z, false, null, 0, 29, null);
                    this.b.h(c17857ng5B);
                    c12889fL5.a = c17857ng5B;
                }

                @Override // com.google.android.exoplayer2.z0.d
                public void s() {
                    C12889fL5 c12889fL5 = this.a;
                    C17857ng5 c17857ng5B = C17857ng5.b((C17857ng5) c12889fL5.a, false, false, true, null, 0, 27, null);
                    this.b.h(c17857ng5B);
                    c12889fL5.a = c17857ng5B;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(EG2 eg2, com.google.android.exoplayer2.E0 e0, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = eg2;
                this.e = e0;
                this.f = fileReference;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(com.google.android.exoplayer2.E0 e0, a aVar) {
                e0.o(aVar);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                f fVar = new f(this.d, this.e, this.f, interfaceC20295rm1);
                fVar.c = obj;
                return fVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                    C12889fL5 c12889fL5 = new C12889fL5();
                    C17857ng5 c17857ng5I = this.d.i(this.e);
                    interfaceC16204ks5.h(c17857ng5I);
                    c12889fL5.a = c17857ng5I;
                    final a aVar = new a(c12889fL5, interfaceC16204ks5, this.f);
                    this.e.m0(aVar);
                    final com.google.android.exoplayer2.E0 e0 = this.e;
                    SA2 sa2 = new SA2() { // from class: ir.nasim.GG2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return EG2.b.f.y(e0, aVar);
                        }
                    };
                    this.b = 1;
                    if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((f) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            g(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                g gVar = new g(interfaceC20295rm1);
                gVar.c = obj;
                return gVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C19406qI3.a("GetVideoPlayerStateUseCase", "playerState: " + ((C17857ng5) this.c), new Object[0]);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17857ng5 c17857ng5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((g) create(c17857ng5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            h(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                h hVar = new h(interfaceC20295rm1);
                hVar.c = obj;
                return hVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C17857ng5 c17857ng5 = (C17857ng5) this.c;
                return AbstractC6392Nk0.a(c17857ng5.d() == 3 && c17857ng5.g());
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17857ng5 c17857ng5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((h) create(c17857ng5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class i extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ boolean d;
            final /* synthetic */ EG2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            i(EG2 eg2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.e = eg2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i != 0) {
                    if (i == 1) {
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                if (this.d) {
                    InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.r(AbstractC3851Cp7.f(1000L, 0L, this.e.c, null, 8, null));
                    this.b = 2;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2R, this) == objE) {
                        return objE;
                    }
                    return C19938rB7.a;
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                this.b = 1;
                if (interfaceC4806Gq2.a(c19938rB7, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            public final Object n(InterfaceC4806Gq2 interfaceC4806Gq2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                i iVar = new i(this.e, interfaceC20295rm1);
                iVar.c = interfaceC4806Gq2;
                iVar.d = z;
                return iVar.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return n((InterfaceC4806Gq2) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(FileReference fileReference, EG2 eg2, com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
            this.e = eg2;
            this.f = e0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object y(InterfaceC16756lo6 interfaceC16756lo6, InterfaceC15981kV7 interfaceC15981kV7, InterfaceC20295rm1 interfaceC20295rm1) {
            interfaceC16756lo6.h(interfaceC15981kV7);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i2 = this.b;
            if (i2 == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                String strA = this.e.f.a(this.d.getFileId(), this.d.getAccessHash());
                InterfaceC4557Fq2 interfaceC4557Fq2B0 = AbstractC6459Nq2.b0(AbstractC6459Nq2.V(AbstractC6459Nq2.f(new f(this.e, this.f, this.d, null)), this.e.d), new g(null));
                InterfaceC16863lz6.a aVar = InterfaceC16863lz6.a;
                InterfaceC10258bL6 interfaceC10258bL6O0 = AbstractC6459Nq2.o0(interfaceC4557Fq2B0, interfaceC16204ks5, aVar.c(), this.e.i(this.f));
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.R(new e(interfaceC10258bL6O0, null));
                InterfaceC10258bL6 interfaceC10258bL6 = interfaceC10258bL6O0;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.s0(AbstractC6459Nq2.V(AbstractC6459Nq2.X(interfaceC10258bL6, new h(null)), this.e.e), new i(this.e, null)), this.e.c);
                InterfaceC10258bL6 interfaceC10258bL6O02 = AbstractC6459Nq2.o0(AbstractC6459Nq2.V(AbstractC6459Nq2.f(new d(this.e, strA, this.d, null)), this.e.c), interfaceC16204ks5, aVar.c(), new RY1.c(null, 1, null));
                AbstractC10533bm0.d(interfaceC16204ks5, this.e.c, null, new a(interfaceC10258bL6O02, this.e, this.d, null), 2, null);
                InterfaceC4557Fq2 interfaceC4557Fq2B02 = AbstractC6459Nq2.b0(AbstractC6459Nq2.V(AbstractC6459Nq2.n(interfaceC10258bL6, interfaceC4557Fq2R, interfaceC10258bL6O02, interfaceC4557Fq2V, new C0337b(this.f, this.e, this.d.getFileSize() / 1024.0f, null)), this.e.d), new c(interfaceC16204ks5.j()));
                this.b = 1;
                if (AbstractC6459Nq2.k(interfaceC4557Fq2B02, this) == objE) {
                    return objE;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public EG2(Cache cache, InterfaceC12532em2 interfaceC12532em2, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, AbstractC13778go1 abstractC13778go13, IT7 it7) {
        AbstractC13042fc3.i(cache, "cache");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(abstractC13778go13, "defaultDispatcher");
        AbstractC13042fc3.i(it7, "cacheIdGenerator");
        this.a = cache;
        this.b = interfaceC12532em2;
        this.c = abstractC13778go1;
        this.d = abstractC13778go12;
        this.e = abstractC13778go13;
        this.f = it7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17857ng5 i(com.google.android.exoplayer2.E0 e0) {
        boolean z = e0.f0() <= 0.0f;
        boolean zI = e0.i();
        C12372eV7 c12372eV7E0 = e0.e0();
        AbstractC13042fc3.h(c12372eV7E0, "getVideoSize(...)");
        return new C17857ng5(z, zI, e0.D0() > 0, c12372eV7E0, e0.p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RY1 j(Cache cache, String str, FileReference fileReference) {
        float fC = cache.c(str, 0L, -1L);
        return fC < ((float) fileReference.getFileSize()) * 0.98f ? new RY1.b(fC / fileReference.getFileSize()) : new RY1.a(new C9115Yo(""));
    }

    public final InterfaceC4557Fq2 k(com.google.android.exoplayer2.E0 e0, FileReference fileReference) {
        AbstractC13042fc3.i(e0, "player");
        AbstractC13042fc3.i(fileReference, "fileReference");
        return AbstractC6459Nq2.j(new b(fileReference, this, e0, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EG2(Context context) {
        this(DD6.c(), ((InterfaceC19086pl2) C92.a(context, InterfaceC19086pl2.class)).Q(), C12366eV1.b(), C12366eV1.c(), C12366eV1.a(), new IT7());
        AbstractC13042fc3.i(context, "context");
    }
}
