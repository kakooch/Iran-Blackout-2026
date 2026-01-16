package ir.nasim.live;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13822gs5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C23553x7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16204ks5;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.SA2;
import ir.nasim.live.LiveActivity;
import ir.nasim.live.LiveActivity$setupActionBroadCastReceiver$1;
import java.util.Iterator;

/* loaded from: classes6.dex */
final class LiveActivity$setupActionBroadCastReceiver$1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
    int b;
    final /* synthetic */ LiveActivity c;

    /* renamed from: ir.nasim.live.LiveActivity$setupActionBroadCastReceiver$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ LiveActivity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LiveActivity liveActivity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = liveActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(LiveActivity liveActivity, LiveActivity$setupActionBroadCastReceiver$1$1$broadcastReceiver$1 liveActivity$setupActionBroadCastReceiver$1$1$broadcastReceiver$1) {
            liveActivity.unregisterReceiver(liveActivity$setupActionBroadCastReceiver$1$1$broadcastReceiver$1);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.d, interfaceC20295rm1);
            anonymousClass1.c = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [android.content.BroadcastReceiver, ir.nasim.live.LiveActivity$setupActionBroadCastReceiver$1$1$broadcastReceiver$1] */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final ?? r1 = new BroadcastReceiver() { // from class: ir.nasim.live.LiveActivity$setupActionBroadCastReceiver$1$1$broadcastReceiver$1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        Object next;
                        if (intent == null) {
                            return;
                        }
                        Iterator<E> it = LiveActivity.a.j().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            } else {
                                next = it.next();
                                if (AbstractC13042fc3.d(intent.getAction(), ((LiveActivity.a) next).name())) {
                                    break;
                                }
                            }
                        }
                        LiveActivity.a aVar = (LiveActivity.a) next;
                        if (aVar == null) {
                            return;
                        }
                        interfaceC16204ks5.h(aVar);
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                Iterator<E> it = LiveActivity.a.j().iterator();
                while (it.hasNext()) {
                    intentFilter.addAction(((LiveActivity.a) it.next()).name());
                }
                this.d.registerReceiver(r1, intentFilter);
                final LiveActivity liveActivity = this.d;
                SA2 sa2 = new SA2() { // from class: ir.nasim.live.b
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return LiveActivity$setupActionBroadCastReceiver$1.AnonymousClass1.y(liveActivity, r1);
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
            return ((AnonymousClass1) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

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
            C19406qI3.a("LiveActivity", "Received action: " + ((LiveActivity.a) this.c), new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(LiveActivity.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* synthetic */ class b implements InterfaceC4806Gq2, InterfaceC22409vB2 {
        final /* synthetic */ LiveActivity a;

        b(LiveActivity liveActivity) {
            this.a = liveActivity;
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return new C23553x7(2, this.a, LiveActivity.class, "handleAction", "handleAction(Lir/nasim/live/LiveActivity$Action;)V", 4);
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final Object a(LiveActivity.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objY = LiveActivity$setupActionBroadCastReceiver$1.y(this.a, aVar, interfaceC20295rm1);
            return objY == AbstractC14862ic3.e() ? objY : C19938rB7.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof InterfaceC4806Gq2) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveActivity$setupActionBroadCastReceiver$1(LiveActivity liveActivity, InterfaceC20295rm1 interfaceC20295rm1) {
        super(2, interfaceC20295rm1);
        this.c = liveActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object y(LiveActivity liveActivity, LiveActivity.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        liveActivity.d2(aVar);
        return C19938rB7.a;
    }

    @Override // ir.nasim.E90
    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return new LiveActivity$setupActionBroadCastReceiver$1(this.c, interfaceC20295rm1);
    }

    @Override // ir.nasim.E90
    public final Object invokeSuspend(Object obj) {
        Object objE = AbstractC14862ic3.e();
        int i = this.b;
        if (i == 0) {
            AbstractC10685c16.b(obj);
            InterfaceC4557Fq2 interfaceC4557Fq2B0 = AbstractC6459Nq2.b0(AbstractC6459Nq2.f(new AnonymousClass1(this.c, null)), new a(null));
            b bVar = new b(this.c);
            this.b = 1;
            if (interfaceC4557Fq2B0.b(bVar, this) == objE) {
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
    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
        return ((LiveActivity$setupActionBroadCastReceiver$1) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
    }
}
