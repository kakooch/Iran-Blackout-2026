package ir.nasim;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: ir.nasim.wG3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23051wG3 {

    /* renamed from: ir.nasim.wG3$a */
    public interface a {
        void a(AbstractC22455vG3 abstractC22455vG3);

        AbstractC22455vG3 b(int i, Bundle bundle);

        void c(AbstractC22455vG3 abstractC22455vG3, Object obj);
    }

    public static AbstractC23051wG3 b(InterfaceC18633oz3 interfaceC18633oz3) {
        return new C23641xG3(interfaceC18633oz3, ((InterfaceC15408jX7) interfaceC18633oz3).d1());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract AbstractC22455vG3 c(int i, Bundle bundle, a aVar);

    public abstract void d();
}
