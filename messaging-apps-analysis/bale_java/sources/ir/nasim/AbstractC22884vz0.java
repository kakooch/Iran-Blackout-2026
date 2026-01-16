package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13463gG6;

/* renamed from: ir.nasim.vz0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22884vz0 {
    private final int a;

    /* renamed from: ir.nasim.vz0$a */
    public static abstract class a extends AbstractC22884vz0 {

        /* renamed from: ir.nasim.vz0$a$a, reason: collision with other inner class name */
        public static final class C1733a extends a {
            private final String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1733a(String str) {
                super(AbstractC12217eE5.invite_not_support, null);
                AbstractC13042fc3.i(str, "userName");
                this.b = str;
            }

            public final String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1733a) && AbstractC13042fc3.d(this.b, ((C1733a) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "InviteNotSupport(userName=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.vz0$a$b */
        public static final class b extends a {
            private final String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(AbstractC12217eE5.invited_user_accepted, null);
                AbstractC13042fc3.i(str, "userName");
                this.b = str;
            }

            public final String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && AbstractC13042fc3.d(this.b, ((b) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "InvitedUserAccepted(userName=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.vz0$a$c */
        public static final class c extends a {
            private final String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(AbstractC12217eE5.invited_user_rejected, null);
                AbstractC13042fc3.i(str, "userName");
                this.b = str;
            }

            public final String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && AbstractC13042fc3.d(this.b, ((c) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "InvitedUserRejected(userName=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.vz0$a$d */
        public static final class d extends a {
            public static final d b = new d();

            private d() {
                super(AbstractC12217eE5.invite_call_btm_max_limit_error, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof d);
            }

            public int hashCode() {
                return 1496532625;
            }

            public String toString() {
                return "MaxInviteUserCountReached";
            }
        }

        /* renamed from: ir.nasim.vz0$a$e */
        public static final class e extends a {
            public static final e b = new e();

            private e() {
                super(AbstractC12217eE5.invite_not_avaliable_at_this_state, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof e);
            }

            public int hashCode() {
                return 569354732;
            }

            public String toString() {
                return "UserCanNotInviteUntilConnected";
            }
        }

        /* renamed from: ir.nasim.vz0$a$f */
        public static final class f extends a {
            private final String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(String str) {
                super(AbstractC12217eE5.user_invited_to_call, null);
                AbstractC13042fc3.i(str, "userName");
                this.b = str;
            }

            public final String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof f) && AbstractC13042fc3.d(this.b, ((f) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "UserInvitedToCall(userName=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.vz0$a$g */
        public static final class g extends a {
            private final int b;

            public g(int i) {
                super(AbstractC12217eE5.users_invited_to_call, null);
                this.b = i;
            }

            public final int b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof g) && this.b == ((g) obj).b;
            }

            public int hashCode() {
                return Integer.hashCode(this.b);
            }

            public String toString() {
                return "UsersInvitedToCall(count=" + this.b + Separators.RPAREN;
            }
        }

        public /* synthetic */ a(int i, ED1 ed1) {
            this(i);
        }

        private a(int i) {
            super(i, null);
        }
    }

    /* renamed from: ir.nasim.vz0$b */
    public static abstract class b extends AbstractC22884vz0 {
        public static final int c = AbstractC13463gG6.a;
        private final AbstractC13463gG6 b;

        /* renamed from: ir.nasim.vz0$b$a */
        public static final class a extends b {
            public static final a d = new a();

            private a() {
                super(AbstractC12217eE5.call_record_end, new AbstractC13463gG6.b(KB5.ic_videocam_enable_new), null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return -411626777;
            }

            public String toString() {
                return "RecordEnded";
            }
        }

        /* renamed from: ir.nasim.vz0$b$b, reason: collision with other inner class name */
        public static final class C1734b extends b {
            private final String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1734b(String str) {
                super(AbstractC12217eE5.call_record_started, new AbstractC13463gG6.b(KB5.ic_videocam_disable_new), null);
                AbstractC13042fc3.i(str, "userName");
                this.d = str;
            }

            public final String c() {
                return this.d;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1734b) && AbstractC13042fc3.d(this.d, ((C1734b) obj).d);
            }

            public int hashCode() {
                return this.d.hashCode();
            }

            public String toString() {
                return "RecordStarted(userName=" + this.d + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.vz0$b$c */
        public static final class c extends b {
            public static final c d = new c();

            private c() {
                super(AbstractC12217eE5.call_record_starting, new AbstractC13463gG6.a(null, null, true, null, 11, null), null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof c);
            }

            public int hashCode() {
                return -1055388429;
            }

            public String toString() {
                return "RecordStarting";
            }
        }

        /* renamed from: ir.nasim.vz0$b$d */
        public static final class d extends b {
            public static final d d = new d();

            private d() {
                super(AbstractC12217eE5.call_record_starting_failed, new AbstractC13463gG6.b(KB5.ic_alert), null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof d);
            }

            public int hashCode() {
                return 224709392;
            }

            public String toString() {
                return "RecordStartingFailed";
            }
        }

        /* renamed from: ir.nasim.vz0$b$e */
        public static final class e extends b {
            public static final e d = new e();

            private e() {
                super(AbstractC12217eE5.call_recording_started, new AbstractC13463gG6.a(null, null, false, null, 11, null), null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof e);
            }

            public int hashCode() {
                return -1131118737;
            }

            public String toString() {
                return "Recording";
            }
        }

        public /* synthetic */ b(int i, AbstractC13463gG6 abstractC13463gG6, ED1 ed1) {
            this(i, abstractC13463gG6);
        }

        public final AbstractC13463gG6 b() {
            return this.b;
        }

        private b(int i, AbstractC13463gG6 abstractC13463gG6) {
            super(i, null);
            this.b = abstractC13463gG6;
        }
    }

    /* renamed from: ir.nasim.vz0$c */
    public static abstract class c extends AbstractC22884vz0 {

        /* renamed from: ir.nasim.vz0$c$a */
        public static final class a extends c {
            private final String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(AbstractC12217eE5.room_event_video_muted, null);
                AbstractC13042fc3.i(str, "userName");
                this.b = str;
            }

            public final String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && AbstractC13042fc3.d(this.b, ((a) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "YourVideoHaveBeenMuted(userName=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.vz0$c$b */
        public static final class b extends c {
            private final String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(AbstractC12217eE5.room_event_voice_muted, null);
                AbstractC13042fc3.i(str, "userName");
                this.b = str;
            }

            public final String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && AbstractC13042fc3.d(this.b, ((b) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "YourVoiceHaveBeenMuted(userName=" + this.b + Separators.RPAREN;
            }
        }

        public /* synthetic */ c(int i, ED1 ed1) {
            this(i);
        }

        private c(int i) {
            super(i, null);
        }
    }

    public /* synthetic */ AbstractC22884vz0(int i, ED1 ed1) {
        this(i);
    }

    public final int a() {
        return this.a;
    }

    private AbstractC22884vz0(int i) {
        this.a = i;
    }
}
