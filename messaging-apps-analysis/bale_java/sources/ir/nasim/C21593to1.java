package ir.nasim;

import ir.nasim.AbstractC24126y52;
import ir.nasim.InterfaceC19699qn4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import livekit.org.webrtc.SdpObserver;
import livekit.org.webrtc.SessionDescription;

/* renamed from: ir.nasim.to1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C21593to1 implements SdpObserver {
    private AbstractC24126y52 b;
    private AbstractC24126y52 d;
    private final InterfaceC19699qn4 a = AbstractC20899sn4.b(false, 1, null);
    private List c = new ArrayList();
    private List e = new ArrayList();

    /* renamed from: ir.nasim.to1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ HE0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(HE0 he0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = he0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21593to1.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19699qn4 interfaceC19699qn4 = C21593to1.this.a;
                this.b = 1;
                if (InterfaceC19699qn4.a.a(interfaceC19699qn4, null, this, 1, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC24126y52 abstractC24126y52 = C21593to1.this.b;
            if (abstractC24126y52 != null) {
                InterfaceC19699qn4.a.c(C21593to1.this.a, null, 1, null);
                this.d.resumeWith(C9475a16.b(abstractC24126y52));
            } else {
                C21593to1.this.c.add(this.d);
                InterfaceC19699qn4.a.c(C21593to1.this.a, null, 1, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.to1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC20295rm1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC20295rm1 interfaceC20295rm12) {
            super(2, interfaceC20295rm12);
            this.d = interfaceC20295rm1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21593to1.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19699qn4 interfaceC19699qn4 = C21593to1.this.a;
                this.b = 1;
                if (InterfaceC19699qn4.a.a(interfaceC19699qn4, null, this, 1, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC24126y52 abstractC24126y52 = C21593to1.this.d;
            if (abstractC24126y52 != null) {
                InterfaceC19699qn4.a.c(C21593to1.this.a, null, 1, null);
                this.d.resumeWith(C9475a16.b(abstractC24126y52));
            } else {
                C21593to1.this.e.add(this.d);
                InterfaceC19699qn4.a.c(C21593to1.this.a, null, 1, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.to1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ AbstractC24126y52 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC24126y52 abstractC24126y52, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = abstractC24126y52;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21593to1.this.new c(this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C21593to1 c21593to1;
            InterfaceC19699qn4 interfaceC19699qn4;
            AbstractC24126y52 abstractC24126y52;
            List listM1;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19699qn4 interfaceC19699qn42 = C21593to1.this.a;
                c21593to1 = C21593to1.this;
                AbstractC24126y52 abstractC24126y522 = this.g;
                this.b = interfaceC19699qn42;
                this.c = c21593to1;
                this.d = abstractC24126y522;
                this.e = 1;
                if (interfaceC19699qn42.a(null, this) == objE) {
                    return objE;
                }
                interfaceC19699qn4 = interfaceC19699qn42;
                abstractC24126y52 = abstractC24126y522;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                abstractC24126y52 = (AbstractC24126y52) this.d;
                c21593to1 = (C21593to1) this.c;
                interfaceC19699qn4 = (InterfaceC19699qn4) this.b;
                AbstractC10685c16.b(obj);
            }
            try {
                c21593to1.b = abstractC24126y52;
                if (abstractC24126y52 != null) {
                    listM1 = AbstractC15401jX0.m1(c21593to1.c);
                    c21593to1.c.clear();
                } else {
                    listM1 = null;
                }
                return listM1;
            } finally {
                interfaceC19699qn4.e(null);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.to1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ AbstractC24126y52 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC24126y52 abstractC24126y52, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = abstractC24126y52;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21593to1.this.new d(this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C21593to1 c21593to1;
            InterfaceC19699qn4 interfaceC19699qn4;
            AbstractC24126y52 abstractC24126y52;
            List listM1;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19699qn4 interfaceC19699qn42 = C21593to1.this.a;
                c21593to1 = C21593to1.this;
                AbstractC24126y52 abstractC24126y522 = this.g;
                this.b = interfaceC19699qn42;
                this.c = c21593to1;
                this.d = abstractC24126y522;
                this.e = 1;
                if (interfaceC19699qn42.a(null, this) == objE) {
                    return objE;
                }
                interfaceC19699qn4 = interfaceC19699qn42;
                abstractC24126y52 = abstractC24126y522;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                abstractC24126y52 = (AbstractC24126y52) this.d;
                c21593to1 = (C21593to1) this.c;
                interfaceC19699qn4 = (InterfaceC19699qn4) this.b;
                AbstractC10685c16.b(obj);
            }
            try {
                c21593to1.d = abstractC24126y52;
                if (abstractC24126y52 != null) {
                    listM1 = AbstractC15401jX0.m1(c21593to1.e);
                    c21593to1.e.clear();
                } else {
                    listM1 = null;
                }
                return listM1;
            } finally {
                interfaceC19699qn4.e(null);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final void j(AbstractC24126y52 abstractC24126y52) {
        List list = (List) AbstractC9913am0.b(null, new c(abstractC24126y52, null), 1, null);
        if (abstractC24126y52 == null || list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((InterfaceC20295rm1) it.next()).resumeWith(C9475a16.b(abstractC24126y52));
        }
    }

    private final void k(AbstractC24126y52 abstractC24126y52) {
        List list = (List) AbstractC9913am0.b(null, new d(abstractC24126y52, null), 1, null);
        if (abstractC24126y52 == null || list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((InterfaceC20295rm1) it.next()).resumeWith(C9475a16.b(abstractC24126y52));
        }
    }

    public final Object h(InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        AbstractC24126y52 abstractC24126y52 = this.b;
        if (abstractC24126y52 != null) {
            ie0.resumeWith(C9475a16.b(abstractC24126y52));
        } else {
            AbstractC9913am0.b(null, new a(ie0, null), 1, null);
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    public final Object i(InterfaceC20295rm1 interfaceC20295rm1) {
        C16963m96 c16963m96 = new C16963m96(AbstractC14251hc3.c(interfaceC20295rm1));
        AbstractC24126y52 abstractC24126y52 = this.d;
        if (abstractC24126y52 != null) {
            c16963m96.resumeWith(C9475a16.b(abstractC24126y52));
        } else {
            AbstractC9913am0.b(null, new b(c16963m96, null), 1, null);
        }
        Object objA = c16963m96.a();
        if (objA == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objA;
    }

    @Override // livekit.org.webrtc.SdpObserver
    public void onCreateFailure(String str) {
        j(new AbstractC24126y52.b(str));
    }

    @Override // livekit.org.webrtc.SdpObserver
    public void onCreateSuccess(SessionDescription sessionDescription) {
        j(sessionDescription == null ? new AbstractC24126y52.b("empty sdp") : new AbstractC24126y52.a(sessionDescription));
    }

    @Override // livekit.org.webrtc.SdpObserver
    public void onSetFailure(String str) {
        k(new AbstractC24126y52.b(str));
    }

    @Override // livekit.org.webrtc.SdpObserver
    public void onSetSuccess() {
        k(new AbstractC24126y52.a(C19938rB7.a));
    }
}
