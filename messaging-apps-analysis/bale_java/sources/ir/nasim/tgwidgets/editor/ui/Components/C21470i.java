package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.widget.FrameLayout;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.Bulletin;

/* renamed from: ir.nasim.tgwidgets.editor.ui.Components.i, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21470i {
    private final FrameLayout a;
    private final m.h b;

    private C21470i(FrameLayout frameLayout, m.h hVar) {
        this.a = frameLayout;
        this.b = hVar;
    }

    private Bulletin a(Bulletin.Layout layout, int i) {
        return Bulletin.k(this.a, layout, i);
    }

    public static Bulletin d(FrameLayout frameLayout, int i, boolean z, int i2, int i3) {
        return h(frameLayout, null).b(z ? i > 1 ? a.h : a.g : i > 1 ? a.f : a.e, i, i2, i3);
    }

    public static Bulletin e(FrameLayout frameLayout, boolean z, int i, int i2) {
        return h(frameLayout, null).b(z ? a.g : a.e, 1, i, i2);
    }

    private Context g() {
        FrameLayout frameLayout = this.a;
        Context context = frameLayout != null ? frameLayout.getContext() : null;
        return context == null ? AbstractC14047hG.a : context;
    }

    public static C21470i h(FrameLayout frameLayout, m.h hVar) {
        return new C21470i(frameLayout, hVar);
    }

    public Bulletin b(a aVar, int i, int i2, int i3) {
        return c(aVar, i, i2, i3, null);
    }

    public Bulletin c(a aVar, int i, int i2, int i3, m.h hVar) {
        Bulletin.LottieLayout lottieLayout = (i2 == 0 || i3 == 0) ? new Bulletin.LottieLayout(g(), hVar) : new Bulletin.LottieLayout(g(), hVar, i2, i3);
        lottieLayout.setAnimation(aVar.d.a, aVar.d.b);
        lottieLayout.v.setText(aVar.q(i));
        if (aVar.d.c != 0) {
            lottieLayout.setIconPaddingBottom(aVar.d.c);
        }
        return a(lottieLayout, 1500);
    }

    public Bulletin f(int i, CharSequence charSequence) {
        Bulletin.LottieLayout lottieLayout = new Bulletin.LottieLayout(g(), this.b);
        lottieLayout.setAnimation(i, 36, 36, new String[0]);
        lottieLayout.v.setText(charSequence);
        lottieLayout.v.setSingleLine(false);
        lottieLayout.v.setMaxLines(2);
        return a(lottieLayout, charSequence.length() < 20 ? 1500 : 2750);
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.i$a */
    public static final class a {
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        private static final /* synthetic */ a[] r;
        private final String a;
        private final int b;
        private final boolean c;
        private final EnumC1594a d;

        /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.i$a$a, reason: collision with other inner class name */
        private enum EnumC1594a {
            SAVED_TO_DOWNLOADS(AbstractC19363qD5.ic_download, 2, "Box", "Arrow"),
            SAVED_TO_GALLERY(AbstractC19363qD5.ic_save_to_gallery, 0, "Box", "Arrow", "Mask", "Arrow 2", "Splash"),
            SAVED_TO_MUSIC(AbstractC19363qD5.ic_save_to_music, 2, "Box", "Arrow"),
            SAVED_TO_GIFS(AbstractC19363qD5.ic_save_to_gifs, 0, "gif");

            private final int a;
            private final String[] b;
            private final int c;

            EnumC1594a(int i, int i2, String... strArr) {
                this.a = i;
                this.c = i2;
                this.b = strArr;
            }
        }

        static {
            int i2 = TD5.tgwidget_PhotoSavedHint;
            EnumC1594a enumC1594a = EnumC1594a.SAVED_TO_GALLERY;
            e = new a("PHOTO", 0, "PhotoSavedHint", i2, enumC1594a);
            f = new a("PHOTOS", 1, "PhotosSavedHint", enumC1594a);
            g = new a("VIDEO", 2, "VideoSavedHint", TD5.tgwidget_VideoSavedHint, enumC1594a);
            h = new a("VIDEOS", 3, "VideosSavedHint", enumC1594a);
            i = new a("MEDIA", 4, "MediaSavedHint", enumC1594a);
            int i3 = TD5.tgwidget_PhotoSavedToDownloadsHint;
            EnumC1594a enumC1594a2 = EnumC1594a.SAVED_TO_DOWNLOADS;
            j = new a("PHOTO_TO_DOWNLOADS", 5, "PhotoSavedToDownloadsHint", i3, enumC1594a2);
            k = new a("VIDEO_TO_DOWNLOADS", 6, "VideoSavedToDownloadsHint", TD5.tgwidget_VideoSavedToDownloadsHint, enumC1594a2);
            l = new a("GIF", 7, "GifSavedHint", TD5.tgwidget_GifSavedHint, EnumC1594a.SAVED_TO_GIFS);
            m = new a("GIF_TO_DOWNLOADS", 8, "GifSavedToDownloadsHint", TD5.tgwidget_GifSavedToDownloadsHint, enumC1594a2);
            int i4 = TD5.tgwidget_AudioSavedHint;
            EnumC1594a enumC1594a3 = EnumC1594a.SAVED_TO_MUSIC;
            n = new a("AUDIO", 9, "AudioSavedHint", i4, enumC1594a3);
            o = new a("AUDIOS", 10, "AudiosSavedHint", enumC1594a3);
            p = new a("UNKNOWN", 11, "FileSavedHint", TD5.tgwidget_FileSavedHint, enumC1594a2);
            q = new a("UNKNOWNS", 12, "FilesSavedHint", enumC1594a2);
            r = a();
        }

        private a(String str, int i2, String str2, int i3, EnumC1594a enumC1594a) {
            this.a = str2;
            this.b = i3;
            this.d = enumC1594a;
            this.c = false;
        }

        private static /* synthetic */ a[] a() {
            return new a[]{e, f, g, h, i, j, k, l, m, n, o, p, q};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String q(int i2) {
            return this.c ? FH3.o(this.a, i2, new Object[0]) : FH3.E(this.a, this.b);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) r.clone();
        }

        private a(String str, int i2, String str2, EnumC1594a enumC1594a) {
            this.a = str2;
            this.d = enumC1594a;
            this.b = 0;
            this.c = true;
        }
    }
}
