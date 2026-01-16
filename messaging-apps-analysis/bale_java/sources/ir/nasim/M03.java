package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.internal.utils.ImageUtil;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class M03 implements InterfaceC15888kL4 {
    @Override // ir.nasim.InterfaceC15888kL4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap apply(PS4 ps4) throws Throwable {
        androidx.camera.core.i iVar;
        Bitmap bitmapI;
        androidx.camera.core.i iVar2 = null;
        try {
            try {
                if (ps4.e() == 35) {
                    androidx.camera.core.f fVar = (androidx.camera.core.f) ps4.c();
                    boolean z = ps4.f() % SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER != 0;
                    iVar = new androidx.camera.core.i(androidx.camera.core.g.a(z ? fVar.getHeight() : fVar.getWidth(), z ? fVar.getWidth() : fVar.getHeight(), 1, 2));
                    try {
                        androidx.camera.core.f fVarD = ImageProcessingUtil.d(fVar, iVar, ByteBuffer.allocateDirect(fVar.getWidth() * fVar.getHeight() * 4), ps4.f(), false);
                        fVar.close();
                        if (fVarD == null) {
                            throw new ImageCaptureException(0, "Can't covert YUV to RGB", null);
                        }
                        bitmapI = ImageUtil.a(fVarD);
                        fVarD.close();
                    } catch (UnsupportedOperationException e) {
                        e = e;
                        throw new ImageCaptureException(0, "Can't convert " + (ps4.e() == 35 ? "YUV" : "JPEG") + " to bitmap", e);
                    } catch (Throwable th) {
                        th = th;
                        iVar2 = iVar;
                        if (iVar2 != null) {
                            iVar2.close();
                        }
                        throw th;
                    }
                } else {
                    if (ps4.e() != 256) {
                        throw new IllegalArgumentException("Invalid postview image format : " + ps4.e());
                    }
                    androidx.camera.core.f fVar2 = (androidx.camera.core.f) ps4.c();
                    Bitmap bitmapA = ImageUtil.a(fVar2);
                    fVar2.close();
                    iVar = null;
                    bitmapI = ImageUtil.i(bitmapA, ps4.f());
                }
                if (iVar != null) {
                    iVar.close();
                }
                return bitmapI;
            } catch (UnsupportedOperationException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
