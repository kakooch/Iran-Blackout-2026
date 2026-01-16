package ir.nasim;

import android.content.Context;
import android.graphics.PointF;
import android.media.Image;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzf;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.oj8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18481oj8 extends Yu8 {
    private final zzf i;

    public C18481oj8(Context context, zzf zzfVar) {
        super(context, "FaceNativeHandle", "face");
        this.i = zzfVar;
        e();
    }

    private static C18435of2 f(FaceParcel faceParcel) {
        C9155Ys3[] c9155Ys3Arr;
        C23939xm1[] c23939xm1Arr;
        int i = faceParcel.b;
        PointF pointF = new PointF(faceParcel.c, faceParcel.d);
        float f = faceParcel.e;
        float f2 = faceParcel.f;
        float f3 = faceParcel.g;
        float f4 = faceParcel.h;
        float f5 = faceParcel.i;
        LandmarkParcel[] landmarkParcelArr = faceParcel.j;
        if (landmarkParcelArr == null) {
            c9155Ys3Arr = new C9155Ys3[0];
        } else {
            C9155Ys3[] c9155Ys3Arr2 = new C9155Ys3[landmarkParcelArr.length];
            int i2 = 0;
            while (i2 < landmarkParcelArr.length) {
                LandmarkParcel landmarkParcel = landmarkParcelArr[i2];
                c9155Ys3Arr2[i2] = new C9155Ys3(new PointF(landmarkParcel.b, landmarkParcel.c), landmarkParcel.d);
                i2++;
                landmarkParcelArr = landmarkParcelArr;
            }
            c9155Ys3Arr = c9155Ys3Arr2;
        }
        zza[] zzaVarArr = faceParcel.n;
        if (zzaVarArr == null) {
            c23939xm1Arr = new C23939xm1[0];
        } else {
            C23939xm1[] c23939xm1Arr2 = new C23939xm1[zzaVarArr.length];
            for (int i3 = 0; i3 < zzaVarArr.length; i3++) {
                zza zzaVar = zzaVarArr[i3];
                c23939xm1Arr2[i3] = new C23939xm1(zzaVar.a, zzaVar.b);
            }
            c23939xm1Arr = c23939xm1Arr2;
        }
        return new C18435of2(i, pointF, f, f2, f3, f4, f5, c9155Ys3Arr, c23939xm1Arr, faceParcel.k, faceParcel.l, faceParcel.m, faceParcel.o);
    }

    @Override // ir.nasim.Yu8
    protected final /* synthetic */ Object a(DynamiteModule dynamiteModule, Context context) {
        Op8 op8B2 = AbstractC14448hv8.a(context, "com.google.android.gms.vision.dynamite.face") ? Nr8.B2(dynamiteModule.d("com.google.android.gms.vision.face.NativeFaceDetectorV2Creator")) : Nr8.B2(dynamiteModule.d("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"));
        if (op8B2 == null) {
            return null;
        }
        return op8B2.Y(CG4.E2(context), (zzf) AbstractC3795Cj5.j(this.i));
    }

    @Override // ir.nasim.Yu8
    protected final void b() {
        ((Oo8) AbstractC3795Cj5.j((Oo8) e())).zza();
    }

    public final C18435of2[] g(ByteBuffer byteBuffer, zzs zzsVar) {
        if (!c()) {
            return new C18435of2[0];
        }
        try {
            FaceParcel[] faceParcelArrU0 = ((Oo8) AbstractC3795Cj5.j((Oo8) e())).u0(CG4.E2(byteBuffer), zzsVar);
            C18435of2[] c18435of2Arr = new C18435of2[faceParcelArrU0.length];
            for (int i = 0; i < faceParcelArrU0.length; i++) {
                c18435of2Arr[i] = f(faceParcelArrU0[i]);
            }
            return c18435of2Arr;
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return new C18435of2[0];
        }
    }

    public final C18435of2[] h(Image.Plane[] planeArr, zzs zzsVar) {
        if (!c()) {
            Log.e("FaceNativeHandle", "Native handle is not ready to be used.");
            return new C18435of2[0];
        }
        if (planeArr != null && planeArr.length != 3) {
            throw new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
        }
        try {
            FaceParcel[] faceParcelArrB1 = ((Oo8) AbstractC3795Cj5.j((Oo8) e())).b1(CG4.E2(planeArr[0].getBuffer()), CG4.E2(planeArr[1].getBuffer()), CG4.E2(planeArr[2].getBuffer()), planeArr[0].getPixelStride(), planeArr[1].getPixelStride(), planeArr[2].getPixelStride(), planeArr[0].getRowStride(), planeArr[1].getRowStride(), planeArr[2].getRowStride(), zzsVar);
            C18435of2[] c18435of2Arr = new C18435of2[faceParcelArrB1.length];
            for (int i = 0; i < faceParcelArrB1.length; i++) {
                c18435of2Arr[i] = f(faceParcelArrB1[i]);
            }
            return c18435of2Arr;
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return new C18435of2[0];
        }
    }
}
