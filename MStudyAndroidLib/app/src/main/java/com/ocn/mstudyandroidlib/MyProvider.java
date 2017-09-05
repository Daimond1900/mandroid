package com.ocn.mstudyandroidlib;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by 1900 on 2017/9/5.
 */

public class MyProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;
    public static final int TABLE2_DIR = 2;
    public static final int TABLE1_ITEM = 1;
    public static final int TABLE2_ITEM = 3;

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.ocn.mstudyandroidlib.myprovider", "table1", TABLE1_DIR);
        uriMatcher.addURI("com.ocn.mstudyandroidlib.myprovider", "table1/#", TABLE1_ITEM);
        uriMatcher.addURI("com.ocn.mstudyandroidlib.myprovider", "table2/", TABLE2_DIR);
        uriMatcher.addURI("com.ocn.mstudyandroidlib.myprovider", "table2/#", TABLE2_ITEM);
    }

    /**
     * onCreate
     * 初始化内容提供器的时候调用
     * PS：只有存在ContentResolver尝试访问我们的应用程序数据的时候，才初始化
     * 通常在这里完成数据库的创建和升级等操作
     *
     * @return true 成功 false 失败
     */
    @Override
    public boolean onCreate() {
        return false;
    }

    /**
     * 从内容提供器中查询数据
     */
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                break;
            case TABLE1_ITEM:
                break;
            case TABLE2_DIR:
                break;
            case TABLE2_ITEM:
                break;
            default:
                break;
        }
        return null;
    }

    /**
     * 根据传入的uri返回相应的MIME类型
     * MIME类型 三部分组成：
     *  1.  必须以vnd开头
     *  2.  如果内容提供器以路径结尾，后面接.android.cursor.dir/
     *      如果以id结尾，后面接.android.cursor.item/
     *  3.  最后接上vnd.<authority><path>
     * @param uri
     * @return
     */
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.ocn.mstudyandroidlib.myprovider.table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.ocn.mstudyandroidlib.myprovider.table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.ocn.mstudyandroidlib.myprovider.table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.ocn.mstudyandroidlib.myprovider.table2";
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
