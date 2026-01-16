package ir.nasim;

/* renamed from: ir.nasim.rM, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC20029rM {
    private final int a;
    private final int b;

    /* renamed from: ir.nasim.rM$a */
    public static final class a extends AbstractC20029rM {
        public static final a c = new a();

        private a() {
            super(AbstractC24188yB5.bold_play, UD5.playing_content_description, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 516765419;
        }

        public String toString() {
            return "Paused";
        }
    }

    /* renamed from: ir.nasim.rM$b */
    public static final class b extends AbstractC20029rM {
        public static final b c = new b();

        private b() {
            super(AbstractC24188yB5.bold_pause, UD5.pause_content_description, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -863507951;
        }

        public String toString() {
            return "Playing";
        }
    }

    public /* synthetic */ AbstractC20029rM(int i, int i2, ED1 ed1) {
        this(i, i2);
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    private AbstractC20029rM(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
