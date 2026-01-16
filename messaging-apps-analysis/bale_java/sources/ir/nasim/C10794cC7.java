package ir.nasim;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;

/* renamed from: ir.nasim.cC7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10794cC7 implements ComposeAnimation {
    public static final a e = new a(null);
    public static final int f = 8;
    private static boolean g;
    private final String a;
    private final ComposeAnimationType b;
    private final Object c;
    private final Set d;

    /* renamed from: ir.nasim.cC7$a */
    public static final class a {
        private a() {
        }

        public final C10794cC7 a(String str) {
            ED1 ed1 = null;
            if (b()) {
                return new C10794cC7(str, ed1);
            }
            return null;
        }

        public final boolean b() {
            return C10794cC7.g;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        ComposeAnimationType[] composeAnimationTypeArrValues = ComposeAnimationType.values();
        int length = composeAnimationTypeArrValues.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (AbstractC13042fc3.d(composeAnimationTypeArrValues[i].name(), "UNSUPPORTED")) {
                z = true;
                break;
            }
            i++;
        }
        g = z;
    }

    public /* synthetic */ C10794cC7(String str, ED1 ed1) {
        this(str);
    }

    private C10794cC7(String str) {
        this.a = str;
        this.b = ComposeAnimationType.UNSUPPORTED;
        this.c = 0;
        this.d = AbstractC4597Fu6.d();
    }
}
