package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aoh implements VideoAdPlayer, ResizablePlayer, aoi, aod {
    private final ej a;
    private final SurfaceView b;
    private final abi c;
    private final FrameLayout d;
    private final ViewGroup e;
    private final List<VideoAdPlayer.VideoAdPlayerCallback> f;
    private final HashSet<AdMediaInfo> g;
    private final aoe h;
    private final aof i;
    private final aog j;
    private final ArrayList<AdMediaInfo> k;
    private final ach l;
    private ti m;
    private AdPodInfo n;
    private int o;

    public aoh(Context context, ViewGroup viewGroup) {
        ej ejVarA = bo.a(context, new aok(context), new aaw(aaq.a, new aah()));
        this.k = new ArrayList<>();
        this.e = viewGroup;
        this.a = ejVarA;
        this.l = new ach(context, aeu.aq(context));
        this.f = new ArrayList(1);
        aof aofVar = new aof(this);
        this.i = aofVar;
        this.g = asn.b();
        aog aogVar = new aog(this);
        this.j = aogVar;
        this.h = new aoe(this);
        ejVarA.c(aofVar);
        ejVarA.e(aogVar);
        FrameLayout frameLayout = new FrameLayout(context);
        this.d = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        abi abiVar = new abi(context);
        this.c = abiVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        abiVar.setLayoutParams(layoutParams);
        this.o = 1;
        SurfaceView surfaceView = new SurfaceView(context);
        this.b = surfaceView;
        surfaceView.setZOrderMediaOverlay(true);
        ejVarA.b(surfaceView.getHolder());
        abiVar.addView(surfaceView);
        frameLayout.addView(abiVar);
        viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    private final void i() {
        this.d.setVisibility(8);
        this.b.setVisibility(4);
        this.m = null;
        this.h.b();
        this.o = 1;
        this.a.a();
        this.a.X();
        this.g.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdMediaInfo j() {
        int iM = this.a.m();
        if (this.m == null) {
            return null;
        }
        return m(iM);
    }

    private final void k(AdMediaInfo adMediaInfo) {
        ty tyVarA;
        Uri uri = Uri.parse(adMediaInfo.getUrl());
        int iAb = aeu.ab(uri);
        if (iAb == 0) {
            ach achVar = this.l;
            tyVarA = new wp(new wz(achVar), achVar).a(uri);
        } else if (iAb == 2) {
            tyVarA = new ys(new yg(this.l)).a(uri);
        } else {
            if (iAb != 3) {
                StringBuilder sb = new StringBuilder(29);
                sb.append("Unsupported type: ");
                sb.append(iAb);
                throw new IllegalStateException(sb.toString());
            }
            tyVarA = new uu(this.l, new aoj()).a(uri);
        }
        this.m.C(tyVarA);
        this.k.add(adMediaInfo);
    }

    private final int l(AdMediaInfo adMediaInfo) {
        return this.k.indexOf(adMediaInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdMediaInfo m(int i) {
        if (i < 0 || i >= this.k.size()) {
            return null;
        }
        return this.k.get(i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aod
    public final void a() {
        AdMediaInfo adMediaInfoJ = j();
        VideoProgressUpdate adProgress = getAdProgress();
        Iterator<VideoAdPlayer.VideoAdPlayerCallback> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().onAdProgress(adMediaInfoJ, adProgress);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
    public final void addCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
        this.f.add(videoAdPlayerCallback);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return ((this.a.g() == 2 || this.a.g() == 3) && this.a.n() > 0) ? new VideoProgressUpdate(this.a.o(), this.a.n()) : VideoProgressUpdate.VIDEO_TIME_NOT_READY;
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VolumeProvider
    public final int getVolume() {
        return 100;
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
    public final void loadAd(AdMediaInfo adMediaInfo, AdPodInfo adPodInfo) {
        if (this.m != null) {
            AdPodInfo adPodInfo2 = this.n;
            if (adPodInfo2 == null || adPodInfo == null || adPodInfo2.getPodIndex() != adPodInfo.getPodIndex()) {
                throw new IllegalStateException("Called loadAd on an ad from a different ad break.");
            }
            k(adMediaInfo);
            return;
        }
        this.a.a();
        ej ejVar = this.a;
        ejVar.y(ejVar.m());
        this.k.clear();
        this.m = new ti(new ve(), new ty[0]);
        this.n = adPodInfo;
        k(adMediaInfo);
        this.a.i(false);
        this.a.h(this.m);
        this.o = 2;
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
    public final void pauseAd(AdMediaInfo adMediaInfo) {
        this.h.b();
        this.o = 4;
        this.a.i(false);
        Iterator<VideoAdPlayer.VideoAdPlayerCallback> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().onPause(adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
    public final void playAd(AdMediaInfo adMediaInfo) {
        if (this.m == null || !this.k.contains(adMediaInfo)) {
            throw new IllegalStateException("Call to playAd without appropriate call to loadAd first.");
        }
        this.d.setVisibility(0);
        this.b.setVisibility(0);
        int i = this.o;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            throw new IllegalStateException("Call to playAd when player state is not LOADED.");
        }
        if (i2 == 1) {
            Iterator<VideoAdPlayer.VideoAdPlayerCallback> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().onPlay(adMediaInfo);
            }
            this.a.b(this.b.getHolder());
        } else {
            if (i2 == 2) {
                return;
            }
            if (i2 == 3) {
                Iterator<VideoAdPlayer.VideoAdPlayerCallback> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    it2.next().onResume(adMediaInfo);
                }
            }
        }
        this.h.a();
        this.o = 3;
        this.a.i(true);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
    public final void release() {
        i();
        this.a.d(this.i);
        this.a.f(this.j);
        this.a.k();
        this.h.b();
        this.e.removeView(this.d);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
    public final void removeCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
        this.f.remove(videoAdPlayerCallback);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.ResizablePlayer
    public final void resize(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.e.getWidth() - i) - i3, (this.e.getHeight() - i2) - i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        this.c.setLayoutParams(layoutParams);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer
    public final void stopAd(AdMediaInfo adMediaInfo) {
        if (this.m == null) {
            Log.e("IMASDK", "Attempting to stop when no current ad source");
            return;
        }
        this.g.add(adMediaInfo);
        int iL = l(adMediaInfo);
        int iM = this.a.m();
        if (iL == iM) {
            if (l(adMediaInfo) == this.k.size() - 1) {
                i();
                return;
            } else {
                this.a.y(this.a.m() + 1);
                return;
            }
        }
        if (iL > iM) {
            this.m.I(l(adMediaInfo));
            this.k.remove(adMediaInfo);
        }
    }
}
