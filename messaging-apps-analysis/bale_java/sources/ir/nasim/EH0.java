package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14451hw1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes2.dex */
public final class EH0 extends IH0 {
    private final int h;
    private final int i;
    private final int j;
    private final long k;
    private List n;
    private List o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private byte t;
    private byte u;
    private boolean w;
    private long x;
    private static final int[] y = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER, 93, 237, WKSRecord.Service.SUR_MEAS, Type.TSIG, 97, 98, 99, 100, 101, 102, 103, 104, 105, Type.L64, 107, Type.EUI48, 109, 110, WKSRecord.Service.SUNRPC, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 113, 114, 115, 116, WKSRecord.Service.UUCP_PATH, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, 119, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, WKSRecord.Service.ERPC, 122, 231, SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER, 209, 241, 9632};
    private static final int[] C = {174, 176, SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER, 8482, SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER, 9834, 224, 32, 232, 226, SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER, SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER, SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER, Type.IXFR};
    private static final int[] D = {SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER, 201, 211, 218, SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER, 252, 8216, SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER, 42, 39, 8212, SetUpdatesStruct$ComposedUpdates.MESSAGE_QUOTED_CHANGED_FIELD_NUMBER, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER, SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER, 207, SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER, 212, 217, 249, 219, 171, SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER};
    private static final int[] E = {195, SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER, 223, 165, SetUpdatesStruct$ComposedUpdates.STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER, 9474, 197, SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private final EW4 g = new EW4();
    private final ArrayList l = new ArrayList();
    private a m = new a(0, 4);
    private int v = 0;

    private static final class a {
        private final List a = new ArrayList();
        private final List b = new ArrayList();
        private final StringBuilder c = new StringBuilder();
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;

        /* renamed from: ir.nasim.EH0$a$a, reason: collision with other inner class name */
        private static class C0338a {
            public final int a;
            public final boolean b;
            public int c;

            public C0338a(int i, boolean z, int i2) {
                this.a = i;
                this.b = z;
                this.c = i2;
            }
        }

        public a(int i, int i2) {
            j(i);
            this.h = i2;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 < this.a.size()) {
                C0338a c0338a = (C0338a) this.a.get(i5);
                boolean z2 = c0338a.b;
                int i7 = c0338a.a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i4 = EH0.A[i7];
                    }
                    z = z3;
                }
                int i8 = c0338a.c;
                i5++;
                if (i8 != (i5 < this.a.size() ? ((C0338a) this.a.get(i5)).c : length)) {
                    if (i != -1 && !z2) {
                        q(spannableStringBuilder, i, i8);
                        i = -1;
                    } else if (i == -1 && z2) {
                        i = i8;
                    }
                    if (i2 != -1 && !z) {
                        o(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z) {
                        i2 = i8;
                    }
                    if (i4 != i3) {
                        n(spannableStringBuilder, i6, i8, i3);
                        i3 = i4;
                        i6 = i8;
                    }
                }
            }
            if (i != -1 && i != length) {
                q(spannableStringBuilder, i, length);
            }
            if (i2 != -1 && i2 != length) {
                o(spannableStringBuilder, i2, length);
            }
            if (i6 != length) {
                n(spannableStringBuilder, i6, length, i3);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        public void e(char c) {
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }

        public void f() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    C0338a c0338a = (C0338a) this.a.get(size);
                    int i = c0338a.c;
                    if (i != length) {
                        return;
                    }
                    c0338a.c = i - 1;
                }
            }
        }

        public C14451hw1 g(int i) {
            float f;
            int i2 = this.e + this.f;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.b.size(); i4++) {
                spannableStringBuilder.append(AbstractC9683aN7.a1((CharSequence) this.b.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(AbstractC9683aN7.a1(h(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                i = (this.g != 2 || (Math.abs(i5) >= 3 && length >= 0)) ? (this.g != 2 || i5 <= 0) ? 0 : 2 : 1;
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i6 = this.d;
            if (i6 > 7) {
                i6 -= 17;
            } else if (this.g == 1) {
                i6 -= this.h - 1;
            }
            return new C14451hw1.b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i6, 1).k(f).l(i).a();
        }

        public boolean i() {
            return this.a.isEmpty() && this.b.isEmpty() && this.c.length() == 0;
        }

        public void j(int i) {
            this.g = i;
            this.a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }

        public void k() {
            this.b.add(h());
            this.c.setLength(0);
            this.a.clear();
            int iMin = Math.min(this.h, this.d);
            while (this.b.size() >= iMin) {
                this.b.remove(0);
            }
        }

        public void l(int i) {
            this.g = i;
        }

        public void m(int i) {
            this.h = i;
        }

        public void p(int i, boolean z) {
            this.a.add(new C0338a(i, z, this.c.length()));
        }
    }

    public EH0(String str, int i, long j) {
        this.k = j > 0 ? j * 1000 : -9223372036854775807L;
        this.h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.j = 0;
            this.i = 0;
        } else if (i == 2) {
            this.j = 1;
            this.i = 0;
        } else if (i == 3) {
            this.j = 0;
            this.i = 1;
        } else if (i != 4) {
            AbstractC18815pI3.k("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.j = 0;
            this.i = 0;
        } else {
            this.j = 1;
            this.i = 1;
        }
        M(0);
        L();
        this.w = true;
        this.x = -9223372036854775807L;
    }

    private static boolean A(byte b, byte b2) {
        return (b & 246) == 18 && (b2 & 224) == 32;
    }

    private static boolean B(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    private static boolean C(byte b, byte b2) {
        return (b & 246) == 20 && (b2 & 240) == 32;
    }

    private static boolean D(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    private static boolean E(byte b) {
        return (b & 240) == 16;
    }

    private boolean F(boolean z2, byte b, byte b2) {
        if (!z2 || !E(b)) {
            this.s = false;
        } else {
            if (this.s && this.t == b && this.u == b2) {
                this.s = false;
                return true;
            }
            this.s = true;
            this.t = b;
            this.u = b2;
        }
        return false;
    }

    private static boolean G(byte b) {
        return (b & 246) == 20;
    }

    private static boolean H(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 48;
    }

    private static boolean I(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    private static boolean J(byte b) {
        return 1 <= b && b <= 15;
    }

    private void K(byte b, byte b2) {
        if (J(b)) {
            this.w = false;
            return;
        }
        if (G(b)) {
            if (b2 != 32 && b2 != 47) {
                switch (b2) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b2) {
                            case 42:
                            case 43:
                                this.w = false;
                                break;
                        }
                }
            }
            this.w = true;
        }
    }

    private void L() {
        this.m.j(this.p);
        this.l.clear();
        this.l.add(this.m);
    }

    private void M(int i) {
        int i2 = this.p;
        if (i2 == i) {
            return;
        }
        this.p = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                ((a) this.l.get(i3)).l(i);
            }
            return;
        }
        L();
        if (i2 == 3 || i == 1 || i == 0) {
            this.n = Collections.emptyList();
        }
    }

    private void N(int i) {
        this.q = i;
        this.m.m(i);
    }

    private boolean O() {
        return (this.k == -9223372036854775807L || this.x == -9223372036854775807L || j() - this.x < this.k) ? false : true;
    }

    private boolean P(byte b) {
        if (z(b)) {
            this.v = q(b);
        }
        return this.v == this.j;
    }

    private static char p(byte b) {
        return (char) B[(b & 127) - 32];
    }

    private static int q(byte b) {
        return (b >> 3) & 1;
    }

    private List r() {
        int size = this.l.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            C14451hw1 c14451hw1G = ((a) this.l.get(i)).g(RecyclerView.UNDEFINED_DURATION);
            arrayList.add(c14451hw1G);
            if (c14451hw1G != null) {
                iMin = Math.min(iMin, c14451hw1G.i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            C14451hw1 c14451hw1 = (C14451hw1) arrayList.get(i2);
            if (c14451hw1 != null) {
                if (c14451hw1.i != iMin) {
                    c14451hw1 = (C14451hw1) AbstractC20011rK.e(((a) this.l.get(i2)).g(iMin));
                }
                arrayList2.add(c14451hw1);
            }
        }
        return arrayList2;
    }

    private static char s(byte b) {
        return (char) D[b & 31];
    }

    private static char t(byte b) {
        return (char) E[b & 31];
    }

    private static char u(byte b, byte b2) {
        return (b & 1) == 0 ? s(b2) : t(b2);
    }

    private static char v(byte b) {
        return (char) C[b & 15];
    }

    private void w(byte b) {
        this.m.e(' ');
        this.m.p((b >> 1) & 7, (b & 1) == 1);
    }

    private void x(byte b) {
        if (b == 32) {
            M(2);
            return;
        }
        if (b == 41) {
            M(3);
            return;
        }
        switch (b) {
            case 37:
                M(1);
                N(2);
                break;
            case 38:
                M(1);
                N(3);
                break;
            case 39:
                M(1);
                N(4);
                break;
            default:
                int i = this.p;
                if (i != 0) {
                    if (b == 33) {
                        this.m.f();
                        break;
                    } else {
                        switch (b) {
                            case 44:
                                this.n = Collections.emptyList();
                                int i2 = this.p;
                                if (i2 == 1 || i2 == 3) {
                                    L();
                                    break;
                                }
                            case 45:
                                if (i == 1 && !this.m.i()) {
                                    this.m.k();
                                    break;
                                }
                                break;
                            case 46:
                                L();
                                break;
                            case 47:
                                this.n = r();
                                L();
                                break;
                        }
                    }
                }
                break;
        }
    }

    private void y(byte b, byte b2) {
        int i = y[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.m.d) {
            if (this.p != 1 && !this.m.i()) {
                a aVar = new a(this.p, this.q);
                this.m = aVar;
                this.l.add(aVar);
            }
            this.m.d = i;
        }
        boolean z2 = (b2 & 16) == 16;
        boolean z3 = (b2 & 1) == 1;
        int i2 = (b2 >> 1) & 7;
        this.m.p(z2 ? 8 : i2, z3);
        if (z2) {
            this.m.e = z[i2];
        }
    }

    private static boolean z(byte b) {
        return (b & 224) == 0;
    }

    @Override // ir.nasim.IH0, ir.nasim.InterfaceC24671z07
    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
    }

    @Override // ir.nasim.IH0
    protected InterfaceC24081y07 e() {
        List list = this.n;
        this.o = list;
        return new JH0((List) AbstractC20011rK.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    @Override // ir.nasim.IH0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void f(ir.nasim.C07 r10) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EH0.f(ir.nasim.C07):void");
    }

    @Override // ir.nasim.IH0, ir.nasim.DB1
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        M(0);
        N(4);
        L();
        this.r = false;
        this.s = false;
        this.t = (byte) 0;
        this.u = (byte) 0;
        this.v = 0;
        this.w = true;
        this.x = -9223372036854775807L;
    }

    @Override // ir.nasim.IH0
    /* renamed from: g */
    public /* bridge */ /* synthetic */ C07 d() {
        return super.d();
    }

    @Override // ir.nasim.IH0, ir.nasim.DB1
    /* renamed from: h */
    public D07 b() {
        D07 d07I;
        D07 d07B = super.b();
        if (d07B != null) {
            return d07B;
        }
        if (!O() || (d07I = i()) == null) {
            return null;
        }
        this.n = Collections.emptyList();
        this.x = -9223372036854775807L;
        d07I.z(j(), e(), Long.MAX_VALUE);
        return d07I;
    }

    @Override // ir.nasim.IH0
    protected boolean k() {
        return this.n != this.o;
    }

    @Override // ir.nasim.IH0
    /* renamed from: l */
    public /* bridge */ /* synthetic */ void c(C07 c07) {
        super.c(c07);
    }

    @Override // ir.nasim.IH0, ir.nasim.DB1
    public void release() {
    }
}
