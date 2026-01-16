package ir.nasim;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import ir.nasim.FT1;
import ir.nasim.InterfaceC22734vk2;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import livekit.org.webrtc.MediaStreamTrack;
import okio.Okio;

/* renamed from: ir.nasim.sl1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20876sl1 implements InterfaceC22734vk2 {
    private final Uri a;
    private final IL4 b;

    /* renamed from: ir.nasim.sl1$a */
    public static final class a implements InterfaceC22734vk2.a {
        private final boolean c(Uri uri) {
            return AbstractC13042fc3.d(uri.getScheme(), "content");
        }

        @Override // ir.nasim.InterfaceC22734vk2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC22734vk2 a(Uri uri, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            if (c(uri)) {
                return new C20876sl1(uri, il4);
            }
            return null;
        }
    }

    public C20876sl1(Uri uri, IL4 il4) {
        this.a = uri;
        this.b = il4;
    }

    private final Bundle d() {
        FT1 ft1D = this.b.o().d();
        FT1.a aVar = ft1D instanceof FT1.a ? (FT1.a) ft1D : null;
        if (aVar == null) {
            return null;
        }
        int i = aVar.a;
        FT1 ft1C = this.b.o().c();
        FT1.a aVar2 = ft1C instanceof FT1.a ? (FT1.a) ft1C : null;
        if (aVar2 == null) {
            return null;
        }
        int i2 = aVar2.a;
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("android.content.extra.SIZE", new Point(i, i2));
        return bundle;
    }

    @Override // ir.nasim.InterfaceC22734vk2
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream;
        ContentResolver contentResolver = this.b.g().getContentResolver();
        if (b(this.a)) {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.a, "r");
            inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.a + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT < 29 || !c(this.a)) {
            inputStreamOpenInputStream = contentResolver.openInputStream(this.a);
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to open '" + this.a + "'.").toString());
            }
        } else {
            AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(this.a, "image/*", d(), null);
            inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
            if (inputStreamOpenInputStream == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.a + "'.").toString());
            }
        }
        return new WH6(AbstractC11466d33.b(Okio.buffer(Okio.source(inputStreamOpenInputStream)), this.b.g(), new C9081Yk1(this.a)), contentResolver.getType(this.a), EnumC21699tz1.c);
    }

    public final boolean b(Uri uri) {
        return AbstractC13042fc3.d(uri.getAuthority(), "com.android.contacts") && AbstractC13042fc3.d(uri.getLastPathSegment(), "display_photo");
    }

    public final boolean c(Uri uri) {
        List<String> pathSegments;
        int size;
        return AbstractC13042fc3.d(uri.getAuthority(), "media") && (size = (pathSegments = uri.getPathSegments()).size()) >= 3 && AbstractC13042fc3.d(pathSegments.get(size + (-3)), MediaStreamTrack.AUDIO_TRACK_KIND) && AbstractC13042fc3.d(pathSegments.get(size + (-2)), "albums");
    }
}
