package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ChatActivityEnterViewAnimatedIconView extends RLottieImageView {
    private c n;
    private d o;
    private Map p;

    class a extends HashMap {
        a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RLottieDrawable get(Object obj) {
            RLottieDrawable rLottieDrawable = (RLottieDrawable) super.get(obj);
            if (rLottieDrawable != null) {
                return rLottieDrawable;
            }
            int i = ((d) obj).c;
            return new RLottieDrawable(i, String.valueOf(i), AbstractC21455b.F(32.0f), AbstractC21455b.F(32.0f));
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.VOICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum c {
        VOICE,
        VIDEO,
        STICKER,
        KEYBOARD,
        SMILE,
        GIF
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
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
    private static final class d {
        public static final d d;
        public static final d e;
        public static final d f;
        public static final d g;
        public static final d h;
        public static final d i;
        public static final d j;
        public static final d k;
        public static final d l;
        public static final d m;
        public static final d n;
        public static final d o;
        private static final /* synthetic */ d[] p;
        final c a;
        final c b;
        final int c;

        static {
            c cVar = c.VOICE;
            c cVar2 = c.VIDEO;
            d = new d("VOICE_TO_VIDEO", 0, cVar, cVar2, AbstractC19363qD5.voice_to_video);
            c cVar3 = c.STICKER;
            c cVar4 = c.KEYBOARD;
            e = new d("STICKER_TO_KEYBOARD", 1, cVar3, cVar4, AbstractC19363qD5.sticker_to_keyboard);
            c cVar5 = c.SMILE;
            f = new d("SMILE_TO_KEYBOARD", 2, cVar5, cVar4, AbstractC19363qD5.smile_to_keyboard);
            g = new d("VIDEO_TO_VOICE", 3, cVar2, cVar, AbstractC19363qD5.video_to_voice);
            h = new d("KEYBOARD_TO_STICKER", 4, cVar4, cVar3, AbstractC19363qD5.keyboard_to_sticker);
            c cVar6 = c.GIF;
            i = new d("KEYBOARD_TO_GIF", 5, cVar4, cVar6, AbstractC19363qD5.keyboard_to_gif);
            j = new d("KEYBOARD_TO_SMILE", 6, cVar4, cVar5, AbstractC19363qD5.keyboard_to_smile);
            k = new d("GIF_TO_KEYBOARD", 7, cVar6, cVar4, AbstractC19363qD5.gif_to_keyboard);
            l = new d("GIF_TO_SMILE", 8, cVar6, cVar5, AbstractC19363qD5.gif_to_smile);
            m = new d("SMILE_TO_GIF", 9, cVar5, cVar6, AbstractC19363qD5.smile_to_gif);
            n = new d("SMILE_TO_STICKER", 10, cVar5, cVar3, AbstractC19363qD5.smile_to_sticker);
            o = new d("STICKER_TO_SMILE", 11, cVar3, cVar5, AbstractC19363qD5.sticker_to_smile);
            p = a();
        }

        private d(String str, int i2, c cVar, c cVar2, int i3) {
            this.a = cVar;
            this.b = cVar2;
            this.c = i3;
        }

        private static /* synthetic */ d[] a() {
            return new d[]{d, e, f, g, h, i, j, k, l, m, n, o};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) p.clone();
        }
    }

    public ChatActivityEnterViewAnimatedIconView(Context context) {
        super(context);
        this.p = new a();
    }

    private d i(c cVar) {
        for (d dVar : d.values()) {
            if (dVar.a == cVar) {
                return dVar;
            }
        }
        return null;
    }

    private d j(c cVar, c cVar2) {
        for (d dVar : d.values()) {
            if (dVar.a == cVar && dVar.b == cVar2) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.o = null;
    }

    public void setState(c cVar, boolean z) {
        if (z && cVar == this.n) {
            return;
        }
        c cVar2 = this.n;
        this.n = cVar;
        if (!z || cVar2 == null || j(cVar2, cVar) == null) {
            RLottieDrawable rLottieDrawable = (RLottieDrawable) this.p.get(i(this.n));
            rLottieDrawable.stop();
            rLottieDrawable.s0(0.0f, false);
            setAnimation(rLottieDrawable);
        } else {
            d dVarJ = j(cVar2, this.n);
            if (dVarJ == this.o) {
                return;
            }
            this.o = dVarJ;
            final RLottieDrawable rLottieDrawable2 = (RLottieDrawable) this.p.get(dVarJ);
            rLottieDrawable2.stop();
            rLottieDrawable2.s0(0.0f, false);
            rLottieDrawable2.d0(0);
            rLottieDrawable2.p0(new Runnable() { // from class: ir.nasim.gL0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k();
                }
            });
            setAnimation(rLottieDrawable2);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.hL0
                @Override // java.lang.Runnable
                public final void run() {
                    rLottieDrawable2.start();
                }
            });
        }
        int i = b.a[cVar.ordinal()];
        if (i == 1) {
            setContentDescription(FH3.E("AccDescrVoiceMessage", TD5.tgwidget_AccDescrVoiceMessage));
        } else {
            if (i != 2) {
                return;
            }
            setContentDescription(FH3.E("AccDescrVideoMessage", TD5.tgwidget_AccDescrVideoMessage));
        }
    }
}
