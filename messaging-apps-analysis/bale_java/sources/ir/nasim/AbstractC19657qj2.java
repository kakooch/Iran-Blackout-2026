package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC19657qj2 {
    private final int a;
    private final int b;
    private final SA2 c;

    /* renamed from: ir.nasim.qj2$a */
    public static final class a extends AbstractC19657qj2 {
        private final SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SA2 sa2) {
            super(ID5.feed_copy_text_menu, AbstractC18163oB5.copy, sa2, null);
            AbstractC13042fc3.i(sa2, "clickAction");
            this.d = sa2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.d, ((a) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public String toString() {
            return "CopyTextMenu(clickAction=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qj2$b */
    public static final class b extends AbstractC19657qj2 {
        private final SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SA2 sa2) {
            super(ID5.feed_forward_menu, AbstractC18163oB5.forward_e, sa2, null);
            AbstractC13042fc3.i(sa2, "clickAction");
            this.d = sa2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.d, ((b) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public String toString() {
            return "ForwardMenu(clickAction=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qj2$c */
    public static final class c extends AbstractC19657qj2 {
        private final SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2) {
            super(ID5.feed_join_menu, AbstractC18163oB5.ic_feed_join_menu, sa2, null);
            AbstractC13042fc3.i(sa2, "clickAction");
            this.d = sa2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.d, ((c) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public String toString() {
            return "JoinChannelMenu(clickAction=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qj2$d */
    public static final class d extends AbstractC19657qj2 {
        private final SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2) {
            super(ID5.feed_report_menu, AbstractC18163oB5.alert, sa2, null);
            AbstractC13042fc3.i(sa2, "clickAction");
            this.d = sa2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.d, ((d) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public String toString() {
            return "ReportMenu(clickAction=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qj2$e */
    public static final class e extends AbstractC19657qj2 {
        private final SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(ID5.feed_save_message_menu, AbstractC18163oB5.saved_message, sa2, null);
            AbstractC13042fc3.i(sa2, "clickAction");
            this.d = sa2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.d, ((e) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public String toString() {
            return "SaveMessageMenu(clickAction=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qj2$f */
    public static final class f extends AbstractC19657qj2 {
        private final SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(ID5.feed_show_menu, AbstractC18163oB5.ic_feed_show_menu, sa2, null);
            AbstractC13042fc3.i(sa2, "clickAction");
            this.d = sa2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && AbstractC13042fc3.d(this.d, ((f) obj).d);
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public String toString() {
            return "ShowChannelMenu(clickAction=" + this.d + Separators.RPAREN;
        }
    }

    public /* synthetic */ AbstractC19657qj2(int i, int i2, SA2 sa2, ED1 ed1) {
        this(i, i2, sa2);
    }

    public final SA2 a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    private AbstractC19657qj2(int i, int i2, SA2 sa2) {
        this.a = i;
        this.b = i2;
        this.c = sa2;
    }
}
