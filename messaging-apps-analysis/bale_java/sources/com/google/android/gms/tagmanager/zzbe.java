package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.gtm.zzfz;
import ir.nasim.BD1;
import ir.nasim.OV0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
final class zzbe implements zzax {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Executor zzb;
    private final Context zzc;
    private final zzbc zzd;
    private final OV0 zze;

    public zzbe(Context context) {
        OV0 ov0A = BD1.a();
        ExecutorService executorServiceZza = zzfz.zza().zza(2);
        this.zzc = context;
        this.zze = ov0A;
        this.zzb = executorServiceZza;
        this.zzd = new zzbc(this, context, "google_tagmanager.db");
    }

    static /* bridge */ /* synthetic */ List zzf(zzbe zzbeVar) {
        ObjectInputStream objectInputStream;
        try {
            zzbeVar.zzk(zzbeVar.zze.currentTimeMillis());
            SQLiteDatabase sQLiteDatabaseZzi = zzbeVar.zzi("Error opening database for loadSerialized.");
            ArrayList<zzbd> arrayList = new ArrayList();
            if (sQLiteDatabaseZzi != null) {
                Cursor cursorQuery = sQLiteDatabaseZzi.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(new zzbd(cursorQuery.getString(0), cursorQuery.getBlob(1)));
                    } finally {
                        cursorQuery.close();
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (zzbd zzbdVar : arrayList) {
                String str = zzbdVar.zza;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zzbdVar.zzb);
                ObjectInputStream objectInputStream2 = null;
                object = null;
                object = null;
                object = null;
                Object object = null;
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (IOException unused) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused2) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    object = objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    arrayList2.add(new zzau(str, object));
                } catch (ClassNotFoundException unused5) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    arrayList2.add(new zzau(str, object));
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException unused6) {
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    throw th;
                }
                byteArrayInputStream.close();
                arrayList2.add(new zzau(str, object));
            }
            return arrayList2;
        } finally {
            zzbeVar.zzj();
        }
    }

    private final SQLiteDatabase zzi(String str) {
        try {
            return this.zzd.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdh.zzc(str);
            return null;
        }
    }

    private final void zzj() {
        try {
            this.zzd.close();
        } catch (SQLiteException unused) {
        }
    }

    private final void zzk(long j) {
        SQLiteDatabase sQLiteDatabaseZzi = zzi("Error opening database for deleteOlderThan.");
        if (sQLiteDatabaseZzi == null) {
            return;
        }
        try {
            int iDelete = sQLiteDatabaseZzi.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)});
            StringBuilder sb = new StringBuilder(33);
            sb.append("Deleted ");
            sb.append(iDelete);
            sb.append(" expired items");
            zzdh.zzb.zzd(sb.toString());
        } catch (SQLiteException unused) {
            zzdh.zzc("Error deleting old entries.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #4 {all -> 0x0035, blocks: (B:4:0x0003, B:27:0x004a, B:29:0x004f, B:42:0x009a, B:72:0x013b, B:73:0x013e, B:56:0x00c6, B:58:0x00f1, B:61:0x00f5, B:63:0x00fd, B:64:0x0115, B:66:0x011b, B:68:0x012b, B:70:0x0135, B:69:0x0130, B:74:0x013f, B:77:0x014a, B:78:0x014e, B:80:0x0154, B:16:0x0031, B:88:0x0185, B:89:0x0188, B:26:0x0046), top: B:97:0x0003, outer: #1, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013b A[Catch: all -> 0x0035, TryCatch #4 {all -> 0x0035, blocks: (B:4:0x0003, B:27:0x004a, B:29:0x004f, B:42:0x009a, B:72:0x013b, B:73:0x013e, B:56:0x00c6, B:58:0x00f1, B:61:0x00f5, B:63:0x00fd, B:64:0x0115, B:66:0x011b, B:68:0x012b, B:70:0x0135, B:69:0x0130, B:74:0x013f, B:77:0x014a, B:78:0x014e, B:80:0x0154, B:16:0x0031, B:88:0x0185, B:89:0x0188, B:26:0x0046), top: B:97:0x0003, outer: #1, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014a A[Catch: all -> 0x0035, TryCatch #4 {all -> 0x0035, blocks: (B:4:0x0003, B:27:0x004a, B:29:0x004f, B:42:0x009a, B:72:0x013b, B:73:0x013e, B:56:0x00c6, B:58:0x00f1, B:61:0x00f5, B:63:0x00fd, B:64:0x0115, B:66:0x011b, B:68:0x012b, B:70:0x0135, B:69:0x0130, B:74:0x013f, B:77:0x014a, B:78:0x014e, B:80:0x0154, B:16:0x0031, B:88:0x0185, B:89:0x0188, B:26:0x0046), top: B:97:0x0003, outer: #1, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0185 A[Catch: all -> 0x0035, TRY_ENTER, TryCatch #4 {all -> 0x0035, blocks: (B:4:0x0003, B:27:0x004a, B:29:0x004f, B:42:0x009a, B:72:0x013b, B:73:0x013e, B:56:0x00c6, B:58:0x00f1, B:61:0x00f5, B:63:0x00fd, B:64:0x0115, B:66:0x011b, B:68:0x012b, B:70:0x0135, B:69:0x0130, B:74:0x013f, B:77:0x014a, B:78:0x014e, B:80:0x0154, B:16:0x0031, B:88:0x0185, B:89:0x0188, B:26:0x0046), top: B:97:0x0003, outer: #1, inners: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzl(java.util.List<com.google.android.gms.tagmanager.zzbd> r18, long r19) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbe.zzl(java.util.List, long):void");
    }

    @Override // com.google.android.gms.tagmanager.zzax
    public final void zzb(zzaw zzawVar) {
        this.zzb.execute(new zzba(this, zzawVar));
    }

    @Override // com.google.android.gms.tagmanager.zzax
    public final void zzc(List<zzau> list, long j) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ArrayList arrayList = new ArrayList();
        for (zzau zzauVar : list) {
            String str = zzauVar.zza;
            Object obj = zzauVar.zzb;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = null;
            byteArray = null;
            byte[] byteArray = null;
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (IOException unused) {
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    byteArrayOutputStream.close();
                    arrayList.add(new zzbd(str, byteArray));
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException unused2) {
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException unused3) {
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException unused4) {
            }
            arrayList.add(new zzbd(str, byteArray));
        }
        this.zzb.execute(new zzaz(this, arrayList, j));
    }
}
