package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C11703dT;

/* renamed from: ir.nasim.gb2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC13649gb2 {
    static final AbstractC13649gb2 a = a().f(10485760).d(200).b(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND).c(604800000).e(81920).a();

    /* renamed from: ir.nasim.gb2$a */
    static abstract class a {
        a() {
        }

        abstract AbstractC13649gb2 a();

        abstract a b(int i);

        abstract a c(long j);

        abstract a d(int i);

        abstract a e(int i);

        abstract a f(long j);
    }

    AbstractC13649gb2() {
    }

    static a a() {
        return new C11703dT.b();
    }

    abstract int b();

    abstract long c();

    abstract int d();

    abstract int e();

    abstract long f();
}
