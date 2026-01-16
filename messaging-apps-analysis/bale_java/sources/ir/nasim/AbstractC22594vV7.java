package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import io.livekit.android.renderer.TextureViewRenderer;
import io.livekit.android.room.Room;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC22594vV7;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.vV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22594vV7 {

    /* renamed from: ir.nasim.vV7$a */
    public static final class a extends AbstractC22594vV7 {
        private final Room a;
        private final EV7 b;
        private final Context c;
        private final InterfaceC20315ro1 d;
        private TextureViewRenderer e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Room room, EV7 ev7, Context context, InterfaceC20315ro1 interfaceC20315ro1) {
            super(null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(ev7, "videoTrack");
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
            this.a = room;
            this.b = ev7;
            this.c = context;
            this.d = interfaceC20315ro1;
        }

        public TextureViewRenderer a() {
            if (this.e == null) {
                this.e = new TextureViewRenderer(this.c);
            }
            TextureViewRenderer textureViewRenderer = this.e;
            AbstractC13042fc3.g(textureViewRenderer, "null cannot be cast to non-null type io.livekit.android.renderer.TextureViewRenderer");
            return textureViewRenderer;
        }
    }

    /* renamed from: ir.nasim.vV7$b */
    public static final class b extends AbstractC22594vV7 {
        private final Room a;
        private final EV7 b;
        private final AbstractC21649tt7.g c;
        private final InterfaceC20315ro1 d;
        private final boolean e;
        private final InterfaceC9336Zm4 f;

        /* renamed from: ir.nasim.vV7$b$a */
        static final class a implements InterfaceC14603iB2 {
            a() {
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    b bVar = b.this;
                    bVar.d(bVar.a, b.this.b, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.vV7$b$b, reason: collision with other inner class name */
        static final class C1667b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9336Zm4 c;
            final /* synthetic */ b d;

            /* renamed from: ir.nasim.vV7$b$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, interfaceC20295rm1);
                    aVar.c = ((Boolean) obj).booleanValue();
                    return aVar;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object value;
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    boolean z = this.c;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.f;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        ((Boolean) value).booleanValue();
                    } while (!interfaceC9336Zm4.f(value, AbstractC6392Nk0.a(z)));
                    return C19938rB7.a;
                }

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1667b(InterfaceC9336Zm4 interfaceC9336Zm4, b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9336Zm4;
                this.d = bVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1667b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
                    a aVar = new a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC9336Zm4, aVar, this) == objE) {
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
                return ((C1667b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Room room, EV7 ev7, AbstractC21649tt7.g gVar, InterfaceC20315ro1 interfaceC20315ro1, boolean z) {
            super(null);
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(ev7, "videoTrack");
            AbstractC13042fc3.i(gVar, "trackSource");
            AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
            this.a = room;
            this.b = ev7;
            this.c = gVar;
            this.d = interfaceC20315ro1;
            this.e = z;
            this.f = AbstractC12281eL6.a(Boolean.FALSE);
        }

        private static final boolean e(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        private static final androidx.compose.ui.e f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (androidx.compose.ui.e) interfaceC9102Ym4.getValue();
        }

        private static final EnumC19000pc6 g(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (EnumC19000pc6) interfaceC9102Ym4.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(InterfaceC9664aL6 interfaceC9664aL6, androidx.compose.ui.graphics.c cVar) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$isMirrorState$delegate");
            AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
            cVar.k(e(interfaceC9664aL6) ? 180.0f : 0.0f);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(InterfaceC9664aL6 interfaceC9664aL6, androidx.compose.ui.graphics.c cVar) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$isMirrorState$delegate");
            AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
            cVar.k(e(interfaceC9664aL6) ? 180.0f : 0.0f);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 j(b bVar, Room room, EV7 ev7, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(bVar, "$tmp4_rcvr");
            AbstractC13042fc3.i(room, "$room");
            AbstractC13042fc3.i(ev7, "$videoTrack");
            bVar.d(room, ev7, interfaceC22053ub1, QJ5.a(i | 1));
            return C19938rB7.a;
        }

        public final void d(final Room room, final EV7 ev7, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
            int i2;
            AbstractC13042fc3.i(room, "room");
            AbstractC13042fc3.i(ev7, "videoTrack");
            InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1297546684);
            if ((i & 6) == 0) {
                i2 = (interfaceC22053ub1J.D(room) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= interfaceC22053ub1J.D(ev7) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= interfaceC22053ub1J.D(this) ? 256 : 128;
            }
            if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
                interfaceC22053ub1J.L();
            } else {
                final InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.f, null, interfaceC22053ub1J, 0, 1);
                interfaceC22053ub1J.W(-1613233470);
                Object objB = interfaceC22053ub1J.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    androidx.compose.ui.e eVarE = (this.e || this.c == AbstractC21649tt7.g.d) ? androidx.compose.foundation.layout.t.E(androidx.compose.ui.e.a, null, false, 3, null) : androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
                    objB = AbstractC13472gH6.d(eVarE, null, 2, null);
                    interfaceC22053ub1J.s(objB);
                }
                InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(-1613216564);
                Object objB2 = interfaceC22053ub1J.B();
                if (objB2 == aVar.a()) {
                    EnumC19000pc6 enumC19000pc6 = (this.e || this.c == AbstractC21649tt7.g.d) ? EnumC19000pc6.a : EnumC19000pc6.b;
                    objB2 = AbstractC13472gH6.d(enumC19000pc6, null, 2, null);
                    interfaceC22053ub1J.s(objB2);
                }
                InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB2;
                interfaceC22053ub1J.Q();
                if (C8386Vt0.a.N8()) {
                    interfaceC22053ub1J.W(1530403493);
                    e.a aVar2 = androidx.compose.ui.e.a;
                    interfaceC22053ub1J.W(-1613194353);
                    boolean zV = interfaceC22053ub1J.V(interfaceC9664aL6B);
                    Object objB3 = interfaceC22053ub1J.B();
                    if (zV || objB3 == aVar.a()) {
                        objB3 = new UA2() { // from class: ir.nasim.wV7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC22594vV7.b.h(interfaceC9664aL6B, (androidx.compose.ui.graphics.c) obj);
                            }
                        };
                        interfaceC22053ub1J.s(objB3);
                    }
                    interfaceC22053ub1J.Q();
                    AbstractC4406Ez4.i(room, ev7, androidx.compose.ui.graphics.b.a(aVar2, (UA2) objB3).i(f(interfaceC9102Ym4)), false, g(interfaceC9102Ym42), interfaceC22053ub1J, (i2 & 14) | (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER), 8);
                    interfaceC22053ub1J.Q();
                } else {
                    interfaceC22053ub1J.W(1530902376);
                    e.a aVar3 = androidx.compose.ui.e.a;
                    interfaceC22053ub1J.W(-1613178353);
                    boolean zV2 = interfaceC22053ub1J.V(interfaceC9664aL6B);
                    Object objB4 = interfaceC22053ub1J.B();
                    if (zV2 || objB4 == aVar.a()) {
                        objB4 = new UA2() { // from class: ir.nasim.xV7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC22594vV7.b.i(interfaceC9664aL6B, (androidx.compose.ui.graphics.c) obj);
                            }
                        };
                        interfaceC22053ub1J.s(objB4);
                    }
                    interfaceC22053ub1J.Q();
                    UU7.i(room, ev7, androidx.compose.ui.graphics.b.a(aVar3, (UA2) objB4).i(f(interfaceC9102Ym4)), false, g(interfaceC9102Ym42), interfaceC22053ub1J, (i2 & 14) | (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER), 8);
                    interfaceC22053ub1J.Q();
                }
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.yV7
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC22594vV7.b.j(this.a, room, ev7, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }

        public InterfaceC14603iB2 n() {
            return AbstractC19242q11.c(-468009972, true, new a());
        }

        public final void o(InterfaceC9336Zm4 interfaceC9336Zm4) {
            AbstractC13042fc3.i(interfaceC9336Zm4, "mirrorFlow");
            AbstractC10533bm0.d(this.d, null, null, new C1667b(interfaceC9336Zm4, this, null), 3, null);
        }
    }

    private AbstractC22594vV7() {
    }

    public /* synthetic */ AbstractC22594vV7(ED1 ed1) {
        this();
    }
}
