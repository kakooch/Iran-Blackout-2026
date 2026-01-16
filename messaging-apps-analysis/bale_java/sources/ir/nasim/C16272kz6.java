package ir.nasim;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.C15791kA6;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.features.MainActivity;
import ir.nasim.utils.images.common.ImageLoadException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.kz6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16272kz6 {
    public static final C16272kz6 a = new C16272kz6();

    private C16272kz6() {
    }

    private final void a(C11458d25 c11458d25, String str, Bitmap bitmap, boolean z) {
        C5721Ko c5721Ko = C5721Ko.a;
        int iE = RA6.e(c5721Ko.d());
        ArrayList arrayList = new ArrayList();
        List listD = RA6.d(c5721Ko.d());
        AbstractC13042fc3.h(listD, "getDynamicShortcuts(...)");
        ArrayList arrayList2 = new ArrayList();
        Set setG = AbstractC4597Fu6.g("ir.nasim.SHORTCUT_SHARE");
        Intent intent = new Intent(c5721Ko.d(), (Class<?>) MainActivity.class);
        intent.setAction("ir.nasim.openchat" + c11458d25.u());
        intent.putExtra("peer_type", c11458d25.s().name());
        intent.addFlags(67108864);
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            String strF = ((C15791kA6) it.next()).f();
            AbstractC13042fc3.h(strF, "getId(...)");
            arrayList2.add(strF);
        }
        C5721Ko c5721Ko2 = C5721Ko.a;
        C15791kA6.b bVar = new C15791kA6.b(c5721Ko2.d(), String.valueOf(c11458d25.u()));
        bVar.m(str);
        bVar.j(str);
        bVar.f(intent);
        bVar.c(setG);
        if (bitmap != null) {
            bVar.e(IconCompat.i(bitmap));
        } else {
            bVar.e(IconCompat.l(c5721Ko2.d(), KB5.shortcut_user));
        }
        C15791kA6 c15791kA6A = bVar.a();
        AbstractC13042fc3.h(c15791kA6A, "build(...)");
        arrayList.add(c15791kA6A);
        if (arrayList2.contains(c15791kA6A.f())) {
            if (z) {
                RA6.n(c5721Ko2.d(), arrayList);
                return;
            }
            ArrayList arrayList3 = new ArrayList();
            String strF2 = c15791kA6A.f();
            AbstractC13042fc3.h(strF2, "getId(...)");
            arrayList3.add(strF2);
            RA6.k(c5721Ko2.d(), arrayList3);
            return;
        }
        if (z) {
            if (arrayList2.size() == iE) {
                String str2 = (String) arrayList2.get(arrayList2.size() - 1);
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(str2);
                RA6.k(c5721Ko2.d(), arrayList4);
            }
            RA6.a(c5721Ko2.d(), arrayList);
        }
    }

    private final Bitmap c(long j) {
        String strG = AbstractC5969Lp4.d().G(j);
        if (strG == null) {
            return null;
        }
        try {
            return AbstractC24097y23.i(strG);
        } catch (ImageLoadException e) {
            C19406qI3.c("SharingShortcutsManager", "getAvatarBitmap", e);
            return null;
        }
    }

    private final Bitmap e(Bitmap bitmap) {
        int iF = AbstractC7426Rr.a.f(48.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF, iF, Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        RectF rectF = new RectF();
        Paint paint2 = new Paint(1);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Path path = new Path();
        float f = iF / 2;
        path.addCircle(f, f, r1 - r0.f(2.0f), Path.Direction.CW);
        path.toggleInverseFillType();
        rectF.set(r0.f(2.0f), r0.f(2.0f), r0.f(46.0f), r0.f(46.0f));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
        canvas.drawPath(path, paint2);
        try {
            canvas.setBitmap(null);
        } catch (Exception unused) {
        }
        return bitmapCreateBitmap;
    }

    public final void b(C11458d25 c11458d25, C21231tK7 c21231tK7, boolean z) {
        AvatarImage largeImage;
        FileReference fileReference;
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c21231tK7, "userVM");
        Avatar avatar = (Avatar) c21231tK7.h().b();
        Long lValueOf = (avatar == null || (largeImage = avatar.getLargeImage()) == null || (fileReference = largeImage.getFileReference()) == null) ? null : Long.valueOf(fileReference.getFileId());
        if (lValueOf == null) {
            Object objB = c21231tK7.r().b();
            AbstractC13042fc3.h(objB, "get(...)");
            a(c11458d25, (String) objB, null, z);
            return;
        }
        Bitmap bitmapC = c(lValueOf.longValue());
        if (bitmapC == null) {
            Object objB2 = c21231tK7.r().b();
            AbstractC13042fc3.h(objB2, "get(...)");
            a(c11458d25, (String) objB2, null, z);
        } else {
            Bitmap bitmapE = e(bitmapC);
            Object objB3 = c21231tK7.r().b();
            AbstractC13042fc3.h(objB3, "get(...)");
            a(c11458d25, (String) objB3, bitmapE, z);
        }
    }

    public final void d() {
        try {
            RA6.j(C5721Ko.a.d());
        } catch (Exception e) {
            C19406qI3.a("SharingShortcutsManager", "exception : " + e, new Object[0]);
        }
    }
}
