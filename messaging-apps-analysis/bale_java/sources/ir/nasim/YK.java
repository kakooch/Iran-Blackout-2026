package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class YK {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object c(InterfaceC3516Be5 interfaceC3516Be5, int i) {
        if (i >= 0 && i < interfaceC3516Be5.f()) {
            int iB = i - interfaceC3516Be5.b();
            if (iB < 0 || iB >= interfaceC3516Be5.a()) {
                return null;
            }
            return interfaceC3516Be5.getItem(iB);
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + interfaceC3516Be5.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C11066cg3 d(InterfaceC3516Be5 interfaceC3516Be5) {
        int iA = interfaceC3516Be5.a() - 1;
        ArrayList arrayList = new ArrayList();
        if (iA >= 0) {
            int i = 0;
            while (true) {
                arrayList.add(interfaceC3516Be5.getItem(i));
                if (i == iA) {
                    break;
                }
                i++;
            }
        }
        return new C11066cg3(interfaceC3516Be5.b(), interfaceC3516Be5.c(), arrayList);
    }
}
