package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.zH1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24832zH1 {
    private final int a;
    private final int b;

    /* renamed from: ir.nasim.zH1$a */
    public static final class a extends AbstractC24832zH1 {
        private final int c;

        public a(int i) {
            super(FD5.delete_conversations_title, FD5.delete_conversations_desc, null);
            this.c = i;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.c == ((a) obj).c;
        }

        public int hashCode() {
            return Integer.hashCode(this.c);
        }

        public String toString() {
            return "MultipleDialogsSelection(count=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zH1$b */
    public static final class b extends AbstractC24832zH1 {
        private final String c;
        private final int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, int i) {
            super(FD5.delete_conversation, FD5.delete_bot_conversation_desc, null);
            AbstractC13042fc3.i(str, "title");
            this.c = str;
            this.d = i;
        }

        public final int c() {
            return this.d;
        }

        public final String d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.c, bVar.c) && this.d == bVar.d;
        }

        public int hashCode() {
            return (this.c.hashCode() * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "SingleBotDialogSelection(title=" + this.c + ", peerId=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zH1$c */
    public static final class c extends AbstractC24832zH1 {
        private final String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(FD5.delete_conversation, FD5.delete_channel_conversation_desc, null);
            AbstractC13042fc3.i(str, "title");
            this.c = str;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.c, ((c) obj).c);
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public String toString() {
            return "SingleChannelDialogSelection(title=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zH1$d */
    public static final class d extends AbstractC24832zH1 {
        private final String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(FD5.delete_conversation, FD5.delete_group_conversation_desc, null);
            AbstractC13042fc3.i(str, "title");
            this.c = str;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.c, ((d) obj).c);
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public String toString() {
            return "SingleGroupDialogSelection(title=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zH1$e */
    public static final class e extends AbstractC24832zH1 {
        private final String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(FD5.delete_conversation, FD5.delete_private_conversation_desc, null);
            AbstractC13042fc3.i(str, "title");
            this.c = str;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.c, ((e) obj).c);
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public String toString() {
            return "SinglePrivateDialogSelection(title=" + this.c + Separators.RPAREN;
        }
    }

    public /* synthetic */ AbstractC24832zH1(int i, int i2, ED1 ed1) {
        this(i, i2);
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    private AbstractC24832zH1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
