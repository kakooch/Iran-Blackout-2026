package ir.nasim;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;
import ir.nasim.C6906Pm2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.Pm2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6906Pm2 {
    public static final C6906Pm2 a = new C6906Pm2();

    /* renamed from: ir.nasim.Pm2$a */
    public static final class a implements InterfaceC8166Uu5 {
        final /* synthetic */ ProgressDialog a;

        a(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ProgressDialog progressDialog, a aVar) {
            String name;
            AbstractC13042fc3.i(aVar, "this$0");
            try {
                progressDialog.dismiss();
            } catch (Exception unused) {
                if (aVar.getClass().isAnonymousClass()) {
                    name = a.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = a.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.b(name, " Failed to dismiss save file progress dialog");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ProgressDialog progressDialog, int i, a aVar) {
            String name;
            AbstractC13042fc3.i(aVar, "this$0");
            try {
                progressDialog.setProgress(i);
            } catch (Exception unused) {
                if (aVar.getClass().isAnonymousClass()) {
                    name = a.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = a.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.b(name, " Failed to update save file progress dialog");
            }
        }

        @Override // ir.nasim.InterfaceC8166Uu5
        public void a(final int i) {
            final ProgressDialog progressDialog = this.a;
            if (progressDialog == null) {
                return;
            }
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.Nm2
                @Override // java.lang.Runnable
                public final void run() {
                    C6906Pm2.a.e(progressDialog, i, this);
                }
            });
        }

        @Override // ir.nasim.InterfaceC8166Uu5
        public void dismiss() {
            final ProgressDialog progressDialog = this.a;
            if (progressDialog == null) {
                return;
            }
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.Om2
                @Override // java.lang.Runnable
                public final void run() {
                    C6906Pm2.a.d(progressDialog, this);
                }
            });
        }
    }

    private C6906Pm2() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void A(java.lang.String r9, android.content.Context r10, final int r11, java.lang.String r12, java.lang.String r13) {
        /*
            if (r9 != 0) goto L3
            return
        L3:
            int r0 = r9.length()
            r1 = 0
            if (r0 == 0) goto L18
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            boolean r9 = r0.exists()
            if (r9 != 0) goto L16
            return
        L16:
            r6 = r0
            goto L19
        L18:
            r6 = r1
        L19:
            if (r6 != 0) goto L1c
            return
        L1c:
            r9 = 1
            boolean[] r8 = new boolean[r9]
            if (r10 == 0) goto L54
            android.app.ProgressDialog r0 = new android.app.ProgressDialog     // Catch: java.lang.Exception -> L4e
            r0.<init>(r10)     // Catch: java.lang.Exception -> L4e
            int r1 = ir.nasim.AbstractC12217eE5.progress_common     // Catch: java.lang.Exception -> L4b
            java.lang.String r10 = r10.getString(r1)     // Catch: java.lang.Exception -> L4b
            r0.setMessage(r10)     // Catch: java.lang.Exception -> L4b
            r10 = 0
            r0.setCanceledOnTouchOutside(r10)     // Catch: java.lang.Exception -> L4b
            r0.setCancelable(r10)     // Catch: java.lang.Exception -> L4b
            r0.setProgressStyle(r9)     // Catch: java.lang.Exception -> L4b
            r9 = 100
            r0.setMax(r9)     // Catch: java.lang.Exception -> L4b
            ir.nasim.Lm2 r9 = new ir.nasim.Lm2     // Catch: java.lang.Exception -> L4b
            r9.<init>()     // Catch: java.lang.Exception -> L4b
            r0.setOnCancelListener(r9)     // Catch: java.lang.Exception -> L4b
            r0.show()     // Catch: java.lang.Exception -> L4b
            r1 = r0
            goto L54
        L4b:
            r9 = move-exception
            r1 = r0
            goto L4f
        L4e:
            r9 = move-exception
        L4f:
            java.lang.String r10 = "baleMessages"
            ir.nasim.C19406qI3.d(r10, r9)
        L54:
            ir.nasim.Pm2$a r7 = new ir.nasim.Pm2$a
            r7.<init>(r1)
            if (r12 != 0) goto L5f
            java.lang.String r12 = r6.getName()
        L5f:
            if (r13 == 0) goto L6a
            int r9 = r13.length()
            if (r9 != 0) goto L68
            goto L6a
        L68:
            r5 = r13
            goto L7c
        L6a:
            android.webkit.MimeTypeMap r9 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r10 = l(r12)
            java.lang.String r9 = r9.getMimeTypeFromExtension(r10)
            if (r9 != 0) goto L7a
            java.lang.String r9 = "application/octet-stream"
        L7a:
            r13 = r9
            goto L68
        L7c:
            if (r12 != 0) goto L82
            java.lang.String r9 = ""
            r4 = r9
            goto L83
        L82:
            r4 = r12
        L83:
            ir.nasim.Zc6 r9 = new ir.nasim.Zc6
            ir.nasim.Ic6 r10 = new ir.nasim.Ic6
            ir.nasim.Mm2 r12 = new ir.nasim.Mm2
            r2 = r12
            r3 = r11
            r2.<init>()
            r10.<init>(r12)
            r9.<init>(r10)
            ir.nasim.dV1 r10 = ir.nasim.EnumC11723dV1.IO
            ir.nasim.Zc6 r9 = r9.h(r10)
            java.lang.String r10 = "subscribeOn(...)"
            ir.nasim.AbstractC13042fc3.h(r9, r10)
            ir.nasim.SZ.e(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6906Pm2.A(java.lang.String, android.content.Context, int, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(boolean[] zArr, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(zArr, "$cancelled");
        zArr[0] = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(int i, String str, String str2, File file, InterfaceC8166Uu5 interfaceC8166Uu5, boolean[] zArr) throws Throwable {
        AbstractC13042fc3.i(str, "$finalName");
        AbstractC13042fc3.i(file, "$sourceFile");
        AbstractC13042fc3.i(interfaceC8166Uu5, "$progressDialogCallback");
        AbstractC13042fc3.i(zArr, "$cancelled");
        a.z(i, str, str2, file, interfaceC8166Uu5, zArr);
    }

    public static final void c(String str) {
        if (str == null) {
            return;
        }
        a.d(Uri.fromFile(new File(str)));
    }

    public static final boolean e(InputStream inputStream, File file) throws IOException {
        AbstractC13042fc3.i(inputStream, "sourceFile");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                fileOutputStream.close();
                return true;
            }
            Thread.yield();
            fileOutputStream.write(bArr, 0, i);
        }
    }

    private final String f(Uri uri) throws Throwable {
        String strF = AbstractC14815iX3.f(uri);
        String str = j().getAbsolutePath() + File.separator + strF;
        if (uri != null) {
            try {
                InputStream inputStreamOpenInputStream = C5721Ko.a.d().getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    e(inputStreamOpenInputStream, new File(str));
                }
            } catch (Exception e) {
                C19406qI3.c("AndroidUtilities", "copyToCache", e);
            }
        }
        return str;
    }

    public static final File j() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
            externalStorageState = null;
        }
        if (externalStorageState == null || AbstractC20153rZ6.S(externalStorageState, "mounted", false, 2, null)) {
            try {
                File externalCacheDir = C5721Ko.a.d().getExternalCacheDir();
                if (externalCacheDir != null) {
                    return externalCacheDir;
                }
            } catch (Exception e2) {
                C19406qI3.d("baleMessages", e2);
            }
        }
        try {
            File cacheDir = C5721Ko.a.d().getCacheDir();
            if (cacheDir != null) {
                return cacheDir;
            }
        } catch (Exception e3) {
            C19406qI3.d("baleMessages", e3);
        }
        return new File("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        if (ir.nasim.AbstractC20153rZ6.S(r9, "file://", false, 2, null) == false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[PHI: r8
      0x005a: PHI (r8v4 android.database.Cursor) = (r8v3 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:29:0x0067, B:22:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String k(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "context"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            java.lang.String r0 = "uri"
            ir.nasim.AbstractC13042fc3.i(r9, r0)
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L60
            if (r8 == 0) goto L58
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            if (r9 == 0) goto L58
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            ir.nasim.AbstractC13042fc3.f(r9)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            java.lang.String r10 = "content://"
            r11 = 2
            r0 = 0
            boolean r10 = ir.nasim.AbstractC14836iZ6.S(r9, r10, r0, r11, r7)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            if (r10 != 0) goto L54
            java.lang.String r10 = "/"
            boolean r10 = ir.nasim.AbstractC14836iZ6.S(r9, r10, r0, r11, r7)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            if (r10 != 0) goto L50
            java.lang.String r10 = "file://"
            boolean r10 = ir.nasim.AbstractC14836iZ6.S(r9, r10, r0, r11, r7)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            if (r10 != 0) goto L50
            goto L54
        L4b:
            r9 = move-exception
            r7 = r8
            goto L6b
        L4e:
            r9 = move-exception
            goto L62
        L50:
            r8.close()
            return r9
        L54:
            r8.close()
            return r7
        L58:
            if (r8 == 0) goto L6a
        L5a:
            r8.close()
            goto L6a
        L5e:
            r9 = move-exception
            goto L6b
        L60:
            r9 = move-exception
            r8 = r7
        L62:
            java.lang.String r10 = "baleMessages"
            ir.nasim.C19406qI3.d(r10, r9)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L6a
            goto L5a
        L6a:
            return r7
        L6b:
            if (r7 == 0) goto L70
            r7.close()
        L70:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6906Pm2.k(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static final String l(String str) {
        int iR0;
        if (str == null || str.length() == 0 || (iR0 = AbstractC20762sZ6.r0(str, Separators.DOT, 0, false, 6, null)) <= 0) {
            return "";
        }
        String strSubstring = str.substring(iR0 + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String m(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int iR0 = AbstractC20762sZ6.r0(str, Separators.DOT, 0, false, 6, null);
        if (iR0 <= 0) {
            return str;
        }
        String strSubstring = str.substring(0, iR0);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String o(String str) {
        if (str == null) {
            return null;
        }
        String strP = p(str);
        return AbstractC13042fc3.d(strP, "") ? URLConnection.guessContentTypeFromName(str) : strP;
    }

    public static final String p(String str) {
        String str2;
        AbstractC13042fc3.i(str, "path");
        try {
            String strSubstring = str.substring(AbstractC20762sZ6.q0(str, '.', 0, false, 6, null));
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            String lowerCase = strSubstring.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case 1422702:
                    return !lowerCase.equals(".3gp") ? "" : "video/3gp";
                case 1467366:
                    str2 = ".avi";
                    break;
                case 1471874:
                    str2 = ".flv";
                    break;
                case 1476865:
                    if (lowerCase.equals(".m4v")) {
                        return "video/x-m4v";
                    }
                case 1478570:
                    if (lowerCase.equals(".mkv")) {
                        return "video/x-matroska";
                    }
                case 1478659:
                    if (lowerCase.equals(".mp4")) {
                        return "video/mp4";
                    }
                case 1478694:
                    if (lowerCase.equals(".mov")) {
                        return "video/quicktime";
                    }
                case 1478846:
                    if (lowerCase.equals(".mts")) {
                        return "video/mts";
                    }
                case 1487323:
                    if (lowerCase.equals(".vob")) {
                        return "video/x-ms-vob";
                    }
                case 1488242:
                    str2 = ".wmv";
                    break;
                case 46127303:
                    if (lowerCase.equals(".webm")) {
                        return "video/webm";
                    }
                default:
            }
            lowerCase.equals(str2);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076 A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:3:0x0006, B:5:0x0013, B:8:0x001e, B:10:0x0034, B:11:0x003c, B:13:0x0042, B:16:0x004f, B:20:0x0062, B:22:0x0076, B:19:0x005e, B:24:0x0091, B:26:0x0097, B:28:0x00ba, B:30:0x00c0, B:32:0x00d6, B:33:0x00de, B:35:0x00e4, B:38:0x00f1, B:40:0x0101, B:42:0x0115, B:50:0x0134, B:43:0x0118, B:45:0x0120, B:46:0x0123, B:48:0x012b, B:49:0x012e, B:39:0x00fd, B:52:0x014a, B:54:0x0156, B:56:0x015f, B:58:0x016b), top: B:62:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String q(android.net.Uri r7) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6906Pm2.q(android.net.Uri):java.lang.String");
    }

    public static final boolean s(String str) {
        if (str == null || !AbstractC20762sZ6.X(str, Separators.DOT, false, 2, null)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return AbstractC20153rZ6.C(lowerCase, ".mp3", false, 2, null) || AbstractC20153rZ6.C(lowerCase, ".m4a", false, 2, null) || AbstractC20153rZ6.C(lowerCase, ".wav", false, 2, null) || AbstractC20153rZ6.C(lowerCase, ".opus", false, 2, null) || AbstractC20153rZ6.C(lowerCase, ".flac", false, 2, null) || AbstractC20153rZ6.C(lowerCase, ".aac", false, 2, null) || AbstractC20153rZ6.C(lowerCase, ".ac3", false, 2, null) || AbstractC20153rZ6.C(lowerCase, ".amr", false, 2, null);
    }

    public static final boolean w(String str) {
        return (str == null || AbstractC13042fc3.d(str, "") || !AbstractC20153rZ6.S(str, MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null)) ? false : true;
    }

    public static final boolean x(String str) {
        AbstractC13042fc3.i(str, "path");
        return w(p(str));
    }

    public static final boolean y(String str) {
        if (str == null || !AbstractC20762sZ6.X(str, Separators.DOT, false, 2, null)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return AbstractC20153rZ6.C(lowerCase, ".ogg", false, 2, null) || AbstractC20153rZ6.C(lowerCase, ".opus", false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[Catch: all -> 0x003e, Exception -> 0x0041, SYNTHETIC, TRY_LEAVE, TryCatch #17 {all -> 0x003e, blocks: (B:3:0x000c, B:36:0x007f, B:40:0x008a, B:42:0x0090, B:44:0x0096, B:128:0x01a2, B:129:0x01ad, B:130:0x01be, B:132:0x01d0, B:135:0x01d7, B:136:0x01ee, B:154:0x0215, B:142:0x0200, B:148:0x020b, B:153:0x0214, B:152:0x0211, B:146:0x0206, B:9:0x0029, B:11:0x0035, B:19:0x0044, B:22:0x004c, B:23:0x0052, B:25:0x005e, B:29:0x0066, B:32:0x006e, B:33:0x0074, B:34:0x0079), top: B:185:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z(int r25, java.lang.String r26, java.lang.String r27, java.io.File r28, ir.nasim.InterfaceC8166Uu5 r29, boolean[] r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6906Pm2.z(int, java.lang.String, java.lang.String, java.io.File, ir.nasim.Uu5, boolean[]):void");
    }

    public final void d(Uri uri) {
        if (uri == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            C5721Ko.a.d().sendBroadcast(intent);
        } catch (Exception e) {
            Log.e("AndroidUtilities", "addMediaToGalley " + e.getMessage());
        }
    }

    public final File g() {
        try {
            return new File(i(), "IMG_" + new SimpleDateFormat(AbstractC7426Rr.a.j(), Locale.US).format(new Date()) + ".jpg");
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Error generating picture path";
            }
            Log.e("baleMessages", message);
            return null;
        }
    }

    public final File h() {
        try {
            return new File(i(), "VID_" + new SimpleDateFormat(AbstractC7426Rr.a.j(), Locale.US).format(new Date()) + ".mp4");
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "exception at generateVideoPath";
            }
            Log.e("baleMessages", message);
            return null;
        }
    }

    public final File i() throws IOException {
        if (Build.VERSION.SDK_INT <= 29 && C5721Ko.a.d().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            String strQ = C4053Dm2.q();
            if (strQ == null) {
                return null;
            }
            File file = new File(strQ);
            file.mkdir();
            return file;
        }
        if (!AbstractC13042fc3.d("mounted", Environment.getExternalStorageState())) {
            C19406qI3.a("nmessages", "External storage is not mounted READ/WRITE.", new Object[0]);
            return null;
        }
        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Bale");
        if (file2.mkdirs() || file2.exists()) {
            return file2;
        }
        C19406qI3.a("nmessages", "failed to create directory", new Object[0]);
        return null;
    }

    public final String n(String str, String str2) {
        String extensionFromMimeType;
        if (str == null || str2 == null || l(str).length() > 0 || (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str2)) == null) {
            return str;
        }
        return str + Separators.DOT + extensionFromMimeType;
    }

    public final String r(Uri uri) throws Throwable {
        String strQ;
        if (uri == null) {
            strQ = null;
        } else if (!AbstractC13042fc3.d("content", uri.getScheme()) || Build.VERSION.SDK_INT < 29) {
            strQ = q(uri);
            if (strQ == null && (!AbstractC13042fc3.d("content", uri.getScheme()) || (strQ = Uri.parse(uri.getPath()).getPath()) == null)) {
                strQ = uri.getPath();
            }
        } else {
            strQ = f(uri);
        }
        return (strQ == null || !new File(strQ).exists()) ? f(uri) : strQ;
    }

    public final boolean t(Uri uri) {
        AbstractC13042fc3.i(uri, "uri");
        return AbstractC13042fc3.d("com.android.providers.downloads.documents", uri.getAuthority());
    }

    public final boolean u(Uri uri) {
        AbstractC13042fc3.i(uri, "uri");
        return AbstractC13042fc3.d("com.android.externalstorage.documents", uri.getAuthority());
    }

    public final boolean v(Uri uri) {
        AbstractC13042fc3.i(uri, "uri");
        return AbstractC13042fc3.d("com.android.providers.media.documents", uri.getAuthority());
    }
}
