package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public final class Cg extends O5 {
    public boolean d;
    public Location e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public Boolean k;
    public InterfaceC3022zg l;
    public final Bg m;
    public String n;
    public boolean o;
    public boolean p;
    public String q;
    public List r;
    public int s;
    public long t;
    public long u;
    public boolean v;
    public long w;
    public List x;

    public Cg(C2484d5 c2484d5) {
        this.m = c2484d5;
    }

    public final void a(Location location) {
        this.e = location;
    }

    public final void b(List<String> list) {
        this.r = list;
    }

    public final String c() {
        return this.n;
    }

    public final void d(boolean z) {
        this.d = z;
    }

    public final void e(boolean z) {
        this.i = z;
    }

    public final void f(boolean z) {
        this.o = z;
    }

    public final String g() {
        return (String) WrapUtils.getOrDefault(this.q, "");
    }

    public final boolean h() {
        return this.l.a(this.k);
    }

    public final int i() {
        return this.h;
    }

    public final Location j() {
        return this.e;
    }

    public final long k() {
        return this.w;
    }

    public final int l() {
        return this.j;
    }

    public final long m() {
        return this.t;
    }

    public final long n() {
        return this.u;
    }

    public final List<String> o() {
        return this.r;
    }

    public final int p() {
        return this.g;
    }

    public final boolean q() {
        return this.p;
    }

    public final boolean r() {
        return this.f;
    }

    public final boolean s() {
        return this.d;
    }

    public final boolean t() {
        return this.o;
    }

    @Override // io.appmetrica.analytics.impl.O5, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig
    public final String toString() {
        return "ReportRequestConfig{mLocationTracking=" + this.d + ", mManualLocation=" + this.e + ", mFirstActivationAsUpdate=" + this.f + ", mSessionTimeout=" + this.g + ", mDispatchPeriod=" + this.h + ", mLogEnabled=" + this.i + ", mMaxReportsCount=" + this.j + ", dataSendingEnabledFromArguments=" + this.k + ", dataSendingStrategy=" + this.l + ", mPreloadInfoSendingStrategy=" + this.m + ", mApiKey='" + this.n + "', mPermissionsCollectingEnabled=" + this.o + ", mFeaturesCollectingEnabled=" + this.p + ", mClidsFromStartupResponse='" + this.q + "', mReportHosts=" + this.r + ", mAttributionId=" + this.s + ", mPermissionsCollectingIntervalSeconds=" + this.t + ", mPermissionsForceSendIntervalSeconds=" + this.u + ", mClidsFromClientMatchClidsFromStartupRequest=" + this.v + ", mMaxReportsInDbCount=" + this.w + ", mCertificates=" + this.x + "} " + super.toString();
    }

    public final boolean u() {
        return isIdentifiersValid() && !hn.a((Collection) this.r) && this.v;
    }

    public final boolean v() {
        return ((C2484d5) this.m).B();
    }

    public final void a(int i) {
        this.s = i;
    }

    public final void b(long j) {
        this.t = j;
    }

    public final void c(long j) {
        this.u = j;
    }

    public final void d(int i) {
        this.g = i;
    }

    public final List<String> e() {
        return this.x;
    }

    public final boolean f() {
        return this.v;
    }

    public final void a(long j) {
        this.w = j;
    }

    public final void b(boolean z) {
        this.p = z;
    }

    public final void c(boolean z) {
        this.f = z;
    }

    public final int d() {
        return this.s;
    }

    public final void a(List<String> list) {
        this.x = list;
    }

    public final void b(int i) {
        this.h = i;
    }

    public final void c(int i) {
        this.j = i;
    }

    public final void a(Boolean bool, InterfaceC3022zg interfaceC3022zg) {
        this.k = bool;
        this.l = interfaceC3022zg;
    }

    public final void a(boolean z) {
        this.v = z;
    }
}
