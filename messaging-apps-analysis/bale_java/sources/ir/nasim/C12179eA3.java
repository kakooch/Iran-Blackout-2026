package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.eA3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12179eA3 implements InterfaceC10156bA3 {
    private final String a;
    private final ExPeer b;

    public C12179eA3(String str) {
        AbstractC13042fc3.i(str, "link");
        this.a = str;
    }

    @Override // ir.nasim.InterfaceC10156bA3
    public Object a(Context context, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        if ((context instanceof Activity ? (Activity) context : null) != null) {
            AbstractC6392Nk0.a(C18987pb3.a.k0(new Intent("android.intent.action.VIEW").setData(Uri.parse(this.a)), (Activity) context));
        } else {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            Uri uri = Uri.parse(this.a);
            AbstractC13042fc3.h(uri, "parse(...)");
            aVar.B(uri);
        }
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC10156bA3
    public ExPeer c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C12179eA3) && AbstractC13042fc3.d(this.a, ((C12179eA3) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "OpenDeepLink(link=" + this.a + Separators.RPAREN;
    }
}
