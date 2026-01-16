package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zza' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzhk {
    public static final zzhk zzA;
    public static final zzhk zzB;
    public static final zzhk zzC;
    public static final zzhk zzD;
    public static final zzhk zzE;
    public static final zzhk zzF;
    public static final zzhk zzG;
    public static final zzhk zzH;
    public static final zzhk zzI;
    public static final zzhk zzJ;
    public static final zzhk zzK;
    public static final zzhk zzL;
    public static final zzhk zzM;
    public static final zzhk zzN;
    public static final zzhk zzO;
    public static final zzhk zzP;
    public static final zzhk zzQ;
    public static final zzhk zzR;
    public static final zzhk zzS;
    public static final zzhk zzT;
    public static final zzhk zzU;
    public static final zzhk zzV;
    public static final zzhk zzW;
    public static final zzhk zzX;
    public static final zzhk zzY;
    public static final zzhk zza;
    private static final zzhk[] zzac;
    private static final /* synthetic */ zzhk[] zzad;
    public static final zzhk zzb;
    public static final zzhk zzc;
    public static final zzhk zzd;
    public static final zzhk zze;
    public static final zzhk zzf;
    public static final zzhk zzg;
    public static final zzhk zzh;
    public static final zzhk zzi;
    public static final zzhk zzj;
    public static final zzhk zzk;
    public static final zzhk zzl;
    public static final zzhk zzm;
    public static final zzhk zzn;
    public static final zzhk zzo;
    public static final zzhk zzp;
    public static final zzhk zzq;
    public static final zzhk zzr;
    public static final zzhk zzs;
    public static final zzhk zzt;
    public static final zzhk zzu;
    public static final zzhk zzv;
    public static final zzhk zzw;
    public static final zzhk zzx;
    public static final zzhk zzy;
    public static final zzhk zzz;
    private final int zzaa;

    static {
        zzid zzidVar = zzid.zze;
        zzhk zzhkVar = new zzhk("DOUBLE", 0, 0, 1, zzidVar);
        zza = zzhkVar;
        zzid zzidVar2 = zzid.zzd;
        zzhk zzhkVar2 = new zzhk("FLOAT", 1, 1, 1, zzidVar2);
        zzb = zzhkVar2;
        zzid zzidVar3 = zzid.zzc;
        zzhk zzhkVar3 = new zzhk("INT64", 2, 2, 1, zzidVar3);
        zzc = zzhkVar3;
        zzhk zzhkVar4 = new zzhk("UINT64", 3, 3, 1, zzidVar3);
        zzd = zzhkVar4;
        zzid zzidVar4 = zzid.zzb;
        zzhk zzhkVar5 = new zzhk("INT32", 4, 4, 1, zzidVar4);
        zze = zzhkVar5;
        zzhk zzhkVar6 = new zzhk("FIXED64", 5, 5, 1, zzidVar3);
        zzf = zzhkVar6;
        zzhk zzhkVar7 = new zzhk("FIXED32", 6, 6, 1, zzidVar4);
        zzg = zzhkVar7;
        zzid zzidVar5 = zzid.zzf;
        zzhk zzhkVar8 = new zzhk("BOOL", 7, 7, 1, zzidVar5);
        zzh = zzhkVar8;
        zzid zzidVar6 = zzid.zzg;
        zzhk zzhkVar9 = new zzhk("STRING", 8, 8, 1, zzidVar6);
        zzi = zzhkVar9;
        zzid zzidVar7 = zzid.zzj;
        zzhk zzhkVar10 = new zzhk("MESSAGE", 9, 9, 1, zzidVar7);
        zzj = zzhkVar10;
        zzid zzidVar8 = zzid.zzh;
        zzhk zzhkVar11 = new zzhk("BYTES", 10, 10, 1, zzidVar8);
        zzk = zzhkVar11;
        zzhk zzhkVar12 = new zzhk("UINT32", 11, 11, 1, zzidVar4);
        zzl = zzhkVar12;
        zzid zzidVar9 = zzid.zzi;
        zzhk zzhkVar13 = new zzhk("ENUM", 12, 12, 1, zzidVar9);
        zzm = zzhkVar13;
        zzhk zzhkVar14 = new zzhk("SFIXED32", 13, 13, 1, zzidVar4);
        zzn = zzhkVar14;
        zzhk zzhkVar15 = new zzhk("SFIXED64", 14, 14, 1, zzidVar3);
        zzo = zzhkVar15;
        zzhk zzhkVar16 = new zzhk("SINT32", 15, 15, 1, zzidVar4);
        zzp = zzhkVar16;
        zzhk zzhkVar17 = new zzhk("SINT64", 16, 16, 1, zzidVar3);
        zzq = zzhkVar17;
        zzhk zzhkVar18 = new zzhk("GROUP", 17, 17, 1, zzidVar7);
        zzr = zzhkVar18;
        zzhk zzhkVar19 = new zzhk("DOUBLE_LIST", 18, 18, 2, zzidVar);
        zzs = zzhkVar19;
        zzhk zzhkVar20 = new zzhk("FLOAT_LIST", 19, 19, 2, zzidVar2);
        zzt = zzhkVar20;
        zzhk zzhkVar21 = new zzhk("INT64_LIST", 20, 20, 2, zzidVar3);
        zzu = zzhkVar21;
        zzhk zzhkVar22 = new zzhk("UINT64_LIST", 21, 21, 2, zzidVar3);
        zzv = zzhkVar22;
        zzhk zzhkVar23 = new zzhk("INT32_LIST", 22, 22, 2, zzidVar4);
        zzw = zzhkVar23;
        zzhk zzhkVar24 = new zzhk("FIXED64_LIST", 23, 23, 2, zzidVar3);
        zzx = zzhkVar24;
        zzhk zzhkVar25 = new zzhk("FIXED32_LIST", 24, 24, 2, zzidVar4);
        zzy = zzhkVar25;
        zzhk zzhkVar26 = new zzhk("BOOL_LIST", 25, 25, 2, zzidVar5);
        zzz = zzhkVar26;
        zzhk zzhkVar27 = new zzhk("STRING_LIST", 26, 26, 2, zzidVar6);
        zzA = zzhkVar27;
        zzhk zzhkVar28 = new zzhk("MESSAGE_LIST", 27, 27, 2, zzidVar7);
        zzB = zzhkVar28;
        zzhk zzhkVar29 = new zzhk("BYTES_LIST", 28, 28, 2, zzidVar8);
        zzC = zzhkVar29;
        zzhk zzhkVar30 = new zzhk("UINT32_LIST", 29, 29, 2, zzidVar4);
        zzD = zzhkVar30;
        zzhk zzhkVar31 = new zzhk("ENUM_LIST", 30, 30, 2, zzidVar9);
        zzE = zzhkVar31;
        zzhk zzhkVar32 = new zzhk("SFIXED32_LIST", 31, 31, 2, zzidVar4);
        zzF = zzhkVar32;
        zzhk zzhkVar33 = new zzhk("SFIXED64_LIST", 32, 32, 2, zzidVar3);
        zzG = zzhkVar33;
        zzhk zzhkVar34 = new zzhk("SINT32_LIST", 33, 33, 2, zzidVar4);
        zzH = zzhkVar34;
        zzhk zzhkVar35 = new zzhk("SINT64_LIST", 34, 34, 2, zzidVar3);
        zzI = zzhkVar35;
        zzhk zzhkVar36 = new zzhk("DOUBLE_LIST_PACKED", 35, 35, 3, zzidVar);
        zzJ = zzhkVar36;
        zzhk zzhkVar37 = new zzhk("FLOAT_LIST_PACKED", 36, 36, 3, zzidVar2);
        zzK = zzhkVar37;
        zzhk zzhkVar38 = new zzhk("INT64_LIST_PACKED", 37, 37, 3, zzidVar3);
        zzL = zzhkVar38;
        zzhk zzhkVar39 = new zzhk("UINT64_LIST_PACKED", 38, 38, 3, zzidVar3);
        zzM = zzhkVar39;
        zzhk zzhkVar40 = new zzhk("INT32_LIST_PACKED", 39, 39, 3, zzidVar4);
        zzN = zzhkVar40;
        zzhk zzhkVar41 = new zzhk("FIXED64_LIST_PACKED", 40, 40, 3, zzidVar3);
        zzO = zzhkVar41;
        zzhk zzhkVar42 = new zzhk("FIXED32_LIST_PACKED", 41, 41, 3, zzidVar4);
        zzP = zzhkVar42;
        zzhk zzhkVar43 = new zzhk("BOOL_LIST_PACKED", 42, 42, 3, zzidVar5);
        zzQ = zzhkVar43;
        zzhk zzhkVar44 = new zzhk("UINT32_LIST_PACKED", 43, 43, 3, zzidVar4);
        zzR = zzhkVar44;
        zzhk zzhkVar45 = new zzhk("ENUM_LIST_PACKED", 44, 44, 3, zzidVar9);
        zzS = zzhkVar45;
        zzhk zzhkVar46 = new zzhk("SFIXED32_LIST_PACKED", 45, 45, 3, zzidVar4);
        zzT = zzhkVar46;
        zzhk zzhkVar47 = new zzhk("SFIXED64_LIST_PACKED", 46, 46, 3, zzidVar3);
        zzU = zzhkVar47;
        zzhk zzhkVar48 = new zzhk("SINT32_LIST_PACKED", 47, 47, 3, zzidVar4);
        zzV = zzhkVar48;
        zzhk zzhkVar49 = new zzhk("SINT64_LIST_PACKED", 48, 48, 3, zzidVar3);
        zzW = zzhkVar49;
        zzhk zzhkVar50 = new zzhk("GROUP_LIST", 49, 49, 2, zzidVar7);
        zzX = zzhkVar50;
        zzhk zzhkVar51 = new zzhk("MAP", 50, 50, 4, zzid.zza);
        zzY = zzhkVar51;
        zzad = new zzhk[]{zzhkVar, zzhkVar2, zzhkVar3, zzhkVar4, zzhkVar5, zzhkVar6, zzhkVar7, zzhkVar8, zzhkVar9, zzhkVar10, zzhkVar11, zzhkVar12, zzhkVar13, zzhkVar14, zzhkVar15, zzhkVar16, zzhkVar17, zzhkVar18, zzhkVar19, zzhkVar20, zzhkVar21, zzhkVar22, zzhkVar23, zzhkVar24, zzhkVar25, zzhkVar26, zzhkVar27, zzhkVar28, zzhkVar29, zzhkVar30, zzhkVar31, zzhkVar32, zzhkVar33, zzhkVar34, zzhkVar35, zzhkVar36, zzhkVar37, zzhkVar38, zzhkVar39, zzhkVar40, zzhkVar41, zzhkVar42, zzhkVar43, zzhkVar44, zzhkVar45, zzhkVar46, zzhkVar47, zzhkVar48, zzhkVar49, zzhkVar50, zzhkVar51};
        zzhk[] zzhkVarArrValues = values();
        zzac = new zzhk[zzhkVarArrValues.length];
        for (zzhk zzhkVar52 : zzhkVarArrValues) {
            zzac[zzhkVar52.zzaa] = zzhkVar52;
        }
    }

    private zzhk(String str, int i, int i2, int i3, zzid zzidVar) {
        this.zzaa = i2;
        zzid zzidVar2 = zzid.zza;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            zzidVar.zza();
        }
        if (i3 == 1) {
            zzidVar.ordinal();
        }
    }

    public static zzhk[] values() {
        return (zzhk[]) zzad.clone();
    }

    public final int zza() {
        return this.zzaa;
    }
}
