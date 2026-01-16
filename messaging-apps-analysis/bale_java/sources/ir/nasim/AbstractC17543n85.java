package ir.nasim;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.features.media.components.PhotoViewerAbs;
import java.util.ArrayList;

/* renamed from: ir.nasim.n85, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17543n85 {

    /* renamed from: ir.nasim.n85$b */
    public interface b {
        void a(String str, String str2);
    }

    public static void a(Fragment fragment, Activity activity, String str, int i, boolean z, b bVar) {
        b(fragment, activity, str, i, z, bVar, false);
    }

    public static void b(Fragment fragment, Activity activity, String str, int i, boolean z, b bVar, boolean z2) {
        if (activity == null || str == null || str.isEmpty() || bVar == null) {
            C19406qI3.b("PhotoCropHandler", "Photo crop parameters is not complete");
            return;
        }
        int iC = V13.c(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AbstractC14815iX3.b(0, 0, 0L, str, iC, false));
        c(fragment, activity, i, z, bVar, z2, arrayList);
        C6906Pm2.c(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void c(Fragment fragment, Activity activity, int i, boolean z, b bVar, boolean z2, ArrayList arrayList) {
        OP0 op0 = fragment instanceof OP0 ? (OP0) fragment : null;
        if (PhotoViewerAbs.getInstance() instanceof C20171rb5) {
            ((C20171rb5) PhotoViewerAbs.getInstance()).c = true;
        }
        PhotoViewerAbs.getInstance().setParentActivity(activity);
        PhotoViewerAbs.getInstance().openPhotoForSelect(arrayList, 0, i, z, new a(arrayList, z2, bVar, fragment), op0 != null ? op0.Y2() : null, op0 != null ? op0.z() : null);
    }

    /* renamed from: ir.nasim.n85$a */
    class a extends PhotoViewerAbs.EmptyPhotoViewerProviderAbs {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ boolean b;
        final /* synthetic */ b c;
        final /* synthetic */ Fragment d;

        a(ArrayList arrayList, boolean z, b bVar, Fragment fragment) {
            this.a = arrayList;
            this.b = z;
            this.c = bVar;
            this.d = fragment;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean allowCaption() {
            return this.b;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public void sendButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h) {
            CharSequence charSequence;
            AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) this.a.get(0);
            String str = bVar.c;
            String string = "";
            if (str == null && (str = bVar.A) == null) {
                str = "";
            }
            if (this.b && (charSequence = bVar.a) != null) {
                string = charSequence.toString();
            }
            this.c.a(str, string);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void sendButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h, boolean z, int i2, boolean z2) {
            sendButtonPressed(i, h);
        }
    }
}
