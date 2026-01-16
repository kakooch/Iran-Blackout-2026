package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.uD4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC21839uD4 extends CD4 {

    /* renamed from: ir.nasim.uD4$a */
    public static final class a implements InterfaceC21839uD4 {
        private final String a;

        public a(String str) {
            AbstractC13042fc3.i(str, "defaultName");
            this.a = str;
        }

        @Override // ir.nasim.CD4
        public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c9057Yh4, "moduleContext");
            AbstractC13042fc3.i(str, "defaultText");
            return new DD4(context.getString(AbstractC12217eE5.audio_notification_text, this.a), null, null, 6, null);
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
            return "ExAudio(defaultName=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.uD4$b */
    public static final class b implements InterfaceC21839uD4 {
        private final String a;

        public b(String str) {
            this.a = str;
        }

        private final String b(Context context, String str) {
            String string = (str == null || AbstractC20762sZ6.n0(str)) ? context.getString(AbstractC12217eE5.file_notification_text) : context.getString(AbstractC12217eE5.caption_notification_text, str);
            AbstractC13042fc3.f(string);
            return string;
        }

        @Override // ir.nasim.CD4
        public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c9057Yh4, "moduleContext");
            AbstractC13042fc3.i(str, "defaultText");
            return new DD4(b(context, this.a), null, null, 6, null);
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
            return "ExFile(caption=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.uD4$c */
    public static final class c implements InterfaceC21839uD4 {
        public static final c a = new c();

        private c() {
        }

        @Override // ir.nasim.CD4
        public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c9057Yh4, "moduleContext");
            AbstractC13042fc3.i(str, "defaultText");
            return new DD4(context.getString(AbstractC12217eE5.gif_notification_text), null, null, 6, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 226084659;
        }

        public String toString() {
            return "ExGif";
        }
    }

    /* renamed from: ir.nasim.uD4$d */
    public static final class d implements InterfaceC21839uD4 {
        private final C9767aX1 a;

        public d(C9767aX1 c9767aX1) {
            AbstractC13042fc3.i(c9767aX1, "data");
            this.a = c9767aX1;
        }

        private final void b(C9057Yh4 c9057Yh4, DD4 dd4) {
            new C4647Fy5(c9057Yh4, new C10977cX1(new C10361bX1(this.a.c(), this.a.a(), this.a.e()), "photo_" + this.a.c() + ".jpg", "", this.a.d()), this.a.f()).a(dd4);
        }

        private final String c(Context context, String str, boolean z) {
            if (str == null || AbstractC20762sZ6.n0(str)) {
                str = context.getString(AbstractC12217eE5.photo_notification_text, context.getString(AbstractC12217eE5.photo_notification_default));
            } else if (!z) {
                str = context.getString(AbstractC12217eE5.photo_notification_text, str);
                AbstractC13042fc3.f(str);
            }
            AbstractC13042fc3.f(str);
            return str;
        }

        @Override // ir.nasim.CD4
        public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c9057Yh4, "moduleContext");
            AbstractC13042fc3.i(str, "defaultText");
            String strC = c(context, this.a.b(), z);
            DD4 dd4 = new DD4(null, null, null, 7, null);
            if (z) {
                b(c9057Yh4, dd4);
            }
            dd4.f(strC);
            return dd4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ExPhoto(data=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.uD4$e */
    public static final class e implements InterfaceC21839uD4 {
        public static final e a = new e();

        private e() {
        }

        @Override // ir.nasim.CD4
        public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c9057Yh4, "moduleContext");
            AbstractC13042fc3.i(str, "defaultText");
            return new DD4(context.getString(AbstractC12217eE5.video_notification_text), null, null, 6, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return -1762120662;
        }

        public String toString() {
            return "ExVideo";
        }
    }

    /* renamed from: ir.nasim.uD4$f */
    public static final class f implements InterfaceC21839uD4 {
        public static final f a = new f();

        private f() {
        }

        @Override // ir.nasim.CD4
        public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c9057Yh4, "moduleContext");
            AbstractC13042fc3.i(str, "defaultText");
            return new DD4(context.getString(AbstractC12217eE5.voice_notification_text), null, null, 6, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return -1761937183;
        }

        public String toString() {
            return "ExVoice";
        }
    }
}
