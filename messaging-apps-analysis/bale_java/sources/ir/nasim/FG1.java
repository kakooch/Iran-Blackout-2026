package ir.nasim;

/* loaded from: classes3.dex */
public abstract class FG1 {
    public static final /* synthetic */ Integer a(int i) {
        Integer numValueOf = Integer.valueOf(i);
        if (i != Integer.MIN_VALUE) {
            return numValueOf;
        }
        return null;
    }

    public static final /* synthetic */ int b(int i, boolean z) {
        return z ? -i : i;
    }
}
