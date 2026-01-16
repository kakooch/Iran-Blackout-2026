package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Sf6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7559Sf6 implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.Sf6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC7325Rf6.values().length];
            try {
                iArr[EnumC7325Rf6.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC7325Rf6.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC7325Rf6.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC7325Rf6.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC7325Rf6.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnumC11822dc4 a(EnumC7325Rf6 enumC7325Rf6) {
        AbstractC13042fc3.i(enumC7325Rf6, "input");
        int i = a.a[enumC7325Rf6.ordinal()];
        if (i == 1) {
            return EnumC11822dc4.MessageContentType_DOCUMENT;
        }
        if (i == 2) {
            return EnumC11822dc4.MessageContentType_DOCUMENT_PHOTO;
        }
        if (i == 3) {
            return EnumC11822dc4.MessageContentType_DOCUMENT_VIDEO;
        }
        if (i == 4) {
            return EnumC11822dc4.MessageContentType_DOCUMENT_AUDIO;
        }
        if (i == 5) {
            return EnumC11822dc4.MessageContentType_DOCUMENT_VOICE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
