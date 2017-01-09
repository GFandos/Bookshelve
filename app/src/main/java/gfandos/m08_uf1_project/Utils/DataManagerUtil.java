package gfandos.m08_uf1_project.Utils;

/**
 * Created by Gerard on 08/01/2017.
 */

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

import java.util.ArrayList;

import gfandos.m08_uf1_project.Pojos.Book;
import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class DataManagerUtil {

    private static UriHelper URI_HELPER = UriHelper.with(ContentProviderUtil.AUTHORITY);
    private static Uri BOOK_URI = URI_HELPER.getUri(Book.class);

    public static void storeBook(Book book, Context context) {
        cupboard().withContext(context).put(BOOK_URI, Book.class, book);
    }

    static CursorLoader getCursorLoader(Context context) {
        return new CursorLoader(context, BOOK_URI, null, null, null, null);
    }

}
