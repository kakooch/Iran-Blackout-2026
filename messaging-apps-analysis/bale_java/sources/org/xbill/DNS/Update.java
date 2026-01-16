package org.xbill.DNS;

import ir.nasim.C19356qC7;
import java.util.function.Consumer;
import org.xbill.DNS.Record;

/* loaded from: classes8.dex */
public class Update extends Message {
    private final int dclass;
    private final Name origin;

    public Update(Name name, int i) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        DClass.check(i);
        getHeader().setOpcode(5);
        addRecord(Record.newRecord(name, 6, 1), 0);
        this.origin = name;
        this.dclass = i;
    }

    private void newPrereq(Record record) {
        addRecord(record, 1);
    }

    private void newUpdate(Record record) {
        addRecord(record, 2);
    }

    public void absent(Name name) {
        newPrereq(Record.newRecord(name, 255, 254, 0L));
    }

    public void add(Name name, int i, long j, String str) {
        newUpdate(Record.fromString(name, i, this.dclass, j, str, this.origin));
    }

    public void delete(Name name) {
        newUpdate(Record.newRecord(name, 255, 255, 0L));
    }

    public void present(Name name) {
        newPrereq(Record.newRecord(name, 255, 255, 0L));
    }

    public void replace(Name name, int i, long j, String str) {
        delete(name, i);
        add(name, i, j, str);
    }

    public void absent(Name name, int i) {
        newPrereq(Record.newRecord(name, i, 254, 0L));
    }

    public void add(Name name, int i, long j, Tokenizer tokenizer) {
        newUpdate(Record.fromString(name, i, this.dclass, j, tokenizer, this.origin));
    }

    public void delete(Name name, int i) {
        newUpdate(Record.newRecord(name, i, 255, 0L));
    }

    public void present(Name name, int i) {
        newPrereq(Record.newRecord(name, i, 255, 0L));
    }

    public void add(Record record) {
        newUpdate(record);
    }

    public void delete(Name name, int i, String str) {
        newUpdate(Record.fromString(name, i, 254, 0L, str, this.origin));
    }

    public void present(Name name, int i, String str) {
        newPrereq(Record.fromString(name, i, this.dclass, 0L, str, this.origin));
    }

    public void replace(Name name, int i, long j, Tokenizer tokenizer) {
        delete(name, i);
        add(name, i, j, tokenizer);
    }

    public void add(Record[] recordArr) {
        for (Record record : recordArr) {
            add(record);
        }
    }

    public void delete(Name name, int i, Tokenizer tokenizer) {
        newUpdate(Record.fromString(name, i, 254, 0L, tokenizer, this.origin));
    }

    public void present(Name name, int i, Tokenizer tokenizer) {
        newPrereq(Record.fromString(name, i, this.dclass, 0L, tokenizer, this.origin));
    }

    public void delete(Record record) {
        newUpdate(record.withDClass(254, 0L));
    }

    public void present(Record record) {
        newPrereq(record);
    }

    public void replace(Record record) {
        delete(record.getName(), record.getType());
        add(record);
    }

    public <T extends Record> void add(RRset rRset) {
        rRset.rrs().forEach(new C19356qC7(this));
    }

    public void delete(Record[] recordArr) {
        for (Record record : recordArr) {
            delete(record);
        }
    }

    public void replace(Record[] recordArr) {
        for (Record record : recordArr) {
            replace(record);
        }
    }

    public <T extends Record> void delete(RRset rRset) {
        rRset.rrs().forEach(new Consumer() { // from class: ir.nasim.rC7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.delete((Record) obj);
            }
        });
    }

    public <T extends Record> void replace(RRset rRset) {
        delete(rRset.getName(), rRset.getType());
        rRset.rrs().forEach(new C19356qC7(this));
    }

    public Update(Name name) {
        this(name, 1);
    }
}
