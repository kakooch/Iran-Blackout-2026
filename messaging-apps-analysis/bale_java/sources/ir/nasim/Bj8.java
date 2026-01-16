package ir.nasim;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes3.dex */
final class Bj8 implements Comparator {
    final /* synthetic */ Vh8 a;
    final /* synthetic */ C20322ro8 b;

    Bj8(Vh8 vh8, C20322ro8 c20322ro8) {
        this.a = vh8;
        this.b = c20322ro8;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        InterfaceC22720vi8 interfaceC22720vi8 = (InterfaceC22720vi8) obj;
        InterfaceC22720vi8 interfaceC22720vi82 = (InterfaceC22720vi8) obj2;
        Vh8 vh8 = this.a;
        C20322ro8 c20322ro8 = this.b;
        if (interfaceC22720vi8 instanceof Ii8) {
            return !(interfaceC22720vi82 instanceof Ii8) ? 1 : 0;
        }
        if (interfaceC22720vi82 instanceof Ii8) {
            return -1;
        }
        return vh8 == null ? interfaceC22720vi8.j().compareTo(interfaceC22720vi82.j()) : (int) AbstractC9951ap8.a(vh8.a(c20322ro8, Arrays.asList(interfaceC22720vi8, interfaceC22720vi82)).k().doubleValue());
    }
}
