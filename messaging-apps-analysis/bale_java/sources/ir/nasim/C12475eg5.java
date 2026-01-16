package ir.nasim;

import android.gov.nist.core.Separators;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.z0;
import ir.nasim.C12475eg5;

/* renamed from: ir.nasim.eg5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12475eg5 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final InterfaceC2037k a;
    private final C11863dg5 b;
    private final InterfaceC4557Fq2 c;

    /* renamed from: ir.nasim.eg5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.eg5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.eg5$b$a */
        public static final class a implements z0.d {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ InterfaceC16204ks5 b;
            final /* synthetic */ C12475eg5 c;

            /* renamed from: ir.nasim.eg5$b$a$a, reason: collision with other inner class name */
            static final class C1058a extends AbstractC22163um1 {
                Object a;
                /* synthetic */ Object b;
                int d;

                C1058a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.b = obj;
                    this.d |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(this);
                }
            }

            a(C12889fL5 c12889fL5, InterfaceC16204ks5 interfaceC16204ks5, C12475eg5 c12475eg5) {
                this.a = c12889fL5;
                this.b = interfaceC16204ks5;
                this.c = c12475eg5;
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void D4(C2018a0 c2018a0, int i) {
                super.D4(c2018a0, i);
                C12889fL5 c12889fL5 = this.a;
                C11863dg5 c11863dg5 = (C11863dg5) c12889fL5.a;
                c12889fL5.a = c11863dg5.a((63 & 1) != 0 ? c11863dg5.a : false, (63 & 2) != 0 ? c11863dg5.b : false, (63 & 4) != 0 ? c11863dg5.c : 0, (63 & 8) != 0 ? c11863dg5.d : null, (63 & 16) != 0 ? c11863dg5.e : 0.0f, (63 & 32) != 0 ? c11863dg5.f : 0L, (63 & 64) != 0 ? c11863dg5.g : false);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void E0(int i) {
                Log.w("playerConfiguration", "onPlaybackStateChanged: " + i);
                super.E0(i);
                C12889fL5 c12889fL5 = this.a;
                C11863dg5 c11863dg5 = (C11863dg5) c12889fL5.a;
                c12889fL5.a = c11863dg5.a((63 & 1) != 0 ? c11863dg5.a : false, (63 & 2) != 0 ? c11863dg5.b : false, (63 & 4) != 0 ? c11863dg5.c : i, (63 & 8) != 0 ? c11863dg5.d : null, (63 & 16) != 0 ? c11863dg5.e : 0.0f, (63 & 32) != 0 ? c11863dg5.f : 0L, (63 & 64) != 0 ? c11863dg5.g : false);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void S4(boolean z, int i) {
                Log.w("playerConfiguration", "onPlayWhenReadyChanged: " + z);
                super.S4(z, i);
                C12889fL5 c12889fL5 = this.a;
                C11863dg5 c11863dg5 = (C11863dg5) c12889fL5.a;
                c12889fL5.a = c11863dg5.a((63 & 1) != 0 ? c11863dg5.a : false, (63 & 2) != 0 ? c11863dg5.b : !z, (63 & 4) != 0 ? c11863dg5.c : 0, (63 & 8) != 0 ? c11863dg5.d : null, (63 & 16) != 0 ? c11863dg5.e : 0.0f, (63 & 32) != 0 ? c11863dg5.f : 0L, (63 & 64) != 0 ? c11863dg5.g : false);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void Z2(PlaybackException playbackException) {
                AbstractC13042fc3.i(playbackException, "error");
                super.Z2(playbackException);
                Log.w("playerConfiguration", "onPlayerError: " + playbackException.getMessage());
                C12889fL5 c12889fL5 = this.a;
                C11863dg5 c11863dg5 = (C11863dg5) c12889fL5.a;
                c12889fL5.a = c11863dg5.a((63 & 1) != 0 ? c11863dg5.a : false, (63 & 2) != 0 ? c11863dg5.b : false, (63 & 4) != 0 ? c11863dg5.c : 0, (63 & 8) != 0 ? c11863dg5.d : playbackException, (63 & 16) != 0 ? c11863dg5.e : 0.0f, (63 & 32) != 0 ? c11863dg5.f : 0L, (63 & 64) != 0 ? c11863dg5.g : false);
                this.b.h(this.a.a);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0051 -> B:20:0x0054). Please report as a decompilation issue!!! */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.InterfaceC20295rm1 r20) {
                /*
                    r19 = this;
                    r0 = r20
                    boolean r1 = r0 instanceof ir.nasim.C12475eg5.b.a.C1058a
                    if (r1 == 0) goto L17
                    r1 = r0
                    ir.nasim.eg5$b$a$a r1 = (ir.nasim.C12475eg5.b.a.C1058a) r1
                    int r2 = r1.d
                    r3 = -2147483648(0xffffffff80000000, float:-0.0)
                    r4 = r2 & r3
                    if (r4 == 0) goto L17
                    int r2 = r2 - r3
                    r1.d = r2
                    r2 = r19
                    goto L1e
                L17:
                    ir.nasim.eg5$b$a$a r1 = new ir.nasim.eg5$b$a$a
                    r2 = r19
                    r1.<init>(r0)
                L1e:
                    java.lang.Object r0 = r1.b
                    java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
                    int r4 = r1.d
                    r5 = 1
                    if (r4 == 0) goto L3b
                    if (r4 != r5) goto L33
                    java.lang.Object r4 = r1.a
                    ir.nasim.eg5$b$a r4 = (ir.nasim.C12475eg5.b.a) r4
                    ir.nasim.AbstractC10685c16.b(r0)
                    goto L54
                L33:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L3b:
                    ir.nasim.AbstractC10685c16.b(r0)
                    r4 = r2
                L3f:
                    ir.nasim.ks5 r0 = r4.b
                    boolean r0 = ir.nasim.AbstractC20906so1.g(r0)
                    if (r0 == 0) goto L80
                    r1.a = r4
                    r1.d = r5
                    r6 = 100
                    java.lang.Object r0 = ir.nasim.HG1.b(r6, r1)
                    if (r0 != r3) goto L54
                    return r3
                L54:
                    ir.nasim.eg5 r0 = r4.c
                    ir.nasim.fL5 r6 = r4.a
                    java.lang.Object r7 = r6.a
                    r8 = r7
                    ir.nasim.dg5 r8 = (ir.nasim.C11863dg5) r8
                    com.google.android.exoplayer2.k r0 = ir.nasim.C12475eg5.b(r0)
                    long r14 = r0.D0()
                    r17 = 95
                    r18 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    r12 = 0
                    r13 = 0
                    r16 = 0
                    ir.nasim.dg5 r0 = ir.nasim.C11863dg5.b(r8, r9, r10, r11, r12, r13, r14, r16, r17, r18)
                    r6.a = r0
                    ir.nasim.ks5 r0 = r4.b
                    ir.nasim.fL5 r6 = r4.a
                    java.lang.Object r6 = r6.a
                    r0.h(r6)
                    goto L3f
                L80:
                    ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12475eg5.b.a.a(ir.nasim.rm1):java.lang.Object");
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void f3(float f) {
                super.f3(f);
                C12889fL5 c12889fL5 = this.a;
                C11863dg5 c11863dg5 = (C11863dg5) c12889fL5.a;
                c12889fL5.a = c11863dg5.a((63 & 1) != 0 ? c11863dg5.a : false, (63 & 2) != 0 ? c11863dg5.b : false, (63 & 4) != 0 ? c11863dg5.c : 0, (63 & 8) != 0 ? c11863dg5.d : null, (63 & 16) != 0 ? c11863dg5.e : f, (63 & 32) != 0 ? c11863dg5.f : 0L, (63 & 64) != 0 ? c11863dg5.g : false);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void r5(boolean z) {
                Log.w("playerConfiguration", "onIsPlayingChanged: " + z + Separators.SP);
                super.r5(z);
                C12889fL5 c12889fL5 = this.a;
                C11863dg5 c11863dg5 = (C11863dg5) c12889fL5.a;
                c12889fL5.a = c11863dg5.a((63 & 1) != 0 ? c11863dg5.a : z, (63 & 2) != 0 ? c11863dg5.b : false, (63 & 4) != 0 ? c11863dg5.c : 0, (63 & 8) != 0 ? c11863dg5.d : null, (63 & 16) != 0 ? c11863dg5.e : 0.0f, (63 & 32) != 0 ? c11863dg5.f : 0L, (63 & 64) != 0 ? c11863dg5.g : false);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void s() {
                Log.w("playerConfiguration", "onRenderedFirstFrame: ");
                super.s();
                C12889fL5 c12889fL5 = this.a;
                C11863dg5 c11863dg5 = (C11863dg5) c12889fL5.a;
                c12889fL5.a = c11863dg5.a((63 & 1) != 0 ? c11863dg5.a : false, (63 & 2) != 0 ? c11863dg5.b : false, (63 & 4) != 0 ? c11863dg5.c : 0, (63 & 8) != 0 ? c11863dg5.d : null, (63 & 16) != 0 ? c11863dg5.e : 0.0f, (63 & 32) != 0 ? c11863dg5.f : 0L, (63 & 64) != 0 ? c11863dg5.g : true);
                this.b.h(this.a.a);
            }
        }

        /* renamed from: ir.nasim.eg5$b$b, reason: collision with other inner class name */
        static final class C1059b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ a c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1059b(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1059b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    a aVar = this.c;
                    this.b = 1;
                    if (aVar.a(this) == objE) {
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
                return ((C1059b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C12475eg5 c12475eg5, a aVar) {
            c12475eg5.a.o(aVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C12475eg5.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                C11863dg5 c11863dg5A = C12475eg5.this.b;
                if (c11863dg5A == null) {
                    c11863dg5A = AbstractC13702gg5.a(C24480yh2.a.c());
                }
                C12889fL5 c12889fL5 = new C12889fL5();
                c12889fL5.a = c11863dg5A;
                final a aVar = new a(c12889fL5, interfaceC16204ks5, C12475eg5.this);
                final C12475eg5 c12475eg5 = C12475eg5.this;
                c12475eg5.a.m0(aVar);
                AbstractC10533bm0.d(interfaceC16204ks5, null, null, new C1059b(aVar, null), 3, null);
                SA2 sa2 = new SA2() { // from class: ir.nasim.fg5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12475eg5.b.y(c12475eg5, aVar);
                    }
                };
                this.c = aVar;
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
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12475eg5(InterfaceC2037k interfaceC2037k, C11863dg5 c11863dg5) {
        AbstractC13042fc3.i(interfaceC2037k, "player");
        this.a = interfaceC2037k;
        this.b = c11863dg5;
        this.c = c();
    }

    private final InterfaceC4557Fq2 c() {
        return AbstractC6459Nq2.f(new b(null));
    }

    public final InterfaceC4557Fq2 d() {
        return this.c;
    }

    public /* synthetic */ C12475eg5(InterfaceC2037k interfaceC2037k, C11863dg5 c11863dg5, int i, ED1 ed1) {
        this(interfaceC2037k, (i & 2) != 0 ? null : c11863dg5);
    }
}
