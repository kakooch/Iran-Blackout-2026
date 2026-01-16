package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import android.util.Pair;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC13937h43;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class SM {
    public static final SM c = new SM(new int[]{2}, 8);
    private static final SM d = new SM(new int[]{2, 5, 6}, 8);
    private static final AbstractC13937h43 e = new AbstractC13937h43.a().d(5, 6).d(17, 6).d(7, 6).d(18, 6).d(6, 8).d(8, 8).d(14, 8).b();
    private final int[] a;
    private final int b;

    private static final class a {
        private static final AudioAttributes a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        public static int[] a() {
            AbstractC12710f43.a aVarL = AbstractC12710f43.L();
            DB7 it = SM.e.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(num.intValue()).setSampleRate(48000).build(), a)) {
                    aVarL.a(num);
                }
            }
            aVarL.a(2);
            return AbstractC8236Vc3.l(aVarL.h());
        }

        public static int b(int i, int i2) {
            for (int i3 = 8; i3 > 0; i3--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(AbstractC9683aN7.E(i3)).build(), a)) {
                    return i3;
                }
            }
            return 0;
        }
    }

    public SM(int[] iArr, int i) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.a = new int[0];
        }
        this.b = i;
    }

    private static boolean b() {
        if (AbstractC9683aN7.a >= 17) {
            String str = AbstractC9683aN7.c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static SM c(Context context) {
        return d(context, AbstractC9683aN7.L0(context, null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    static SM d(Context context, Intent intent) {
        return (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) ? d : (AbstractC9683aN7.a < 29 || !(AbstractC9683aN7.x0(context) || AbstractC9683aN7.s0(context))) ? (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? c : new SM(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)) : new SM(a.a(), 8);
    }

    private static int e(int i) {
        int i2 = AbstractC9683aN7.a;
        if (i2 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (i2 <= 26 && "fugu".equals(AbstractC9683aN7.b) && i == 1) {
            i = 2;
        }
        return AbstractC9683aN7.E(i);
    }

    private static int g(int i, int i2) {
        return AbstractC9683aN7.a >= 29 ? a.b(i, i2) : ((Integer) AbstractC20011rK.e((Integer) e.getOrDefault(Integer.valueOf(i), 0))).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SM)) {
            return false;
        }
        SM sm = (SM) obj;
        return Arrays.equals(this.a, sm.a) && this.b == sm.b;
    }

    public Pair f(com.google.android.exoplayer2.X x) {
        int iF = AbstractC24462yf4.f((String) AbstractC20011rK.e(x.l), x.i);
        if (!e.containsKey(Integer.valueOf(iF))) {
            return null;
        }
        if (iF == 18 && !i(18)) {
            iF = 6;
        } else if (iF == 8 && !i(8)) {
            iF = 7;
        }
        if (!i(iF)) {
            return null;
        }
        int iG = x.y;
        if (iG == -1 || iF == 18) {
            int i = x.z;
            if (i == -1) {
                i = 48000;
            }
            iG = g(iF, i);
        } else if (iG > this.b) {
            return null;
        }
        int iE = e(iG);
        if (iE == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iF), Integer.valueOf(iE));
    }

    public boolean h(com.google.android.exoplayer2.X x) {
        return f(x) != null;
    }

    public int hashCode() {
        return this.b + (Arrays.hashCode(this.a) * 31);
    }

    public boolean i(int i) {
        return Arrays.binarySearch(this.a, i) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", supportedEncodings=" + Arrays.toString(this.a) + "]";
    }
}
