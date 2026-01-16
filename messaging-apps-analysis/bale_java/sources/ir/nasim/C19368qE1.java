package ir.nasim;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import ir.nasim.C16675lg5;

/* renamed from: ir.nasim.qE1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19368qE1 implements C16675lg5.e {
    private final PendingIntent a;

    public C19368qE1(PendingIntent pendingIntent) {
        this.a = pendingIntent;
    }

    @Override // ir.nasim.C16675lg5.e
    public PendingIntent a(com.google.android.exoplayer2.z0 z0Var) {
        return this.a;
    }

    @Override // ir.nasim.C16675lg5.e
    public CharSequence b(com.google.android.exoplayer2.z0 z0Var) {
        if (!z0Var.K(18)) {
            return "";
        }
        CharSequence charSequence = z0Var.A0().e;
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        CharSequence charSequence2 = z0Var.A0().a;
        return charSequence2 != null ? charSequence2 : "";
    }

    @Override // ir.nasim.C16675lg5.e
    public CharSequence c(com.google.android.exoplayer2.z0 z0Var) {
        if (!z0Var.K(18)) {
            return null;
        }
        CharSequence charSequence = z0Var.A0().b;
        return !TextUtils.isEmpty(charSequence) ? charSequence : z0Var.A0().d;
    }

    @Override // ir.nasim.C16675lg5.e
    public Bitmap e(com.google.android.exoplayer2.z0 z0Var, C16675lg5.b bVar) {
        byte[] bArr;
        if (z0Var.K(18) && (bArr = z0Var.A0().j) != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }
}
