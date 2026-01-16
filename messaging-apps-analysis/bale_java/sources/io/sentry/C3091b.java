package io.sentry;

import java.util.concurrent.Callable;

/* renamed from: io.sentry.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3091b {
    private byte[] a;
    private final A0 b;
    private final Callable c;
    private String d;
    private final String e;
    private final String f;
    private final boolean g;
    private String h;

    public C3091b(byte[] bArr, String str, String str2, boolean z) {
        this(bArr, str, str2, "event.attachment", z);
    }

    public static C3091b a(Callable callable, String str, String str2, boolean z) {
        return new C3091b(callable, str, str2, "event.attachment", z);
    }

    public static C3091b b(byte[] bArr) {
        return new C3091b(bArr, "thread-dump.txt", "text/plain", false);
    }

    public static C3091b c(io.sentry.protocol.H h) {
        return new C3091b((A0) h, "view-hierarchy.json", "application/json", "event.view_hierarchy", false);
    }

    public String d() {
        return this.h;
    }

    public Callable e() {
        return this.c;
    }

    public byte[] f() {
        return this.a;
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.e;
    }

    public String i() {
        return this.d;
    }

    public A0 j() {
        return this.b;
    }

    boolean k() {
        return this.g;
    }

    public C3091b(byte[] bArr, String str, String str2, String str3, boolean z) {
        this.a = bArr;
        this.b = null;
        this.c = null;
        this.e = str;
        this.f = str2;
        this.h = str3;
        this.g = z;
    }

    public C3091b(A0 a0, String str, String str2, String str3, boolean z) {
        this.a = null;
        this.b = a0;
        this.c = null;
        this.e = str;
        this.f = str2;
        this.h = str3;
        this.g = z;
    }

    public C3091b(Callable callable, String str, String str2, String str3, boolean z) {
        this.a = null;
        this.b = null;
        this.c = callable;
        this.e = str;
        this.f = str2;
        this.h = str3;
        this.g = z;
    }
}
