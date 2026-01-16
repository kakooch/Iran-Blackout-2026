package ir.nasim;

/* renamed from: ir.nasim.hp8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC14388hp8 extends Zn8 implements Cloneable {
    private static volatile AbstractC14388hp8[] b;

    public static AbstractC14388hp8[] i() {
        if (b == null) {
            synchronized (AbstractC9941ao8.c) {
                try {
                    if (b == null) {
                        b = new AbstractC14388hp8[0];
                    }
                } finally {
                }
            }
        }
        return b;
    }
}
