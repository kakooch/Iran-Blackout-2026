package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.Er5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC4335Er5 {

    /* renamed from: ir.nasim.Er5$a */
    public static final class a implements InterfaceC4335Er5 {
        private final String a;
        private final C19705qo0 b;
        private final C19705qo0 c;
        private final int d;

        public a(String str) {
            AbstractC13042fc3.i(str, "userName");
            this.a = str;
            this.b = new C19705qo0(DD5.privacy_bar_understood, InterfaceC19114po0.b.C1454b.a);
            this.c = new C19705qo0(DD5.privacy_bar_block_bot, InterfaceC19114po0.c.b.a);
            this.d = DD5.privacy_bar_bot_title;
        }

        public C19705qo0 b() {
            return this.b;
        }

        public C19705qo0 c() {
            return this.c;
        }

        public Integer d() {
            return Integer.valueOf(this.d);
        }

        public final String e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Bot(userName=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Er5$b */
    public static final class b implements InterfaceC4335Er5 {
        private final String a;
        private final C19705qo0 b = new C19705qo0(DD5.privacy_bar_accept_invitation, InterfaceC19114po0.b.c.a);
        private final C19705qo0 c;
        private final C19705qo0 d;
        private final int e;

        public b(String str) {
            this.a = str;
            int i = DD5.privacy_bar_leave_the_channel;
            InterfaceC19114po0.c.C1455c c1455c = InterfaceC19114po0.c.C1455c.a;
            this.c = new C19705qo0(i, c1455c);
            this.d = new C19705qo0(DD5.privacy_bar_leave_the_channel_and_report, c1455c);
            this.e = DD5.privacy_bar_group_title;
        }

        @Override // ir.nasim.InterfaceC4335Er5
        public C19705qo0 a() {
            return this.d;
        }

        public C19705qo0 b() {
            return this.b;
        }

        public C19705qo0 c() {
            return this.c;
        }

        public Integer d() {
            return Integer.valueOf(this.e);
        }

        public final String e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Channel(userName=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Er5$c */
    public static final class c implements InterfaceC4335Er5 {
        private final String a;
        private final C19705qo0 b = new C19705qo0(DD5.privacy_bar_accept_invitation, InterfaceC19114po0.b.c.a);
        private final C19705qo0 c;
        private final C19705qo0 d;
        private final int e;

        public c(String str) {
            this.a = str;
            int i = DD5.privacy_bar_leave_the_group;
            InterfaceC19114po0.c.C1455c c1455c = InterfaceC19114po0.c.C1455c.a;
            this.c = new C19705qo0(i, c1455c);
            this.d = new C19705qo0(DD5.privacy_bar_leave_the_group_and_report, c1455c);
            this.e = DD5.privacy_bar_group_title;
        }

        @Override // ir.nasim.InterfaceC4335Er5
        public C19705qo0 a() {
            return this.d;
        }

        public C19705qo0 b() {
            return this.b;
        }

        public C19705qo0 c() {
            return this.c;
        }

        public Integer d() {
            return Integer.valueOf(this.e);
        }

        public final String e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Group(userName=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Er5$d */
    public static final class d implements InterfaceC4335Er5 {
        public static final d a = new d();

        private d() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return -592291518;
        }

        public String toString() {
            return "None";
        }
    }

    /* renamed from: ir.nasim.Er5$e */
    public static final class e implements InterfaceC4335Er5 {
        private final String a;
        private final C19705qo0 b;
        private final C19705qo0 c;
        private final C19705qo0 d;
        private final int e;

        public e(String str) {
            AbstractC13042fc3.i(str, "userName");
            this.a = str;
            this.b = new C19705qo0(DD5.privacy_bar_contacts_available, InterfaceC19114po0.b.c.a);
            int i = DD5.privacy_bar_contacts_block;
            InterfaceC19114po0.c.C1455c c1455c = InterfaceC19114po0.c.C1455c.a;
            this.c = new C19705qo0(i, c1455c);
            this.d = new C19705qo0(DD5.privacy_bar_contacts_block_and_report, c1455c);
            this.e = DD5.privacy_bar_private_message_title;
        }

        @Override // ir.nasim.InterfaceC4335Er5
        public C19705qo0 a() {
            return this.d;
        }

        public C19705qo0 b() {
            return this.b;
        }

        public C19705qo0 c() {
            return this.c;
        }

        public Integer d() {
            return Integer.valueOf(this.e);
        }

        public final String e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Private(userName=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Er5$f */
    public static final class f implements InterfaceC4335Er5 {
        public static final f a = new f();

        private f() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return 1396701419;
        }

        public String toString() {
            return SIPHeaderNames.UNSUPPORTED;
        }
    }

    default C19705qo0 a() {
        return null;
    }
}
