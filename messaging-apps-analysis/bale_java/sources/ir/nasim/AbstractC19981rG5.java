package ir.nasim;

import java.util.Random;

/* renamed from: ir.nasim.rG5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19981rG5 {
    private static final Random a = new Random();

    public static synchronized long a() {
        return a.nextLong();
    }

    public static synchronized int b(int i) {
        return a.nextInt(i);
    }
}
