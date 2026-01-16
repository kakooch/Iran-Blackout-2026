package ir.nasim;

/* renamed from: ir.nasim.p32, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18672p32 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(char c, char c2) {
        return Character.isHighSurrogate(c) && Character.isLowSurrogate(c2);
    }
}
