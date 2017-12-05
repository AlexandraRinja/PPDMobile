package com.example.alis.exemplu.model;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by Alis on 12/5/2017.
 */

public class TypeConv {
    @TypeConverter
    public static Type toType(String type){
        return Type.valueOf(type);
    }
    @TypeConverter
    public static String toString(Type type){
        return type.toString();
    }
}
