package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.im2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC14960im2 {

    /* renamed from: ir.nasim.im2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4543Fo6.values().length];
            try {
                iArr[EnumC4543Fo6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC4543Fo6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC4543Fo6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC4543Fo6.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC4543Fo6.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC4543Fo6.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnumC8100Un2 b(EnumC4543Fo6 enumC4543Fo6) {
        switch (a.a[enumC4543Fo6.ordinal()]) {
            case 1:
                return EnumC8100Un2.SendType_UNKNOWN;
            case 2:
                return EnumC8100Un2.SendType_PHOTO;
            case 3:
                return EnumC8100Un2.SendType_VIDEO;
            case 4:
                return EnumC8100Un2.SendType_VOICE;
            case 5:
                return EnumC8100Un2.SendType_AUDIO;
            case 6:
                return EnumC8100Un2.SendType_DOCUMENT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
