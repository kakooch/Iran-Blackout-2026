package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.face.internal.client.zzf;
import java.nio.ByteBuffer;
import java.util.HashSet;

/* renamed from: ir.nasim.pf2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19026pf2 extends EJ1 {
    private final Pk8 b;
    private final C18481oj8 c;
    private final Object d;
    private boolean e;

    /* renamed from: ir.nasim.pf2$a */
    public static class a {
        private final Context a;
        private int b = 0;
        private boolean c = false;
        private int d = 0;
        private boolean e = true;
        private int f = 0;
        private float g = -1.0f;

        public a(Context context) {
            this.a = context;
        }

        public C19026pf2 a() {
            zzf zzfVar = new zzf();
            zzfVar.a = this.f;
            zzfVar.b = this.b;
            zzfVar.c = this.d;
            zzfVar.d = this.c;
            zzfVar.e = this.e;
            zzfVar.f = this.g;
            if (C19026pf2.e(zzfVar)) {
                return new C19026pf2(new C18481oj8(this.a, zzfVar));
            }
            throw new IllegalArgumentException("Invalid build options");
        }

        public a b(int i) {
            if (i == 0 || i == 1 || i == 2) {
                this.b = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid landmark type: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public a c(int i) {
            if (i == 0 || i == 1 || i == 2) {
                this.f = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(25);
            sb.append("Invalid mode: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public a d(boolean z) {
            this.e = z;
            return this;
        }
    }

    private C19026pf2(C18481oj8 c18481oj8) {
        this.b = new Pk8();
        this.d = new Object();
        this.e = true;
        this.c = c18481oj8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(zzf zzfVar) {
        boolean z;
        if (zzfVar.a == 2 || zzfVar.b != 2) {
            z = true;
        } else {
            Log.e("FaceDetector", "Contour is not supported for non-SELFIE mode.");
            z = false;
        }
        if (zzfVar.b != 2 || zzfVar.c != 1) {
            return z;
        }
        Log.e("FaceDetector", "Classification is not supported with contour.");
        return false;
    }

    @Override // ir.nasim.EJ1
    public final void a() {
        super.a();
        synchronized (this.d) {
            try {
                if (this.e) {
                    this.c.d();
                    this.e = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final SparseArray b(C7501Rz2 c7501Rz2) {
        C18435of2[] c18435of2ArrG;
        if (c7501Rz2 == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        if (c7501Rz2.d() == null || ((Image.Plane[]) AbstractC3795Cj5.j(c7501Rz2.d())).length != 3) {
            ByteBuffer byteBufferA = c7501Rz2.a() != null ? xv8.a((Bitmap) AbstractC3795Cj5.j(c7501Rz2.a()), true) : c7501Rz2.b();
            synchronized (this.d) {
                if (!this.e) {
                    throw new IllegalStateException("Cannot use detector after release()");
                }
                c18435of2ArrG = this.c.g((ByteBuffer) AbstractC3795Cj5.j(byteBufferA), zzs.P(c7501Rz2));
            }
        } else {
            synchronized (this.d) {
                try {
                    if (!this.e) {
                        throw new IllegalStateException("Cannot use detector after release()");
                    }
                    c18435of2ArrG = this.c.h((Image.Plane[]) AbstractC3795Cj5.j(c7501Rz2.d()), zzs.P(c7501Rz2));
                } finally {
                }
            }
        }
        HashSet hashSet = new HashSet();
        SparseArray sparseArray = new SparseArray(c18435of2ArrG.length);
        int iMax = 0;
        for (C18435of2 c18435of2 : c18435of2ArrG) {
            int iA = c18435of2.a();
            iMax = Math.max(iMax, iA);
            if (hashSet.contains(Integer.valueOf(iA))) {
                iA = iMax + 1;
                iMax = iA;
            }
            hashSet.add(Integer.valueOf(iA));
            sparseArray.append(this.b.a(iA), c18435of2);
        }
        return sparseArray;
    }

    public final boolean c() {
        return this.c.c();
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this.d) {
                try {
                    if (this.e) {
                        Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                        a();
                    }
                } finally {
                }
            }
        } finally {
            super.finalize();
        }
    }
}
