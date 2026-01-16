package ir.nasim;

import ir.nasim.InterfaceC21989uU1;
import java.io.File;

/* loaded from: classes2.dex */
public abstract class BU1 implements InterfaceC21989uU1.a {
    private final long a;
    private final a b;

    public interface a {
        File a();
    }

    public BU1(a aVar, long j) {
        this.a = j;
        this.b = aVar;
    }

    @Override // ir.nasim.InterfaceC21989uU1.a
    public InterfaceC21989uU1 a() {
        File fileA = this.b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return CU1.c(fileA, this.a);
        }
        return null;
    }
}
