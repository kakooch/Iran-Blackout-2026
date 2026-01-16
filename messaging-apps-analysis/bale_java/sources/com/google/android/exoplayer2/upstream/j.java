package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import ir.nasim.AbstractC20011rK;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface j {

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public boolean a(int i) {
            if (i == 1) {
                if (this.a - this.b <= 1) {
                    return false;
                }
            } else if (this.c - this.d <= 1) {
                return false;
            }
            return true;
        }
    }

    public static final class b {
        public final int a;
        public final long b;

        public b(int i, long j) {
            AbstractC20011rK.a(j >= 0);
            this.a = i;
            this.b = j;
        }
    }

    public static final class c {
        public final LoadEventInfo a;
        public final MediaLoadData b;
        public final IOException c;
        public final int d;

        public c(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, int i) {
            this.a = loadEventInfo;
            this.b = mediaLoadData;
            this.c = iOException;
            this.d = i;
        }
    }

    long a(c cVar);

    int b(int i);

    b c(a aVar, c cVar);

    default void d(long j) {
    }
}
