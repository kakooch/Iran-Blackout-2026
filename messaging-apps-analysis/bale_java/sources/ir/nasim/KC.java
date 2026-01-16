package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes7.dex */
public final class KC implements InterfaceC14123hO3 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JU6.values().length];
            try {
                iArr[JU6.StoryContentType_Photo.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JU6.StoryContentType_Video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JU6.StoryContentType_Text.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JU6.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnumC14144hQ6 a(JU6 ju6) {
        AbstractC13042fc3.i(ju6, "input");
        int i = a.a[ju6.ordinal()];
        if (i == 1) {
            return EnumC14144hQ6.a;
        }
        if (i == 2) {
            return EnumC14144hQ6.b;
        }
        if (i == 3) {
            return EnumC14144hQ6.c;
        }
        if (i == 4) {
            return EnumC14144hQ6.d;
        }
        throw new NoWhenBranchMatchedException();
    }
}
