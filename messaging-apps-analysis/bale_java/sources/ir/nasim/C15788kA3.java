package ir.nasim;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.kA3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15788kA3 {
    private static Account e;
    public static final C15788kA3 a = new C15788kA3();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.hA3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C15788kA3.h();
        }
    });
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.iA3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C15788kA3.d();
        }
    });
    private static final InterfaceC9173Yu3 d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jA3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C15788kA3.i();
        }
    });
    public static final int f = 8;

    private C15788kA3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountManager d() {
        return AccountManager.get(C5721Ko.a.d());
    }

    private final List f(C16388lB3 c16388lB3, int i) {
        if (e == null || c16388lB3 == null) {
            return AbstractC10360bX0.m();
        }
        if (!C21753u45.a.T()) {
            return AbstractC10360bX0.m();
        }
        Uri uriBuild = ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        Account account = e;
        ContentProviderOperation.Builder builderWithValue = builderNewInsert.withValue("account_name", account != null ? account.name : null);
        Account account2 = e;
        return AbstractC10360bX0.p(builderWithValue.withValue("account_type", account2 != null ? account2.type : null).withValue("sync1", c16388lB3.b()).withValue("sync2", Integer.valueOf(c16388lB3.c())).build(), ContentProviderOperation.newInsert(uriBuild).withValueBackReference("raw_contact_id", i).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data1", c16388lB3.a()).build(), ContentProviderOperation.newInsert(uriBuild).withValueBackReference("raw_contact_id", i).withValue("mimetype", "vnd.android.cursor.item/vnd.ir.nasim.profile").withValue("data1", Integer.valueOf(c16388lB3.c())).withValue("data2", "Bale Profile").withValue("data3", "Message +" + c16388lB3.b()).withYieldAllowed(true).build(), ContentProviderOperation.newInsert(uriBuild).withValueBackReference("raw_contact_id", i).withValue("mimetype", "vnd.android.cursor.item/vnd.ir.nasim.call").withValue("data1", Integer.valueOf(c16388lB3.c())).withValue("data2", "Bale Voice Call").withValue("data3", "Voice call +" + c16388lB3.b()).withYieldAllowed(true).build(), ContentProviderOperation.newInsert(uriBuild).withValueBackReference("raw_contact_id", i).withValue("mimetype", "vnd.android.cursor.item/vnd.ir.nasim.video").withValue("data1", Integer.valueOf(c16388lB3.c())).withValue("data2", "Bale Video Call").withValue("data3", "Video call +" + c16388lB3.b()).withYieldAllowed(true).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentResolver h() {
        return C5721Ko.a.d().getContentResolver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i() {
        return String.valueOf(AbstractC5969Lp4.f());
    }

    private final AccountManager k() {
        Object value = c.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (AccountManager) value;
    }

    private final ContentResolver l() {
        Object value = b.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (ContentResolver) value;
    }

    public final void e(List list) throws RemoteException, OperationApplicationException {
        AbstractC13042fc3.i(list, "users");
        g();
        if (e != null && C21753u45.a.T()) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList, a.f((C16388lB3) it.next(), arrayList.size()));
            }
            if (!arrayList.isEmpty()) {
                try {
                    l().applyBatch("com.android.contacts", arrayList);
                } catch (Exception e2) {
                    C19406qI3.b("LinkedContactDetails", "applyBatch e : " + e2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        ir.nasim.C15788kA3.e = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r11 = this;
            java.lang.String r0 = "exception : "
            java.lang.String r1 = "LinkedContactDetails"
            java.lang.String r2 = "com.bale.messenger"
            android.accounts.Account r3 = ir.nasim.C15788kA3.e
            if (r3 == 0) goto Lb
            return
        Lb:
            r3 = 0
            r4 = 0
            android.accounts.AccountManager r5 = r11.k()     // Catch: java.lang.Exception -> L31
            android.accounts.Account[] r5 = r5.getAccountsByType(r2)     // Catch: java.lang.Exception -> L31
            java.lang.String r6 = "getAccountsByType(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r6)     // Catch: java.lang.Exception -> L31
            ir.nasim.C15788kA3.e = r3     // Catch: java.lang.Exception -> L31
            int r6 = r5.length     // Catch: java.lang.Exception -> L31
            r7 = r4
        L1e:
            if (r7 >= r6) goto L4a
            r8 = r5[r7]     // Catch: java.lang.Exception -> L31
            java.lang.String r9 = r8.name     // Catch: java.lang.Exception -> L31
            java.lang.String r10 = r11.m()     // Catch: java.lang.Exception -> L31
            boolean r9 = ir.nasim.AbstractC13042fc3.d(r9, r10)     // Catch: java.lang.Exception -> L31
            if (r9 == 0) goto L33
            ir.nasim.C15788kA3.e = r8     // Catch: java.lang.Exception -> L31
            goto L4a
        L31:
            r5 = move-exception
            goto L36
        L33:
            int r7 = r7 + 1
            goto L1e
        L36:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            ir.nasim.C19406qI3.a(r1, r5, r6)
        L4a:
            android.accounts.Account r5 = ir.nasim.C15788kA3.e
            if (r5 != 0) goto L7a
            android.accounts.Account r5 = new android.accounts.Account     // Catch: java.lang.Exception -> L65
            java.lang.String r6 = r11.m()     // Catch: java.lang.Exception -> L65
            r5.<init>(r6, r2)     // Catch: java.lang.Exception -> L65
            ir.nasim.C15788kA3.e = r5     // Catch: java.lang.Exception -> L65
            android.accounts.AccountManager r2 = r11.k()     // Catch: java.lang.Exception -> L65
            android.accounts.Account r5 = ir.nasim.C15788kA3.e     // Catch: java.lang.Exception -> L65
            java.lang.String r6 = ""
            r2.addAccountExplicitly(r5, r6, r3)     // Catch: java.lang.Exception -> L65
            goto L7a
        L65:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r4]
            ir.nasim.C19406qI3.a(r1, r0, r2)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15788kA3.g():void");
    }

    public final void j() {
        C19406qI3.a("LinkedContactDetails", "Deleting app account...", new Object[0]);
        try {
            Account[] accountsByType = k().getAccountsByType("com.bale.messenger");
            AbstractC13042fc3.h(accountsByType, "getAccountsByType(...)");
            e = null;
            for (Account account : accountsByType) {
                if (AbstractC13042fc3.d(account.name, m())) {
                    k().removeAccountExplicitly(account);
                    return;
                }
            }
        } catch (Exception e2) {
            C19406qI3.a("LinkedContactDetails", "exception : " + e2, new Object[0]);
        }
    }

    public final String m() {
        return (String) d.getValue();
    }

    public final void n(List list) throws Throwable {
        Integer numValueOf;
        AbstractC13042fc3.i(list, "users");
        Cursor cursor = null;
        try {
            try {
                ContentResolver contentResolver = C5721Ko.a.d().getContentResolver();
                AbstractC13042fc3.h(contentResolver, "getContentResolver(...)");
                Uri.Builder builderBuildUpon = ContactsContract.RawContacts.CONTENT_URI.buildUpon();
                Account account = e;
                Uri.Builder builderAppendQueryParameter = builderBuildUpon.appendQueryParameter("account_name", account != null ? account.name : null);
                Account account2 = e;
                Uri uriBuild = builderAppendQueryParameter.appendQueryParameter("account_type", account2 != null ? account2.type : null).build();
                String[] strArr = {"_id", "sync2", "sync1"};
                Cursor cursorQuery = contentResolver.query(uriBuild, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        numValueOf = Integer.valueOf(cursorQuery.getColumnIndex(strArr[0]));
                    } catch (Exception e2) {
                        e = e2;
                        cursor = cursorQuery;
                        C19406qI3.d("LinkedContactDetails", e);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else {
                    numValueOf = null;
                }
                Integer numValueOf2 = cursorQuery != null ? Integer.valueOf(cursorQuery.getColumnIndex(strArr[1])) : null;
                C21892uJ3 c21892uJ3 = new C21892uJ3(0, 1, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        AbstractC13042fc3.f(numValueOf2);
                        long j = cursorQuery.getLong(numValueOf2.intValue());
                        AbstractC13042fc3.f(numValueOf);
                        c21892uJ3.l(j, Long.valueOf(cursorQuery.getLong(numValueOf.intValue())));
                    }
                    cursorQuery.close();
                    ArrayList arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        C16388lB3 c16388lB3 = (C16388lB3) list.get(i);
                        if (c21892uJ3.h(c16388lB3.c()) < 0) {
                            arrayList.add(c16388lB3);
                        }
                    }
                    e(arrayList);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
