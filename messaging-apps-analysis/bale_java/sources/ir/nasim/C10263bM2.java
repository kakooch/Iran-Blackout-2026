package ir.nasim;

import ai.bale.proto.MeetStruct$GroupCall;
import ir.nasim.AbstractC17643nJ4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.bM2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10263bM2 {
    public static final C10263bM2 a = new C10263bM2();
    private static final InterfaceC9336Zm4 b;
    private static final InterfaceC10258bL6 c;
    private static int d;
    public static final int e;

    static {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        b = interfaceC9336Zm4A;
        c = interfaceC9336Zm4A;
        e = 8;
    }

    private C10263bM2() {
    }

    public final void a(List list) {
        Object value;
        AbstractC13042fc3.i(list, "onGoingCalls");
        InterfaceC9336Zm4 interfaceC9336Zm4 = b;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, list));
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof AbstractC17643nJ4.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((AbstractC17643nJ4.b) obj2).f() == AbstractC5969Lp4.f()) {
                arrayList2.add(obj2);
            }
        }
        d = arrayList2.size();
    }

    public final InterfaceC10258bL6 b() {
        return c;
    }

    public final int c() {
        return d;
    }

    public final void d(E84 e84, MeetStruct$GroupCall meetStruct$GroupCall, InterfaceC14603iB2 interfaceC14603iB2) {
        boolean z;
        Object value;
        ArrayList arrayList;
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(meetStruct$GroupCall, "protoCall");
        AbstractC13042fc3.i(interfaceC14603iB2, "callExistCallBack");
        Iterable iterable = (Iterable) b.getValue();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            z = false;
        } else {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((AbstractC17643nJ4) it.next()).a() == meetStruct$GroupCall.getId()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        boolean z2 = ((C17448mz0) C18039nz0.a.d().getValue()).c() == meetStruct$GroupCall.getId();
        C19406qI3.a("GroupCallStateHolder", "groupCallEnded " + meetStruct$GroupCall.getId() + " and isGroupCallRunning " + z2, new Object[0]);
        if (z) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = b;
            do {
                value = interfaceC9336Zm4.getValue();
                arrayList = new ArrayList();
                for (Object obj : (List) value) {
                    if (((AbstractC17643nJ4) obj).a() != meetStruct$GroupCall.getId()) {
                        arrayList.add(obj);
                    }
                }
            } while (!interfaceC9336Zm4.f(value, arrayList));
        }
        e84.Q1(new C11458d25(W25.b, meetStruct$GroupCall.getPeer().getId()));
        interfaceC14603iB2.invoke(Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public final void e(E84 e84, MeetStruct$GroupCall meetStruct$GroupCall, InterfaceC14603iB2 interfaceC14603iB2) {
        boolean z;
        Object value;
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(meetStruct$GroupCall, "protoCall");
        AbstractC13042fc3.i(interfaceC14603iB2, "callExistCallBack");
        Iterable iterable = (Iterable) b.getValue();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            z = false;
        } else {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((AbstractC17643nJ4) it.next()).a() == meetStruct$GroupCall.getId()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        boolean z2 = ((C17448mz0) C18039nz0.a.d().getValue()).c() != -1;
        C19406qI3.a("GroupCallStateHolder", "call started " + meetStruct$GroupCall.getId() + " and isCallRunning " + z2, new Object[0]);
        if (!z) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = b;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.R0(AbstractC9766aX0.e(new AbstractC17643nJ4.a(meetStruct$GroupCall.getId(), meetStruct$GroupCall.getPeer().getId(), meetStruct$GroupCall.getInitiatorUserId(), meetStruct$GroupCall.getCreateDate().getValue())), (List) value)));
            e84.R1(new C11458d25(W25.b, meetStruct$GroupCall.getPeer().getId()));
        }
        interfaceC14603iB2.invoke(Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public final void f(long j) {
        Object next;
        Object value;
        ArrayList arrayList;
        Iterator it = ((Iterable) b.getValue()).iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (((AbstractC17643nJ4) next).a() == j) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        AbstractC17643nJ4 abstractC17643nJ4 = (AbstractC17643nJ4) next;
        if (abstractC17643nJ4 != null) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = b;
            do {
                value = interfaceC9336Zm4.getValue();
                arrayList = new ArrayList();
                for (Object obj : (List) value) {
                    if (((AbstractC17643nJ4) obj).a() != j) {
                        arrayList.add(obj);
                    }
                }
            } while (!interfaceC9336Zm4.f(value, arrayList));
            if (abstractC17643nJ4 instanceof AbstractC17643nJ4.b) {
                d--;
            }
        }
    }

    public final void g(long j, List list) {
        Object value;
        AbstractC13042fc3.i(list, "memberIds");
        Iterable iterable = (Iterable) b.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((AbstractC17643nJ4) it.next()).a() == j) {
                    return;
                }
            }
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = b;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.R0(AbstractC9766aX0.e(new AbstractC17643nJ4.c(j, list)), (List) value)));
    }

    public final void h(long j, List list, int i, String str, String str2, Long l) {
        Object value;
        AbstractC13042fc3.i(list, "memberIds");
        AbstractC13042fc3.i(str2, "callLink");
        Iterable iterable = (Iterable) b.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((AbstractC17643nJ4) it.next()).a() == j) {
                    return;
                }
            }
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = b;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.R0(AbstractC9766aX0.e(new AbstractC17643nJ4.b(j, list, i, str2, str, l)), (List) value)));
        d++;
    }
}
