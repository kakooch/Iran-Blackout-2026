package ir.nasim;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import ir.nasim.C5298It;
import java.util.Set;

/* renamed from: ir.nasim.v63, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22361v63 implements ComposeAnimation {
    public static final a f = new a(null);
    public static final int g = 8;
    private static boolean h;
    private final C5522Jr7 a;
    private final C21097t63 b;
    private final ComposeAnimationType c;
    private final Set d;
    private final String e;

    /* renamed from: ir.nasim.v63$a */
    public static final class a {
        private a() {
        }

        public final boolean a() {
            return C22361v63.h;
        }

        public final C22361v63 b(C5298It.h hVar) {
            ED1 ed1 = null;
            if (a()) {
                return new C22361v63(hVar.b(), hVar.a(), ed1);
            }
            return null;
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
            if (AbstractC13042fc3.d(composeAnimationTypeArrValues[i].name(), "INFINITE_TRANSITION")) {
                z = true;
                break;
            }
            i++;
        }
        h = z;
    }

    public /* synthetic */ C22361v63(C5522Jr7 c5522Jr7, C21097t63 c21097t63, ED1 ed1) {
        this(c5522Jr7, c21097t63);
    }

    public C21097t63 b() {
        return this.b;
    }

    private C22361v63(C5522Jr7 c5522Jr7, C21097t63 c21097t63) {
        this.a = c5522Jr7;
        this.b = c21097t63;
        this.c = ComposeAnimationType.INFINITE_TRANSITION;
        this.d = AbstractC4363Eu6.c(0);
        this.e = b().h();
    }
}
