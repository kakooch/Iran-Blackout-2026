package ir.nasim;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.c;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: ir.nasim.qx1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19795qx1 implements MediaSource.Factory {
    private final Context a;
    private MediaSource.Factory b;
    private MediaSource.Factory c;

    public C19795qx1(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        c.a aVar = new c.a(context);
        UD1 ud1J = new UD1().j(true);
        AbstractC13042fc3.h(ud1J, "setConstantBitrateSeekingEnabled(...)");
        this.b = new ProgressiveMediaSource.Factory(aVar, ud1J);
        this.c = new HlsMediaSource.Factory(aVar);
    }

    private final Uri d(String str, long j) throws IOException {
        File file = new File(this.a.getCacheDir(), "temp_voice_" + System.currentTimeMillis() + ".m3u8");
        FileWriter fileWriter = new FileWriter(file);
        try {
            fileWriter.write(AbstractC16016kZ6.g("\n                        #EXTM3U\n                        #EXT-X-VERSION:3\n                        #EXT-X-TARGETDURATION:" + j + "\n                        #EXT-X-MEDIA-SEQUENCE:0\n                        #EXT-X-PLAYLIST-TYPE:VOD\n                        #EXTINF:" + j + ".0,\n                        " + str + "\n                        #EXT-X-ENDLIST\n                "));
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(fileWriter, null);
            Uri uriFromFile = Uri.fromFile(file);
            AbstractC13042fc3.h(uriFromFile, "fromFile(...)");
            return uriFromFile;
        } finally {
        }
    }

    private final boolean e(C2018a0 c2018a0) {
        String str;
        C2018a0.h hVar = c2018a0.b;
        return (hVar == null || (str = hVar.e) == null || !AbstractC20153rZ6.S(str, "fragmented_mp4_", false, 2, null)) ? false : true;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public MediaSource a(C2018a0 c2018a0) {
        Uri uri;
        AbstractC13042fc3.i(c2018a0, "mediaItem");
        if (e(c2018a0)) {
            try {
                Bundle bundle = c2018a0.e.Z;
                long j = bundle != null ? bundle.getLong("durationInMillis") : 120L;
                C2018a0.h hVar = c2018a0.b;
                if (hVar != null && (uri = hVar.a) != null) {
                    String string = uri.toString();
                    AbstractC13042fc3.h(string, "toString(...)");
                    C2018a0 c2018a0A = new C2018a0.c().j(d(string, j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)).e(c2018a0.a).a();
                    AbstractC13042fc3.h(c2018a0A, "build(...)");
                    MediaSource mediaSourceA = this.c.a(c2018a0A);
                    AbstractC13042fc3.h(mediaSourceA, "createMediaSource(...)");
                    return mediaSourceA;
                }
                MediaSource mediaSourceA2 = this.b.a(c2018a0);
                AbstractC13042fc3.h(mediaSourceA2, "createMediaSource(...)");
                return mediaSourceA2;
            } catch (Exception e) {
                C19406qI3.j("CustomMediaSourceFactory", "HLS wrapper failed, falling back to progressive: " + e.getMessage(), new Object[0]);
            }
        }
        MediaSource mediaSourceA3 = this.b.a(c2018a0);
        AbstractC13042fc3.h(mediaSourceA3, "createMediaSource(...)");
        return mediaSourceA3;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public MediaSource.Factory b(InterfaceC12088e12 interfaceC12088e12) {
        AbstractC13042fc3.i(interfaceC12088e12, "provider");
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public MediaSource.Factory c(com.google.android.exoplayer2.upstream.j jVar) {
        AbstractC13042fc3.i(jVar, "policy");
        return this;
    }

    public final void f() {
        try {
            File[] fileArrListFiles = this.a.getCacheDir().listFiles();
            if (fileArrListFiles != null) {
                ArrayList<File> arrayList = new ArrayList();
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    AbstractC13042fc3.h(name, "getName(...)");
                    if (AbstractC20153rZ6.S(name, "temp_voice_", false, 2, null)) {
                        String name2 = file.getName();
                        AbstractC13042fc3.h(name2, "getName(...)");
                        if (AbstractC20153rZ6.C(name2, ".m3u8", false, 2, null)) {
                            arrayList.add(file);
                        }
                    }
                }
                for (File file2 : arrayList) {
                    try {
                        file2.delete();
                    } catch (Exception unused) {
                        C19406qI3.j("CustomMediaSourceFactory", "Failed to clean up temp manifest: " + file2.getName(), new Object[0]);
                    }
                }
            }
        } catch (Exception e) {
            C19406qI3.j("CustomMediaSourceFactory", "Error during manifest cleanup: " + e.getMessage(), new Object[0]);
        }
    }
}
