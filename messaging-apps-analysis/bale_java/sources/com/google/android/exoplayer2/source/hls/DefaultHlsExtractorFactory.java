package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC5238Im2;
import ir.nasim.AbstractC8236Vc3;
import ir.nasim.C14506i2;
import ir.nasim.C15493jg5;
import ir.nasim.C16431lG1;
import ir.nasim.C16886m2;
import ir.nasim.C21678tw7;
import ir.nasim.C24512yk4;
import ir.nasim.C4419Fb;
import ir.nasim.C5045Hq7;
import ir.nasim.C7267Qz2;
import ir.nasim.InterfaceC9262Ze2;
import ir.nasim.InterfaceC9845af2;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {
    private static final int[] d = {8, 13, 11, 2, 0, 1, 7};
    private final int b;
    private final boolean c;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    private static void b(int i, List list) {
        if (AbstractC8236Vc3.h(d, i) == -1 || list.contains(Integer.valueOf(i))) {
            return;
        }
        list.add(Integer.valueOf(i));
    }

    private InterfaceC9262Ze2 d(int i, X x, List list, C5045Hq7 c5045Hq7) {
        if (i == 0) {
            return new C14506i2();
        }
        if (i == 1) {
            return new C16886m2();
        }
        if (i == 2) {
            return new C4419Fb();
        }
        if (i == 7) {
            return new C24512yk4(0, 0L);
        }
        if (i == 8) {
            return e(c5045Hq7, x, list);
        }
        if (i == 11) {
            return f(this.b, this.c, x, list, c5045Hq7);
        }
        if (i != 13) {
            return null;
        }
        return new WebvttExtractor(x.c, c5045Hq7);
    }

    private static C7267Qz2 e(C5045Hq7 c5045Hq7, X x, List list) {
        int i = g(x) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new C7267Qz2(i, c5045Hq7, null, list);
    }

    private static C21678tw7 f(int i, boolean z, X x, List list, C5045Hq7 c5045Hq7) {
        int i2 = i | 16;
        if (list != null) {
            i2 = i | 48;
        } else {
            list = z ? Collections.singletonList(new X.b().g0("application/cea-608").G()) : Collections.emptyList();
        }
        String str = x.i;
        if (!TextUtils.isEmpty(str)) {
            if (!AbstractC24462yf4.b(str, "audio/mp4a-latm")) {
                i2 |= 2;
            }
            if (!AbstractC24462yf4.b(str, "video/avc")) {
                i2 |= 4;
            }
        }
        return new C21678tw7(2, c5045Hq7, new C16431lG1(i2, list));
    }

    private static boolean g(X x) {
        Metadata metadata = x.j;
        if (metadata == null) {
            return false;
        }
        for (int i = 0; i < metadata.e(); i++) {
            if (metadata.d(i) instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) r2).c.isEmpty();
            }
        }
        return false;
    }

    private static boolean h(InterfaceC9262Ze2 interfaceC9262Ze2, InterfaceC9845af2 interfaceC9845af2) {
        try {
            boolean zD = interfaceC9262Ze2.d(interfaceC9845af2);
            interfaceC9845af2.e();
            return zD;
        } catch (EOFException unused) {
            interfaceC9845af2.e();
            return false;
        } catch (Throwable th) {
            interfaceC9845af2.e();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BundledHlsMediaChunkExtractor a(Uri uri, X x, List list, C5045Hq7 c5045Hq7, Map map, InterfaceC9845af2 interfaceC9845af2, C15493jg5 c15493jg5) {
        int iA = AbstractC5238Im2.a(x.l);
        int iB = AbstractC5238Im2.b(map);
        int iC = AbstractC5238Im2.c(uri);
        int[] iArr = d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(iA, arrayList);
        b(iB, arrayList);
        b(iC, arrayList);
        for (int i : iArr) {
            b(i, arrayList);
        }
        interfaceC9845af2.e();
        InterfaceC9262Ze2 interfaceC9262Ze2 = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int iIntValue = ((Integer) arrayList.get(i2)).intValue();
            InterfaceC9262Ze2 interfaceC9262Ze22 = (InterfaceC9262Ze2) AbstractC20011rK.e(d(iIntValue, x, list, c5045Hq7));
            if (h(interfaceC9262Ze22, interfaceC9845af2)) {
                return new BundledHlsMediaChunkExtractor(interfaceC9262Ze22, x, c5045Hq7);
            }
            if (interfaceC9262Ze2 == null && (iIntValue == iA || iIntValue == iB || iIntValue == iC || iIntValue == 11)) {
                interfaceC9262Ze2 = interfaceC9262Ze22;
            }
        }
        return new BundledHlsMediaChunkExtractor((InterfaceC9262Ze2) AbstractC20011rK.e(interfaceC9262Ze2), x, c5045Hq7);
    }

    public DefaultHlsExtractorFactory(int i, boolean z) {
        this.b = i;
        this.c = z;
    }
}
