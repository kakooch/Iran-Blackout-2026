package ir.nasim;

/* renamed from: ir.nasim.hc2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC14250hc2 {
    public static RuntimeException a(Throwable th) {
        throw AbstractC8226Vb2.d(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
