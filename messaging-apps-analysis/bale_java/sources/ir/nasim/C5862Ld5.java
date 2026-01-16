package ir.nasim;

import ai.bale.proto.MessagingStruct$MessageContainer;
import ir.nasim.database.pinMessages.PinMessageEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ld5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5862Ld5 implements InterfaceC5628Kd5 {
    private final E84 a;

    public C5862Ld5(E84 e84) {
        AbstractC13042fc3.i(e84, "messagesModule");
        this.a = e84;
    }

    private final List c(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((PinMessageEntity) obj).getRid() != -1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC5628Kd5
    public Object a(C11458d25 c11458d25, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        List listC = c(list);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add((J44) this.a.H0(c11458d25).a(((PinMessageEntity) it.next()).getRid()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC5628Kd5
    public Object b(long j, int i, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        List<MessagingStruct$MessageContainer> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (MessagingStruct$MessageContainer messagingStruct$MessageContainer : list2) {
            arrayList.add(new PinMessageEntity(j, i, messagingStruct$MessageContainer.getRid(), messagingStruct$MessageContainer.getDate(), 0L, 16, null));
        }
        return arrayList;
    }
}
