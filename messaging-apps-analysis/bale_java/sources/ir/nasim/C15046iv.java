package ir.nasim;

import ai.bale.proto.KetfOuterClass$ResponseSendInlineCallback;
import ir.nasim.C14439hv;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.iv, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15046iv {
    private final String a;

    /* renamed from: ir.nasim.iv$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC6422Nn3.values().length];
            try {
                iArr[EnumC6422Nn3.Pin.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC6422Nn3.Alert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC6422Nn3.UNRECOGNIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public C15046iv(String str) {
        AbstractC13042fc3.i(str, "title");
        this.a = str;
    }

    private final C14439hv.a a(EnumC6422Nn3 enumC6422Nn3) {
        int i = a.a[enumC6422Nn3.ordinal()];
        if (i == 1) {
            return C14439hv.a.a;
        }
        if (i == 2) {
            return C14439hv.a.b;
        }
        if (i == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final C14439hv b(KetfOuterClass$ResponseSendInlineCallback ketfOuterClass$ResponseSendInlineCallback) {
        AbstractC13042fc3.i(ketfOuterClass$ResponseSendInlineCallback, "obj");
        if (!ketfOuterClass$ResponseSendInlineCallback.hasAnswer()) {
            return null;
        }
        EnumC6422Nn3 type = ketfOuterClass$ResponseSendInlineCallback.getAnswer().getType();
        AbstractC13042fc3.h(type, "getType(...)");
        C14439hv.a aVarA = a(type);
        if (aVarA == null) {
            return null;
        }
        String str = this.a;
        String text = ketfOuterClass$ResponseSendInlineCallback.getAnswer().getText();
        AbstractC13042fc3.h(text, "getText(...)");
        return new C14439hv(str, text, aVarA);
    }
}
