package ir.nasim;

import android.os.SystemClock;
import com.google.android.exoplayer2.K0;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.j;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC15323jO3;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.Pt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6974Pt7 {
    public static com.google.android.exoplayer2.K0 a(AbstractC15323jO3.a aVar, InterfaceC5774Kt7[] interfaceC5774Kt7Arr) {
        List[] listArr = new List[interfaceC5774Kt7Arr.length];
        for (int i = 0; i < interfaceC5774Kt7Arr.length; i++) {
            InterfaceC5774Kt7 interfaceC5774Kt7 = interfaceC5774Kt7Arr[i];
            listArr[i] = interfaceC5774Kt7 != null ? AbstractC12710f43.W(interfaceC5774Kt7) : AbstractC12710f43.V();
        }
        return b(aVar, listArr);
    }

    public static com.google.android.exoplayer2.K0 b(AbstractC15323jO3.a aVar, List[] listArr) {
        boolean z;
        AbstractC12710f43.a aVar2 = new AbstractC12710f43.a();
        for (int i = 0; i < aVar.d(); i++) {
            TrackGroupArray trackGroupArrayF = aVar.f(i);
            List list = listArr[i];
            for (int i2 = 0; i2 < trackGroupArrayF.a; i2++) {
                TrackGroup trackGroupC = trackGroupArrayF.c(i2);
                boolean z2 = aVar.a(i, i2, false) != 0;
                int i3 = trackGroupC.a;
                int[] iArr = new int[i3];
                boolean[] zArr = new boolean[i3];
                for (int i4 = 0; i4 < trackGroupC.a; i4++) {
                    iArr[i4] = aVar.g(i, i2, i4);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= list.size()) {
                            z = false;
                            break;
                        }
                        InterfaceC5774Kt7 interfaceC5774Kt7 = (InterfaceC5774Kt7) list.get(i5);
                        if (interfaceC5774Kt7.l().equals(trackGroupC) && interfaceC5774Kt7.k(i4) != -1) {
                            z = true;
                            break;
                        }
                        i5++;
                    }
                    zArr[i4] = z;
                }
                aVar2.a(new K0.a(trackGroupC, z2, iArr, zArr));
            }
        }
        TrackGroupArray trackGroupArrayH = aVar.h();
        for (int i6 = 0; i6 < trackGroupArrayH.a; i6++) {
            TrackGroup trackGroupC2 = trackGroupArrayH.c(i6);
            int[] iArr2 = new int[trackGroupC2.a];
            Arrays.fill(iArr2, 0);
            aVar2.a(new K0.a(trackGroupC2, false, iArr2, new boolean[trackGroupC2.a]));
        }
        return new com.google.android.exoplayer2.K0(aVar2.h());
    }

    public static j.a c(InterfaceC13679ge2 interfaceC13679ge2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = interfaceC13679ge2.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (interfaceC13679ge2.c(i2, jElapsedRealtime)) {
                i++;
            }
        }
        return new j.a(1, 0, length, i);
    }
}
