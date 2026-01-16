package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class amt extends ImageView implements View.OnClickListener {
    private final CompanionData a;
    private final float b;
    private final ane c;
    private final String d;
    private final List<CompanionAdSlot.ClickListener> e;
    private final ams f;

    public amt(Context context, ane aneVar, CompanionData companionData, String str, List<CompanionAdSlot.ClickListener> list) {
        ams amsVar;
        super(context);
        this.b = getResources().getDisplayMetrics().density;
        this.c = aneVar;
        this.a = companionData;
        this.d = str;
        this.e = list;
        String size = companionData.size();
        if (size == null) {
            amsVar = null;
        } else {
            String[] strArrSplit = size.split("x", -1);
            amsVar = strArrSplit.length != 2 ? new ams(0, 0) : new ams(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        }
        this.f = amsVar;
        setOnClickListener(this);
    }

    static /* synthetic */ void c(amt amtVar) {
        ane aneVar = amtVar.c;
        String strCompanionId = amtVar.a.companionId();
        String str = amtVar.d;
        if (aqd.b(strCompanionId) || aqd.b(str)) {
            return;
        }
        HashMap mapG = asn.g(1);
        mapG.put("companionId", strCompanionId);
        aneVar.n(new amx(amv.displayContainer, amw.companionView, str, mapG));
    }

    final Bitmap a(String str) throws IOException {
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        return (this.f.a == bitmapDecodeStream.getWidth() && this.f.b == bitmapDecodeStream.getHeight() && !asr.a((double) this.b)) ? Bitmap.createScaledBitmap(bitmapDecodeStream, (int) (this.b * bitmapDecodeStream.getWidth()), (int) (this.b * bitmapDecodeStream.getHeight()), true) : bitmapDecodeStream;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Iterator<CompanionAdSlot.ClickListener> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().onCompanionAdClick();
        }
        this.c.o(this.a.clickThroughUrl());
    }
}
