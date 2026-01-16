package ir.nasim;

import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.rV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC20117rV6 {
    public static final a h;
    public static final EnumC20117rV6 i = new EnumC20117rV6("ARBAEEN", 0, 1, AbstractC23008wB5.story_arbaeen_badge, AbstractC23008wB5.story_arbaeen_badge_seen, AbstractC23008wB5.story_arbaeen_ring, SD5.tag_title_arbaeen, AbstractC23008wB5.bg_story_tag_arbaeen, SD5.story_tag_tooltip_text);
    public static final EnumC20117rV6 j = new EnumC20117rV6("YALDA", 1, 2, AbstractC23008wB5.story_yalda_badge, AbstractC23008wB5.story_yalda_badge_seen, AbstractC23008wB5.story_yalda_ring, SD5.tag_title_yalda, AbstractC23008wB5.bg_story_tag_yalda, SD5.story_yalda_tag_tooltip_text);
    public static final EnumC20117rV6 k = new EnumC20117rV6("NOWRUZ", 2, 3, AbstractC23008wB5.story_nowruz_badge, AbstractC23008wB5.story_nowruz_badge_seen, AbstractC23008wB5.story_nowruz_ring, SD5.tag_title_nowruz, AbstractC23008wB5.bg_story_tag_nowruz, SD5.story_nowruz_tag_tooltip_text);
    private static final /* synthetic */ EnumC20117rV6[] l;
    private static final /* synthetic */ F92 m;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    /* renamed from: ir.nasim.rV6$a */
    public static final class a {
        private a() {
        }

        public final EnumC20117rV6 a(int i) {
            Object next;
            Iterator<E> it = EnumC20117rV6.r().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((EnumC20117rV6) next).s() == i) {
                    break;
                }
            }
            return (EnumC20117rV6) next;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC20117rV6[] enumC20117rV6ArrA = a();
        l = enumC20117rV6ArrA;
        m = G92.a(enumC20117rV6ArrA);
        h = new a(null);
    }

    private EnumC20117rV6(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.a = i3;
        this.b = i4;
        this.c = i5;
        this.d = i6;
        this.e = i7;
        this.f = i8;
        this.g = i9;
    }

    private static final /* synthetic */ EnumC20117rV6[] a() {
        return new EnumC20117rV6[]{i, j, k};
    }

    public static F92 r() {
        return m;
    }

    public static EnumC20117rV6 valueOf(String str) {
        return (EnumC20117rV6) Enum.valueOf(EnumC20117rV6.class, str);
    }

    public static EnumC20117rV6[] values() {
        return (EnumC20117rV6[]) l.clone();
    }

    public final int j() {
        return this.b;
    }

    public final int p() {
        return this.c;
    }

    public final int q() {
        return this.f;
    }

    public final int s() {
        return this.a;
    }

    public final int u() {
        return this.d;
    }

    public final int w() {
        return this.e;
    }

    public final int y() {
        return this.g;
    }
}
