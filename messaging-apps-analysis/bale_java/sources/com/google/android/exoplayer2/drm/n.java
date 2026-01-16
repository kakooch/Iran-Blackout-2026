package com.google.android.exoplayer2.drm;

import android.gov.nist.core.Separators;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.m;
import ir.nasim.AbstractC12884fL0;
import ir.nasim.AbstractC15671jy5;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.AbstractC9451Zz2;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C8208Uz2;
import ir.nasim.EW4;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class n implements m {
    public static final m.c d = new m.c() { // from class: ir.nasim.Vz2
        @Override // com.google.android.exoplayer2.drm.m.c
        public final com.google.android.exoplayer2.drm.m a(UUID uuid) {
            return com.google.android.exoplayer2.drm.n.A(uuid);
        }
    };
    private final UUID a;
    private final MediaDrm b;
    private int c;

    private static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, C15493jg5 c15493jg5) {
            LogSessionId logSessionIdA = c15493jg5.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            AbstractC9451Zz2.a(AbstractC20011rK.e(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(logSessionIdA);
        }
    }

    private n(UUID uuid) {
        AbstractC20011rK.e(uuid);
        AbstractC20011rK.b(!AbstractC9350Zo0.b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.a = uuid;
        MediaDrm mediaDrm = new MediaDrm(u(uuid));
        this.b = mediaDrm;
        this.c = 1;
        if (AbstractC9350Zo0.d.equals(uuid) && B()) {
            w(mediaDrm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ m A(UUID uuid) {
        try {
            return C(uuid);
        } catch (UnsupportedDrmException unused) {
            AbstractC18815pI3.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + Separators.DOT);
            return new k();
        }
    }

    private static boolean B() {
        return "ASUS_Z00AD".equals(AbstractC9683aN7.d);
    }

    public static n C(UUID uuid) throws UnsupportedDrmException {
        try {
            return new n(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }

    private static byte[] p(byte[] bArr) {
        EW4 ew4 = new EW4(bArr);
        int iS = ew4.s();
        short sU = ew4.u();
        short sU2 = ew4.u();
        if (sU != 1 || sU2 != 1) {
            AbstractC18815pI3.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sU3 = ew4.u();
        Charset charset = AbstractC12884fL0.e;
        String strD = ew4.D(sU3, charset);
        if (strD.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strD.indexOf("</DATA>");
        if (iIndexOf == -1) {
            AbstractC18815pI3.k("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strD.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strD.substring(iIndexOf);
        int i = iS + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putShort(sU);
        byteBufferAllocate.putShort(sU2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    private static String q(String str) {
        return "<LA_URL>https://x</LA_URL>".equals(str) ? "" : (AbstractC9683aN7.a == 33 && "https://default.url".equals(str)) ? "" : str;
    }

    private static byte[] r(UUID uuid, byte[] bArr) {
        return AbstractC9350Zo0.c.equals(uuid) ? com.google.android.exoplayer2.drm.a.a(bArr) : bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] s(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = ir.nasim.AbstractC9350Zo0.e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = ir.nasim.AbstractC15671jy5.e(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = p(r4)
            byte[] r4 = ir.nasim.AbstractC15671jy5.a(r0, r4)
        L18:
            int r1 = ir.nasim.AbstractC9683aN7.a
            r2 = 23
            if (r1 >= r2) goto L26
            java.util.UUID r1 = ir.nasim.AbstractC9350Zo0.d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L58
        L26:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5f
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = ir.nasim.AbstractC9683aN7.c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5f
            java.lang.String r0 = ir.nasim.AbstractC9683aN7.d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L58:
            byte[] r3 = ir.nasim.AbstractC15671jy5.e(r4, r3)
            if (r3 == 0) goto L5f
            return r3
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.n.s(java.util.UUID, byte[]):byte[]");
    }

    private static String t(UUID uuid, String str) {
        return (AbstractC9683aN7.a < 26 && AbstractC9350Zo0.c.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    private static UUID u(UUID uuid) {
        return (AbstractC9683aN7.a >= 27 || !AbstractC9350Zo0.c.equals(uuid)) ? uuid : AbstractC9350Zo0.b;
    }

    private static void w(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static DrmInitData.SchemeData y(UUID uuid, List list) {
        if (!AbstractC9350Zo0.d.equals(uuid)) {
            return (DrmInitData.SchemeData) list.get(0);
        }
        if (AbstractC9683aN7.a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) list.get(0);
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) list.get(i);
                byte[] bArr = (byte[]) AbstractC20011rK.e(schemeData2.e);
                if (AbstractC9683aN7.c(schemeData2.d, schemeData.d) && AbstractC9683aN7.c(schemeData2.c, schemeData.c) && AbstractC15671jy5.c(bArr)) {
                    length += bArr.length;
                }
            }
            byte[] bArr2 = new byte[length];
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                byte[] bArr3 = (byte[]) AbstractC20011rK.e(((DrmInitData.SchemeData) list.get(i3)).e);
                int length2 = bArr3.length;
                System.arraycopy(bArr3, 0, bArr2, i2, length2);
                i2 += length2;
            }
            return schemeData.a(bArr2);
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            DrmInitData.SchemeData schemeData3 = (DrmInitData.SchemeData) list.get(i4);
            int iG = AbstractC15671jy5.g((byte[]) AbstractC20011rK.e(schemeData3.e));
            int i5 = AbstractC9683aN7.a;
            if (i5 < 23 && iG == 0) {
                return schemeData3;
            }
            if (i5 >= 23 && iG == 1) {
                return schemeData3;
            }
        }
        return (DrmInitData.SchemeData) list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(m.b bVar, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        bVar.a(this, bArr, i, i2, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public Map a(byte[] bArr) {
        return this.b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public m.d b() {
        MediaDrm.ProvisionRequest provisionRequest = this.b.getProvisionRequest();
        return new m.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.m
    public byte[] c() {
        return this.b.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void d(byte[] bArr, byte[] bArr2) {
        this.b.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void e(final m.b bVar) {
        this.b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: ir.nasim.Wz2
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                this.a.z(bVar, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void f(byte[] bArr) throws DeniedByServerException {
        this.b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public int g() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void h(byte[] bArr, C15493jg5 c15493jg5) {
        if (AbstractC9683aN7.a >= 31) {
            try {
                a.b(this.b, bArr, c15493jg5);
            } catch (UnsupportedOperationException unused) {
                AbstractC18815pI3.k("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.m
    public boolean j(byte[] bArr, String str) {
        if (AbstractC9683aN7.a >= 31) {
            return a.a(this.b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void k(byte[] bArr) {
        this.b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public byte[] l(byte[] bArr, byte[] bArr2) throws JSONException {
        if (AbstractC9350Zo0.c.equals(this.a)) {
            bArr2 = com.google.android.exoplayer2.drm.a.b(bArr2);
        }
        return this.b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public m.a m(byte[] bArr, List list, int i, HashMap map) throws NotProvisionedException {
        DrmInitData.SchemeData schemeDataY;
        byte[] bArrS;
        String strT;
        if (list != null) {
            schemeDataY = y(this.a, list);
            bArrS = s(this.a, (byte[]) AbstractC20011rK.e(schemeDataY.e));
            strT = t(this.a, schemeDataY.d);
        } else {
            schemeDataY = null;
            bArrS = null;
            strT = null;
        }
        MediaDrm.KeyRequest keyRequest = this.b.getKeyRequest(bArr, bArrS, strT, i, map);
        byte[] bArrR = r(this.a, keyRequest.getData());
        String strQ = q(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(strQ) && schemeDataY != null && !TextUtils.isEmpty(schemeDataY.c)) {
            strQ = schemeDataY.c;
        }
        return new m.a(bArrR, strQ, AbstractC9683aN7.a >= 23 ? keyRequest.getRequestType() : RecyclerView.UNDEFINED_DURATION);
    }

    @Override // com.google.android.exoplayer2.drm.m
    public synchronized void release() {
        int i = this.c - 1;
        this.c = i;
        if (i == 0) {
            this.b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.m
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public C8208Uz2 i(byte[] bArr) {
        return new C8208Uz2(u(this.a), bArr, AbstractC9683aN7.a < 21 && AbstractC9350Zo0.d.equals(this.a) && "L3".equals(x("securityLevel")));
    }

    public String x(String str) {
        return this.b.getPropertyString(str);
    }
}
