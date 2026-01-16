package ir.nasim;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public abstract class Eu8 {
    private static final AtomicReference a = new AtomicReference(null);

    public static void a(InterfaceC16818lu8 interfaceC16818lu8) {
        AtomicReference atomicReference = a;
        while (!AbstractC16775lq5.a(atomicReference, null, interfaceC16818lu8) && atomicReference.get() == null) {
        }
    }
}
