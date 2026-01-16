package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.Zd5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9256Zd5 {
    public static final b c = new b(null);
    private final String a;
    private final String b;

    /* renamed from: ir.nasim.Zd5$a */
    public static final class a extends AbstractC9256Zd5 {
        private final ExPeer d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ExPeer exPeer) {
            super("chat_" + exPeer.getPeerId(), "shortcut_chat", null);
            AbstractC13042fc3.i(exPeer, "exPeer");
            this.d = exPeer;
        }

        public final ExPeer c() {
            return this.d;
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
            return "Chat(exPeer=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Zd5$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Zd5$c */
    public static final class c extends AbstractC9256Zd5 {
        private final int d;

        public c(int i) {
            super("main_webapp_" + i, "shortcut_main_webapp", null);
            this.d = i;
        }

        public final int c() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.d == ((c) obj).d;
        }

        public int hashCode() {
            return Integer.hashCode(this.d);
        }

        public String toString() {
            return "MainWebApp(peerId=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Zd5$d */
    public static final class d extends AbstractC9256Zd5 {
        private final int d;

        public d(int i) {
            super("menu_webapp_" + i, "shortcut_menu_webapp", null);
            this.d = i;
        }

        public final int c() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.d == ((d) obj).d;
        }

        public int hashCode() {
            return Integer.hashCode(this.d);
        }

        public String toString() {
            return "MenuWebApp(peerId=" + this.d + Separators.RPAREN;
        }
    }

    public /* synthetic */ AbstractC9256Zd5(String str, String str2, ED1 ed1) {
        this(str, str2);
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    private AbstractC9256Zd5(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
