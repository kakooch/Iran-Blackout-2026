package ir.nasim;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* renamed from: ir.nasim.Uq, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC8124Uq extends ZE2 {
    private static boolean b = false;

    public AbstractC8124Uq() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (b) {
            b = true;
            AbstractC21317tS4.a();
        }
    }

    public String c() {
        return UUID.randomUUID().toString();
    }
}
