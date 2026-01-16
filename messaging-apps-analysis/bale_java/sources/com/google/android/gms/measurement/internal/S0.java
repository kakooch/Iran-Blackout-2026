package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.Ap8;
import ir.nasim.Bt8;
import ir.nasim.C11384cu8;
import ir.nasim.C13254fu8;
import ir.nasim.C15045iu8;
import ir.nasim.C15626jt8;
import ir.nasim.C17399mt8;
import ir.nasim.C18541op8;
import ir.nasim.C19172pt8;
import ir.nasim.C20963st8;
import ir.nasim.C22836vt8;
import ir.nasim.C24606yt8;
import ir.nasim.Cs8;
import ir.nasim.Et8;
import ir.nasim.Fs8;
import ir.nasim.Is8;
import ir.nasim.Ls8;
import ir.nasim.Os8;
import ir.nasim.Rs8;
import ir.nasim.Tt8;
import ir.nasim.Us8;
import ir.nasim.Wt8;
import ir.nasim.Zt8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class S0 {
    public static final R0 A;
    public static final R0 B;
    public static final R0 C;
    public static final R0 D;
    public static final R0 E;
    public static final R0 F;
    public static final R0 G;
    public static final R0 H;
    public static final R0 I;
    public static final R0 J;
    public static final R0 K;
    public static final R0 L;
    public static final R0 M;
    public static final R0 N;
    public static final R0 O;
    public static final R0 P;
    public static final R0 Q;
    public static final R0 R;
    public static final R0 S;
    public static final R0 T;
    public static final R0 U;
    public static final R0 V;
    public static final R0 W;
    public static final R0 X;
    public static final R0 Y;
    public static final R0 Z;
    public static final R0 a0;
    public static final R0 b0;
    public static final R0 c0;
    public static final R0 d0;
    public static final R0 e0;
    public static final R0 f0;
    public static final R0 g0;
    public static final R0 h0;
    public static final R0 i0;
    public static final R0 j0;
    public static final R0 k;
    public static final R0 k0;
    public static final R0 l;
    public static final R0 l0;
    public static final R0 m;
    public static final R0 m0;
    public static final R0 n;
    public static final R0 n0;
    public static final R0 o;
    public static final R0 o0;
    public static final R0 p;
    public static final R0 p0;
    public static final R0 q;
    public static final R0 q0;
    public static final R0 r;
    public static final R0 r0;
    public static final R0 s;
    public static final R0 s0;
    public static final R0 t;
    public static final R0 t0;
    public static final R0 u;
    public static final R0 u0;
    public static final R0 v;
    public static final R0 v0;
    public static final R0 w;
    public static final R0 w0;
    public static final R0 x;
    public static final R0 y;
    public static final R0 z;
    private static final List a = Collections.synchronizedList(new ArrayList());
    private static final Set b = Collections.synchronizedSet(new HashSet());
    public static final R0 c = a("measurement.ad_id_cache_time", 10000L, 10000L, new P0() { // from class: com.google.android.gms.measurement.internal.F
        @Override // com.google.android.gms.measurement.internal.P0
        public final Object zza() {
            R0 r02 = S0.c;
            return Long.valueOf(Is8.m());
        }
    });
    public static final R0 d = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, new P0() { // from class: com.google.android.gms.measurement.internal.x
        @Override // com.google.android.gms.measurement.internal.P0
        public final Object zza() {
            R0 r02 = S0.c;
            return Long.valueOf(Is8.w());
        }
    });
    public static final R0 e = a("measurement.config.cache_time", 86400000L, 3600000L, new P0() { // from class: com.google.android.gms.measurement.internal.J
        @Override // com.google.android.gms.measurement.internal.P0
        public final Object zza() {
            R0 r02 = S0.c;
            return Long.valueOf(Is8.o());
        }
    });
    public static final R0 f = a("measurement.config.url_scheme", "https", "https", new P0() { // from class: com.google.android.gms.measurement.internal.W
        @Override // com.google.android.gms.measurement.internal.P0
        public final Object zza() {
            R0 r02 = S0.c;
            return Is8.k();
        }
    });
    public static final R0 g = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", new P0() { // from class: com.google.android.gms.measurement.internal.j0
        @Override // com.google.android.gms.measurement.internal.P0
        public final Object zza() {
            R0 r02 = S0.c;
            return Is8.j();
        }
    });
    public static final R0 h = a("measurement.upload.max_bundles", 100, 100, new P0() { // from class: com.google.android.gms.measurement.internal.v0
        @Override // com.google.android.gms.measurement.internal.P0
        public final Object zza() {
            R0 r02 = S0.c;
            return Integer.valueOf((int) Is8.H());
        }
    });
    public static final R0 i = a("measurement.upload.max_batch_size", 65536, 65536, new P0() { // from class: com.google.android.gms.measurement.internal.H0
        @Override // com.google.android.gms.measurement.internal.P0
        public final Object zza() {
            R0 r02 = S0.c;
            return Integer.valueOf((int) Is8.e());
        }
    });
    public static final R0 j = a("measurement.upload.max_bundle_size", 65536, 65536, new P0() { // from class: com.google.android.gms.measurement.internal.I0
        @Override // com.google.android.gms.measurement.internal.P0
        public final Object zza() {
            R0 r02 = S0.c;
            return Integer.valueOf((int) Is8.G());
        }
    });

    static {
        Integer numValueOf = Integer.valueOf(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        k = a("measurement.upload.max_events_per_bundle", numValueOf, numValueOf, new P0() { // from class: com.google.android.gms.measurement.internal.J0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.K());
            }
        });
        l = a("measurement.upload.max_events_per_day", 100000, 100000, new P0() { // from class: com.google.android.gms.measurement.internal.K0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.a());
            }
        });
        m = a("measurement.upload.max_error_events_per_day", numValueOf, numValueOf, new P0() { // from class: com.google.android.gms.measurement.internal.Q
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.J());
            }
        });
        n = a("measurement.upload.max_public_events_per_day", 50000, 50000, new P0() { // from class: com.google.android.gms.measurement.internal.d0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.b());
            }
        });
        Integer numValueOf2 = Integer.valueOf(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND);
        o = a("measurement.upload.max_conversions_per_day", numValueOf2, numValueOf2, new P0() { // from class: com.google.android.gms.measurement.internal.o0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.I());
            }
        });
        p = a("measurement.upload.max_realtime_events_per_day", 10, 10, new P0() { // from class: com.google.android.gms.measurement.internal.A0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.d());
            }
        });
        q = a("measurement.store.max_stored_events_per_app", 100000, 100000, new P0() { // from class: com.google.android.gms.measurement.internal.L0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.r());
            }
        });
        r = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", new P0() { // from class: com.google.android.gms.measurement.internal.M0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Is8.l();
            }
        });
        s = a("measurement.upload.backoff_period", 43200000L, 43200000L, new P0() { // from class: com.google.android.gms.measurement.internal.N0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.D());
            }
        });
        t = a("measurement.upload.window_interval", 3600000L, 3600000L, new P0() { // from class: com.google.android.gms.measurement.internal.O0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.h());
            }
        });
        u = a("measurement.upload.interval", 3600000L, 3600000L, new P0() { // from class: com.google.android.gms.measurement.internal.u
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.F());
            }
        });
        v = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, new P0() { // from class: com.google.android.gms.measurement.internal.w
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.x());
            }
        });
        w = a("measurement.upload.debug_upload_interval", 1000L, 1000L, new P0() { // from class: com.google.android.gms.measurement.internal.y
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.p());
            }
        });
        x = a("measurement.upload.minimum_delay", 500L, 500L, new P0() { // from class: com.google.android.gms.measurement.internal.z
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.v());
            }
        });
        y = a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, new P0() { // from class: com.google.android.gms.measurement.internal.A
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.u());
            }
        });
        z = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, new P0() { // from class: com.google.android.gms.measurement.internal.B
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.A());
            }
        });
        A = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, new P0() { // from class: com.google.android.gms.measurement.internal.C
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.y());
            }
        });
        B = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, new P0() { // from class: com.google.android.gms.measurement.internal.D
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.E());
            }
        });
        C = a("measurement.upload.retry_time", 1800000L, 1800000L, new P0() { // from class: com.google.android.gms.measurement.internal.E
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.g());
            }
        });
        D = a("measurement.upload.retry_count", 6, 6, new P0() { // from class: com.google.android.gms.measurement.internal.G
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.f());
            }
        });
        E = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, new P0() { // from class: com.google.android.gms.measurement.internal.H
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.c());
            }
        });
        F = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, new P0() { // from class: com.google.android.gms.measurement.internal.I
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.q());
            }
        });
        G = a("measurement.audience.filter_result_max_count", 200, 200, new P0() { // from class: com.google.android.gms.measurement.internal.K
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.t());
            }
        });
        H = a("measurement.upload.max_public_user_properties", 25, 25, null);
        Integer numValueOf3 = Integer.valueOf(SIPTransactionStack.BASE_TIMER_INTERVAL);
        I = a("measurement.upload.max_event_name_cardinality", numValueOf3, numValueOf3, null);
        J = a("measurement.upload.max_public_event_params", 25, 25, null);
        K = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, new P0() { // from class: com.google.android.gms.measurement.internal.L
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.z());
            }
        });
        Boolean bool = Boolean.FALSE;
        L = a("measurement.test.boolean_flag", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.M
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C24606yt8.f());
            }
        });
        M = a("measurement.test.string_flag", "---", "---", new P0() { // from class: com.google.android.gms.measurement.internal.N
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return C24606yt8.e();
            }
        });
        N = a("measurement.test.long_flag", -1L, -1L, new P0() { // from class: com.google.android.gms.measurement.internal.O
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(C24606yt8.c());
            }
        });
        O = a("measurement.test.int_flag", -2, -2, new P0() { // from class: com.google.android.gms.measurement.internal.P
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) C24606yt8.b());
            }
        });
        Double dValueOf = Double.valueOf(-3.0d);
        P = a("measurement.test.double_flag", dValueOf, dValueOf, new P0() { // from class: com.google.android.gms.measurement.internal.S
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Double.valueOf(C24606yt8.a());
            }
        });
        Q = a("measurement.experiment.max_ids", 50, 50, new P0() { // from class: com.google.android.gms.measurement.internal.T
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.s());
            }
        });
        R = a("measurement.max_bundles_per_iteration", 100, 100, new P0() { // from class: com.google.android.gms.measurement.internal.U
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Is8.n());
            }
        });
        S = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, new P0() { // from class: com.google.android.gms.measurement.internal.V
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.B());
            }
        });
        T = a("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, new P0() { // from class: com.google.android.gms.measurement.internal.Y
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Long.valueOf(Is8.C());
            }
        });
        Boolean bool2 = Boolean.TRUE;
        U = a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.Z
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Bt8.b());
            }
        });
        V = a("measurement.quality.checksum", bool, bool, null);
        W = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.a0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Us8.d());
            }
        });
        X = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.b0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Us8.c());
            }
        });
        Y = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.c0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Us8.e());
            }
        });
        Z = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.e0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C13254fu8.b());
            }
        });
        a0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.f0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C20963st8.b());
            }
        });
        b0 = a("measurement.lifecycle.app_in_background_parameter", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.g0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C22836vt8.b());
            }
        });
        c0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.h0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C11384cu8.c());
            }
        });
        d0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.i0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C15045iu8.b());
            }
        });
        e0 = a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.k0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Rs8.c());
            }
        });
        f0 = a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.l0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C17399mt8.c());
            }
        });
        g0 = a("measurement.collection.synthetic_data_mitigation", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.m0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Zt8.b());
            }
        });
        h0 = a("measurement.service.storage_consent_support_version", 203600, 203600, new P0() { // from class: com.google.android.gms.measurement.internal.n0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Integer.valueOf((int) Ls8.a());
            }
        });
        i0 = a("measurement.client.click_identifier_control.dev", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.p0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Cs8.b());
            }
        });
        j0 = a("measurement.service.click_identifier_control", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.q0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Fs8.b());
            }
        });
        k0 = a("measurement.service.store_null_safelist", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.r0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Os8.c());
            }
        });
        l0 = a("measurement.service.store_safelist", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.s0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Os8.d());
            }
        });
        m0 = a("measurement.collection.enable_session_stitching_token.service", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.t0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Wt8.e());
            }
        });
        n0 = a("measurement.collection.enable_session_stitching_token.service_new", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.u0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Wt8.f());
            }
        });
        o0 = a("measurement.collection.enable_session_stitching_token.client.dev", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.w0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Wt8.c());
            }
        });
        p0 = a("measurement.session_stitching_token_enabled", bool, bool, new P0() { // from class: com.google.android.gms.measurement.internal.x0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Wt8.d());
            }
        });
        q0 = a("measurement.redaction.e_tag", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.z0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Et8.d());
            }
        });
        r0 = a("measurement.redaction.client_ephemeral_aiid_generation", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.B0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Et8.c());
            }
        });
        s0 = a("measurement.redaction.retain_major_os_version", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.C0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Et8.e());
            }
        });
        t0 = a("measurement.redaction.scion_payload_generator", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.D0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Et8.f());
            }
        });
        u0 = a("measurement.audience.dynamic_filters.oob_fix", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.E0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C15626jt8.c());
            }
        });
        v0 = a("measurement.service.clear_global_params_on_uninstall", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.F0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(C19172pt8.c());
            }
        });
        w0 = a("measurement.sessionid.enable_client_session_id", bool2, bool2, new P0() { // from class: com.google.android.gms.measurement.internal.G0
            @Override // com.google.android.gms.measurement.internal.P0
            public final Object zza() {
                R0 r02 = S0.c;
                return Boolean.valueOf(Tt8.c());
            }
        });
    }

    static R0 a(String str, Object obj, Object obj2, P0 p02) {
        R0 r02 = new R0(str, obj, obj2, p02, null);
        a.add(r02);
        return r02;
    }

    public static Map c(Context context) {
        C18541op8 c18541op8B = C18541op8.b(context.getContentResolver(), Ap8.a("com.google.android.gms.measurement"), new Runnable() { // from class: ir.nasim.Si8
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC11344cq8.d();
            }
        });
        return c18541op8B == null ? Collections.emptyMap() : c18541op8B.c();
    }
}
