package ir.nasim;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.lr3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16783lr3 {
    private static final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public static InterfaceC16192kr3 a(String str) throws GeneralSecurityException {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            InterfaceC16192kr3 interfaceC16192kr3 = (InterfaceC16192kr3) it.next();
            if (interfaceC16192kr3.a(str)) {
                return interfaceC16192kr3;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
