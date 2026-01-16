package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.qq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC19733qq8 {
    public static InterfaceC16778lq8 a(InterfaceC16778lq8 interfaceC16778lq8) {
        return ((interfaceC16778lq8 instanceof C17960nq8) || (interfaceC16778lq8 instanceof C17369mq8)) ? interfaceC16778lq8 : interfaceC16778lq8 instanceof Serializable ? new C17369mq8(interfaceC16778lq8) : new C17960nq8(interfaceC16778lq8);
    }

    public static InterfaceC16778lq8 b(Object obj) {
        return new C18551oq8(obj);
    }
}
