package com.example.apprealm.model;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.annotations.PrimaryKey;

public class Migration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        /* Version 0
            public class User extends RealmObject {
            @PrimaryKey
            private int id;
            private String nombre;
            private String año;
            }
        */

        /* Version 1
            public class User extends RealmObject {
            @PrimaryKey
            private int id;
            private String nombre;
            private String apellidos;
            private String edad;
            private String direccion;
            private int telefono;
            }
        */


        if(oldVersion == 0) {
            Log.d("Migration", "actualitzant a la versió 1");
            schema.get("User")
                    .addField("apellidos", String.class)
                    .addField("direccion", String.class)
                    .addField("telefono", int.class)
                    .addField("edad", String.class)
                    .removeField("año");
            oldVersion++;
        }
    }
}
