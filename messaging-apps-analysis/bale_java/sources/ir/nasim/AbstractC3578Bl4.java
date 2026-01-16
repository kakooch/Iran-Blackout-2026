package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Bl4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3578Bl4 {

    /* renamed from: ir.nasim.Bl4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(C10971cW4 c10971cW4) {
            return '[' + c10971cW4.f() + ", " + c10971cW4.b() + ')';
        }
    }

    public static final int a(List list, int i) {
        int i2;
        int iB = ((C10971cW4) AbstractC15401jX0.C0(list)).b();
        boolean z = false;
        if (!(i <= ((C10971cW4) AbstractC15401jX0.C0(list)).b())) {
            N73.a("Index " + i + " should be less or equal than last line's end " + iB);
        }
        int size = list.size() - 1;
        int i3 = 0;
        while (true) {
            if (i3 > size) {
                i2 = -(i3 + 1);
                break;
            }
            i2 = (i3 + size) >>> 1;
            C10971cW4 c10971cW4 = (C10971cW4) list.get(i2);
            char c = c10971cW4.f() > i ? (char) 1 : c10971cW4.b() <= i ? (char) 65535 : (char) 0;
            if (c >= 0) {
                if (c <= 0) {
                    break;
                }
                size = i2 - 1;
            } else {
                i3 = i2 + 1;
            }
        }
        if (i2 >= 0 && i2 < list.size()) {
            z = true;
        }
        if (!z) {
            N73.a("Found paragraph index " + i2 + " should be in range [0, " + list.size() + ").\nDebug info: index=" + i + ", paragraphs=[" + AbstractC12806fC3.e(list, null, null, null, 0, null, a.e, 31, null) + ']');
        }
        return i2;
    }

    public static final int b(List list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            C10971cW4 c10971cW4 = (C10971cW4) list.get(i3);
            char c = c10971cW4.g() > i ? (char) 1 : c10971cW4.c() <= i ? (char) 65535 : (char) 0;
            if (c < 0) {
                i2 = i3 + 1;
            } else {
                if (c <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int c(List list, float f) {
        if (f <= 0.0f) {
            return 0;
        }
        if (f >= ((C10971cW4) AbstractC15401jX0.C0(list)).a()) {
            return AbstractC10360bX0.o(list);
        }
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            C10971cW4 c10971cW4 = (C10971cW4) list.get(i2);
            char c = c10971cW4.h() > f ? (char) 1 : c10971cW4.a() <= f ? (char) 65535 : (char) 0;
            if (c < 0) {
                i = i2 + 1;
            } else {
                if (c <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static final void d(List list, long j, UA2 ua2) {
        int size = list.size();
        for (int iA = a(list, C4301En7.l(j)); iA < size; iA++) {
            C10971cW4 c10971cW4 = (C10971cW4) list.get(iA);
            if (c10971cW4.f() >= C4301En7.k(j)) {
                return;
            }
            if (c10971cW4.f() != c10971cW4.b()) {
                ua2.invoke(c10971cW4);
            }
        }
    }
}
