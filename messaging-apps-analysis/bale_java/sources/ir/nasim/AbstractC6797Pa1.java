package ir.nasim;

/* renamed from: ir.nasim.Pa1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6797Pa1 {
    public static final int a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(524444915, i, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:213)");
        }
        int iR = interfaceC22053ub1.R();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return iR;
    }

    public static final OJ5 b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(394957799, i, -1, "androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:184)");
        }
        OJ5 oj5Y = interfaceC22053ub1.y();
        if (oj5Y == null) {
            throw new IllegalStateException("no recompose scope found".toString());
        }
        interfaceC22053ub1.b(oj5Y);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return oj5Y;
    }

    public static final void c() {
        throw new IllegalStateException("Invalid applier".toString());
    }

    public static final AbstractC7050Qb1 d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1165786124, i, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:461)");
        }
        AbstractC7050Qb1 abstractC7050Qb1S = interfaceC22053ub1.S();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return abstractC7050Qb1S;
    }
}
