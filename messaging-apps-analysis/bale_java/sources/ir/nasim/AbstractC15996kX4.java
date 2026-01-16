package ir.nasim;

/* renamed from: ir.nasim.kX4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC15996kX4 {
    private final int a;
    private final int b;

    /* renamed from: ir.nasim.kX4$a */
    public static final class a extends AbstractC15996kX4 {
        public static final a c = new a();

        private a() {
            super(AbstractC12217eE5.participant_option_mute_video, KB5.ic_videocam_enable_new, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 223633482;
        }

        public String toString() {
            return "CanCloseVideo";
        }
    }

    /* renamed from: ir.nasim.kX4$b */
    public static final class b extends AbstractC15996kX4 {
        public static final b c = new b();

        private b() {
            super(AbstractC12217eE5.participant_option_kick_user, KB5.kick_user, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 721007576;
        }

        public String toString() {
            return "CanKickUser";
        }
    }

    /* renamed from: ir.nasim.kX4$c */
    public static final class c extends AbstractC15996kX4 {
        public static final c c = new c();
        public static final int d = 0;

        private c() {
            super(AbstractC12217eE5.participant_option_mute_voice, KB5.voice_call_muted_new, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -699700672;
        }

        public String toString() {
            return "CanMute";
        }
    }

    /* renamed from: ir.nasim.kX4$d */
    public static final class d extends AbstractC15996kX4 {
        public static final d c = new d();

        private d() {
            super(AbstractC12217eE5.participant_option_send_message, KB5.chat, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return -1440655338;
        }

        public String toString() {
            return "SendMessage";
        }
    }

    public /* synthetic */ AbstractC15996kX4(int i, int i2, ED1 ed1) {
        this(i, i2);
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    private AbstractC15996kX4(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
