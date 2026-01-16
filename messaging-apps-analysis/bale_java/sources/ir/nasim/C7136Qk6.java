package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Qk6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C7136Qk6 {
    private static final QI6 d = QI6.d(':');
    private static final QI6 e = QI6.d('*');
    private final List a = new ArrayList();
    private int b = 0;
    private int c;

    /* renamed from: ir.nasim.Qk6$a */
    private static final class a {
        public final int a;
        public final long b;
        public final int c;

        public a(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    private void a(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        EW4 ew4 = new EW4(8);
        interfaceC9845af2.readFully(ew4.e(), 0, 8);
        this.c = ew4.s() + 8;
        if (ew4.o() != 1397048916) {
            c8292Vi5.a = 0L;
        } else {
            c8292Vi5.a = interfaceC9845af2.getPosition() - (this.c - 12);
            this.b = 2;
        }
    }

    private static int b(String str) throws ParserException {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw ParserException.a("Invalid SEF name", null);
        }
    }

    private void d(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        long length = interfaceC9845af2.getLength();
        int i = this.c - 20;
        EW4 ew4 = new EW4(i);
        interfaceC9845af2.readFully(ew4.e(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            ew4.T(2);
            short sU = ew4.u();
            if (sU == 2192 || sU == 2816 || sU == 2817 || sU == 2819 || sU == 2820) {
                this.a.add(new a(sU, (length - this.c) - ew4.s(), ew4.s()));
            } else {
                ew4.T(8);
            }
        }
        if (this.a.isEmpty()) {
            c8292Vi5.a = 0L;
        } else {
            this.b = 3;
            c8292Vi5.a = ((a) this.a.get(0)).b;
        }
    }

    private void e(InterfaceC9845af2 interfaceC9845af2, List list) throws ParserException {
        long position = interfaceC9845af2.getPosition();
        int length = (int) ((interfaceC9845af2.getLength() - interfaceC9845af2.getPosition()) - this.c);
        EW4 ew4 = new EW4(length);
        interfaceC9845af2.readFully(ew4.e(), 0, length);
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = (a) this.a.get(i);
            ew4.S((int) (aVar.b - position));
            ew4.T(4);
            int iS = ew4.s();
            int iB = b(ew4.C(iS));
            int i2 = aVar.c - (iS + 8);
            if (iB == 2192) {
                list.add(f(ew4, i2));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private static SlowMotionData f(EW4 ew4, int i) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List listF = e.f(ew4.C(i));
        for (int i2 = 0; i2 < listF.size(); i2++) {
            List listF2 = d.f((CharSequence) listF.get(i2));
            if (listF2.size() != 3) {
                throw ParserException.a(null, null);
            }
            try {
                arrayList.add(new SlowMotionData.Segment(Long.parseLong((String) listF2.get(0)), Long.parseLong((String) listF2.get(1)), 1 << (Integer.parseInt((String) listF2.get(2)) - 1)));
            } catch (NumberFormatException e2) {
                throw ParserException.a(null, e2);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public int c(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5, List list) throws ParserException {
        int i = this.b;
        long j = 0;
        if (i == 0) {
            long length = interfaceC9845af2.getLength();
            if (length != -1 && length >= 8) {
                j = length - 8;
            }
            c8292Vi5.a = j;
            this.b = 1;
        } else if (i == 1) {
            a(interfaceC9845af2, c8292Vi5);
        } else if (i == 2) {
            d(interfaceC9845af2, c8292Vi5);
        } else {
            if (i != 3) {
                throw new IllegalStateException();
            }
            e(interfaceC9845af2, list);
            c8292Vi5.a = 0L;
        }
        return 1;
    }

    public void g() {
        this.a.clear();
        this.b = 0;
    }
}
