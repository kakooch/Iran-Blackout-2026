package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public class zzho<MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> extends zzga<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    protected zzho(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (MessageType) messagetype.zzl(4, null, null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzjf.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    public final MessageType zzaA() {
        MessageType messagetype = (MessageType) zzaD();
        boolean z = true;
        byte bByteValue = ((Byte) messagetype.zzl(1, null, null)).byteValue();
        if (bByteValue != 1) {
            if (bByteValue == 0) {
                z = false;
            } else {
                boolean zZzj = zzjf.zza().zzb(messagetype.getClass()).zzj(messagetype);
                messagetype.zzl(2, true != zZzj ? null : messagetype, null);
                z = zZzj;
            }
        }
        if (z) {
            return messagetype;
        }
        throw new zzjv(messagetype);
    }

    public final BuilderType zzaB(MessageType messagetype) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final BuilderType zzaC(byte[] bArr, int i, int i2, zzhe zzheVar) throws zzic {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        try {
            zzjf.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i2, new zzge(zzheVar));
            return this;
        } catch (zzic e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzic.zza();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final /* bridge */ /* synthetic */ zzga zzar(byte[] bArr, int i, int i2) throws zzic {
        zzaC(bArr, 0, i2, zzhe.zza());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final /* bridge */ /* synthetic */ zzga zzas(byte[] bArr, int i, int i2, zzhe zzheVar) throws zzic {
        zzaC(bArr, 0, i2, zzheVar);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    protected final /* bridge */ /* synthetic */ zzga zzat(zzgb zzgbVar) {
        zzaB((zzhs) zzgbVar);
        return this;
    }

    protected void zzax() {
        MessageType messagetype = (MessageType) this.zza.zzl(4, null, null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: zzay, reason: merged with bridge method [inline-methods] */
    public final BuilderType clone() {
        BuilderType buildertype = (BuilderType) this.zzc.zzl(5, null, null);
        buildertype.zzaB(zzaD());
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    /* renamed from: zzaz, reason: merged with bridge method [inline-methods] */
    public MessageType zzaD() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzjf.zza().zzb(messagetype.getClass()).zzi(messagetype);
        this.zzb = true;
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    public final /* bridge */ /* synthetic */ zzix zzbK() {
        return this.zzc;
    }
}
