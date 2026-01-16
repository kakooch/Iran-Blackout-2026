package ir.nasim;

import java.util.List;

/* loaded from: classes.dex */
public interface EN6 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final EN6 b = new C0340a();

        /* renamed from: ir.nasim.EN6$a$a, reason: collision with other inner class name */
        public static final class C0340a implements EN6 {
            C0340a() {
            }

            @Override // ir.nasim.EN6
            public AbstractC18977pa3 a(int i, int i2, AbstractC18977pa3 abstractC18977pa3) {
                int i3;
                if (i2 - i < 0 || (i3 = abstractC18977pa3.b) == 0) {
                    return AbstractC19568qa3.a();
                }
                C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, i3);
                int iO = c24411ya3Y.o();
                int iT = c24411ya3Y.t();
                int iE = -1;
                if (iO <= iT) {
                    while (abstractC18977pa3.e(iO) <= i) {
                        iE = abstractC18977pa3.e(iO);
                        if (iO == iT) {
                            break;
                        }
                        iO++;
                    }
                }
                return iE == -1 ? AbstractC19568qa3.a() : AbstractC19568qa3.b(iE);
            }

            @Override // ir.nasim.EN6
            public int b(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
                Object obj;
                int size = list.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size) {
                        obj = null;
                        break;
                    }
                    obj = list.get(i8);
                    if (((InterfaceC24630yw3) obj).getIndex() != i) {
                        break;
                    }
                    i8++;
                }
                InterfaceC24630yw3 interfaceC24630yw3 = (InterfaceC24630yw3) obj;
                int iC = interfaceC24630yw3 != null ? AbstractC6763Ow3.c(interfaceC24630yw3) : Integer.MIN_VALUE;
                int iMax = i3 == Integer.MIN_VALUE ? -i4 : Math.max(-i4, i3);
                return iC != Integer.MIN_VALUE ? Math.min(iMax, iC - i2) : iMax;
            }
        }

        private a() {
        }

        public final EN6 a() {
            return b;
        }
    }

    AbstractC18977pa3 a(int i, int i2, AbstractC18977pa3 abstractC18977pa3);

    int b(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7);
}
