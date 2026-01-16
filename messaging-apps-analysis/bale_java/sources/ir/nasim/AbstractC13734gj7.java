package ir.nasim;

import android.database.Cursor;
import ir.nasim.C13143fj7;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: ir.nasim.gj7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13734gj7 {
    private static final Map a(InterfaceC12694f27 interfaceC12694f27, String str) throws IOException {
        Cursor cursorR1 = interfaceC12694f27.r1("PRAGMA table_info(`" + str + "`)");
        try {
            Cursor cursor = cursorR1;
            if (cursor.getColumnCount() <= 0) {
                Map mapK = AbstractC20051rO3.k();
                YV0.a(cursorR1, null);
                return mapK;
            }
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("type");
            int columnIndex3 = cursor.getColumnIndex("notnull");
            int columnIndex4 = cursor.getColumnIndex("pk");
            int columnIndex5 = cursor.getColumnIndex("dflt_value");
            Map mapD = AbstractC19460qO3.d();
            while (cursor.moveToNext()) {
                String string = cursor.getString(columnIndex);
                String string2 = cursor.getString(columnIndex2);
                boolean z = cursor.getInt(columnIndex3) != 0;
                int i = cursor.getInt(columnIndex4);
                String string3 = cursor.getString(columnIndex5);
                AbstractC13042fc3.h(string, "name");
                AbstractC13042fc3.h(string2, "type");
                mapD.put(string, new C13143fj7.a(string, string2, z, i, string3, 2));
            }
            Map mapC = AbstractC19460qO3.c(mapD);
            YV0.a(cursorR1, null);
            return mapC;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                YV0.a(cursorR1, th);
                throw th2;
            }
        }
    }

    private static final List b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        List listC = AbstractC9766aX0.c();
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i2 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            AbstractC13042fc3.h(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            AbstractC13042fc3.h(string2, "cursor.getString(toColumnIndex)");
            listC.add(new C13143fj7.d(i, i2, string, string2));
        }
        return AbstractC15401jX0.Z0(AbstractC9766aX0.a(listC));
    }

    private static final Set c(InterfaceC12694f27 interfaceC12694f27, String str) throws IOException {
        Cursor cursorR1 = interfaceC12694f27.r1("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            Cursor cursor = cursorR1;
            int columnIndex = cursor.getColumnIndex("id");
            int columnIndex2 = cursor.getColumnIndex("seq");
            int columnIndex3 = cursor.getColumnIndex("table");
            int columnIndex4 = cursor.getColumnIndex("on_delete");
            int columnIndex5 = cursor.getColumnIndex("on_update");
            List listB = b(cursor);
            cursor.moveToPosition(-1);
            Set setB = AbstractC4363Eu6.b();
            while (cursor.moveToNext()) {
                if (cursor.getInt(columnIndex2) == 0) {
                    int i = cursor.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<C13143fj7.d> arrayList3 = new ArrayList();
                    for (Object obj : listB) {
                        if (((C13143fj7.d) obj).i() == i) {
                            arrayList3.add(obj);
                        }
                    }
                    for (C13143fj7.d dVar : arrayList3) {
                        arrayList.add(dVar.h());
                        arrayList2.add(dVar.j());
                    }
                    String string = cursor.getString(columnIndex3);
                    AbstractC13042fc3.h(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursor.getString(columnIndex4);
                    AbstractC13042fc3.h(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursor.getString(columnIndex5);
                    AbstractC13042fc3.h(string3, "cursor.getString(onUpdateColumnIndex)");
                    setB.add(new C13143fj7.c(string, string2, string3, arrayList, arrayList2));
                }
            }
            Set setA = AbstractC4363Eu6.a(setB);
            YV0.a(cursorR1, null);
            return setA;
        } finally {
        }
    }

    private static final C13143fj7.e d(InterfaceC12694f27 interfaceC12694f27, String str, boolean z) throws IOException {
        Cursor cursorR1 = interfaceC12694f27.r1("PRAGMA index_xinfo(`" + str + "`)");
        try {
            Cursor cursor = cursorR1;
            int columnIndex = cursor.getColumnIndex("seqno");
            int columnIndex2 = cursor.getColumnIndex("cid");
            int columnIndex3 = cursor.getColumnIndex("name");
            int columnIndex4 = cursor.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursor.moveToNext()) {
                    if (cursor.getInt(columnIndex2) >= 0) {
                        int i = cursor.getInt(columnIndex);
                        String string = cursor.getString(columnIndex3);
                        String str2 = cursor.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i);
                        AbstractC13042fc3.h(string, "columnName");
                        treeMap.put(numValueOf, string);
                        treeMap2.put(Integer.valueOf(i), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                AbstractC13042fc3.h(collectionValues, "columnsMap.values");
                List listM1 = AbstractC15401jX0.m1(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                AbstractC13042fc3.h(collectionValues2, "ordersMap.values");
                C13143fj7.e eVar = new C13143fj7.e(str, z, listM1, AbstractC15401jX0.m1(collectionValues2));
                YV0.a(cursorR1, null);
                return eVar;
            }
            YV0.a(cursorR1, null);
            return null;
        } finally {
        }
    }

    private static final Set e(InterfaceC12694f27 interfaceC12694f27, String str) throws IOException {
        Cursor cursorR1 = interfaceC12694f27.r1("PRAGMA index_list(`" + str + "`)");
        try {
            Cursor cursor = cursorR1;
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("origin");
            int columnIndex3 = cursor.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                Set setB = AbstractC4363Eu6.b();
                while (cursor.moveToNext()) {
                    if (AbstractC13042fc3.d("c", cursor.getString(columnIndex2))) {
                        String string = cursor.getString(columnIndex);
                        boolean z = true;
                        if (cursor.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        AbstractC13042fc3.h(string, "name");
                        C13143fj7.e eVarD = d(interfaceC12694f27, string, z);
                        if (eVarD == null) {
                            YV0.a(cursorR1, null);
                            return null;
                        }
                        setB.add(eVarD);
                    }
                }
                Set setA = AbstractC4363Eu6.a(setB);
                YV0.a(cursorR1, null);
                return setA;
            }
            YV0.a(cursorR1, null);
            return null;
        } finally {
        }
    }

    public static final C13143fj7 f(InterfaceC12694f27 interfaceC12694f27, String str) {
        AbstractC13042fc3.i(interfaceC12694f27, "database");
        AbstractC13042fc3.i(str, "tableName");
        return new C13143fj7(str, a(interfaceC12694f27, str), c(interfaceC12694f27, str), e(interfaceC12694f27, str));
    }
}
