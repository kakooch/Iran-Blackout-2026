package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new g();
    String a;
    private GoogleSignInAccount b;
    String c;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.b = googleSignInAccount;
        this.a = AbstractC3795Cj5.g(str, "8.3 and 8.4 SDKs require non-null email");
        this.c = AbstractC3795Cj5.g(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount P() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 4, this.a, false);
        AbstractC21804u96.s(parcel, 7, this.b, i, false);
        AbstractC21804u96.t(parcel, 8, this.c, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
