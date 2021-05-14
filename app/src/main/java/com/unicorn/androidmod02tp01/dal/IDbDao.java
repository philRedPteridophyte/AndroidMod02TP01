package com.unicorn.androidmod02tp01.dal;

import android.content.Context;

import java.util.List;

public interface IDbDao<T> {

    T insert(Context _context, T _item);
    List<T> get(Context _context);
    T get(Context _context, T _item);
    void update(Context _context);
    void delete(Context _context);

}
