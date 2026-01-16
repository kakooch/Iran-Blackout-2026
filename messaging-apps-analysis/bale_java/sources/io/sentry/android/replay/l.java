package io.sentry.android.replay;

import ir.nasim.AbstractC13042fc3;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class l {
    private volatile m a = m.INITIAL;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[m.values().length];
            try {
                iArr[m.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[m.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[m.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[m.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[m.STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[m.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public final m a() {
        return this.a;
    }

    public final boolean b(m mVar) {
        AbstractC13042fc3.i(mVar, "newState");
        switch (a.a[this.a.ordinal()]) {
            case 1:
                if (mVar == m.STARTED || mVar == m.CLOSED) {
                    return true;
                }
                break;
            case 2:
                if (mVar == m.PAUSED || mVar == m.STOPPED || mVar == m.CLOSED) {
                    return true;
                }
                break;
            case 3:
                if (mVar == m.PAUSED || mVar == m.STOPPED || mVar == m.CLOSED) {
                    return true;
                }
                break;
            case 4:
                if (mVar == m.RESUMED || mVar == m.STOPPED || mVar == m.CLOSED) {
                    return true;
                }
                break;
            case 5:
                if (mVar == m.STARTED || mVar == m.CLOSED) {
                    return true;
                }
                break;
            case 6:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return false;
    }

    public final boolean c() {
        return this.a == m.STARTED || this.a == m.RESUMED;
    }

    public final void d(m mVar) {
        AbstractC13042fc3.i(mVar, "<set-?>");
        this.a = mVar;
    }
}
