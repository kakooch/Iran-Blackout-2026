package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.dz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12067dz1 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.dz1$a */
    public static final class a {

        /* renamed from: ir.nasim.dz1$a$a, reason: collision with other inner class name */
        static final class C1042a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ List d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1042a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = list;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1042a c1042a = new C1042a(this.d, interfaceC20295rm1);
                c1042a.c = obj;
                return c1042a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    F73 f73 = (F73) this.c;
                    a aVar = AbstractC12067dz1.a;
                    List list = this.d;
                    this.b = 1;
                    if (aVar.c(list, f73, this) == objE) {
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
            public final Object invoke(F73 f73, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1042a) create(f73, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.dz1$a$b */
        static final class b extends AbstractC22163um1 {
            Object a;
            Object b;
            /* synthetic */ Object c;
            int e;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.c = obj;
                this.e |= RecyclerView.UNDEFINED_DURATION;
                return a.this.c(null, null, this);
            }
        }

        /* renamed from: ir.nasim.dz1$a$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            int e;
            /* synthetic */ Object f;
            final /* synthetic */ List g;
            final /* synthetic */ List h;

            /* renamed from: ir.nasim.dz1$a$c$a, reason: collision with other inner class name */
            static final class C1043a extends AbstractC19859r37 implements UA2 {
                int b;

                C1043a(InterfaceC11424cz1 interfaceC11424cz1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(1, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1043a(null, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        this.b = 1;
                        throw null;
                    }
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.UA2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1043a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.g = list;
                this.h = list2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.g, this.h, interfaceC20295rm1);
                cVar.f = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                List list;
                Iterator it;
                AbstractC14862ic3.e();
                int i = this.e;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    obj = this.f;
                    List list2 = this.g;
                    list = this.h;
                    it = list2.iterator();
                } else if (i == 1) {
                    Object obj2 = this.d;
                    AbstractC18350oW3.a(this.c);
                    Iterator it2 = (Iterator) this.b;
                    List list3 = (List) this.f;
                    AbstractC10685c16.b(obj);
                    if (((Boolean) obj).booleanValue()) {
                        list3.add(new C1043a(null, null));
                        this.f = list3;
                        this.b = it2;
                        this.c = null;
                        this.d = null;
                        this.e = 2;
                        throw null;
                    }
                    obj = obj2;
                    it = it2;
                    list = list3;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.b;
                    list = (List) this.f;
                    AbstractC10685c16.b(obj);
                }
                if (!it.hasNext()) {
                    return obj;
                }
                AbstractC18350oW3.a(it.next());
                this.f = list;
                this.b = it;
                this.c = null;
                this.d = obj;
                this.e = 1;
                throw null;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(obj, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0088 -> B:25:0x006b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008b -> B:25:0x006b). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object c(java.util.List r7, ir.nasim.F73 r8, ir.nasim.InterfaceC20295rm1 r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof ir.nasim.AbstractC12067dz1.a.b
                if (r0 == 0) goto L13
                r0 = r9
                ir.nasim.dz1$a$b r0 = (ir.nasim.AbstractC12067dz1.a.b) r0
                int r1 = r0.e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.e = r1
                goto L18
            L13:
                ir.nasim.dz1$a$b r0 = new ir.nasim.dz1$a$b
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.c
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r7 = r0.b
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.a
                ir.nasim.fL5 r8 = (ir.nasim.C12889fL5) r8
                ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.lang.Throwable -> L34
                goto L6b
            L34:
                r9 = move-exception
                goto L84
            L36:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3e:
                java.lang.Object r7 = r0.a
                java.util.List r7 = (java.util.List) r7
                ir.nasim.AbstractC10685c16.b(r9)
                goto L60
            L46:
                ir.nasim.AbstractC10685c16.b(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                ir.nasim.dz1$a$c r2 = new ir.nasim.dz1$a$c
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.a = r9
                r0.e = r4
                java.lang.Object r7 = r8.a(r2, r0)
                if (r7 != r1) goto L5f
                return r1
            L5f:
                r7 = r9
            L60:
                ir.nasim.fL5 r8 = new ir.nasim.fL5
                r8.<init>()
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.Iterator r7 = r7.iterator()
            L6b:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L96
                java.lang.Object r9 = r7.next()
                ir.nasim.UA2 r9 = (ir.nasim.UA2) r9
                r0.a = r8     // Catch: java.lang.Throwable -> L34
                r0.b = r7     // Catch: java.lang.Throwable -> L34
                r0.e = r3     // Catch: java.lang.Throwable -> L34
                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                if (r9 != r1) goto L6b
                return r1
            L84:
                java.lang.Object r2 = r8.a
                if (r2 != 0) goto L8b
                r8.a = r9
                goto L6b
            L8b:
                ir.nasim.AbstractC13042fc3.f(r2)
                java.lang.Object r2 = r8.a
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                ir.nasim.AbstractC16041kc2.a(r2, r9)
                goto L6b
            L96:
                java.lang.Object r7 = r8.a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L9f
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            L9f:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC12067dz1.a.c(java.util.List, ir.nasim.F73, ir.nasim.rm1):java.lang.Object");
        }

        public final InterfaceC14603iB2 b(List list) {
            AbstractC13042fc3.i(list, "migrations");
            return new C1042a(list, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }
}
