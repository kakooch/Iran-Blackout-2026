package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: ir.nasim.nN3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C17678nN3 extends ArrayList {
    private C17678nN3() {
    }

    public static C17678nN3 r(Collection collection) {
        return new C17678nN3(collection);
    }

    public C17678nN3 f(InterfaceC17569nB2 interfaceC17569nB2) {
        C17678nN3 c17678nN3 = new C17678nN3();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            c17678nN3.add(interfaceC17569nB2.apply(it.next()));
        }
        return c17678nN3;
    }

    private C17678nN3(Collection collection) {
        super(collection);
    }
}
