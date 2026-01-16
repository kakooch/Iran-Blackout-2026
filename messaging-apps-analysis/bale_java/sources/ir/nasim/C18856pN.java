package ir.nasim;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import ir.nasim.AbstractC14721iN;
import ir.nasim.InterfaceC20791sc6;
import java.util.ArrayList;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.pN, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18856pN extends AudioDeviceCallback implements InterfaceC20791sc6 {
    private InterfaceC20791sc6.a a;
    private final AudioManager b;
    private final Handler c;

    public C18856pN(AudioManager audioManager, Handler handler) {
        AbstractC13042fc3.i(audioManager, "audioManager");
        AbstractC13042fc3.i(handler, "handler");
        this.b = audioManager;
        this.c = handler;
    }

    @Override // ir.nasim.InterfaceC20791sc6
    public boolean a(AbstractC14721iN abstractC14721iN) {
        AbstractC13042fc3.i(abstractC14721iN, "audioDevice");
        AudioDeviceInfo[] devices = this.b.getDevices(2);
        AbstractC13042fc3.h(devices, "this.audioManager\n      …ager.GET_DEVICES_OUTPUTS)");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            AbstractC13042fc3.h(audioDeviceInfo, "it");
            if (d(audioDeviceInfo, abstractC14721iN)) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC20791sc6
    public boolean b(InterfaceC20791sc6.a aVar) {
        AbstractC13042fc3.i(aVar, "listener");
        this.a = aVar;
        this.b.registerAudioDeviceCallback(this, this.c);
        return true;
    }

    public final AbstractC14721iN c(AudioDeviceInfo audioDeviceInfo) {
        AbstractC13042fc3.i(audioDeviceInfo, "$this$audioDevice");
        if (audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 8) {
            return new AbstractC14721iN.a(audioDeviceInfo.getProductName().toString());
        }
        if (Build.VERSION.SDK_INT >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
            return new AbstractC14721iN.a(audioDeviceInfo.getProductName().toString());
        }
        if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 22) {
            return new AbstractC14721iN.d(null, 1, null);
        }
        if (audioDeviceInfo.getType() == 1) {
            return new AbstractC14721iN.b(null, 1, null);
        }
        if (audioDeviceInfo.getType() == 2) {
            return new AbstractC14721iN.c(null, 1, null);
        }
        return null;
    }

    public final boolean d(AudioDeviceInfo audioDeviceInfo, AbstractC14721iN abstractC14721iN) {
        AbstractC13042fc3.i(audioDeviceInfo, "$this$isAudioDevice");
        AbstractC13042fc3.i(abstractC14721iN, "audioDevice");
        if (abstractC14721iN instanceof AbstractC14721iN.a) {
            if (audioDeviceInfo.getType() != 7 && audioDeviceInfo.getType() != 8) {
                if (Build.VERSION.SDK_INT < 31) {
                    return false;
                }
                if (audioDeviceInfo.getType() != 26 && audioDeviceInfo.getType() != 27) {
                    return false;
                }
            }
        } else if (abstractC14721iN instanceof AbstractC14721iN.b) {
            if (audioDeviceInfo.getType() != 1) {
                return false;
            }
        } else if (abstractC14721iN instanceof AbstractC14721iN.c) {
            if (audioDeviceInfo.getType() != 2) {
                return false;
            }
        } else {
            if (!(abstractC14721iN instanceof AbstractC14721iN.d)) {
                throw new NoWhenBranchMatchedException();
            }
            if (audioDeviceInfo.getType() != 3 && audioDeviceInfo.getType() != 4 && (Build.VERSION.SDK_INT < 26 || audioDeviceInfo.getType() != 22)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.media.AudioDeviceCallback
    public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        super.onAudioDevicesAdded(audioDeviceInfoArr);
        if (audioDeviceInfoArr != null) {
            ArrayList arrayList = new ArrayList();
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                AbstractC14721iN abstractC14721iNC = c(audioDeviceInfo);
                if (abstractC14721iNC != null) {
                    arrayList.add(abstractC14721iNC);
                }
            }
            Set<AbstractC14721iN> setR1 = AbstractC15401jX0.r1(arrayList);
            if (setR1 != null) {
                for (AbstractC14721iN abstractC14721iN : setR1) {
                    InterfaceC20791sc6.a aVar = this.a;
                    if (aVar != null) {
                        aVar.a(abstractC14721iN);
                    }
                }
            }
        }
    }

    @Override // android.media.AudioDeviceCallback
    public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        super.onAudioDevicesRemoved(audioDeviceInfoArr);
        if (audioDeviceInfoArr != null) {
            ArrayList arrayList = new ArrayList();
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                AbstractC14721iN abstractC14721iNC = c(audioDeviceInfo);
                if (abstractC14721iNC != null) {
                    arrayList.add(abstractC14721iNC);
                }
            }
            Set<AbstractC14721iN> setR1 = AbstractC15401jX0.r1(arrayList);
            if (setR1 != null) {
                for (AbstractC14721iN abstractC14721iN : setR1) {
                    InterfaceC20791sc6.a aVar = this.a;
                    if (aVar != null) {
                        aVar.b(abstractC14721iN);
                    }
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC20791sc6
    public boolean stop() {
        this.b.unregisterAudioDeviceCallback(this);
        this.a = null;
        return true;
    }
}
