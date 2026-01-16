package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import ir.nasim.AbstractC10360bX0;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.zh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3023zh implements Ma {
    public final Context a;
    public final Oe b;
    public final Lh c;
    public final Handler d;
    public final Nk e;
    public final C2516ec f;
    public final LinkedHashMap g;
    public final Am h;
    public final List i;
    public Ub j;

    public C3023zh(Context context, Oe oe, Lh lh, Handler handler, Nk nk) {
        this.a = context;
        this.b = oe;
        this.c = lh;
        this.d = handler;
        this.e = nk;
        this.f = new C2516ec(context, this, oe, lh, nk);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new Am(new Bh(linkedHashMap));
        this.i = AbstractC10360bX0.p("20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72");
    }

    @Override // io.appmetrica.analytics.impl.Ma, io.appmetrica.analytics.impl.Na
    public final Ma a() {
        return this;
    }

    public final C3023zh b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ma
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final synchronized Ub a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        Ub ub;
        try {
            ub = this.j;
            if (ub == null) {
                this.h.a(appMetricaConfig.apiKey);
                ub = new Ub(this.f);
                ub.i = new C2539fb(this.d, ub);
                Nk nk = this.e;
                Wg wg = ub.b;
                if (nk != null) {
                    wg.b.setUuid(nk.g());
                } else {
                    wg.getClass();
                }
                this.f.a(appMetricaConfig, publicLogger);
                ub.a(appMetricaConfig, z);
                ub.k();
                this.c.f.c = new C2999yh(ub);
                this.g.put(appMetricaConfig.apiKey, ub);
                this.j = ub;
            }
        } finally {
        }
        return ub;
    }

    @Override // io.appmetrica.analytics.impl.Ma
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final synchronized Ub b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        Ub ub;
        try {
            ub = this.j;
            if (ub != null) {
                this.f.a(appMetricaConfig, publicLogger);
                ub.a(appMetricaConfig, z);
                C2747o4.g().getClass();
                this.g.put(appMetricaConfig.apiKey, ub);
            } else {
                this.h.a(appMetricaConfig.apiKey);
                ub = new Ub(this.f);
                ub.i = new C2539fb(this.d, ub);
                Nk nk = this.e;
                Wg wg = ub.b;
                if (nk != null) {
                    wg.b.setUuid(nk.g());
                } else {
                    wg.getClass();
                }
                this.f.a(appMetricaConfig, publicLogger);
                ub.a(appMetricaConfig, z);
                ub.k();
                this.c.f.c = new C2999yh(ub);
                this.g.put(appMetricaConfig.apiKey, ub);
                C2747o4.g().getClass();
                this.j = ub;
            }
        } catch (Throwable th) {
            throw th;
        }
        return ub;
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final synchronized void a(ReporterConfig reporterConfig) {
        try {
            if (this.g.containsKey(reporterConfig.apiKey)) {
                LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", reporterConfig.apiKey);
            } else {
                b(reporterConfig);
                ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final synchronized La b(ReporterConfig reporterConfig) {
        La la;
        try {
            la = (La) this.g.get(reporterConfig.apiKey);
            if (la == null) {
                if (!this.i.contains(reporterConfig.apiKey)) {
                    this.e.i();
                }
                Context context = this.a;
                C2588hc c2588hc = new C2588hc(context, this.b, reporterConfig, this.c, new G9(context));
                c2588hc.i = new C2539fb(this.d, c2588hc);
                Nk nk = this.e;
                Wg wg = c2588hc.b;
                if (nk != null) {
                    wg.b.setUuid(nk.g());
                } else {
                    wg.getClass();
                }
                c2588hc.k();
                this.g.put(reporterConfig.apiKey, c2588hc);
                la = c2588hc;
            }
        } catch (Throwable th) {
            throw th;
        }
        return la;
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final synchronized Oa b(AppMetricaConfig appMetricaConfig) {
        Q2 c2677l6;
        try {
            c2677l6 = this.j;
            if (c2677l6 == null) {
                Context context = this.a;
                c2677l6 = new C2677l6(context, this.b, appMetricaConfig, this.c, new G9(context));
                c2677l6.i = new C2539fb(this.d, c2677l6);
                Nk nk = this.e;
                Wg wg = c2677l6.b;
                if (nk != null) {
                    wg.b.setUuid(nk.g());
                } else {
                    wg.getClass();
                }
                c2677l6.b(appMetricaConfig.errorEnvironment);
                c2677l6.k();
            }
        } catch (Throwable th) {
            throw th;
        }
        return c2677l6;
    }
}
