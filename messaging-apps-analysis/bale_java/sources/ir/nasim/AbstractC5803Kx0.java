package ir.nasim;

/* renamed from: ir.nasim.Kx0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5803Kx0 {
    public static final int e = 8;
    private final int a;
    private final int b;
    private final InterfaceC8960Xz0 c;
    private final InterfaceC14603iB2 d;

    /* renamed from: ir.nasim.Kx0$a */
    public static final class a extends AbstractC5803Kx0 {
        public static final a f = new a();

        private a() {
            super(AbstractC12217eE5.nasim_call_members, KB5.two_user, C7265Qz0.a, null, 8, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1936213941;
        }

        public String toString() {
            return "CallMembers";
        }
    }

    /* renamed from: ir.nasim.Kx0$b */
    public static final class b extends AbstractC5803Kx0 {
        public static final b f = new b();

        private b() {
            super(AbstractC12217eE5.call_monitoring, KB5.background_restriction_icon, C7972Tz0.a, null, 8, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1441263658;
        }

        public String toString() {
            return "CallMonitoring";
        }
    }

    /* renamed from: ir.nasim.Kx0$c */
    public static final class c extends AbstractC5803Kx0 {
        public static final c f = new c();

        private c() {
            super(AbstractC12217eE5.nasim_call_link, KB5.link, C8206Uz0.a, null, 8, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -755001718;
        }

        public String toString() {
            return "Link";
        }
    }

    /* renamed from: ir.nasim.Kx0$d */
    public static final class d extends AbstractC5803Kx0 {
        public static final d f = new d();

        private d() {
            super(AbstractC12217eE5.call_option_item_record, KB5.ic_record, C8694Wz0.a, null, 8, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 460582625;
        }

        public String toString() {
            return "Record";
        }
    }

    /* renamed from: ir.nasim.Kx0$e */
    public static final class e extends AbstractC5803Kx0 {
        public static final e f = new e();

        private e() {
            super(AbstractC12217eE5.call_option_item_recording, KB5.ic_call_option_pause, C8440Vz0.a, C10700c31.a.b(), null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return -1203424927;
        }

        public String toString() {
            return "Recording";
        }
    }

    /* renamed from: ir.nasim.Kx0$f */
    public static final class f extends AbstractC5803Kx0 {
        public static final f f = new f();

        private f() {
            super(AbstractC12217eE5.start_share_screen, KB5.ic_sharescreen, C7499Rz0.a, null, 8, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return -1669621255;
        }

        public String toString() {
            return "StartShareScreen";
        }
    }

    /* renamed from: ir.nasim.Kx0$g */
    public static final class g extends AbstractC5803Kx0 {
        public static final g f = new g();

        private g() {
            super(AbstractC12217eE5.stop_share_screen, KB5.ic_sharescreen, C7733Sz0.a, null, 8, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof g);
        }

        public int hashCode() {
            return -1994611911;
        }

        public String toString() {
            return "StopShareScreen";
        }
    }

    public /* synthetic */ AbstractC5803Kx0(int i, int i2, InterfaceC8960Xz0 interfaceC8960Xz0, InterfaceC14603iB2 interfaceC14603iB2, ED1 ed1) {
        this(i, i2, interfaceC8960Xz0, interfaceC14603iB2);
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final InterfaceC14603iB2 c() {
        return this.d;
    }

    public final InterfaceC8960Xz0 d() {
        return this.c;
    }

    private AbstractC5803Kx0(int i, int i2, InterfaceC8960Xz0 interfaceC8960Xz0, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = i;
        this.b = i2;
        this.c = interfaceC8960Xz0;
        this.d = interfaceC14603iB2;
    }

    public /* synthetic */ AbstractC5803Kx0(int i, int i2, InterfaceC8960Xz0 interfaceC8960Xz0, InterfaceC14603iB2 interfaceC14603iB2, int i3, ED1 ed1) {
        this(i, i2, interfaceC8960Xz0, (i3 & 8) != 0 ? C10700c31.a.a() : interfaceC14603iB2, null);
    }
}
