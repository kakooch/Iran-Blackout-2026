package io.sentry;

/* loaded from: classes3.dex */
public final class Q2 {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private CharSequence g;
    private CharSequence h;
    private CharSequence i;
    private CharSequence j;
    private CharSequence k;
    private CharSequence l;
    private CharSequence m;
    private CharSequence n;
    private CharSequence o;
    private CharSequence p;
    private CharSequence q;
    private Runnable r;
    private Runnable s;
    private a t;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public Q2(a aVar) {
        this.a = false;
        this.b = true;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = "Report a Bug";
        this.h = "Send Bug Report";
        this.i = "Cancel";
        this.j = "Name";
        this.k = "Your Name";
        this.l = "Email";
        this.m = "your.email@example.org";
        this.n = " (Required)";
        this.o = "Description";
        this.p = "What's the bug? What did you expect?";
        this.q = "Thank you for your report!";
        this.t = aVar;
    }

    public void A(boolean z) {
        this.b = z;
    }

    public void B(boolean z) {
        this.e = z;
    }

    public CharSequence a() {
        return this.i;
    }

    public CharSequence b() {
        return this.l;
    }

    public CharSequence c() {
        return this.m;
    }

    public CharSequence d() {
        return this.g;
    }

    public CharSequence e() {
        return this.n;
    }

    public CharSequence f() {
        return this.o;
    }

    public CharSequence g() {
        return this.p;
    }

    public CharSequence h() {
        return this.j;
    }

    public CharSequence i() {
        return this.k;
    }

    public Runnable j() {
        return this.s;
    }

    public Runnable k() {
        return this.r;
    }

    public c l() {
        return null;
    }

    public c m() {
        return null;
    }

    public CharSequence n() {
        return this.h;
    }

    public CharSequence o() {
        return this.q;
    }

    public boolean p() {
        return this.c;
    }

    public boolean q() {
        return this.a;
    }

    public boolean r() {
        return this.f;
    }

    public boolean s() {
        return this.d;
    }

    public boolean t() {
        return this.b;
    }

    public String toString() {
        return "SentryFeedbackOptions{isNameRequired=" + this.a + ", showName=" + this.b + ", isEmailRequired=" + this.c + ", showEmail=" + this.d + ", useSentryUser=" + this.e + ", showBranding=" + this.f + ", formTitle='" + ((Object) this.g) + "', submitButtonLabel='" + ((Object) this.h) + "', cancelButtonLabel='" + ((Object) this.i) + "', nameLabel='" + ((Object) this.j) + "', namePlaceholder='" + ((Object) this.k) + "', emailLabel='" + ((Object) this.l) + "', emailPlaceholder='" + ((Object) this.m) + "', isRequiredLabel='" + ((Object) this.n) + "', messageLabel='" + ((Object) this.o) + "', messagePlaceholder='" + ((Object) this.p) + "'}";
    }

    public boolean u() {
        return this.e;
    }

    public void v(a aVar) {
        this.t = aVar;
    }

    public void w(boolean z) {
        this.c = z;
    }

    public void x(boolean z) {
        this.a = z;
    }

    public void y(boolean z) {
        this.f = z;
    }

    public void z(boolean z) {
        this.d = z;
    }

    public Q2(Q2 q2) {
        this.a = false;
        this.b = true;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = "Report a Bug";
        this.h = "Send Bug Report";
        this.i = "Cancel";
        this.j = "Name";
        this.k = "Your Name";
        this.l = "Email";
        this.m = "your.email@example.org";
        this.n = " (Required)";
        this.o = "Description";
        this.p = "What's the bug? What did you expect?";
        this.q = "Thank you for your report!";
        this.a = q2.a;
        this.b = q2.b;
        this.c = q2.c;
        this.d = q2.d;
        this.e = q2.e;
        this.f = q2.f;
        this.g = q2.g;
        this.h = q2.h;
        this.i = q2.i;
        this.j = q2.j;
        this.k = q2.k;
        this.l = q2.l;
        this.m = q2.m;
        this.n = q2.n;
        this.o = q2.o;
        this.p = q2.p;
        this.q = q2.q;
        this.r = q2.r;
        this.s = q2.s;
        this.t = q2.t;
    }
}
