package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.cW3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC10970cW3 {

    /* renamed from: ir.nasim.cW3$a */
    public static final class a {
        public static int a(InterfaceC10970cW3 interfaceC10970cW3, InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return InterfaceC10970cW3.super.i(interfaceC10436bc3, list, i);
        }

        public static int b(InterfaceC10970cW3 interfaceC10970cW3, InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return InterfaceC10970cW3.super.d(interfaceC10436bc3, list, i);
        }

        public static int c(InterfaceC10970cW3 interfaceC10970cW3, InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return InterfaceC10970cW3.super.a(interfaceC10436bc3, list, i);
        }

        public static int d(InterfaceC10970cW3 interfaceC10970cW3, InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return InterfaceC10970cW3.super.h(interfaceC10436bc3, list, i);
        }
    }

    default int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new C15231jE1((InterfaceC9236Zb3) list.get(i2), EnumC11026cc3.a, EnumC12433ec3.b));
        }
        return b(new C15451jc3(interfaceC10436bc3, interfaceC10436bc3.getLayoutDirection()), arrayList, AbstractC19606qe1.b(0, i, 0, 0, 13, null)).getHeight();
    }

    InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j);

    default int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new C15231jE1((InterfaceC9236Zb3) list.get(i2), EnumC11026cc3.b, EnumC12433ec3.a));
        }
        return b(new C15451jc3(interfaceC10436bc3, interfaceC10436bc3.getLayoutDirection()), arrayList, AbstractC19606qe1.b(0, 0, 0, i, 7, null)).getWidth();
    }

    default int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new C15231jE1((InterfaceC9236Zb3) list.get(i2), EnumC11026cc3.a, EnumC12433ec3.a));
        }
        return b(new C15451jc3(interfaceC10436bc3, interfaceC10436bc3.getLayoutDirection()), arrayList, AbstractC19606qe1.b(0, 0, 0, i, 7, null)).getWidth();
    }

    default int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new C15231jE1((InterfaceC9236Zb3) list.get(i2), EnumC11026cc3.b, EnumC12433ec3.b));
        }
        return b(new C15451jc3(interfaceC10436bc3, interfaceC10436bc3.getLayoutDirection()), arrayList, AbstractC19606qe1.b(0, i, 0, 0, 13, null)).getHeight();
    }
}
