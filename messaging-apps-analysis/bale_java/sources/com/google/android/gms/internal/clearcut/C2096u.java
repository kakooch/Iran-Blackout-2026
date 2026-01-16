package com.google.android.gms.internal.clearcut;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.InterfaceC20302rm8;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.clearcut.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2096u extends AbstractC2095t {
    C2096u() {
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2095t
    final int a(Map.Entry entry) {
        AbstractC18350oW3.a(entry.getKey());
        throw null;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2095t
    final AbstractC2099x b(Object obj) {
        AbstractC18350oW3.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2095t
    final void c(v0 v0Var, Map.Entry entry) {
        AbstractC18350oW3.a(entry.getKey());
        int[] iArr = AbstractC2097v.a;
        throw null;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2095t
    final void d(Object obj, AbstractC2099x abstractC2099x) {
        AbstractC18350oW3.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2095t
    final AbstractC2099x e(Object obj) {
        AbstractC2099x abstractC2099xB = b(obj);
        if (!abstractC2099xB.c()) {
            return abstractC2099xB;
        }
        AbstractC2099x abstractC2099x = (AbstractC2099x) abstractC2099xB.clone();
        d(obj, abstractC2099x);
        return abstractC2099x;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2095t
    final void f(Object obj) {
        b(obj).i();
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2095t
    final boolean g(InterfaceC20302rm8 interfaceC20302rm8) {
        return false;
    }
}
