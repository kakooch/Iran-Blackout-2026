package ir.nasim;

/* renamed from: ir.nasim.sm2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC20887sm2 {
    static /* synthetic */ InterfaceC23940xm2 a(InterfaceC20887sm2 interfaceC20887sm2, long j, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openFileForWriting");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return interfaceC20887sm2.c(j, str, z);
    }

    String b(String str, EnumC9082Yk2 enumC9082Yk2, NN6 nn6);

    InterfaceC23940xm2 c(long j, String str, boolean z);
}
