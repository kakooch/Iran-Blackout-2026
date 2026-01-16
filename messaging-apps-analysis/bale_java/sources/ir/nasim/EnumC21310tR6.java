package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.tR6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC21310tR6 {
    public static final a d;
    public static final EnumC21310tR6 e = new EnumC21310tR6("MP4", 0, "mp4", true, "video/mp4");
    public static final EnumC21310tR6 f = new EnumC21310tR6("JPG", 1, "jpg", false, "photo/jpeg");
    public static final EnumC21310tR6 g = new EnumC21310tR6("JPEG", 2, "jpeg", false, "photo/jpeg");
    public static final EnumC21310tR6 h = new EnumC21310tR6("PNG", 3, "png", false, "photo/png");
    public static final EnumC21310tR6 i = new EnumC21310tR6("WEBP", 4, "webp", false, "photo/webp");
    public static final EnumC21310tR6 j = new EnumC21310tR6("HEIC", 5, "heic", false, "photo/heic");
    private static final /* synthetic */ EnumC21310tR6[] k;
    private static final /* synthetic */ F92 l;
    private final String a;
    private final boolean b;
    private final String c;

    /* renamed from: ir.nasim.tR6$a */
    public static final class a {
        private a() {
        }

        public final EnumC21310tR6 a(String str) {
            Object obj;
            AbstractC13042fc3.i(str, "extension");
            Iterator<E> it = EnumC21310tR6.j().iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (AbstractC20762sZ6.X(((EnumC21310tR6) next).p(), AbstractC20762sZ6.Z0(str, Separators.DOT, null, 2, null), false, 2, null)) {
                    obj = next;
                    break;
                }
            }
            EnumC21310tR6 enumC21310tR6 = (EnumC21310tR6) obj;
            return enumC21310tR6 == null ? EnumC21310tR6.h : enumC21310tR6;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC21310tR6[] enumC21310tR6ArrA = a();
        k = enumC21310tR6ArrA;
        l = G92.a(enumC21310tR6ArrA);
        d = new a(null);
    }

    private EnumC21310tR6(String str, int i2, String str2, boolean z, String str3) {
        this.a = str2;
        this.b = z;
        this.c = str3;
    }

    private static final /* synthetic */ EnumC21310tR6[] a() {
        return new EnumC21310tR6[]{e, f, g, h, i, j};
    }

    public static F92 j() {
        return l;
    }

    public static EnumC21310tR6 valueOf(String str) {
        return (EnumC21310tR6) Enum.valueOf(EnumC21310tR6.class, str);
    }

    public static EnumC21310tR6[] values() {
        return (EnumC21310tR6[]) k.clone();
    }

    public final String p() {
        return this.a;
    }

    public final String q() {
        return this.c;
    }

    public final boolean r() {
        return this.b;
    }
}
